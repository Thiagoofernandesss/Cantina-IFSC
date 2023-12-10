/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bo;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Thiago
 */
public class Caixa {

    private int id;
    private String dataHoraAbertura;
    private String dataHoraFechamento;
    private float valorAbertura;
    private float valorFechamento;
    private String observacao;
    private char status;
    
    private Funcionario funcionario;

    public Caixa() {
    }

    public Caixa(int id, String dataHoraAbertura, String dataHoraFechamento, float valorAbertura, float valorFechamento, String observaccao, char status, Funcionario funcionario) {
        this.id = id;
        this.dataHoraAbertura = dataHoraAbertura;
        this.dataHoraFechamento = dataHoraFechamento;
        this.valorAbertura = valorAbertura;
        this.valorFechamento = valorFechamento;
        this.observacao = observaccao;
        this.status = status;
        this.funcionario = funcionario;
    }

    public String getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(String dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }



    public int getId() {
        return id;
    }


    public String getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public float getValorAbertura() {
        return valorAbertura;
    }

    public float getValorFechamento() {
        return valorFechamento;
    }

    public String getObservaccao() {
        return observacao;
    }

    public char getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataHoraFechamento(String dataHoraFechamento) {
        this.dataHoraFechamento = dataHoraFechamento;
    }

    public void setValorAbertura(float valorAbertura) {
        this.valorAbertura = valorAbertura;
    }

    public void setValorFechamento(float valorFechamento) {
        this.valorFechamento = valorFechamento;
    }

    public void setObservaccao(String observaccao) {
        this.observacao = observaccao;
    }

    public void setStatus(char status) {
        this.status = status;
    }
    
    public void setStatu(boolean statusInformado) {
        if(statusInformado == false){
            this.status = 'A';
        } else{
            this.status = 'I';
    }
        
   }

    @Override
    public String toString() {
        return this.getId() + ", " 
                + this.getDataHoraAbertura() + ", " 
                + this.getDataHoraFechamento() + ", " 
                + this.getValorAbertura() + ", " 
                + this.getValorFechamento() + ", " 
                + this.getObservaccao() + ", " 
                + this.getStatus() + ", "
                + this.funcionario.getUsuario();

    }

}
