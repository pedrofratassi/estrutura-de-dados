package controller;

import model.Fila;
import model.Senha;
import model.TipoSenha;

public class FilaController {

    private Fila fila = new Fila();
    private int numeroSenhaNormal = 1;
    private int numeroSenhaPreferencial = 1;

    public void gerarSenha(TipoSenha tipo) {
        if (tipo == TipoSenha.NORMAL) {
            fila.adicionar(new Senha(numeroSenhaNormal++, TipoSenha.NORMAL));
        } else {
            fila.adicionar(new Senha(numeroSenhaPreferencial++, TipoSenha.PREFERENCIAL));
        }
    }

    public void chamarSenha() {
        if (!fila.estaVazia()) {
            Senha senhaChamada;
            if ((senhaChamada = fila.removerSenhaPreferencial()) != null) {
                System.out.println("Senha chamada: " + senhaChamada.getTipo() + " " + senhaChamada.getNumero() + " (Preferencial)");
            } else if ((senhaChamada = fila.removerSenhaNormal()) != null) {
                System.out.println("Senha chamada: " + senhaChamada.getTipo() + " " + senhaChamada.getNumero());
            } else {
                System.out.println("Senha esta Vazia");
            }
        } else {
            System.out.println("Senha esta Vazia");
        }
    }

    public Object getFila() {
        return fila;
    }

}
