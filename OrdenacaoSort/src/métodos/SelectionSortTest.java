package métodos;
import static org.junit.Assert.*;
import java.time.Instant;
import java.time.Duration;
import org.junit.Test;

public class SelectionSortTest {

    @Test
    public void testSelectionSort() {
        testSelectionSortComCenario(100);
        testSelectionSortComCenario(1000);
        testSelectionSortComCenario(20000);
    }

    private void testSelectionSortComCenario(int quantidade) {
        Pessoa[] pessoas = GeraNumerosAleatorios.gerarPessoas(quantidade);

        Instant start = Instant.now();
        SelectionSort.selectionSort(pessoas, quantidade);
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        System.out.println("Selection Sort com " + quantidade + " elementos levou " + timeElapsed + " milissegundos");

        for (int i = 0; i < pessoas.length - 1; i++) {
            assertTrue(pessoas[i].getSalario() <= pessoas[i + 1].getSalario());
        }
    }
}
