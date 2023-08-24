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

    private double salary;
    private double balance;

    public Account newAccount(){
        CreateParameter createParameter = new CreateParameter();
        this.fullName = createParameter.createString("Full name: ");
        this.salary = createParameter.createDouble("Salary U$: ");
        return this;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getSalary() {
        return salary;
    }

    public double getBalance() {
        return balance;
    }

//    public Account  deposited(String message) {
//        CreateParameter createParameter = new CreateParameter();
//        this.balance +=  createParameter.createInt(message);
//        return this ;
//    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

//    public Account withdrawMoney(String message){
//        CreateParameter createParameter = new CreateParameter();
//        int withdraw = createParameter.createInt(message);
//
//        if (withdraw < this.balance){
//            this.balance -= withdraw;
//        }else {
//            System.out.println("The value what you want  withdraw is more what you have in the account.");
//        }
//        return this;
//    }




}
