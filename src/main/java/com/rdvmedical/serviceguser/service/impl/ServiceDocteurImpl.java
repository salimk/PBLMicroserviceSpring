package com.rdvmedical.serviceguser.service.impl;

import com.rdvmedical.serviceguser.domain.entity.Docteur;
import com.rdvmedical.serviceguser.domain.entity.Role;
import com.rdvmedical.serviceguser.respository.DocteurRepository;
import com.rdvmedical.serviceguser.respository.RoleRepository;
import com.rdvmedical.serviceguser.service.IServiceDocteur;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class ServiceDocteurImpl implements IServiceDocteur {

    private final DocteurRepository docteurRepository;
    private final RoleRepository roleRepository;


    @Autowired
    public ServiceDocteurImpl(DocteurRepository docteurRepository, RoleRepository roleRepository) {
        this.docteurRepository = docteurRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Docteur createDocteur(Docteur docteur, Set<Long> roleIds) {
        attachRoles(docteur, roleIds);
        return docteurRepository.save(docteur);
    }

    @Override
    @Transactional(readOnly = true)
    public Docteur getDocteurById(Long id) {
        return docteurRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Docteur not found"+id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Docteur> getAllDocteurs() {
        return docteurRepository.findAll();
    }

    @Override
    public Docteur updateDocteur(Docteur docteur, Set<Long> roleIds) {
        Docteur olddocteur = docteurRepository.findById(docteur.getId())
                .orElseThrow(() -> new EntityNotFoundException("Docteur not found: " + docteur.getId()));
        olddocteur.setSpecialite(docteur.getSpecialite());
        olddocteur.setInpe(docteur.getInpe());
        // hérités de User si tu veux les exposer ici :
        olddocteur.setEmail(docteur.getEmail());
        olddocteur.setPassword(docteur.getPassword());
        olddocteur.setNom(docteur.getNom());
        olddocteur.setPrenom(docteur.getPrenom());
        olddocteur.setTelephone(docteur.getTelephone());
        attachRoles(olddocteur, roleIds);

        return docteurRepository.save(olddocteur);

    }
    @Override
    public void deleteDocteur(Long id) {
        if(docteurRepository.existsById(id)){
            docteurRepository.deleteById(id);
        }else throw new EntityNotFoundException("Docteur not fount"+id);

    }

    private void attachRoles(Docteur docteur, Set<Long> roleIds) {
        if (roleIds == null || roleIds.isEmpty()) {
            docteur.setRoles(new HashSet<>());
            return;
        }
        Set<Role> roles = roleIds.stream()
                .map(rid -> roleRepository.findById(rid)
                        .orElseThrow(() -> new EntityNotFoundException("Role not found: " + rid)))
                .collect(Collectors.toSet());
        docteur.setRoles(roles);
    }
}
