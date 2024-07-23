package com.tshirtkart.entities;


import javax.persistence.Entity;

import javax.persistence.Id;

@Entity

public class ProductDetails {


	@Id
	private String id;
	
	private String name;
	private String color;
	private String genderRecommendation;
	private String size;
	private Double price;
	private Double rating;
	private String availability;

	public ProductDetails(String id, String name, String color, String genderRecommendation, String size, Double price,
			Double rating, String availability) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.genderRecommendation = genderRecommendation;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.availability = availability;
	}

	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGenderRecommendation() {
		return genderRecommendation;
	}

	public void setGenderRecommendation(String genderRecommendation) {
		this.genderRecommendation = genderRecommendation;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "[" + id + "|" + name + "|" + color + "|"
				+ genderRecommendation + "|" + size + "|" + price + "|" + rating
				+ "|" + availability + "]";
	}



}
