package com.example.model.joined;

import javax.persistence.Entity;

@Entity
public class Developpeur extends Employe {

    // Attribut spécifique au développeur
    private String langage;

    public Developpeur() {
    }

    public Developpeur(String nom, String langage) {
        super(nom);
        this.langage = langage;
    }

    public String getLangage() {
        return langage;
    }

    public void setLangage(String langage) {
        this.langage = langage;
    }
}
