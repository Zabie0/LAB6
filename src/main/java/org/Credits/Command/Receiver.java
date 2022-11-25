package org.Credits.Command;

import org.Credits.BankInfo.BankCredit;

import java.util.ArrayList;
import java.util.List;
public class Receiver {
    private final List<Command> commandList = new ArrayList<>();
    private final BankCredit list;
    public Receiver(BankCredit list){
        this.list = list;
        addCommands();
    }
    public void run(int index){
        commandList.get(index).execute();
    }

    public void addCommands(){
        commandList.add(new AddCreditCommand(list));
        commandList.add(new ChooseCreditCommand(list));
        commandList.add(new ExtendCreditLineCommand(list));
        commandList.add(new PayCommand(list));
        commandList.add(new ShowCreditsFilterCommand(list));
        commandList.add(new ShowCreditsListCommand(list));
        commandList.add(new DepositCommand(list));
        commandList.add(new DisplayInfoCommand(list));
        commandList.add(new ShowAllBanksCommand(list));
        commandList.add(new CreateBankCommand(list));
        commandList.add(new ExitCommand());
    }
}
