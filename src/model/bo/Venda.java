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
public class Venda {

    private int id;
    private String datahoravenda;
    private float valorDesconto;
    private char flagTipoDesconto;
    private String observacao;
    private char status;

    private Carteirinha carteirinha;
    private Funcionario funcionario;

    public Venda() {
    }


    public Venda(int id, String dataHoraVenda, float valorDesconto, char flagTipoDesconto, String observacao, char status, Carteirinha carteirinha, Funcionario funcionario) {
        this.id = id;
        this.datahoravenda = dataHoraVenda;
        this.valorDesconto = valorDesconto;
        this.flagTipoDesconto = flagTipoDesconto;
        this.observacao = observacao;
        this.status = status;
        this.carteirinha = carteirinha;
        this.funcionario = funcionario;
    }

    public Carteirinha getCarteirinha() {
        return carteirinha;
    }

    public void setCarteirinha(Carteirinha carteirinha) {
        this.carteirinha = carteirinha;
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

    public String getDataHoraVenda() {
        return datahoravenda;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public char getFlagTipoDesconto() {
        return flagTipoDesconto;
    }

    public String getObservacao() {
        return observacao;
    }

    public char getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataHoraVenda(String dataHoraVenda) {
        this.datahoravenda = dataHoraVenda;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public void setFlagTipoDesconto(char flagTipoDesconto) {
        this.flagTipoDesconto = flagTipoDesconto;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getId() + ", " 
                + this.getDataHoraVenda() + ", " 
                + this.getValorDesconto() + ", " 
                + this.getFlagTipoDesconto() + ", " 
                + this.getObservacao() + ", " 
                + this.getStatus() + ", "
                + this.carteirinha.getId()
                + this.carteirinha.getCliente().getNome();

    }

}
