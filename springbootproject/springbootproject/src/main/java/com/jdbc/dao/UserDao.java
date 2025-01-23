package com.jdbc.dao;

import com.jdbc.Entity.User;

public interface UserDao {

    public int createTable();
    public int insertUser(User user);

}
