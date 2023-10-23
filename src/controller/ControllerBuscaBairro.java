/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import service.BairroService;
import view.BuscaBairro;

/**
 *
 * @author Thiago
 */
public class ControllerBuscaBairro implements ActionListener {

    BuscaBairro buscaBairro;

    public ControllerBuscaBairro(BuscaBairro buscaBairro) {

        this.buscaBairro = buscaBairro;
        this.buscaBairro.getjButtonFiltrar().addActionListener(this);
        this.buscaBairro.getjButtonCarregar().addActionListener(this);
        this.buscaBairro.getjButtonSair().addActionListener(this);

        //Teste Seguiindo proj. Rober
        //utilities.Utilities.ativa(true, this.buscaBairro.getjPanelBotoes());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaBairro.getjButtonFiltrar()) {
            if (this.buscaBairro.getjTextFieldFiltrar().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atenção opção de filtro vazia");
                this.buscaBairro.getjTextFieldFiltrar().requestFocus();

            } else {
                List<Bairro> listaBairros = new ArrayList<Bairro>();
                
                if(this.buscaBairro.getjComboBoxBuscaBairroPor().getSelectedIndex()==0){
                    listaBairros.add(BairroService.carregar(Integer.parseInt(this.buscaBairro.getjTextFieldFiltrar().getText())));
                    
                }else if(this.buscaBairro.getjComboBoxBuscaBairroPor().getSelectedIndex()==1){
                    listaBairros= BairroService.carregar(this.buscaBairro.getjTextFieldFiltrar().getText().trim());
                
                }
   
                
                //Criando um objeto do tipo TableModel
                DefaultTableModel tabela = (DefaultTableModel) this.buscaBairro.getjTableDados().getModel();
                tabela.setRowCount(0);
                for (Bairro bairroAtual : listaBairros) {
                    tabela.addRow(new Object[]{bairroAtual.getId(),
                        bairroAtual.getDescricao()});

                }

            }

        } else if (e.getSource() == this.buscaBairro.getjButtonCarregar()) {

            controller.ControllerCadastroBairro.codigo = (int) this.buscaBairro.
                    getjTableDados().getValueAt(this.buscaBairro.getjTableDados().getSelectedRow(), 0);
            controller.ControllerCadastroEndereco.codigo = (int) this.buscaBairro.
                    getjTableDados().getValueAt(this.buscaBairro.getjTableDados().getSelectedRow(), 0);
            this.buscaBairro.dispose();

        } else if (e.getSource() == this.buscaBairro.getjButtonSair()) {
            this.buscaBairro.dispose();

        }
    }

}
