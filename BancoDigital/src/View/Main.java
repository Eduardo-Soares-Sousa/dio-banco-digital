package View;

import Model.TipoDaConta;
import Service.Banco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\tBem-vindo ao North Bank!");
        boolean sair = false;
        while(sair != true){
            System.out.println("\n");
            System.out.println("\t\tDigite a opcao desejada.");
            System.out.println("\t1 - Adicionar um novo cliente: ");
            System.out.println("\t2 - Remover um cliente: ");
            System.out.println("\t3 - Consultar os dados de um cliente: ");
            System.out.println("\t4 - Exibir os clientes cadastrados: ");
            System.out.println("\t5 - Exibir quantos clientes estão cadastros: ");
            System.out.println("\t6 - Exibir dados da conta de um cliente: ");
            System.out.println("\t0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch(opcao){
                case 1:
                    System.out.println("\tAdicionar um novo cliente");
                    System.out.println("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o cpf do cliente: ");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite a idade do cliente: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o qual o tipo da conta (CORRENTE ou POUPANCA): ");
                    String tipoDaContaBanco = scanner.nextLine();
                    TipoDaConta tipoDaConta = null;

                    try{
                        tipoDaConta = TipoDaConta.valueOf(tipoDaContaBanco.toUpperCase());
                    }catch(IllegalArgumentException e){
                        System.out.println("Tipo da conta inválido. Por favor, digite CORRENTE ou POUPANCA.");
                        break;
                    }

                    banco.adicionarCliente(nome, cpf, idade, tipoDaConta);
                    break;
                case 2:
                    System.out.println("\tRemover um cliente");
                    System.out.println("Digite o cpf do cliente que será removido: ");
                    String cpf1 = scanner.nextLine();

                    banco.removerCliente(cpf1);
                    break;
                case 3:
                    System.out.println("\tConsultar os dados de um cliente");
                    System.out.println("Digite o cpf do cliente que deseja fazer a consulta: ");
                    String cpf2 = scanner.nextLine();

                    banco.pesquisarCliente(cpf2);
                    break;
                case 4:
                    System.out.println("\tClientes cadastrados: ");
                    banco.exibirClientes();
                    break;
                case 5:
                    System.out.println("\tExibir quantos clientes estão cadastros");
                    System.out.println("O sistema possui " + banco.contarClientes() + " clientes cadastrados!");
                    break;
                case 6:
                    System.out.println("\tExibir dados da conta de um cliente");
                    System.out.println("Digite o cpf do cliente que deseja consultar: ");
                    String cpf3 = scanner.nextLine();

                    banco.dadosContaCliente(cpf3);
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        System.out.println("Sistema encerrado!");
    }
}