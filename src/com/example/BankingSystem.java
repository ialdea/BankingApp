package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BankingSystem {
    public static void main(String[] args){

        Agency militari = Agency.getAgency("Iuliu Maniu", "Bucuresti");
        Agency unirii = Agency.getAgency("unirii", "Bucuresti");

        Customer c1 = new Customer("Irina", "Aldea", militari, AccountType.DEBIT);
        c1.addAccount(AccountType.CREDIT);

        Customer c2 = new Customer("Bogadan", "Talpiga", unirii, AccountType.CREDIT);

        System.out.println(c1);
        System.out.println(c2);

        try{
            c1.getAccountByNumber(1).deposit(100);
            c1.getAccountByNumber(2).withdrawal(10);
            c2.getAccountByNumber(3).deposit(100);
        }catch (Exception e){
            e.printStackTrace();
        }

        List<Customer> allCustomers = new ArrayList<>();
        allCustomers.add(c1);
        allCustomers.add(c2);
        Customer c3 = new Customer("gigi", "duru", unirii, AccountType.CREDIT);
        allCustomers.add(c3);


        c3.getAccounts().get(0).deposit(10);

        sortCustomers(allCustomers);

        System.out.println("----");
        for(Customer c : allCustomers){
            System.out.println(c);
        }

        persistCustomers(allCustomers);
    }

    private static void sortCustomers(List<Customer> allCustomers) {
        for(int i = 0; i < allCustomers.size() - 1; i++){
            for(int j = i+1; j < allCustomers.size(); j++){
                float leftCustomerBalance = allCustomers.get(i).getTotalBalance();
                float rightCustomerBalance = allCustomers.get(j).getTotalBalance();
                if(leftCustomerBalance < rightCustomerBalance){
                    Customer aux = allCustomers.get(i);

                    allCustomers.remove(i);
                    allCustomers.add(i, allCustomers.get(j-1));

                    allCustomers.remove(j);
                    allCustomers.add(j, aux);
                }
            }
        }
    }

    private static void persistCustomers(List<Customer> allCustomers){
        BufferedWriter bw = null;
        try{
            FileOutputStream fos = new FileOutputStream("./Customers.txt");
            bw = new BufferedWriter(new OutputStreamWriter(fos));
            for(Customer c : allCustomers){
                bw.write(c.toString()+"\n");
//                fos.write((c.toString()+"\n").getBytes());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bw != null){
                try{
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
