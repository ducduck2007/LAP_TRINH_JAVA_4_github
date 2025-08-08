package org.example.lab6.dao;

import org.example.lab6.model.User;

public interface UserDAO {
    void create(User user);
    void update(User user);
    User findByUsername(String username);
}
