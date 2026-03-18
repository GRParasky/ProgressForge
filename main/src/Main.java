import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean systemRunning = true;
        Scanner scanner = new Scanner(System.in);
        List tasks = new ArrayList<String>();

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
                    System.out.println(tasks);
                    break;
                case 3:
                    for (Object taskCreated : tasks) {
                        System.out.println(taskCreated);
                    }
                case 9:
                    systemRunning = false;
            }
        }
    }
}