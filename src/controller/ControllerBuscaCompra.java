/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BuscaCompra;

/**
 *
 * @author Thiago
 */
public class ControllerBuscaCompra implements ActionListener{
    
    BuscaCompra buscaCompra;

    public ControllerBuscaCompra(BuscaCompra buscaCompra) {
        this.buscaCompra = buscaCompra;
        
        this.buscaCompra.getjButtonFiltrar().addActionListener(this);
        this.buscaCompra.getjButtonCarregar().addActionListener(this);
        this.buscaCompra.getjButtonSair().addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.buscaCompra.getjButtonFiltrar()){
        
        }else if(e.getSource() == this.buscaCompra.getjButtonCarregar()){
        
        }else if(e.getSource() == this.buscaCompra.getjButtonSair()){
            this.buscaCompra.dispose();
            
        }
    }
    
    
    
}
