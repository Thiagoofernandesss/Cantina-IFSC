/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BuscaFuncionario;

/**
 *
 * @author Thiago
 */
public class ControllerBuscaFuncionario implements ActionListener{
    
    BuscaFuncionario buscaFuncionario;

    public ControllerBuscaFuncionario(BuscaFuncionario buscaFuncionario) {
        this.buscaFuncionario = buscaFuncionario;
        
        this.buscaFuncionario.getjButtonFiltrar().addActionListener(this);
        this.buscaFuncionario.getjButtonCarregar().addActionListener(this);
        this.buscaFuncionario.getjButtonSair().addActionListener(this);
        
        utilities.Utilities.ativa(true, this.buscaFuncionario.getjPanelBotoes());
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.buscaFuncionario.getjButtonFiltrar()){
        
        }else if(e.getSource() == this.buscaFuncionario.getjButtonCarregar()){
        
        }else if(e.getSource() == this.buscaFuncionario.getjButtonSair()){
            this.buscaFuncionario.dispose();
        }
    }
    
    
}
