package ui;

/**
 * Ui is the class responsible for outputting the respective
 * error messages , intro and outro messages to the user
 *
 */
public abstract class Ui{


    public static void outroMessage() {
        printLine();
        System.out.println(" Bye. Hope to see you again soon!");
        printLine();
    }

    public static void introMessage(){
        printLine();
        System.out.println(" Hello! I'm Duke the list bot\n" +
                " Please list down your plans for today...\n" +
                " For more information on how to use me, check the User Guide!\n" +
                " type \"list\" to see the current list!\n" +
                " type \"bye\" after you are done!");
        printLine();
    }

    public static void printLine(){
        System.out.println(" ____________________________________________________________");
    }


    public static void printMissingFileMessage() {
        printLine();
        System.out.println("The File is missing");
        printLine();
    }

    public static void emptyToDoMessage() {
        printLine();
        System.out.println(" ☹ OOPS!!! The description of a todo cannot be empty.");
        printLine();
    }

    public static void emptyEventMessage() {
        printLine();
        System.out.println(" ☹ OOPS!!! The description of a event cannot be empty.");
        printLine();
    }
    public static void emptyDeadlineMessage() {
        printLine();
        System.out.println(" ☹ OOPS!!! The description of a deadline cannot be empty.");
        printLine();
    }


    public static void unknownMessage() {
        printLine();
        System.out.println(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        printLine();
    }

    public static void incorrectDateFormat() {
        printLine();
        System.out.println("Incorrect Date or DateTime input detected!" +
                "Please follow the format: d-MM-yyyy or d-MM-yyyy HHmm");
        printLine();
    }

    public static void outsideListIndex() {
        printLine();
        System.out.println("Index not found, please recheck the list");
        printLine();
    }
}
