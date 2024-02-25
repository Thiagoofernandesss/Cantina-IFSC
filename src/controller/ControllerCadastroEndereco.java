/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Dao.ClasseDados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import utilities.Utilities;
import view.BuscaBairro;
import view.BuscaCidade;
import view.BuscaEndereco;
import view.CadastroBairro;
import view.CadastroCidade;
import view.CadastroEndereco;

/**
 *
 * @author Thiago
 */
public class ControllerCadastroEndereco implements ActionListener {

    private CadastroEndereco cadastroEndereco;
    public static int codigo;

    public ControllerCadastroEndereco(CadastroEndereco cadastroEndereco) {

        this.cadastroEndereco = cadastroEndereco;

        //Adicionando listerners aos campos e botões
        this.cadastroEndereco.getjButtonNovo().addActionListener(this);
        this.cadastroEndereco.getjButtonSair().addActionListener(this);
        this.cadastroEndereco.getjButtonCancelar().addActionListener(this);
        this.cadastroEndereco.getjButtonSalvar().addActionListener(this);
        this.cadastroEndereco.getjButtonConsultar().addActionListener(this);
        
        this.cadastroEndereco.getjTextFieldLogradouro().addFocusListener(focusLogradouro);
        this.cadastroEndereco.getjFormattedTextFieldCep().addFocusListener(focusCep);

        List<Cidade> listaCidades = new ArrayList<Cidade>();
        List<Bairro> listaBairros = new ArrayList<Bairro>();

        listaCidades = service.CidadeService.carregar();
        listaBairros = service.BairroService.carregar();

        this.cadastroEndereco.getjComboBoxCidade().removeAll();
        this.cadastroEndereco.getjComboBoxBairro().removeAll();

        for (Cidade cidadeAtual : listaCidades) {
            this.cadastroEndereco.getjComboBoxCidade().addItem(cidadeAtual.getDescricao());

        }

        for (Bairro bairroAtual : listaBairros) {
            this.cadastroEndereco.getjComboBoxBairro().addItem(bairroAtual.getDescricao());
        }

        utilities.Utilities.ativa(true, this.cadastroEndereco.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroEndereco.getjPanelDados());
    }
    
    FocusListener focusLogradouro = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            
            Utilities.turnTextFieldGray(cadastroEndereco.getjTextFieldLogradouro());  
        }

        @Override
        public void focusLost(FocusEvent e) {
            
            Utilities.turnTextFieldRed(cadastroEndereco.getjTextFieldLogradouro());
        }
    };
    FocusListener focusCep = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            
            Utilities.turnCepTextFieldGray(cadastroEndereco.getjFormattedTextFieldCep());
        }

        @Override
        public void focusLost(FocusEvent e) {
            
            Utilities.turnCepTextFieldRed(cadastroEndereco.getjFormattedTextFieldCep());
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroEndereco.getjButtonNovo()) {
            utilities.Utilities.ativa(false, this.cadastroEndereco.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroEndereco.getjPanelDados());

            this.cadastroEndereco.getjTextFieldId().setEnabled(false);

        } else if (e.getSource() == this.cadastroEndereco.getjButtonSair()) {
            this.cadastroEndereco.dispose(); //Ação botão sair

        } else if (e.getSource() == this.cadastroEndereco.getjButtonCancelar()) {
            //Ação botão cancelar
            utilities.Utilities.ativa(true, this.cadastroEndereco.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroEndereco.getjPanelDados());
            utilities.Utilities.turnCepTextFieldGray(this.cadastroEndereco.getjFormattedTextFieldCep());
            utilities.Utilities.turnTextFieldGray(this.cadastroEndereco.getjTextFieldLogradouro());
        } else if (e.getSource() == this.cadastroEndereco.getjButtonSalvar()) {
            //Ação botão salvar
            Endereco endereco = new Endereco();

            endereco.setLogradouro(this.cadastroEndereco.getjTextFieldLogradouro().getText());
            endereco.setCep(this.cadastroEndereco.getjFormattedTextFieldCep().getText().trim());
            endereco.setStatus(this.cadastroEndereco.getjCheckBoxStatus().isSelected());

            
            endereco.setBairro(service.BairroService.carregar("" + this.cadastroEndereco.getjComboBoxBairro().getSelectedItem()).get(0));
            endereco.setCidade(service.CidadeService.carregar("descricao", this.cadastroEndereco.getjComboBoxCidade().getSelectedItem() + "").get(0));

            if (codigo == 0) {
                service.EnderecoService.adicionar(endereco);
                utilities.Utilities.ativa(true, this.cadastroEndereco.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(false, this.cadastroEndereco.getjPanelDados());

                this.cadastroEndereco.getjTextFieldId().setEditable(false);

            } else {
                endereco.setId(codigo);

                service.EnderecoService.atualizar(endereco);
                utilities.Utilities.ativa(true, this.cadastroEndereco.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(false, this.cadastroEndereco.getjPanelDados());
                utilities.Utilities.turnCepTextFieldGray(this.cadastroEndereco.getjFormattedTextFieldCep());
                utilities.Utilities.turnTextFieldGray(this.cadastroEndereco.getjTextFieldLogradouro());
                
                this.cadastroEndereco.getjTextFieldId().setEditable(false);

            }

        } else if (e.getSource() == this.cadastroEndereco.getjButtonConsultar()) {
            codigo = 0;

            BuscaEndereco buscaEndereco = new BuscaEndereco(null, true);
            ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(buscaEndereco);
            buscaEndereco.setVisible(true);

            if (codigo != 0) {
                utilities.Utilities.ativa(false, this.cadastroEndereco.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.cadastroEndereco.getjPanelDados());

                Endereco endereco = new Endereco();
                endereco = service.EnderecoService.carregar(codigo);

                this.cadastroEndereco.getjTextFieldId().setText(endereco.getId() + "");
                this.cadastroEndereco.getjTextFieldLogradouro().setText(endereco.getLogradouro());
                this.cadastroEndereco.getjFormattedTextFieldCep().setText(endereco.getCep());

                if (endereco.getStatus() == 'I') {
                    this.cadastroEndereco.getjCheckBoxStatus().setSelected(true);
                }

                this.cadastroEndereco.getjComboBoxBairro().setSelectedItem(endereco.getBairro().getDescricao());
                this.cadastroEndereco.getjComboBoxCidade().setSelectedItem(endereco.getCidade().getDescricao());

                this.cadastroEndereco.getjTextFieldId().setEnabled(false);
                
            utilities.Utilities.turnCepTextFieldGray(this.cadastroEndereco.getjFormattedTextFieldCep());
            utilities.Utilities.turnTextFieldGray(this.cadastroEndereco.getjTextFieldLogradouro());
            }

        }

    }

}
