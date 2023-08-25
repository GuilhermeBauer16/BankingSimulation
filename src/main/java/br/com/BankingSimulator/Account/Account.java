package br.com.BankingSimulator.Account;

import br.com.BankingSimulator.DAO.AccountTypeDAO;
import br.com.BankingSimulator.Functions.CreateParameter;

import javax.persistence.*;

@Entity
@Table(name = "accounts")

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "account_type_id")

    private AccountType accountType;
    private String fullName;

    private double salary;
    private double balance;

    public Account newAccount() {
        CreateParameter createParameter = new CreateParameter();
        this.fullName = createParameter.createString("Full name: ");
        this.salary = createParameter.createDouble("Salary U$: ");
        return this;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
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


    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void setFullName(String string) {
    }

    public void setSalary(double aDouble) {
    }
}



