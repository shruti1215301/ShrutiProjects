package javapractise;

import java.util.Scanner;

public class carinsds {
    private String carModel;
    private String carType;
    private double carCostPrice;
    private String insuranceType;

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarModel() {
        return this.carModel;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarType() {
        return this.carType;
    }

    public void setCarCostPrice(double carCostPrice) {
        this.carCostPrice = carCostPrice;
    }

    public double getCarCostPrice() {
        return this.carCostPrice;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getInsuranceType() {
        return this.insuranceType;
    }

    // Method to calculate the insurance premium for the car
    public double calculateInsurancePremium() {
        double insurancepremiumPercentage;
        // calculating the percentage of insurance premium based on car type
        switch (this.carType) {
            case "Hatchback":
                insurancepremiumPercentage = 0.05;
                break;
            case "Sedan":
                insurancepremiumPercentage = 0.08;
                break;
            case "SUV":
                insurancepremiumPercentage = 0.10;
                break;
            default:
                throw new IllegalArgumentException("Invalid car type");
        }
        // Calculating the insurance premium
        double insurancepremium = this.carCostPrice * insurancepremiumPercentage;
        // Add 20% to the insurance premium if the insurance type is premium
        if (this.insuranceType.equalsIgnoreCase("Premium")) {
            insurancepremium += (insurancepremium * 0.20);
        }

        return insurancepremium;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            do {
                carinsds carInsurance = new carinsds();

                System.out.print("Enter car model: ");
                carInsurance.setCarModel(scanner.nextLine());

                System.out.print("Enter car type (Hatchback, Sedan, SUV): ");
                carInsurance.setCarType(scanner.nextLine());

                if (carInsurance.getCarType().equals("Hatchback") || carInsurance.getCarType().equals("Sedan")
                        || carInsurance.getCarType().equals("SUV")) {

                    System.out.print("Enter car cost price: ");
                    carInsurance.setCarCostPrice(scanner.nextDouble());

                    scanner.nextLine();

                    System.out.print("Enter insurance type (Basic or Premium): ");
                    carInsurance.setInsuranceType(scanner.nextLine());

                    System.out.println("Car Model: " + carInsurance.getCarModel());
                    System.out.println("Car Type: " + carInsurance.getCarType());
                    System.out.println("Car Cost Price: " + carInsurance.getCarCostPrice());
                    System.out.println("Insurance Type: " + carInsurance.getInsuranceType());
                    System.out.println("Effective Insurance Premium: " + carInsurance.calculateInsurancePremium());
                } else {
                    System.out.println("Invalid car type entered. Please try again.");
                }

                System.out.print("Do you want to enter details of any other car (y/n): ");
            } while (scanner.nextLine().equalsIgnoreCase("y"));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}

