/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BuscaCarteirinha;
import view.BuscaVenda;
import view.CadastroCarteirinha;
import view.CadastroVenda;

/**
 *
 * @author Thiago
 */
public class ControllerCadastroVenda implements ActionListener {

    CadastroVenda cadastroVenda;

    public ControllerCadastroVenda(CadastroVenda cadastroVenda) {
        this.cadastroVenda = cadastroVenda;

        this.cadastroVenda.getjButtonNovo().addActionListener(this);
        this.cadastroVenda.getjButtonSair().addActionListener(this);
        this.cadastroVenda.getjButtonCancelar().addActionListener(this);
        this.cadastroVenda.getjButtonSalvar().addActionListener(this);
        this.cadastroVenda.getjButtonConsultar().addActionListener(this);
        this.cadastroVenda.getjButtonPesquisarCarteirinha().addActionListener(this);
        this.cadastroVenda.getjButtonAdicionarCarteirinha().addActionListener(this);

        utilities.Utilities.ativa(true, this.cadastroVenda.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroVenda.getjPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroVenda.getjButtonNovo()) {
            utilities.Utilities.ativa(false, this.cadastroVenda.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroVenda.getjPanelDados());

        } else if (e.getSource() == this.cadastroVenda.getjButtonSair()) {
            this.cadastroVenda.dispose();

        } else if (e.getSource() == this.cadastroVenda.getjButtonCancelar()) {
            utilities.Utilities.ativa(true, this.cadastroVenda.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroVenda.getjPanelDados());

        } else if (e.getSource() == this.cadastroVenda.getjButtonSalvar()) {
            utilities.Utilities.ativa(true, cadastroVenda.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, cadastroVenda.getjPanelDados());

        } else if (e.getSource() == this.cadastroVenda.getjButtonConsultar()) {
            BuscaVenda buscaVenda = new BuscaVenda(null, true);
            ControllerBuscaVenda controllerBuscaVenda = new ControllerBuscaVenda(buscaVenda);
            buscaVenda.setVisible(true);

            //Inserir o controller da busca de bairros
        } else if (e.getSource() == this.cadastroVenda.getjButtonAdicionarCarteirinha()) {
            CadastroCarteirinha cadastroCarteirinha = new CadastroCarteirinha();
            ControllerCadastroCarteirinha controllerCadastroCarteirinha = new ControllerCadastroCarteirinha(cadastroCarteirinha);
            cadastroCarteirinha.setVisible(true);
            
        } else if (e.getSource() == this.cadastroVenda.getjButtonPesquisarCarteirinha()) {
            BuscaCarteirinha buscaCarteirinha = new BuscaCarteirinha(null, true);
            ControllerBuscaCarteirinha controllerBuscaCarteirinha = new ControllerBuscaCarteirinha(buscaCarteirinha);
            buscaCarteirinha.setVisible(true);

        }

    }

}
