package Banco_Digital;

import java.util.ArrayList;
import java.util.List;

public interface iConta {

    void sacar(double valor);
    void depositar(double valor);
    void transferir(double valor, Conta contaDestino);
    void imprimirExtrato();
}
