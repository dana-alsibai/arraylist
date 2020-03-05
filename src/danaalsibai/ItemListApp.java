/*
        Name: Dana Alsibi
        Assignment:  Assignment 3
        Program: Item List Application
        Date:  February 10th, 2020
    
        Description: an application that can be used to keep 
                    track of item cost information.
        
 */
package danaalsibai;

import java.util.*;

/**
 *
 * @author danasebai, 2020
 */
public class ItemListApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        - create an object of the Item  class.
        - create an empty List. 
        - functions to get the user input and catch the exception inside them.
         */

        Size s = Size.M;
        double base;
        boolean valid = true;
        boolean notValid = true;
        boolean exit = false;

        ItemList list = new ItemList();

        Item item;

        Scanner sc = new Scanner(System.in);

        while (!exit) {

            do {
                try {

                    s = ItemListApp.getInput("Enter Enter Size Code:"
                            + " (XS|S|M|L|XL):\t ");
                    valid = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    valid = true;
                }
            } while (valid);

            do {
                try {
                    base = ItemListApp.itemBaseCostInput("Enter the base cost:\t\t");
                    item = new Item(s, base);
                    list.add(item);
                    notValid = false;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (notValid);

            System.out.println("Would you like to enter another item (Y/N):\t ");
            char answer = sc.next().toUpperCase().charAt(0);
            if (answer == 'Y') {
            } else {
                printMethod();
                System.out.println(list.toString());
                exit = true;
            }
        }
    }

    /**
     * @param prompt String message to get the user size input.
     * @return Size value.
     */
    public static Size getInput(String prompt) throws IllegalArgumentException {
        String itemInput = "";
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        itemInput = sc.nextLine().toUpperCase();
        if (!(itemInput.matches("[SMLX]{1,2}"))) {
            throw new IllegalArgumentException("Error! There is no such size!");
        }
        return Size.valueOf(itemInput);
    }

    /**
     *
     * @param prompt String message to get the base cost from the user
     * @return double baseCost.
     */
    public static double itemBaseCostInput(String prompt) {

        double itemCostInput;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print(prompt);
            itemCostInput = sc.nextDouble();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! base cost must be a number");
            itemCostInput = itemBaseCostInput(prompt);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            itemCostInput = itemBaseCostInput(prompt);

        }
        return itemCostInput;
    }

    // print the header
    public static void printMethod() {
        System.out.printf("%s \n %s  %s\t%s \n %s \n",
                "========================================",
                "Item Name", "Base Cost", "Item Cost",
                "=======================================");
    }
}
