package br.com.BankingSimulator.DAO;

import br.com.BankingSimulator.Account.Account;
import br.com.BankingSimulator.Account.AccountType;
import br.com.BankingSimulator.Functions.CreateParameter;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AccountTypeDAO {

    private EntityManager entityManager;
    private CreateParameter createParameter = new CreateParameter();


    public AccountTypeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public AccountType findID() {
        CreateParameter createParameter = new CreateParameter();
        String jpql = "SELECT AT FROM AccountType AT ";
        Query query = entityManager.createQuery(jpql, AccountType.class);
        List<AccountType> accountTypes = query.getResultList();
        long id = 0l;

        while (true) {
            id = createParameter.createInt("Type ID: ");
            if (id > accountTypes.size()) {

                System.out.println("Invalid account type ID!");

            } else {
                break;
            }

        }
        return entityManager.find(AccountType.class, id);
    }


    public void showAccountTypes() {

        String jpql = "SELECT AT FROM AccountType AT ";
        Query query = entityManager.createQuery(jpql, AccountType.class);
        List<AccountType> accountTypes = query.getResultList();
        System.out.println("=".repeat(100));
        System.out.printf("| %-4s | %-17s |%n", "ID", "Account type");
        System.out.println("=".repeat(100));

        for (AccountType accountType : accountTypes) {

            System.out.printf("| %-4s | %-17s |%n", accountType.getId(), accountType.toString());

        }
        System.out.println("=".repeat(100));
    }



}
