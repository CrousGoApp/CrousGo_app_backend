-- Insertion dans la table Allergen
INSERT INTO allergen (name) VALUES ('Gluten');
INSERT INTO allergen (name) VALUES ('Lactose');
INSERT INTO allergen (name) VALUES ('Peanuts');
INSERT INTO allergen (name) VALUES ('Tree nuts');
INSERT INTO allergen (name) VALUES ('Soy');
INSERT INTO allergen (name) VALUES ('Fish');
INSERT INTO allergen (name) VALUES ('Shellfish');
INSERT INTO allergen (name) VALUES ('Eggs');

-- Insertion dans la table Categorie
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
INSERT INTO classroom (name) VALUES ('Classroom A');
INSERT INTO classroom (name) VALUES ('Classroom B');
INSERT INTO classroom (name) VALUES ('Classroom C');
INSERT INTO classroom (name) VALUES ('Classroom D');
INSERT INTO classroom (name) VALUES ('Classroom E');
INSERT INTO classroom (name) VALUES ('Classroom F');

-- Insertion dans la table users
ALTER TABLE users ALTER COLUMN id INT AUTO_INCREMENT;
INSERT INTO users (firstname, lastname, login, password, wallet) VALUES ('John', 'Doe', 'login', 'password', 100);
INSERT INTO users (firstname, lastname, login, password, wallet) VALUES ('Jane', 'Doe', 'login', 'password', 100);
INSERT INTO users (firstname, lastname, login, password, wallet) VALUES ('Emily', 'Smith', 'login', 'password', 100);
INSERT INTO users (firstname, lastname, login, password, wallet) VALUES ('Michael', 'Johnson', 'login', 'password', 100);
INSERT INTO users (firstname, lastname, login, password, wallet) VALUES ('Sarah', 'Williams', 'login', 'password', 100);
INSERT INTO users (firstname, lastname, login, password, wallet) VALUES ('David', 'Brown', 'login', 'password', 100);
INSERT INTO users (firstname, lastname, login, password, wallet) VALUES ('Laura', 'Jones', 'login', 'password', 100);
INSERT INTO users (firstname, lastname, login, password, wallet) VALUES ('Robert', 'Garcia', 'login', 'password', 100);
INSERT INTO users (firstname, lastname, login, password, wallet) VALUES ('Maria', 'Martinez', 'login', 'password', 100);
INSERT INTO users (firstname, lastname, login, password, wallet) VALUES ('James', 'Anderson', 'login', 'password', 100);

-- Insertion dans la table Dish
INSERT INTO dish (name, description, picture, price) VALUES ('Salad', 'Fresh green salad', 'salad.jpg', 5);
SET @dishId = LAST_INSERT_ID();
INSERT INTO dish_allergen (dish_id, allergen_id) VALUES (@dishId, 1);
INSERT INTO dish_categorie (dish_id, categorie_id) VALUES (@dishId, 1);
INSERT INTO dish (name, description, picture, price) VALUES ('Burger', 'Juicy beef burger', 'burger.jpg', 5);
SET @dishId = LAST_INSERT_ID();
INSERT INTO dish_allergen (dish_id, allergen_id) VALUES (@dishId, 2);
INSERT INTO dish_categorie (dish_id, categorie_id) VALUES (@dishId, 2);
INSERT INTO dish (name, description, picture, price) VALUES ('Pasta', 'Pasta with tomato sauce', 'pasta.jpg', 5);
SET @dishId = LAST_INSERT_ID();
INSERT INTO dish_allergen (dish_id, allergen_id) VALUES (@dishId, 3);
INSERT INTO dish_categorie (dish_id, categorie_id) VALUES (@dishId, 3);
INSERT INTO dish (name, description, picture, price) VALUES ('Pizza', 'Pizza with cheese and tomato', 'pizza.jpg', 5);
SET @dishId = LAST_INSERT_ID();
INSERT INTO dish_allergen (dish_id, allergen_id) VALUES (@dishId, 4);
INSERT INTO dish_categorie (dish_id, categorie_id) VALUES (@dishId, 4);
INSERT INTO dish (name, description, picture, price) VALUES ('Rice', 'Rice with vegetables', 'rice.jpg', 5);
SET @dishId = LAST_INSERT_ID();
INSERT INTO dish_allergen (dish_id, allergen_id) VALUES (@dishId, 5);
INSERT INTO dish_categorie (dish_id, categorie_id) VALUES (@dishId, 5);
INSERT INTO dish (name, description, picture, price) VALUES ('Sandwich', 'Sandwich with ham and cheese', 'sandwich.jpg', 5);
SET @dishId = LAST_INSERT_ID();
INSERT INTO dish_allergen (dish_id, allergen_id) VALUES (@dishId, 6);
INSERT INTO dish_categorie (dish_id, categorie_id) VALUES (@dishId, 6);
INSERT INTO dish (name, description, picture, price) VALUES ('Soup', 'Soup with vegetables', 'soup.jpg', 5);
SET @dishId = LAST_INSERT_ID();
INSERT INTO dish_allergen (dish_id, allergen_id) VALUES (@dishId, 7);
INSERT INTO dish_categorie (dish_id, categorie_id) VALUES (@dishId, 7);
INSERT INTO dish (name, description, picture, price) VALUES ('Steak', 'Steak with fries', 'steak.jpg', 5);
SET @dishId = LAST_INSERT_ID();
INSERT INTO dish_allergen (dish_id, allergen_id) VALUES (@dishId, 8);
INSERT INTO dish_categorie (dish_id, categorie_id) VALUES (@dishId, 8);
INSERT INTO dish (name, description, picture, price) VALUES ('Sushi', 'Sushi with salmon', 'sushi.jpg', 5);
SET @dishId = LAST_INSERT_ID();
INSERT INTO dish_allergen (dish_id, allergen_id) VALUES (@dishId, 8);
INSERT INTO dish_categorie (dish_id, categorie_id) VALUES (@dishId, 9);

INSERT INTO dish_allergen (dish_id, allergen_id) VALUES (SELECT id FROM ALLERGEN WHERE name = 'Gluten', SELECT id FROM DISH WHERE name = 'Salad');