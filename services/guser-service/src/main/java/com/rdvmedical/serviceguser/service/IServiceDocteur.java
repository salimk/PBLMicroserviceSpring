package com.rdvmedical.serviceguser.service;

import com.rdvmedical.serviceguser.domain.entity.Docteur;

import java.util.List;
import java.util.Set;

public interface IServiceDocteur {

    Docteur createDocteur(Docteur docteur, Set<Long> roleIds);
    Docteur getDocteurById(Long id);
    List<Docteur> getAllDocteurs();
    Docteur updateDocteur(Docteur docteur, Set<Long> roleIds);
    void deleteDocteur(Long id);
}
