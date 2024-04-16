package model;

public class Senha {
    private int numero;
    private TipoSenha tipo;

    public Senha(int numero, TipoSenha tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public TipoSenha getTipo() {
        return tipo;
    }
}
