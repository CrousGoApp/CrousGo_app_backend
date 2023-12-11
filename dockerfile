# Utiliser une image de base Java (JDK)
FROM openjdk:11-jdk

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR de votre application dans le conteneur
COPY ./target/mon-application.jar /app/mon-application.jar

# Exposer le port sur lequel votre application s'exécute
EXPOSE 8080

# Commande pour exécuter l'application
CMD ["java", "-jar", "/app/mon-application.jar"]
