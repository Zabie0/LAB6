package org.Credits.Command;

import org.Credits.BankInfo.BankCredit;

public class ShowCreditsListCommand implements Command{
    BankCredit list;
    public ShowCreditsListCommand(BankCredit list) {
        this.list = list;
    }
    @Override
    public void execute() {
        try {list.showCreditsList();}
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
