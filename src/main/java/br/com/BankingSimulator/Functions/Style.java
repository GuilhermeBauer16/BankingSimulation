package br.com.BankingSimulator.Functions;

public class Style {

    public  void createMenu(int number){

        System.out.println(title("Banking simulator" , number));
        System.out.println("[1]New account ");
        System.out.println("[2]Deposit ");
        System.out.println("[3]Withdraw money ");
        System.out.println("[4]View accounts ");
        System.out.println("[5]Exit ");
        System.out.println(line(number));

    }

    public String title(String message, int number) {
        String line = "==".repeat(number);
        return line + "\n" + message + "\n" + line;
    }

    public String line(int number) {
        return "==".repeat(number);
    }
}
