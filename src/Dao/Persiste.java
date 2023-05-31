/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.util.ArrayList;
import model.bo.Bairro;
import model.bo.Caixa;
import model.bo.Carteirinha;
import model.bo.Cidade;
import model.bo.Cliente;
import model.bo.Compra;
import model.bo.Contas;
import model.bo.Endereco;
import model.bo.Fornecedor;
import model.bo.Funcionario;
import model.bo.ItemCompra;
import model.bo.ItemVenda;
import model.bo.MovimentacaoEstoque;
import model.bo.MovimentoCaixa;
import model.bo.Produto;
import model.bo.Venda;

/**
 *
 * @author Thiago
 */
public class Persiste {
    private static Persiste uniqueInstance;

    public Persiste() {
    }
    
    public static synchronized Persiste getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Persiste();
        }
        return uniqueInstance;
    }
    
    public static ArrayList<Bairro>bairros = new ArrayList<>();
    public static ArrayList<Caixa>caixas = new ArrayList<>();
    public static ArrayList<Carteirinha>carteirinhas = new ArrayList<>();
    public static ArrayList<Cidade>cidades = new ArrayList<>();
    public static ArrayList<Cliente>clientes = new ArrayList<>();
    public static ArrayList<Compra>compras = new ArrayList<>();
    public static ArrayList<Contas>contas = new ArrayList<>();
    public static ArrayList<Endereco>enderecos = new ArrayList<>();
    public static ArrayList<Fornecedor>fornecedores = new ArrayList<>();
    public static ArrayList<Funcionario>funcionarios = new ArrayList<>();
    public static ArrayList<ItemCompra>itemCompra = new ArrayList<>();
    public static ArrayList<ItemVenda>itemVenda = new ArrayList<>();
    public static ArrayList<MovimentacaoEstoque>movimentacaoEstoque = new ArrayList<>();
    public static ArrayList<MovimentoCaixa>movimentoCaixa = new ArrayList<>();
    public static ArrayList<Produto>produtos = new ArrayList<>();
    public static ArrayList<Venda>vendas = new ArrayList<>();
    
    
    
    
    
    
}
