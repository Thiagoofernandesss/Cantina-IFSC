/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Fornecedor;
import view.BuscaFornecedor;

/**
 *
 * @author Thiago and Gabrieli
 */
public class ControllerBuscaFornecedor implements ActionListener {

    BuscaFornecedor buscaFornecedor;

    public ControllerBuscaFornecedor(BuscaFornecedor buscaFornecedor) {
        this.buscaFornecedor = buscaFornecedor;
        this.buscaFornecedor.getjButtonFiltrar().addActionListener(this);
        this.buscaFornecedor.getjButtonCarregar().addActionListener(this);
        this.buscaFornecedor.getjButtonSair().addActionListener(this);
        this.buscaFornecedor.getjComboBoxBuscaFornecedoresPor().addActionListener(this);
        this.buscaFornecedor.getjTextFieldFiltrar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

       if (e.getSource() == this.buscaFornecedor.getjButtonFiltrar()) {
            DefaultTableModel tabela = (DefaultTableModel) this.buscaFornecedor.getjTableDados().getModel();
            tabela.setRowCount(0); // Limpa a tabela

            String filtro = this.buscaFornecedor.getjTextFieldFiltrar().getText().trim();

            if (filtro.isEmpty()) {
                List<Fornecedor> listaFornecedor = service.FornecedorService.carregar();
                
                 for (Fornecedor fornecedorAtual : listaFornecedor) {
                    tabela.addRow(new Object[]{
                    fornecedorAtual.getId(),
                    fornecedorAtual.getCnpj(),
                    fornecedorAtual.getRazaoSocial(),
                    fornecedorAtual.getInscricaoEstadual(),
                    fornecedorAtual.getStatus()
                });
            }
            }else{
               String buscaPor = this.buscaFornecedor.getjComboBoxBuscaFornecedoresPor().getSelectedItem().toString().toLowerCase();
               
               List<Fornecedor> listaFornecedor;
                if (buscaPor.equals("id")) {
                    listaFornecedor =  new ArrayList<>();
                    Fornecedor fornecedor = service.FornecedorService.carregar(Integer.parseInt(filtro));
                    if (fornecedor != null) {
                        listaFornecedor.add(fornecedor);
                    }
                }else if (buscaPor.equals("razão social")) {
                    listaFornecedor = service.FornecedorService.carregar("razaoSocial", filtro);
                }else if (buscaPor.equals("inscrição estadual")) {
                    listaFornecedor = service.FornecedorService.carregar("inscricaoEstadual", filtro);
                }else{
                    listaFornecedor = service.FornecedorService.carregar(buscaPor, filtro);
                }
                
                 for (Fornecedor fornecedorAtual : listaFornecedor) {
                    tabela.addRow(new Object[]{
                    fornecedorAtual.getId(),
                    fornecedorAtual.getCnpj(),
                    fornecedorAtual.getRazaoSocial(),
                    fornecedorAtual.getInscricaoEstadual(),
                    fornecedorAtual.getStatus()
                });
            }
        }} else if (e.getSource() == this.buscaFornecedor.getjButtonCarregar()) {
           controller.ControllerCadastroFornecedor.codigo = (int) this.buscaFornecedor.getjTableDados().
                    getValueAt(this.buscaFornecedor.getjTableDados().getSelectedRow(), 0);

            this.buscaFornecedor.dispose();

        } else if (e.getSource() == this.buscaFornecedor.getjButtonSair()) {
            this.buscaFornecedor.dispose();
        }

    }

}
