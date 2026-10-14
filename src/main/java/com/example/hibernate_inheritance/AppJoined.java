package com.example.hibernate_inheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.model.joined.Developpeur;
import com.example.model.joined.Manager;

public class AppJoined {

    public static void main(String[] args) {

        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("hibernate-inheritance");

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Création d'un développeur
            Developpeur dev =
                new Developpeur("Anas", "Java");

            // Création d'un manager
            Manager manager =
                new Manager("Youssef", 3);

            // Enregistrement des employés
            em.persist(dev);
            em.persist(manager);

            em.getTransaction().commit();

            System.out.println("Développeur ID : " + dev.getId());
            System.out.println("Manager ID : " + manager.getId());
            System.out.println("Les employés ont été enregistrés.");

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
