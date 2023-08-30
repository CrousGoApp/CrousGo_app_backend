-- Insertion dans la table Allergen
ALTER TABLE allergen ALTER COLUMN id INT AUTO_INCREMENT;
INSERT INTO allergen (name) VALUES ('Gluten');
INSERT INTO allergen (name) VALUES ('Lactose');
INSERT INTO allergen (name) VALUES ('Peanuts');
INSERT INTO allergen (name) VALUES ('Tree nuts');
INSERT INTO allergen (name) VALUES ('Soy');
INSERT INTO allergen (name) VALUES ('Fish');
INSERT INTO allergen (name) VALUES ('Shellfish');
INSERT INTO allergen (name) VALUES ('Eggs');

-- Insertion dans la table Categorie
ALTER TABLE categorie ALTER COLUMN id INT AUTO_INCREMENT;
INSERT INTO categorie (name) VALUES ('Vegan');
INSERT INTO categorie (name) VALUES ('Vegetarian');
INSERT INTO categorie (name) VALUES ('Meat');
INSERT INTO categorie (name) VALUES ('Fish');
INSERT INTO categorie (name) VALUES ('Pasta');
INSERT INTO categorie (name) VALUES ('Rice');
INSERT INTO categorie (name) VALUES ('Salad');
INSERT INTO categorie (name) VALUES ('Sandwich');
INSERT INTO categorie (name) VALUES ('Soup');
INSERT INTO categorie (name) VALUES ('Burger');

-- Insertion dans la table Classroom
ALTER TABLE classroom ALTER COLUMN id INT AUTO_INCREMENT;
INSERT INTO classroom (name) VALUES ('Classroom A');
INSERT INTO classroom (name) VALUES ('Classroom B');
INSERT INTO classroom (name) VALUES ('Classroom C');
INSERT INTO classroom (name) VALUES ('Classroom D');
INSERT INTO classroom (name) VALUES ('Classroom E');
INSERT INTO classroom (name) VALUES ('Classroom F');

-- Insertion dans la table User
ALTER TABLE user ALTER COLUMN id INT AUTO_INCREMENT;
INSERT INTO user (firstname, lastname) VALUES ('John', 'Doe');
INSERT INTO user (firstname, lastname) VALUES ('Jane', 'Doe');
INSERT INTO user (firstname, lastname) VALUES ('Emily', 'Smith');
INSERT INTO user (firstname, lastname) VALUES ('Michael', 'Johnson');
INSERT INTO user (firstname, lastname) VALUES ('Sarah', 'Williams');
INSERT INTO user (firstname, lastname) VALUES ('David', 'Brown');
INSERT INTO user (firstname, lastname) VALUES ('Laura', 'Jones');
INSERT INTO user (firstname, lastname) VALUES ('Robert', 'Garcia');
INSERT INTO user (firstname, lastname) VALUES ('Maria', 'Martinez');
INSERT INTO user (firstname, lastname) VALUES ('James', 'Anderson');

-- Insertion dans la table Dish
ALTER TABLE dish ALTER COLUMN id INT AUTO_INCREMENT;
INSERT INTO dish (name, description, picture) VALUES ('Salad', 'Fresh green salad', 'salad.jpg');
INSERT INTO dish (name, description, picture) VALUES ('Burger', 'Juicy beef burger', 'burger.jpg');
INSERT INTO dish (name, description, picture) VALUES ('Pasta', 'Pasta with tomato sauce', 'pasta.jpg');
INSERT INTO dish (name, description, picture) VALUES ('Pizza', 'Pizza with cheese and tomato', 'pizza.jpg');
INSERT INTO dish (name, description, picture) VALUES ('Rice', 'Rice with vegetables', 'rice.jpg');
INSERT INTO dish (name, description, picture) VALUES ('Sandwich', 'Sandwich with ham and cheese', 'sandwich.jpg');
INSERT INTO dish (name, description, picture) VALUES ('Soup', 'Soup with vegetables', 'soup.jpg');
INSERT INTO dish (name, description, picture) VALUES ('Steak', 'Steak with fries', 'steak.jpg');
INSERT INTO dish (name, description, picture) VALUES ('Sushi', 'Sushi with salmon', 'sushi.jpg');