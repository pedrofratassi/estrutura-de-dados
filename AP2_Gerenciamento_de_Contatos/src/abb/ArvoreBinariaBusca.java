package abb;

public class ArvoreBinariaBusca {

    private No raiz;

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
        int alturaDireita = pegaAlturaDoSubNo(noReferencia.getDireito());
        int alturaEsquerda = pegaAlturaDoSubNo(noReferencia.getEsquerdo());

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

    private int pegaProfundidadeDoNoAteRaiz(No noReferencia, No noBuscado) {
        if (noReferencia == null) {
            return 0;
        } else {
            if (noBuscado.getElemento().getCodigo() == noReferencia.getElemento().getCodigo()) {
                return 1;
            }

            if (noBuscado.getElemento().getCodigo() < noReferencia.getElemento().getCodigo()) {
                return 1 + pegaProfundidadeDoNoAteRaiz(noReferencia.getEsquerdo(), noBuscado);
            } else {
                return 1 + pegaProfundidadeDoNoAteRaiz(noReferencia.getDireito(), noBuscado);
            }
        }
    }

    public No pegarNoArvorePorValor(int valorBuscado) {
        No atual = raiz;
        while (atual != null) {
            if (valorBuscado == atual.getElemento().getCodigo()) {
                return atual;
            } else if (valorBuscado < atual.getElemento().getCodigo()) {
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

    public void adicionaNo(int valorNoAdicionado, Contato elemento) {
        raiz = inserirNo(raiz, valorNoAdicionado, elemento);
    }

    private No inserirNo(No atual, int valorNoAdicionado, Contato elemento) {
        if (atual == null) {
            return new No(elemento);
        }

        if (valorNoAdicionado < atual.getElemento().getCodigo()) {
            atual.setEsquerdo(inserirNo(atual.getEsquerdo(), valorNoAdicionado, elemento));
        } else if (valorNoAdicionado > atual.getElemento().getCodigo()) {
            atual.setDireito(inserirNo(atual.getDireito(), valorNoAdicionado, elemento));
        } else {
            System.out.println("O contato com o código " + valorNoAdicionado + " já está na agenda. Duplicatas não são permitidas.");
        }

        return atual;
    }

    public void removeNoPorValor(int valorARemover) {

        No pai = null;
        No atual = raiz;
        while (atual != null) {
            if (valorARemover == atual.getElemento().getCodigo()) {
                if (atual.ehFolha()) {
                    removerNoFolha(pai, atual);
                } else if (atual.getDireito() == null) {
                    removerSoFilhoEsquerdo(pai, atual);
                } else if (atual.getEsquerdo() == null) {
                    removerSoFilhoDireito(pai, atual);
                } else {
                    No sucessor = buscarSucessor(atual);
                    int valorSucessor = sucessor.getElemento().getCodigo();
                    removeNoPorValor(valorSucessor);
                   // atual.getElemento().setCodigo(valorSucessor);
                }
                return;
            } else if (valorARemover < atual.getElemento().getCodigo()) {
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

    private No buscarSucessor(No no) {
        No sucessor = no.getDireito();
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
            System.out.println(noReferencia.getElemento().getCodigo());
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
            System.out.println(noReferencia.getElemento().getCodigo());
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
            System.out.println(noReferencia.getElemento().getCodigo());
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
        System.out.print(noReferencia.getElemento().getCodigo() + "\n");

        print2DUtil(noReferencia.getEsquerdo(), space);
    }

    public boolean contemContato(int codigo) {
        return pegarNoArvorePorValor(codigo) != null;
    }

    public void adicionarContato(Contato contato) {
        raiz = inserirContato(raiz, contato);
    }

    private No inserirContato(No atual, Contato novoContato) {
        if (atual == null) {
            return new No(novoContato);
        }

        int comp = novoContato.getNome().compareTo(atual.getElemento().getNome());
        if (comp < 0) {
            atual.setEsquerdo(inserirContato(atual.getEsquerdo(), novoContato));
        } else if (comp > 0) {
            atual.setDireito(inserirContato(atual.getDireito(), novoContato));
        } else {
            System.out.println("O contato com o nome " + novoContato.getNome() + " já está na agenda. Duplicatas não são permitidas.");
        }

        return atual;
    }

    public Contato pegarContatoPorCodigo(int codigo) {
        No no = pegarNoArvorePorValor(codigo);
        if (no != null) {
            return no.getElemento();
        }
        return null;
    }

    public void removerContatoPorCodigo(int codigo) {
        removeNoPorValor(codigo);
    }

    public void listarContatosEmOrdemAlfabetica() {
        listarContatosEmOrdemAlfabetica(raiz);
    }

    private void listarContatosEmOrdemAlfabetica(No no) {
        if (no != null) {
            listarContatosEmOrdemAlfabetica(no.getEsquerdo());
            System.out.println(no.getElemento().getNome());
            listarContatosEmOrdemAlfabetica(no.getDireito());
        }
    }

    public Contato pesquisarContato(int codigo) {
        return pesquisarContatoRecursivo(raiz, codigo);
    }

    private Contato pesquisarContatoRecursivo(No no, int codigo) {
        if (no == null) {
            return null;
        }
        if (no.getElemento().getCodigo() == codigo) {
            return no.getElemento();
        } else if (codigo < no.getElemento().getCodigo()) {
            return pesquisarContatoRecursivo(no.getEsquerdo(), codigo);
        } else {
            return pesquisarContatoRecursivo(no.getDireito(), codigo);
        }
    }

}
