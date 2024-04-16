package abb;

public class Agenda {
    private ArvoreBinariaBusca arvoreContatos;

    public Agenda() {
        arvoreContatos = new ArvoreBinariaBusca();
    }

    public void adicionarContato(int codigo, String nome, String telefone) {
        Contato novoContato = new Contato(codigo, nome, telefone);
        arvoreContatos.adicionarContato(novoContato);
    }


    public Contato pesquisarContato(int codigo) {
        return arvoreContatos.pegarContatoPorCodigo(codigo);
    }

    public void listarContatosEmOrdemAlfabetica() {
        arvoreContatos.listarContatosEmOrdemAlfabetica();
    }

    public void removerContato(int codigo) {
        arvoreContatos.removerContatoPorCodigo(codigo);
    }
}

