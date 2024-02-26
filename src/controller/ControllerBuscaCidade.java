/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Cidade;
import service.CidadeService;
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
        this.buscaCidade.getjComboBoxBuscaCidadesPor().addActionListener(this);
        this.buscaCidade.getjTextFieldFiltrar().addActionListener(this);
    }

    @Override
     public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaCidade.getjButtonFiltrar()) {        
            DefaultTableModel tabela = (DefaultTableModel) this.buscaCidade.getjTableDados().getModel();
            tabela.setRowCount(0);

            String filtro = this.buscaCidade.getjTextFieldFiltrar().getText().trim();

            if (filtro.isEmpty()) {
                List<Cidade> listaCidades = service.CidadeService.carregar();

                for (Cidade cidadeatual : listaCidades) {
                    tabela.addRow(new Object[]{cidadeatual.getId(),
                        cidadeatual.getDescricao(),
                        cidadeatual.getUf()
                    });

                }

            } else {
                List<Cidade> listaCidades = new ArrayList<Cidade>();

                if (this.buscaCidade.getjComboBoxBuscaCidadesPor().getSelectedItem().toString().equalsIgnoreCase("id")) {
                    listaCidades.add(service.CidadeService.carregar(Integer.parseInt(this.buscaCidade.getjTextFieldFiltrar().getText())));
                } else if (this.buscaCidade.getjComboBoxBuscaCidadesPor().getSelectedItem().toString().equalsIgnoreCase("descrição")) {
                    listaCidades = service.CidadeService.carregar("cidade.descricao", this.buscaCidade.getjTextFieldFiltrar().getText());
                } else if (this.buscaCidade.getjComboBoxBuscaCidadesPor().getSelectedItem().toString().equalsIgnoreCase("uf")) {
                    listaCidades = service.CidadeService.carregar("cidade.uf", this.buscaCidade.getjTextFieldFiltrar().getText());
                } else {
                    listaCidades = service.CidadeService.carregar(this.buscaCidade.getjComboBoxBuscaCidadesPor().getSelectedItem().toString(),
                            this.buscaCidade.getjTextFieldFiltrar().getText());
                }

                for (Cidade cidadeatual : listaCidades) {
                    tabela.addRow(new Object[]{cidadeatual.getId(),
                        cidadeatual.getDescricao(),
                        cidadeatual.getUf()
                    });

                }

            }

        } else if (e.getSource() == this.buscaCidade.getjButtonCarregar()) {
            controller.ControllerCadastroCidade.codigo = (int) this.buscaCidade.getjTableDados().
                    getValueAt(this.buscaCidade.getjTableDados().getSelectedRow(), 0);
            this.buscaCidade.dispose();

        } else if (e.getSource() == this.buscaCidade.getjButtonSair()) {
            this.buscaCidade.dispose();
        }
    }


}
