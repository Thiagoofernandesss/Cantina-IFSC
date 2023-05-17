/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BuscaCompra;
import view.BuscaFornecedor;
import view.CadastroCompra;
import view.CadastroFornecedor;

/**
 *
 * @author Thiago
 */
public class ControllerCadastroCompra implements ActionListener {
    
    CadastroCompra cadastroCompra;
    
    public ControllerCadastroCompra(CadastroCompra cadastroCompra) {
        this.cadastroCompra = cadastroCompra;
        
        this.cadastroCompra.getjButtonNovo().addActionListener(this);
        this.cadastroCompra.getjButtonSair().addActionListener(this);
        this.cadastroCompra.getjButtonCancelar().addActionListener(this);
        this.cadastroCompra.getjButtonSalvar().addActionListener(this);
        this.cadastroCompra.getjButtonConsultar().addActionListener(this);
        this.cadastroCompra.getjButtonPesquisarCnpj().addActionListener(this);
        this.cadastroCompra.getjButtonAdicionarCnpj().addActionListener(this);
        
        utilities.Utilities.ativa(true, this.cadastroCompra.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroCompra.getjPanelDados());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroCompra.getjButtonNovo()) {
            utilities.Utilities.ativa(false, this.cadastroCompra.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroCompra.getjPanelDados());
            
        } else if (e.getSource() == this.cadastroCompra.getjButtonSair()) {
            this.cadastroCompra.dispose();
            
        } else if (e.getSource() == this.cadastroCompra.getjButtonCancelar()) {
            utilities.Utilities.ativa(true, this.cadastroCompra.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroCompra.getjPanelDados());
            
        } else if (e.getSource() == this.cadastroCompra.getjButtonSalvar()) {
            utilities.Utilities.ativa(true, cadastroCompra.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, cadastroCompra.getjPanelDados());
            
        } else if (e.getSource() == this.cadastroCompra.getjButtonConsultar()) {
            BuscaCompra buscaCompra = new BuscaCompra(null, true);
            ControllerBuscaCompra controllerBuscaCompra = new ControllerBuscaCompra(buscaCompra);
            buscaCompra.setVisible(true);
            
        } else if (e.getSource() == this.cadastroCompra.getjButtonAdicionarCnpj()) {
            CadastroFornecedor cadastroFornecedor = new CadastroFornecedor();
            ControllerCadastroFornecedor controllerCadastroFornecedor = new ControllerCadastroFornecedor(cadastroFornecedor);
            cadastroFornecedor.setVisible(true);
        } else if (e.getSource() == this.cadastroCompra.getjButtonPesquisarCnpj()) {
            BuscaFornecedor buscaFornecedor = new BuscaFornecedor(null, true);
            ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(buscaFornecedor);
            buscaFornecedor.setVisible(true);
        }
    }
    
}
