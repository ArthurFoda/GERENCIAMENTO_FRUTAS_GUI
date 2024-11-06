import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// 1. Definindo a interface FrutaManager
interface FrutaManager {
    void adicionarFruta(String fruta);
    void listarFrutas();
    void removerFruta(String fruta);
    boolean verificarFruta(String fruta);
}

// 2. Classe que implementa a interface FrutaManager e manipula a lista de frutas
class FrutaManagerImpl implements FrutaManager {
    private List<String> frutas = new ArrayList<>(); // A lista de frutas

    // Implementação do método de adicionar fruta
    @Override
    public void adicionarFruta(String fruta) {
        if (!frutas.contains(fruta)) {
            frutas.add(fruta);
            System.out.println(fruta + " foi adicionada.");
        } else {
            System.out.println(fruta + " já está presente na lista.");
        }
    }

    // Implementação do método para listar todas as frutas
    @Override
    public void listarFrutas() {
        if (frutas.isEmpty()) {
            System.out.println("Nenhuma fruta foi adicionada ainda.");
        } else {
            System.out.println("Frutas: " + frutas);
        }
    }

    // Implementação do método de remover uma fruta
    @Override
    public void removerFruta(String fruta) {
        if (frutas.remove(fruta)) {
            System.out.println(fruta + " foi removida.");
        } else {
            System.out.println(fruta + " não foi encontrada na lista.");
        }
    }

    // Implementação do método para verificar se uma fruta está presente
    @Override
    public boolean verificarFruta(String fruta) {
        return frutas.contains(fruta);
    }
}

// 3. Classe principal para interação com o usuário
public class ExemploArrayListInterativo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FrutaManager frutaManager = new FrutaManagerImpl(); // Criando a instância da implementação da interface

        while (true) {
            try {
                // Exibindo o menu de opções
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Adicionar uma fruta");
                System.out.println("2. Listar todas as frutas");
                System.out.println("3. Remover uma fruta");
                System.out.println("4. Verificar se uma fruta está presente");
                System.out.println("5. Sair");
                System.out.print("Opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer para evitar problemas com o scanner

                switch (opcao) {
                    case 1:
                        // Opção para adicionar uma fruta
                        System.out.print("Digite o nome da fruta para adicionar: ");
                        String novaFruta = scanner.nextLine();
                        frutaManager.adicionarFruta(novaFruta);
                        break;

                    case 2:
                        // Opção para listar todas as frutas
                        frutaManager.listarFrutas();
                        break;

                    case 3:
                        // Opção para remover uma fruta
                        System.out.print("Digite o nome da fruta que deseja remover: ");
                        String frutaRemover = scanner.nextLine();
                        frutaManager.removerFruta(frutaRemover);
                        break;

                    case 4:
                        // Opção para verificar se uma fruta está presente na lista
                        System.out.print("Digite o nome da fruta para verificar: ");
                        String frutaVerificar = scanner.nextLine();
                        if (frutaManager.verificarFruta(frutaVerificar)) {
                            System.out.println(frutaVerificar + " está presente na lista.");
                        } else {
                            System.out.println(frutaVerificar + " não foi encontrada na lista.");
                        }
                        break;

                    case 5:
                        // Opção para sair do programa
                        System.out.println("Saindo...");
                        scanner.close();
                        return;

                    default:
                        // Caso o usuário digite uma opção inválida
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                // Captura exceções de entrada inválida (caso o usuário digite algo que não seja número)
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpa o buffer para evitar um loop infinito
            }
        }
    }
}
