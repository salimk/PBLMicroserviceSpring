package com.rdvmedical.serviceguser.service.impl;

import com.rdvmedical.serviceguser.domain.entity.Docteur;
import com.rdvmedical.serviceguser.respository.DocteurRepository;
import com.rdvmedical.serviceguser.service.IServiceDocteur;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceDocteurImpl implements IServiceDocteur {

    private final DocteurRepository docteurRepository;

    @Autowired
    public ServiceDocteurImpl(DocteurRepository docteurRepository) {
        this.docteurRepository = docteurRepository;
    }

    @Override
    public Docteur createDocteur(Docteur docteur) {
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
    public Docteur updateDocteur(Docteur docteur) {
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
        return docteurRepository.save(olddocteur);

    }
    @Override
    public void deleteDocteur(Long id) {
        if(docteurRepository.existsById(id)){
            docteurRepository.deleteById(id);
        }else throw new EntityNotFoundException("Docteur not fount"+id);

    }
}
