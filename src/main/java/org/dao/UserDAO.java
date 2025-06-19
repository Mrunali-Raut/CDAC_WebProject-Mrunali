package org.dao;

import org.model.pojo.User;

public interface UserDAO {
    boolean saveUser(User user);
    boolean loginUser(String username, String password);
}
