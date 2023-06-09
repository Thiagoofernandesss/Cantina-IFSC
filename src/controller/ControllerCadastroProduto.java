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
    public static int codigo;
    
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
            //Deseligando o ID no braço, PROVISÓRIO
            this.cadastroProduto.getjTextFieldId().setEditable(false);
            //Trazendo proximo id
            this.cadastroProduto.getjTextFieldId().setText(Integer.toString(Dao.ClasseDados.produtos.size()+1));

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
            if(Dao.ClasseDados.produtos.size() < Integer.parseInt(this.cadastroProduto.getjTextFieldId().getText())){
                Dao.ClasseDados.produtos.add(produto);
            
            } else{
                int id = Integer.parseInt(this.cadastroProduto.getjTextFieldId().getText());
                
                for (Produto produtoAtual : Dao.ClasseDados.produtos) {
                    if(produtoAtual.getId() == id){
                        produtoAtual.setDescricao(this.cadastroProduto.getjTextFieldDescricao().getText());
                        produtoAtual.setCodigoBarra(this.cadastroProduto.getjTextFieldCodigoBarras().getText());
                        produtoAtual.setStatus(this.cadastroProduto.getjCheckBoxStatus().isSelected());
                        break;
                    }
                   
                }
            
            }
            
            
            
            utilities.Utilities.ativa(true, cadastroProduto.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, cadastroProduto.getjPanelDados());

        } else if (e.getSource() == this.cadastroProduto.getjButtonConsultar()) {
            codigo = 0;
            
            BuscaProduto buscaProduto = new BuscaProduto(null, true);
            ControllerBuscaProduto controllerBuscaProduto = new ControllerBuscaProduto(buscaProduto);
            
            //Inserir o controller da busca de produto
            buscaProduto.setVisible(true);
            
            if(codigo != 0){
                Produto produto = new Produto();
                produto = Dao.ClasseDados.produtos.get(codigo - 1);
                
                utilities.Utilities.ativa(false, cadastroProduto.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, cadastroProduto.getjPanelDados());
                
                this.cadastroProduto.getjTextFieldId().setText(produto.getId() + "");
                this.cadastroProduto.getjTextFieldDescricao().setText(produto.getDescricao() + "");
                this.cadastroProduto.getjTextFieldCodigoBarras().setText(produto.getCodigoBarra() + "");
                
                if(produto.getStatus() == 'I'){
                    this.cadastroProduto.getjCheckBoxStatus().setSelected(true);
                }else{
                    this.cadastroProduto.getjCheckBoxStatus().setSelected(false);
                }
                
                this.cadastroProduto.getjTextFieldId().setEditable(false);
            }

        }
    }
    
    
}
