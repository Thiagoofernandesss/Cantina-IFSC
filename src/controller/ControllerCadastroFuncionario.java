/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import model.bo.Endereco;
import model.bo.Funcionario;
import service.EnderecoService;
import view.BuscaEndereco;
import view.BuscaFuncionario;
import view.CadastroEndereco;
import view.CadastroFuncionario;

/**
 *
 * @author Thiago and Gabrieli
 */
public class ControllerCadastroFuncionario implements ActionListener, FocusListener {

    CadastroFuncionario cadastroFuncionario;
    public static int codigo;


    public ControllerCadastroFuncionario(CadastroFuncionario cadastroFuncionario) {
        this.cadastroFuncionario = cadastroFuncionario;

        this.cadastroFuncionario.getjButtonNovo().addActionListener(this);
        this.cadastroFuncionario.getjButtonSair().addActionListener(this);
        this.cadastroFuncionario.getjButtonCancelar().addActionListener(this);
        this.cadastroFuncionario.getjButtonSalvar().addActionListener(this);
        this.cadastroFuncionario.getjButtonConsultar().addActionListener(this);
        
        this.cadastroFuncionario.getjButtonAdicionarCep().addActionListener(this);
        this.cadastroFuncionario.getjButtonPesquisarCep().addActionListener(this);
        
        List<Endereco> listaEnderecos = new ArrayList<>();
        
        listaEnderecos = service.EnderecoService.carregar();
        
        //Adicionando os listeners ao campo de cep
        this.cadastroFuncionario.getjFormattedTextFieldCEP().addFocusListener(this);
        
        // Habilitando os botões e desabilitando os campos do formulário
        utilities.Utilities.ativa(true, this.cadastroFuncionario.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroFuncionario.getjPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == this.cadastroFuncionario.getjButtonNovo()) {
            utilities.Utilities.ativa(false, this.cadastroFuncionario.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroFuncionario.getjPanelDados());
             
            
            this.cadastroFuncionario.getjTextFieldID().setEditable(false);
            
            //Desligando os campos de descrições da cidade, do bairro e logradouro
            this.cadastroFuncionario.getjTextFieldCidade().setEditable(false);
            this.cadastroFuncionario.getjTextFieldBairro().setEditable(false);
            this.cadastroFuncionario.getjTextFieldLogradouro().setEditable(false);
            this.cadastroFuncionario.getjTextFieldNome().requestFocus();//Cursor  começando no nome

        } else if (e.getSource() == this.cadastroFuncionario.getjButtonSair()) {
            this.cadastroFuncionario.dispose();

        } else if (e.getSource() == this.cadastroFuncionario.getjButtonCancelar()) {
            utilities.Utilities.ativa(true, this.cadastroFuncionario.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroFuncionario.getjPanelDados());

        } else if (e.getSource() == this.cadastroFuncionario.getjButtonSalvar()) {
            Funcionario funcionario = new Funcionario();
             
            funcionario.setNome(this.cadastroFuncionario.getjTextFieldNome().getText());
            funcionario.setFone1(this.cadastroFuncionario.getjFormattedTextFieldFone1().getText());
            funcionario.setFone2(this.cadastroFuncionario.getjFormattedTextFieldFone2().getText());
            funcionario.setEmail(this.cadastroFuncionario.getjTextFieldEmail().getText());
            funcionario.setStatus(this.cadastroFuncionario.getjCheckBoxStatus().isSelected());
            funcionario.setCpf(this.cadastroFuncionario.getjFormattedTextFieldCPF().getText());
            String cpfString = this.cadastroFuncionario.getjFormattedTextFieldCPF().getText();
            funcionario.setRg(this.cadastroFuncionario.getjFormattedTextFieldRg().getText());
            funcionario.setComplementoEndereco(this.cadastroFuncionario.getjTextFieldComplementoEndereco().getText());
            funcionario.setUsuario(this.cadastroFuncionario.getjTextFieldUsuario().getText());
            funcionario.setSenha(this.cadastroFuncionario.getjPasswordFieldSenhaUsuario().getText());
            
            Endereco endereco = EnderecoService.carregarCEP(this.cadastroFuncionario.getjFormattedTextFieldCEP().getText());
            
            funcionario.setEndereco(endereco);
            
            if (codigo == 0) {
                service.FuncionarioService.adicionar(funcionario);
                utilities.Utilities.ativa(true, this.cadastroFuncionario.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(false, this.cadastroFuncionario.getjPanelDados());

                this.cadastroFuncionario.getjTextFieldID().setEditable(false); //Desligando id no braço, provisório

                //Desligando os campos de descrições da cidade, do bairro e logradouro
                this.cadastroFuncionario.getjTextFieldCidade().setEditable(false);
                this.cadastroFuncionario.getjTextFieldBairro().setEditable(false);
                this.cadastroFuncionario.getjTextFieldLogradouro().setEditable(false);
            } else {
                funcionario.setId(codigo);

                service.FuncionarioService.atualizar(funcionario);
                utilities.Utilities.ativa(true, this.cadastroFuncionario.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(false, this.cadastroFuncionario.getjPanelDados());

                this.cadastroFuncionario.getjTextFieldID().setEditable(false); //Desligando id no braço, provisório

                //Desligando os campos de descrições da cidade, do bairro e logradouro
                this.cadastroFuncionario.getjTextFieldCidade().setEditable(false);
                this.cadastroFuncionario.getjTextFieldBairro().setEditable(false);
                this.cadastroFuncionario.getjTextFieldLogradouro().setEditable(false);

            }
            
        } else if (e.getSource() == this.cadastroFuncionario.getjButtonConsultar()) {
            codigo = 0;
            BuscaFuncionario buscaFuncionario = new BuscaFuncionario(null, true);
            ControllerBuscaFuncionario controllerBuscaFuncionario = new ControllerBuscaFuncionario(buscaFuncionario);
            buscaFuncionario.setVisible(true);
            
             if (codigo != 0) {

                utilities.Utilities.ativa(false, cadastroFuncionario.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, cadastroFuncionario.getjPanelDados());

                Funcionario funcionario = new Funcionario();
                funcionario = service.FuncionarioService.carregar(codigo);

                this.cadastroFuncionario.getjTextFieldID().setText(funcionario.getId() + "");
                this.cadastroFuncionario.getjTextFieldNome().setText(funcionario.getNome() + "");
                this.cadastroFuncionario.getjFormattedTextFieldCPF().setText(funcionario.getCpf() + "");
                this.cadastroFuncionario.getjFormattedTextFieldRg().setText(funcionario.getRg() + "");
                this.cadastroFuncionario.getjTextFieldEmail().setText(funcionario.getEmail() + "");
                this.cadastroFuncionario.getjFormattedTextFieldFone1().setText(funcionario.getFone1() + "");
                this.cadastroFuncionario.getjFormattedTextFieldFone2().setText(funcionario.getFone2() + "");
                this.cadastroFuncionario.getjFormattedTextFieldCEP().setText(funcionario.getEndereco().getCep() + "");
                this.cadastroFuncionario.getjTextFieldUsuario().setText(funcionario.getUsuario() + "");
                this.cadastroFuncionario.getjPasswordFieldSenhaUsuario().setText(funcionario.getSenha() + "");


                this.cadastroFuncionario.getjTextFieldLogradouro().setText(funcionario.getEndereco().getLogradouro() + "");
                this.cadastroFuncionario.getjTextFieldBairro().setText(funcionario.getEndereco().getBairro().getDescricao() + "");
                this.cadastroFuncionario.getjTextFieldCidade().setText(funcionario.getEndereco().getCidade().getDescricao() + "");
                this.cadastroFuncionario.getjTextFieldComplementoEndereco().setText(funcionario.getComplementoEndereco() + "");

                if (funcionario.getStatus() == 'I') {
                    this.cadastroFuncionario.getjCheckBoxStatus().setSelected(true);
                }

                this.cadastroFuncionario.getjTextFieldID().setEditable(false);
                //Desligando os campos de descrições da cidade, do bairro e logradouro
                this.cadastroFuncionario.getjTextFieldCidade().setEditable(false);
                this.cadastroFuncionario.getjTextFieldBairro().setEditable(false);
                this.cadastroFuncionario.getjTextFieldLogradouro().setEditable(false);
            }
             
        } else if (e.getSource() == this.cadastroFuncionario.getjButtonPesquisarCep()){
              buscarCep();
                
        } else if (e.getSource() == this.cadastroFuncionario.getjButtonAdicionarCep()){
             CadastroEndereco cadastroEndereco = new CadastroEndereco();
             ControllerCadastroEndereco controllerCadastroEndereco = new ControllerCadastroEndereco(cadastroEndereco);
             cadastroEndereco.setVisible(true);
        }
    }

    
    public Endereco getEndByCep(String cep) {
        Endereco teste = new Endereco();
        for (Endereco enderecoAtual : service.EnderecoService.carregar()) {
            if (enderecoAtual.getCep().equals(cep)) {
                teste= enderecoAtual;
            }
        }
        return teste;
    }

    public Endereco getEndById(int idEnd) {
        for (Endereco enderecoAtual : service.EnderecoService.carregar()) {
            if (enderecoAtual.getId() == idEnd) {
                return enderecoAtual;
            }

        }
        return null;
    }
    
    
    @Override
    public void focusGained(FocusEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == this.cadastroFuncionario.getjFormattedTextFieldCEP()) {
            String codigoCEP = this.cadastroFuncionario.getjFormattedTextFieldCEP().getText();
            if (codigoCEP.isEmpty()) {
                this.cadastroFuncionario.getjFormattedTextFieldCEP().setText("");
                this.cadastroFuncionario.getjTextFieldCidade().setText("");
                this.cadastroFuncionario.getjTextFieldBairro().setText("");
                this.cadastroFuncionario.getjTextFieldLogradouro().setText("");
            } else {
                Endereco endereco = EnderecoService.carregarCEP(codigoCEP);

                if (endereco != null) {
                    this.cadastroFuncionario.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
                    this.cadastroFuncionario.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
                    this.cadastroFuncionario.getjTextFieldLogradouro().setText(endereco.getLogradouro());
                } else {
                    this.cadastroFuncionario.getjTextFieldCidade().setText("");
                    this.cadastroFuncionario.getjTextFieldBairro().setText("");
                    this.cadastroFuncionario.getjTextFieldLogradouro().setText("");
                    

                }
            }
        }
    }
    private void buscarCep() {
        BuscaEndereco buscaEndereco = new BuscaEndereco(null, true);
        ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(buscaEndereco);
        buscaEndereco.setVisible(true);

        if (ControllerCadastroEndereco.codigo != 0) {
            Endereco endereco = getEndById(ControllerCadastroEndereco.codigo);
            this.cadastroFuncionario.getjFormattedTextFieldCEP().setText(endereco.getCep());
            this.cadastroFuncionario.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
            this.cadastroFuncionario.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
            this.cadastroFuncionario.getjTextFieldLogradouro().setText(endereco.getLogradouro());
        }
    }
}
