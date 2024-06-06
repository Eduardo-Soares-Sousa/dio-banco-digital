package Repository;

import Model.Conta;

public interface IConta {
    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, Conta contaDestino);

    void solicitarEmprestimo(double valor);

    void imprimirDadosConta();

    void imprimirInfosConta();
}