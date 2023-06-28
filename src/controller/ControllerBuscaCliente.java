/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Cliente;
import view.BuscaCliente;

/**
 *
 * @author Thiago
 */
public class ControllerBuscaCliente implements ActionListener {

    BuscaCliente buscaCliente;

    public ControllerBuscaCliente(BuscaCliente buscaCliente) {
        this.buscaCliente = buscaCliente;

        this.buscaCliente.getjButtonFiltrar().addActionListener(this);
        this.buscaCliente.getjButtonCarregar().addActionListener(this);
        this.buscaCliente.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativa(true, this.buscaCliente.getjPanelBotoes());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaCliente.getjButtonFiltrar()) {
            //Criando/carregando uma instancia da classe singleton de dados
            Dao.ClasseDados.getInstance();
            
            //Criando um objeto do tipo table model
            DefaultTableModel tabela = (DefaultTableModel) this.buscaCliente.getjTableDados().getModel();
            
            for (Cliente clienteAtual : Dao.ClasseDados.clientes) {
                tabela.addRow(new Object[]{clienteAtual.getId(),
                                            clienteAtual.getNome(), 
                                            clienteAtual.getMatricula(), 
                                            clienteAtual.getStatus()});
                
            }
            

        } else if (e.getSource() == this.buscaCliente.getjButtonCarregar()) {
            controller.ControllerCadastroCliente.codigo = (int) this.buscaCliente.
                    getjTableDados().getValueAt(this.buscaCliente.getjTableDados().getSelectedRow(), 0);
            
            
            this.buscaCliente.dispose();

        } else if (e.getSource() == this.buscaCliente.getjButtonSair()) {
            this.buscaCliente.dispose();

        }

    }

}
