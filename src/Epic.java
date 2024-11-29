import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Epic extends Task {
    private final List<Integer> subtaskIds;

    public Epic(int id, String name, String description) {
        super(id, name, description, Status.NEW);
        this.subtaskIds = new ArrayList<>();
    }

    public List<Integer> getSubtaskIds() {
        return subtaskIds;
    }

    public void addSubtask(int subtaskId) {
        subtaskIds.add(subtaskId);
    }

    public void updateStatus(Map<Integer, Subtask> subtasks) {
        if (subtaskIds.isEmpty()) {
            status = Status.NEW;
            return;
        }

        boolean allNew = true;
        boolean allDone = true;

        for (Integer subtaskId : subtaskIds) {
            Subtask subtask = subtasks.get(subtaskId);
            if (subtask == null) continue;

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
                ", подзадачи=" + subtaskIds +
                '}';
    }
}