/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BuscaCarteirinha;

/**
 *
 * @author Thiago
 */
public class ControllerBuscaCarteirinha implements ActionListener{
    
    BuscaCarteirinha buscaCarteirinha;

    public ControllerBuscaCarteirinha(BuscaCarteirinha buscaCarteirinha) {
        
        this.buscaCarteirinha = buscaCarteirinha;
        
        this.buscaCarteirinha.getjButtonFiltrar().addActionListener(this);
        this.buscaCarteirinha.getjButtonCarregar().addActionListener(this);
        this.buscaCarteirinha.getjButtonSair().addActionListener(this);
        
        utilities.Utilities.ativa(true, this.buscaCarteirinha.getjPanelBotoes());
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.buscaCarteirinha.getjButtonFiltrar()){
        
        }else if(e.getSource() == this.buscaCarteirinha.getjButtonCarregar()){
        
        }else if(e.getSource() == this.buscaCarteirinha.getjButtonSair()){
            this.buscaCarteirinha.dispose();
            
        }
    }
    
    
    
}
