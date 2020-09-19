package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    private List<Account> accounts;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public void addAccount(AccountType t){
        accounts.add(new Account(t));
    }

    public List<Account> getAccounts(){
        return Collections.unmodifiableList(accounts);
    }

    private Agency agency;

    public Customer(String firstName, String lastName, Agency ag, AccountType t){
        this.firstName = firstName;
        this.lastName = lastName;
        agency = ag;
        accounts = new ArrayList<>();
        accounts.add(new Account(t));
    }

    public String toString(){
        String ret = "Customer "+firstName+" "+lastName+" at agency: "+agency.toString()+" having "+accounts.size()+" accounts";
        return ret;
    }

    public Account getAccountByNumber(int accountId) throws Exception{
        for(Account ac : accounts){
            if(ac.getId() == accountId){
                return ac;
            }
        }
        throw  new Exception("Account not fount");
    }

    public float getTotalBalance() {
        float ret = 0;
        for(Account a : accounts){
            ret += a.balance;
        }
        return ret;
    }
}
