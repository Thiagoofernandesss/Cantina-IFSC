/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bo;

/**
 *
 * @author Thiago
 */
public class ItemVenda {

    private int id;
    private float qtdProduto;
    private float valorUnitario;
    private char status;

    public ItemVenda() {
    }

    public ItemVenda(int id, float qtdProduto, float valorUnitario, char status) {
        this.id = id;
        this.qtdProduto = qtdProduto;
        this.valorUnitario = valorUnitario;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public float getQtdProduto() {
        return qtdProduto;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public char getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQtdProduto(float qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getId() + ", " + this.getQtdProduto() + ", " + this.getValorUnitario() + ", " + this.getStatus();

    }

}
