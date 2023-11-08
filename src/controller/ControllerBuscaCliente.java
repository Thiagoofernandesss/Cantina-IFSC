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
        this.buscaCliente.getjComboBoxBuscaClientesPor().addActionListener(this);
        this.buscaCliente.getjTextFieldFiltrar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaCliente.getjButtonFiltrar()) {
            DefaultTableModel tabela = (DefaultTableModel) this.buscaCliente.getjTableDados().getModel();
            tabela.setRowCount(0); // Limpa a tabela

            String filtro = this.buscaCliente.getjTextFieldFiltrar().getText().trim();

            if (filtro.isEmpty()) {
                // Se o campo de filtro estiver vazio, exibe todos os clientes
                List<Cliente> listaClientes = service.ClienteService.carregar();
                for (Cliente clienteAtual : listaClientes) {
                    tabela.addRow(new Object[]{
                    clienteAtual.getId(),
                    clienteAtual.getNome(),
                    clienteAtual.getCpf(),
                    clienteAtual.getMatricula(),
                    clienteAtual.getStatus()
                });
            }
        } else {
            // Se houver texto no campo de filtro, realiza a busca com base no critério selecionado
            String buscaPor = this.buscaCliente.getjComboBoxBuscaClientesPor().getSelectedItem().toString().toLowerCase();

            List<Cliente> listaClientes;

            if (buscaPor.equals("id")) {
                listaClientes = new ArrayList<>();
                Cliente cliente = service.ClienteService.carregar(Integer.parseInt(filtro));
                if (cliente != null) {
                    listaClientes.add(cliente);
                }
            } else if (buscaPor.equals("matrícula")) {
                listaClientes = service.ClienteService.carregar("matricula", filtro);
            } else {
                listaClientes = service.ClienteService.carregar(buscaPor, filtro);
            }

            for (Cliente clienteAtual : listaClientes) {
                tabela.addRow(new Object[]{
                clienteAtual.getId(),
                clienteAtual.getNome(),
                clienteAtual.getCpf(),
                clienteAtual.getMatricula(),
                clienteAtual.getStatus()
            });
        }
    }
    }else if (e.getSource() == this.buscaCliente.getjButtonCarregar()) {
            controller.ControllerCadastroCliente.codigo = (int) this.buscaCliente.getjTableDados().
                    getValueAt(this.buscaCliente.getjTableDados().getSelectedRow(), 0);

            this.buscaCliente.dispose();

        } else if (e.getSource() == this.buscaCliente.getjButtonSair()) {
            this.buscaCliente.dispose();

        }

    }

}
