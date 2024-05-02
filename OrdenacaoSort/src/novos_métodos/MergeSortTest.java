package novos_métodos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.Instant;

public class MergeSortTest {

    @Test
    public void testMergeSortPerformance() {
        testMergeSortComCenario(100);
        testMergeSortComCenario(1000);
        testMergeSortComCenario(10000);
    }

    private void testMergeSortComCenario(int quantidade) {
        Nota[] notas = GeraNumerosAleatorios.gerarNotas(quantidade);

        Instant start = Instant.now();
        MergeSort.mergeSort(notas, 0, notas.length);
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        System.out.println("Merge Sort com " + quantidade + " elementos levou " + timeElapsed + " milissegundos");

        for (int i = 0; i < notas.length - 1; i++) {
            assertTrue(notas[i].getValor() <= notas[i + 1].getValor());
        }
    }
}
