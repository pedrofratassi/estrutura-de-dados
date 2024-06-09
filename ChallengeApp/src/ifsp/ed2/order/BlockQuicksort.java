package ifsp.ed2.order;

import ifsp.ed2.model.Customer;

public class BlockQuicksort {

    private static final int TAMANHO_BLOCO = 5;

    public static void quickSort(Customer[] array, int inicio, int fim) {
        if (fim - inicio <= TAMANHO_BLOCO) {
            insertionSort(array, inicio, fim);
        } else {
            int pivo = partition(array, inicio, fim);
            quickSort(array, inicio, pivo - 1);
            quickSort(array, pivo + 1, fim);
        }
    }

    private static int partition(Customer[] array, int inicio, int fim) {
        Customer pivot = array[fim]; // Seleciona o último elemento como pivô
        int i = inicio - 1; // Índice do menor elemento

        for (int j = inicio; j < fim; j++) {
            // Se o elemento atual for menor ou igual ao pivô
            if (array[j].compareTo(pivot) <= 0) {
                i++;

                // Troca array[i] e array[j]
                Customer temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Troca array[i+1] e array[fim] (o pivô)
        Customer temp = array[i + 1];
        array[i + 1] = array[fim];
        array[fim] = temp;

        return i + 1; // Retorna o índice do pivô após a partição
    }


    private static void insertionSort(Customer[] array, int inicio, int fim) {
        for (int i = inicio + 1; i <= fim; i++) {
            Customer chave = array[i];
            int j = i - 1;
            while (j >= inicio && array[j].getId() > chave.getId()) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = chave;
        }
    }
}