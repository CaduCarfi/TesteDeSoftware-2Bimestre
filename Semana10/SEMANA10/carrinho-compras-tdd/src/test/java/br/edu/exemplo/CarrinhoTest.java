package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarrinhoTest {

    private static final double DELTA = 0.001;

    @Test
    void produtoDeveExporNomeEPreco() {
        Produto produto = new Produto("Teclado", 100);

        assertEquals("Teclado", produto.getNome());
        assertEquals(100, produto.getPreco(), DELTA);
    }

    // Requisito 1
    @Test
    void carrinhoNovoDeveTerTotalZero() {
        Carrinho carrinho = new Carrinho();

        assertEquals(0, carrinho.getTotal(), DELTA);
    }

    // Requisito 2
    @Test
    void deveAdicionarUmProduto() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Teclado", 100));

        assertEquals(100, carrinho.getTotal(), DELTA);
    }

    // Requisito 3
    @Test
    void deveSomarVariosProdutos() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Teclado", 100));
        carrinho.adicionar(new Produto("Mouse", 50));

        assertEquals(150, carrinho.getTotal(), DELTA);
    }

    // Requisito 4
    @Test
    void deveRemoverProduto() {
        Carrinho carrinho = new Carrinho();
        Produto teclado = new Produto("Teclado", 100);
        Produto mouse = new Produto("Mouse", 50);
        carrinho.adicionar(teclado);
        carrinho.adicionar(mouse);

        carrinho.remover(mouse);

        assertEquals(100, carrinho.getTotal(), DELTA);
    }

    @Test
    void removerProdutoAusenteNaoDeveAlterarTotal() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Produto("Teclado", 100));

        carrinho.remover(new Produto("Mouse", 50));

        assertEquals(100, carrinho.getTotal(), DELTA);
    }

    // Requisito 5 (decisão: lançar exceção)
    @Test
    void deveLancarExcecaoParaPrecoNegativo() {
        Carrinho carrinho = new Carrinho();

        assertThrows(IllegalArgumentException.class,
                () -> carrinho.adicionar(new Produto("Teclado", -100)));
        assertEquals(0, carrinho.getTotal(), DELTA);
    }

    @Test
    void deveLancarExcecaoParaProdutoNulo() {
        Carrinho carrinho = new Carrinho();

        assertThrows(IllegalArgumentException.class, () -> carrinho.adicionar(null));
    }

    @Test
    void devePermitirProdutoGratuito() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Brinde", 0));

        assertEquals(0, carrinho.getTotal(), DELTA);
    }

    // Requisito 6
    @Test
    void deveAplicarDescontoDe10PorCentoAcimaDe500() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Monitor", 600));

        assertEquals(540, carrinho.getTotal(), DELTA);
    }

    @Test
    void naoDeveAplicarDescontoEm499e99() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Item", 499.99));

        assertEquals(499.99, carrinho.getTotal(), DELTA);
    }

    @Test
    void deveAplicarDescontoEmExatamente500() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Item", 500));

        assertEquals(450, carrinho.getTotal(), DELTA);
    }

    @Test
    void deveAplicarDescontoEm500e01() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Item", 500.01));

        assertEquals(450.009, carrinho.getTotal(), DELTA);
    }

    @Test
    void descontoDeveConsiderarSomaDeVariosProdutos() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("A", 300));
        carrinho.adicionar(new Produto("B", 300));

        assertEquals(540, carrinho.getTotal(), DELTA);
    }
}
