package com.imt.fw.crousgo_app_backend;

import com.imt.fw.crousgo_app_backend.entities.*;
import com.imt.fw.crousgo_app_backend.repositories.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CrousGoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrousGoApplication.class, args);
		System.out.println("CrousGo Application Started");
	}

	@Bean
	public ApplicationRunner initAllergens(AllergenRepository allergenRepository) {
		return args -> {
			List<String> allergenNames = Arrays.asList(
					"Gluten", "Lactose", "Peanuts", "Tree nuts",
					"Soy", "Fish", "Shellfish", "Eggs"
			);

			for (String allergenName : allergenNames) {
				Allergen allergen = new Allergen();
				allergen.setName(allergenName);
				allergenRepository.save(allergen);
			}
		};
	}

	@Bean
	public ApplicationRunner initCategories(CategorieRepository categorieRepository) {
		return args -> {
			List<String> categoriesNames = Arrays.asList(
					"Vegan", "Vegetarian", "Meat", "Fish",
					"Pasta", "Rice", "Salad", "Sandwich", "Soup", "Burger"
			);

			for (String categoriesName : categoriesNames) {
				Categorie categorie = new Categorie();
				categorie.setName(categoriesName);
				categorieRepository.save(categorie);
			}
		};
	}

	@Bean
	public ApplicationRunner initClassrooms(ClassroomRepository classroomRepository) {
		return args -> {
			List<String> classroomsNames = Arrays.asList(
					"Classroom A", "Classroom B", "Classroom C", "Classroom D",
					"Classroom E", "Classroom F"
			);

			for (String classroomsName : classroomsNames) {
				Classroom classroom = new Classroom();
				classroom.setName(classroomsName);
				classroomRepository.save(classroom);
			}
		};
	}

	@Bean
	public ApplicationRunner initUsers(UserRepository userRepository) {
		return args -> {
			Users user1 = new Users();
			user1.setFirstname("John");
			user1.setLastname("Doe");
			user1.setLogin("login");
			user1.setPassword("password");
			user1.setWallet(100);
			userRepository.save(user1);

			Users user2 = new Users();
			user2.setFirstname("Jane");
			user2.setLastname("Doe");
			user2.setLogin("login");
			user2.setPassword("password");
			user2.setWallet(100);
			userRepository.save(user2);

			Users user3 = new Users();
			user3.setFirstname("Emily");
			user3.setLastname("Smith");
			user3.setLogin("login");
			user3.setPassword("password");
			user3.setWallet(100);
			userRepository.save(user3);

			Users user4 = new Users();
			user4.setFirstname("Michael");
			user4.setLastname("Johnson");
			user4.setLogin("login");
			user4.setPassword("password");
			user4.setWallet(100);
			userRepository.save(user4);

			Users user5 = new Users();
			user5.setFirstname("Sarah");
			user5.setLastname("Williams");
			user5.setLogin("login");
			user5.setPassword("password");
			user5.setWallet(100);
			userRepository.save(user5);
		};
	}

	@Bean
	public ApplicationRunner initDish(DishRepository dishRepository, AllergenRepository allergenRepository, CategorieRepository categorieRepository) {
		return args -> {
			Dish dish1 = new Dish();
			dish1.setName("Salad");
			dish1.setDescription("Fresh green salad");
			dish1.setPicture("salad.jpg");
			dish1.setPrice(5);
			List<Allergen> allergens1 = new ArrayList<>();
			allergens1.add(allergenRepository.findByName("Gluten")); // Fetch allergen by name from repository
			allergens1.add(allergenRepository.findByName("Peanuts"));
			dish1.setAllergens(allergens1);
			List<Categorie> categories1 = new ArrayList<>();
			categories1.add(categorieRepository.findByName("Vegan")); // Fetch category by name from repository
			categories1.add(categorieRepository.findByName("Salad"));
			dish1.setCategorie(categories1);
			dishRepository.save(dish1);

			Dish dish2 = new Dish();
			dish2.setName("Burger");
			dish2.setDescription("Juicy beef burger");
			dish2.setPicture("burger.jpg");
			dish2.setPrice(5);
			List<Allergen> allergens2 = new ArrayList<>();
			allergens2.add(allergenRepository.findByName("Gluten")); // Fetch allergen by name from repository
			dish2.setAllergens(allergens2);
			List<Categorie> categories2 = new ArrayList<>();
			categories2.add(categorieRepository.findByName("Meat")); // Fetch category by name from repository
			categories2.add(categorieRepository.findByName("Burger"));
			dish2.setCategorie(categories2);
			dishRepository.save(dish2);

			Dish dish3 = new Dish();
			dish3.setName("Pasta");
			dish3.setDescription("Pasta with tomato sauce");
			dish3.setPicture("pasta.jpg");
			dish3.setPrice(5);
			List<Allergen> allergens3 = new ArrayList<>();
			allergens3.add(allergenRepository.findByName("Gluten")); // Fetch allergen by name from repository
			allergens3.add(allergenRepository.findByName("Eggs"));
			dish3.setAllergens(allergens3);
			List<Categorie> categories3 = new ArrayList<>();
			categories3.add(categorieRepository.findByName("Pasta")); // Fetch category by name from repository
			categories3.add(categorieRepository.findByName("Vegetarian"));
			dish3.setCategorie(categories3);
			dishRepository.save(dish3);

			Dish dish4 = new Dish();
			dish4.setName("Pizza");
			dish4.setDescription("Pizza with cheese and tomato");
			dish4.setPicture("pizza.jpg");
			dish4.setPrice(5);
			List<Allergen> allergens4 = new ArrayList<>();
			allergens4.add(allergenRepository.findByName("Gluten")); // Fetch allergen by name from repository
			allergens4.add(allergenRepository.findByName("Eggs"));
			allergens4.add(allergenRepository.findByName("Lactose"));
			dish4.setAllergens(allergens4);
			List<Categorie> categories4 = new ArrayList<>();// Fetch category by name from repository
			categories4.add(categorieRepository.findByName("Vegetarian"));
			dish4.setCategorie(categories4);
			dishRepository.save(dish4);

			Dish dish5 = new Dish();
			dish5.setName("Rice");
			dish5.setDescription("Rice with vegetables");
			dish5.setPicture("rice.jpg");
			dish5.setPrice(5);
			List<Allergen> allergens5 = new ArrayList<>();
			allergens5.add(allergenRepository.findByName("Gluten")); // Fetch allergen by name from repository
			dish5.setAllergens(allergens5);
			List<Categorie> categories5 = new ArrayList<>();// Fetch category by name from repository
			categories5.add(categorieRepository.findByName("Vegan"));
			categories5.add(categorieRepository.findByName("Rice"));
			dish5.setCategorie(categories5);
			dishRepository.save(dish5);

			Dish dish6 = new Dish();
			dish6.setName("Sandwich");
			dish6.setDescription("Sandwich with ham and cheese");
			dish6.setPicture("sandwich.jpg");
			dish6.setPrice(6);
			List<Allergen> allergens6 = new ArrayList<>();
			allergens6.add(allergenRepository.findByName("Gluten")); // Fetch allergen by name from repository
			allergens6.add(allergenRepository.findByName("Lactose"));
			dish6.setAllergens(allergens6);
			List<Categorie> categories6 = new ArrayList<>();// Fetch category by name from repository
			categories6.add(categorieRepository.findByName("Meat"));
			categories6.add(categorieRepository.findByName("Sandwich"));
			dish6.setCategorie(categories6);
			dishRepository.save(dish6);

			Dish dish7 = new Dish();
			dish7.setName("Soup");
			dish7.setDescription("Soup with vegetables");
			dish7.setPicture("soup.jpg");
			dish7.setPrice(7);
			List<Allergen> allergens7 = new ArrayList<>();
			allergens7.add(allergenRepository.findByName("Gluten")); // Fetch allergen by name from repository
			dish7.setAllergens(allergens7);
			List<Categorie> categories7 = new ArrayList<>();// Fetch category by name from repository
			categories7.add(categorieRepository.findByName("Vegan"));
			categories7.add(categorieRepository.findByName("Soup"));
			dish7.setCategorie(categories7);
			dishRepository.save(dish7);

			Dish dish8 = new Dish();
			dish8.setName("Steak");
			dish8.setDescription("Steak with fries");
			dish8.setPicture("steak.jpg");
			dish8.setPrice(8);
			List<Allergen> allergens8 = new ArrayList<>();
			allergens8.add(allergenRepository.findByName("Gluten")); // Fetch allergen by name from repository
			dish8.setAllergens(allergens8);
			List<Categorie> categories8 = new ArrayList<>();// Fetch category by name from repository
			categories8.add(categorieRepository.findByName("Meat"));
			dish8.setCategorie(categories8);
			dishRepository.save(dish8);

			Dish dish9 = new Dish();
			dish9.setName("Sushi");
			dish9.setDescription("Salmon Sushi");
			dish9.setPicture("sushi.jpg");
			dish9.setPrice(9);
			List<Allergen> allergens9 = new ArrayList<>();
			allergens9.add(allergenRepository.findByName("Gluten")); // Fetch allergen by name from repository
			allergens9.add(allergenRepository.findByName("Soy"));
			allergens9.add(allergenRepository.findByName("Fish"));
			dish9.setAllergens(allergens9);
			List<Categorie> categories9 = new ArrayList<>();// Fetch category by name from repository
			categories9.add(categorieRepository.findByName("Fish"));
			categories9.add(categorieRepository.findByName("Rice"));
			dish9.setCategorie(categories9);
			dishRepository.save(dish9);
		};
	}
}
