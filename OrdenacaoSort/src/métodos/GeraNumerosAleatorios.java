package métodos;
import java.util.Random;

public class GeraNumerosAleatorios {

    public static Pessoa[] gerarPessoas(int quantidade) {
        Pessoa[] pessoas = new Pessoa[quantidade];
        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {
            int salario = random.nextInt(10000) + 1; // Gera um salário aleatório entre 1 e 10000
            pessoas[i] = new Pessoa("Pessoa " + (i + 1), salario);
        }

        return pessoas;
    }
}