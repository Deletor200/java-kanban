public class Subtask extends Task {
    private int epicId;

    public Subtask(int id, String name, String description, Status status, int epicId) {
        super(id, name, description, status);
        this.epicId = epicId;
    }

    public int getEpicId() { return epicId; }

    @Override
    public String toString() {
        return "Subtask{" +
                "id=" + id +
                ", название='" + name + '\'' +
                ", описание='" + description + '\'' +
                ", статус=" + status +
                ", epicId=" + epicId +
                '}';
    }
}