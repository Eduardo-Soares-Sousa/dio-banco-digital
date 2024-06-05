package Model;

import java.util.Objects;

public class Cliente implements Comparable<Cliente> {
    private String nome;
    private String cpf;
    private int idade;
    private Conta conta;

    public Cliente(String nome, String cpf, int idade, TipoDaConta tipoDaConta) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        if(tipoDaConta == TipoDaConta.CORRENTE){
            this.conta = new ContaCorrente();
        }else if(tipoDaConta == TipoDaConta.POUPANCA){
            this.conta = new ContaPoupanca();
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public Conta getConta() {
        return conta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(getCpf(), cliente.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpf());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", tipo de conta=" + conta +
                '}';
    }

    @Override
    public int compareTo(Cliente o) {
        return nome.compareTo(o.getNome());
    }
}
