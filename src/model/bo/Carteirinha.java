/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bo;

/**
 *
 * @author Thiago
 */
public class Carteirinha {

    private int id;
    private String codigoBarra;
    private String dataGeracao;
    private String dataCancelamento;
    
    private Cliente cliente;

    public Carteirinha() {
    }

    public Carteirinha(int id, String codigoBarra, String dataGeracao, String dataCancelamento, Cliente cliente) {
        this.id = id;
        this.codigoBarra = codigoBarra;
        this.dataGeracao = dataGeracao;
        this.dataCancelamento = dataCancelamento;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public int getId() {
        return id;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public String getDataGeracao() {
        return dataGeracao;
    }

    public String getDataCancelamento() {
        return dataCancelamento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public void setDataGeracao(String dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public void setDataCancelamento(String dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    @Override
    public String toString() {
        return this.getId() + ", " 
                + this.getCodigoBarra() + ", " 
                + this.getDataGeracao() + ", " 
                + this.getDataCancelamento() + ", "
                + this.cliente.getMatricula() + ", "
                + this.cliente.getNome();

    }

}
