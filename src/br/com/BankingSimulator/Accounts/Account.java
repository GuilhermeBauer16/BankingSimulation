package br.com.BankingSimulator.Accounts;

import br.com.BankingSimulator.Functions.CreateParameter;

public class Account {
    private String fullName;

    private double salary;
    private double balance;
    private byte age;
    private String accountType;
    private CreateParameter createParameter = new CreateParameter();

    public Account newAccount(){
        this.fullName = createParameter.createString("Full name: ");
        this.salary = createParameter.createDouble("Salary U$: ");
        return this;
    }

    public double deposit(String message) {
        return this.balance = createParameter.createDouble(message);
    }

    public double getBalance() {
        return balance;
    }
}
