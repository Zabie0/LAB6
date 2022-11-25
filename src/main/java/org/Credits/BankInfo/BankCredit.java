package org.Credits.BankInfo;

import org.Credits.CreditsList.CreditsList;
import org.Credits.DatabaseExecuter;
import org.Credits.User.User;
import org.Credits.User.biler;

import java.sql.SQLException;
import java.util.Scanner;
public class BankCredit {
    CreditsList creditsList = new CreditsList();
    private final Scanner scan = new Scanner(System.in);
    User user = new User();
    public void showAllBanks() throws SQLException {
        biler res = DatabaseExecuter.dbExecuteSelect(1,"null","SELECT COUNT(*) as total FROM banks;");
        if(res.getId() == 0){
            System.out.println("There are no banks to display");
        }
        else{
            DatabaseExecuter.dbExecuteShowAllBanks("select * from banks");
        }
    }
    public void showCreditsList() throws SQLException{
        biler res = DatabaseExecuter.dbExecuteSelect(1,"null","SELECT COUNT(*) as total FROM credits;");
        if(res.getId() == 0){
            System.out.println("There are no credits to show");
        }
        else {
            DatabaseExecuter.dbExecuteShowAllCredits("select * from (credits inner join banks on (credits.bankId = banks.bankId));");
        }
    }
    public void createCredit() throws SQLException {
        creditsList.addCredit();
    }
    public void createBank(){
        creditsList.setBank();
    }
    public void chooseCredit() throws SQLException {
        biler bil = DatabaseExecuter.dbExecuteSelect(1,"null","select count(*) from credits");
        if(bil.getId() == 0){
            System.out.println("There are no credits to choose from");
        }
        else{
            bil = DatabaseExecuter.dbExecuteSelect(1,"null","select top 1 users.creditId from users");
            if(bil.getId() != 0){
                System.out.println("You already have a credit chosen");
            }
            else{
                System.out.println("Enter credit id to choose: ");
                int temp = scan.nextInt();
                biler bal = DatabaseExecuter.dbExecuteSelect(1,"null","select userBalance from users where userId=1;");
                biler res = DatabaseExecuter.dbExecuteSelect(1,"null","SELECT TOP 1 credits.creditId FROM credits WHERE credits.creditId = "+temp+";");
                while(res.getId() == 0){
                    System.out.println("Credit was not found, please try again");
                    System.out.print("\nEnter credit id to choose: ");
                    temp = scan.nextInt();
                    res = DatabaseExecuter.dbExecuteSelect(1,"null","SELECT TOP 1 credits.creditId FROM credits WHERE credits.creditId = "+temp+";");
                }
                res = DatabaseExecuter.dbExecuteSelect4("MoneyGiven","creditId","months","moneyToGive","select top 1 * from credits where creditId = "+temp+";");
                int newUserBalance = bal.getId() + res.getId();
                DatabaseExecuter.dbExecute("update users set userBalance="+newUserBalance+",creditId="+res.getId1()+",creditTime="+res.getId2()+",userRepay="+res.getId3()+" where userId = 1;");
            }
        }
    }
    public void extendCreditLine() throws SQLException {
        biler user = DatabaseExecuter.dbExecuteSelect4("userBalance","creditId","extendedLine","userRepay","select * from users where userId = 1");
        biler credit = DatabaseExecuter.dbExecuteSelect8("creditId","moneyGiven","percentage","months","moneyToGive","creditLineExtendable","maxExtendableMoney","extendedPercentage", "select * from credits where creditId="+user.getId1()+";");
        if(user.getId1() == 0){
            System.out.println("You don't have any credits active");
        }
        else if(credit.getId5() == 0){
            System.out.println("The credit line you've chosen can't be extended");
        }
        else if(user.getId2() == 1){
            System.out.println("You've already extended your credit line");
        }
        else{
            System.out.println("Max: " + credit.getId6()+"$");
            System.out.println("(Percentage these money will be counted on: "+credit.getId7()+"%)");
            int temp = scan.nextInt();
            while(temp > credit.getId6()){
                System.out.println("Money amount exceeds max line");
                temp = scan.nextInt();
            }
            int f = user.getId3() + temp + (temp * credit.getId7())/100;
            int newUserBalance = user.getId() + temp;
            //user.setUserRepay(f);
            //user.setUserBalance(user.getUserBalance()+temp);
            //user.setExtendedLine(true);
            DatabaseExecuter.dbExecute("update users set userBalance="+newUserBalance+",userRepay="+f+",extendedLine=1 where userId = 1;");
        }
    }
    public void pay() throws SQLException {
        biler res = DatabaseExecuter.dbExecuteSelect(1, "null","select userRepay from users where userId = 1");
        if(res.getId()<=0){
            System.out.println("You don't have to repay any credits");
        }
        else{
            res = DatabaseExecuter.dbExecuteSelect4("userBalance","creditId","creditTime","userRepay","select * from users where userId = 1");
            System.out.println("Enter amount to repay(Debt: "+res.getId3()+" | Balance: "+res.getId()+"): ");
            int temp = scan.nextInt();
            while(temp > res.getId()){
                System.out.println("Not enough money on balance");
                temp = scan.nextInt();
            }
            if(res.getId3()>temp){
                int temp1 = res.getId3()-temp;
                int temp2 = res.getId()-temp;
                DatabaseExecuter.dbExecute("update users set userBalance="+temp2+",userRepay="+temp1+" where userId=1;");
            }
            else if(res.getId3()<=temp){
                int te = temp - res.getId3();
                int newUserBalance = (res.getId() - temp) + te;
                DatabaseExecuter.dbExecute("update users set userBalance="+newUserBalance+",creditId=0,creditTime=0,userRepay=0, extendedLine=0 where userId=1;");
            }
        }
    }
    public void showCreditsFilter() throws SQLException {
        biler res = DatabaseExecuter.dbExecuteSelect(1,"null","SELECT COUNT(*) as total FROM credits;");
        if(res.getId() == 0){
            System.out.println("There are no credits to show");
        }
        else{
            System.out.println("Min amount of money given: ");
            int minTemp = scan.nextInt();
            System.out.println("Max amount of money given: ");
            int maxTemp = scan.nextInt();
            DatabaseExecuter.dbExecuteShowFilter("select * from credits where moneyGiven<"+maxTemp+" and moneyGiven>"+minTemp+";");
        }
    }
    public void deposit() throws SQLException {
        biler res = DatabaseExecuter.dbExecuteSelect4("userBalance","creditId","creditTime","userRepay","select * from users where userId = 1");
        System.out.println("Enter the amount to add (Debt: "+res.getId3()+" | Balance: "+res.getId()+"): ");
        int temp = scan.nextInt();
        int newUserBalance = res.getId() + temp;
        DatabaseExecuter.dbExecute("update users set userBalance="+newUserBalance+"where userId = 1;");
    }

    public void displayInfo() throws SQLException {
        biler res = DatabaseExecuter.dbExecuteSelect4("userBalance", "creditId", "creditTime", "userRepay", "select * from users where userId = 1");
        System.out.println("User info:\nUser balance: " + res.getId() + "$\nCredit id: " + res.getId1() + "\nMonths to repay: " + res.getId2() + "\nDebt: " + res.getId3() + "$\n");
    }
}
