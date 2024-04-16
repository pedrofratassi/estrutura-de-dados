package abb;

public class Contato {
    private int codigo;
    private String nome;
    private String telefone;

    public Contato(int codigo, String nome, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
  
    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Telefone: " + telefone;
    }
}
