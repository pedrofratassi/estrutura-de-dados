package métodos;

public class BubbleSort {
	
	public static void bubbleSort(Pessoa[] pessoas, int quantidadeElementos) {
		
		for (int i = 0; i < quantidadeElementos - 1; i++) {
			for (int j = 0; j<quantidadeElementos - 1 - i; j++) {
				if (pessoas[j].getSalario() > pessoas[j+1].getSalario() ) {
					trocar(pessoas, j, j+1);
				}
			}
		}
	}
	
	public static void trocar(Pessoa[] pessoas, int posicaoPrimeiro, int posicaoSegundo) {
		
		Pessoa primeiro = pessoas[posicaoPrimeiro];
		Pessoa segundo = pessoas [posicaoSegundo];
		pessoas[posicaoPrimeiro] = segundo;
		pessoas [posicaoSegundo] = primeiro;
	}
}