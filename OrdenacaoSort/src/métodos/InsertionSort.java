package métodos;

public class InsertionSort {

	public static void insertionSort(Pessoa[] pessoas, int quantidadeElementos) {

		for (int posicaoAtual = 1; posicaoAtual < quantidadeElementos; posicaoAtual++) {
			int posAnalise = posicaoAtual;
			while (posAnalise > 0 && pessoas[posAnalise].getSalario() < pessoas[posAnalise - 1].getSalario()) {
				trocar(pessoas, posAnalise, posAnalise - 1);
				posAnalise--;
			}
		}

	}

	public static void trocar(Pessoa[] pessoas, int posicaoPrimeiro, int posicaoSegundo) {

		Pessoa primeiro = pessoas[posicaoPrimeiro];
		Pessoa segundo = pessoas[posicaoSegundo];
		pessoas[posicaoPrimeiro] = segundo;
		pessoas[posicaoSegundo] = primeiro;
	}
}