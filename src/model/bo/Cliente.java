/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bo;

/**
 *
 * @author Thiago
 */
public class Cliente extends Pessoa {

    private String cpf;
    private String rg;
    private String matricula;
    private String dataNascimento;

    public Cliente() {
    }

    public Cliente(String cpf, String rg, String matricula, String dataNascimento, int id, String nome, String fone1, String fone2, String email, char status, String complementoEndereco, Endereco endereco) {
        super(id, nome, fone1, fone2, email, status, complementoEndereco, endereco);
        this.cpf = cpf;
        this.rg = rg;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    

    @Override
    public String toString() {
        return super.toString() + ", "
                + this.getCpf() + ", "
                + this.getRg() + ", "
                + this.getMatricula() + ", "
                + this.getDataNascimento() + ", ";

    }

}
