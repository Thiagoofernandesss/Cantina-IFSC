/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Produto;
import view.BuscaProduto;

/**
 *
 * @author Thiago
 */
public class ControllerBuscaProduto implements ActionListener {

    BuscaProduto buscaProduto;

    public ControllerBuscaProduto(BuscaProduto buscaProduto) {
        this.buscaProduto = buscaProduto;

        this.buscaProduto.getjButtonFiltrar().addActionListener(this);
        this.buscaProduto.getjButtonCarregar().addActionListener(this);
        this.buscaProduto.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativa(true, this.buscaProduto.getjPanelBotoes());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaProduto.getjButtonFiltrar()) {
            Dao.ClasseDados.getInstance();
            
            DefaultTableModel tabela = (DefaultTableModel) this.buscaProduto.getjTableDados().getModel();
            
            for (Produto produtoAtual : Dao.ClasseDados.produtos) {
                tabela.addRow(new Object[]{produtoAtual.getId(), produtoAtual.getDescricao(), produtoAtual.getCodigoBarra(), produtoAtual.getStatus()});
                
            }

        } else if (e.getSource() == this.buscaProduto.getjButtonCarregar()) {

        } else if (e.getSource() == this.buscaProduto.getjButtonSair()) {
            this.buscaProduto.dispose();

        }
    }

}
