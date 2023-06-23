/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Dao.ClasseDados;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
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

    CadastroEndereco cadastroEndereco;
    public static int codigo;

    public int idBairro, idCidade;

    public ControllerCadastroEndereco(CadastroEndereco cadastroEndereco) {

        this.cadastroEndereco = cadastroEndereco;

        this.cadastroEndereco.getjButtonNovo().addActionListener(this);
        this.cadastroEndereco.getjButtonSair().addActionListener(this);
        this.cadastroEndereco.getjButtonCancelar().addActionListener(this);
        this.cadastroEndereco.getjButtonSalvar().addActionListener(this);
        this.cadastroEndereco.getjButtonConsultar().addActionListener(this);
        this.cadastroEndereco.getjButtonAdicionarBairro().addActionListener(this);
        this.cadastroEndereco.getjButtonBuscaBairro().addActionListener(this);
        this.cadastroEndereco.getjButtonAdicionarCidade().addActionListener(this);
        this.cadastroEndereco.getjButtonBuscaCidade().addActionListener(this);

        utilities.Utilities.ativa(true, this.cadastroEndereco.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroEndereco.getjPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroEndereco.getjButtonNovo()) {
            utilities.Utilities.ativa(false, this.cadastroEndereco.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroEndereco.getjPanelDados());
            //Desligando o ID no braço (PROVISÓRIO)
            this.cadastroEndereco.getjTextFieldId().setEditable(false);

        } else if (e.getSource() == this.cadastroEndereco.getjButtonSair()) {
            this.cadastroEndereco.dispose();

        } else if (e.getSource() == this.cadastroEndereco.getjButtonCancelar()) {
            utilities.Utilities.ativa(true, this.cadastroEndereco.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroEndereco.getjPanelDados());

        } else if (e.getSource() == this.cadastroEndereco.getjButtonSalvar()) {

            Endereco endereco = new Endereco();
            endereco.setId(Dao.ClasseDados.enderecos.size() + 1);
            endereco.setCep(this.cadastroEndereco.getjFormattedTextFieldCep().getText());
            endereco.setLogradouro(this.cadastroEndereco.getjTextFieldLogradouro().getText());
            endereco.setStatus(this.cadastroEndereco.getjCheckBoxStatus().isSelected());

            idBairro = Integer.parseInt(this.cadastroEndereco.getjTextFieldCodigoBairro().getText());

            for (Bairro bairroAtual : Dao.ClasseDados.bairros) {
                if (bairroAtual.getId() == idBairro) {
                    endereco.setBairro(bairroAtual);
                    break;
                }
                break;
            }

            idCidade = Integer.parseInt(this.cadastroEndereco.getjTextFieldCodigoCidade().getText());

            for (Cidade cidadeAtual : Dao.ClasseDados.cidades) {
                if (cidadeAtual.getId() == idCidade) {
                    endereco.setCidade(cidadeAtual);
                    break;
                }
                break;
            }

            if (this.cadastroEndereco.getjTextFieldId().getText().equalsIgnoreCase("")) {
                Dao.ClasseDados.enderecos.add(endereco);
            } else {
                int id = Integer.parseInt(this.cadastroEndereco.getjTextFieldId().getText());

                for (Endereco enderecoAtual : Dao.ClasseDados.enderecos) {
                    if (enderecoAtual.getId() == id) {
                        enderecoAtual.setCep(this.cadastroEndereco.getjFormattedTextFieldCep().getText());
                        enderecoAtual.setLogradouro(this.cadastroEndereco.getjTextFieldLogradouro().getText());
                        enderecoAtual.setStatus(this.cadastroEndereco.getjCheckBoxStatus().isSelected());

                        idBairro = Integer.parseInt(this.cadastroEndereco.getjTextFieldCodigoBairro().getText());

                        for (Bairro bairroAtual : Dao.ClasseDados.bairros) {
                            if (bairroAtual.getId() == idBairro) {
                                enderecoAtual.setBairro(bairroAtual);
                            }
                        }

                        idCidade = Integer.parseInt(this.cadastroEndereco.getjTextFieldCodigoCidade().getText());

                        for (Cidade cidadeAtual : Dao.ClasseDados.cidades) {
                            if (cidadeAtual.getId() == idCidade) {
                                endereco.setCidade(cidadeAtual);
                            }

                        }
                    }

                }

            }

            utilities.Utilities.ativa(true, cadastroEndereco.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, cadastroEndereco.getjPanelDados());

        } else if (e.getSource() == this.cadastroEndereco.getjButtonConsultar()) {
            codigo = 0;

            BuscaEndereco buscaEndereco = new BuscaEndereco(null, true);
            ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(buscaEndereco);

            //Inserir o controller da busca de bairros
            buscaEndereco.setVisible(true);

            if (codigo != 0) {
                Endereco endereco = new Endereco();
                endereco = Dao.ClasseDados.enderecos.get(codigo - 1);

                utilities.Utilities.ativa(false, cadastroEndereco.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, cadastroEndereco.getjPanelDados());

                this.cadastroEndereco.getjTextFieldId().setText(endereco.getId() + "");
                this.cadastroEndereco.getjFormattedTextFieldCep().setText(endereco.getCep() + "");
                this.cadastroEndereco.getjTextFieldLogradouro().setText(endereco.getLogradouro() + "");

                if (endereco.getStatus() == 'I') {
                    this.cadastroEndereco.getjCheckBoxStatus().setSelected(true);
                } else {
                    this.cadastroEndereco.getjCheckBoxStatus().setSelected(false);
                }

                this.cadastroEndereco.getjTextFieldCodigoCidade().setText(String.valueOf(endereco.getCidade().getId()));
                this.cadastroEndereco.getjTextFieldDescricaoCidade().setText(endereco.getCidade().getDescricao() + "");
                this.cadastroEndereco.getjTextFieldCodigoBairro().setText(String.valueOf(endereco.getBairro().getId()));
                this.cadastroEndereco.getjTextFieldDescricaoBairro().setText(endereco.getBairro().getDescricao() + "");

                this.cadastroEndereco.getjTextFieldId().setEditable(false);
            }

        } else if (e.getSource() == this.cadastroEndereco.getjButtonAdicionarBairro()) {
            CadastroBairro cadastroBairro = new CadastroBairro();
            ControllerCadastroBairro controllerCadastroBairro = new ControllerCadastroBairro(cadastroBairro);
            cadastroBairro.setVisible(true);

        } else if (e.getSource() == this.cadastroEndereco.getjButtonAdicionarCidade()) {
            CadastroCidade cadastroCidade = new CadastroCidade();
            ControllerCadastroCidade controllerCadastroCidade = new ControllerCadastroCidade(cadastroCidade);
            cadastroCidade.setVisible(true);
        } else if (e.getSource() == this.cadastroEndereco.getjButtonBuscaBairro()) {
            BuscaBairro buscaBairro = new BuscaBairro(null, true);
            ControllerBuscaBairro controllerBuscaBairro = new ControllerBuscaBairro(buscaBairro);
            buscaBairro.setVisible(true);

        } else if (e.getSource() == this.cadastroEndereco.getjButtonBuscaCidade()) {
            BuscaCidade buscaCidade = new BuscaCidade(null, true);
            ControllerBuscaCidade controllerBuscaCidade = new ControllerBuscaCidade(buscaCidade);
            buscaCidade.setVisible(true);
        }

    }

}
