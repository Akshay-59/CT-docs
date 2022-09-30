package com.shopping.service.Impl;

import com.shopping.mapper.UserMapper;
import com.shopping.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.shopping.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void saveUser(User user) {
        User dbUser = getUserByUsername(user.getUsername());
        if (dbUser == null) {
            try {
                int rows = this.jdbcTemplate.update("insert into user_tbl values (?,?,?)", user.getUsername(), user.getPassword(), user.getRole());
                System.out.println("Customer Created Successfully");

            } catch (EmptyResultDataAccessException e) {
                System.out.println("An error occurred while saving customer");

            }
        }
    }


    public void updateUser(User user) {
        User dbUser = getUserById(user.getId());
        if (dbUser != null) {
            int rows = this.jdbcTemplate.update("update user_tbl set username = ?, password = ? where id = ?", user.getUsername(), user.getPassword(), user.getId());


            if (rows != 0) {
                System.out.println("Customer Updated Successfully");
            } else {
                System.out.println("An error occurred while updating customer");
            }
        }
    }


    public User getUserById(int id) {
        try {
            User user = this.jdbcTemplate.queryForObject("select * from user_tbl where id=? and role = 'customer' ", new UserMapper(), id);
            return user;
        } catch (EmptyResultDataAccessException e) {
            System.out.println("No user with id " + id + " exists");
            return null;
        }
    }

    public User getUserByUsername(String username) {
        try {
            User user = this.jdbcTemplate.queryForObject("select * from user_tbl where username=?", new UserMapper(), username);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    public List<User> getAllUserByRole(String role) {
        try {
            List<User> users = this.jdbcTemplate.query("select * from user_tbl where role = ?", new UserMapper(), role);
            return users;
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Unable to fetch users");
            return new ArrayList<>();

        }
    }


    public boolean validateUser(User user) {
        boolean isValid;
        try {
            this.jdbcTemplate.queryForObject("select * from user_tbl where  username=? and password=? ", new UserMapper(), user.getUsername(), user.getPassword());
            isValid = true;
        } catch (EmptyResultDataAccessException e) {
            isValid = false;
        }
        return isValid;
    }

    public void deleteUserById(int id) {
        User user = getUserById(id);
        if (user != null) {
            try {
                int row = this.jdbcTemplate.update("delete from user_tbl where id = ? and role = 'customer' ", id);
                System.out.println("User Deleted Successfully");
            } catch (EmptyResultDataAccessException e) {
                System.out.println("An error occurred while deleting record");

            }
        }
    }

}
