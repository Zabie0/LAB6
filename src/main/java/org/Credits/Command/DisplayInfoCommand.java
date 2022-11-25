package org.Credits.Command;

import org.Credits.BankInfo.BankCredit;

public class DisplayInfoCommand implements Command{
    BankCredit list;
    public DisplayInfoCommand(BankCredit list) {
        this.list = list;
    }
    @Override
    public void execute() {
        try {list.displayInfo();}
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
