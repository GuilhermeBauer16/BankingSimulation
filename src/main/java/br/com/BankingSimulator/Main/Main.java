package br.com.BankingSimulator.Main;

import br.com.BankingSimulator.Account.Account;
import br.com.BankingSimulator.DAO.BankingSimulatorDAO;
import br.com.BankingSimulator.Functions.CreateParameter;
import br.com.BankingSimulator.Util.JPAUtil;
import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        CreateParameter createParameter = new CreateParameter();
        Account account  = new Account();
        EntityManager entityManager = new JPAUtil().getEntityManager();
        BankingSimulatorDAO bankingSimulatorDAO = new BankingSimulatorDAO(entityManager);

        while (true){
        System.out.println("Banking simulator");
        System.out.println("[1]New account ");
        System.out.println("[2]Deposit ");
        System.out.println("[3]View Balance ");
        int option = createParameter.createInt("Select your Option: ");

        switch (option) {
            case 1:
                entityManager.getTransaction().begin();
                bankingSimulatorDAO.insert(account.newAccount());
                entityManager.getTransaction().commit();
                break;

            case 2 :
                bankingSimulatorDAO.Deposit();

                break;

            case 3:
                bankingSimulatorDAO.showAccounts();
                System.out.println("U$ " + account.getBalance());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }
}
}