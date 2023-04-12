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
public class MovimentoCaixa {

    private int id;
    private DateTimeFormatter dataHorarioMovimento;
    private float valorMovimento;
    private String observacao;
    private char flagTipoMovimento;
    private char status;

    public MovimentoCaixa() {
    }

    public MovimentoCaixa(int id, DateTimeFormatter dataHorarioMovimento, float valorMovimento, String observacao, char flagTipoMovimento, char status) {
        this.id = id;
        this.dataHorarioMovimento = dataHorarioMovimento;
        this.valorMovimento = valorMovimento;
        this.observacao = observacao;
        this.flagTipoMovimento = flagTipoMovimento;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public DateTimeFormatter getDataHorarioMovimento() {
        return dataHorarioMovimento;
    }

    public float getValorMovimento() {
        return valorMovimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public char getFlagTipoMovimento() {
        return flagTipoMovimento;
    }

    public char getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataHorarioMovimento(DateTimeFormatter dataHorarioMovimento) {
        this.dataHorarioMovimento = dataHorarioMovimento;
    }

    public void setValorMovimento(float valorMovimento) {
        this.valorMovimento = valorMovimento;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setFlagTipoMovimento(char flagTipoMovimento) {
        this.flagTipoMovimento = flagTipoMovimento;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getId() + ", " + this.getDataHorarioMovimento() + ", " + this.getValorMovimento() + ", " + this.getObservacao() + ", " + this.getFlagTipoMovimento() + ", " + this.getStatus();

    }

}
