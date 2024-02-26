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
import model.bo.Produto;
import service.ProdutoService;
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
        this.buscaProduto.getjComboBoxBuscaProdutoPor().addActionListener(this);
        this.buscaProduto.getjTextFieldFiltrar().addActionListener(this);

        //utilities.Utilities.ativa(true, this.buscaProduto.getjPanelBotoes());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaProduto.getjButtonFiltrar()) {
DefaultTableModel tabela = (DefaultTableModel) this.buscaProduto.getjTableDados().getModel();
    tabela.setRowCount(0);

    String filtro = this.buscaProduto.getjTextFieldFiltrar().getText().trim();

    if (filtro.isEmpty()) {
        List<Produto> listaProdutos = service.ProdutoService.carregar();
        
        for (Produto produtoAtual : listaProdutos) {
            tabela.addRow(new Object[]{
                produtoAtual.getId(),
                produtoAtual.getDescricao(),
                produtoAtual.getCodigoBarra(),
                produtoAtual.getPreco(),
                produtoAtual.getStatus()
            });
        }
    } else {
        List<Produto> listaProdutos = new ArrayList<Produto>();
        String buscaPor = this.buscaProduto.getjComboBoxBuscaProdutoPor().getSelectedItem().toString();

        if (buscaPor.equalsIgnoreCase("ID")) {
            listaProdutos.add(service.ProdutoService.carregar(Integer.parseInt(filtro)));
        }else if(buscaPor.equalsIgnoreCase("DESCRIÇÃO")){
            listaProdutos = service.ProdutoService.carregar("descricao", filtro);
        }else if(buscaPor.equalsIgnoreCase("CÓDIGO DE BARRAS")){
            listaProdutos = service.ProdutoService.carregar("codigoBarra", filtro);
        } 
        else {
            listaProdutos = service.ProdutoService.carregar(buscaPor.toLowerCase(), filtro);
        }

        for (Produto produtoAtual : listaProdutos) {
            tabela.addRow(new Object[]{
                produtoAtual.getId(),
                produtoAtual.getDescricao(),
                produtoAtual.getCodigoBarra(),
                produtoAtual.getPreco(),
                produtoAtual.getStatus()
            });
        }
    }

        } else if (e.getSource() == this.buscaProduto.getjButtonCarregar()) {   
             controller.ControllerCadastroProduto.codigo = (int) this.buscaProduto.getjTableDados().
                    getValueAt(this.buscaProduto.getjTableDados().getSelectedRow(), 0);

            this.buscaProduto.dispose();

        } else if (e.getSource() == this.buscaProduto.getjButtonSair()) {
            this.buscaProduto.dispose();

        }
    }

}
