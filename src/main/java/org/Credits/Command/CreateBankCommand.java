package org.Credits.Command;

import org.Credits.BankInfo.BankCredit;

public class CreateBankCommand implements Command{
    BankCredit list;
    public CreateBankCommand(BankCredit list) {
        this.list = list;
    }
    @Override
    public void execute() {
        list.createBank();
    }
}
