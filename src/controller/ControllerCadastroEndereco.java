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
public class ControllerCadastroEndereco implements ActionListener, FocusListener {

    private CadastroEndereco cadastroEndereco;

    public static int codigo;

    public int idBairro, idCidade;

    public ControllerCadastroEndereco(CadastroEndereco cadastroEndereco) {

        this.cadastroEndereco = cadastroEndereco;

        //Adicionando listerners aos campos e botões
        this.cadastroEndereco.getjButtonNovo().addActionListener(this);
        this.cadastroEndereco.getjButtonSair().addActionListener(this);
        this.cadastroEndereco.getjButtonCancelar().addActionListener(this);
        this.cadastroEndereco.getjButtonSalvar().addActionListener(this);
        this.cadastroEndereco.getjButtonConsultar().addActionListener(this);
        this.cadastroEndereco.getjButtonAdicionarBairro().addActionListener(this);
        this.cadastroEndereco.getjButtonBuscaBairro().addActionListener(this);
        this.cadastroEndereco.getjButtonAdicionarCidade().addActionListener(this);
        this.cadastroEndereco.getjButtonBuscaCidade().addActionListener(this);

        //Adicionando os listeners aos campos de código bairro e cidade
        this.cadastroEndereco.getjTextFieldCodigoBairro().addFocusListener(this);
        this.cadastroEndereco.getjTextFieldCodigoCidade().addFocusListener(this);

        utilities.Utilities.ativa(true, this.cadastroEndereco.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroEndereco.getjPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroEndereco.getjButtonNovo()) {
            utilities.Utilities.ativa(false, this.cadastroEndereco.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroEndereco.getjPanelDados());

            this.cadastroEndereco.getjTextFieldId().setEditable(false); //Desligando o ID no braço (PROVISÓRIO)
            this.cadastroEndereco.getjTextFieldDescricaoBairro().setEditable(false);//Desligando descriçao bairro
            this.cadastroEndereco.getjTextFieldDescricaoCidade().setEditable(false); //desligando descrição cidade
            this.cadastroEndereco.getjTextFieldId().setText(Integer.toString(Dao.ClasseDados.enderecos.size()+1));//Trazendo próximo id
            this.cadastroEndereco.getjFormattedTextFieldCep().requestFocus(); //Curso começa já no cep

        } else if (e.getSource() == this.cadastroEndereco.getjButtonSair()) {
            this.cadastroEndereco.dispose(); //Ação botão sair

        } else if (e.getSource() == this.cadastroEndereco.getjButtonCancelar()) {
            //Ação botão cancelar
            utilities.Utilities.ativa(true, this.cadastroEndereco.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroEndereco.getjPanelDados());

        } else if (e.getSource() == this.cadastroEndereco.getjButtonSalvar()) {
            //Ação botão salvar
            Endereco endereco = new Endereco();
            endereco.setId(Dao.ClasseDados.enderecos.size() + 1);

            endereco.setCep(this.cadastroEndereco.getjFormattedTextFieldCep().getText());
            if (this.cadastroEndereco.getjFormattedTextFieldCep().getText().equalsIgnoreCase("")) {
                endereco.setCep("Não informado");
            }
            endereco.setLogradouro(this.cadastroEndereco.getjTextFieldLogradouro().getText());

            if (this.cadastroEndereco.getjTextFieldLogradouro().getText().equalsIgnoreCase("")) {
                endereco.setLogradouro("Não informado");
            }
            endereco.setStatus(this.cadastroEndereco.getjCheckBoxStatus().isSelected());

            idBairro = Integer.parseInt(this.cadastroEndereco.getjTextFieldCodigoBairro().getText());
            Bairro bairro = getBairroById(idBairro);
            if (bairro != null) {
                endereco.setBairro(bairro);
                this.cadastroEndereco.getjTextFieldDescricaoBairro().setText(bairro.getDescricao());
            } else {
                endereco.setBairro(null);
                this.cadastroEndereco.getjTextFieldDescricaoBairro().setText("");
            }

            idCidade = Integer.parseInt(this.cadastroEndereco.getjTextFieldCodigoCidade().getText());
            Cidade cidade = getCidadeById(idCidade);
            if (cidade != null) {
                endereco.setCidade(cidade);
                this.cadastroEndereco.getjTextFieldDescricaoCidade().setText(cidade.getDescricao());
            } else {
                endereco.setCidade(null);
                this.cadastroEndereco.getjTextFieldDescricaoCidade().setText("");
            }

            if (Dao.ClasseDados.enderecos.size() < Integer.parseInt(this.cadastroEndereco.getjTextFieldId().getText())) {
                Dao.ClasseDados.enderecos.add(endereco);
            } else {
                int id = Integer.parseInt(this.cadastroEndereco.getjTextFieldId().getText());

                for (Endereco enderecoAtual : Dao.ClasseDados.enderecos) {
                    if (enderecoAtual.getId() == id) {
                        enderecoAtual.setCep(this.cadastroEndereco.getjFormattedTextFieldCep().getText());
                        enderecoAtual.setLogradouro(this.cadastroEndereco.getjTextFieldLogradouro().getText());
                        enderecoAtual.setStatus(this.cadastroEndereco.getjCheckBoxStatus().isSelected());
                        enderecoAtual.setBairro(endereco.getBairro());
                        enderecoAtual.setCidade(endereco.getCidade());

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
            buscarBairro();

        } else if (e.getSource() == this.cadastroEndereco.getjButtonBuscaCidade()) {
            buscaCidade();

        }

    }

    private Bairro getBairroById(int idBairro) {
        for (Bairro bairroAtual : Dao.ClasseDados.bairros) {
            if (bairroAtual.getId() == idBairro) {
                return bairroAtual;
            }
        }
        return null;
    }

    private Cidade getCidadeById(int idCidade) {
        for (Cidade cidadeAtual : Dao.ClasseDados.cidades) {
            if (cidadeAtual.getId() == idCidade) {
                return cidadeAtual;
            }
        }
        return null;
    }

    @Override
    public void focusGained(FocusEvent e) {
        //Método do FocusListener para quando o campo ganha foco
        // Não é necessário implementar nada aqui
        
    }
    
    

    @Override
    public void focusLost(FocusEvent e) {
   
        if (e.getSource() == this.cadastroEndereco.getjTextFieldCodigoBairro()) {
            // Campo TextFieldCodigoBairro perdeu o foco
            String codigoBairro = this.cadastroEndereco.getjTextFieldCodigoBairro().getText().trim();
            if (codigoBairro.isEmpty()) {
                this.cadastroEndereco.getjTextFieldDescricaoBairro().setText("");
            } else {
                int idBairro = Integer.parseInt(codigoBairro);
                Bairro bairro = getBairroById(idBairro);

                if (bairro != null) {
                    this.cadastroEndereco.getjTextFieldDescricaoBairro().setText(bairro.getDescricao());
                } else {
                    this.cadastroEndereco.getjTextFieldDescricaoBairro().setText("");
                }
            }
        } else if (e.getSource() == this.cadastroEndereco.getjTextFieldCodigoCidade()) {
            String codigoCidade = this.cadastroEndereco.getjTextFieldCodigoCidade().getText().trim();
            if(codigoCidade.isEmpty()){
                this.cadastroEndereco.getjTextFieldDescricaoCidade().setText("");
            }else{
                int idCidade = Integer.parseInt(codigoCidade);
                Cidade cidade = getCidadeById(idCidade);
                
                if(cidade != null){
                    this.cadastroEndereco.getjTextFieldDescricaoCidade().setText(cidade.getDescricao());
                }else{
                    this.cadastroEndereco.getjTextFieldDescricaoCidade().setText("");
                }
                
            }
        }
    }

    private void buscarBairro() {
        BuscaBairro buscaBairro = new BuscaBairro(null, true);
        ControllerBuscaBairro controllerBuscaBairro = new ControllerBuscaBairro(buscaBairro);
        buscaBairro.setVisible(true);

        // Verificar se um bairro foi selecionado na tela de busca
        if (ControllerCadastroBairro.codigo != 0) {
            Bairro bairro = getBairroById(ControllerCadastroBairro.codigo);
            if (bairro != null) {
                this.cadastroEndereco.getjTextFieldCodigoBairro().setText(String.valueOf(bairro.getId()));
                this.cadastroEndereco.getjTextFieldDescricaoBairro().setText(bairro.getDescricao());
            }
        }
    }

    private void buscaCidade() {
        BuscaCidade buscaCidade = new BuscaCidade(null, true);
        ControllerBuscaCidade controllerBuscaCidade = new ControllerBuscaCidade(buscaCidade);
        buscaCidade.setVisible(true);

        // Verificar se um bairro foi selecionado na tela de busca
        if (ControllerCadastroCidade.codigo != 0) {
            Cidade cidade = getCidadeById(ControllerCadastroCidade.codigo);
            if (cidade != null) {
                this.cadastroEndereco.getjTextFieldCodigoCidade().setText(String.valueOf(cidade.getId()));
                this.cadastroEndereco.getjTextFieldDescricaoCidade().setText(cidade.getDescricao());
            }
        }
    }

}
