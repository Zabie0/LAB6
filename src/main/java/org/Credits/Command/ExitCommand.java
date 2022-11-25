package org.Credits.Command;

public class ExitCommand implements Command{
    @Override
    public void execute() {
        System.out.println("Shut down");
        System.exit(0);
    }
}
