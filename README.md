# TP 4

<img width="717" height="343" alt="TP4-1" src="https://github.com/user-attachments/assets/58a43e8f-0941-42c8-9587-73b5c6b3b31c" />

## Explication des résultats

- Insertion d’une voiture : Hibernate exécute une requête SQL INSERT pour enregistrer une voiture dans la table Vehicule, avec ses attributs marque et nombrePortes.

- Insertion d’une moto : une deuxième requête INSERT permet d’enregistrer une moto dans la même table, avec ses attributs marque et sidecar.

- Gestion de l’héritage : les valeurs VOITURE et MOTO dans la colonne vehicule_type permettent de distinguer les deux types de véhicules.

- Attribution des identifiants : la voiture reçoit l’identifiant 1 et la moto l’identifiant 2.

- Confirmation de l’enregistrement : le message « Les deux véhicules ont été enregistrés » confirme que les deux objets ont été persistés dans la base de données.
