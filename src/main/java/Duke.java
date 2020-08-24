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

        String[] list = new String[100];
        int listCounter = 0;

        while(true) {
            reply = scan.nextLine();

            if (reply.equals("bye")) {
                System.out.println(" ____________________________________________________________\n" +
                        " Bye. Hope to see you again soon!\n" +
                        " ____________________________________________________________\n");
                break;
            }
            if(reply.equals("list")){
                System.out.print(" ____________________________________________________________\n");
                for ( int i = 1; i <= listCounter ; i++){
                    System.out.println( i + ". " + list[i-1] );
                }
                System.out.println(" ____________________________________________________________\n");
            }
            else {
                list[listCounter] = reply;
                listCounter++;

                System.out.println(" ____________________________________________________________\n" +
                        " added: " + reply + "\n" +
                        " ____________________________________________________________");
            }
        }
    }
}
