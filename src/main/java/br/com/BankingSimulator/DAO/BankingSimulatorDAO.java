package br.com.BankingSimulator.DAO;

import br.com.BankingSimulator.Account.Account;
import br.com.BankingSimulator.Functions.CreateParameter;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class BankingSimulatorDAO {
    private EntityManager entityManager;

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

    public Account findID(long id) {
        CreateParameter createParameter = new CreateParameter();

        return entityManager.find(Account.class, id);
    }

    public void Deposit() {
        showAccounts();
        CreateParameter createParameter = new CreateParameter();
        int id = createParameter.createInt("Type ID:");
        Account account = findID(id);
        if (account != null) {
//            int depositar = createParameter.createInt();
            entityManager.getTransaction().begin();
            account.deposited("Insert the value what you want to deposit.U$ ");
            entityManager.getTransaction().commit();
        } else {
            System.out.println("This account is not find!");
        }
    }
}
