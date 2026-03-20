package service;

import model.Task;
import repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(String name){
        if(name.length() <= 3 || name.length() > 60) {
            System.out.println("Nome da nova tarefa incompatível. Nomes precisam ter entre 4 a 60 caracteres");
            return;
        }
        taskRepository.createTask(name);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(int id){
        return taskRepository.findById(id);
    }

    public void updateTask(int id, String newName) {
        taskRepository.updateTask(id, newName);
    }

    public void deleteTask(int id) {
        taskRepository.deleteTask(id);
    }

}
