/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Cidade;
import view.BuscaCidade;

/**
 *
 * @author Thiago
 */
public class ControllerBuscaCidade implements ActionListener {

    BuscaCidade buscaCidade;

    public ControllerBuscaCidade(BuscaCidade buscaCidade) {
        this.buscaCidade = buscaCidade;

        this.buscaCidade.getjButtonFiltrar().addActionListener(this);
        this.buscaCidade.getjButtonCarregar().addActionListener(this);
        this.buscaCidade.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativa(true, this.buscaCidade.getjPanelBotoes());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.buscaCidade.getjButtonFiltrar()){
            //Criando/Carregando uma instancia da classe singleton de dados
            
            Dao.ClasseDados.getInstance();
        
            //Criando um objeto do tipo TableModel
            DefaultTableModel tabela = (DefaultTableModel) this.buscaCidade.getjTableDados().getModel();
        
            for (Cidade cidadeAtual : Dao.ClasseDados.cidades) {
                tabela.addRow(new Object[]{cidadeAtual.getId(), cidadeAtual.getDescricao(), cidadeAtual.getUf()});
                
            }
        
        }else if(e.getSource() == this.buscaCidade.getjButtonCarregar()){
            controller.ControllerCadastroCidade.codigo = (int) this.buscaCidade.getjTableDados().
                    getValueAt(this.buscaCidade.getjTableDados().getSelectedRow(), 0);

            this.buscaCidade.dispose();
        
        }else if(e.getSource() == this.buscaCidade.getjButtonSair()){
            this.buscaCidade.dispose();
        }
    }

}
