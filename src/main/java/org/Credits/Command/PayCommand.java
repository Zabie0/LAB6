package org.Credits.Command;

import org.Credits.BankInfo.BankCredit;

public class PayCommand implements Command{
    BankCredit list;
    public PayCommand(BankCredit list) {
        this.list = list;
    }
    @Override
    public void execute() {
        try {list.pay();}
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
