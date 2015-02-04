package com.andrejkn.recipe_book;

public enum NutrientType {
	FAT(4),
	PROTEIN(3),
	CARBOHYDRATE(2);
	
	private final int caloriesPerGram;
	
	NutrientType(int calories) {
		this.caloriesPerGram = calories;
	}
	
	public int getCalories() {
		return this.caloriesPerGram;
	}
}