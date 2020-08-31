public class Task {
    protected String description;
    protected boolean isDone;

    protected static int numberOfTasks = 0; //class-level member

    public Task(String description) {
        this.description = description;
        this.isDone = false;

        numberOfTasks++;
    }

    public String checkStatus() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    //going to be overloaded by subclasses
    @Override
    public String toString(){ //returning the task only with status box
        return "[" + this.checkStatus() + "] " + this.description;
    }

    public void markAsDone(){
        if (!isDone){   //checking if isDone is false?
            isDone = true;
            System.out.println(" ____________________________________________________________");
            System.out.println(" Nice! I've marked this task as done:");
            System.out.println("  [" + checkStatus() + "] "+ description);
        } else{
            System.out.println(" ____________________________________________________________");
            System.out.println(" You have already finished the task!");
        }
        System.out.println(" ____________________________________________________________");
    }

    public void added(Task addedTask){
        System.out.println(" ____________________________________________________________\n" +
                "Got it. I've added this task:\n" +
                 addedTask.toString() + "\n" +
                "Now you have " + numberOfTasks + " tasks in the list\n" +
                " ____________________________________________________________");
    }
}
