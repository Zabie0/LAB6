package org.Credits.User;

import lombok.Data;

@Data
public class User {
    private int userId;
    private int userBalance;
    private int creditId = 0;
    private int creditTime;
    private int userRepay = 0;
    private boolean extendedLine = false;

    @Override
    public String toString() {
        return  "User balance=" + userBalance + "\n" +
                "Credit id=" + creditId + "\n" +
                "Credit time=" + creditTime + " months\n" +
                "User repay=" + userRepay + "\n" +
                "Has extended credit line=" + extendedLine;
    }
}
