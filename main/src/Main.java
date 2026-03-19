import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean systemRunning = true;
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();

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
                    String task = scanner.nextLine();
                    tasks.add(task);
                    break;
                case 2:
                    for (int index = 0; index < tasks.size(); index++) {
                        int viewIndex = index + 1;
                        System.out.println(viewIndex + " - " + tasks.get(index));
                    }
                    break;
                case 3:
                    if(tasks.size() == 0){
                        System.out.println("Não há nenhuma tarefa salva");
                        break;
                    }
                    for (int index = 0; index < tasks.size(); index++) {
                        int viewIndex = index + 1;
                        System.out.println(viewIndex + " - " + tasks.get(index));
                    }
                    System.out.println("Informe o número da tarefa a ser atualizada");
                    String indexOfTaskFiltered = scanner.nextLine();
                    int indexOfTaskFilteredConverted = Integer.parseInt(indexOfTaskFiltered);
                    int indexOfTaskFilteredForSearch = Integer.parseInt(indexOfTaskFiltered)-1;

                    if((indexOfTaskFilteredConverted > tasks.size()) || (indexOfTaskFilteredConverted <= 0)) {
                        System.out.println("O número digitado não condiz com nenhuma tarefa criada: " + indexOfTaskFilteredConverted);
                        break;
                    }

                    System.out.println("Tarefa a ser alterada: " + tasks.get(indexOfTaskFilteredForSearch));
                    System.out.println("Informe o novo nome da tarefa: ");
                    String newTaskName = scanner.nextLine();
                    tasks.set(indexOfTaskFilteredForSearch, newTaskName);
                    break;

                case 9:
                    systemRunning = false;
            }
        }
    }
}