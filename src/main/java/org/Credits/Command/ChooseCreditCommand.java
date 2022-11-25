package org.Credits.Command;

import org.Credits.BankInfo.BankCredit;
import org.Credits.Credit.Credit;

public class ChooseCreditCommand implements Command{
    BankCredit list;
    public ChooseCreditCommand(BankCredit list) {
        this.list = list;
    }
    @Override
    public void execute() {
        try {list.chooseCredit();}
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
