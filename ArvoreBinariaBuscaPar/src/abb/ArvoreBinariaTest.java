package abb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArvoreBinariaTest {

	private ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
	private ArvoreBinariaBuilder builder = new ArvoreBinariaBuilder();

	@BeforeEach
	void inicializarArvore() {
		arvore = new ArvoreBinariaBusca();
	}

	@Test
	void deveRetornarEhVaziaSemRaiz() {
		assertTrue(arvore.ehVazia());
	}

	@Test
	void deveRetornarNaoEhVaziaComRaiz() {
		No noUm = new No(1, null, null);
		arvore.setRaiz(noUm);

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.pegaQuantidadeNos());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(1, arvore.pegaQuantidadeNos());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreComElementos() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		assertEquals(2, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		assertEquals(2, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		assertEquals(3, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		assertEquals(4, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();
		assertEquals(4, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoDoisEsquerdo();
		assertEquals(5, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertEquals(7, arvore.pegaQuantidadeNos());

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarAlturaSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.pegaAlturaDaArvore());
	}

	@Test
	void deveRetornarAlturaSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(0, arvore.pegaAlturaDaArvore());
	}

	@Test
	void deveRetornarAlturaSubNosArvoreComElementos() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		assertEquals(1, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		assertEquals(1, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		assertEquals(1, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		assertEquals(2, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();
		assertEquals(2, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoDoisEsquerdo();
		assertEquals(2, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertEquals(2, arvore.pegaAlturaDaArvore());

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarAlturaSubNosComElementos() {

		arvore = builder.montaArvoreCheiaDoisNiveis();
		No noTres = arvore.getRaiz().getEsquerdo();

		assertEquals(1, arvore.pegaAlturaDoNo(noTres));
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		No noRef = arvore.getRaiz();
		assertEquals(0, arvore.pegaProfundidadeDoNo(noRef));
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		No noRef = arvore.getRaiz();
		assertEquals(0, arvore.pegaProfundidadeDoNo(noRef));
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreComElementos() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		No noRef = arvore.getRaiz().getDireito();
		assertEquals(1, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		noRef = arvore.getRaiz().getEsquerdo();
		assertEquals(1, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		noRef = arvore.getRaiz().getDireito();
		assertEquals(1, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		noRef = arvore.getRaiz().getEsquerdo().getEsquerdo();
		assertEquals(2, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();
		noRef = arvore.getRaiz().getDireito().getDireito();
		assertEquals(2, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizDoisFilhoDireitoDoisEsquerdo();
		noRef = arvore.getRaiz().getDireito().getDireito();
		assertEquals(2, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		noRef = arvore.getRaiz().getEsquerdo().getEsquerdo();
		assertEquals(2, arvore.pegaProfundidadeDoNo(noRef));

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarNullSePegarNoArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertNull(arvore.pegarNoArvorePorValor(20));
	}

	@Test
	void deveRetornarNullSePegarNoNaoExistente() {
		arvore = builder.montaArvoreSoRaiz();
		assertNull(arvore.pegarNoArvorePorValor(20));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertNull(arvore.pegarNoArvorePorValor(20));
	}

	@Test
	void deveRetornarNoSePegarRaiz() {
		arvore = builder.montaArvoreSoRaiz();

		No noRetornado = arvore.pegarNoArvorePorValor(5);

		assertNotNull(noRetornado);
		assertEquals(5, noRetornado.getValor());
	}

	@Test
	void deveRetornarNoSePegarOutroElemento() {
		arvore = builder.montaArvoreCheiaDoisNiveis();

		No noRetornado = arvore.pegarNoArvorePorValor(3);

		assertNotNull(noRetornado);
		assertEquals(3, noRetornado.getValor());
	}

	@Test
	void deveRetornarFalseContemArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertFalse(arvore.contem(20));
	}

	@Test
	void deveRetornarFalseContemNoNaoExistente() {
		arvore = builder.montaArvoreSoRaiz();
		assertFalse(arvore.contem(20));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertFalse(arvore.contem(20));
	}

	@Test
	void deveRetornarTrueContemSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertTrue(arvore.contem(5));
	}

	@Test
	void deveRetornarNoComtemOutroElemento() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertTrue(arvore.contem(3));
		assertTrue(arvore.contem(4));
		assertTrue(arvore.contem(1));
	}


	@Test
	void adicionarNoArvoreVazia() {
		arvore = builder.montaArvoreVazia();

		arvore.adicionaNo(5);

		assertEquals(0, arvore.pegaAlturaDaArvore());
		assertEquals(5, arvore.getRaiz().getValor());
		assertTrue(arvore.contem(5));
	}

	@Test
	void adicionarNoArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();

		arvore.adicionaNo(7);

		assertEquals(1, arvore.pegaAlturaDaArvore());
		assertEquals(5, arvore.getRaiz().getValor());
		assertTrue(arvore.contem(7));
	}

	@Test
	void adicionarNoArvoreComElementosSoFilhoDireito() {

		arvore = builder.montaArvoreRaizFilhoDireito();

		arvore.adicionaNo(3);

		assertEquals(1, arvore.pegaAlturaDaArvore());
		assertEquals(5, arvore.getRaiz().getValor());
		assertTrue(arvore.contem(3));
	}

	@Test
	void adicionarNoArvoreComElementosSoFilhoEsquerdo() {

		arvore = builder.montaArvoreRaizFilhoEsquerdo();

		arvore.adicionaNo(7);

		assertEquals(1, arvore.pegaAlturaDaArvore());
		assertEquals(5, arvore.getRaiz().getValor());
		assertTrue(arvore.contem(7));
	}

	@Test
	void adicionarNoArvoreComElementosDoisFilhosDireitoEsquerdo() {

		arvore = builder.montaArvoreCheiaDoisNiveis();

		arvore.adicionaNo(2);

		assertEquals(3, arvore.pegaAlturaDaArvore());
		assertEquals(5, arvore.getRaiz().getValor());
		assertTrue(arvore.contem(2));
	}

	@Test
	void removerNoArvoreSoRaizValorExiste() {
		arvore = builder.montaArvoreSoRaiz();

		arvore.removeNoPorValor(5);
		assertFalse(arvore.contem(5));
		assertNull(arvore.getRaiz());
	}
	
	@Test
	void removerNoArvoreSoRaizValorNaoExiste() {
		arvore = builder.montaArvoreSoRaiz();

		arvore.removeNoPorValor(50);
		assertTrue(arvore.contem(5));
		assertNotNull(arvore.getRaiz());
	}

	@Test
	void removerNoArvoreNaoFolhaSoFilhoDireito() {

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();

		arvore.removeNoPorValor(7);

		assertEquals(5, arvore.getRaiz().getValor());
		assertFalse(arvore.contem(7));
		assertEquals(1, arvore.pegaAlturaDaArvore());
		
	}

	@Test
	void removerNoArvoreNaoFolhaSoFilhoEsquerdo() {

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		
		arvore.removeNoPorValor(3);

		assertEquals(5, arvore.getRaiz().getValor());
		assertFalse(arvore.contem(3));
		assertEquals(1, arvore.pegaAlturaDaArvore());
	}

	@Test
	void removerNoArvoreComElementosDoisFilhosDireitoEsquerdo() {

		arvore = builder.montaArvoreCheiaDoisNiveis();

		arvore.removeNoPorValor(5);

		assertEquals(6, arvore.getRaiz().getValor());
		assertFalse(arvore.contem(5));
	}
	
	@Test
	void removerNoArvoreEspecialParaExclusao() {
		
	
		arvore = builder.montaArvoreEspecialParaExclusao();

		arvore.removeNoPorValor(5);
		
		assertEquals(6, arvore.getRaiz().getEsquerdo().getValor());
		assertFalse(arvore.contem(5));
	}
	
	
    @Test
    public void deveRetornarArvoreZigueZagueVazia() {
        ArvoreBinariaBuilder builder = new ArvoreBinariaBuilder();
        ArvoreBinariaBusca arvore = builder.montaArvoreVazia();
        assertThrows(IllegalArgumentException.class, () -> arvore.imprimirZigueZague());
    }

    @Test
    public void deveImprimirZigueZagueComArvoreCheia() {
        ArvoreBinariaBuilder builder = new ArvoreBinariaBuilder();
        ArvoreBinariaBusca arvore = builder.montaArvoreVazia();
        arvore.adicionaNo(1);
        arvore.adicionaNo(2);
        arvore.adicionaNo(3);
        arvore.adicionaNo(4);
        arvore.adicionaNo(5);
        arvore.adicionaNo(6);
        arvore.adicionaNo(7);
        arvore.adicionaNo(8);
        arvore.adicionaNo(9);
        arvore.adicionaNo(10);
        
        
        arvore.imprimirZigueZague();     
    }
}
