package ifsp.ed2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import ifsp.ed2.model.Customer;
import ifsp.ed2.order.BlockQuicksort;
import ifsp.ed2.search.TabelaHash;

public class CustomerOperatorTest {

	private Date inicio;
	private Date termino;

	@Test
	void testFindById() {

		iniciarTarefa("testFindById()");

		List<Customer> customers = CustomerOperator.loadCustomersFromCSV("customerDb200.csv");
		assertEquals(200000, customers.size());

		// =================================================
		
		   TabelaHash tabela = new TabelaHash(200000); // Defina o tamanho da tabela aqui
		    for (Customer customer : customers) {
		        tabela.adicionar(customer);
		    }

		    assertTrue(tabela.contemCliente(451));

		// =================================================

		terminarTarefa("testFindById()");
		System.out.println("Duracao (ms): " + calcularDuracaoEmSegundosTarefa());

	}

	@Test
	void testOrderById() {

		iniciarTarefa("testOrderById()");

		List<Customer> customers = CustomerOperator.loadCustomersFromCSV("customerDb200.csv");
		assertEquals(200000, customers.size()); // testa quantidade de elementos carregados
		assertEquals(77163, customers.get(0).getId()); // verifica o primeiro elemento antes de ordenar
		assertEquals(126598, customers.get(199999).getId()); // verifica o ultimo elemento antes de ordenar

		// =================================================
	    
		// Converta a lista de clientes para um array
		Customer[] arrayCustomers = customers.toArray(new Customer[customers.size()]);
		// Ordene o array pelo ID usando BlockQuicksort
		BlockQuicksort.quickSort(arrayCustomers, 0, arrayCustomers.length - 1);

		// Adicione uma instrução de impressão para verificar o ID do primeiro elemento
		System.out.println("ID do primeiro elemento após a ordenação: " + arrayCustomers[0].getId());
		    
		// =================================================



		assertEquals(200000, arrayCustomers.length); // testa quantidade de elementos no vetor ordenado
		assertEquals(0, arrayCustomers[0].getId()); // verifica o primeiro elemento depois de ordenar
		assertEquals(199999, arrayCustomers[199999].getId()); // verifica o ultimo elemento depois de ordenar

		terminarTarefa("testOrderById()");
		System.out.println("Duracao (ms): " + calcularDuracaoEmSegundosTarefa());

	}

	private void iniciarTarefa(String nomeTarefa) {
		inicio = new Date();
		System.out.println("Tarefa " + nomeTarefa + " iniciada em: " + inicio);
	}

	private void terminarTarefa(String nomeTarefa) {
		termino = new Date();
		System.out.println("Tarefa " + nomeTarefa + " terminada em: " + termino);
	}

	private long calcularDuracaoEmSegundosTarefa() {
		if (inicio == null || termino == null) {
			System.out.println("A tarefa não foi iniciada ou terminada.");
			return 0;
		}
		long duracaoEmMilissegundos = termino.getTime() - inicio.getTime();
		return duracaoEmMilissegundos;
	}
}
