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
public class ControllerCadastroBairro implements ActionListener{

    //Criando um objeto global do tipo da tela que iremos controlar 
    private CadastroBairro cadastroBairro;
    public static int codigo;

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
            //Deseligando o ID no braço, PROVISÓRIO
            this.cadastroBairro.getjTextFieldId().setEditable(false);
            this.cadastroBairro.getjTextFieldId().setText(Integer.toString(Dao.ClasseDados.bairros.size()+1)); //Trazendo proximo id
            this.cadastroBairro.getjTextFieldDescricao().requestFocus();

        } else if (e.getSource() == this.cadastroBairro.getjButtonSair()) {
            this.cadastroBairro.dispose();

        } else if (e.getSource() == this.cadastroBairro.getjButtonCancelar()) {
            utilities.Utilities.ativa(true, this.cadastroBairro.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.cadastroBairro.getjPanelDados());

        } else if (e.getSource() == this.cadastroBairro.getjButtonSalvar()) {
            
            Bairro bairro = new Bairro();
            bairro.setId(Dao.ClasseDados.bairros.size() + 1);
            bairro.setDescricao(this.cadastroBairro.getjTextFieldDescricao().getText());
            if (Dao.ClasseDados.bairros.size() < Integer.parseInt(this.cadastroBairro.getjTextFieldId().getText())) {
                Dao.ClasseDados.bairros.add(bairro);
            } else{
                int id = Integer.parseInt(this.cadastroBairro.getjTextFieldId().getText());
                
                for (Bairro bairroAtual : Dao.ClasseDados.bairros) {
                    if(bairroAtual.getId() == id){
                        bairroAtual.setDescricao(this.cadastroBairro.getjTextFieldDescricao().getText());
                        break;
                    }
                    
                }
                
            }

            utilities.Utilities.ativa(true, cadastroBairro.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, cadastroBairro.getjPanelDados());

        } else if (e.getSource() == this.cadastroBairro.getjButtonConsultar()) {
            codigo = 0;

            BuscaBairro buscaBairro = new BuscaBairro(null, true);
            ControllerBuscaBairro controllerBuscaBairro = new ControllerBuscaBairro(buscaBairro);

            //Inserir o controller da busca de bairros
            buscaBairro.setVisible(true);

            if (codigo != 0) {
                Bairro bairro = new Bairro();
                bairro = Dao.ClasseDados.bairros.get(codigo - 1);

                utilities.Utilities.ativa(false, cadastroBairro.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, cadastroBairro.getjPanelDados());

                this.cadastroBairro.getjTextFieldId().setText(bairro.getId() + "");
                this.cadastroBairro.getjTextFieldDescricao().setText(bairro.getDescricao() +"");
                
                this.cadastroBairro.getjTextFieldId().setEditable(false);

            }

        }
    }

}
