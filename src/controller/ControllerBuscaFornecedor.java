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
import model.bo.Fornecedor;
import view.BuscaFornecedor;

/**
 *
 * @author Thiago
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
            if (!this.buscaFornecedor.getjTextFieldFiltrar().getText().trim().equalsIgnoreCase("")) {
                List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();

                if (this.buscaFornecedor.getjComboBoxBuscaFornecedoresPor().getSelectedItem().toString().equalsIgnoreCase("id")) {
                    listaFornecedores.add(service.FornecedorService.carregar(Integer.parseInt(this.buscaFornecedor.getjTextFieldFiltrar().getText())));
                }else if(this.buscaFornecedor.getjComboBoxBuscaFornecedoresPor().getSelectedItem().toString().equalsIgnoreCase("Razão Social")){
                    listaFornecedores = service.FornecedorService.carregar("razaoSocial", this.buscaFornecedor.getjTextFieldFiltrar().getText());
                }else if(this.buscaFornecedor.getjComboBoxBuscaFornecedoresPor().getSelectedItem().toString().equalsIgnoreCase("Ins. Estadual")){
                    listaFornecedores = service.FornecedorService.carregar("inscricaoEstadual", this.buscaFornecedor.getjTextFieldFiltrar().getText());
                }else{
                    listaFornecedores = service.FornecedorService.carregar(this.buscaFornecedor.getjComboBoxBuscaFornecedoresPor().getSelectedItem().toString().toLowerCase(), 
                            this.buscaFornecedor.getjTextFieldFiltrar().getText());
                }

                DefaultTableModel tabela = (DefaultTableModel) this.buscaFornecedor.getjTableDados().getModel();
                tabela.setRowCount(0);
                
                for (Fornecedor fornecedorAtual : listaFornecedores) {
                    tabela.addRow(new Object[]{fornecedorAtual.getId(),
                        fornecedorAtual.getCnpj(),
                        fornecedorAtual.getRazaoSocial(),
                        fornecedorAtual.getInscricaoEstadual(),
                        fornecedorAtual.getStatus()});
                    
                }
            }

        } else if (e.getSource() == this.buscaFornecedor.getjButtonCarregar()) {
            controller.ControllerCadastroFornecedor.codigo = (int) this.buscaFornecedor.getjTableDados().
                    getValueAt(this.buscaFornecedor.getjTableDados().getSelectedRow(), 0);

        } else if (e.getSource() == this.buscaFornecedor.getjButtonSair()) {
            this.buscaFornecedor.dispose();
        }

    }

}
