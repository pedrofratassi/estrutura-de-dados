public class HashVetor {
	
	private static final String TAMANHO_INVALIDO_O_VALOR_DEVE_SER_MAIOR_QUE_ZERO = "Tamanho Invalido. O valor deve ser maior que zero.";
	private int tamanho;
	private TabelaHash tabelaHash;
	
	public HashVetor (int tamanho) {
		
		if (tamanho <= 0) {
			throw new IllegalArgumentException(TAMANHO_INVALIDO_O_VALOR_DEVE_SER_MAIOR_QUE_ZERO); // criei uma constante para passar a mensagem de erro
		}
		
		tabelaHash = new TabelaHash(tamanho);
		this.tamanho = tamanho;
	}
	
	private int calculaHash(int chave) {
		
		String chaveConvertida = String.valueOf(chave); // transforma os números em um tipo String
		int endereco = 0;
		for (int i = 0; i < chaveConvertida.length(); i++) {
			endereco = 31 * endereco + chaveConvertida.charAt(i);
		}
		return endereco % tamanho;
	}
	
	public int adicionar(Cliente novoCliente) {

		int enderecoAdicionado = calculaHash(novoCliente.getCodigo());

		if (tabelaHash.getElementos()[enderecoAdicionado] != null) {
			tabelaHash.getColisoes()[enderecoAdicionado].adicionaNoFinal(novoCliente);
		} else {
			tabelaHash.getElementos()[enderecoAdicionado] = novoCliente;
		}

		return enderecoAdicionado;

	}
	
	// Não teve Teste Unitário, porque eclipse da sala de aula estava numa versão sem JUnit
	public Cliente remover(int codigoClienteRemovido) {
	    int enderecoHashRemovido = calculaHash(codigoClienteRemovido);
	    
	    if (tabelaHash.getElementos()[enderecoHashRemovido] != null) {
	        if (tabelaHash.getElementos()[enderecoHashRemovido].getCodigo() == codigoClienteRemovido) {
	            Cliente clienteRemovido = tabelaHash.getElementos()[enderecoHashRemovido];
	            tabelaHash.getElementos()[enderecoHashRemovido] = null;
	            return clienteRemovido;
	        }
	        else {
	            int tamanhoListaColisoes = tabelaHash.getColisoes()[enderecoHashRemovido].pegaTotalElementos();
	            for (int i = 0; i < tamanhoListaColisoes; i++) {
	                Cliente clienteColisao = (Cliente) tabelaHash.getColisoes()[enderecoHashRemovido].pega(i);
	                if (clienteColisao.getCodigo() == codigoClienteRemovido) {
	                    Cliente clienteRemovido = clienteColisao;
	                    tabelaHash.getColisoes()[enderecoHashRemovido].removeNaPosicao(i);
	                    return clienteRemovido;
	                }
	            }
	        }
	    }
	    return null;
	}

	
	
	public Cliente buscarClienteCodigo(int codigoBuscado) {
		
		int enderecoBuscado = calculaHash(codigoBuscado);
		
		if (tabelaHash.getElementos()[enderecoBuscado] != null) {
			if (tabelaHash.getElementos()[enderecoBuscado].getCodigo() == codigoBuscado) {
				return tabelaHash.getElementos()[enderecoBuscado];
			}
			else {
				int tamanhoListaColisao = tabelaHash.getColisoes()[enderecoBuscado].pegaTotalElementos();
				if (tamanhoListaColisao != 0) {
					for (int i=0; i<tamanhoListaColisao; i++) {
						Cliente clienteColisao = (Cliente) tabelaHash.getColisoes()[enderecoBuscado].pega(i);
						if (clienteColisao.getCodigo() == codigoBuscado) {
							return clienteColisao;
						}
					}
				}
			}
			
		}
		return null;		
	}
	
}
