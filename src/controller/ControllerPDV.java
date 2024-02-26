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
import java.awt.event.KeyAdapter;
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
public class ControllerPDV implements ActionListener, FocusListener {

    float valorTotalVenda, valorEmDinheiro = 0;
    private PontoVenda pontoVenda;
    private Venda faturacao;
    List<ItemVenda> itensDaTabela = new ArrayList<>();

    public ControllerPDV(PontoVenda pontoVenda) {
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
        this.pontoVenda.getjTextFieldFiltrarProduto().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    adicionarItemVenda();
                }
            }
        });
        this.pontoVenda.getjTextFieldValorRecebido().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    calculaTroco();
                }
            }
        });
        this.pontoVenda.getjTextFieldDesconto().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    aplicarDesconto();
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.pontoVenda.getjButtonSair()) {
            this.pontoVenda.dispose();
        } else if (e.getSource() == this.pontoVenda.getjButtonCancelar()) {
            utilities.Utilities.limpaComponentes(false, this.pontoVenda.getjPanelDados());
            utilities.Utilities.limpaComponentes(true, this.pontoVenda.getjPanelFiltro());
            utilities.Utilities.limpaComponentes(true, this.pontoVenda.getjPanelTroco());
            
            DefaultTableModel tabelaItens = (DefaultTableModel) pontoVenda.getjTableDados().getModel();
            this.itensDaTabela.clear();
            tabelaItens.setRowCount(0);
            
            
            //this.pontoVenda.getValorTotalVenda().setText("0.00");
            this.pontoVenda.setLabelValorSubtotal("0.00");
            this.pontoVenda.setLabelValorTotal("0.00");
            //this.pontoVenda.setLabelValorUnitarioItem("0.00");
            //this.pontoVenda.getTroco().setText("0.00");

        } else if (e.getSource() == this.pontoVenda.getjButtonSalvar()) {
            //produzir
        } else if (e.getSource() == this.pontoVenda.getjButtonPesquisarCliente()) {
            buscarCliente();
        } else if (e.getSource() == this.pontoVenda.getjButtonAdicionarCliente()) {
            CadastroCliente cadastroCliente = new CadastroCliente();
            ControllerCadastroCliente controllerCadastroCliente = new ControllerCadastroCliente(cadastroCliente);
            cadastroCliente.setVisible(true);
        } else if (e.getSource() == this.pontoVenda.getjButtonPesquisarFuncionario()) {
            buscarFuncionario();
        } else if (e.getSource() == this.pontoVenda.getjButtonAdicionarFuncionario()) {
            CadastroFuncionario cadastroFuncionario = new CadastroFuncionario();
            ControllerCadastroFuncionario controllerCadastroFuncionario = new ControllerCadastroFuncionario(cadastroFuncionario);
            cadastroFuncionario.setVisible(true);
        } else if (e.getSource() == this.pontoVenda.getjButtonPesquisarProduto()) {
            buscarProduto();
        } else if (e.getSource() == this.pontoVenda.getjButtonAdicionarProduto()) {
            CadastroProduto cadastroProduto = new CadastroProduto();
            ControllerCadastroProduto controllerCadastroProduto = new ControllerCadastroProduto(cadastroProduto);
            cadastroProduto.setVisible(true);
        }
    }

    public Cliente getClienteEndById(int idClienteEnd) {
        for (Cliente clienteAtual : service.ClienteService.carregar()) {
            if (clienteAtual.getId() == idClienteEnd) {
                return clienteAtual;
            }

        }
        return null;
    }

    public Funcionario getFuncioanrioEndById(int idFuncionarioEnd) {
        for (Funcionario funcionarioAtual : service.FuncionarioService.carregar()) {
            if (funcionarioAtual.getId() == idFuncionarioEnd) {
                return funcionarioAtual;
            }

        }
        return null;
    }

    public Produto getProdutoEndById(int idProdutoEndById) {
        for (Produto produtoAtual : service.ProdutoService.carregar()) {
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

    }

    private void buscarCliente() {
        BuscaCliente buscaCliente = new BuscaCliente(null, true);
        ControllerBuscaCliente controllerBuscaCliente = new ControllerBuscaCliente(buscaCliente);
        buscaCliente.setVisible(true);

        if (ControllerCadastroCliente.codigo != 0) {
            Cliente cliente = getClienteEndById(ControllerCadastroCliente.codigo);
            this.pontoVenda.getjTextFieldFiltrarCliente().setText(cliente.getNome());
        }
    }

    private void buscarFuncionario() {
        BuscaFuncionario buscaFuncionario = new BuscaFuncionario(null, true);
        ControllerBuscaFuncionario controllerBuscaFuncionario = new ControllerBuscaFuncionario(buscaFuncionario);
        buscaFuncionario.setVisible(true);

        if (ControllerCadastroFuncionario.codigo != 0) {
            Funcionario funcionario = getFuncioanrioEndById(ControllerCadastroFuncionario.codigo);
            this.pontoVenda.getjTextFieldFiltrarFuncionario().setText(funcionario.getNome());
        }
    }

    private void buscarProduto() {
        BuscaProduto buscaProduto = new BuscaProduto(null, true);
        ControllerBuscaProduto controllerBuscaProduto = new ControllerBuscaProduto(buscaProduto);
        buscaProduto.setVisible(true);

        if (ControllerCadastroProduto.codigo != 0) {
            Produto produto = getProdutoEndById(ControllerCadastroProduto.codigo);
            this.pontoVenda.getjTextFieldFiltrarProduto().setText(produto.getCodigoBarra());
        }
    }

    public ItemVenda itemVenda() {
        int quantidade = 1;
        ItemVenda itemVenda = new ItemVenda();
        Produto produtoAtual = adicionarProduto();
        itemVenda.setVenda(faturacao);
        itemVenda.setProduto(produtoAtual);

        if (this.pontoVenda.getjTextFieldFiltrarProduto().getText().contains("X") || this.pontoVenda.getjTextFieldFiltrarProduto().getText().contains("x")) {
            int parametroQuantidade = this.pontoVenda.getjTextFieldFiltrarProduto().getText().toUpperCase().indexOf("X");
            quantidade = Integer.parseInt(this.pontoVenda.getjTextFieldFiltrarProduto().getText().substring(0, parametroQuantidade));

        }

        itemVenda.setQtdProduto(quantidade);
        itemVenda.setStatus('A');

        return itemVenda;
    }

    public Produto adicionarProduto() {

        Produto produtoAtual = new Produto();
        if (this.pontoVenda.getjTextFieldFiltrarProduto().getText().toUpperCase().contains("X")) {
            int parametroQuantidade = this.pontoVenda.getjTextFieldFiltrarProduto().getText().toUpperCase().indexOf("X");

            String codigodebarras = this.pontoVenda.getjTextFieldFiltrarProduto().getText().substring(parametroQuantidade + 1);

            produtoAtual = service.ProdutoService.carregarCodigoBarra(codigodebarras);

        } else {
            String codigodebarras = this.pontoVenda.getjTextFieldFiltrarProduto().getText();
            produtoAtual = service.ProdutoService.carregarCodigoBarra(codigodebarras);
        }

        return produtoAtual;
    }

    public void adicionarItemVenda() {
        DefaultTableModel tabelaItens = (DefaultTableModel) pontoVenda.getjTableDados().getModel();

        Produto produtoAtual = adicionarProduto();

        int quantidade = 1;
        if (pontoVenda.getjTextFieldFiltrarProduto().getText().toUpperCase().contains("X")) {
            int parametroQuantidade = pontoVenda.getjTextFieldFiltrarProduto().getText().toUpperCase().indexOf("X");
            quantidade = Integer.parseInt(pontoVenda.getjTextFieldFiltrarProduto().getText().substring(0, parametroQuantidade));
        }

        float subtotal = produtoAtual.getPreco() * quantidade;

        tabelaItens.addRow(new Object[]{
            tabelaItens.getRowCount() + 1,
            produtoAtual.getCodigoBarra(),
            produtoAtual.getDescricao(),
            quantidade,
            produtoAtual.getPreco(),
            subtotal
        });

        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setVenda(faturacao);
        itemVenda.setProduto(produtoAtual);
        itemVenda.setQtdProduto(quantidade);
        itemVenda.setStatus('A');

        itensDaTabela.add(itemVenda);

        pontoVenda.getjTextFieldFiltrarProduto().setText("");
        valorTotalVenda += subtotal;
        pontoVenda.setLabelValorSubtotal(subtotal + "");
        pontoVenda.setLabelValorTotal(calcularValorTotal() + "");
    }

    private void aplicarDesconto() {
        try {
           double valorDesconto = Double.parseDouble(this.pontoVenda.getjTextFieldDesconto().getText());
           
           double desconto = calcularValorTotal()-valorDesconto;

            if (desconto >= 0) {
                pontoVenda.setLabelValorTotal(String.valueOf(desconto));
            } else {
                // Trate o caso em que o desconto é maior que o valor total
                pontoVenda.setLabelValorTotal("0");
                // Ou exiba uma mensagem informando que o desconto é maior que o valor total
                // JOptionPane.showMessageDialog(pontoVenda, "Desconto é maior que o valor total", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            // Trate caso o valor do desconto não seja um número válido
            // Ou exiba uma mensagem informando que o valor do desconto é inválido
            // JOptionPane.showMessageDialog(pontoVenda, "Valor do desconto inválido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void calculaTroco() {
        try {
            float valorRecebido = Float.parseFloat(this.pontoVenda.getjTextFieldValorRecebido().getText());

            float troco = valorRecebido - calcularValorTotal();
            if (troco >= 0) {
                this.pontoVenda.getjTextFieldTroco().setText(String.valueOf(troco));
            } else {
                // Trate o caso em que o valor recebido é menor que o total da venda
                this.pontoVenda.getjTextFieldTroco().setText("0");
                // Ou exiba uma mensagem informando que o valor recebido é insuficiente
                // JOptionPane.showMessageDialog(pontoVenda, "Valor recebido é menor que o total da venda", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            // Trate caso o valor recebido não seja um número válido
            this.pontoVenda.getjTextFieldTroco().setText("0");
            // Ou exiba uma mensagem informando que o valor recebido é inválido
            // JOptionPane.showMessageDialog(pontoVenda, "Valor recebido inválido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private float calcularValorTotal() {
        float desconto = obterDesconto();
        return valorTotalVenda - desconto;
    }

    private float obterDesconto() {
        try {
            String textoDesconto = pontoVenda.getjTextFieldDesconto().getText();
            return Float.parseFloat(textoDesconto);
        } catch (NumberFormatException e) {
            // Trate caso o valor do desconto não seja um número válido
            return 0; // Ou qualquer valor padrão desejado
        }
    }
}
