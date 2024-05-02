import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArvoreBinariaBuscaTeste {

	private ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
	
	@BeforeEach
	void inicializarArvore() {
		arvore = new ArvoreBinariaBusca();
	}


	@Test
	void deveRetornarMaiorValor() {
		assertTrue(arvore.ehVazia());
		arvore.adicionaNo(2);
		arvore.adicionaNo(4);
		arvore.adicionaNo(6);
		assertEquals(6, arvore.retornarMaiorValor());
		
	} 
	
	 @Test
	    public void testPegaQuantidadeDeNumerosPares() {
	        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
	        arvore.adicionaNo(10);
	        arvore.adicionaNo(5);
	        arvore.adicionaNo(15);
	        arvore.adicionaNo(8);
	        arvore.adicionaNo(12);
	        arvore.adicionaNo(20);
	        
	        assertEquals(4, arvore.pegaQuantidadeDeNumerosPares());
	    }
		
}
