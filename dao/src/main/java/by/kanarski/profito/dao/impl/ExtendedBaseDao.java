package by.kanarski.profito.dao.impl;

import by.kanarski.profito.dao.interfaces.IExtendedBaseDao;
import by.kanarski.profito.utils.CriteriaBuilder;
import by.kanarski.profito.utils.criteria.SearchFilter;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Repository
public abstract class ExtendedBaseDao<T> extends BaseDao<T> implements IExtendedBaseDao<T> {

    private static final int BATCH_SIZE = 20;

    private CriteriaBuilder criteriaBuilder;

//    @Autowired
//    public ExtendedBaseDao(SessionFactory sessionFactory) {
//        super(sessionFactory);
//    }

    @Override
    public void updateList(List<T> entityList) {
        Session session = getSession();
        for (int i = 0; i < entityList.size(); i++) {
            T t = entityList.get(i);
            update(t);
            checkBatch(session, i);
        }
    }

    @Override
    public void addList(List<T> entityList) {
        Session session = getSession();
        for (int i = 0; i < entityList.size(); i++) {
            T t = entityList.get(i);
            add(t);
            checkBatch(session, i);
        }
    }

    /**
     * Recives all entities from table. Not recommended for use
     *
     * @return all entities
     */
    @Override
    public List<T> getAll() {
        Criteria criteria = getSession().createCriteria(getEntityClass());
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getUniqueByFilter(SearchFilter searchFilter) {
        Criteria criteria = criteriaBuilder.createCriteria(searchFilter, getEntityClass());
        Object result = criteria.uniqueResult();
        if (getEntityClass().isInstance(result)) {
            return (T) result;
        } else {
            throw new ClassCastException();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getListByFilter(SearchFilter searchFilter) {
        Criteria criteria = criteriaBuilder.createCriteria(searchFilter, getEntityClass());
        List resultList = criteria.list();
        if (CollectionUtils.isNotEmpty(resultList)) {
            if (getEntityClass().isInstance(resultList.get(0))) {
                return (List<T>) resultList;
            } else {
                throw new ClassCastException();
            }
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getBy(String propertyName, Object value) {
        Criteria criteria = getSession().createCriteria(getEntityClass());
        return (T) criteria.add(Restrictions.eq(propertyName, value)).uniqueResult();
    }

    @Autowired
    public void setCriteriaBuilder(CriteriaBuilder criteriaBuilder) {
        this.criteriaBuilder = criteriaBuilder;
    }

    private void checkBatch(Session session, int batchSize) {
        if ((batchSize + 1) % BATCH_SIZE == 0) {
            session.flush();
            session.clear();
        }
    }
}
