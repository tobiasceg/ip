import org.w3c.dom.ls.LSInput;

import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String intro = " ____________________________________________________________\n" +
                " Hello! I'm Duke the repeat bot\n" +
                " What can I do for you?\n" +
                " type \"bye\" after you are done having fun!\n" +
                " ____________________________________________________________";
        System.out.println(intro);

        String reply;
        Scanner scan = new Scanner(System.in);

        while(true) {
            reply = scan.nextLine();

            if (reply.equals("bye")) {
                System.out.println(" ____________________________________________________________\n" +
                        " Bye. Hope to see you again soon!\n" +
                        " ____________________________________________________________\n");
                break;
            }
            else {
                System.out.println(" ____________________________________________________________\n" +
                        " " + reply + "\n" +
                        " ____________________________________________________________");
            }
        }
    }
}
