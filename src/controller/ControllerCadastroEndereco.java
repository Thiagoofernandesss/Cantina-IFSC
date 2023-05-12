/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BuscaBairro;
import view.CadastroEndereco;

/**
 *
 * @author Thiago
 */
public class ControllerCadastroEndereco implements ActionListener{
    
    CadastroEndereco cadastroEndereco;

    public ControllerCadastroEndereco(CadastroEndereco cadastroEndereco) {
        
        this.cadastroEndereco = cadastroEndereco;
        
        this.cadastroEndereco.getjButtonNovo().addActionListener(this);
        this.cadastroEndereco.getjButtonSair().addActionListener(this);
        this.cadastroEndereco.getjButtonCancelar().addActionListener(this);
        this.cadastroEndereco.getjButtonSalvar().addActionListener(this);
        this.cadastroEndereco.getjButtonConsultar().addActionListener(this);
        
        utilities.Utilities.ativa(true, this.cadastroEndereco.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroEndereco.getjPanelDados());
    }

    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroEndereco.getjButtonNovo()) {
            utilities.Utilities.ativa(false, this.cadastroEndereco.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroEndereco.getjPanelDados());

        } else if (e.getSource() == this.cadastroEndereco.getjButtonSair()) {
            this.cadastroEndereco.dispose();

        } else if (e.getSource() == this.cadastroEndereco.getjButtonCancelar()) {
            utilities.Utilities.ativa(true, this.cadastroEndereco.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroEndereco.getjPanelDados());

        } else if (e.getSource() == this.cadastroEndereco.getjButtonSalvar()) {
            utilities.Utilities.ativa(true, cadastroEndereco.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, cadastroEndereco.getjPanelDados());

        } else if (e.getSource() == this.cadastroEndereco.getjButtonConsultar()) {
            BuscaBairro buscaBairro = new BuscaBairro(null, true);
            //Inserir o controller da busca de bairros
            buscaBairro.setVisible(true);

        }
    }
    
}
