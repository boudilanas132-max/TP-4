package com.example.hibernate_inheritance;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.model.tableperclass.Livre;
import com.example.model.tableperclass.Electronique;

public class AppTablePerClass {

    public static void main(String[] args) {

        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("hibernate-inheritance");

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Création d'un livre
            Livre livre = new Livre("Java pour débutants", "Dupont");

            // Création d'un produit électronique
            Electronique ordinateur =
                new Electronique("Ordinateur portable", 24);

            // Enregistrement des deux produits
            em.persist(livre);
            em.persist(ordinateur);

            em.getTransaction().commit();

            System.out.println("Livre ID : " + livre.getId());
            System.out.println("Electronique ID : " + ordinateur.getId());
            System.out.println("Les produits ont été enregistrés.");

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
