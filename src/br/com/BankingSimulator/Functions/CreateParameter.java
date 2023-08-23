package br.com.BankingSimulator.Functions;

import java.util.Scanner;

public class CreateParameter {

    public String createString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.next();
    }

    public int createInt(String message){
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        while (true){

            System.out.print(message);
            if (scanner.hasNextInt()){
                number = scanner.nextInt();
                break;
            }else {
                System.out.println("Please type a number!");
                scanner.next();
            }
        }
        return number;
    }
    public double createDouble(String message){
        Scanner scanner = new Scanner(System.in);
        double number = 0;
        while (true){

            System.out.print(message);
            if (scanner.hasNextInt()){
                number = scanner.nextDouble();
                break;
            }else {
                System.out.println("Please type a number!");
                scanner.next();
            }
        }
        return number;
    }
}
