package model;

public class Fila {
    private ListaLigada lista = new ListaLigada();

    public void adicionar(Senha senha) {
        lista.adicionar(senha);
    }

    public Senha removerSenhaPreferencial() {
        return lista.removerSenhaPreferencial();
    }

    public Senha removerSenhaNormal() {
        return lista.removerSenhaNormal();
    }

    public boolean estaVazia() {
        return lista.tamanho() == 0;
    }

    public boolean contemSenhaNormal() {
        return lista.contemSenhaNormal();
    }
}
