package task;

import java.util.ArrayList;

/**
 * TaskList class handles all output and listing
 * out of all the tasks the user inputs.
 *
 * All tasks are stored inside an ArrayList list
 */
public abstract class TaskList extends ArrayList<Task> {

    /**
     * Prints the full list of task out for the user
     *
     * @param list the arraylist to be printed out
     */
    public static void printList(ArrayList<Task> list) {
        printLine();
        System.out.println("Here are the tasks in your list:");
        for (Task i : list){
            System.out.println( (list.indexOf(i)+1) + "." + i.toString() );
        }
        printLine();
    }

    /**
     * Adds the task input by the user , newTask into the array
     *
     * @param list arraylist to be added to
     * @param newTask the input task by to be added
     * @param rebootFlag flag to choose if print message is to be displayed
     */
    public static void addedList(ArrayList<Task> list, Task newTask, int rebootFlag) {
        list.add(newTask);
        if(rebootFlag == 1) {
            added(newTask, list.size());
        }
    }

    /**
     * Prints the output message when a task is a successfully added
     *
     * @param addedTask task that was added to arraylist
     * @param listCounter The current number of task in the arraylist
     */
    public static void added(Task addedTask, int listCounter){
        printLine();
        System.out.println(
                "Got it. I've added this task:\n" +
                addedTask.toString() + "\n" +
                "Now you have " + listCounter + " tasks in the list");
        printLine();
    }

    /**
     * Prints the output message when a task is a successfully deleted
     *
     * @param deletedTask task that was deleted in arraylist
     * @param listCounter the current number of task in the arraylist
     */
    public static void printDelete(Task deletedTask, int listCounter) {
        printLine();
        System.out.println("Noted. I've removed this task:");
        System.out.println(deletedTask.toString());
        System.out.println("Now you have "+ listCounter +" task in this list");
        printLine();
    }

    public static void printLine() {
        System.out.println(" ____________________________________________________________");
    }

    public static void printSearchList(ArrayList<Task> searchResults) {
        printLine();
        System.out.println("Here are the matching tasks in your list:");
        for (Task j: searchResults){
            System.out.println((searchResults.indexOf(j)+1)+"."+j);
        }
        printLine();
    }
}
