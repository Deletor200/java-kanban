public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        Task task1 = new Task(0, "Купить продукты", "Купить молоко и хлеб", Status.NEW);
        Task task2 = new Task(0, "Сделать уборку", "Пропылесосить комнату", Status.NEW);
        manager.addTask(task1);
        manager.addTask(task2);

        Epic epic1 = new Epic(0, "Переезд", "Переезд в новую квартиру");
        manager.addEpic(epic1);

        Subtask subtask1 = new Subtask(0, "Собрать вещи", "Упаковать все вещи в коробки", Status.NEW, epic1.getId());
        Subtask subtask2 = new Subtask(0, "Нанять грузчиков", "Найти компанию для перевозки", Status.NEW, epic1.getId());
        manager.addSubtask(subtask1);
        manager.addSubtask(subtask2);

        Epic epic2 = new Epic(0, "Подготовка к экзамену", "Подготовиться к финальному экзамену");
        manager.addEpic(epic2);

        Subtask subtask3 = new Subtask(0, "Прочитать материалы", "Изучить все лекции и заметки", Status.NEW, epic2.getId());
        manager.addSubtask(subtask3);

        System.out.println("Все задачи:");
        System.out.println(manager.getAllTasks());

        System.out.println("\nВсе эпики:");
        System.out.println(manager.getAllEpics());

        System.out.println("\nВсе подзадачи:");
        System.out.println(manager.getAllSubtasks());

        task1.setStatus(Status.DONE);
        manager.updateTask(task1);

        subtask1.setStatus(Status.IN_PROGRESS);
        manager.updateSubtask(subtask1);

        subtask2.setStatus(Status.DONE);
        manager.updateSubtask(subtask2);

        subtask3.setStatus(Status.DONE);
        manager.updateSubtask(subtask3);

        System.out.println("\nОбновленные задачи:");
        System.out.println(manager.getAllTasks());

        System.out.println("\nОбновленные эпики:");
        System.out.println(manager.getAllEpics());

        manager.removeTaskById(task2.getId());
        manager.removeEpicById(epic2.getId());

        System.out.println("\nПосле удаления:");
        System.out.println("Все задачи:");
        System.out.println(manager.getAllTasks());

        System.out.println("\nВсе эпики:");
        System.out.println(manager.getAllEpics());
    }
}