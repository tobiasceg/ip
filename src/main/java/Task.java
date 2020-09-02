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

    //going to be overloaded by subclasses
    @Override
    public String toString(){ //returning the task only with status box
        return "[" + this.checkStatus() + "] " + this.description;
    }

    public void markAsDone(){
        printLine();
        if (!isDone){   //checking if isDone is false?
            isDone = true;
            System.out.println(" Nice! I've marked this task as done:");
            System.out.println("  [" + checkStatus() + "] "+ description);
        } else{
            System.out.println(" You have already finished the task!");
        }
        printLine();
    }

    public void printLine() {
        System.out.println(" ____________________________________________________________");
    }
}
