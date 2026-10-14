package com.example.hibernate_inheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.model.singletable.Voiture;
import com.example.model.singletable.Moto;

public class AppSingleTable {

    public static void main(String[] args) {

        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("hibernate-inheritance");

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Voiture voiture = new Voiture("Toyota", 5);
            Moto moto = new Moto("Yamaha", true);

            em.persist(voiture);
            em.persist(moto);

            em.getTransaction().commit();

            System.out.println("Voiture ID : " + voiture.getId());
            System.out.println("Moto ID : " + moto.getId());
            System.out.println("Les deux véhicules ont été enregistrés.");

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
