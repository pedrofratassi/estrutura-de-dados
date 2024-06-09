package ifsp.ed2.search;

import ifsp.ed2.model.Customer;

public class TabelaHash {
    private LinkedList<Customer>[] tabela;
    private int tamanho;
    private int tamanhoAtual;
    private double fatorCargaMaximo;

    private static final int[] PRIMOS = {
        31, 61, 127, 257, 521, 1031, 2053, 4099, 8209, 16411, 32771, 65537, 131101, 262147, 524309, 1048583, 2097169, 4194319, 8388617, 16777259
    };

    @SuppressWarnings("unchecked")
    public TabelaHash(int tamanhoInicial, double fatorCargaMaximo) {
        this.tamanho = proximoPrimo(tamanhoInicial);
        this.fatorCargaMaximo = fatorCargaMaximo;
        tabela = (LinkedList<Customer>[]) new LinkedList[this.tamanho];
        for (int i = 0; i < this.tamanho; i++) {
            tabela[i] = new LinkedList<>();
        }
        tamanhoAtual = 0;
    }

    private int proximoPrimo(int tamanho) {
        for (int primo : PRIMOS) {
            if (primo > tamanho) {
                return primo;
            }
        }
        throw new IllegalArgumentException("Tamanho muito grande");
    }

    public boolean contemCliente(int id) {
        int indice = hash(id);
        LinkedList<Customer> lista = tabela[indice];
        for (Customer customer : lista) {
            if (customer.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void adicionar(Customer customer) {
        if (contemCliente(customer.getId())) {
            return;
        }
        int indice = hash(customer.getId());
        tabela[indice].add(customer);
        tamanhoAtual++;

        double fatorCarga = (double) tamanhoAtual / tamanho;
        if (fatorCarga > fatorCargaMaximo) {
            rehash();
        }
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        int novoTamanho = proximoPrimo(tamanho * 4);  // Aumente o tamanho da tabela por um fator de 4
        LinkedList<Customer>[] novaTabela = (LinkedList<Customer>[]) new LinkedList[novoTamanho];
        for (int i = 0; i < novoTamanho; i++) {
            novaTabela[i] = new LinkedList<>();
        }
        for (LinkedList<Customer> lista : tabela) {
            for (Customer customer : lista) {
                int novoIndice = hash(customer.getId(), novoTamanho);
                novaTabela[novoIndice].add(customer);
            }
        }
        tabela = novaTabela;
        tamanho = novoTamanho;
    }

    private int hash(int id) {
        return id % tamanho;
    }

    private int hash(int id, int novoTamanho) {
        return id % novoTamanho;
    }

    public int tamanho() {
        return tamanho;
    }

    public int tamanhoAtual() {
        return tamanhoAtual;
    }
}
