package com.andrejkn.recipe_book.models;

import java.util.Map;

public class Ingredient {
	private int id;
	private String name;
	private Map<Nutrient, Double> nutrientQuantityInGrams;
	
	public Ingredient(String name, Map<Nutrient, Double> nutrientQuantityInGrams) {
		this.name = name;
		this.nutrientQuantityInGrams = nutrientQuantityInGrams;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Map<Nutrient, Double> getNutrientQuantityInGrams() {
		return this.nutrientQuantityInGrams;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNutrientQuantityInGrams(Map<Nutrient, Double> nutrientQuantityInGrams) {
		this.nutrientQuantityInGrams = nutrientQuantityInGrams;
	}
}
