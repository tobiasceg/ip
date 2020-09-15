import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;

public class Duke {
    public static void main(String[] args){
        introMessage();

        String reply;
        Scanner scan = new Scanner(System.in);

        String dukeHome = System.getProperty("user.dir");
        Path dukeLocation = Paths.get(dukeHome, "data", "duke.txt");

        // Array of the Task class objects
        ArrayList<Task> list = new ArrayList<>();
        ArrayList<String> listText = new ArrayList<>();


        int listCounter = 0;
        int taskFlag = 0; // Flag to see which command triggers the exception StringIndexOut....

        String taskName;
        String dueDate;

        int TODO_REMOVAL = 5;
        int DEADLINE_REMOVAL = 9;
        int EVENT_REMOVAL = 6;
        int STATUS_REMOVAL = 7;

        try {
            File dukeFile = new File(String.valueOf(dukeLocation));
            Scanner myReader = new Scanner(dukeFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.startsWith("[T]")) {
                    taskName = data.substring(STATUS_REMOVAL);
                    Todo newTask = new Todo(taskName);
                    listCounter = addedList(list, listCounter, newTask, 0);
                    if (data.contains("\u2713")) {
                        newTask.markAsDone(0);
                    }
                } else if (data.contains("[E]")){
                    taskName = data.substring(STATUS_REMOVAL, data.indexOf("(") - 1);
                    dueDate = data.substring(data.indexOf(":") + 2,data.indexOf(")"));
                    Event newTask = new Event(taskName, dueDate);
                    listCounter = addedList(list, listCounter, newTask,0);
                    if (data.contains("\u2713")) {
                        newTask.markAsDone(0);
                    }
                } else if (data.contains("[D]")){
                    taskName = data.substring(STATUS_REMOVAL, data.indexOf("(") - 1);
                    dueDate = data.substring(data.indexOf(":") + 2,data.indexOf(")"));
                    Deadline newTask = new Deadline(taskName, dueDate);
                    listCounter = addedList(list, listCounter, newTask,0);
                    if (data.contains("\u2713")) {
                        newTask.markAsDone(0);
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            printMissingFileMessage();
        }

        while (true) {
            reply = scan.nextLine();
            try {
                if (reply.equals("bye")) {
                    outroMessage();
                    break;
                } else if (reply.equals("list")){
                    printList(list);
                } else if (reply.contains("done")) {
                    for (int j = 1; j <= listCounter; j++) {
                        if (reply.contains(Integer.toString(j))) { //finding out the task that is chosen
                            list.get(j - 1).markAsDone(1); // minus 1 coz the array of Task is 1 digit ahead , rebootFlag = 1 means reboot done alr
                             //scanningTextFile(j,dukeLocation);
                            listText.set(j-1, String.valueOf(list.get(j-1)));
                            break;
                        }
                    }
                } else if (reply.contains("delete")) {
                    for (int j = 1; j <= listCounter; j++) {
                        if (reply.contains(Integer.toString(j))) { //finding out the task that is chosen
                            listCounter--;
                            printDelete(list.get(j-1),listCounter);
                            list.remove(j-1); // minus 1 coz the array of Task is 1 digit ahead
                            listText.remove(j-1);
                            break;
                        }
                    }
                } else if (reply.contains("todo")) {
                    taskFlag = 1;
                    taskName = reply.substring(TODO_REMOVAL);
                    emptyChecker(taskName,taskFlag);
                    Todo newTask = new Todo(taskName);
                    listCounter = addedList(list, listCounter, newTask,1);
                    listText.add(newTask.toString());

                } else if (reply.contains("deadline")) {
                    taskFlag = 2;
                    taskName = reply.substring(DEADLINE_REMOVAL, reply.indexOf("/") - 1);
                    emptyChecker(taskName,taskFlag);
                    dueDate = reply.substring(reply.indexOf("/by") + 4);
                    Deadline newTask = new Deadline(taskName, dueDate);
                    listCounter = addedList(list, listCounter, newTask,1);
                    listText.add(newTask.toString());

                } else if (reply.contains("event")) {
                    taskFlag = 3;
                    taskName = reply.substring(EVENT_REMOVAL, reply.indexOf("/") - 1);
                    emptyChecker(taskName,taskFlag);
                    dueDate = reply.substring(reply.indexOf("/at") + 4);
                    Event newTask = new Event(taskName, dueDate);
                    listCounter = addedList(list, listCounter, newTask,1);
                    listText.add(newTask.toString());

                } else {
                    throw new UnknownCommand();
                }
                FileWriter fw = new FileWriter(dukeLocation.toString());
                for(String i: listText) {
                    fw.write(i + "\n");
                }
                fw.close();
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
            } catch (IOException e) {
                printMissingFileMessage();
            }
        }
    }

    public static void printMissingFileMessage() {
        printLine();
        System.out.println("The File is missing");
        printLine();
    }


    private static void printDelete(Task deletedTask,int listCounter) {
        printLine();
        System.out.println("Noted. I've removed this task:");
        System.out.println(deletedTask.toString());
        System.out.println("Now you have "+ listCounter +" task in this list");
        printLine();
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

    public static void printList(ArrayList<Task> list) {
        printLine();
        System.out.println("Here are the tasks in your list:");
        for (Task i : list){
            System.out.println( (list.indexOf(i)+1) + "." + i.toString());
        }
        printLine();
    }

    public static int addedList(ArrayList<Task> list, int listCounter, Task newTask,int rebootFlag) {
        list.add(newTask);
        listCounter++;
        if(rebootFlag == 1) {
            added(newTask, listCounter);
        }
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
