package ifsp.ed2.search;

public class HashVetor {

	private int tamanho;
	private TabelaHash tabelaHash;

	public HashVetor(int tamanho) {

		if (tamanho <= 0) {
			throw new IllegalArgumentException("Tamanho Inválido.");
		}
		this.tamanho = tamanho;
		tabelaHash = new TabelaHash(tamanho);
	}

	private int calcularHash(int chave) {

		String chaveConvertida = String.valueOf(chave);
		int h = 0;
		for (int i = 0; i < chaveConvertida.length(); i++) {
			h = 31 * h + chaveConvertida.charAt(i);
		}
		return h % tamanho;
	}

	public int adicionar(Cliente novoCliente) {

		int enderecoAdicionado = calcularHash(novoCliente.getCodigo());

		tabelaHash.getElementos()[enderecoAdicionado].adicionarNoFinal(novoCliente);

		return enderecoAdicionado;

	}
	
	public Cliente buscarClienteCodigo(int codigoBuscado) {
		
		int enderecoBuscado = calcularHash(codigoBuscado);
		
		int tamanhoLista = tabelaHash.getElementos()[enderecoBuscado].pegarTotalElementos();
		if (tamanhoLista != 0) {
			for (int i=0; i<tamanhoLista; i++) {
				Cliente cliente = (Cliente) tabelaHash.getElementos()[enderecoBuscado].pegar(i);
				if (cliente.getCodigo() == codigoBuscado) {
					return cliente;
				}
			}
		}
	
		return null;
		
	}

	public boolean contem(Cliente cliente) {
		int endereco = calcularHash(cliente.getCodigo());
		int tamanhoLista = tabelaHash.getElementos()[endereco].pegarTotalElementos();
		for (int i = 0; i < tamanhoLista; i++) {
			Cliente clienteAtual = (Cliente) tabelaHash.getElementos()[endereco].pegar(i);
			if (clienteAtual.equals(cliente)) {
				return true;
			}
		}
		return false;
	}

	public void excluir(Cliente cliente) {
		int endereco = calcularHash(cliente.getCodigo());
		int tamanhoLista = tabelaHash.getElementos()[endereco].pegarTotalElementos();
		for (int i = 0; i < tamanhoLista; i++) {
			Cliente clienteAtual = (Cliente) tabelaHash.getElementos()[endereco].pegar(i);
			if (clienteAtual.equals(cliente)) {
				tabelaHash.getElementos()[endereco].removerNaPosicao(i);
				break;
			}
		}
	}

	public double tamanhoMedioPesquisa() {
		int totalElementos = 0;
		for (int i = 0; i < tamanho; i++) {
			totalElementos += tabelaHash.getElementos()[i].pegarTotalElementos();
		}
		return (double) totalElementos / tamanho;
	}
	
}
