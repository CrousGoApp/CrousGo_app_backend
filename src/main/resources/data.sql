-- Affiche les plats et leurs jointure
SELECT 
    d.id, 
    d.name, 
    d.description, 
    d.picture, 
    d.price,
    GROUP_CONCAT(DISTINCT a.name) AS allergens,
    GROUP_CONCAT(DISTINCT c.name) AS categories
FROM Dish d
LEFT JOIN dish_allergen da ON d.id = da.dish_id
LEFT JOIN Allergen a ON da.allergen_id = a.id
LEFT JOIN dish_categorie dc ON d.id = dc.dish_id
LEFT JOIN Categorie c ON dc.categorie_id = c.id
GROUP BY d.id, d.name, d.description, d.picture, d.price;

-- Affiche les commandes et les jointure
SELECT o.id AS order_id, o.user_email, d.id AS dish_id, d.name AS dish_name, c.id AS classroom_id, c.name AS classroom_name
FROM Orders o
LEFT JOIN order_dish od ON o.id = od.order_id
LEFT JOIN Dish d ON od.dish_id = d.id
LEFT JOIN order_classroom oc ON o.id = oc.order_id
LEFT JOIN Classroom c ON oc.classroom_id = c.id;