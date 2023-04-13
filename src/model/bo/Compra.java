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
public class Compra {

    private int id;
    private int numeroNF;
    private DateTimeFormatter dataHoraCompra;
    private float valorDesconto;
    private char flagTipoDesconto;
    private char status;
    private String observacao;
    
    private Fornecedor fornecedor;

    public Compra() {
    }

    public Compra(int id, int numeroNF, DateTimeFormatter dataHoraCompra, float valorDesconto, char flagTipoDesconto, char status, String observacao, Fornecedor fornecedor) {
        this.id = id;
        this.numeroNF = numeroNF;
        this.dataHoraCompra = dataHoraCompra;
        this.valorDesconto = valorDesconto;
        this.flagTipoDesconto = flagTipoDesconto;
        this.status = status;
        this.observacao = observacao;
        this.fornecedor = fornecedor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }



    public int getId() {
        return id;
    }

    public int getNumeroNF() {
        return numeroNF;
    }

    public DateTimeFormatter getDataHoraCompra() {
        return dataHoraCompra;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public char getFlagTipoDesconto() {
        return flagTipoDesconto;
    }

    public char getStatus() {
        return status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumeroNF(int numeroNF) {
        this.numeroNF = numeroNF;
    }

    public void setDataHoraCompra(DateTimeFormatter dataHoraCompra) {
        this.dataHoraCompra = dataHoraCompra;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public void setFlagTipoDesconto(char flagTipoDesconto) {
        this.flagTipoDesconto = flagTipoDesconto;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return this.getId() + ", " 
                + this.getNumeroNF() + ", " 
                + this.getDataHoraCompra() + ", " 
                + this.getValorDesconto() + ", " 
                + this.getFlagTipoDesconto() + ", " 
                + this.getStatus() + ", " 
                + this.getObservacao() + ", "
                + this.fornecedor.getCnpj() + ", "
                + this.fornecedor.getRazaoSocial();

    }

}
