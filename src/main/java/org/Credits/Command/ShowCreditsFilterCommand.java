package org.Credits.Command;

import org.Credits.BankInfo.BankCredit;

public class ShowCreditsFilterCommand implements Command{
    BankCredit list;
    public ShowCreditsFilterCommand(BankCredit list) {
        this.list = list;
    }
    @Override
    public void execute() {
        try {list.showCreditsFilter();}
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
