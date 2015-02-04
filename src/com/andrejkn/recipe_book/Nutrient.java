package com.andrejkn.recipe_book;

public class Nutrient {

	NutrientType type;
	double amountInGrams;
	
	public Nutrient(NutrientType nType, double amountInGrams) {
		this.type = nType;
		this.amountInGrams = amountInGrams;
	}
	
	public double getTotalCalories() {
		return this.type.getCalories() * this.amountInGrams;
	}
	
}
