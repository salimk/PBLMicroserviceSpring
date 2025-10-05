package com.rdvmedical.serviceguser.service;

import com.rdvmedical.serviceguser.domain.entity.Patient;

import java.util.List;

public interface IServicePatient {
    Patient createPatient(Patient patient);
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
    Patient updatePatient(Patient patient);
    void deletePatient(Long id);
}
