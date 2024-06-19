package Banco_Digital;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements iConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    private static final double TAXA_SAQUE = 1.0; // Taxa para saques
    private static final double TAXA_TRANSFERENCIA = 1.5; // Taxa para transferências

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<String> historicoTransacoes;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.historicoTransacoes = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor + TAXA_SAQUE) {
            saldo -= valor + TAXA_SAQUE;
            historicoTransacoes.add(String.format("Saque: %.2f", valor));
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        historicoTransacoes.add(String.format("Depósito: %.2f", valor));
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (saldo >= valor + TAXA_TRANSFERENCIA) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            saldo -= TAXA_TRANSFERENCIA;
            historicoTransacoes.add(String.format("Transferência para conta %d: %.2f", contaDestino.getNumero(), valor));
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println("Histórico de Transações:");
        for (String transacao : historicoTransacoes) {
            System.out.println(transacao);
        }
    }
}
