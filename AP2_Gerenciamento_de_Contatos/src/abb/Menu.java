package abb;

import java.util.Scanner;

public class Menu {

    private ArvoreBinariaBusca arvoreContatos;
    private Scanner scanner;

    public Menu() {
        arvoreContatos = new ArvoreBinariaBusca();
        scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciador de Conta ---");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Pesquisar Contato por Código");
            System.out.println("3. Listar Todos os Contatos em Ordem Alfabética");
            System.out.println("4. Remover Contato por Código");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1:
                    adicionarContato();
                    break;
                    
                case 2:
                    pesquisarContatoPorCodigo();
                    break;
                    
                case 3:
                    listarContatosEmOrdemAlfabetica();
                    break;
                    
                case 4:
                    removerContatoPorCodigo();
                    break;
                    
                case 5:              
                    System.out.println("Saindo...");
                    break;
                    
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 5);
    }

    private void adicionarContato() {
        System.out.println("\nAdicionar Contato");
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Contato novoContato = new Contato(codigo, nome, telefone);
        arvoreContatos.adicionarContato(novoContato);
    }


    private void pesquisarContatoPorCodigo() {
        System.out.println("\nPesquisar Contato por Código");
        System.out.print("Digite o código do contato: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); 

        Contato contatoEncontrado = arvoreContatos.pesquisarContato(codigo);
        if (contatoEncontrado != null) {
            System.out.println("Contato encontrado:");
            System.out.println(contatoEncontrado);
        } else {
            System.out.println("Contato com o código " + codigo + " não encontrado.");
        }
    }

    private void listarContatosEmOrdemAlfabetica() {
        System.out.println("\nListar Todos os Contatos em Ordem Alfabética");
        arvoreContatos.listarContatosEmOrdemAlfabetica();
    }

    private void removerContatoPorCodigo() {
        System.out.println("\nRemover Contato por Código");
        System.out.print("Digite o código do contato a ser removido: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); 

        arvoreContatos.removerContatoPorCodigo(codigo);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibirMenu();
    }
}
