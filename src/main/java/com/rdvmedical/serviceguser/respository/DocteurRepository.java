package com.rdvmedical.serviceguser.respository;

import com.rdvmedical.serviceguser.domain.entity.Docteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocteurRepository extends JpaRepository<Docteur, Long> {
    Optional<Docteur> findByInpe(String inpe);
    List<Docteur> findBySpecialiteContainingIgnoreCase(String Specialite);
}