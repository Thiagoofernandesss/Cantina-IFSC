/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BuscaCarteirinha;
import view.BuscaCliente;
import view.CadastroCarteirinha;
import view.CadastroCliente;

/**
 *
 * @author Thiago
 */
public class ControllerCadastroCarteirinha implements ActionListener {

    CadastroCarteirinha cadastroCarteirinha;

    public ControllerCadastroCarteirinha(CadastroCarteirinha cadastroCarteirinha) {
        this.cadastroCarteirinha = cadastroCarteirinha;

        this.cadastroCarteirinha.getjButtonNovo().addActionListener(this);
        this.cadastroCarteirinha.getjButtonSalvar().addActionListener(this);
        this.cadastroCarteirinha.getjButtonCancelar().addActionListener(this);
        this.cadastroCarteirinha.getjButtonConsultar().addActionListener(this);
        this.cadastroCarteirinha.getjButtonSair().addActionListener(this);
        this.cadastroCarteirinha.getjButtonPesquisarCPF().addActionListener(this);
        this.cadastroCarteirinha.getjButtonAdicionarCPF().addActionListener(this);

        utilities.Utilities.ativa(true, this.cadastroCarteirinha.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroCarteirinha.getjPanelDados());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroCarteirinha.getjButtonNovo()) {
            utilities.Utilities.ativa(false, this.cadastroCarteirinha.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroCarteirinha.getjPanelDados());

        } else if (e.getSource() == this.cadastroCarteirinha.getjButtonSair()) {
            this.cadastroCarteirinha.dispose();

        } else if (e.getSource() == this.cadastroCarteirinha.getjButtonCancelar()) {
            utilities.Utilities.ativa(true, this.cadastroCarteirinha.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroCarteirinha.getjPanelDados());

        } else if (e.getSource() == this.cadastroCarteirinha.getjButtonSalvar()) {
            utilities.Utilities.ativa(true, cadastroCarteirinha.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, cadastroCarteirinha.getjPanelDados());

        } else if (e.getSource() == this.cadastroCarteirinha.getjButtonConsultar()) {
            BuscaCarteirinha buscaCarteirinha = new BuscaCarteirinha(null, true);
            ControllerBuscaCarteirinha controllerBuscaCarteirinha = new ControllerBuscaCarteirinha(buscaCarteirinha);
            //Inserir o controller da busca de bairros
            buscaCarteirinha.setVisible(true);

        } else if (e.getSource() == this.cadastroCarteirinha.getjButtonAdicionarCPF()) {
            CadastroCliente cadastroCliente = new CadastroCliente();
            ControllerCadastroCliente controllerCadastroCliente = new ControllerCadastroCliente(cadastroCliente);
            cadastroCliente.setVisible(true);

        } else if (e.getSource() == this.cadastroCarteirinha.getjButtonPesquisarCPF()) {
            BuscaCliente buscaCliente = new BuscaCliente(null, true);
            ControllerBuscaCliente controllerBuscaCliente = new ControllerBuscaCliente(buscaCliente);
            buscaCliente.setVisible(true);
        }
    }

}
