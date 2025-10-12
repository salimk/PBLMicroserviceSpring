package com.rdvmedical.serviceguser.service;

import com.rdvmedical.serviceguser.domain.entity.Role;

import java.util.List;
import java.util.Optional;

public interface IServiceRole {
    Role createRole(Role role);
    Role getRoleById(Long id);
    List<Role> getAllRoles();
    Role updateRole(Role role);
    void deleteRole(Long id);
}
