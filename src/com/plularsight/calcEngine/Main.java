package com.plularsight.calcEngine;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Bank myBank = new Bank();

    public static void main(String[] args) {
        System.out.println("Welcome in TD Bank");
        boolean quit = false;
        printActions();
        while(!quit){
            System.out.println("Enter action(7 to show available actions):");
            int pick = scanner.nextInt();
            scanner.nextLine();
            switch (pick){
                case 0 -> {
                    System.out.println("Closing app....");
                    quit = true;
                }
                case 1 -> myBank.listBranches();
                case 2 -> listCostumers();
                case 3 -> addBranch();
                case 4 -> addCustomerToBranch();
                case 5 -> addTransaction();
                case 6 -> viewTransactionDetails();
                case 7 -> printActions();
            }

        }
    }

    private static void viewTransactionDetails(){
        System.out.println("Enter branch name: ");
        String nameBranch = scanner.nextLine();
        System.out.println("Enter name of the customer: ");
        String customerName = scanner.nextLine();
       myBank.listTransactionCustomersBranch(customerName,nameBranch);
    }

    private static void addTransaction(){
        System.out.println("Enter branch name: ");
        String nameBranch = scanner.nextLine();
        System.out.println("Enter name of the customer: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter transaction amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        myBank.addTransactionToCustomerInBranch(nameBranch,customerName,amount);

    }


    private static void addCustomerToBranch(){
        System.out.println("Enter name of branch to which add new customer: ");
        String nameBranch = scanner.nextLine();
        System.out.println("Enter name of the customer: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter initial transaction amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        myBank.addCustomerToBranch(nameBranch,customerName,amount);
    }
    private static void addBranch(){
        System.out.println("Enter new branch name: ");
        String name = scanner.nextLine();
        if(myBank.addBranch(name)){
            System.out.println("New branch " + name + " successful added.");
        }else {
            System.out.println("Adding error.");
        }
    }


    private static void listCostumers(){
        System.out.println("Enter branch name: ");
        String name = scanner.nextLine();
        myBank.listCustomersBranch(name);
    }


    private static void printActions() {
        System.out.println("\nAvailable actions: \npress");
        System.out.println("0 - To Exit\n" +
                "1 - To View List of Branches\n" +
                "2 - To view list of customers for a branch\n"+
                "3 - To add a Branch\n" +
                "4 - To add a new customer to an existing branch\n" +
                "5 - To add a transaction to an existing account\n" +
                "6 - To view transaction details of an existing account\n" +
                "7 - To Show available actions\n");

    }
}
