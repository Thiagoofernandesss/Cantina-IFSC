/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.Produto;
import view.BuscaProduto;
import view.CadastroProduto;


/**
 *
 * @author Thiago
 */
public class ControllerCadastroProduto implements ActionListener{
    
    CadastroProduto cadastroProduto;
    
    public ControllerCadastroProduto(CadastroProduto cadastroProduto) {
        this.cadastroProduto = cadastroProduto;
        
        this.cadastroProduto.getjButtonNovo().addActionListener(this);
        this.cadastroProduto.getjButtonSair().addActionListener(this);
        this.cadastroProduto.getjButtonCancelar().addActionListener(this);
        this.cadastroProduto.getjButtonSalvar().addActionListener(this);
        this.cadastroProduto.getjButtonConsultar().addActionListener(this);
        
        utilities.Utilities.ativa(true, this.cadastroProduto.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroProduto.getjPanelDados());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroProduto.getjButtonNovo()) {
            utilities.Utilities.ativa(false, this.cadastroProduto.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroProduto.getjPanelDados());

        } else if (e.getSource() == this.cadastroProduto.getjButtonSair()) {
            this.cadastroProduto.dispose();

        } else if (e.getSource() == this.cadastroProduto.getjButtonCancelar()) {
            utilities.Utilities.ativa(true, this.cadastroProduto.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroProduto.getjPanelDados());

        } else if (e.getSource() == this.cadastroProduto.getjButtonSalvar()) {
            
            Produto produto = new Produto();
            produto.setId(Dao.ClasseDados.produtos.size()+1);
            produto.setDescricao(this.cadastroProduto.getjTextFieldDescricao().getText());
            produto.setCodigoBarra(this.cadastroProduto.getjTextFieldCodigoBarras().getText());            
            produto.setStatus(this.cadastroProduto.getjCheckBoxStatus().isSelected());
            
            Dao.ClasseDados.produtos.add(produto);
            
            
            utilities.Utilities.ativa(true, cadastroProduto.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, cadastroProduto.getjPanelDados());

        } else if (e.getSource() == this.cadastroProduto.getjButtonConsultar()) {
            BuscaProduto buscaProduto = new BuscaProduto(null, true);
            ControllerBuscaProduto controllerBuscaProduto = new ControllerBuscaProduto(buscaProduto);
            //Inserir o controller da busca de bairros
            buscaProduto.setVisible(true);

        }
    }
    
    
}
