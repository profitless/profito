package by.kanarski.profito.services.impl;

import by.kanarski.profito.services.interfaces.IBaseService;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public abstract class BaseService<D, E> implements IBaseService<D, E> {
    
//    @Autowired
//    protected ModelMapperWrapper modelMapper;
//
//    @Override
//    public void add(D dto) {
//        E entity = modelMapper.map(dto, getEntityClass());
//        getDao().add(entity);
//    }
//
//    @Override
//    public D getById(Long id) {
//        E entity = getDao().getById(id);
//        return modelMapper.map(entity, getDtoClass());
//    }
//
//    @Override
//    public void update(D dto) {
//        E entity = modelMapper.map(dto, getEntityClass());
//        getDao().update(entity);
//    }
//
//    @Override
//    public void delete(D dto) {
//        E entity = modelMapper.map(dto, getEntityClass());
//        getDao().delete(entity);
//    }
//
//    @Override
//    public void updateAllOf(Collection<D> dtoCollection) {
//        getDao().updateList(convertToEntityList(dtoCollection));
//    }
//
//    @Override
//    public void addAllOf(Collection<D> dtoCollection) {
//        getDao().addList(convertToEntityList(dtoCollection));
//    }
//
//    protected Class<E> getEntityClass() {
//        Type superclass = getClass().getGenericSuperclass();
//        Class<E> persistentClass = null;
//        if (!superclass.equals(Object.class)) {
//            ParameterizedType classType = (ParameterizedType) superclass;
//            persistentClass = (Class<E>) classType.getActualTypeArguments()[0];
//        }
//        return persistentClass;
//    }
//
//    protected Class<D> getDtoClass() {
//        Type superclass = getClass().getGenericSuperclass();
//        Class<D> persistentClass = null;
//        if (!superclass.equals(Object.class)) {
//            ParameterizedType classType = (ParameterizedType) superclass;
//            persistentClass = (Class<D>) classType.getActualTypeArguments()[1];
//        }
//        return persistentClass;
//    }
//
//    private List<E> convertToEntityList(Collection<D> dtoCollection) {
//        List<E> entityList = null;
//        if (dtoCollection instanceof Set) {
//
//            entityList = modelMapper.convertSetToList((Set<D>) dtoCollection, getEntityClass());
//        }
//        if (dtoCollection instanceof List) {
//            entityList = modelMapper.map((List<D>) dtoCollection, getEntityClass());
//        }
//        return entityList;
//    }
//
//    protected abstract IExtendedBaseDao<E> getDao();

}
