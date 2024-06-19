package Banco_Digital;

public class ContaPoupanca extends Conta {

    private static final double RENDIMENTO = 0.05; // 5% de rendimento ao ano

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void calcularRendimento() {
        double rendimento = saldo * RENDIMENTO;
        depositar(rendimento);
        historicoTransacoes.add(String.format("Rendimento: %.2f", rendimento));
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato da Conta Poupança ***");
        super.imprimirInfosComuns();
    }
}
