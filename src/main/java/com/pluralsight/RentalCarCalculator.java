package com.pluralsight;

import java.util.Objects;
import java.util.Scanner;

public class RentalCarCalculator {
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args){
        String pickupDate = promptForString("Pickup Date: ");
        int numberOfDays = promptForInt("Number of Days for the rental: ");
        boolean tollTag = promptForBoolean("Do you want an electronic toll tag for $3.95/day ?");
        boolean GPS = promptForBoolean("Do you want GPS for $2.95/day ?");
        boolean roadsideAssistance = promptForBoolean("Do you want roadside assistance for $3.95/day? ");
        int age = promptForInt("What is your age?");

        double tollTagCost = costTollTag(numberOfDays, tollTag);
        double costOfGPS = costGPS(numberOfDays, GPS);
        double roadsideAssistanceCost = costRoadsideAssistance(numberOfDays, roadsideAssistance);

        double basicCarRental = numberOfDays * 29.99;
        double optionsCost = tollTagCost + costOfGPS + roadsideAssistanceCost;
        double underageDriverSurcharge = 0.0;
        if (age < 25) {
            underageDriverSurcharge = basicCarRental * .3;
        }
        double totalCost = basicCarRental + optionsCost + underageDriverSurcharge;

        System.out.println("The basic car rental cost is " + basicCarRental);
        System.out.println("The total options cost is " + optionsCost);
        System.out.println("The underage driver surcharge is " + underageDriverSurcharge);
        System.out.println("The totalCost is " + totalCost);

    }

    public static int promptForInt(String prompt){
        System.out.println(prompt);
        int num = myScanner.nextInt();
        myScanner.nextLine();
        return num;
    }

    public static boolean promptForBoolean(String prompt){
        String answer = promptForString(prompt + "(Y for Yes, N for No)");
        return (Objects.equals(answer, "Y")
                ||
                Objects.equals(answer, "Yes")
                ||
                Objects.equals(answer, "yes")
                ||
                Objects.equals(answer, "YES")
                );

    }

    public static String promptForString (String prompt){
        System.out.println(prompt);
        return myScanner.nextLine();
    }

    public static double costGPS(int numberOfDays,boolean needed){
        double cost = 0.0;
        if (needed){
            cost =  numberOfDays * 2.95;
        }
        return cost;
    }

    public static double costTollTag(int numberOfDays,boolean needed){
        double cost = 0.0;
        if (needed){
            cost =  numberOfDays * 3.95;
        }
        return cost;
    }


    public static double costRoadsideAssistance(int numberOfDays,boolean needed){
        double cost = 0.0;
        if (needed){
            cost =  numberOfDays * 3.95;
        }
        return cost;
    }


}
