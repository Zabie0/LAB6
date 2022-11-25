package org.Credits.Command;

import org.Credits.BankInfo.BankCredit;

public class ExtendCreditLineCommand implements Command{
    BankCredit list;
    public ExtendCreditLineCommand(BankCredit list) {
        this.list = list;
    }
    @Override
    public void execute() {
        try {list.extendCreditLine();}
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
