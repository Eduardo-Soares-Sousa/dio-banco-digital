package Model;

import Repository.IConta;

public class Conta implements IConta {
    private static final String NOME_BANCO = "North Bank";
    private static final int NUMERO_AGENCIA = 4041;
    private static int CONTA_SEQUENCIAL = 1;

    private String nomeBanco;
    private int agencia;
    private int numeroConta;
    private double saldo;

    public Conta(String nomeBanco, int agencia, int numeroConta, double saldo) {
        this.nomeBanco = NOME_BANCO;
        this.agencia = NUMERO_AGENCIA;
        this.numeroConta = CONTA_SEQUENCIAL++;
        this.saldo = saldo;
    }

    @Override
    public void sacar(double valor) {

    }

    @Override
    public void depositar(double valor) {

    }

    @Override
    public void transferir(double valor, IConta contaDestino) {

    }

    @Override
    public void solicitarEmprestimo(double valor) {

    }
}
