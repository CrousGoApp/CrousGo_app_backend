# CrousGO - Application de commande de repas

## Objectif
Le but de ce projet est de créer une application cross-plateforme pour commander des repas. L'application permet aux utilisateurs de parcourir une liste de plats, de les ajouter à un panier et de passer une commande.

## Technologies utilisées
**Backend:** Spring Boot avec une base de données H2 embarquée  
**Webservices:** RESTful APIs  
**Format de données:** JSON

## Fonctionnalités

### Fonctionnalités principales
**Liste des plats:** Affiche une liste de plats avec des images, des titres, des descriptions, des prix et des catégories.  
**Détails du plat:** Affiche des informations supplémentaires sur un plat sélectionné, y compris les allergènes.  
**Panier:** Permet aux utilisateurs de voir les plats sélectionnés, de modifier la quantité et de supprimer des plats du panier.  
**Validation de la commande:** Permet aux utilisateurs de renseigner une adresse de livraison et de valider la commande.  
**Écran de succès:** Confirme que la commande a été passée avec succès.

### Fonctionnalités Bonus

**Authentification des utilisateurs:** Écran de connexion au démarrage de l'application.  
**Profil utilisateur:** Affiche les informations de l'utilisateur et l'historique des commandes.

## Installation et Configuration

**1. Clonez le dépôt**
<pre>
git clone git@github.com:wardrockay/CrousGo_app_backend.git
</pre>

**2. Installer les dépendances**
<pre>
mvn clean install
</pre>

**3. Installation des données de test**  
Pour installer les données de test dans la base de données H2 embarquée, suivez les étapes ci-dessous :

Ouvrez le fichier `data.sql` situé dans le répertoire `src/main/resources`.

1. Accédez à la console H2 via votre navigateur web en allant à `http://localhost:8080/h2`  
2. Connectez-vous à la base de données en utilisant les informations de connexion appropriées.  
3. Ouvrez le fichier `data.sql` situé dans le répertoire `src/main/resources`.  
4. Copiez les requêtes SQL du fichier `data.sql`.  
5. Collez les requêtes SQL copiées dans la console H2.  
6. Appuyez sur le bouton "Run" pour initialiser les données de test dans la base de données.

Après avoir appuyé sur "Run", les données de test seront insérées dans la base de données H2.





## Auteurs

Téo VANDROEMME  
Louis MERCIER  
Etienne MAILLOT

## Liens utiles
