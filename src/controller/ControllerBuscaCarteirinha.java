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
import model.bo.Carteirinha;
import view.BuscaCarteirinha;

/**
 *
 * @author Thiago and Gabrieli
 */
public class ControllerBuscaCarteirinha implements ActionListener{
    
    BuscaCarteirinha buscaCarteirinha;

    public ControllerBuscaCarteirinha(BuscaCarteirinha buscaCarteirinha) {
        
        this.buscaCarteirinha = buscaCarteirinha;
        
        this.buscaCarteirinha.getjButtonFiltrar().addActionListener(this);
        this.buscaCarteirinha.getjButtonCarregar().addActionListener(this);
        this.buscaCarteirinha.getjButtonSair().addActionListener(this);
        this.buscaCarteirinha.getjComboBoxBuscaCarteirinhaPor().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaCarteirinha.getjButtonFiltrar()) {
            DefaultTableModel tabela = (DefaultTableModel) this.buscaCarteirinha.getjTableDados().getModel();
            tabela.setRowCount(0); // Limpa a tabela
    
            String filtro = this.buscaCarteirinha.getjTextFieldFiltrar().getText().trim();
    
            if (filtro.isEmpty()) {
                List<Carteirinha> listaCarteirinha = service.CarteirinhaService.carregar();
        
                for (Carteirinha carteirinhaAtual : listaCarteirinha) {
                    tabela.addRow(new Object[]{
                    carteirinhaAtual.getId(),
                    carteirinhaAtual.getCliente().getNome(),
                    carteirinhaAtual.getCodigoBarra(),
                    carteirinhaAtual.getDataCancelamento()
                    

                });
            }
            } else {
                String buscaPor = this.buscaCarteirinha.getjComboBoxBuscaCarteirinhaPor().getSelectedItem().toString().toLowerCase();
        
                List<Carteirinha> listaCarteirinha = null;
        
                if (buscaPor.equals("id")) {
                    listaCarteirinha = new ArrayList<>();
                    Carteirinha carteirinha = service.CarteirinhaService.carregar(Integer.parseInt(filtro));
                    if (carteirinha != null) {
                        listaCarteirinha.add(carteirinha);
                    }
                } else if (buscaPor.equals("código barra")) {
                    listaCarteirinha = service.CarteirinhaService.carregar("codigoBarra", filtro);
                } else if (buscaPor.equals("nome")) {
                    listaCarteirinha = service.CarteirinhaService.carregar("nome");
                }else if (buscaPor.equals("data geração")) {
                    listaCarteirinha = service.CarteirinhaService.carregar("dataGeracao", filtro);
                }
               
            if (listaCarteirinha != null) {
                for (Carteirinha carteirinhaAtual : listaCarteirinha) {
                    tabela.addRow(new Object[]{
                    carteirinhaAtual.getId(),
                    carteirinhaAtual.getCliente().getNome(),
                    carteirinhaAtual.getDataGeracao(),
                    carteirinhaAtual.getDataCancelamento(),
                    carteirinhaAtual.getCodigoBarra()
                });
            }
        }
        }}else if(e.getSource() == this.buscaCarteirinha.getjButtonCarregar()){
            controller.ControllerCadastroCarteirinha.codigo = (int) this.buscaCarteirinha.getjTableDados().
            getValueAt(this.buscaCarteirinha.getjTableDados().getSelectedRow(), 0);
            
            this.buscaCarteirinha.dispose();
            
        }else if(e.getSource() == this.buscaCarteirinha.getjButtonSair()){
            this.buscaCarteirinha.dispose();
            
        }
    }   
}
