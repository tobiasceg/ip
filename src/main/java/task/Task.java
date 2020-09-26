package task;

/**
 * The class Task which is the parent class
 * Contains the base attributes and methods of its child classes
 * Todo,Event and Deadline
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Instantiates a new Task, where
     * isDone  whether the task is complete, which is default false
     *
     * @param description the name of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Checks the completion status of the task
     * gets check/cross string based on isDone
     *
     * @return the task completion status
     */
    public String checkStatus() {
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Outputs a string of the Task in a fixed format
     *
     * @return a string that displays the task's completion status and name
     */
    @Override
    public String toString(){
        return "[" + this.checkStatus() + "] " + this.description;
    }

    /**
     * set the boolean to true, completion of the task
     *
     * @param rebootFlag 1 to print message to user, 0 is without
     */
    public void markAsDone(int rebootFlag){

        if (!isDone){   //checking if isDone is false?
            isDone = true;
            if ( rebootFlag == 1) {
                printLine();
                System.out.println(" Nice! I've marked this task as done:");
                System.out.println("  [" + checkStatus() + "] " + description);
                printLine();
            }
        } else{
            printLine();
            System.out.println(" You have already finished the task!");
            printLine();
        }
    }

    /**
     *  Method to print a line
     */
    public static void printLine() {
        System.out.println(" ____________________________________________________________");
    }
}
