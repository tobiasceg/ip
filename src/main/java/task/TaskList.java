package task;

import java.util.ArrayList;

public abstract class TaskList extends ArrayList<Task> {


    public static void printList(ArrayList<Task> list) {
        printLine();
        System.out.println("Here are the tasks in your list:");
        for (Task i : list){
            System.out.println( (list.indexOf(i)+1) + "." + i.toString());
        }
        printLine();
    }

    public static void addedList(ArrayList<Task> list, Task newTask,int rebootFlag) {
        list.add(newTask);
        if(rebootFlag == 1) {
            added(newTask, list.size());
        }
    }

    public static void added(Task addedTask,int listCounter){
        printLine();
        System.out.println(
                "Got it. I've added this task:\n" +
                addedTask.toString() + "\n" +
                "Now you have " + listCounter + " tasks in the list");
        printLine();
    }

    public static void printDelete(Task deletedTask,int listCounter) {
        printLine();
        System.out.println("Noted. I've removed this task:");
        System.out.println(deletedTask.toString());
        System.out.println("Now you have "+ listCounter +" task in this list");
        printLine();
    }

    public static void printLine(){
        System.out.println(" ____________________________________________________________");
    }
}
