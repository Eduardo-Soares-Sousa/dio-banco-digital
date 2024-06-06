package Service;

import Model.Cliente;
import Model.TipoDaConta;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Banco {
    private static final String SENHA_ADMINISTRADOR = "Admin123";
    List<Cliente> clienteList;

    public Banco() {
        this.clienteList = new ArrayList<>();
    }

    public boolean verificarSenhaAdministrador(String senha) {
        return SENHA_ADMINISTRADOR.equals(senha);
    }

    public void adicionarCliente(String nome, String cpf, int idade, TipoDaConta tipoDaConta) {
        clienteList.add(new Cliente(nome, cpf, idade, tipoDaConta));
    }

    public void removerCliente(String cpf) {
        boolean deuCerto = false;
        Cliente clienteRemover = null;
        if(!clienteList.isEmpty()){
            for(Cliente cliente : clienteList){
                if(cliente.getCpf().equalsIgnoreCase(cpf)){
                    clienteRemover = cliente;
                    clienteList.remove(clienteRemover);
                    deuCerto = true;
                    break;
                }
            }
            if(deuCerto != false){
                System.out.println("Cliente: " + clienteRemover.getNome() + ", CPF: " + clienteRemover.getCpf() + " removido com sucesso!");
            }else{
                System.out.println("Não há cliente com esse CPF!");
            }
        }else{
            throw new RuntimeException("A lista de clientes está vazia!");
        }
    }

    public Cliente pesquisarCliente(String cpf) {
        Cliente clienteEncontrado = null;
        if(!clienteList.isEmpty()){
            for(Cliente procurado : clienteList){
                if(procurado.getCpf().equalsIgnoreCase(cpf)){
                    clienteEncontrado = procurado;
                    break;
                }
            }
        }else{
            throw new RuntimeException("A lista de clientes está vazia!");
        }

        if(clienteEncontrado == null){
            System.out.println("Não há cliente com esse CPF!");
            return null;
        }

        System.out.println(clienteEncontrado);
        return clienteEncontrado;
    }

    public void exibirClientes() {
        Set<Cliente> exibirClientesNomes = new TreeSet<>(clienteList);
        if(!clienteList.isEmpty()){
            for(Cliente cliente : exibirClientesNomes){
                System.out.println(cliente);
            }
        }else{
            throw new RuntimeException("A lista de clientes está vazia!");
        }
    }

    public void dadosContaCliente(String cpf) {
        boolean deuCerto = false;
        if(!clienteList.isEmpty()){
            for(Cliente procurado : clienteList){
                if(procurado.getCpf().equalsIgnoreCase(cpf)){
                    procurado.getConta().imprimirInfosConta();
                    deuCerto = true;
                    break;
                }
            }
        }else{
            throw new RuntimeException("A lista de clientes está vazia!");
        }

        if(!deuCerto){
            System.out.println("Não há cliente com esse CPF!");
        }
    }

    public int contarClientes() {
        return clienteList.size();
    }
}
