package ifsp.ed2.search;

import ifsp.ed2.model.Customer;

public class TabelaHash {
    private LinkedList<Customer>[] tabela;
    private int tamanho;
    private int tamanhoAtual;
    private static final double FATOR_CARGA_MAXIMO = 0.7;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        tabela = new LinkedList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<>();
        }
        tamanhoAtual = 0;
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
        int indice = hash(customer.getId());
        tabela[indice].add(customer);
        tamanhoAtual++;

        double fatorCarga = (double) tamanhoAtual / tamanho;
        if (fatorCarga > FATOR_CARGA_MAXIMO) {
            rehash();
        }
    }

    private void rehash() {
        int novoTamanho = tamanho * 2;
        LinkedList<Customer>[] novaTabela = new LinkedList[novoTamanho];
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
}

