package com.example;

public class Account {
    float balance;
    private AccountType type;
    private int id;
    private static int idSequence = 0;

    public int getId() {
        return id;
    }

    public Account(AccountType t){
        id = ++idSequence;
        type = t;
        balance = 0f;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public void deposit(float amount){
        this.balance += amount;
    }

    public void withdrawal(float amount) throws Exception{
        this.balance -= amount;
        if(amount > balance){
            throw new Exception("Not enought money");
        }
    }
}

enum AccountType{
    DEBIT, CREDIT;
}
