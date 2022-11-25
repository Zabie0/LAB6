package org.Credits.Command;

import org.Credits.BankInfo.BankCredit;

public class ShowAllBanksCommand implements Command{
    BankCredit list;
    public ShowAllBanksCommand(BankCredit list) {
        this.list = list;
    }
    @Override
    public void execute() {
        try {list.showAllBanks();}
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
