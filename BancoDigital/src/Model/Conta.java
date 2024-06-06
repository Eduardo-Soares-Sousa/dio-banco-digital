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
        if(valor < saldo){
            saldo -= valor;
            System.out.println("Saque efetuado com sucesso.");
        }else{
            System.out.println("Impossível realizar o saque. O valor a ser sacado supera seu saldo.");
        }
    }

    @Override
    public void depositar(double valor) {
        if(valor > 0){
            saldo += valor;
            System.out.println("Deposito efetuado com sucesso.");
        }else{
            System.out.println("Impossível realizar o deposito. O valor que deseja depositar não pode ser negativo.");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(valor < saldo && valor <= saldo){
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada com sucesso.");
        }else if(valor < 0){
            System.out.println("Impossível realizar a transferência. O valor solicitado não pode ser negativo.");
        }else{
            System.out.println("Impossível realizar a transferência. O valor solicitado supera seu saldo.");
        }
    }

    @Override
    public void solicitarEmprestimo(double valor) {
        if(valor < 10000.00){
            this.depositar(valor);
            System.out.println("Você tem 1 ano e 6 messes para pagar o empréstimo, com acrescimo de 40% do valor retirado.");
            System.out.println("O valor a ser pago será de: R$ " + valorPagoEmprestimo(valor));
        }else if(valor > 10000.00){
            System.out.println("Impossível realizar o empréstimo. O valor solicitado é superior ao limite de R$ 10.000,00.");
        }else{
            System.out.println("Impossível realizar o empréstimo. O valor solicitado não pode ser negativo.");
        }
    }

    public double valorPagoEmprestimo(double valor){
        double totalPago = valor;
        return totalPago += ((valor * 40) / 100);
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
