/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import model.bo.Cliente;
import model.bo.Endereco;
import service.EnderecoService;
import view.BuscaCliente;
import view.BuscaEndereco;
import view.CadastroCliente;
import view.CadastroEndereco;
import utilities.Utilities;

/**
 *
 * @author Thiago
 */
public class ControllerCadastroCliente implements ActionListener, FocusListener {

    private CadastroCliente cadastroCliente;
    public static int codigo;

    //public String numeroCEP;
    
    FocusListener focusData = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnCepTextFieldGray(cadastroCliente.getjFormattedTextFieldDataNascimento());
            
        }

        @Override
        public void focusLost(FocusEvent e) {
                
            
             Utilities.turnCepTextFieldRed(cadastroCliente.getjFormattedTextFieldDataNascimento());
            
        }
    };
    
    FocusListener focusCep = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnCepTextFieldGray(cadastroCliente.getjFormattedTextFieldCEP());
            
        }

        @Override
        public void focusLost(FocusEvent e) {
                
            
             Utilities.turnCepTextFieldRed(cadastroCliente.getjFormattedTextFieldCEP());
            
        }
    };
    
    FocusListener focusMatricula = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnTextFieldGray(cadastroCliente.getjTextFieldMatricula());
        }

        @Override
        public void focusLost(FocusEvent e) {
            Utilities.turnTextFieldRed(cadastroCliente.getjTextFieldMatricula());
        }
    };
    
    FocusListener focusCpf = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnCepTextFieldGray(cadastroCliente.getjFormattedTextFieldCPF());
        }

        @Override
        public void focusLost(FocusEvent e) {
            Utilities.turnCpfTextFieldRed(cadastroCliente.getjFormattedTextFieldCPF());
        }
    };
    
    FocusListener focusNome = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnTextFieldGray(cadastroCliente.getjTextFieldNome());
        }

        @Override
        public void focusLost(FocusEvent e) {
            Utilities.turnTextFieldRed(cadastroCliente.getjTextFieldNome());
        }
    };

    public ControllerCadastroCliente(CadastroCliente cadastroCliente) {
        this.cadastroCliente = cadastroCliente;

        // Adicionando os listeners aos botões
        this.cadastroCliente.getjButtonNovo().addActionListener(this);
        this.cadastroCliente.getjButtonSair().addActionListener(this);
        this.cadastroCliente.getjButtonCancelar().addActionListener(this);
        this.cadastroCliente.getjButtonSalvar().addActionListener(this);
        this.cadastroCliente.getjButtonConsultar().addActionListener(this);
        
        this.cadastroCliente.getjButtonAdicionarCep().addActionListener(this);
        this.cadastroCliente.getjButtonPesquisarCep().addActionListener(this);  
        
        this.cadastroCliente.getjFormattedTextFieldCEP().addFocusListener(focusCep);
        this.cadastroCliente.getjTextFieldMatricula().addFocusListener(focusMatricula);
        this.cadastroCliente.getjFormattedTextFieldCPF().addFocusListener(focusCpf);
        this.cadastroCliente.getjTextFieldNome().addFocusListener(focusNome);
        this.cadastroCliente.getjFormattedTextFieldDataNascimento().addFocusListener(focusData);

        List<Endereco> listaEnderecos = new ArrayList<>();

        listaEnderecos = service.EnderecoService.carregar();

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
            this.cadastroCliente.getjTextFieldNome().requestFocus();//Cursor  começando no nome
            
            utilities.Utilities.turnCepTextFieldGray(this.cadastroCliente.getjFormattedTextFieldCEP());
            utilities.Utilities.turnCepTextFieldGray(this.cadastroCliente.getjFormattedTextFieldCPF());
        } else if (e.getSource() == this.cadastroCliente.getjButtonSair()) {
            this.cadastroCliente.dispose(); //Ação botão sair

        } else if (e.getSource() == this.cadastroCliente.getjButtonCancelar()) {
            //Ações botão cancelar
            utilities.Utilities.ativa(true, this.cadastroCliente.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroCliente.getjPanelDados());

        } else if (e.getSource() == this.cadastroCliente.getjButtonSalvar()) {
            //Ação Botão Salvar
            Cliente cliente = new Cliente();
            
            cliente.setNome(this.cadastroCliente.getjTextFieldNome().getText());
            cliente.setFone1(this.cadastroCliente.getjFormattedTextFieldFone1().getText());
            cliente.setFone2(this.cadastroCliente.getjFormattedTextFieldFone2().getText());
            cliente.setEmail(this.cadastroCliente.getjTextFieldEmail().getText());
            cliente.setStatus(this.cadastroCliente.getjCheckBoxStatus().isSelected());
            cliente.setCpf(this.cadastroCliente.getjFormattedTextFieldCPF().getText());
            String cpfString = this.cadastroCliente.getjFormattedTextFieldCPF().getText();
            cliente.setRg(this.cadastroCliente.getjFormattedTextFieldRg().getText());
            cliente.setMatricula(this.cadastroCliente.getjTextFieldMatricula().getText());
            cliente.setComplementoEndereco(this.cadastroCliente.getjTextFieldComplementoEndereco().getText());
            //cliente.setDataNascimento(this.cadastroCliente.getjFormattedTextFieldDataNascimento().getText());

            String dataNascimentoString = this.cadastroCliente.getjFormattedTextFieldDataNascimento().getText();
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoSaida = new SimpleDateFormat("yyyy-MM-dd");

            try {
                java.util.Date dataNascimento = formatoEntrada.parse(dataNascimentoString);
                String dataNascimentoFormatada = formatoSaida.format(dataNascimento);

                cliente.setDataNascimento(dataNascimentoFormatada);
            } catch (ParseException m) {
                // Lida com erros de formatação da data, se necessário
            }

            Endereco endereco = EnderecoService.carregarCEP(this.cadastroCliente.getjFormattedTextFieldCEP().getText());
            
            cliente.setEndereco(endereco);

            if (codigo == 0) {
                service.ClienteService.adicionar(cliente);
                utilities.Utilities.ativa(true, this.cadastroCliente.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(false, this.cadastroCliente.getjPanelDados());

                this.cadastroCliente.getjTextFieldID().setEditable(false); //Desligando id no braço, provisório

                //Desligando os campos de descrições da cidade, do bairro e logradouro
                this.cadastroCliente.getjTextFieldCidade().setEditable(false);
                this.cadastroCliente.getjTextFieldBairro().setEditable(false);
                this.cadastroCliente.getjTextFieldLogradouro().setEditable(false);
            } else {
                cliente.setId(codigo);

                service.ClienteService.atualizar(cliente);
                utilities.Utilities.ativa(true, this.cadastroCliente.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(false, this.cadastroCliente.getjPanelDados());

                this.cadastroCliente.getjTextFieldID().setEditable(false); //Desligando id no braço, provisório

                //Desligando os campos de descrições da cidade, do bairro e logradouro
                this.cadastroCliente.getjTextFieldCidade().setEditable(false);
                this.cadastroCliente.getjTextFieldBairro().setEditable(false);
                this.cadastroCliente.getjTextFieldLogradouro().setEditable(false);

            }
            
            utilities.Utilities.turnCepTextFieldGray(this.cadastroCliente.getjFormattedTextFieldCEP());
            utilities.Utilities.turnCepTextFieldGray(this.cadastroCliente.getjFormattedTextFieldCPF());

        } else if (e.getSource() == this.cadastroCliente.getjButtonConsultar()) {
            codigo = 0;

            BuscaCliente buscaCliente = new BuscaCliente(null, true);
            ControllerBuscaCliente controllerBuscaCliente = new ControllerBuscaCliente(buscaCliente);
            //Inserir o controller da busca de cliente
            buscaCliente.setVisible(true);

            if (codigo != 0) {

                utilities.Utilities.ativa(false, cadastroCliente.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, cadastroCliente.getjPanelDados());

                Cliente cliente = new Cliente();
                cliente = service.ClienteService.carregar(codigo);

                this.cadastroCliente.getjTextFieldID().setText(cliente.getId() + "");
                this.cadastroCliente.getjTextFieldNome().setText(cliente.getNome() + "");
                this.cadastroCliente.getjFormattedTextFieldCPF().setText(cliente.getCpf() + "");
                this.cadastroCliente.getjFormattedTextFieldRg().setText(cliente.getRg() + "");
                this.cadastroCliente.getjTextFieldMatricula().setText(cliente.getMatricula() + "");
                this.cadastroCliente.getjTextFieldEmail().setText(cliente.getEmail() + "");
                this.cadastroCliente.getjFormattedTextFieldFone1().setText(cliente.getFone1() + "");
                this.cadastroCliente.getjFormattedTextFieldFone2().setText(cliente.getFone2() + "");
                this.cadastroCliente.getjFormattedTextFieldCEP().setText(cliente.getEndereco().getCep() + "");

                String dataNascimentoDoBanco = cliente.getDataNascimento(); // Suponha que você tenha recuperado a data do banco aqui
                SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    java.util.Date dataNascimento = formatoEntrada.parse(dataNascimentoDoBanco);
                    String dataNascimentoFormatada = formatoSaida.format(dataNascimento);
                    this.cadastroCliente.getjFormattedTextFieldDataNascimento().setText(dataNascimentoFormatada);

                    // Agora você pode usar dataNascimentoFormatada para exibir a data no formato "dd/MM/yyyy"
                } catch (ParseException m) {
                    // Lida com erros de formatação da data, se necessário
                }
                
                

                this.cadastroCliente.getjTextFieldLogradouro().setText(cliente.getEndereco().getLogradouro() + "");
                this.cadastroCliente.getjTextFieldBairro().setText(cliente.getEndereco().getBairro().getDescricao() + "");
                this.cadastroCliente.getjTextFieldCidade().setText(cliente.getEndereco().getCidade().getDescricao() + "");
                this.cadastroCliente.getjTextFieldComplementoEndereco().setText(cliente.getComplementoEndereco() + "");

                if (cliente.getStatus() == 'I') {
                    this.cadastroCliente.getjCheckBoxStatus().setSelected(true);
                }

                this.cadastroCliente.getjTextFieldID().setEditable(false);
                //Desligando os campos de descrições da cidade, do bairro e logradouro
                this.cadastroCliente.getjTextFieldCidade().setEditable(false);
                this.cadastroCliente.getjTextFieldBairro().setEditable(false);
                this.cadastroCliente.getjTextFieldLogradouro().setEditable(false);

            }

        } else if (e.getSource() == this.cadastroCliente.getjButtonPesquisarCep()) {

            buscarCep();
            utilities.Utilities.turnCepTextFieldGray(this.cadastroCliente.getjFormattedTextFieldCEP());
            utilities.Utilities.turnCepTextFieldGray(this.cadastroCliente.getjFormattedTextFieldCPF());

        } else if (e.getSource() == this.cadastroCliente.getjButtonAdicionarCep()) {
            CadastroEndereco cadastroEndereco = new CadastroEndereco();
            ControllerCadastroEndereco controllerCadastroEndereco = new ControllerCadastroEndereco(cadastroEndereco);
            cadastroEndereco.setVisible(true);
            
            utilities.Utilities.turnCepTextFieldGray(this.cadastroCliente.getjFormattedTextFieldCEP());
            utilities.Utilities.turnCepTextFieldGray(this.cadastroCliente.getjFormattedTextFieldCPF());
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
        //Método do FocusListener para quando o campo ganha foco
        // Não é necessário implementar nada aqui
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == this.cadastroCliente.getjFormattedTextFieldCEP()) {
            String codigoCEP = (String) this.cadastroCliente.getjFormattedTextFieldCEP().getText();
            System.out.println(codigoCEP);

            if (codigoCEP.isEmpty()) {
                this.cadastroCliente.getjFormattedTextFieldCEP().setText("");
                this.cadastroCliente.getjTextFieldCidade().setText("");
                this.cadastroCliente.getjTextFieldBairro().setText("");
                this.cadastroCliente.getjTextFieldLogradouro().setText("");
            } else {
                Endereco endereco = EnderecoService.carregarCEP(codigoCEP);

                if (endereco != null) {
                    this.cadastroCliente.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
                    this.cadastroCliente.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
                    this.cadastroCliente.getjTextFieldLogradouro().setText(endereco.getLogradouro());
                } else {
                    this.cadastroCliente.getjTextFieldCidade().setText("");
                    this.cadastroCliente.getjTextFieldBairro().setText("");
                    this.cadastroCliente.getjTextFieldLogradouro().setText("");

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
            this.cadastroCliente.getjFormattedTextFieldCEP().setText(endereco.getCep());
            this.cadastroCliente.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
            this.cadastroCliente.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
            this.cadastroCliente.getjTextFieldLogradouro().setText(endereco.getLogradouro());
        }
    }
}
