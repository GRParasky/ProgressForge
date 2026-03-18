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
                    "3 - Sair\n" +
                    "------------"
            );
            System.out.println("Escolha a opção: ");
            int option = scanner.nextInt();

            switch(option){
                case 1:
                    System.out.println("Informe a tarefa a ser adicionada: ");
                    String task = scanner.next();
                    tasks.add(task);
                    break;
                case 2:
                    System.out.println(tasks);
                    break;
                case 3:
                    systemRunning = false;
            }
        }
    }
}