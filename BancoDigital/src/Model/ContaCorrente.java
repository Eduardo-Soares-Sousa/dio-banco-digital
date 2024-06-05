package Model;

public class ContaCorrente extends Conta {
    public ContaCorrente() {
        super();
    }

    @Override
    public void imprimirDadosConta() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosConta();
    }

    @Override
    public String toString() {
        return "Conta Corrente";
    }
}
