/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bo;

/**
 *
 * @author Thiago
 * 
 * 
 * 
 * 
 * 
 */
public class Funcionario extends Pessoa {

    private String cpf;
    private String rg;
    private String usuario;
    private String senha;

    public Funcionario() {
    }

    public Funcionario(String cpf, String rg, String usuario, String senha) {
        this.cpf = cpf;
        this.rg = rg;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return this.getCpf() + ", " + this.getRg() + ", " + this.getUsuario() + ", " + this.getSenha();

    }

}
