package task;

public class Event extends Task {

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override // calls Task's toString
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}