package View;

import Model.Cliente;
import Model.TipoDaConta;
import Service.Banco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\tBem-vindo ao North Bank!");
        while(true){
            System.out.println("Você é um administrador ou um cliente? (Digite 'administrador' ou 'cliente'): ");
            String tipoUsuario = scanner.nextLine();

            if("administrador".equalsIgnoreCase(tipoUsuario)){
                System.out.println("Digite a senha de administrador: ");
                String senha = scanner.nextLine();

                if(!banco.verificarSenhaAdministrador(senha)){
                    System.out.println("Senha incorreta! Tente novamente.");
                    continue;
                }

                boolean sair = false;
                while(sair != true){
                    System.out.println("\n");
                    System.out.println("\t1 - Adicionar um novo cliente: ");
                    System.out.println("\t2 - Remover um cliente: ");
                    System.out.println("\t3 - Consultar os dados de um cliente: ");
                    System.out.println("\t4 - Exibir os clientes cadastrados: ");
                    System.out.println("\t5 - Exibir quantos clientes estão cadastros: ");
                    System.out.println("\t6 - Exibir dados da conta de um cliente: ");
                    System.out.println("\t0 - Sair");
                    System.out.println("Escolha uma opção:");

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


            }else if("cliente".equalsIgnoreCase(tipoUsuario)){
                System.out.println("Digite o CPF:");
                String cpfCliente = scanner.nextLine();
                Cliente cliente = banco.pesquisarCliente(cpfCliente);

                if(cliente == null){
                    System.out.println("Cliente não encontrado.");
                    continue;
                }

                boolean sair = false;
                while(sair != true){
                    System.out.println("1 - Sacar: ");
                    System.out.println("2 - Depositar: ");
                    System.out.println("3 - Transferir: ");
                    System.out.println("4 - Solicitar empréstimo: ");
                    System.out.println("5 - Vizualizar os dados da sua conta: ");
                    System.out.println("0 - Sair");
                    System.out.println("Escolha uma opção:");

                    int opcao = scanner.nextInt();
                    scanner.nextLine();
                    switch(opcao){
                        case 1:
                            System.out.println("\tSacar");
                            System.out.println("Digite o valor para sacar: ");
                            double valorSaque = scanner.nextDouble();
                            cliente.getConta().sacar(valorSaque);
                            break;
                        case 2:
                            System.out.println("\tDepositar");
                            System.out.println("Digite o valor para depositar: ");
                            double valorDeposito = scanner.nextDouble();
                            cliente.getConta().depositar(valorDeposito);
                            break;
                        case 3:
                            System.out.println("\tTransferir");
                            System.out.println("Digite o CPF do destinatário: ");
                            String cpfDestinatario = scanner.nextLine();
                            Cliente destinatario = banco.pesquisarCliente(cpfDestinatario);
                            if (destinatario == null) {
                                System.out.println("Destinatário não encontrado.");
                                break;
                            }
                            System.out.println("Digite o valor para transferir:");
                            double valorTransferencia = scanner.nextDouble();
                            cliente.getConta().transferir(valorTransferencia, destinatario.getConta());
                            break;
                        case 4:
                            System.out.println("\tSolicitar Empréstimo");
                            System.out.println("OBS: O VALOR DO EMPRÉSTIMO NÃO PODE EXCEDER R$ 10.000,00.");
                            System.out.println("Digite o valor do empréstimo: ");
                            double valorEmprestimo = scanner.nextDouble();
                            cliente.getConta().solicitarEmprestimo(valorEmprestimo);
                            break;
                        case 5:
                            System.out.println("\tVizualizar os dados da sua conta");
                            cliente.getConta().imprimirDadosConta();
                            System.out.println(cliente.toString());
                            break;
                        case 0:
                            sair = true;
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
                }
            }else{
                System.out.println("Tipo de usuário inválido. Por favor, digite 'admin' ou 'cliente'.");
            }
        }
    }
}