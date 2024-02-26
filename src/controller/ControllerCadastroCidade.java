/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.WindowConstants;
import model.bo.Cidade;
import utilities.Utilities;
import view.BuscaCidade;
import view.CadastroCidade;

/**
 *
 * @author Thiago
 */
public class ControllerCadastroCidade implements ActionListener {

    CadastroCidade cadastroCidade;
    public static int codigo;

    public ControllerCadastroCidade(CadastroCidade cadastroCidade) {
        this.cadastroCidade = cadastroCidade;

        this.cadastroCidade.getjButtonNovo().addActionListener(this);
        this.cadastroCidade.getjButtonCancelar().addActionListener(this);
        this.cadastroCidade.getjButtonConsultar().addActionListener(this);
        this.cadastroCidade.getjButtonSair().addActionListener(this);
        this.cadastroCidade.getjButtonSalvar().addActionListener(this);
        
        this.cadastroCidade.getjTextFieldDescricao().addFocusListener(focus);

        utilities.Utilities.ativa(true, this.cadastroCidade.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroCidade.getjPanelDados());

    }
    
    FocusListener focus = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            
            cadastroCidade.getjTextFieldDescricao().requestFocus();  
        }

        @Override
        public void focusLost(FocusEvent e) {
            
            Utilities.turnTextFieldRed(cadastroCidade.getjTextFieldDescricao());
        }
    };
   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroCidade.getjButtonNovo()) {
            utilities.Utilities.ativa(false, this.cadastroCidade.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroCidade.getjPanelDados());
            //Desligando o ID no braço (Provisório)
            this.cadastroCidade.getjTextFieldId().setEditable(false);

        } else if (e.getSource() == this.cadastroCidade.getjButtonSair()) {
            this.cadastroCidade.dispose();
            

        } else if (e.getSource() == this.cadastroCidade.getjButtonCancelar()) {
            utilities.Utilities.ativa(true, this.cadastroCidade.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroCidade.getjPanelDados());
            utilities.Utilities.turnTextFieldGray(this.cadastroCidade.getjTextFieldDescricao());

        } else if (e.getSource() == this.cadastroCidade.getjButtonSalvar()) {
            
            Cidade cidade = new Cidade();
            cidade.setDescricao(this.cadastroCidade.getjTextFieldDescricao().getText());
            cidade.setUf((String) this.cadastroCidade.getjComboBoxUf().getSelectedItem());
            
            if(this.cadastroCidade.getjTextFieldId().getText().equalsIgnoreCase("")){  
                service.CidadeService.adicionar(cidade);
            }else{
                cidade.setId(Integer.parseInt(this.cadastroCidade.getjTextFieldId().getText()));
                service.CidadeService.atualizar(cidade);
            }
            utilities.Utilities.ativa(true, cadastroCidade.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, cadastroCidade.getjPanelDados());
            utilities.Utilities.turnTextFieldGray(this.cadastroCidade.getjTextFieldDescricao());
            
        } else if(e.getSource() == this.cadastroCidade.getjButtonConsultar()){
            codigo=0;
            
            BuscaCidade buscaCidade = new BuscaCidade(null, true);
            ControllerBuscaCidade controllerBuscaCidade = new ControllerBuscaCidade(buscaCidade);
            
            //Inserir o controller da busca de bairros
            buscaCidade.setVisible(true);
            
            if(codigo != 0){
                Cidade cidade = new Cidade();
                cidade = service.CidadeService.carregar(codigo);
                utilities.Utilities.ativa(false, cadastroCidade.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, cadastroCidade.getjPanelDados());
                
                this.cadastroCidade.getjTextFieldId().setText(cidade.getId() + "");
                this.cadastroCidade.getjTextFieldDescricao().setText(cidade.getDescricao()+ "");
                
                this.cadastroCidade.getjComboBoxUf().setSelectedItem(cidade.getUf());
                this.cadastroCidade.getjTextFieldId().setEditable(false);
                
            }

        }
    }

}
