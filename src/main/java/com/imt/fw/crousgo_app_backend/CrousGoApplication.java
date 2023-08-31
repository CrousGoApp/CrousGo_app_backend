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
		};
	}
}
