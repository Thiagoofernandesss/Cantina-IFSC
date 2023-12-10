/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Caixa;
import view.BuscaCaixa;

/**
 *
 * @author gabri
 */
public class ControllerBuscaCaixa implements ActionListener{
    
    BuscaCaixa buscaCaixa;
    
    public ControllerBuscaCaixa(BuscaCaixa buscaCaixa) {
        this.buscaCaixa = buscaCaixa;
        this.buscaCaixa.getjButtonFiltrar().addActionListener(this);
        this.buscaCaixa.getjButtonCarregar().addActionListener(this);
        this.buscaCaixa.getjButtonSair().addActionListener(this);
        this.buscaCaixa.getjComboBoxBuscaCaixaPor().addActionListener(this);
        this.buscaCaixa.getjTextFieldFiltrar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaCaixa.getjButtonFiltrar()) {
            DefaultTableModel tabela = (DefaultTableModel) this.buscaCaixa.getjTableDados().getModel();
            tabela.setRowCount(0); // Limpa a tabela

            String filtro = this.buscaCaixa.getjTextFieldFiltrar().getText().trim();

            if (filtro.isEmpty()) {
                // Se o campo de filtro estiver vazio, exibe todos os clientes
                List<Caixa> listaCaixa = service.CaixaService.carregar();
                for (Caixa caixaAtual : listaCaixa) {
                    tabela.addRow(new Object[]{
                    caixaAtual.getId(),
                    caixaAtual.getObservaccao(),
                    caixaAtual.getFuncionario(),
                    caixaAtual.getStatus()
                });
            }
        } else {
            // Se houver texto no campo de filtro, realiza a busca com base no critério selecionado
            String buscaPor = this.buscaCaixa.getjComboBoxBuscaCaixaPor().getSelectedItem().toString().toLowerCase();

            List<Caixa> listaCaixa;

            if (buscaPor.equals("id")) {
                listaCaixa = new ArrayList<>();
                Caixa caixa = service.CaixaService.carregar(Integer.parseInt(filtro));
                if (caixa != null) {
                    listaCaixa.add(caixa);
                }
            } else if (buscaPor.equals("observação")) {
                listaCaixa = service.CaixaService.carregar("observacao", filtro);
            } else {
                listaCaixa = service.CaixaService.carregar(buscaPor, filtro);
            }

            for(Caixa caixaAtual : listaCaixa) {
                tabela.addRow(new Object[]{
                caixaAtual.getId(),
                caixaAtual.getObservaccao(),
                caixaAtual.getFuncionario(),
                caixaAtual.getStatus()
            });
        }
    }
    }else if (e.getSource() == this.buscaCaixa.getjButtonCarregar()) {
            controller.ControllerCadastroCliente.codigo = (int) this.buscaCaixa.getjTableDados().
                    getValueAt(this.buscaCaixa.getjTableDados().getSelectedRow(), 0);

            this.buscaCaixa.dispose();

        } else if (e.getSource() == this.buscaCaixa.getjButtonSair()) {
            this.buscaCaixa.dispose();

        }

    }
}
