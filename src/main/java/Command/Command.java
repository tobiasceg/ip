package Command;

/**
 * Parent Class Command for all the different commands
 * available to the user
 */
public abstract class Command {
    public abstract void execute();
    public static void printLine(){
        System.out.println(" ____________________________________________________________");
    }
}
