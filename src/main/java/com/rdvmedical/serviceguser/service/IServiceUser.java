package com.rdvmedical.serviceguser.service;

import com.rdvmedical.serviceguser.domain.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IServiceUser {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long id);
    User findByEmail(String email);
    User addRole(Long userId, Long roleId);
    User removeRole(Long userId, Long roleId);
}
