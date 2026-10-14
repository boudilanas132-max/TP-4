
package com.example.model.joined;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    // Constructeur vide obligatoire pour JPA
    public Employe() {
    }

    // Constructeur avec le nom
    public Employe(String nom) {
        this.nom = nom;
    }

    // Getter de l'identifiant
    public Long getId() {
        return id;
    }

    // Getter du nom
    public String getNom() {
        return nom;
    }

    // Setter du nom
    public void setNom(String nom) {
        this.nom = nom;
    }
}
