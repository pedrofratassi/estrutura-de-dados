package métodos;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.time.Instant;
import org.junit.jupiter.api.Test;

public class InsertionSortTest {

    @Test
    public void testInsertionSort() {
        testInsertionSortComCenario(100);
        testInsertionSortComCenario(1000);
        testInsertionSortComCenario(20000);
    }

    private void testInsertionSortComCenario(int quantidade) {
        Pessoa[] pessoas = GeraNumerosAleatorios.gerarPessoas(quantidade);

        Instant start = Instant.now();
        InsertionSort.insertionSort(pessoas, quantidade);
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        System.out.println("Insertion Sort com " + quantidade + " elementos levou " + timeElapsed + " milissegundos");

        for (int i = 0; i < pessoas.length - 1; i++) {
            assertTrue(pessoas[i].getSalario() <= pessoas[i + 1].getSalario());
        }
    }
}
