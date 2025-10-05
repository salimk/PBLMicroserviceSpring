package com.rdvmedical.serviceguser.service.impl;

import com.rdvmedical.serviceguser.domain.entity.Role;
import com.rdvmedical.serviceguser.respository.RoleRepository;
import com.rdvmedical.serviceguser.service.IServiceRole;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ServiceRoleImpl implements IServiceRole {

    private final RoleRepository roleRepository;

    @Autowired
    public ServiceRoleImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    @Transactional(readOnly = true)
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Role not found"+id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role updateRole(Role role) {
        if(roleRepository.existsById(role.getId())){
            Role oldrole=roleRepository.findById(role.getId()).get();
            oldrole.setNom(role.getNom());
            return roleRepository.save(oldrole);
        }else throw new EntityNotFoundException("Role not fount"+role.getId());

    }
    @Override
    public void deleteRole(Long id) {
        if(roleRepository.existsById(id)){
            roleRepository.deleteById(id);
        }else throw new EntityNotFoundException("Role not fount"+id);

    }
}
