package repository;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private List<Task> tasks;
    private int nextId = 0;

    public TaskRepository() {
        this.tasks = new ArrayList<>();
    }

    public void createTask(String name){
        this.tasks.add(new Task(this.nextId++, name));
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Task findById(int id){
        return this.tasks.get(id-1);
    }

    public void updateTask(int id, String newName) {
        this.tasks.get(id-1).setName(newName);
    }

    public void deleteTask(int id) {
        this.tasks.remove(id-1);
    }
}
