package com.intellisoft.autopartsstore.api.service;



import com.intellisoft.autopartsstore.entity.User;
import com.intellisoft.autopartsstore.entity.UserRole;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Autoparts store project.
 * Author: Solovjev Sergey
 */
public interface IUserService {

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);

    public User getUserById(Integer id);

    public List<User> getAllUsers();

    public Boolean userIsRegistered(User user);

    public List<User> getUsersByRole(UserRole userRole);



}
