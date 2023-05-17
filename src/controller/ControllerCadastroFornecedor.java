/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BuscaEndereco;
import view.BuscaFornecedor;
import view.CadastroEndereco;
import view.CadastroFornecedor;

/**
 *
 * @author Thiago
 */
public class ControllerCadastroFornecedor implements ActionListener {
    
    CadastroFornecedor cadastroFornecedor;

    public ControllerCadastroFornecedor(CadastroFornecedor cadastroFornecedor) {
        this.cadastroFornecedor = cadastroFornecedor;
        
        this.cadastroFornecedor.getjButtonNovo().addActionListener(this);
        this.cadastroFornecedor.getjButtonSair().addActionListener(this);
        this.cadastroFornecedor.getjButtonCancelar().addActionListener(this);
        this.cadastroFornecedor.getjButtonSalvar().addActionListener(this);
        this.cadastroFornecedor.getjButtonConsultar().addActionListener(this);
        this.cadastroFornecedor.getjButtonPesquisarCep().addActionListener(this);
        this.cadastroFornecedor.getjButtonAdcionarCep().addActionListener(this);
        
        utilities.Utilities.ativa(true, this.cadastroFornecedor.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroFornecedor.getjPanelDados());
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroFornecedor.getjButtonNovo()) {
            utilities.Utilities.ativa(false, this.cadastroFornecedor.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroFornecedor.getjPanelDados());

        } else if (e.getSource() == this.cadastroFornecedor.getjButtonSair()) {
            this.cadastroFornecedor.dispose();

        } else if (e.getSource() == this.cadastroFornecedor.getjButtonCancelar()) {
            utilities.Utilities.ativa(true, this.cadastroFornecedor.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroFornecedor.getjPanelDados());

        } else if (e.getSource() == this.cadastroFornecedor.getjButtonSalvar()) {
            utilities.Utilities.ativa(true, cadastroFornecedor.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, cadastroFornecedor.getjPanelDados());

        } else if (e.getSource() == this.cadastroFornecedor.getjButtonConsultar()) {
            BuscaFornecedor buscaFornecedor= new BuscaFornecedor(null, true);
            ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(buscaFornecedor);
            buscaFornecedor.setVisible(true);

        } else if (e.getSource() == this.cadastroFornecedor.getjButtonPesquisarCep()){
            BuscaEndereco buscaEndereco = new BuscaEndereco(null, true);
            ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(buscaEndereco);
            buscaEndereco.setVisible(true);
            
        } else if(e.getSource() == this.cadastroFornecedor.getjButtonAdcionarCep()){
            CadastroEndereco cadastroEndereco = new CadastroEndereco();
           ControllerCadastroEndereco controllerCadastroEndereco = new ControllerCadastroEndereco(cadastroEndereco);
            cadastroEndereco.setVisible(true);
        }
    }
    
    
    
}
