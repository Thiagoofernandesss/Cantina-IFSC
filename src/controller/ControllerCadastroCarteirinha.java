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
import java.util.ArrayList;
import java.util.List;
import model.bo.Carteirinha;
import model.bo.Cliente;
import service.ClienteService;
import view.BuscaCarteirinha;
import view.BuscaCliente;
import view.CadastroCarteirinha;
import view.CadastroCliente;

/**
 *
 * @author Thiago and Gabrieli
 */
public class ControllerCadastroCarteirinha implements ActionListener, FocusListener {

    CadastroCarteirinha cadastroCarteirinha;
    public static int codigo;


    public ControllerCadastroCarteirinha(CadastroCarteirinha cadastroCarteirinha) {
        this.cadastroCarteirinha = cadastroCarteirinha;

        this.cadastroCarteirinha.getjButtonNovo().addActionListener(this);
        this.cadastroCarteirinha.getjButtonSalvar().addActionListener(this);
        this.cadastroCarteirinha.getjButtonCancelar().addActionListener(this);
        this.cadastroCarteirinha.getjButtonConsultar().addActionListener(this);
        this.cadastroCarteirinha.getjButtonSair().addActionListener(this);
        this.cadastroCarteirinha.getjButtonPesquisarCPF().addActionListener(this);
        this.cadastroCarteirinha.getjButtonAdicionarCPF().addActionListener(this);
        
        this.cadastroCarteirinha.getjFormattedTextFieldCPF().addFocusListener(this);
        
        List<Cliente> listaCliente = new ArrayList<>();
        
        listaCliente = service.ClienteService.carregar();
        
        //this.cadastroCarteirinha.getjFormattedTextFieldCPF().addFocusListener(this);

        utilities.Utilities.ativa(true, this.cadastroCarteirinha.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroCarteirinha.getjPanelDados());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroCarteirinha.getjButtonNovo()) { 
            utilities.Utilities.ativa(false, this.cadastroCarteirinha.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroCarteirinha.getjPanelDados());
            
            this.cadastroCarteirinha.getjTextFieldID().setEditable(false);
            this.cadastroCarteirinha.getjTextFieldNome().setEditable(false);
            
            this.cadastroCarteirinha.getjFormattedTextFieldCPF().requestFocus();
            
        } else if (e.getSource() == this.cadastroCarteirinha.getjButtonSair()) {
            this.cadastroCarteirinha.dispose();

        } else if (e.getSource() == this.cadastroCarteirinha.getjButtonCancelar()) {
            utilities.Utilities.ativa(true, this.cadastroCarteirinha.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroCarteirinha.getjPanelDados());

        } else if (e.getSource() == this.cadastroCarteirinha.getjButtonSalvar()) {
            Carteirinha carteirinha = new Carteirinha();

            carteirinha.setCodigoBarra(this.cadastroCarteirinha.getjTextFieldCodBarra().getText());

            String dataGeracaoString = this.cadastroCarteirinha.getjFormattedTextFieldDataGeracao().getText();
            SimpleDateFormat formatoGeracaoEntrada = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoGeracaoSaida = new SimpleDateFormat("yyyy-MM-dd");

            try {
                java.util.Date dataGeracao = formatoGeracaoEntrada.parse(dataGeracaoString);
                String dataGeracaoFormatada = formatoGeracaoSaida.format(dataGeracao);

                carteirinha.setDataGeracao(dataGeracaoFormatada);
            } catch (ParseException m) {
                // Lida com erros de formatação da data, se necessário
            }

            String dataCancelamentoString = this.cadastroCarteirinha.getjFormattedTextFieldDataCancelamento().getText();
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoSaida = new SimpleDateFormat("yyyy-MM-dd");

            try {
                java.util.Date dataCancelamento = formatoEntrada.parse(dataCancelamentoString);
                String dataCancelamentoFormatada = formatoSaida.format(dataCancelamento);

                carteirinha.setDataCancelamento(dataCancelamentoFormatada);
            } catch (ParseException m) {
                // Lida com erros de formatação da data, se necessário
            }

            Cliente cliente = ClienteService.carregarCPF(this.cadastroCarteirinha.getjFormattedTextFieldCPF().getText());

            carteirinha.setCliente(cliente);

            if (codigo == 0) {
                service.CarteirinhaService.adicionar(carteirinha);
                utilities.Utilities.ativa(true, cadastroCarteirinha.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(false, cadastroCarteirinha.getjPanelDados());

                this.cadastroCarteirinha.getjTextFieldID().setEditable(false);
                this.cadastroCarteirinha.getjTextFieldNome().setEditable(false);

            } else {
                cliente.setId(codigo);

                service.CarteirinhaService.atualizar(carteirinha);
                utilities.Utilities.ativa(true, this.cadastroCarteirinha.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(false, this.cadastroCarteirinha.getjPanelDados());

                this.cadastroCarteirinha.getjTextFieldID().setEditable(false);
                this.cadastroCarteirinha.getjTextFieldNome().setEditable(false);

            }
            

        } else if (e.getSource() == this.cadastroCarteirinha.getjButtonConsultar())  {
            codigo = 0;

            BuscaCarteirinha buscaCarteirinha = new BuscaCarteirinha(null, true);
            ControllerBuscaCarteirinha controllerBuscaCarteirinha = new ControllerBuscaCarteirinha(buscaCarteirinha);
            //Inserir o controller da busca de bairros
            buscaCarteirinha.setVisible(true);

            if (codigo != 0) {

                utilities.Utilities.ativa(false, cadastroCarteirinha.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, cadastroCarteirinha.getjPanelDados());

                Carteirinha carteirinha = new Carteirinha();
                carteirinha = service.CarteirinhaService.carregar(codigo);

                this.cadastroCarteirinha.getjTextFieldID().setText(carteirinha.getId() + "");
                this.cadastroCarteirinha.getjTextFieldNome().setText(carteirinha.getCliente().getNome() + "");
                this.cadastroCarteirinha.getjFormattedTextFieldCPF().setText(carteirinha.getCliente().getCpf() + "");
                this.cadastroCarteirinha.getjTextFieldCodBarra().setText(carteirinha.getCodigoBarra() + "");

                String dataGeracaoDoBanco = carteirinha.getDataGeracao(); // Suponha que você tenha recuperado a data do banco aqui
                SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    java.util.Date dataGeracao = formatoEntrada.parse(dataGeracaoDoBanco);
                    String dataGeracaoFormatada = formatoSaida.format(dataGeracao);
                    this.cadastroCarteirinha.getjFormattedTextFieldDataGeracao().setText(dataGeracaoFormatada);

                    // Agora você pode usar dataNascimentoFormatada para exibir a data no formato "dd/MM/yyyy"
                } catch (ParseException m) {
                    // Lida com erros de formatação da data, se necessário
                }

                String dataCancelamentoDoBanco = carteirinha.getDataCancelamento();

                if (dataCancelamentoDoBanco != null) {
                    SimpleDateFormat formatoEntradaCancelamento = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat formatoSaidaCancelamento = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        java.util.Date dataCancelamento = formatoEntrada.parse(dataCancelamentoDoBanco);
                        String dataCancelamentoFormatada = formatoSaida.format(dataCancelamento);
                        this.cadastroCarteirinha.getjFormattedTextFieldDataGeracao().setText(dataCancelamentoFormatada);

                        // Agora você pode usar dataNascimentoFormatada para exibir a data no formato "dd/MM/yyyy"
                    } catch (ParseException m) {
                        // Lida com erros de formatação da data, se necessário
                    }

                } else {
                    this.cadastroCarteirinha.getjFormattedTextFieldDataCancelamento().setText("");
                }

                this.cadastroCarteirinha.getjTextFieldID().setEditable(false);
                this.cadastroCarteirinha.getjTextFieldNome().setEditable(false);

            }

        } else if (e.getSource() == this.cadastroCarteirinha.getjButtonAdicionarCPF()) {
            CadastroCliente cadastroCliente = new CadastroCliente();
            ControllerCadastroCliente controllerCadastroCliente = new ControllerCadastroCliente(cadastroCliente);
            cadastroCliente.setVisible(true);

        } else if (e.getSource() == this.cadastroCarteirinha.getjButtonPesquisarCPF()) {

            buscarCPF();

        }

    }

    @Override
    public void focusGained(FocusEvent e) {
        //Método do FocusListener para quando o campo ganha foco
        // Não é necessário implementar nada aqui
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == this.cadastroCarteirinha.getjFormattedTextFieldCPF()) {
            String CPF = this.cadastroCarteirinha.getjFormattedTextFieldCPF().getText().trim();

            if (!CPF.isEmpty()) {
                List<Cliente> listaClientes = ClienteService.carregar("cpf", CPF);

                if (!listaClientes.isEmpty()) {
                    Cliente cliente = listaClientes.get(0);

                    this.cadastroCarteirinha.getjTextFieldNome().setText(cliente.getNome());
                } else {
                    this.cadastroCarteirinha.getjFormattedTextFieldCPF().setValue(null);
                    this.cadastroCarteirinha.getjTextFieldNome().setText("");

                }

            }
        }
    }

    public Cliente getCPFByID(int idClient) {
        for (Cliente clienteAtual : service.ClienteService.carregar()) {
            if (clienteAtual.getId() == idClient) {
                return clienteAtual;
            }
        }
        return null;
    }

    private void buscarCPF() {
        BuscaCliente buscaCliente = new BuscaCliente(null, true);
        ControllerBuscaCliente controllerBuscaCliente = new ControllerBuscaCliente(buscaCliente);
        buscaCliente.setVisible(true);

        if (ControllerCadastroCliente.codigo != 0) {
            Cliente cliente = getCPFByID(ControllerCadastroCliente.codigo);
            this.cadastroCarteirinha.getjTextFieldNome().setText(cliente.getNome());
        }
    }
}
