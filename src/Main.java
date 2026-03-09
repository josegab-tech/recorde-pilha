import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Sistema de ranking esportivo");

        System.out.println("Digite o tamanho da pilha");
        int tamanho = scanner.nextInt();
        scanner.nextLine();

        Pilha<Recorde> pilha = new Pilha<>(tamanho);

        int opcao;

        do {
            System.out.println("\nMenu");
            System.out.println("1-Inserir recorde");
            System.out.println("2-Consultar topo");
            System.out.println("3-Remover topo");
            System.out.println("4-Lstar todos");
            System.out.println("0-Sair");
            System.out.println("Escolhendo: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Inserir recorde
                    System.out.println("\n--- NOVO RECORDE ---");

                    // Verificar se a pilha está cheia
                    if (pilha.isFull()) {
                        System.out.println("Pilha cheia! Não pode inserir.");
                        break;
                    }

                    // Ler data
                    System.out.print("Data (dd/mm/aaaa): ");
                    String dataStr = scanner.nextLine();
                    LocalDate data = LocalDate.parse(dataStr, formatador);

                    // Ler tempo
                    System.out.print("Tempo (segundos): ");
                    double tempo = scanner.nextDouble();
                    scanner.nextLine();

                    // Ler nome
                    System.out.print("Nome do atleta: ");
                    String nome = scanner.nextLine();

                    // Criar recorde
                    Recorde novo = new Recorde(data, tempo, nome);

                    // Verificar regra do tempo menor
                    if (pilha.isEmpty()) {
                        // Pilha vazia - pode inserir
                        pilha.push(novo);
                        System.out.println("Recorde inserido!");
                    } else {
                        // Comparar com o topo
                        Recorde topo = pilha.peek();
                        if (tempo < topo.getTempo()) {
                            pilha.push(novo);
                            System.out.println("Recorde inserido! (melhor tempo)");
                        } else {
                            System.out.println("Tempo maior que o recorde atual! Não pode inserir.");
                        }
                    }
                    break;

                case 2:
                    // Consultar topo
                    System.out.println("\n--- TOPO DA PILHA ---");
                    Recorde topo = pilha.peek();
                    if (topo != null) {
                        System.out.println(topo);
                    } else {
                        System.out.println("Pilha vazia!");
                    }
                    break;

                case 3:
                    // Remover topo
                    System.out.println("\n--- REMOVER TOPO ---");
                    Recorde removido = pilha.pop();
                    if (removido != null) {
                        System.out.println("Removido: " + removido);
                    } else {
                        System.out.println("Pilha vazia!");
                    }
                    break;

                case 4:
                    // Listar todos
                    System.out.println("\n--- TODOS OS RECORDES ---");
                    if (pilha.isEmpty()) {
                        System.out.println("Nenhum recorde.");
                    } else {
                        System.out.print(pilha.toString());
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

    }
}
