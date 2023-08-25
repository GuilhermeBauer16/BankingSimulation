package br.com.BankingSimulator.Main;

import br.com.BankingSimulator.Account.Account;
import br.com.BankingSimulator.Account.AccountType;
import br.com.BankingSimulator.DAO.AccountTypeDAO;
import br.com.BankingSimulator.DAO.AccountDAO;
import br.com.BankingSimulator.Functions.CreateParameter;
import br.com.BankingSimulator.Functions.Style;
import br.com.BankingSimulator.Util.JPAUtil;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {

        CreateParameter createParameter = new CreateParameter();
        Style style = new Style();


        EntityManager entityManager = new JPAUtil().getEntityManager();
        AccountTypeDAO accountTypeDAO = new AccountTypeDAO(entityManager);
        AccountDAO bankingSimulatorDAO = new AccountDAO(entityManager);

        while (true) {
            style.createMenu(50);
            int option = createParameter.createInt("Select your Option: ");

            switch (option) {
                case 1:
                    entityManager.getTransaction().begin();
                    Account account = new Account();
                    AccountType accountType = new AccountType();

                    account.newAccount();
                    accountTypeDAO.showAccountTypes();
                    AccountType selectedAccountType = accountTypeDAO.findID();
                    account.setAccountType(selectedAccountType);
                    bankingSimulatorDAO.insert(account);

                    entityManager.getTransaction().commit();
                    break;

                case 2:

                    bankingSimulatorDAO.Deposit();
                    break;

                case 3:

                    bankingSimulatorDAO.Withdraw();

                case 4:

                    bankingSimulatorDAO.showAccounts();
                    break;

                case 5:

                    System.out.println("Exit of the system,bye");
                    entityManager.close();
                    return;

                default:

                    throw new IllegalStateException("Unexpected value: " + option);

            }

        }

    }


}