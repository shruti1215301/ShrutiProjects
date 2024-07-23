package com.nagarro.training;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
        Scanner sc = new Scanner(System.in);
        String colorOfTShirt, gender, preferenceChoice, size;
        System.out.println("Enter T-Shirt Details");
        System.out.print("Enter Color : ");
        colorOfTShirt = sc.nextLine();
        System.out.print("Enter Size : ");
        size = sc.nextLine();
        System.out.print("Enter Gender : ");
        gender = sc.nextLine();
        System.out.print("Enter Output Preference (Price,Rating,Both) : ");
        preferenceChoice = sc.nextLine();
        
        dataController dc = new dataController();
        
        dc.searchData(colorOfTShirt, size, gender);
        
        dc.manageData(preferenceChoice);
        sc.close();
    }
}
