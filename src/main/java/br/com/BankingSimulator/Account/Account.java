package br.com.BankingSimulator.Account;

import br.com.BankingSimulator.Functions.CreateParameter;

import javax.persistence.*;

@Entity
@Table(name = "accounts")

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String fullName;

    private int salary;
    private int balance;

    public Account newAccount(){
        CreateParameter createParameter = new CreateParameter();
        this.fullName = createParameter.createString("Full name: ");
        this.salary = createParameter.createInt("Salary U$: ");
        return this;
    }

    public Account  deposited(String message) {
        CreateParameter createParameter = new CreateParameter();
        this.balance +=  createParameter.createInt(message);
        return this ;
    }

    public double getBalance() {
        return balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
