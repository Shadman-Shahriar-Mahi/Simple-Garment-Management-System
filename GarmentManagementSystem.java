package com.mycompany.garmentmanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Garment {
    private String name;
    private String type;
    private double price;

    public Garment(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Garment : " +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}


class GarmentManager {
    private List<Garment> garments;

    public GarmentManager() {
        garments = new ArrayList<>();
    }

    public void addGarment(Garment garment) {
        garments.add(garment);
        System.out.println("Garment added: " + garment);
    }

    public void displayGarments() {
        if (garments.isEmpty()) {
            System.out.println("No garments available.");
            return;
        }
        System.out.println("Garments in inventory:");
        for (Garment garment : garments) {
            System.out.println(garment);
        }
    }
}


public class GarmentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GarmentManager garmentManager = new GarmentManager();

        while (true) {
            System.out.println("1. Add Garment");
            System.out.println("2. Display Garments");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter garment name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter garment type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter garment price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    Garment garment = new Garment(name, type, price);
                    garmentManager.addGarment(garment);
                    break;
                case 2:
                    garmentManager.displayGarments();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
