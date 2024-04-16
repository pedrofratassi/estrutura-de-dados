package testes;

import controller.FilaController;
import model.Fila;
import model.TipoSenha;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FilaControllerTest {

    @Test
    public void testGerarSenhaNormal() {
        FilaController filaController = new FilaController();
        filaController.gerarSenha(TipoSenha.NORMAL);
        Fila fila = (Fila) filaController.getFila(); 
        assertFalse(fila.estaVazia());
    }

    @Test
    public void testGerarSenhaPreferencial() {
        FilaController filaController = new FilaController();
        filaController.gerarSenha(TipoSenha.PREFERENCIAL);
        Fila fila = (Fila) filaController.getFila(); 
        assertFalse(fila.estaVazia());
    }
    
    @Test
    public void testChamarSenhaPreferencial() {
        FilaController filaController = new FilaController();
        filaController.gerarSenha(TipoSenha.PREFERENCIAL);
        filaController.chamarSenha();
        assertTrue(((Fila) filaController.getFila()).estaVazia());
    }

    @Test
    public void testChamarSenhaNormal() {
        FilaController filaController = new FilaController();
        filaController.gerarSenha(TipoSenha.NORMAL);
        filaController.chamarSenha();
        assertTrue(((Fila) filaController.getFila()).estaVazia());
    }

    @Test
    public void testChamarSenhaVazia() {
        FilaController filaController = new FilaController();
        filaController.chamarSenha();
        assertTrue(((Fila) filaController.getFila()).estaVazia());
    }
}
