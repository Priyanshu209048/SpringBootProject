package com.jdbc.dao;

import com.jdbc.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImple implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDaoImple(){

    }

    //Create Table
    public int createTable(){
        String query = "CREATE TABLE IF NOT EXISTS User(id int primary key, name varchar(200), age int, city varchar(100))";
        int result = this.jdbcTemplate.update(query);
        return result;
    }

    //Insert User
    public int insertUser(User user){
        String query = "insert into user(id, name, age, city) values(?,?,?,?)";
        int update = this.jdbcTemplate.update(query, user.getId(), user.getName(), user.getAge(), user.getCity());
        return update;
    }

}
