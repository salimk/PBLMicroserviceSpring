package com.rdvmedical.serviceguser.service.impl;

import com.rdvmedical.serviceguser.domain.entity.Docteur;
import com.rdvmedical.serviceguser.domain.entity.Patient;
import com.rdvmedical.serviceguser.domain.entity.Role;
import com.rdvmedical.serviceguser.domain.entity.User;
import com.rdvmedical.serviceguser.respository.PatientRepository;
import com.rdvmedical.serviceguser.respository.RoleRepository;
import com.rdvmedical.serviceguser.service.IServicePatient;
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
public class ServicePatientImpl implements IServicePatient {

    private final PatientRepository patientRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public ServicePatientImpl(PatientRepository patientRepository, RoleRepository roleRepository) {
        this.patientRepository = patientRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Patient createPatient(Patient patient, Set<Long> roleIds) {
        attachRoles(patient, roleIds);
        return patientRepository.save(patient);
    }

    @Override
    @Transactional(readOnly = true)
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Patient not found"+id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient updatePatient(Patient patient, Set<Long> roleIds) {
        Patient oldpatient = patientRepository.findById(patient.getId())
                .orElseThrow(() -> new EntityNotFoundException("Patient not found: " + patient.getId()));
            oldpatient.setNumeroSecuriteSocial(patient.getNumeroSecuriteSocial());
            oldpatient.setDateNaissance(patient.getDateNaissance());
            oldpatient.setSexe(patient.getSexe());
            // hérités de User si nécessaire :
            oldpatient.setEmail(patient.getEmail());
            oldpatient.setPassword(patient.getPassword());
            oldpatient.setNom(patient.getNom());
            oldpatient.setPrenom(patient.getPrenom());
            oldpatient.setTelephone(patient.getTelephone());
            attachRoles(oldpatient, roleIds);
            return patientRepository.save(oldpatient);
    }
    @Override
    public void deletePatient(Long id) {
        if(patientRepository.existsById(id)){
            patientRepository.deleteById(id);
        }else throw new EntityNotFoundException("Patient not fount"+id);

    }
    private void attachRoles(User user, Set<Long> roleIds) {
        if (roleIds == null || roleIds.isEmpty()) {
            user.setRoles(new HashSet<>());
            return;
        }
        Set<Role> roles = roleIds.stream()
                .map(rid -> roleRepository.findById(rid)
                        .orElseThrow(() -> new EntityNotFoundException("Role not found: " + rid)))
                .collect(Collectors.toSet());
        user.setRoles(roles);
    }
}
