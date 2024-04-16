package abb;

public class No {

    private Contato elemento;
    private No direito;
    private No esquerdo;

    public No(Contato elemento) {
        this.elemento = elemento;
        this.direito = null;
        this.esquerdo = null;
    }

    public Contato getElemento() {
        return elemento;
    }

    public No getDireito() {
        return direito;
    }

    public void setDireito(No direito) {
        this.direito = direito;
    }

    public No getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(No esquerdo) {
        this.esquerdo = esquerdo;
    }

    public boolean ehFolha() {
        return (direito == null && esquerdo == null);
    }
}
