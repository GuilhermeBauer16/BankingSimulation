package br.com.BankingSimulator.Main;

import br.com.BankingSimulator.Accounts.Account;
import br.com.BankingSimulator.Functions.CreateParameter;

public class Main {
    public static void main(String[] args) {
        CreateParameter createParameter = new CreateParameter();
        Account account  = new Account();

        while (true){
        System.out.println("Banking simulator");
        System.out.println("[1]New account ");
        System.out.println("[2]Deposit ");
        System.out.println("[3]View Balance ");
        int option = createParameter.createInt("Select your Option: ");

        switch (option) {
            case 1:
                account.newAccount();
                break;

            case 2 :
                account.deposit("Input the value what you want to deposit:U$ ");
                break;

            case 3:
                System.out.println("U$ " + account.getBalance());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }
}
}