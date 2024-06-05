package Model;

import Repository.IConta;

public abstract class Conta implements IConta {
    private static final String NOME_BANCO = "North Bank";
    private static final int NUMERO_AGENCIA = 4041;
    private static int CONTA_SEQUENCIAL = 1;

    private String nomeBanco;
    private int agencia;
    private int numeroConta;
    private double saldo;
    protected Cliente cliente;

    public Conta() {
        this.nomeBanco = NOME_BANCO;
        this.agencia = NUMERO_AGENCIA;
        this.numeroConta = CONTA_SEQUENCIAL++;
        this.saldo = 0.0;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void solicitarEmprestimo(double valor) {

    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void imprimirInfosConta() {
        System.out.println("Nome do Banco: " + this.nomeBanco);
        System.out.println("Número da Agencia: " + this.agencia);
        System.out.println("Número da Conta: " + this.numeroConta);
        System.out.println("Saldo disponível: " + this.saldo);
    }
}
