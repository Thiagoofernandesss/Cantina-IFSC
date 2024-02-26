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
import model.bo.Fornecedor;
import service.EnderecoService;
import utilities.Utilities;
import view.BuscaEndereco;
import view.BuscaFornecedor;
import view.CadastroEndereco;
import view.CadastroFornecedor;

/**
 *
 * @author Thiago
 */
public class ControllerCadastroFornecedor implements ActionListener, FocusListener {

    private CadastroFornecedor cadastroFornecedor;
    public static int codigo;
    
    FocusListener focusCep = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnCepTextFieldGray(cadastroFornecedor.getjFormattedTextFieldCep());
            
        }

        @Override
        public void focusLost(FocusEvent e) {
            Utilities.turnCepTextFieldRed(cadastroFornecedor.getjFormattedTextFieldCep());
        }
    };
    
    FocusListener focusMatricula = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnTextFieldGray(cadastroFornecedor.getjFormattedTextFieldInsEstadual());
        }

        @Override
        public void focusLost(FocusEvent e) {
            Utilities.turnTextFieldRed(cadastroFornecedor.getjFormattedTextFieldInsEstadual());
        }
    };
    
    FocusListener focusCpf = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnCepTextFieldGray(cadastroFornecedor.getjFormattedTextFieldCnpj());
        }

        @Override
        public void focusLost(FocusEvent e) {
            Utilities.turnCepTextFieldRed(cadastroFornecedor.getjFormattedTextFieldCnpj());
        }
    };
  

    public ControllerCadastroFornecedor(CadastroFornecedor cadastroFornecedor) {
        this.cadastroFornecedor = cadastroFornecedor;

        this.cadastroFornecedor.getjButtonNovo().addActionListener(this);
        this.cadastroFornecedor.getjButtonSair().addActionListener(this);
        this.cadastroFornecedor.getjButtonCancelar().addActionListener(this);
        this.cadastroFornecedor.getjButtonSalvar().addActionListener(this);
        this.cadastroFornecedor.getjButtonConsultar().addActionListener(this);
        
        this.cadastroFornecedor.getjFormattedTextFieldCnpj().addFocusListener(focusCpf);
        this.cadastroFornecedor.getjFormattedTextFieldCep().addFocusListener(focusCep);
        this.cadastroFornecedor.getjFormattedTextFieldInsEstadual().addFocusListener(focusMatricula);

        this.cadastroFornecedor.getjButtonPesquisarCep().addActionListener(this);
        this.cadastroFornecedor.getjButtonAdcionarCep().addActionListener(this);

        List<Endereco> listaEnderecos = new ArrayList<>();

        listaEnderecos = service.EnderecoService.carregar();

        //Adicionando os listeners ao campo de cep
        this.cadastroFornecedor.getjFormattedTextFieldCep().addFocusListener(this);

        // Habilitando os botões e desabilitando os campos do formulário
        utilities.Utilities.ativa(true, this.cadastroFornecedor.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroFornecedor.getjPanelDados());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroFornecedor.getjButtonNovo()) {
            utilities.Utilities.ativa(false, this.cadastroFornecedor.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroFornecedor.getjPanelDados());
            
            this.cadastroFornecedor.getjTextFieldId().setEditable(false);//Desligando id no braço, provisório
            
            //Desligando os campos de descrições da cidade, do bairro e logradouro
            this.cadastroFornecedor.getjTextFieldCidade().setEditable(false);
            this.cadastroFornecedor.getjTextFieldBairro().setEditable(false);
            this.cadastroFornecedor.getjTextFieldLogradouro().setEditable(false);
            this.cadastroFornecedor.getjTextFieldRazaoSocial().requestFocus();//Cursor começando na razao social

        } else if (e.getSource() == this.cadastroFornecedor.getjButtonSair()) {
            this.cadastroFornecedor.dispose();//Ação botão sair

        } else if (e.getSource() == this.cadastroFornecedor.getjButtonCancelar()) {
            utilities.Utilities.ativa(true, this.cadastroFornecedor.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroFornecedor.getjPanelDados());

        } else if (e.getSource() == this.cadastroFornecedor.getjButtonSalvar()) {
            Fornecedor fornecedor = new Fornecedor();
            
            fornecedor.setNome(this.cadastroFornecedor.getjTextFieldNomeFantasia().getText());
            fornecedor.setFone1(this.cadastroFornecedor.getjFormattedTextFieldFone1().getText());
            fornecedor.setFone2(this.cadastroFornecedor.getjFormattedTextFieldFone2().getText());
            fornecedor.setEmail(this.cadastroFornecedor.getjTextFieldEmail().getText());
            fornecedor.setStatus(this.cadastroFornecedor.getjCheckBoxInativo().isSelected());
            fornecedor.setCnpj(this.cadastroFornecedor.getjFormattedTextFieldCnpj().getText());
            fornecedor.setComplementoEndereco(this.cadastroFornecedor.getjTextFieldComplementoEndereco().getText());
            fornecedor.setComplementoEndereco(this.cadastroFornecedor.getjTextFieldComplementoEndereco().getText());
            fornecedor.setInscricaoEstadual(this.cadastroFornecedor.getjFormattedTextFieldInsEstadual().getText());
            fornecedor.setRazaoSocial(this.cadastroFornecedor.getjTextFieldRazaoSocial().getText());
            
            
            Endereco endereco = EnderecoService.carregarCEP(this.cadastroFornecedor.getjFormattedTextFieldCep().getText());
            
            fornecedor.setEndereco(endereco);
            
            if (codigo ==0){
                service.FornecedorService.adicionar(fornecedor);
                
                utilities.Utilities.ativa(true, this.cadastroFornecedor.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(false, this.cadastroFornecedor.getjPanelDados());

                this.cadastroFornecedor.getjTextFieldId().setEditable(false); //Desligando id no braço, provisório

                //Desligando os campos de descrições da cidade, do bairro e logradouro
                this.cadastroFornecedor.getjTextFieldCidade().setEditable(false);
                this.cadastroFornecedor.getjTextFieldBairro().setEditable(false);
                this.cadastroFornecedor.getjTextFieldLogradouro().setEditable(false);
            }else{
                fornecedor.setId(codigo);
                
                service.FornecedorService.atualizar(fornecedor);                
                utilities.Utilities.ativa(true, this.cadastroFornecedor.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(false, this.cadastroFornecedor.getjPanelDados());

                this.cadastroFornecedor.getjTextFieldId().setEditable(false); //Desligando id no braço, provisório

                //Desligando os campos de descrições da cidade, do bairro e logradouro
                this.cadastroFornecedor.getjTextFieldCidade().setEditable(false);
                this.cadastroFornecedor.getjTextFieldBairro().setEditable(false);
                this.cadastroFornecedor.getjTextFieldLogradouro().setEditable(false);
                
            }

        } else if (e.getSource() == this.cadastroFornecedor.getjButtonConsultar()) {
            codigo = 0;
            
            BuscaFornecedor buscaFornecedor = new BuscaFornecedor(null, true);
            ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(buscaFornecedor);
            buscaFornecedor.setVisible(true);
            
            if(codigo !=0){
            
                utilities.Utilities.ativa(false, cadastroFornecedor.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, cadastroFornecedor.getjPanelDados());
                
                Fornecedor fornecedor = new Fornecedor();
                fornecedor = service.FornecedorService.carregar(codigo);
                
                this.cadastroFornecedor.getjTextFieldId().setText(fornecedor.getId() +"");
                this.cadastroFornecedor.getjTextFieldNomeFantasia().setText(fornecedor.getNome() +"");
                this.cadastroFornecedor.getjTextFieldRazaoSocial().setText(fornecedor.getRazaoSocial() +"");
                this.cadastroFornecedor.getjFormattedTextFieldFone1().setText(fornecedor.getFone1() +"");
                this.cadastroFornecedor.getjFormattedTextFieldFone2().setText(fornecedor.getFone2() +"");
                this.cadastroFornecedor.getjFormattedTextFieldCep().setText(fornecedor.getEndereco().getCep() + "");
                this.cadastroFornecedor.getjTextFieldEmail().setText(fornecedor.getEmail() + "");
                this.cadastroFornecedor.getjFormattedTextFieldCnpj().setText(fornecedor.getCnpj() + "");
                this.cadastroFornecedor.getjFormattedTextFieldInsEstadual().setText(fornecedor.getInscricaoEstadual() + "");
                
                this.cadastroFornecedor.getjTextFieldLogradouro().setText(fornecedor.getEndereco().getLogradouro() +"");
                this.cadastroFornecedor.getjTextFieldBairro().setText(fornecedor.getEndereco().getBairro().getDescricao()+"");
                this.cadastroFornecedor.getjTextFieldCidade().setText(fornecedor.getEndereco().getCidade().getDescricao());
                this.cadastroFornecedor.getjTextFieldComplementoEndereco().setText(fornecedor.getComplementoEndereco()+ "");

                if(fornecedor.getStatus() =='I'){
                    this.cadastroFornecedor.getjCheckBoxInativo().setSelected(true);
                }
                
                this.cadastroFornecedor.getjTextFieldId().setEditable(false);
                //Desligando os campos de descrições da cidade, do bairro e logradouro
                this.cadastroFornecedor.getjTextFieldCidade().setEditable(false);
                this.cadastroFornecedor.getjTextFieldBairro().setEditable(false);
                this.cadastroFornecedor.getjTextFieldLogradouro().setEditable(false);
                
                
                
            }

        } else if (e.getSource() == this.cadastroFornecedor.getjButtonPesquisarCep()) {
            buscarCep();

        } else if (e.getSource() == this.cadastroFornecedor.getjButtonAdcionarCep()) {
            CadastroEndereco cadastroEndereco = new CadastroEndereco();
            ControllerCadastroEndereco controllerCadastroEndereco = new ControllerCadastroEndereco(cadastroEndereco);
            cadastroEndereco.setVisible(true);
        }
    }
    
    private Endereco getEndByCep(String cep) {
        Endereco teste = new Endereco();
        for (Endereco enderecoAtual : service.EnderecoService.carregar()) {
            if (enderecoAtual.getCep().equals(cep)) {
                teste= enderecoAtual;
            }
        }
        return teste;
    }

    private Endereco getEndById(int idEnd) {
        for (Endereco enderecoAtual : service.EnderecoService.carregar()) {
            if (enderecoAtual.getId() == idEnd) {
                return enderecoAtual;
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
        if (e.getSource() == this.cadastroFornecedor.getjFormattedTextFieldCep()) {
            String codigoCEP = this.cadastroFornecedor.getjFormattedTextFieldCep().getText();

            if (codigoCEP.isEmpty()) {
                this.cadastroFornecedor.getjFormattedTextFieldCep().setText("");
                this.cadastroFornecedor.getjTextFieldCidade().setText("");
                this.cadastroFornecedor.getjTextFieldBairro().setText("");
                this.cadastroFornecedor.getjTextFieldLogradouro().setText("");
            } else {
                Endereco endereco = EnderecoService.carregarCEP(codigoCEP);

                if (endereco != null) {
                    this.cadastroFornecedor.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
                    this.cadastroFornecedor.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
                    this.cadastroFornecedor.getjTextFieldLogradouro().setText(endereco.getLogradouro());
                } else {
                    this.cadastroFornecedor.getjTextFieldCidade().setText("");
                    this.cadastroFornecedor.getjTextFieldBairro().setText("");
                    this.cadastroFornecedor.getjTextFieldLogradouro().setText("");

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
            this.cadastroFornecedor.getjFormattedTextFieldCep().setText(endereco.getCep());
            this.cadastroFornecedor.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
            this.cadastroFornecedor.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
            this.cadastroFornecedor.getjTextFieldLogradouro().setText(endereco.getLogradouro());
        }
    }

}
