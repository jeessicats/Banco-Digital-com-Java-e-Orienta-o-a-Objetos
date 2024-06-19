package Banco_Digital;

public class Main {

    public static void main(String[] args) {
        Cliente jessica = new Cliente();
        jessica.setNome("Jéssica");

        Conta cc = new ContaCorrente(jessica);
        cc.depositar(100);

        Conta cp = new ContaPoupanca(jessica);
        cc.transferir(80, cp);

        cc.imprimirExtrato();
        cp.imprimirExtrato();

        ((ContaPoupanca) cp).calcularRendimento();
        cp.imprimirExtrato();
    }
}
