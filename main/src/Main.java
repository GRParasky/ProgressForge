import model.Task;
import repository.TaskRepository;
import service.TaskService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean systemRunning = true;
        Scanner scanner = new Scanner(System.in);
        TaskRepository repository = new TaskRepository();
        TaskService service = new TaskService(repository);

        List<Task> tasks = service.findAll();

        while (systemRunning) {
            System.out.println("Bem-vindo ao sistema de tarefas");
            System.out.println("------------\n" +
                    "1 - Adicionar tarefa\n" +
                    "2 - Ler tarefas\n" +
                    "3 - Atualizar tarefa\n" +
                    "9 - Sair\n" +
                    "------------"
            );
            System.out.println("Escolha a opção: ");
            String input = scanner.nextLine();
            int option = Integer.parseInt(input);

            switch(option){
                case 1:
                    System.out.println("Informe a tarefa a ser adicionada: ");
                    String taskName = scanner.nextLine();
                    service.createTask(taskName);
                    break;
                case 2:
                    if(tasks.isEmpty()){
                        System.out.println("Não há nenhuma tarefa salva");
                        break;
                    }
                    for (int index = 0; index < tasks.size(); index++) {
                        int viewIndex = index + 1;
                        System.out.println(viewIndex + " - " + tasks.get(index).getName());
                    }
                    break;
                case 3:
                    if(tasks.isEmpty()){
                        System.out.println("Não há nenhuma tarefa salva");
                        break;
                    }
                    for (int index = 0; index < tasks.size(); index++) {
                        int viewIndex = index + 1;
                        System.out.println(viewIndex + " - " + tasks.get(index).getName());
                    }
                    System.out.println("Informe o número da tarefa a ser atualizada");
                    String indexOfTaskFiltered = scanner.nextLine();
                    int indexOfTaskFilteredConverted = Integer.parseInt(indexOfTaskFiltered);

                    if((indexOfTaskFilteredConverted > tasks.size()) || (indexOfTaskFilteredConverted <= 0)) {
                        System.out.println("O número digitado não condiz com nenhuma tarefa criada: " + indexOfTaskFilteredConverted);
                        break;
                    }

                    System.out.println("Tarefa a ser alterada: " + tasks.get(indexOfTaskFilteredConverted-1).getName());
                    System.out.println("Informe o novo nome da tarefa: ");
                    String newTaskName = scanner.nextLine();
                    service.updateTask(indexOfTaskFilteredConverted, newTaskName);
                    break;

                case 9:
                    systemRunning = false;
            }
        }
    }
}