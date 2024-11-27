import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private List<Subtask> subtasks;

    public Epic(int id, String name, String description) {
        super(id, name, description, Status.NEW);
        this.subtasks = new ArrayList<>();
    }

    public List<Subtask> getSubtasks() { return subtasks; }
    public void addSubtask(Subtask subtask) { subtasks.add(subtask); }
    public void removeSubtask(Subtask subtask) { subtasks.remove(subtask); }

    public void updateStatus() {
        if (subtasks.isEmpty()) {
            status = Status.NEW;
            return;
        }

        boolean allNew = true;
        boolean allDone = true;

        for (Subtask subtask : subtasks) {
            if (subtask.getStatus() != Status.NEW) {
                allNew = false;
            }
            if (subtask.getStatus() != Status.DONE) {
                allDone = false;
            }
        }

        if (allNew) {
            status = Status.NEW;
        } else if (allDone) {
            status = Status.DONE;
        } else {
            status = Status.IN_PROGRESS;
        }
    }

    @Override
    public String toString() {
        return "Epic{" +
                "id=" + id +
                ", название='" + name + '\'' +
                ", описание='" + description + '\'' +
                ", статус=" + status +
                ", подзадачи=" + subtasks +
                '}';
    }
}