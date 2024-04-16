package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Fila;
import model.Senha;
import model.TipoSenha;

class FilaTest {

	@Test
    public void testAdicionar() {
        Fila fila = new Fila();
        assertEquals(true, fila.estaVazia());
        
        Senha senhaNormal = new Senha(1, TipoSenha.NORMAL);
        fila.adicionar(senhaNormal);
        assertEquals(false, fila.estaVazia());
        
        Senha senhaPreferencial = new Senha(1, TipoSenha.PREFERENCIAL);
        fila.adicionar(senhaPreferencial);
        assertEquals(false, fila.estaVazia());
    }

    @Test
    public void testRemoverSenhaPreferencial() {
        Fila fila = new Fila();
        assertNull(fila.removerSenhaPreferencial());
        
        Senha senhaPreferencial1 = new Senha(1, TipoSenha.PREFERENCIAL);
        Senha senhaPreferencial2 = new Senha(2, TipoSenha.PREFERENCIAL);
        fila.adicionar(senhaPreferencial1);
        fila.adicionar(senhaPreferencial2);
        
        assertEquals(senhaPreferencial1, fila.removerSenhaPreferencial());
        assertEquals(senhaPreferencial2, fila.removerSenhaPreferencial());
        assertNull(fila.removerSenhaPreferencial());
    }

    @Test
    public void testRemoverSenhaNormal() {
        Fila fila = new Fila();
        assertNull(fila.removerSenhaNormal());
        
        Senha senhaNormal1 = new Senha(1, TipoSenha.NORMAL);
        Senha senhaNormal2 = new Senha(2, TipoSenha.NORMAL);
        fila.adicionar(senhaNormal1);
        fila.adicionar(senhaNormal2);
        
        assertEquals(senhaNormal1, fila.removerSenhaNormal());
        assertEquals(senhaNormal2, fila.removerSenhaNormal());
        assertNull(fila.removerSenhaNormal());
    }

    @Test
    public void testEstaVazia() {
        Fila fila = new Fila();
        assertTrue(fila.estaVazia());
        
        Senha senhaNormal = new Senha(1, TipoSenha.NORMAL);
        fila.adicionar(senhaNormal);
        assertFalse(fila.estaVazia());
        

        fila.removerSenhaNormal();
        assertTrue(fila.estaVazia());
    }

    @Test
    public void testContemSenhaNormal() {
        Fila fila = new Fila();
        assertFalse(fila.contemSenhaNormal());
        
        Senha senhaNormal1 = new Senha(1, TipoSenha.NORMAL);
        Senha senhaNormal2 = new Senha(2, TipoSenha.NORMAL);
        fila.adicionar(senhaNormal1);
        fila.adicionar(senhaNormal2);
        
        assertTrue(fila.contemSenhaNormal());
        
        fila.removerSenhaNormal();
        assertTrue(fila.contemSenhaNormal());
        
        fila.removerSenhaNormal();
        assertFalse(fila.contemSenhaNormal());
    }

}
