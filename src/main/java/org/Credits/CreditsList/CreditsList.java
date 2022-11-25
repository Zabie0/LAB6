package org.Credits.CreditsList;
import org.Credits.DatabaseExecuter;
import org.Credits.User.biler;

import java.sql.SQLException;
import java.util.Scanner;
public class CreditsList {
    public void addCredit() throws SQLException {
        biler res = DatabaseExecuter.dbExecuteSelect(1,"null","SELECT COUNT(*) as total FROM banks;");
        if(res.getId() == 0){
            System.out.println("There are no banks to add credits to");
        }
        else{
            setCredit();
        }
    }

    public void setCredit() throws SQLException {
        int extendedPercentage = 0;
        int maxExtendableMoney = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter the id of Bank: ");
        int bankId = scan.nextInt();
        biler res = DatabaseExecuter.dbExecuteSelect(1,"null","SELECT TOP 1 banks.bankId FROM banks WHERE banks.bankId = "+bankId+";");
        while(res.getId() == 0){
            System.out.println("Bank was not found, please try again");
            System.out.print("\nEnter the id of Bank: ");
            bankId = scan.nextInt();
            res = DatabaseExecuter.dbExecuteSelect(1,"null","SELECT TOP 1 banks.bankId FROM banks WHERE banks.bankId = "+bankId+";");
        }
        System.out.print("\n Is credit line extendable(1-Yes,2-No): ");
        int bool = scan.nextInt();
        while(bool < 0 || bool > 2){
            System.out.println("Invalid request!");
            bool = scan.nextInt();
        }
        System.out.println("\n Amount of months to repay: ");
        int months = scan.nextInt();
        System.out.println("\n Money given by the bank: ");
        int moneyGiven = scan.nextInt();
        System.out.println("\n Percentage to repay under: ");
        int percentage = scan.nextInt();
        int moneyToGive = moneyGiven + ((moneyGiven * percentage)/100);
        System.out.println("\n Amount to repay: " + moneyToGive);
        if(bool==1){
            System.out.println("\n Percentage if line gets extended: ");
            extendedPercentage = scan.nextInt();
            System.out.println("\n Max amount of money to extend the line to: ");
            maxExtendableMoney = scan.nextInt();
        }
        DatabaseExecuter.dbExecute("INSERT INTO credits (moneyGiven, percentage, months, moneyToGive, creditLineExtendable, maxExtendableMoney, extendedPercentage, BankId) VALUES "
                + "("+moneyGiven+", "+percentage+", "+months+", "+moneyToGive+", "+bool+", "+maxExtendableMoney+", "+extendedPercentage+", "+bankId+");");
    }
    public void setBank(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Bank name: ");
        String name = scan.nextLine();
        System.out.println("Address: ");
        String address = scan.nextLine();
        System.out.println("Email: ");
        String email = scan.nextLine();
        DatabaseExecuter.dbExecute("INSERT INTO banks (name, address, email) VALUES "
                + "('"+name+"', '"+address+"', '"+email+"');");
    }
}
