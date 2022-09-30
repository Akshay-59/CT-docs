package com.shopping.service;

import com.shopping.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void saveUser(com.shopping.model.User user);

    void updateUser(User user);

    User getUserById(int id);

    User getUserByUsername(String username);

    List<User> getAllUserByRole(String role);

    boolean validateUser(User user);

    void deleteUserById(int id);
}
