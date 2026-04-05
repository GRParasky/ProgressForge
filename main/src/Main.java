import model.Task;
import repository.TaskRepository;
import service.TaskService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static int selecionarTarefa(List<Task> tasks, Scanner scanner, String mensagem) {
        for (int index = 0; index < tasks.size(); index++) {
            int viewIndex = index + 1;
            System.out.println(viewIndex + " - " + tasks.get(index).getName());
        }
        System.out.println("Informe o número da tarefa a ser " + mensagem + ": ");
        int id = Integer.parseInt(scanner.nextLine());

        if (id <= 0 || id > tasks.size()) {
            System.out.println("Número inválido: " + id);
            return -1;
        }
        return id;
    }


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
                    "4 - Deletar tarefa\n" +
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
                    int indexOfTaskFilteredConverted = selecionarTarefa(tasks, scanner, "atualizada");

                    System.out.println("Tarefa a ser alterada: " + tasks.get(indexOfTaskFilteredConverted-1).getName());
                    System.out.println("Informe o novo nome da tarefa: ");
                    String newTaskName = scanner.nextLine();
                    service.updateTask(indexOfTaskFilteredConverted, newTaskName);
                    break;

                case 4:
                    if(tasks.isEmpty()){
                        System.out.println("Não há nenhuma tarefa salva");
                        break;
                    }
                    int indexOfTaskExcludeConverted = selecionarTarefa(tasks, scanner, "deletada");

                    System.out.println("Tarefa a ser excluída: " + tasks.get(indexOfTaskExcludeConverted-1).getName());
                    System.out.println("Deseja realmente excluir a task: " + tasks.get(indexOfTaskExcludeConverted-1).getName() + "? Y/N");
                    String confirmation = scanner.nextLine();
                    if(confirmation.equals("Y")){
                        service.deleteTask(indexOfTaskExcludeConverted);
                    } else {
                        System.out.println("Operação cancelada pelo usuário!");
                        break;
                    }

                    break;

                case 9:
                    systemRunning = false;
            }
        }
    }
}