/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;
import view.BuscaCidade;
import view.CadastroCidade;

/**
 *
 * @author Thiago
 */
public class ControllerCadastroCidade implements ActionListener {

    CadastroCidade cadastroCidade;

    public ControllerCadastroCidade(CadastroCidade cadastroCidade) {
        this.cadastroCidade = cadastroCidade;

        this.cadastroCidade.getjButtonNovo().addActionListener(this);
        this.cadastroCidade.getjButtonCancelar().addActionListener(this);
        this.cadastroCidade.getjButtonConsultar().addActionListener(this);
        this.cadastroCidade.getjButtonSair().addActionListener(this);
        this.cadastroCidade.getjButtonSalvar().addActionListener(this);

        utilities.Utilities.ativa(true, this.cadastroCidade.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroCidade.getjPanelDados());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroCidade.getjButtonNovo()) {
            utilities.Utilities.ativa(false, this.cadastroCidade.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroCidade.getjPanelDados());

        } else if (e.getSource() == this.cadastroCidade.getjButtonSair()) {
            this.cadastroCidade.dispose();
            

        } else if (e.getSource() == this.cadastroCidade.getjButtonCancelar()) {
            utilities.Utilities.ativa(true, this.cadastroCidade.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroCidade.getjPanelDados());

        } else if (e.getSource() == this.cadastroCidade.getjButtonSalvar()) {
            utilities.Utilities.ativa(true, cadastroCidade.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, cadastroCidade.getjPanelDados());

        } else if(e.getSource() == this.cadastroCidade.getjButtonConsultar()){
            BuscaCidade buscaCidade = new BuscaCidade(null, true);
            ControllerBuscaCidade controllerBuscaCidade = new ControllerBuscaCidade(buscaCidade);
            //Inserir o controller da busca de bairros
            buscaCidade.setVisible(true);

        }
    }

}
