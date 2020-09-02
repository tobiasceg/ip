public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override //calls Task's toString
    public String toString() {
        return "[T]" + super.toString();
    }
}
