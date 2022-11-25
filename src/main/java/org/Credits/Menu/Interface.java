package org.Credits.Menu;

import org.Credits.BankInfo.BankCredit;
import org.Credits.Command.Receiver;

import java.util.Scanner;
public class Interface {
    private final BankCredit list = new BankCredit();
    private final Scanner scanner = new Scanner(System.in);
    private final Receiver receiver = new Receiver(list);
    public void showMenu(){
        String value;
        System.out.print("--------------------------Bank Credits--------------------------");
        do {
            menu();
            value = scanner.nextLine();
            switch (value) {
                case "1" -> receiver.run(0);
                case "2" -> receiver.run(1);
                case "3" -> receiver.run(2);
                case "4" -> receiver.run(3);
                case "5" -> receiver.run(4);
                case "6" -> receiver.run(5);
                case "7" -> receiver.run(6);
                case "8" -> receiver.run(7);
                case "9" -> receiver.run(8);
                case "10"-> receiver.run(9);
                case "11" -> receiver.run(10);
            }

        } while (true);
    }

    static void menu() {
        System.out.println("\n1.Add credit to the list");
        System.out.println("2.Choose credit");
        System.out.println("3.Extend credit line");
        System.out.println("4.Pay");
        System.out.println("5.Show credits filtered");
        System.out.println("6.Show credits list");
        System.out.println("7.Deposit to balance");
        System.out.println("8.Show info");
        System.out.println("9.Show all banks");
        System.out.println("10.Create new bank");
        System.out.println("11.Exit\n");
        System.out.print("Your choice: ");
    }
}
