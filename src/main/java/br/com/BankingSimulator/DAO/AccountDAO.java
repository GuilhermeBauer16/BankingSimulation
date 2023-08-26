package br.com.BankingSimulator.DAO;

import br.com.BankingSimulator.Account.Account;
import br.com.BankingSimulator.Account.AccountType;
import br.com.BankingSimulator.Functions.CreateParameter;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.text.DecimalFormat;
import java.util.List;

public class AccountDAO {
    private EntityManager entityManager;
    private CreateParameter createParameter = new CreateParameter();
    private Account account = new Account();

    public AccountDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Account account) {

        entityManager.persist(account);

    }
    public double decimalFormat(double amount ){
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.format(amount);
        return amount;
    }
    public void showAccounts() {
        String jpql = "SELECT A FROM Account A ";
        Query query = entityManager.createQuery(jpql, Account.class);
        List<Account> accounts = query.getResultList();
        System.out.println("=".repeat(100));
        System.out.printf("| %-4s | %-30s | %-17s | %-17s |%n", "ID", "Name", "Account type","Balance");
        System.out.println("=".repeat(100));
        for (Account account : accounts) {

            System.out.printf("| %-4s | %-30s | %-17s | %-17s |%n", account.getId(), account.getFullName(), account.getAccountType(),account.getBalance());

        }


    }

    public Account findID() {
        CreateParameter createParameter = new CreateParameter();
        long id = createParameter.createInt("Type ID: ");
        return entityManager.find(Account.class, id);
    }

    public void Deposit() {

        showAccounts();
        entityManager.getTransaction().begin();
        Account selectedAccount = findID();
        if (selectedAccount != null) {
//
            double amount = selectedAccount.getBalance();
            double deposit = createParameter.createDouble("Insert the value what you want to deposit.U$ ");
            decimalFormat(deposit);
            decimalFormat(amount);
            double newBalance = amount + deposit;
            double formattedValue = decimalFormat(newBalance);
            selectedAccount.setBalance(formattedValue);
            entityManager.getTransaction().commit();
        } else {
            entityManager.getTransaction().rollback();
            System.out.println("Account not found!");
        }
    }

    public void Withdraw() {
        showAccounts();
        entityManager.getTransaction().begin();
        Account selectedAccount = findID();
        if (selectedAccount != null) {

            double amount = selectedAccount.getBalance();
            double withdraw = createParameter.createInt("Insert the value what you want to withdraw.U$ ");
            double newBalance = amount - withdraw;
            double formattedValue = decimalFormat(newBalance);
            selectedAccount.setBalance(formattedValue);

            entityManager.getTransaction().commit();

        } else {
            entityManager.getTransaction().rollback();
            System.out.println("Account not found!");
        }
    }

    public void showAccountTypes() {
        String jpql = "SELECT AT FROM AccountType AT ";
        Query query = entityManager.createQuery(jpql, AccountType.class);
        List<AccountType> accounts = query.getResultList();

        for (AccountType accountType : accounts) {
            System.out.println(accountType.getId());


        }
    }
}
