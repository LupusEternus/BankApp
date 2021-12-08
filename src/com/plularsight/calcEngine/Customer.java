package com.plularsight.calcEngine;

import java.util.ArrayList;

public class Customer {

    private final String name;
    private final ArrayList<Double> transactionList;

    public Customer(String name, double amount){
        this.name = name;
        this.transactionList = new ArrayList<Double>();
        this.transactionList.add(amount);

    }

    public String getName(){
        return this.name;
    }
    public static Customer createCustomer(String name, double amount){
        return new Customer(name,amount);
    }

    public void addTransaction(double amount){
        if(amount != 0){
            this.transactionList.add(Double.valueOf(amount));
        }else{
            System.out.println("Transaction value should be different than zero.");
        }
    }
    public void viewTransactionDetails(){
        if(!transactionList.isEmpty()){
            double balance = 0;
            System.out.println("List of all transaction of " + this.getName());
            for(int i = 0; i < transactionList.size(); i++){
                balance += transactionList.get(i);
                System.out.println((i+1) + ". " + transactionList.get(i).doubleValue());
            }
            System.out.println("Balance: " + balance);

        }
    }

}
