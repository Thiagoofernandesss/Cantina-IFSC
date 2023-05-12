/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BuscaFornecedor;
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
            //Inserir o controller da busca de bairros
            buscaFornecedor.setVisible(true);

        }
    }
    
    
    
}
