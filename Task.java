package Projects.ToDoList;

public class Task {

    private final String name;
    private boolean Completed;

    public Task(String name) {
        this.name = name;
        this.Completed = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return Completed;
    }

    public void markCompleted() {
        Completed = true;
    }

    @Override
    public String toString() {
        return name + (Completed ? "(✅Completed)" : "(⏳Pending)");
    }

}
