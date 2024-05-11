package ifsp.ed2.search;

import ifsp.ed2.model.Customer;

public class TabelaHash {
	
	private ListaLigada[] elementos;
	private static final int LOAD_FACTOR = 70; // Define o fator de carga
	
	public TabelaHash(int tamanho) {
		int realTamanho = (int) (tamanho / (LOAD_FACTOR / 100.0)); // Ajusta o tamanho com base no fator de carga
		elementos = new ListaLigada[realTamanho];
		inicializarElementos(realTamanho);
	}

	private void inicializarElementos(int tamanho) {
		for (int i = 0; i < tamanho; i++) {
			elementos[i] = new ListaLigada();
		}
	}

	public ListaLigada[] getElementos() {
		return elementos;
	}

	public void setElementos(ListaLigada[] elementos) {
		this.elementos = elementos;
	}

	public void adicionar(Customer customer) {
	    int indice = calcularIndice(customer.getId());
	    elementos[indice].adicionarNoFinal(customer);
	    if (elementos[indice].pegarTotalElementos() > 10) { // Se a lista ficar muito longa, redimensione a tabela
	        redimensionar();
	    }
	}

	private int calcularIndice(int id) {
	    return id % elementos.length;
	}
	
	private void redimensionar() {
	    int novoTamanho = elementos.length * 2;
	    TabelaHash novaTabela = new TabelaHash(novoTamanho);
	    for (ListaLigada lista : elementos) {
	        for (int i = 0; i < lista.pegarTotalElementos(); i++) {
	            Customer customer = (Customer) lista.pegar(i);
	            novaTabela.adicionar(customer);
	        }
	    }
	    elementos = novaTabela.getElementos();
	}

	public boolean contemCliente(int id) {
	    int indice = calcularIndice(id);
	    ListaLigada lista = elementos[indice];
	    return lista.contemCliente(id);
	}

}