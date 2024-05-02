public class ArvoreBinariaBusca {

	protected No raiz;

	static final int CONTADOR_ESPACO = 5;

	public ArvoreBinariaBusca() {
		raiz = null;
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	public boolean ehVazia() {
		return raiz == null;
	}

	public int pegaQuantidadeNos() {
		return pegaQuantidadeNosDoSubNo(raiz);
	}

	public int pegaQuantidadeNosDoSubNo(No noReferencia) {
		if (noReferencia == null) {
			return 0;
		} else {
			return pegaQuantidadeNosDoSubNo(noReferencia.getEsquerdo()) + 1
					+ pegaQuantidadeNosDoSubNo(noReferencia.getDireito());
		}
	}

	public int pegaAlturaDoNo(No noReferencia) {
		if (noReferencia == null) {
			return 0;
		} else {
			return pegaAlturaDoSubNo(noReferencia) - 1;
		}
	}

	private int pegaAlturaDoSubNo(No noReferencia) {
		if (noReferencia == null) {
			return 0;
		}
		int alturaDireita = pegaAlturaDoSubNo(noReferencia.getDireito()); // 2
		int alturaEsquerda = pegaAlturaDoSubNo(noReferencia.getEsquerdo()); // 0

		return 1 + Math.max(alturaDireita, alturaEsquerda);
	}

	public int pegaAlturaDaArvore() {
		return pegaAlturaDoNo(raiz);
	}

	public int pegaProfundidadeDoNo(No noBuscado) {

		if (noBuscado == null) {
			return 0;
		} else {
			return pegaProfundidadeDoNoAteRaiz(raiz, noBuscado) - 1;
		}
	}

	protected int pegaProfundidadeDoNoAteRaiz(No noReferencia, No noBuscado) {
		if (noReferencia == null) {
			return 0;
		} else {
			if (noBuscado.getValor() == noReferencia.getValor()) {
				return 1;
			}

			if (noBuscado.getValor() < noReferencia.getValor()) {
				return 1 + pegaProfundidadeDoNoAteRaiz(noReferencia.getEsquerdo(), noBuscado);
			} else {
				return 1 + pegaProfundidadeDoNoAteRaiz(noReferencia.getDireito(), noBuscado);
			}
		}
	}

	public No pegarNoArvorePorValor(int valorBuscado) {

		No atual = raiz;
		while (atual != null) {
			if (valorBuscado == atual.getValor()) {
				return atual;
			} else if (valorBuscado < atual.getValor()) {
				atual = atual.getEsquerdo();
			} else {
				atual = atual.getDireito();
			}
		}
		return null;
	}

	public boolean contem(int valorBuscado) {

		return (pegarNoArvorePorValor(valorBuscado) != null);
	}

	public void adicionaNo(int valorNoAdicionado) {

		if (raiz == null) {
			raiz = new No(valorNoAdicionado, null, null);
		} else {
			No atual = raiz;
			while (true) {
				if (valorNoAdicionado < atual.getValor()) {
					if (atual.getEsquerdo() == null) {
						atual.setEsquerdo(new No(valorNoAdicionado, null, null));
						return;
					}
					atual = atual.getEsquerdo();
				} else if (valorNoAdicionado > atual.getValor()) {
					if (atual.getDireito() == null) {
						atual.setDireito(new No(valorNoAdicionado, null, null));
						return;
					}
					atual = atual.getDireito();
				} else {
					return; // Valor já existe na árvore, não faz nada
				}
			}
		}
	}

	public void removeNoPorValor(int valorARemover) {

		No pai = null;
		No atual = raiz;
		while (atual != null) {
			if (valorARemover == atual.getValor()) {
				if (atual.ehFolha()) {
					removerNoFolha(pai, atual);
				} else if (atual.getDireito() == null) {
					removerSoFilhoEsquerdo(pai, atual);
				} else if (atual.getEsquerdo() == null) {
					removerSoFilhoDireito(pai, atual);
				} else {
					No sucessor = buscarSucessor(atual);
					int valorSucessor = sucessor.getValor();
					removeNoPorValor(valorSucessor);
					atual.setValor(valorSucessor);
				}
				return;
			} else if (valorARemover < atual.getValor()) {
				pai = atual;
				atual = atual.getEsquerdo();
			} else {
				pai = atual;
				atual = atual.getDireito();
			}
		}
	}

	private void removerSoFilhoDireito(No pai, No atual) {
		if (pai == null) {
			raiz = atual.getDireito();
		} else {
			if (pai.getEsquerdo() == atual) {
				pai.setEsquerdo(atual.getDireito());
			} else {
				pai.setDireito(atual.getDireito());
			}
		}
	}

	private void removerSoFilhoEsquerdo(No pai, No atual) {
		if (pai == null) {
			raiz = atual.getEsquerdo();
		} else {
			if (pai.getEsquerdo() == atual) {
				pai.setEsquerdo(atual.getEsquerdo());
			} else {
				pai.setDireito(atual.getEsquerdo());
			}
		}
	}

	private void removerNoFolha(No pai, No atual) {
		if (pai == null) {
			raiz = null;
		} else {
			if (pai.getEsquerdo() == atual) {
				pai.setEsquerdo(null);
			} else {
				pai.setDireito(null);
			}
		}
	}

	private No buscarSucessor(No noAtual) {
		No sucessor = noAtual.getDireito();
		while (sucessor.getEsquerdo() != null) {
			sucessor = sucessor.getEsquerdo();
		}
		return sucessor;
	}

	public void imprimirPreOrder() {
		percorrerPreOrder(raiz);
	}

	private void percorrerPreOrder(No noReferencia) {
		if (noReferencia != null) {
			System.out.println(noReferencia.getValor());
			percorrerPreOrder(noReferencia.getEsquerdo());
			percorrerPreOrder(noReferencia.getDireito());
		}
	}

	public void imprimirInOrder() {
		percorrerInOrder(raiz);
	}

	private void percorrerInOrder(No noReferencia) {
		if (noReferencia != null) {
			percorrerInOrder(noReferencia.getEsquerdo());
			System.out.println(noReferencia.getValor());
			percorrerInOrder(noReferencia.getDireito());
		}
	}

	public void imprimirPosOrder() {
		percorrerPosOrder(raiz);
	}

	private void percorrerPosOrder(No noReferencia) {
		if (noReferencia != null) {
			percorrerPosOrder(noReferencia.getEsquerdo());
			percorrerPosOrder(noReferencia.getDireito());
			System.out.println(noReferencia.getValor());
		}
	}

	public void imprimir2DArvore() {
		print2DUtil(raiz, 0);
	}

	private void print2DUtil(No noReferencia, int space) {
		if (noReferencia == null) {
			return;
		}
		space += CONTADOR_ESPACO;
		print2DUtil(noReferencia.getDireito(), space);

		System.out.print("\n");
		for (int i = CONTADOR_ESPACO; i < space; i++)
			System.out.print(" ");
		System.out.print(noReferencia.getValor() + "\n");

		print2DUtil(noReferencia.getEsquerdo(), space);
	}

	// Método Exigido: retornar o maior	valor (chave) (ACERTEI)
	public int retornarMaiorValor() {

		No atual = raiz;

	    while (atual.getDireito() != null) {
	        atual = atual.getDireito();
		} 
		
	    return atual.getValor();
	}


	// Método Exigido 01: retornar a quantidade de números pares (chave) (ERREI)
//	public int pegaQuantidadeDeNumerosPares(int valorBuscado) {
//		if (valorBuscado % 2 == 0) {
//			return valorBuscado++;
//		}
//		return valorBuscado;
//	}
	
	// Método Exigido 02: retornar a quantidade de números pares (chave) (O JEITO CERTO DE RESOLVER O MÉTODO 02)
	public int pegaQuantidadeDeNumerosPares() {
	    return pegaQuantidadeDeNumerosParesRecursivo(raiz);
	}

	private int pegaQuantidadeDeNumerosParesRecursivo(No noReferencia) {
	    if (noReferencia == null) {
	        return 0;
	    }

	    int quantidadePares = 0;

	    // Verifica se o valor do nó atual é par
	    if (noReferencia.getValor() % 2 == 0) {
	        quantidadePares++;
	    }

	    // Chama recursivamente para os filhos esquerdo e direito
	    quantidadePares += pegaQuantidadeDeNumerosParesRecursivo(noReferencia.getEsquerdo());
	    quantidadePares += pegaQuantidadeDeNumerosParesRecursivo(noReferencia.getDireito());

	    return quantidadePares;
	}


}
