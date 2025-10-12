package com.rdvmedical.serviceguser.service;

import com.rdvmedical.serviceguser.domain.entity.Patient;

import java.util.List;
import java.util.Set;

public interface IServicePatient {
    Patient createPatient(Patient patient, Set<Long> roleIds);
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
    Patient updatePatient(Patient patient, Set<Long> roleIds);
    void deletePatient(Long id);
}
