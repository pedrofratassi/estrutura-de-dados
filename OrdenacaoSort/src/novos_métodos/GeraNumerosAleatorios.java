package novos_métodos;

import java.util.Random;

public class GeraNumerosAleatorios {

    public static Nota[] gerarNotas(int quantidade) {
        Nota[] notas = new Nota[quantidade];
        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {
            double valor = random.nextDouble() * 10;
            notas[i] = new Nota("Aluno " + (i + 1), valor);
        }

        return notas;
    }
}

