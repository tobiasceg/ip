package Command;

public abstract class Command {
    public abstract void execute();
    public static void printLine(){
        System.out.println(" ____________________________________________________________");
    }
}
