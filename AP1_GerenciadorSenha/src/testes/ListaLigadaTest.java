package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.ListaLigada;
import model.Senha;
import model.TipoSenha;

class ListaLigadaTest {

    @Test
    public void testAdicionar() {
        ListaLigada lista = new ListaLigada();
        assertEquals(0, lista.tamanho());

        Senha senha1 = new Senha(1, TipoSenha.NORMAL);
        lista.adicionar(senha1);
        assertEquals(1, lista.tamanho());

        Senha senha2 = new Senha(2, TipoSenha.PREFERENCIAL);
        lista.adicionar(senha2);
        assertEquals(2, lista.tamanho());
    }

    @Test
    public void testRemoverSenhaPreferencial() {
        ListaLigada lista = new ListaLigada();
        Senha senha1 = new Senha(1, TipoSenha.PREFERENCIAL);
        Senha senha2 = new Senha(2, TipoSenha.NORMAL);
        lista.adicionar(senha1);
        lista.adicionar(senha2);

        Senha senhaRemovida = lista.removerSenhaPreferencial();
        assertEquals(1, lista.tamanho());
        assertEquals(senha1, senhaRemovida);
        assertTrue(lista.contemSenhaNormal());
    }

    @Test
    public void testRemoverSenhaNormal() {
        ListaLigada lista = new ListaLigada();
        Senha senha1 = new Senha(1, TipoSenha.NORMAL);
        Senha senha2 = new Senha(2, TipoSenha.PREFERENCIAL);
        lista.adicionar(senha1);
        lista.adicionar(senha2);

        Senha senhaRemovida = lista.removerSenhaNormal();
        assertEquals(1, lista.tamanho());
        assertEquals(senha1, senhaRemovida);
        assertFalse(lista.contemSenhaNormal());
    }

    @Test
    public void testContemSenhaNormal() {
        ListaLigada lista = new ListaLigada();
        assertFalse(lista.contemSenhaNormal());

        Senha senha1 = new Senha(1, TipoSenha.NORMAL);
        Senha senha2 = new Senha(2, TipoSenha.PREFERENCIAL);
        lista.adicionar(senha1);
        lista.adicionar(senha2);

        assertTrue(lista.contemSenhaNormal());
    }

}
