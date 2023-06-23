/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Endereco;
import view.BuscaEndereco;

/**
 *
 * @author Thiago
 */
public class ControllerBuscaEndereco implements ActionListener {

    BuscaEndereco buscaEndereco;

    public ControllerBuscaEndereco(BuscaEndereco buscaEndereco) {
        this.buscaEndereco = buscaEndereco;

        this.buscaEndereco.getjButtonFiltrar().addActionListener(this);
        this.buscaEndereco.getjButtonCarregar().addActionListener(this);
        this.buscaEndereco.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativa(true, this.buscaEndereco.getjPanelBotoes());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaEndereco.getjButtonFiltrar()) {
            
            Dao.ClasseDados.getInstance();

            DefaultTableModel tabela = (DefaultTableModel) this.buscaEndereco.getjTableDados().getModel();

            for (Endereco enderecoAtual : Dao.ClasseDados.enderecos) {
                tabela.addRow(new Object[]{enderecoAtual.getId(),
                    enderecoAtual.getCep(),
                    enderecoAtual.getLogradouro(),
                    enderecoAtual.getStatus(),
                    enderecoAtual.getCidade().getDescricao(),
                    enderecoAtual.getBairro().getDescricao()});

            }

        } else if (e.getSource() == this.buscaEndereco.getjButtonCarregar()) {
            controller.ControllerCadastroEndereco.codigo = (int) this.buscaEndereco.getjTableDados().
                    getValueAt(this.buscaEndereco.getjTableDados().getSelectedRow(), 0);
            this.buscaEndereco.dispose();
            

        } else if (e.getSource() == this.buscaEndereco.getjButtonSair()) {
            this.buscaEndereco.dispose();
        }
    }

}
