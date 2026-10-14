package com.example.hibernate_inheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.model.joined.Developpeur;
import com.example.model.joined.Manager;
import com.example.model.joined.Employe;

import com.example.model.singletable.Moto;
import com.example.model.singletable.Voiture;
import com.example.model.singletable.Vehicule;

import com.example.model.tableperclass.Electronique;
import com.example.model.tableperclass.Livre;
import com.example.model.tableperclass.Produit;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hibernate-inheritance");

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // 1. STRATEGIE SINGLE_TABLE
            Voiture voiture = new Voiture("Toyota", 4);
            Moto moto = new Moto("Harley", true);

            em.persist(voiture);
            em.persist(moto);

            // 2. STRATEGIE JOINED
            Developpeur dev = new Developpeur("Alice", "Java");
            Manager manager = new Manager("Bob", 3);

            em.persist(dev);
            em.persist(manager);

            // 3. STRATEGIE TABLE_PER_CLASS
            Livre livre = new Livre("Clean Code", "Robert C. Martin");
            Electronique electronique =
                    new Electronique("Smartphone", 24);

            em.persist(livre);
            em.persist(electronique);

            em.getTransaction().commit();

            // LECTURE DES VEHICULES
            System.out.println("--- Liste des véhicules ---");

            em.createQuery(
                    "SELECT v FROM Vehicule v", Vehicule.class)
                    .getResultList()
                    .forEach(v -> System.out.println(
                            v.getClass().getSimpleName()
                            + ": " + v.getMarque()));

            // LECTURE DES EMPLOYES
            System.out.println("--- Liste des employés ---");

            em.createQuery(
                    "SELECT e FROM Employe e", Employe.class)
                    .getResultList()
                    .forEach(e -> System.out.println(
                            e.getClass().getSimpleName()
                            + ": " + e.getNom()));

            // LECTURE DES PRODUITS
            System.out.println("--- Liste des produits ---");

            em.createQuery(
                    "SELECT p FROM Produit p", Produit.class)
                    .getResultList()
                    .forEach(p -> System.out.println(
                            p.getClass().getSimpleName()
                            + ": " + p.getNom()));

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
