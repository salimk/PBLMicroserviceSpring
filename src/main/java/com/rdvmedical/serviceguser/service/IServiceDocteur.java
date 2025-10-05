package com.rdvmedical.serviceguser.service;

import com.rdvmedical.serviceguser.domain.entity.Docteur;

import java.util.List;

public interface IServiceDocteur {
    Docteur createDocteur(Docteur docteur);
    Docteur getDocteurById(Long id);
    List<Docteur> getAllDocteurs();
    Docteur updateDocteur(Docteur docteur);
    void deleteDocteur(Long id);
}
