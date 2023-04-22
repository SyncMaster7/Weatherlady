package edu.weatherlady;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static final Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;

        printInstructions();
        while (!quit) {
            System.out.println("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0 -> printInstructions();
                case 1 -> edu.weatherlady.database.DataService.getAllLocationInfo();
                case 2 -> addLocationInfo();
                case 3 -> getWeatherInfo();
                case 4 -> quit = true;
            }
        }
    }

    public static void printInstructions() {

        System.out.println("\nPress\n");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of location information.");
        System.out.println("\t 2 - To add a location to the database.");
        System.out.println("\t 3 - To get weather information about desired location.");
        System.out.println("\t 4 - To quit the application.\n");
    }

    public static void addLocationInfo() {

        System.out.println("Insert 'latitude' value: ");
        double lat = sc.nextDouble();
        System.out.println("Insert 'longitude' value: ");
        double lon = sc.nextDouble();
        System.out.println("Insert region: ");
        String region = sc.nextLine();
        System.out.println("Insert name of the country: ");
        String countryName = sc.nextLine();
        System.out.println("Insert name of the city: ");
        String cityName = sc.nextLine();

        edu.weatherlady.database.DataService.addLocation(lat, lon, region, countryName, cityName);
    }

    public static void getWeatherInfo() {
        System.out.println("Unfortunately this functionality is still under development ...");
    }
}
