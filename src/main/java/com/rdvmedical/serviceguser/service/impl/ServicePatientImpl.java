package com.rdvmedical.serviceguser.service.impl;

import com.rdvmedical.serviceguser.domain.entity.Patient;
import com.rdvmedical.serviceguser.respository.PatientRepository;
import com.rdvmedical.serviceguser.service.IServicePatient;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServicePatientImpl implements IServicePatient {

    private final PatientRepository patientRepository;

    @Autowired
    public ServicePatientImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient createPatient(Patient patient) {
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
    public Patient updatePatient(Patient patient) {
        if(patientRepository.existsById(patient.getId())){
            Patient oldpatient=patientRepository.findById(patient.getId()).get();
            oldpatient.setNumeroSecuriteSocial(patient.getNumeroSecuriteSocial());
            oldpatient.setDateNaissance(patient.getDateNaissance());
            oldpatient.setSexe(patient.getSexe());
            // hérités de User si nécessaire :
            oldpatient.setEmail(patient.getEmail());
            oldpatient.setPassword(patient.getPassword());
            oldpatient.setNom(patient.getNom());
            oldpatient.setPrenom(patient.getPrenom());
            oldpatient.setTelephone(patient.getTelephone());
            return patientRepository.save(oldpatient);
        }else throw new EntityNotFoundException("Patient not fount"+patient.getId());

    }
    @Override
    public void deletePatient(Long id) {
        if(patientRepository.existsById(id)){
            patientRepository.deleteById(id);
        }else throw new EntityNotFoundException("Patient not fount"+id);

    }
}
