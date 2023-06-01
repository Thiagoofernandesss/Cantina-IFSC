package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.Bairro;
import view.BuscaBairro;
import view.CadastroBairro;

/**
 *
 * @author aluno
 */
public class ControllerCadastroBairro implements ActionListener {

    //Criando um objeto global do tipo da tela que iremos controlar 
    CadastroBairro cadastroBairro;

    //Passando a tela que iremos controlar como parametro de inovação
    public ControllerCadastroBairro(CadastroBairro cadastroBairro) {
        //Repassando o valor (tela) do parâmetro para o objeto global
        this.cadastroBairro = cadastroBairro;

        //Adicionando Listeners para escutar ações nos botões da tela
        this.cadastroBairro.getjButtonNovo().addActionListener(this);
        this.cadastroBairro.getjButtonSair().addActionListener(this);
        this.cadastroBairro.getjButtonCancelar().addActionListener(this);
        this.cadastroBairro.getjButtonSalvar().addActionListener(this);
        this.cadastroBairro.getjButtonConsultar().addActionListener(this);

        //Executando os métodos da clase de utilitários
        //Para ativar/desativar/limpar botões 
        utilities.Utilities.ativa(true, this.cadastroBairro.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.cadastroBairro.getjPanelDados());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroBairro.getjButtonNovo()) {
            utilities.Utilities.ativa(false, this.cadastroBairro.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.cadastroBairro.getjPanelDados());

        } else if (e.getSource() == this.cadastroBairro.getjButtonSair()) {
            this.cadastroBairro.dispose();

        } else if (e.getSource() == this.cadastroBairro.getjButtonCancelar()) {
            utilities.Utilities.ativa(true, this.cadastroBairro.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroBairro.getjPanelDados());

        } else if (e.getSource() == this.cadastroBairro.getjButtonSalvar()) {
            
            Bairro bairro = new Bairro();
            bairro.setId(Dao.ClasseDados.listaBairro.size()+1);
            bairro.setDescricao(this.cadastroBairro.getjTextFieldDescricao().getText());
            Dao.ClasseDados.listaBairro.add(bairro);
            
            
            
            
            
            
            
            
            
            
            utilities.Utilities.ativa(true, cadastroBairro.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, cadastroBairro.getjPanelDados());

        } else if (e.getSource() == this.cadastroBairro.getjButtonConsultar()) {
            BuscaBairro buscaBairro = new BuscaBairro(null, true);
            ControllerBuscaBairro controllerBuscaBairro = new ControllerBuscaBairro(buscaBairro);
                    
            //Inserir o controller da busca de bairros
            buscaBairro.setVisible(true);

        }
    }

}
