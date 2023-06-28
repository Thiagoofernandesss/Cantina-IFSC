/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import model.bo.Cliente;
import model.bo.Endereco;
import view.BuscaCliente;
import view.BuscaEndereco;
import view.CadastroCliente;
import view.CadastroEndereco;

/**
 *
 * @author Thiago
 */
public class ControllerCadastroCliente implements ActionListener, FocusListener {

    private CadastroCliente cadastroCliente;
    public static int codigo;

    public String numeroCEP;

    public ControllerCadastroCliente(CadastroCliente cadastroCliente) {
        this.cadastroCliente = cadastroCliente;

        // Adicionando os listeners aos botões
        this.cadastroCliente.getjButtonNovo().addActionListener(this);
        this.cadastroCliente.getjButtonSair().addActionListener(this);
        this.cadastroCliente.getjButtonCancelar().addActionListener(this);
        this.cadastroCliente.getjButtonSalvar().addActionListener(this);
        this.cadastroCliente.getjButtonConsultar().addActionListener(this);
        this.cadastroCliente.getjButtonPesquisarCep().addActionListener(this);
        this.cadastroCliente.getjButtonAdicionarCep().addActionListener(this);

        //Adicionando os listeners ao campo de cep
        this.cadastroCliente.getjFormattedTextFieldCEP().addFocusListener(this);

        // Habilitando os botões e desabilitando os campos do formulário
        utilities.Utilities.ativa(true, this.cadastroCliente.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroCliente.getjPanelDados());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroCliente.getjButtonNovo()) {
            utilities.Utilities.ativa(false, this.cadastroCliente.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroCliente.getjPanelDados());

            this.cadastroCliente.getjTextFieldID().setEditable(false); //Desligando id no braço, provisório

            //Desligando os campos de descrições da cidade, do bairro e logradouro
            this.cadastroCliente.getjTextFieldCidade().setEditable(false);
            this.cadastroCliente.getjTextFieldBairro().setEditable(false);
            this.cadastroCliente.getjTextFieldLogradouro().setEditable(false);
            this.cadastroCliente.getjTextFieldID().setText(Integer.toString(Dao.ClasseDados.clientes.size() + 1));//Trazendo o próximo ID
            this.cadastroCliente.getjTextFieldNome().requestFocus();//Cursor  começando no nome

        } else if (e.getSource() == this.cadastroCliente.getjButtonSair()) {
            this.cadastroCliente.dispose(); //Ação botão sair

        } else if (e.getSource() == this.cadastroCliente.getjButtonCancelar()) {
            //Ações botão cancelar
            utilities.Utilities.ativa(true, this.cadastroCliente.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroCliente.getjPanelDados());

        } else if (e.getSource() == this.cadastroCliente.getjButtonSalvar()) {
            //Ação Botão Salvar
            Cliente cliente = new Cliente();
            cliente.setId(Dao.ClasseDados.clientes.size() + 1);

            cliente.setNome(this.cadastroCliente.getjTextFieldNome().getText());
            if (this.cadastroCliente.getjTextFieldNome().getText().equalsIgnoreCase("")) {
                cliente.setNome("Não Informado");
            }
            cliente.setStatus(this.cadastroCliente.getjCheckBoxStatus().isSelected());
            cliente.setDataNascimento(this.cadastroCliente.getjFormattedTextFieldDataNascimento().getText());
            if (this.cadastroCliente.getjFormattedTextFieldDataNascimento().getText().equalsIgnoreCase("")) {
                cliente.setDataNascimento("00/00/00");
            }
            cliente.setCpf(this.cadastroCliente.getjFormattedTextFieldCPF().getText());
            if (this.cadastroCliente.getjFormattedTextFieldCPF().getText().equalsIgnoreCase("")) {
                cliente.setCpf("");
            }
            cliente.setRg(this.cadastroCliente.getjFormattedTextFieldRg().getText());
            if (this.cadastroCliente.getjFormattedTextFieldRg().getText().equalsIgnoreCase("")) {
                cliente.setRg("");
            }
            cliente.setMatricula(this.cadastroCliente.getjTextFieldMatricula().getText());
            if (this.cadastroCliente.getjTextFieldMatricula().getText().equalsIgnoreCase("")) {
                cliente.setMatricula("Não Informada");
            }
            cliente.setEmail(this.cadastroCliente.getjTextFieldEmail().getText());
            if (this.cadastroCliente.getjTextFieldEmail().getText().equalsIgnoreCase("")) {
                cliente.setEmail("Não Informado");
            }
            cliente.setFone1(this.cadastroCliente.getjFormattedTextFieldFone1().getText());
            if (this.cadastroCliente.getjFormattedTextFieldFone1().getText().equalsIgnoreCase("")) {
                cliente.setFone1("");
            }
            cliente.setFone2(this.cadastroCliente.getjFormattedTextFieldFone2().getText());
            if (this.cadastroCliente.getjFormattedTextFieldFone2().getText().equalsIgnoreCase("")) {
                cliente.setFone2("");
            }
            

            numeroCEP = this.cadastroCliente.getjFormattedTextFieldCEP().getText();
            
            Endereco endereco = buscaIdEndByCep(numeroCEP);
            
            if(endereco != null){
                cliente.setEndereco(endereco);
                this.cadastroCliente.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
                this.cadastroCliente.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
                this.cadastroCliente.getjTextFieldLogradouro().setText(endereco.getLogradouro());
            }
            else{
                cliente.setEndereco(null);
                this.cadastroCliente.getjTextFieldCidade().setText("");
                this.cadastroCliente.getjTextFieldBairro().setText("");
                this.cadastroCliente.getjTextFieldLogradouro().setText("");
            }
            
            /*
            Endereco endereco = getEnderecoByCep(numeroCEP);
            
            if(endereco != null){
                cliente.setEndereco(endereco);
                this.cadastroCliente.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
                this.cadastroCliente.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
                this.cadastroCliente.getjTextFieldLogradouro().setText(endereco.getLogradouro());
            }else{
                cliente.setEndereco(null);
                this.cadastroCliente.getjTextFieldCidade().setText("");
                this.cadastroCliente.getjTextFieldBairro().setText("");
                this.cadastroCliente.getjTextFieldLogradouro().setText("");
            }
            */
           

            if (Dao.ClasseDados.clientes.size() < Integer.parseInt(this.cadastroCliente.getjTextFieldID().getText())) {
                Dao.ClasseDados.clientes.add(cliente);
            } else {
                int id = Integer.parseInt(this.cadastroCliente.getjTextFieldID().getText());

                for (Cliente clienteAtual : Dao.ClasseDados.clientes) {
                    if (clienteAtual.getId() == id) {
                        clienteAtual.setNome(this.cadastroCliente.getjTextFieldNome().getText());
                        clienteAtual.setStatus(this.cadastroCliente.getjCheckBoxStatus().isSelected());
                        clienteAtual.setDataNascimento(this.cadastroCliente.getjFormattedTextFieldDataNascimento().getText());
                        clienteAtual.setCpf(this.cadastroCliente.getjFormattedTextFieldCPF().getText());
                        clienteAtual.setRg(this.cadastroCliente.getjFormattedTextFieldRg().getText());
                        clienteAtual.setMatricula(this.cadastroCliente.getjTextFieldMatricula().getText());
                        clienteAtual.setEmail(this.cadastroCliente.getjTextFieldEmail().getText());
                        clienteAtual.setFone1(this.cadastroCliente.getjFormattedTextFieldFone1().getText());
                        clienteAtual.setFone2(this.cadastroCliente.getjFormattedTextFieldFone2().getText());
                        clienteAtual.setEndereco(cliente.getEndereco());
                    }

                }
            }
            utilities.Utilities.ativa(true, this.cadastroCliente.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroCliente.getjPanelDados());

        } else if (e.getSource() == this.cadastroCliente.getjButtonConsultar()) {
            codigo = 0;

            BuscaCliente buscaCliente = new BuscaCliente(null, true);
            ControllerBuscaCliente controllerBuscaCliente = new ControllerBuscaCliente(buscaCliente);
            //Inserir o controller da busca de bairros
            buscaCliente.setVisible(true);

            if (codigo != 0) {
                Cliente cliente = new Cliente();
                cliente = Dao.ClasseDados.clientes.get(codigo - 1);

                utilities.Utilities.ativa(false, cadastroCliente.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, cadastroCliente.getjPanelDados());

                this.cadastroCliente.getjTextFieldID().setText(cliente.getId() + "");
                this.cadastroCliente.getjTextFieldNome().setText(cliente.getNome() + "");
                this.cadastroCliente.getjFormattedTextFieldDataNascimento().setText(cliente.getDataNascimento() + "");
                this.cadastroCliente.getjFormattedTextFieldCPF().setText(cliente.getCpf() + "");
                this.cadastroCliente.getjFormattedTextFieldRg().setText(cliente.getRg() + "");
                this.cadastroCliente.getjTextFieldMatricula().setText(cliente.getMatricula() + "");
                this.cadastroCliente.getjTextFieldEmail().setText(cliente.getEmail() + "");
                this.cadastroCliente.getjFormattedTextFieldFone1().setText(cliente.getFone1() + "");
                this.cadastroCliente.getjFormattedTextFieldFone2().setText(cliente.getFone2() + "");

                this.cadastroCliente.getjFormattedTextFieldCEP().setText(cliente.getEndereco().getCep() + "");
                this.cadastroCliente.getjTextFieldLogradouro().setText(cliente.getEndereco().getLogradouro());
                this.cadastroCliente.getjTextFieldBairro().setText(cliente.getEndereco().getBairro().getDescricao());
                this.cadastroCliente.getjTextFieldCidade().setText(cliente.getEndereco().getCidade().getDescricao());
                this.cadastroCliente.getjTextFieldComplementoEndereco().setText(cliente.getComplementoEndereco() + "");

                if (cliente.getStatus() == 'I') {
                    this.cadastroCliente.getjCheckBoxStatus().setSelected(true);
                } else {
                    this.cadastroCliente.getjCheckBoxStatus().setSelected(false);
                }

                this.cadastroCliente.getjTextFieldID().setEditable(false);

            }

        } else if (e.getSource() == this.cadastroCliente.getjButtonPesquisarCep()) {

            buscarCep();

        } else if (e.getSource() == this.cadastroCliente.getjButtonAdicionarCep()) {
            CadastroEndereco cadastroEndereco = new CadastroEndereco();
            ControllerCadastroEndereco controllerCadastroEndereco = new ControllerCadastroEndereco(cadastroEndereco);
            cadastroEndereco.setVisible(true);

        }
    }
    
    private Endereco buscaIdEndByCep(String cep){
        for (Endereco enderecoAtual : Dao.ClasseDados.enderecos) {
            if(enderecoAtual.getCep() == cep){
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
        if(e.getSource() == this.cadastroCliente.getjFormattedTextFieldCEP()){
            String codigoCEP = this.cadastroCliente.getjFormattedTextFieldCEP().getText();
            
            if(codigoCEP.isEmpty()){
                this.cadastroCliente.getjTextFieldCidade().setText("");
                this.cadastroCliente.getjTextFieldBairro().setText("");
                this.cadastroCliente.getjTextFieldLogradouro().setText("");
            }else{
                Endereco endereco = buscaIdEndByCep(codigoCEP);
                
                if(endereco != null){
                    this.cadastroCliente.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
                    this.cadastroCliente.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
                    this.cadastroCliente.getjTextFieldLogradouro().setText(endereco.getLogradouro());
                }
                
            }
            
        }
        
        
    }

    private void buscarCep() {
        BuscaEndereco buscaEndereco = new BuscaEndereco(null, true);
        ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(buscaEndereco);
        buscaEndereco.setVisible(true);
        
        if(ControllerCadastroEndereco.codigo != 0){
            Endereco endereco = buscaIdEndByCep(Integer.toString(ControllerCadastroEndereco.codigo));
            if(endereco != null){
                this.cadastroCliente.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
                this.cadastroCliente.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
                this.cadastroCliente.getjTextFieldLogradouro().setText(endereco.getLogradouro());
            }
        }
        

    }

}
