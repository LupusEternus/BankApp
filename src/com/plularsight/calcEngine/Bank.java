package com.plularsight.calcEngine;

import java.util.ArrayList;

public class Bank {

    private final ArrayList<Branch> bank = new ArrayList<Branch>();

    public boolean addBranch(String name){
        if(findBranch(name) < 0){
            bank.add(new Branch(name));
            return true;
        }
        return false;
    }
    public void addCustomerToBranch(String branchName, String customerName, double amount){
        int index = findBranch(branchName);
        if( index >= 0){
            bank.get(index).addCustomer(customerName,amount);
            System.out.println("Customer " + customerName + " successful added to " + branchName
                + " branch, with " + amount + " initial transaction.");
        }else {
            System.out.println("Sorry, branch with name " + branchName + " don't exist, pls add branch.");
        }
    }
    public void addTransactionToCustomerInBranch(String branchName, String customerName,double amount){
       int index = findBranch(branchName);
       if(index >= 0) {
           bank.get(index).addTransaction(customerName, amount);
           System.out.println("Transaction added successful to " + customerName + " in " + branchName
                   + " branch, with " + amount);
       }else {
           System.out.println("Can't find " + branchName + " branch.");
       }
    }

    private int findBranch(String name){
        for(Branch x : bank){
            if(x.getBranchName().equals(name)){
                return bank.indexOf(x);
            }
        }
        return -1;
    }
    public void listCustomersBranch(String branchName){
        bank.get(findBranch(branchName)).listCustomers();
    }
    public void listTransactionCustomersBranch(String customerName, String branchName){
        bank.get(findBranch(branchName)).viewCustomerDetails(customerName);
    }
    public void listBranches(){
        System.out.println("Branches:");
        for(Branch c: bank){
            System.out.println("Name: " + c.getBranchName() + ",number of customers: " + c.noOfCustomers());
        }
    }


}
