/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;
import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import view.BuscaBairro;

/**
 *
 * @author Thiago
 */
public class ControllerBuscaBairro implements ActionListener{
    
    BuscaBairro buscaBairro;

    public ControllerBuscaBairro(BuscaBairro buscaBairro) {
        
        this.buscaBairro = buscaBairro;
        
        this.buscaBairro.getjButtonFiltrar().addActionListener(this);
        this.buscaBairro.getjButtonCarregar().addActionListener(this);
        this.buscaBairro.getjButtonSair().addActionListener(this);
        
        utilities.Utilities.ativa(true, this.buscaBairro.getjPanelBotoes());
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.buscaBairro.getjButtonFiltrar()){
            //Criando/Carregando uma instancia da classe singleton de dados
            Dao.ClasseDados.getInstance();
            
            //Criando um objeto do tipo TableModel
            DefaultTableModel tabela =(DefaultTableModel) this.buscaBairro.getjTableDados().getModel();
            for (Bairro bairroAtual : Dao.ClasseDados.bairros) {
                tabela.addRow(new Object[]{bairroAtual.getId(),
                                           bairroAtual.getDescricao()});
                
            }
        
        }else if(e.getSource() == this.buscaBairro.getjButtonCarregar()){
            controller.ControllerCadastroBairro.codigo = (int) this.buscaBairro.
                    getjTableDados().getValueAt(this.buscaBairro.getjTableDados().getSelectedRow(), 0);
            this.buscaBairro.dispose();
            
            
        
        }else if(e.getSource() == this.buscaBairro.getjButtonSair()){
            this.buscaBairro.dispose();
            
        }
    }
    
}
