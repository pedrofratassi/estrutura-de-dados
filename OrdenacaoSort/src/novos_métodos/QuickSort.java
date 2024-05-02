package novos_métodos;

public class QuickSort {

    public static void quickSort(Nota[] notas, int esquerda, int direita) {
        if (esquerda < direita) {
            int posicaoPivo = particionar(notas, esquerda, direita);
            quickSort(notas, esquerda, posicaoPivo - 1);
            quickSort(notas, posicaoPivo + 1, direita);
        }
    }

    private static int particionar(Nota[] notas, int esquerda, int direita) {
        Nota pivo = notas[direita];
        int i = esquerda - 1;

        for (int j = esquerda; j < direita; j++) {
            if (notas[j].getValor() <= pivo.getValor()) {
                i++;
                trocar(notas, i, j);
            }
        }

        trocar(notas, i + 1, direita);
        return i + 1;
    }

    private static void trocar(Nota[] notas, int i, int j) {
        Nota temp = notas[i];
        notas[i] = notas[j];
        notas[j] = temp;
    }
}