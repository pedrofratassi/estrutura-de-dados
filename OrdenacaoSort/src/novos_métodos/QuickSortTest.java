package novos_métodos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.Instant;

public class QuickSortTest {

    @Test
    public void testQuickSortPerformance() {
        testQuickSortComCenario(100);
        testQuickSortComCenario(1000);
        testQuickSortComCenario(10000);
    }

    private void testQuickSortComCenario(int quantidade) {
        Nota[] notas = GeraNumerosAleatorios.gerarNotas(quantidade);

        Instant start = Instant.now();
        QuickSort.quickSort(notas, 0, notas.length - 1);
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        System.out.println("Quick Sort com " + quantidade + " elementos levou " + timeElapsed + " milissegundos");

        for (int i = 0; i < notas.length - 1; i++) {
            assertTrue(notas[i].getValor() <= notas[i + 1].getValor());
        }
    }
}