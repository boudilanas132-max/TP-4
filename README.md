# TP 4

<img width="717" height="343" alt="TP4-1" src="https://github.com/user-attachments/assets/58a43e8f-0941-42c8-9587-73b5c6b3b31c" />

## Explication des résultats

- Insertion d’une voiture : Hibernate exécute une requête SQL INSERT pour enregistrer une voiture dans la table Vehicule, avec ses attributs marque et nombrePortes.

- Insertion d’une moto : une deuxième requête INSERT permet d’enregistrer une moto dans la même table, avec ses attributs marque et sidecar.

- Gestion de l’héritage : les valeurs VOITURE et MOTO dans la colonne vehicule_type permettent de distinguer les deux types de véhicules.

- Attribution des identifiants : la voiture reçoit l’identifiant 1 et la moto l’identifiant 2.

- Confirmation de l’enregistrement : le message « Les deux véhicules ont été enregistrés » confirme que les deux objets ont été persistés dans la base de données.

<img width="719" height="322" alt="TP4-2" src="https://github.com/user-attachments/assets/f8af6411-42a1-4e2f-b3d6-145e37520092" />

## Explication des résultats

- Hibernate génère automatiquement les requêtes SQL pour enregistrer les données dans la base de données.

- La table Employe contient les informations communes, comme l’identifiant et le nom.

- La table Developpeur contient les informations spécifiques au développeur, notamment le langage de programmation.

- La table Manager contient les informations spécifiques au manager, notamment le nombre d’équipes gérées.

- La stratégie d’héritage JOINED permet de répartir les données entre la table mère Employe et les tables filles Developpeur et Manager.

- Le développeur a été enregistré avec l’identifiant 1.

- Le manager a été enregistré avec l’identifiant 2.

- Le message final confirme que les employés ont été enregistrés avec succès.

  <img width="938" height="428" alt="TP4-4" src="https://github.com/user-attachments/assets/ab5f5cdd-a63a-4da4-afbb-2ea2898e2427" />

  
