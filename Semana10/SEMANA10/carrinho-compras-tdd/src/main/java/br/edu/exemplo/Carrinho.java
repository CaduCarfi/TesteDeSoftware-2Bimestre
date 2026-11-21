package br.edu.exemplo;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private static final double LIMITE_DESCONTO = 500.0;
    private static final double FATOR_DESCONTO = 0.90;

    private final List<Produto> produtos = new ArrayList<>();

    public void adicionar(Produto produto) {
        if (produto == null || produto.getPreco() < 0) {
            throw new IllegalArgumentException("Produto inválido");
        }
        produtos.add(produto);
    }

    public void remover(Produto produto) {
        produtos.remove(produto);
    }

    public double getTotal() {
        double subtotal = 0;
        for (Produto produto : produtos) {
            subtotal += produto.getPreco();
        }
        return subtotal >= LIMITE_DESCONTO ? subtotal * FATOR_DESCONTO : subtotal;
    }
}
