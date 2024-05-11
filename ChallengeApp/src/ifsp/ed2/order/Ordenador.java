package ifsp.ed2.order;

import ifsp.ed2.model.Customer;

public class Ordenador {

	public static void bubbleSort(Customer[] customers, int quantidadeElementos) {

		for (int i = 0; i < quantidadeElementos - 1; i++) {
			for (int j = 0; j < quantidadeElementos - 1 - i; j++) {
				if (customers[j].getId() > customers[j + 1].getId()) {
					trocar(customers, j, j + 1);
				}
			}
		}
	}

	public static void insertionSort(Customer[] pessoas, int quantidadeElementos) {

		for (int posicaoAtual = 1; posicaoAtual < quantidadeElementos; posicaoAtual++) {
			int posAnalise = posicaoAtual;
			while (posAnalise > 0 && pessoas[posAnalise].getId() < pessoas[posAnalise - 1].getId()) {
				trocar(pessoas, posAnalise, posAnalise - 1);
				posAnalise--;
			}
		}

	}
	
	public static void quickSort(Customer[] pessoas, int de, int ate) {

		int elementos = ate - de;
		if (elementos > 1) {
			int posicaoDoPivo = particiona(pessoas, de, ate);
			quickSort(pessoas, de, posicaoDoPivo);
			quickSort(pessoas, posicaoDoPivo + 1, ate);
		}
	}

	private static int particiona(Customer[] pessoas, int inicial, int termino) {

		int menoresEncontrados = inicial;
		Customer pivo = pessoas[termino - 1];

		for (int analisando = inicial; analisando < termino - 1; analisando++) {
			Customer atual = pessoas[analisando];
			if (atual.getId() <= pivo.getId()) {
				trocar(pessoas, analisando, menoresEncontrados);
				menoresEncontrados++;
			}
		}
		trocar(pessoas, termino - 1, menoresEncontrados);
		return menoresEncontrados;
	}
	
	

	private static void trocar(Customer[] customers, int posicaoPrimeiro, int posicaoSegundo) {

		Customer primeiro = customers[posicaoPrimeiro];
		Customer segundo = customers[posicaoSegundo];
		customers[posicaoPrimeiro] = segundo;
		customers[posicaoSegundo] = primeiro;
	}
}
