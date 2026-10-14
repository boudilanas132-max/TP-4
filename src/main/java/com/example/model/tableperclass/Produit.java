package com.example.model.tableperclass;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    // Constructeur vide obligatoire pour JPA
    public Produit() {
    }

    // Constructeur avec le nom du produit
    public Produit(String nom) {
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
