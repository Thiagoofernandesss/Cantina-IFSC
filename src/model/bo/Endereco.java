/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bo;

/**
 *
 * @author Thiago
 */
public class Endereco {

    private int id;
    private String cep;
    private String logradouro;
    private char status;

    public Endereco() {
    }

    public Endereco(int id, String cep, String logradouro, char status) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public char getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getId() + ", " + this.getCep() + ", " + this.getLogradouro() + ", " + this.getStatus();

    }

}
