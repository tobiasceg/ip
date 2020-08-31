import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String INTRO_MESSAGE = " ____________________________________________________________\n" +
                " Hello! I'm Duke the list bot\n" +
                " Please list down your plans for today...\n" +
                " type \"list\" to see the current list!\n" +
                " type \"bye\" after you are done!\n" +
                " ____________________________________________________________";
        System.out.println(INTRO_MESSAGE);

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
                System.out.println(" ____________________________________________________________\n" +
                        " Bye. Hope to see you again soon!\n" +
                        " ____________________________________________________________\n");
                break;
            } else if (reply.equals("list")){
                System.out.print(" ____________________________________________________________\n" +
                        "Here are the tasks in your list:\n");
                for ( int i = 1; i <= listCounter ; i++){
                    System.out.println( i + "." + list[i-1].toString());
                }
                System.out.println(" ____________________________________________________________\n");
            } else if (reply.contains("done")){
                for (int j = 1; j <= listCounter ; j++){
                    if (reply.contains(Integer.toString(j))){ //finding out the task that is chosen
                        list[j-1].markAsDone(); // minus 1 coz the array of Task is 1 digit ahead
                    }
                }
            } else if (reply.contains("todo")){
                taskName = reply.substring(TODO_REMOVAL);
                Todo newTask = new Todo(taskName);
                list[listCounter] = newTask; //added to the task list
                listCounter++;
                newTask.added(newTask); //output of the added message
            } else if (reply.contains("deadline")){
                taskName = reply.substring(DEADLINE_REMOVAL,reply.indexOf("/") - 1);
                dueDate = reply.substring(reply.indexOf("/by") + 4);
                Deadline newTask = new Deadline(taskName,dueDate);
                list[listCounter] = newTask;
                listCounter++;
                newTask.added(newTask);
            } else if (reply.contains("event")){
                taskName = reply.substring(EVENT_REMOVAL,reply.indexOf("/") - 1);
                dueDate = reply.substring(reply.indexOf("/at") + 4);
                Event newTask = new Event(taskName,dueDate);
                list[listCounter] = newTask;
                listCounter++;
                newTask.added(newTask);
            } else System.out.println(" ____________________________________________________________\n" +
                    "Missing Todo, Event or Deadline! \n" +
                    " ____________________________________________________________");
        }
    }
}
