package view;

import controller.FilaController;
import model.TipoSenha;

import java.util.Scanner;

public class AppSenhaDigital {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        FilaController controller = new FilaController();
        int opcao;

        do {
            System.out.println("### Senha Digital ###");
            System.out.println("=========================");
            System.out.println("| 1 - Senha Normal       |");
            System.out.println("| 2 - Senha Preferencial |");
            System.out.println("| 3 - Chamar Senha       |");
            System.out.println("| 0 - Sair               |");
            System.out.println("=========================");
            System.out.print("Opcao -> ");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    controller.gerarSenha(TipoSenha.NORMAL);
                    break;
                case 2:
                    controller.gerarSenha(TipoSenha.PREFERENCIAL);
                    break;
                case 3:
                    controller.chamarSenha();
                    break;
                case 0:
                    System.out.println("Saindo do Programa...");
                    break;
                default:
                    System.out.println("Opcao Invalida!");
            }

        } while (opcao != 0);

        teclado.close();
    }
}
