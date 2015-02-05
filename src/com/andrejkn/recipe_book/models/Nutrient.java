package com.andrejkn.recipe_book.models;

import com.andrejkn.recipe_book.NutrientType;

public class Nutrient {
	
	private int id;
	private NutrientType nutrientType;
	private double amountInGrams;
	
	public Nutrient() {
		
	}

	public Nutrient(NutrientType nType, double amountInGrams) {
		this.nutrientType = nType;
		this.amountInGrams = amountInGrams;
	}
	
	
	public double getTotalCalories() {
		return this.nutrientType.getCalories() * this.amountInGrams;
	}
	
	
	@Override
	public boolean equals(Object n) {
		if( !(n instanceof Nutrient) ) {
			return false;
		}
		
		if( ((Nutrient)n).getNutrientType() == this.nutrientType ) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getId() {
		return this.id;
	}

	public double getAmountInGrams() {
		return this.amountInGrams;
	}
	
	public NutrientType getNutrientType() {
		return this.nutrientType;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNutrientType(NutrientType type) {
		this.nutrientType = type;
	}
	
	public void setAmountInGrams(double amountInGrams) {
		this.amountInGrams = amountInGrams;
	}
}
