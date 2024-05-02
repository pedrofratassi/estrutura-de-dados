package métodos;
public class SelectionSort {
	
	
	 static void selectionSort(Pessoa[] pessoas, int quantidadeElementos) {
		
		for (int posicaoAtual = 0; posicaoAtual < quantidadeElementos; posicaoAtual++) {
			int posicaoMenor = buscaMenorSalario(pessoas, posicaoAtual, quantidadeElementos - 1);
			trocar(pessoas, posicaoAtual, posicaoMenor);
		}

	}


	private static void trocar(Pessoa[] pessoas, int posicaoPrimeiro, int posicaoSegundo) {
		
		Pessoa primeiro = pessoas[posicaoPrimeiro];
		Pessoa segundo = pessoas [posicaoSegundo];
		pessoas[posicaoPrimeiro] = segundo;
		pessoas [posicaoSegundo] = primeiro;
	}
	
	private static int buscaMenorSalario(Pessoa[] pessoas, int posicaoInicio, int posicaoTermino) {
		
		int posicaoMenorSalario = posicaoInicio;
		
		for (int posicaoAtual=posicaoInicio+1; posicaoAtual<=posicaoTermino; posicaoAtual++) {
			
			if (pessoas[posicaoAtual].getSalario() < pessoas[posicaoMenorSalario].getSalario()) {
				posicaoMenorSalario = posicaoAtual;
			}
		}
		return posicaoMenorSalario;
	}
}