package Service;

import Model.Cliente;
import Model.TipoDaConta;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Banco {
    List<Cliente> clienteList;

    public Banco() {
        this.clienteList = new ArrayList<>();
    }

    public void adicionarCliente(String nome, String cpf, int idade, TipoDaConta tipoDaConta, double saldo) {
        clienteList.add(new Cliente(nome, cpf, idade, tipoDaConta, saldo));
    }

    public void removerCliente(String cpf) {
        Cliente clienteRemover = null;
        if(!clienteList.isEmpty()){
            for(Cliente cliente : clienteList){
                if(cliente.getCpf() == cpf){
                    clienteRemover = cliente;
                    break;
                }
            }
            clienteList.remove(clienteRemover);
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
            System.out.println("Não cliente com esse cpf!");
            return null;
        }
        
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

    public int contarClientes() {
        return clienteList.size();
    }
}
