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
        if(e.getSource() == this.buscaFuncionario.getjButtonFiltrar()){
            if (!this.buscaFuncionario.getjTextFieldFiltrar().getText().trim().equalsIgnoreCase("")) {
                List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
                
                if(this.buscaFuncionario.getjComboBoxBuscaFuncionariosPor().getSelectedItem().toString().equalsIgnoreCase("id")) {
                    listaFuncionarios.add(service.FuncionarioService.carregar(Integer.parseInt(this.buscaFuncionario.getjTextFieldFiltrar().getText())));
                }else {
                    listaFuncionarios = service.FuncionarioService.carregar(this.buscaFuncionario.getjComboBoxBuscaFuncionariosPor().getSelectedItem().toString().toLowerCase(),
                            this.buscaFuncionario.getjTextFieldFiltrar().getText());
                }
                
                //Criando um objeto do tipo table model
                DefaultTableModel tabela = (DefaultTableModel) this.buscaFuncionario.getjTableDados().getModel();
                tabela.setRowCount(0);

                for (Funcionario funcionarioAtual : listaFuncionarios) {
                    tabela.addRow(new Object[]{funcionarioAtual.getId(),
                        funcionarioAtual.getNome(),
                        funcionarioAtual.getCpf(),
                        funcionarioAtual.getRg(),
                        funcionarioAtual.getUsuario(),
                        funcionarioAtual.getStatus()});

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
