import java.util.Scanner;

public class MenuListaSimples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o tamanho da lista:");
        int tamanho = scanner.nextInt();
        int option;

        ListaSimples listaSimples = new ListaSimples(tamanho);

        do {
            System.out.println("MENU");
            System.out.println("1 - Inserir elementos");
            System.out.println("2 - Remover elementos");
            System.out.println("3 - Buscar elementos");
            System.out.println("4 - Ordenar lista");
            System.out.println("5 - Editar elementos");
            System.out.println("6 - Exibir lista");
            System.out.println("7 - Outras operações");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    int insertOption;
                    do {
                        System.out.println("INSERIR ELEMENTOS");
                        System.out.println("1 - Inserir no final");
                        System.out.println("2 - Inserir em índice específico");
                        System.out.println("3 - Inserir sequência de elementos");
                        System.out.println("0 - Voltar ao menu principal");
                        System.out.print("Escolha uma opção: ");
                        insertOption = scanner.nextInt();

                        switch (insertOption) {
                            case 1:
                                System.out.print("Digite o elemento a ser inserido: ");
                                Object element = scanner.next();
                                listaSimples.inserirElemento(element);
                                break;
                            case 2:
                                System.out.print("Digite o elemento: ");
                                Object elementoIndice = scanner.next();
                                System.out.print("Digite o índice: ");
                                int indice = scanner.nextInt();
                                listaSimples.inserirElementoIndice(elementoIndice, indice);
                                break;
                            case 3:
                                System.out.print("Quantos elementos deseja inserir? : ");
                                int qtd = scanner.nextInt();
                                Object[] sequency = new Object[qtd];
                                for (int i = 0; i < qtd; i++) {
                                    System.out.print("Elemento " + (i + 1) + ": ");
                                    sequency[i] = scanner.next();
                                }
                                listaSimples.inserirSequencia(sequency);
                                break;
                            case 0:
                                System.out.println("Voltando ao menu principal");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (insertOption != 0);
                    break;
                case 2:
                    int removeOption;
                    do {
                        System.out.println("REMOVER ELEMENTOS");
                        System.out.println("1 - Remover último elemento");
                        System.out.println("2 - Remover por índice");
                        System.out.println("3 - Remover sequência de elementos");
                        System.out.println("4 - Remover todas as ocorrências de um elemento");
                        System.out.println("0 - Voltar ao menu principal");
                        System.out.print("Escolha uma opção: ");
                        removeOption = scanner.nextInt();

                        switch (removeOption) {
                            case 1:
                                boolean removed = listaSimples.removerElemento();
                                if (removed) {
                                    System.out.println("Último elemento removido com sucesso!");
                                } else {
                                    System.out.println("A lista está vazia.");
                                }
                                break;
                            case 2:
                                System.out.print("Digite o índice a ser removido: ");
                                int removeIndex = scanner.nextInt();
                                Object removedElement = listaSimples.removerIndice(removeIndex);
                                if (removedElement != null && !removedElement.equals(0)) {
                                    System.out.println("Elemento removido: " + removedElement);
                                } else {
                                    System.out.println("Índice inválido ou lista vazia.");
                                }
                                break;
                            case 3:
                                System.out.print("Quantos elementos deseja remover? : ");
                                int removedAmount = scanner.nextInt();
                                Object[] removeSequency = new Object[removedAmount];
                                for (int i = 0; i < removedAmount; i++) {
                                    System.out.print("Elemento " + (i + 1) + ": ");
                                    removeSequency[i] = scanner.next();
                                }
                                listaSimples.removerSequencia(removeSequency);
                                break;
                            case 4:
                                System.out.print("Digite o elemento a remover de todas as ocorrências: ");
                                Object elementoTodas = scanner.next();
                                listaSimples.removerTodasOcorrencias(elementoTodas);
                                break;
                            case 0:
                                System.out.println("Voltando ao menu principal");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (removeOption != 0);
                    break;
                case 3:
                    int searchOption;
                    do {
                        System.out.println("BUSCAR ELEMENTOS");
                        System.out.println("1 -  Buscar elemento por valor");
                        System.out.println("2 -  Buscar elemento por índice");
                        System.out.println("0 -  Voltar ao menu principal");
                        System.out.print("Escolha uma opção: ");
                        searchOption = scanner.nextInt();

                        switch (searchOption) {
                            case 1:
                                System.out.print("Digite o elemento a buscar: ");
                                Object elementoBuscar = scanner.next();
                                boolean found = listaSimples.buscarElemento(elementoBuscar);
                                if (found) {
                                    System.out.println("Elemento encontrado na lista!");
                                } else {
                                    System.out.println("Elemento não encontrado.");
                                }
                                break;
                            case 2:
                                System.out.print("Digite o índice que deseja buscar: ");
                                int searchIndex = scanner.nextInt();
                                Object result = listaSimples.buscarElementoIndice(searchIndex);
                                if (result != null) {
                                    System.out.println("Elemento no índice " + searchIndex + ": " + result);
                                } else {
                                    System.out.println("Índice inválido.");
                                }
                                break;
                            case 0:
                                System.out.println("Voltando ao menu principal...");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (searchOption != 0);
                    break;
                case 4:
                    int orderOption;
                    do {
                        System.out.println("ORDENAR ELEMENTOS");
                        System.out.println("1 -  Ordenar em ordem crescente");
                        System.out.println("2 -  Ordenar em ordem decrescente");
                        System.out.println("0 -  Voltar ao menu principal");
                        System.out.print("Escolha uma opção: ");
                        orderOption = scanner.nextInt();

                        switch (orderOption) {
                            case 1:
                                listaSimples.ordenarCrescente();
                                break;
                            case 2:
                                listaSimples.ordenarDecrescente();
                                break;
                            case 0:
                                System.out.println("Voltando ao menu principal");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (orderOption != 0);
                    break;
                case 5:
                    System.out.print("Digite o elemento que deseja editar: ");
                    Object oldElement = scanner.next();
                    System.out.print("Digite o novo valor do elemento: ");
                    Object newElement = scanner.next();
                    listaSimples.editarElemento(oldElement, newElement);
                    System.out.println("Elemento editado!");
                    break;
                case 6:
                    listaSimples.exibir();
                    break;
                case 7:
                    System.out.println("1 - Dobrar a capacidade da lista");
                    System.out.println("2 - Limpar a lista");
                    System.out.println("3 - Obter o primeiro elemento");
                    System.out.println("4 - Obter o último elemento");
                    System.out.println("Selecione uma operação:");

                    int opcaoOutros = scanner.nextInt();
                    switch (opcaoOutros) {
                        case 1:
                            listaSimples.dobrarCapacidade();
                            System.out.println("Capacidade dobrada!");
                            break;
                        case 2:
                            listaSimples.limpar();
                            System.out.println("Lista limpa!");
                            break;
                        case 3:
                            System.out.println("Primeiro elemento: " + listaSimples.obterPrimeiroElemento());
                            break;
                        case 4:
                            System.out.println("Último elemento: " + listaSimples.obterUltimoElemento());
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 0);
    }
}