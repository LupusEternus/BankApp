package com.plularsight.calcEngine;

import java.util.ArrayList;

public class Branch {

    private final String branchName;
    private final ArrayList<Customer> customersArrayList;

    public Branch(String branchName){
        this.branchName = branchName;
        customersArrayList = new ArrayList<Customer>();
    }
    public String getBranchName(){
        return this.branchName;
    }
    private int findCustomer(Customer customer){
        return customersArrayList.indexOf(customer);

    }
    private int findCustomer(String name){
        for(int i = 0; i < customersArrayList.size(); i++){
            if(customersArrayList.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public void addTransaction(String name, double amount){
        int index = findCustomer(name);
        if( index >= 0){
            customersArrayList.get(index).addTransaction(amount);


        }else {
            System.out.println("Sorry customer with " + name + " wasn't found.");
        }

    }
    public void addCustomer(String name, double initialAmount){
        if(findCustomer(name) >= 0){
            System.out.println("Can't add customer with name " + name +", this customer already exist");
        }
        customersArrayList.add(Customer.createCustomer(name,initialAmount));

    }
    public void listCustomers(){
        if(!customersArrayList.isEmpty()){
            System.out.println("List of customers in " + getBranchName() + " branch:");
            for(int i = 0; i < customersArrayList.size(); i++){
                System.out.println((i+1) + ". " + customersArrayList.get(i).getName());
            }
        }
    }
    public void viewCustomerDetails(String customerName){
        int index = findCustomer(customerName);
        customersArrayList.get(index).viewTransactionDetails();
    }
    public int noOfCustomers(){
        return customersArrayList.size();
    }
}
