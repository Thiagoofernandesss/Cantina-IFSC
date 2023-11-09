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
import model.bo.Funcionario;
import view.BuscaFuncionario;

/**
 *
 * @author Thiago and Gabrieli
 */
public class ControllerBuscaFuncionario implements ActionListener{
    
    BuscaFuncionario buscaFuncionario;

    public ControllerBuscaFuncionario(BuscaFuncionario buscaFuncionario) {
        this.buscaFuncionario = buscaFuncionario;
        this.buscaFuncionario.getjButtonFiltrar().addActionListener(this);
        this.buscaFuncionario.getjButtonCarregar().addActionListener(this);
        this.buscaFuncionario.getjComboBoxBuscaFuncionariosPor().addActionListener(this);
        this.buscaFuncionario.getjButtonSair().addActionListener(this);
        this.buscaFuncionario.getjTextFieldFiltrar().addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaFuncionario.getjButtonFiltrar()) {
            DefaultTableModel tabela = (DefaultTableModel) this.buscaFuncionario.getjTableDados().getModel();
            tabela.setRowCount(0); // Limpa a tabela

            String filtro = this.buscaFuncionario.getjTextFieldFiltrar().getText().trim();

            if (filtro.isEmpty()) {
                // Se o campo de filtro estiver vazio, exibe todos os funcionários
                List<Funcionario> listaFuncionarios = service.FuncionarioService.carregar();
                
                for (Funcionario funcionarioAtual : listaFuncionarios) {
                    tabela.addRow(new Object[]{
                    funcionarioAtual.getId(),
                    funcionarioAtual.getNome(),
                    funcionarioAtual.getCpf(),
                    funcionarioAtual.getRg(),
                    funcionarioAtual.getUsuario(),
                    funcionarioAtual.getStatus()
                });
            }
        } else {
            // Se houver texto no campo de filtro, realiza a busca com base no critério selecionado
            String buscaPor = this.buscaFuncionario.getjComboBoxBuscaFuncionariosPor().getSelectedItem().toString().toLowerCase();

            List<Funcionario> listaFuncionarios;
            if (buscaPor.equals("id")) {
                listaFuncionarios = new ArrayList<>();
                Funcionario funcionario = service.FuncionarioService.carregar(Integer.parseInt(filtro));
                if (funcionario != null) {
                    listaFuncionarios.add(funcionario);
                }
            } else {
                listaFuncionarios = service.FuncionarioService.carregar(buscaPor, filtro);
            }

            for (Funcionario funcionarioAtual : listaFuncionarios) {
                tabela.addRow(new Object[]{
                funcionarioAtual.getId(),
                funcionarioAtual.getNome(),
                funcionarioAtual.getCpf(),
                funcionarioAtual.getRg(),
                funcionarioAtual.getUsuario(),
                funcionarioAtual.getStatus()
            });
        }
    }
}else if(e.getSource() == this.buscaFuncionario.getjButtonCarregar()){
            controller.ControllerCadastroFuncionario.codigo = (int) this.buscaFuncionario.getjTableDados().
                    getValueAt(this.buscaFuncionario.getjTableDados().getSelectedRow(), 0);

            this.buscaFuncionario.dispose();
        
        }else if(e.getSource() == this.buscaFuncionario.getjButtonSair()){
            this.buscaFuncionario.dispose();
        }
    }
    
    
}
