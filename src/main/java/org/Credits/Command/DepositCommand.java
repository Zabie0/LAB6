package org.Credits.Command;

import org.Credits.BankInfo.BankCredit;

public class DepositCommand implements Command{
    BankCredit list;
    public DepositCommand(BankCredit list) {
        this.list = list;
    }
    @Override
    public void execute() {
        try {list.deposit();}
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
