package Model;

public class ContaPoupanca extends Conta {
    public ContaPoupanca() {
        super();
    }

    @Override
    public void imprimirDadosConta() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosConta();
    }

    @Override
    public String toString() {
        return "Conta Poupanca";
    }
}
