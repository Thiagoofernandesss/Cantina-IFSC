/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BuscaCliente;
import view.CadastroCliente;

/**
 *
 * @author Thiago
 */
public class ControllerCadastroCliente implements ActionListener {

    CadastroCliente cadastroCliente;

    public ControllerCadastroCliente(CadastroCliente cadastroCliente) {
        this.cadastroCliente = cadastroCliente;

        this.cadastroCliente.getjButtonNovo().addActionListener(this);
        this.cadastroCliente.getjButtonSair().addActionListener(this);
        this.cadastroCliente.getjButtonCancelar().addActionListener(this);
        this.cadastroCliente.getjButtonSalvar().addActionListener(this);
        this.cadastroCliente.getjButtonConsultar().addActionListener(this);

        utilities.Utilities.ativa(true, this.cadastroCliente.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroCliente.getjPanelDados());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroCliente.getjButtonNovo()) {
            utilities.Utilities.ativa(false, this.cadastroCliente.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroCliente.getjPanelDados());

        } else if (e.getSource() == this.cadastroCliente.getjButtonSair()) {
            this.cadastroCliente.dispose();

        } else if (e.getSource() == this.cadastroCliente.getjButtonCancelar()) {
            utilities.Utilities.ativa(true, this.cadastroCliente.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroCliente.getjPanelDados());

        } else if (e.getSource() == this.cadastroCliente.getjButtonSalvar()) {
            utilities.Utilities.ativa(true, cadastroCliente.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, cadastroCliente.getjPanelDados());

        } else if (e.getSource() == this.cadastroCliente.getjButtonConsultar()) {
            BuscaCliente buscaCliente = new BuscaCliente(null, true);
            //Inserir o controller da busca de bairros
            buscaCliente.setVisible(true);

        }
    }

}
