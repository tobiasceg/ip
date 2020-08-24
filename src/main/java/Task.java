public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String checkStatus() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone(){
        if (!isDone){   //checking if isDone is false?
            isDone = true;
            System.out.println(" ____________________________________________________________\n");
            System.out.println(" Nice! I've marked this task as done:\n");
            System.out.println("  [" + checkStatus() + "] "+ description);
            System.out.println(" ____________________________________________________________\n");
        }
        else{
            System.out.println(" ____________________________________________________________\n");
            System.out.println(" You have already finished the task!");
            System.out.println(" ____________________________________________________________\n");
        }
    }
}
