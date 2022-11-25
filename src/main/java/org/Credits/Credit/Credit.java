package org.Credits.Credit;


import lombok.Data;
import org.Credits.DatabaseExecuter;
import org.Credits.User.biler;

import java.sql.SQLException;

@Data
public class Credit {
    protected int creditId;
    protected int moneyGiven;
    protected int percentage;
    protected int months;
    protected int moneyToGive;
    protected boolean creditLineExtendable;
    protected int maxExtendableMoney;
    protected int extendedPercentage;
    protected int bankId;

    @Override
    public String toString() {
        biler res;
        try {
            res = DatabaseExecuter.dbExecuteSelect(1,"name","select * from banks where bankId="+bankId+";");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  "Credit id=" + creditId + "\n" +
                "Money given by the bank=" + moneyGiven +"\n" +
                "Percentage to repay under=" + percentage +"%\n" +
                "Months to repay=" + months +"\n" +
                "Money to repay=" + moneyToGive +"\n" +
                "Is the credit line extendable=" + creditLineExtendable +"\n" +
                "Max money for extended line =" + maxExtendableMoney +"\n" +
                "Percentage for extended line=" + extendedPercentage +"%\n" +
                "Bank=" + res.getName() + "\n";
    }
}
