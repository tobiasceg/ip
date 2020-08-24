import org.w3c.dom.ls.LSInput;

import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String intro = " ____________________________________________________________\n" +
                " Hello! I'm Duke the list bot\n" +
                " Please list down your plans for today?\n" +
                " type \"list\" to see the current list!\n" +
                " type \"bye\" after you are done!\n" +
                " ____________________________________________________________";
        System.out.println(intro);

        String reply;
        Scanner scan = new Scanner(System.in);

        Task[] list = new Task[100];

        int listCounter = 0;

        while(true) {
            reply = scan.nextLine();

            if (reply.equals("bye")) {
                System.out.println(" ____________________________________________________________\n" +
                        " Bye. Hope to see you again soon!\n" +
                        " ____________________________________________________________\n");
                break;
            }
            else if (reply.equals("list")){
                System.out.print(" ____________________________________________________________\n");
                for ( int i = 1; i <= listCounter ; i++){
                    System.out.println( i + ".[" + list[i-1].checkStatus() + "] " + list[i-1].description );
                }
                System.out.println(" ____________________________________________________________\n");
            }
            else if (reply.contains("done")){
                for (int j = 1; j <= listCounter ; j++){
                    if (reply.contains(Integer.toString(j))){ //finding out the task that is chosen
                        list[j-1].markAsDone(); // minus 1 coz the array of Task is 1 digit ahead
                    }
                }
            }
            else {
                Task t = new Task(reply); //initialising the new task
                list[listCounter] = t; //adding task to the list
                listCounter++; //counter to keep track of number of tasks

                System.out.println(" ____________________________________________________________\n" +
                        " added: " + reply + "\n" +
                        " ____________________________________________________________");
            }
        }
    }
}
