package service;

import model.Task;
import repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(String name){
        if((name == null) || (name.length() <= 3 || name.length() > 60)) {
            System.out.println("Nome da nova tarefa incompatível. Nomes precisam ter entre 4 a 60 caracteres");
            return;
        }
        taskRepository.createTask(name);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(int id){
        try {
            Objects.checkIndex(id-1, taskRepository.findAll().size());
            System.out.println("Buscando tarefa " + id + " nas tarefas cadastradas");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Código inválido: " + e.getMessage());
        }
        return taskRepository.findById(id);
    }

    public void updateTask(int id, String newName) {
        try {
            Objects.checkIndex(id-1, taskRepository.findAll().size());
            System.out.println("Buscando tarefa " + id + " nas tarefas cadastradas");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Código inválido: " + e.getMessage());
        }
        taskRepository.updateTask(id, newName);
    }

    public void deleteTask(int id) {
        try {
            Objects.checkIndex(id-1, taskRepository.findAll().size());
            System.out.println("Buscando tarefa " + id + " nas tarefas cadastradas");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Código inválido: " + e.getMessage());
        }
        taskRepository.deleteTask(id);
    }

}
