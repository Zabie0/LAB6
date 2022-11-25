package org.Credits.Command;

import org.Credits.BankInfo.BankCredit;

public class AddCreditCommand implements Command{
    BankCredit list;
    public AddCreditCommand(BankCredit list) {
        this.list = list;
    }
    @Override
    public void execute() {
        try {list.createCredit();}
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

