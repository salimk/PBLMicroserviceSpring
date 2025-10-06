package com.rdvmedical.serviceguser.domain.dto.user;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.rdvmedical.serviceguser.domain.entity.User}
 */
public class UserCreateUpdateDto implements Serializable {
    @NotBlank
    private final String email;
    @NotBlank
    @Size(min = 6, max = 20)
    private final String password;
    @Size(max = 50)
    @NotBlank
    private final String nom;
    @Size(max = 50)
    @NotBlank
    private final String prenom;
    @Pattern(regexp = "^[0-9 +()-]{6,20}$")
    private final String telephone;
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private final Set<Long> roleIds;

    public UserCreateUpdateDto(String email, String password, String nom, String prenom, String telephone, Set<Long> roleIds) {
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.roleIds = roleIds;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public Set<Long> getRoleIds() {
        return roleIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreateUpdateDto entity = (UserCreateUpdateDto) o;
        return Objects.equals(this.email, entity.email) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.prenom, entity.prenom) &&
                Objects.equals(this.telephone, entity.telephone) &&
                Objects.equals(this.roleIds, entity.roleIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, nom, prenom, telephone, roleIds);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "email = " + email + ", " +
                "password = " + password + ", " +
                "nom = " + nom + ", " +
                "prenom = " + prenom + ", " +
                "telephone = " + telephone + ", " +
                "roleIds = " + roleIds + ")";
    }
}