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
        long id = createParameter.createInt("Type ID:");
        return entityManager.find(AccountType.class, id);
    }
    public void accountType() {


        AccountType selectedAccount = findID();
        if (selectedAccount != null) {
            selectedAccount.getAccountType();

        } else {
            entityManager.getTransaction().rollback();
            System.out.println("Account not found!");
        }

    }

    public void showAccountTypes() {
        String jpql = "SELECT AT FROM AccountType AT ";
        Query query = entityManager.createQuery(jpql, AccountType.class);
        List<AccountType> accountTypes = query.getResultList();

        for (AccountType accountType : accountTypes) {
            System.out.println(accountType.getId());
            System.out.println(accountType.toString());


        }
}

}
