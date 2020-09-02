import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        introMessage();

        String reply;
        Scanner scan = new Scanner(System.in);

        // Array of the Task class objects
        Task[] list = new Task[100];

        int listCounter = 0;

        String taskName;
        String dueDate;

        int TODO_REMOVAL = 5;
        int DEADLINE_REMOVAL = 9;
        int EVENT_REMOVAL = 6;

        while (true) {
            reply = scan.nextLine();

            if (reply.equals("bye")) {
                outroMessage();
                break;
            } else if (reply.equals("list")){
                printList(list, listCounter);
            } else if (reply.contains("done")){
                for (int j = 1; j <= listCounter ; j++){
                    if (reply.contains(Integer.toString(j))){ //finding out the task that is chosen
                        list[j-1].markAsDone(); // minus 1 coz the array of Task is 1 digit ahead
                    }
                }
            } else if (reply.contains("todo")){
                taskName = reply.substring(TODO_REMOVAL);
                Todo newTask = new Todo(taskName);
                listCounter = addedList(list, listCounter, newTask);
            } else if (reply.contains("deadline")){
                taskName = reply.substring(DEADLINE_REMOVAL,reply.indexOf("/") - 1);
                dueDate = reply.substring(reply.indexOf("/by") + 4);
                Deadline newTask = new Deadline(taskName,dueDate);
                listCounter = addedList(list, listCounter, newTask);
            } else if (reply.contains("event")){
                taskName = reply.substring(EVENT_REMOVAL,reply.indexOf("/") - 1);
                dueDate = reply.substring(reply.indexOf("/at") + 4);
                Event newTask = new Event(taskName,dueDate);
                listCounter = addedList(list, listCounter, newTask);
            } else {
                unknownCommand();
            }
        }
    }

    public static void printList(Task[] list, int listCounter) {
        printLine();
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i <= listCounter; i++){
            System.out.println( i + "." + list[i-1].toString());
        }
        printLine();
    }

    public static int addedList(Task[] list, int listCounter, Task newTask) {
        list[listCounter] = newTask;
        listCounter++;
        added(newTask,listCounter);
        return listCounter;
    }

    public static void added(Task addedTask,int listCounter){
        System.out.println(" ____________________________________________________________\n" +
                "Got it. I've added this task:\n" +
                addedTask.toString() + "\n" +
                "Now you have " + listCounter + " tasks in the list\n" +
                " ____________________________________________________________");
    }


    public static void outroMessage() {
        printLine();
        System.out.println(" Bye. Hope to see you again soon!");
        printLine();
    }

    public static void unknownCommand() {
        printLine();
        System.out.println("Missing Todo, Event, Deadline, list or bye! ");
        printLine();
    }

    public static void introMessage() {
        printLine();
        System.out.println(" Hello! I'm Duke the list bot\n" +
                " Please list down your plans for today...\n" +
                " type \"list\" to see the current list!\n" +
                " type \"bye\" after you are done!");
        printLine();
    }

    public static void printLine(){
        System.out.println(" ____________________________________________________________");
    }
}
