import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        introMessage();

        String reply;
        Scanner scan = new Scanner(System.in);

        // Array of the Task class objects
        Task[] list = new Task[100];

        int listCounter = 0;
        int taskFlag = 0; // Flag to see which command triggers the exception StringIndexOut....

        String taskName;
        String dueDate;

        int TODO_REMOVAL = 5;
        int DEADLINE_REMOVAL = 9;
        int EVENT_REMOVAL = 6;

        while (true) {
            reply = scan.nextLine();
            try {
                if (reply.equals("bye")) {
                    outroMessage();
                    break;
                } else if (reply.equals("list")){
                    printList(list, listCounter);
                } else if (reply.contains("done")) {
                    for (int j = 1; j <= listCounter; j++) {
                        if (reply.contains(Integer.toString(j))) { //finding out the task that is chosen
                            list[j - 1].markAsDone(); // minus 1 coz the array of Task is 1 digit ahead
                            break;
                        }
                    }
                } else if (reply.contains("todo")) {
                    taskFlag = 1;
                    taskName = reply.substring(TODO_REMOVAL);
                    emptyChecker(taskName,taskFlag);
                    Todo newTask = new Todo(taskName);
                    listCounter = addedList(list, listCounter, newTask);
                } else if (reply.contains("deadline")) {
                    taskFlag = 2;
                    taskName = reply.substring(DEADLINE_REMOVAL, reply.indexOf("/") - 1);
                    emptyChecker(taskName,taskFlag);
                    dueDate = reply.substring(reply.indexOf("/by") + 4);
                    Deadline newTask = new Deadline(taskName, dueDate);
                    listCounter = addedList(list, listCounter, newTask);
                } else if (reply.contains("event")) {
                    taskFlag = 3;
                    taskName = reply.substring(EVENT_REMOVAL, reply.indexOf("/") - 1);
                    emptyChecker(taskName,taskFlag);
                    dueDate = reply.substring(reply.indexOf("/at") + 4);
                    Event newTask = new Event(taskName, dueDate);
                    listCounter = addedList(list, listCounter, newTask);
                } else throw new UnknownCommand();
            } catch ( UnknownCommand e) { // don't understand the command
                unknownMessage();
            } catch ( emptyToDo e) { // spacing
                emptyToDoMessage();
            } catch ( emptyEvent e) { // spacing
                emptyEventMessage();
            } catch ( emptyDeadline e) { // spacing
                emptyDeadlineMessage();
            } catch ( StringIndexOutOfBoundsException e ) { // no spacing
                if (taskFlag == 1){
                    emptyToDoMessage();
                }else if (taskFlag == 2){
                    emptyDeadlineMessage();
                }else {
                    emptyEventMessage();
                }
            }
        }
    }

    public static void emptyChecker(String taskName,int taskFlag) throws emptyToDo,emptyDeadline,emptyEvent{
        if (taskName.equals("") && taskFlag == 1){
            throw new emptyToDo();
        }else if ( taskName.equals("") && taskFlag == 2){
            throw new emptyDeadline();
        } else if ( taskName.equals("") && taskFlag == 3 ){
            throw new emptyEvent();
        }
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
