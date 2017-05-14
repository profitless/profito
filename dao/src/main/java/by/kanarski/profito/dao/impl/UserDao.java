package by.kanarski.profito.dao.impl;

import by.kanarski.profito.dao.interfaces.registry.IUserDao;
import by.kanarski.profito.entities.registry.User;
import org.springframework.stereotype.Repository;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 * @see IUserDao
 */

@Repository
public class UserDao extends ExtendedBaseDao<User> implements IUserDao {



}
