package br.com.BankingSimulator.DAO;

import br.com.BankingSimulator.Account.Account;
import br.com.BankingSimulator.Functions.CreateParameter;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class BankingSimulatorDAO {
    private EntityManager entityManager;
    private CreateParameter createParameter = new CreateParameter();
    private Account account = new Account();
    public BankingSimulatorDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Account account) {
        entityManager.persist(account);
    }

    public void showAccounts() {
        String jpql = "SELECT A FROM Account A ";
        Query query = entityManager.createQuery(jpql, Account.class);
        List<Account> accounts = query.getResultList();

        for (Account account : accounts) {
            System.out.println(account.getId());
            System.out.println(account.getFullName());

        }


    }

    public Account findID() {
        CreateParameter createParameter = new CreateParameter();
        long id = createParameter.createInt("Type ID:");
        return entityManager.find(Account.class, id);
    }

    public void Deposit() {

        showAccounts();
        entityManager.getTransaction().begin();
        Account selectedAccount = findID();
        if (selectedAccount != null) {
//
            double amount = selectedAccount.getBalance();
            double withdraw = createParameter.createDouble("Insert the value what you want to deposit.U$ ");
            double newBalance = amount + withdraw;
            selectedAccount.setBalance(newBalance);
            entityManager.getTransaction().commit();
        } else {
            entityManager.getTransaction().rollback();
            System.out.println("Account not found!");
        }
    }

    public  void Withdraw(){
        showAccounts();
        entityManager.getTransaction().begin();
        Account selectedAccount = findID();
        if (selectedAccount != null){

            double amount = selectedAccount.getBalance();
            double withdraw = createParameter.createInt("Insert the value what you want to withdraw.U$ ");
            double newBalance = amount - withdraw;
            selectedAccount.setBalance(newBalance);

            entityManager.getTransaction().commit();

        } else {
            entityManager.getTransaction().rollback();
            System.out.println("Account not found!");
        }
    }
}
