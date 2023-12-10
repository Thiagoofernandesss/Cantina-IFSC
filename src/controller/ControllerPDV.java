/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Cliente;
import model.bo.Funcionario;
import model.bo.ItemVenda;
import model.bo.Produto;
import model.bo.Venda;
import view.BuscaCliente;
import view.BuscaFuncionario;
import view.BuscaProduto;
import view.CadastroCliente;
import view.CadastroFuncionario;
import view.CadastroProduto;
import view.PontoVenda;

/**
 *
 * @author gabri
 */
public class ControllerPDV implements ActionListener, FocusListener{
    
    private PontoVenda pontoVenda;
    private Venda faturacao;
    List<ItemVenda> itensDaTabela = new ArrayList<>();
    
    private KeyEventDispatcher atalhos = new KeyEventDispatcher() {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        adicionarItemVenda();
                        break;
                }
            }
            return false;
        }
    };

    
    public ControllerPDV(PontoVenda pontoVenda){
        this.pontoVenda = pontoVenda;
        
        this.pontoVenda.getjButtonSalvar().addActionListener(this);
        this.pontoVenda.getjButtonSair().addActionListener(this);
        this.pontoVenda.getjButtonCancelar().addActionListener(this);
        
        this.pontoVenda.getjButtonAdicionarCliente().addActionListener(this);
        this.pontoVenda.getjButtonPesquisarCliente().addActionListener(this);
        
        List<Cliente> listaCliente = new ArrayList<>();
        listaCliente = service.ClienteService.carregar();
        
        this.pontoVenda.getjButtonAdicionarFuncionario().addActionListener(this);
        this.pontoVenda.getjButtonPesquisarFuncionario().addActionListener(this);
        
        List<Funcionario> listaFuncionario = new ArrayList<>();
        listaFuncionario = service.FuncionarioService.carregar();
        
        this.pontoVenda.getjButtonAdicionarProduto().addActionListener(this);
        this.pontoVenda.getjButtonPesquisarProduto().addActionListener(this);
        
        List<Produto> listaProduto = new ArrayList<>();
        listaProduto = service.ProdutoService.carregar();
        
        utilities.Utilities.limpaComponentes(false, this.pontoVenda.getjPanelDados());     
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(atalhos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.pontoVenda.getjButtonSair()) {
           this.pontoVenda.dispose(); 
        } else if (e.getSource() == this.pontoVenda.getjButtonCancelar()) {
            utilities.Utilities.limpaComponentes(false, this.pontoVenda.getjPanelDados());
        }else if (e.getSource() == this.pontoVenda.getjButtonSalvar()) {
            //produzir
        }else if (e.getSource() == this.pontoVenda.getjButtonPesquisarCliente()) {
            buscarCliente();
        }else if (e.getSource() == this.pontoVenda.getjButtonAdicionarCliente()) {
            CadastroCliente cadastroCliente = new CadastroCliente();
            ControllerCadastroCliente controllerCadastroCliente = new ControllerCadastroCliente(cadastroCliente);
            cadastroCliente.setVisible(true);
        }else if (e.getSource() == this.pontoVenda.getjButtonPesquisarFuncionario()) {
            buscarFuncionario();
        }else if (e.getSource() == this.pontoVenda.getjButtonAdicionarFuncionario()) {
            CadastroFuncionario cadastroFuncionario = new CadastroFuncionario();
            ControllerCadastroFuncionario controllerCadastroFuncionario = new ControllerCadastroFuncionario(cadastroFuncionario);
            cadastroFuncionario.setVisible(true);
        }else if (e.getSource() == this.pontoVenda.getjButtonPesquisarProduto()) {
            buscarProduto();
        }else if (e.getSource() == this.pontoVenda.getjButtonAdicionarProduto()) {
            CadastroProduto cadastroProduto = new CadastroProduto();
            ControllerCadastroProduto controllerCadastroProduto = new ControllerCadastroProduto(cadastroProduto);
            cadastroProduto.setVisible(true);
        }
    }
    
    public Cliente getClienteEndById(int idClienteEnd){
        for(Cliente clienteAtual : service.ClienteService.carregar()) {
            if (clienteAtual.getId() == idClienteEnd) {
                return clienteAtual;
            }

        }
        return null;
    }
    public Funcionario getFuncioanrioEndById(int idFuncionarioEnd){
        for(Funcionario funcionarioAtual : service.FuncionarioService.carregar()) {
            if (funcionarioAtual.getId() == idFuncionarioEnd) {
                return funcionarioAtual;
            }

        }
        return null;
    }
    public Produto getProdutoEndById(int idProdutoEndById){
        for(Produto produtoAtual : service.ProdutoService.carregar()){
            if (produtoAtual.getId() == idProdutoEndById) {
                return produtoAtual;
            }
        }
        return null;
    }

    @Override
    public void focusGained(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void buscarCliente(){
        BuscaCliente buscaCliente = new BuscaCliente(null, true);
        ControllerBuscaCliente controllerBuscaCliente = new ControllerBuscaCliente(buscaCliente);
        buscaCliente.setVisible(true);
        
        if (ControllerCadastroCliente.codigo != 0) {
            Cliente cliente = getClienteEndById(ControllerCadastroCliente.codigo);
            this.pontoVenda.getjTextFieldFiltrarCliente().setText(cliente.getNome());
        }
    }
    
    private void buscarFuncionario(){
        BuscaFuncionario buscaFuncionario = new BuscaFuncionario(null, true);
        ControllerBuscaFuncionario controllerBuscaFuncionario = new ControllerBuscaFuncionario(buscaFuncionario);
        buscaFuncionario.setVisible(true);
        
        if (ControllerCadastroFuncionario.codigo != 0) {
            Funcionario funcionario = getFuncioanrioEndById(ControllerCadastroFuncionario.codigo);
            this.pontoVenda.getjTextFieldFiltrarFuncionario().setText(funcionario.getNome());
        }
    }
    
    private void buscarProduto(){
        BuscaProduto buscaProduto = new BuscaProduto(null, true);
        ControllerBuscaProduto controllerBuscaProduto = new ControllerBuscaProduto(buscaProduto);
        buscaProduto.setVisible(true);
        
        if (ControllerCadastroProduto.codigo != 0) {
            Produto produto = getProdutoEndById(ControllerCadastroProduto.codigo);
            this.pontoVenda.getjTextFieldFiltrarProduto().setText(produto.getCodigoBarra());
        }
    }
    
    public ItemVenda itemVenda(){
       int quantidade=0;
       ItemVenda itemVenda=new ItemVenda();
       Produto produtoAtual = adicionarProduto();
       itemVenda.setVenda(faturacao);
       itemVenda.setProduto(produtoAtual);
       
       if(this.pontoVenda.getjTextFieldFiltrarProduto().getText().contains("X")||this.pontoVenda.getjTextFieldFiltrarProduto().getText().contains("x")){
            int parametroQuantidade=this.pontoVenda.getjTextFieldFiltrarProduto().getText().toUpperCase().indexOf("X");
            System.out.println(parametroQuantidade);
            quantidade= Integer.parseInt(this.pontoVenda.getjTextFieldFiltrarProduto().getText().substring(0, parametroQuantidade));
       }
       
       itemVenda.setQtdProduto(quantidade);
       itemVenda.setStatus('A');
    
       return itemVenda; 
    }
    
    public Produto adicionarProduto(){

        Produto produtoAtual = new Produto();
        if(this.pontoVenda.getjTextFieldFiltrarProduto().getText().contains("X")||this.pontoVenda.getjTextFieldFiltrarProduto().getText().contains("x")){
            int parametroQuantidade=this.pontoVenda.getjTextFieldFiltrarProduto().getText().toUpperCase().indexOf("X");

            String codigodebarras=this.pontoVenda.getjTextFieldFiltrarProduto().getText().substring(parametroQuantidade+1);
            produtoAtual=service.ProdutoService.carregarCodigoBarra(codigodebarras);

        }else{
            String codigodebarras=this.pontoVenda.getjTextFieldFiltrarProduto().getText();
            produtoAtual=service.ProdutoService.carregarCodigoBarra(codigodebarras);
        }


        return produtoAtual;
    }
    
     public void adicionarItemVenda(){
        
         DefaultTableModel tabelaItens = (DefaultTableModel) pontoVenda.getjTableDados().getModel();
        
        this.pontoVenda.getjTextFieldFiltrarProduto().setText(itemVenda().getProduto().getCodigoBarra());
        this.pontoVenda.setLabelValorSubtotal(itemVenda().getProduto().getPreco()*itemVenda().getQtdProduto()+"");
        
        tabelaItens.addRow(new Object[]{tabelaItens.getRowCount()+1,itemVenda().getProduto().getCodigoBarra(),itemVenda().getProduto().getDescricao(),itemVenda().getQtdProduto(),itemVenda().getProduto().getPreco(),itemVenda().getProduto().getPreco()*itemVenda().getQtdProduto()});
        
        itensDaTabela.add(itemVenda());        
        
    }
    
}
