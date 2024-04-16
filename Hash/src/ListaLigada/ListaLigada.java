package ListaLigada;


public class ListaLigada {

	private Celula primeira = null;
	private Celula ultima = null;
	private int totalDeElementos = 0;

	private static final String MSG_ERRO_AO_REMOVER_CELULA_POSICAO_INVALIDA = "Erro ao remover celula: posição inválida";
	private static final String MSG_ERRO_REMOCAO_INVALIDA_LISTA_ESTA_VAZIA = "Erro ao tentar remover: lista esta vazia.";
	private static final String MSG_ERRO_AO_RECUPERAR_CELULA_POSICAO_INVALIDA = "Erro ao recuperar celula: posicao inválida.";
	private static final String MSG_ERRO_AO_RECUPERAR_PRIMEIRA_POSICAO_ESTA_VAZIA = "Erro ao recuperar: lista está vazia";
	private static final String MSG_ERRO_AO_INSERIR_POSICAO_INVALIDA = "Erro ao tentar inserir: posicao invalida.";

	public void adicionaNoComeco(Object novoElemento) {

		if (ehVazia()) {
			Celula nova = new Celula(novoElemento);
			this.primeira = nova;
			this.ultima = nova;
		} else {
			Celula nova = new Celula(novoElemento, this.primeira);
			this.primeira.setAnterior(nova);
			this.primeira = nova;
		}
		this.totalDeElementos++;
	}

	public void adicionaNoFinal(Object novoElemento) {

		if (ehVazia()) {
			adicionaNoComeco(novoElemento);
		} else {
			Celula nova = new Celula(novoElemento);
			this.ultima.setProximo(nova);
			nova.setAnterior(this.ultima);
			this.ultima = nova;
			this.totalDeElementos++;
		}

	}

	private boolean posicaoValidaInsercao(int posicao) {
		return (posicao >= 0) && (posicao <= this.totalDeElementos);
	}

	public void adicinaNaPosicao(Object novoElemento, int posicao) {

		if (!posicaoValidaInsercao(posicao)) {
			throw new IllegalArgumentException(MSG_ERRO_AO_INSERIR_POSICAO_INVALIDA);
		}

		if (posicao == 0) {
			adicionaNoComeco(novoElemento);
		} else if (posicao == this.totalDeElementos) {
			adicionaNoFinal(novoElemento);
		} else {
			Celula anterior = pegaCelula(posicao - 1);
			Celula proxima = anterior.getProximo();

			Celula nova = new Celula(novoElemento, proxima);
			nova.setAnterior(anterior);
			anterior.setProximo(nova);
			proxima.setAnterior(nova);
			this.totalDeElementos++;
		}

	}

	private boolean ehVazia() {
		return totalDeElementos == 0;

	}

	public int pegaTotalElementos() {
		return totalDeElementos;
	}

	public Object pegaPrimeiro() {
		if (this.primeira == null)
			throw new RuntimeException(MSG_ERRO_AO_RECUPERAR_PRIMEIRA_POSICAO_ESTA_VAZIA);

		return this.primeira.getElemento();
	}

	public Object pegaUltima() {
		if (this.ultima == null)
			throw new RuntimeException(MSG_ERRO_AO_RECUPERAR_PRIMEIRA_POSICAO_ESTA_VAZIA);

		return this.ultima.getElemento();
	}

	private boolean posicaoValidaRecuperar(int posicao) {
		return (posicao >= 0) && (posicao < this.totalDeElementos);
	}

	private Celula pegaCelula(int posicao) {

		if (!posicaoValidaRecuperar(posicao)) {
			throw new IllegalArgumentException(MSG_ERRO_AO_RECUPERAR_CELULA_POSICAO_INVALIDA);
		}

		Celula atual = this.primeira;

		for (int i = 0; i < posicao; i++) {
			atual = atual.getProximo();
		}

		return atual;

	}

	public Object pega(int posicao) {

		return pegaCelula(posicao).getElemento();

	}

	public boolean contem(Object elementoBuscado) {

		Celula atual = this.primeira;

		while (atual != null) {

			if (atual.getElemento().equals(elementoBuscado)) {
				return true;
			}
			atual = atual.getProximo();
		}

		return false;
	}

	public void removeDoComeco() {

		if (ehVazia()) {
			throw new RuntimeException(MSG_ERRO_REMOCAO_INVALIDA_LISTA_ESTA_VAZIA);
		}
		this.primeira = this.primeira.getProximo();

		if (this.totalDeElementos > 1) {
			this.primeira.setAnterior(null);
		}
		this.totalDeElementos--;

		if (totalDeElementos == 0) {
			this.ultima = null;
		}

	}

	public void removeDoFinal() {

		if (ehVazia()) {
			throw new RuntimeException(MSG_ERRO_REMOCAO_INVALIDA_LISTA_ESTA_VAZIA);
		}
		if (this.totalDeElementos == 1) {
			removeDoComeco();
		} else {
			Celula penultima = this.ultima.getAnterior();
			penultima.setProximo(null);
			this.ultima = penultima;
			totalDeElementos--;
		}

	}

	public void removeNaPosicao(int posicao) {

		if (!posicaoValidaRecuperar(posicao)) {
			throw new IllegalArgumentException(MSG_ERRO_AO_REMOVER_CELULA_POSICAO_INVALIDA);
		}
		if (posicao == 0) {
			removeDoComeco();
		} else if (posicao == this.totalDeElementos - 1) {
			removeDoFinal();
		} else {
			Celula anterior = this.pegaCelula(posicao - 1);
			Celula atual = anterior.getProximo();
			Celula proxima = atual.getProximo();

			anterior.setProximo(proxima);
			proxima.setAnterior(anterior);

			this.totalDeElementos--;
		}
	}

	public boolean primeiroEhNulo() {
		return this.primeira == null;
	}

	public boolean ultimoEhNulo() {
		return this.ultima == null;
	}

}