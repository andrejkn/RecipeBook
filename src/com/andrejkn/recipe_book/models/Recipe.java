package com.andrejkn.recipe_book.models;

public class Recipe {
	private int id;
	private String title; 
	private String description;

	public Recipe() {
	}
	
	public Recipe(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDescription() {
		return this.description;
	}
}
