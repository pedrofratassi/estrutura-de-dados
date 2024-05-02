package métodos;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.time.Instant;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {

    @Test
    public void testBubbleSort() {
        testBubbleSortComCenario(100);
        testBubbleSortComCenario(1000);
        testBubbleSortComCenario(20000);
    }

    private void testBubbleSortComCenario(int quantidade) {
        Pessoa[] pessoas = GeraNumerosAleatorios.gerarPessoas(quantidade);

        Instant start = Instant.now();
        BubbleSort.bubbleSort(pessoas, quantidade);
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        System.out.println("Bubble Sort com " + quantidade + " elementos levou " + timeElapsed + " milissegundos");

        for (int i = 0; i < pessoas.length - 1; i++) {
            assertTrue(pessoas[i].getSalario() <= pessoas[i + 1].getSalario());
        }
    }
}
