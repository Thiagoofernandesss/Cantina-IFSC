/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.time.format.DateTimeFormatter;
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
 * @author aluno
 */
public class ClasseDados {
    private static ClasseDados instance;
    public static ArrayList<Bairro> bairros;
    public static ArrayList<Caixa> caixas;
    public static ArrayList<Carteirinha> carteirinhas;
    public static ArrayList<Cidade> cidades;
    public static ArrayList<Cliente> clientes;
    public static ArrayList<Compra> compras;
    public static ArrayList<Contas> contas;
    public static ArrayList<Endereco> enderecos;
    public static ArrayList<Fornecedor> fornecedores;
    public static ArrayList<Funcionario> funcionarios;
    public static ArrayList<ItemCompra> itensCompras;
    public static ArrayList<ItemVenda> itensVendas;
    public static ArrayList<MovimentacaoEstoque> movimentacoesDeEstoque;
    public static ArrayList<MovimentoCaixa> movimentacoesDeCaixas;
    public static ArrayList<Produto> produtos;
    public static ArrayList<Venda> vendas;
    
    public static synchronized ClasseDados getInstance(){
        if(instance == null){
            instance = new ClasseDados();
        }
        return instance;
    }
    
    private ClasseDados(){
        bairros = new ArrayList<>();
        caixas = new ArrayList<>();
        carteirinhas = new ArrayList<>();
        cidades = new ArrayList<>();
        clientes = new ArrayList<>();
        compras = new ArrayList<>();
        contas = new ArrayList<>();
        enderecos = new ArrayList<>();
        fornecedores = new ArrayList<>();
        funcionarios = new ArrayList<>();
        itensCompras = new ArrayList<>();
        itensVendas = new ArrayList<>();
        movimentacoesDeEstoque = new ArrayList<>();
        movimentacoesDeCaixas = new ArrayList<>();
        produtos = new ArrayList<>();
        vendas = new ArrayList<>();
        
        //Teste, não precisa
        
        //Bairros
        Bairro bairro1 = new Bairro(1, "Centro");
        Bairro bairro2 = new Bairro(2, "Vila Moema");
        Bairro bairro3 = new Bairro(3, "Humaita");
        
        bairros.add(bairro1);
        bairros.add(bairro2);
        bairros.add(bairro3);
        
        //Cidades
        Cidade cidade1 = new Cidade(1, "Tubarão", "SC");
        Cidade cidade2 = new Cidade(2, "Criciúma", "SC");
        Cidade cidade3 = new Cidade(3, "Capivari de Baixo", "SC");
        
        cidades.add(cidade1);
        cidades.add(cidade2);
        cidades.add(cidade3);
        
        //Endereços
        Endereco endereco1 = new Endereco(1, "88708 - 695", "Rua João Silva", 'A', bairro1, cidade3);
        Endereco endereco2 = new Endereco(2, "88708 - 696", "Rua Adelson Cascaces", 'A', bairro2, cidade2);
        Endereco endereco3 = new Endereco(3, "88708 - 697", "Avenida Patricio Lima", 'I', bairro3, cidade1);
        
        
        enderecos.add(endereco1);
        enderecos.add(endereco2);
        enderecos.add(endereco3);
        
        //Clientes
        Cliente cliente1 = new Cliente("12324896958", "6659985", "202218A", "21/12/99", 1, "Thiago Fernandes", "48999566532","48999568795",
                "Thiago123@gmail.com",'I', "Morro da Cruz", endereco1);
        
        Cliente cliente2 = new Cliente("12324815658", "6659985", "202218A", "21/02/02", 2, "Lara Raldi", "48 999568795","48999566532",
                "Lara@gmail.com",'A', "", endereco2);
        
        Cliente cliente3 = new Cliente("59815896954", "6989685", "202218B", "21/09/07", 3, "Lucca Martins", "48967366532","null",
                "Luizinho@gmail.com",'A', "Esquina", endereco3);
        
        
        
        
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        
        //Fornecedores
        Fornecedor fornecedor1 = new Fornecedor("12.345.678/0001-00", "123.456.789.012", " TecnoCop LTDA", 1, "TecnoCop", "48 9 9856 - 2121",
                "null", "contato@tecnocop.com", 'A', "Lado da loja Vivo", endereco1);
        
        Fornecedor fornecedor2 = new Fornecedor("98.765.432/0001-01", "123.456.789.012", " EcoSol Energia Sustentável SA", 2, "EcoSol", 
                "48 9 9856 - 2121","null", "contato@ecosolenergia.com", 'A', "", endereco2);
        
        Fornecedor fornecedor3 = new Fornecedor("45.678.901/0001-23", "123.456.789.012", "Comércio Expresso Ltda", 3, "Comércio Expresso", 
                "48 9 9856 - 2121","null", "contato@ecosolenergia.com", 'A', "", endereco2);
        
        fornecedores.add(fornecedor1);
        fornecedores.add(fornecedor2);
        fornecedores.add(fornecedor3);
        
        //Funcionarios
        Funcionario funcionario1 = new Funcionario("125.268.951-16", "6.887.229", "funcionario1", "funcionario1**");
        Funcionario funcionario2 = new Funcionario("545.658.950-65", "6.656.229", "funcionario2", "funcionario2**");
        Funcionario funcionario3= new Funcionario("128.496.954-89", "6.887.879", "funcionario3", "funcionario3**");
        
        funcionarios.add(funcionario1);
        funcionarios.add(funcionario2);
        funcionarios.add(funcionario3);
        
        //Carteirinhas
        Carteirinha carteirinha1 = new Carteirinha(1, "123123456", "21/12/2021", "", cliente1);
        Carteirinha carteirinha2 = new Carteirinha(2, "123123457", "21/12/2021", "", cliente2);
        Carteirinha carteirinha3 = new Carteirinha(3, "123123458", "21/12/2021", "", cliente3);
        
        carteirinhas.add(carteirinha1);
        carteirinhas.add(carteirinha2);
        carteirinhas.add(carteirinha3);
        
        //Produtos
        //Produto produto1 = new Produto(1, "Rigoles", "123456987", 'I');
        //Produto produto2 = new Produto(2, "Pastel", "123456998", 'A');
        // produto3 = new Produto(3, "Coxinha", "123456998", 'A');
        
       // produtos.add(produto1);
        //produtos.add(produto2);
        //produtos.add(produto3);
        
        //Compras
        Compra compra1 = new Compra(1, 10, DateTimeFormatter.ISO_LOCAL_DATE, 0, 'S', 'A', "", fornecedor1);
        Compra compra2 = new Compra(2, 20, DateTimeFormatter.ISO_LOCAL_DATE, 0, 'S', 'A', "", fornecedor2);
        Compra compra3 = new Compra(3, 30, DateTimeFormatter.ISO_LOCAL_DATE, 0, 'S', 'A', "", fornecedor3);
        
        compras.add(compra1);
        compras.add(compra2);
        compras.add(compra3);
        
        //Vendas
        //Venda venda1 = new Venda(1, DateTimeFormatter.ISO_LOCAL_DATE, 0, 'S', "", 'A', carteirinha1, funcionario1);
       // Venda venda2 = new Venda(2, DateTimeFormatter.ISO_LOCAL_DATE, 0, 'S', "", 'A', carteirinha2, funcionario2);
        // venda3 = new Venda(3, DateTimeFormatter.ISO_LOCAL_DATE, 0, 'S', "", 'A', carteirinha3, funcionario3);
        
        //vendas.add(venda1);
       // vendas.add(venda2);
       // vendas.add(venda3);
        
        //Contas
        

    }
    
}
