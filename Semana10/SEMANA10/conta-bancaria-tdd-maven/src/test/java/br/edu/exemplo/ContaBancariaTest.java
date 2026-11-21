package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContaBancariaTest {

    @Test
    void deveDepositarValorNaConta() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        assertEquals(100, conta.getSaldo(), 0.001);
    }

    @Test
    void deveAcumularDepositos() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        conta.depositar(50);
        assertEquals(150, conta.getSaldo(), 0.001);
    }

    @Test
    void deveSacarValorDaConta() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        conta.sacar(40);
        assertEquals(60, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDevePermitirSaqueMaiorQueSaldo() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        conta.sacar(150);
        assertEquals(100, conta.getSaldo(), 0.001);
    }

    @Test
    void contaDeveIniciarComSaldoZero() {
        assertEquals(0, new ContaBancaria().getSaldo(), 0.001);
    }

    @Test
    void naoDeveDepositarValorNegativo() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(-50);
        assertEquals(0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveDepositarValorZero() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(0);
        assertEquals(0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveSacarValorNegativoOuZero() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        conta.sacar(-10);
        conta.sacar(0);
        assertEquals(100, conta.getSaldo(), 0.001);
    }

    @Test
    void devePermitirSacarTodoOSaldo() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        conta.sacar(100);
        assertEquals(0, conta.getSaldo(), 0.001);
    }
}
