package com.nagarro.training;
import java.util.ArrayList;

public class dataView {
	public void displayTShirt(ArrayList<dataModel> tShirtList) {
		System.out.println("ID  NAME  COLOR  GENDER  SIZE  PRICE  RATING ");
		boolean present = false;
		for(dataModel tShirt : tShirtList) {
			if(tShirt.getAvailability() == 'Y') {
				present = true;
				System.out.println( 
					tShirt.getId() + " " + 
					tShirt.getModelName() + " " + 
					tShirt.getColor() + " " + 
					tShirt.getGender() + " " + 
					tShirt.getSize() + " " + 
					tShirt.getPrice() + " " + 
					tShirt.getRating());
			}
		}
		if(!present) System.out.println("No T Shirt Available for choosen filters");
	}
}