/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BuscaEndereco;
import view.BuscaFuncionario;
import view.CadastroEndereco;
import view.CadastroFuncionario;

/**
 *
 * @author Thiago
 */
public class ControllerCadastroFuncionario implements ActionListener {

    CadastroFuncionario cadastroFuncionario;

    public ControllerCadastroFuncionario(CadastroFuncionario cadastroFuncionario) {
        this.cadastroFuncionario = cadastroFuncionario;

        this.cadastroFuncionario.getjButtonNovo().addActionListener(this);
        this.cadastroFuncionario.getjButtonSair().addActionListener(this);
        this.cadastroFuncionario.getjButtonCancelar().addActionListener(this);
        this.cadastroFuncionario.getjButtonSalvar().addActionListener(this);
        this.cadastroFuncionario.getjButtonConsultar().addActionListener(this);
        this.cadastroFuncionario.getjButtonAdicionarCep().addActionListener(this);
        this.cadastroFuncionario.getjButtonPesquisarCep().addActionListener(this);

        utilities.Utilities.ativa(true, this.cadastroFuncionario.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroFuncionario.getjPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == this.cadastroFuncionario.getjButtonNovo()) {
            utilities.Utilities.ativa(false, this.cadastroFuncionario.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroFuncionario.getjPanelDados());

        } else if (e.getSource() == this.cadastroFuncionario.getjButtonSair()) {
            this.cadastroFuncionario.dispose();

        } else if (e.getSource() == this.cadastroFuncionario.getjButtonCancelar()) {
            utilities.Utilities.ativa(true, this.cadastroFuncionario.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroFuncionario.getjPanelDados());

        } else if (e.getSource() == this.cadastroFuncionario.getjButtonSalvar()) {
            utilities.Utilities.ativa(true, cadastroFuncionario.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, cadastroFuncionario.getjPanelDados());

        } else if (e.getSource() == this.cadastroFuncionario.getjButtonConsultar()) {
            BuscaFuncionario buscaFuncionario = new BuscaFuncionario(null, true);
            ControllerBuscaFuncionario controllerBuscaFuncionario = new ControllerBuscaFuncionario(buscaFuncionario);
            buscaFuncionario.setVisible(true);
             
        } else if (e.getSource() == this.cadastroFuncionario.getjButtonPesquisarCep()){
             BuscaEndereco buscaEndereco = new BuscaEndereco(null, true);
             ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(buscaEndereco);
             buscaEndereco.setVisible(true);
                
        } else if (e.getSource() == this.cadastroFuncionario.getjButtonAdicionarCep()){
             CadastroEndereco cadastroEndereco = new CadastroEndereco();
             ControllerCadastroEndereco controllerCadastroEndereco = new ControllerCadastroEndereco(cadastroEndereco);
             cadastroEndereco.setVisible(true);
        }
    }

}
