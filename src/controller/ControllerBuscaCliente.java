/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        } else if (e.getSource() == this.buscaCliente.getjButtonCarregar()) {

        } else if (e.getSource() == this.buscaCliente.getjButtonSair()) {
            this.buscaCliente.dispose();

        }

    }

}
