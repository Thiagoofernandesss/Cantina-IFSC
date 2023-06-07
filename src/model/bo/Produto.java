/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bo;

/**
 *
 * @author Thiago
 */
public class Produto {

    private int id;
    private String descricao;
    private String codigoBarra;
    private char status;

    public Produto() {
    }

    public Produto(int id, String descricao, String codigoBarra, char status) {
        this.id = id;
        this.descricao = descricao;
        this.codigoBarra = codigoBarra;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public char getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public void setStatus(char status) {
        this.status = status;    
    }
    
    public void setStatus(boolean status){
        if(status == true){
            this.status = 'I';
        } else{
            this.status = 'A';
        }
    
    }
    
    



    @Override
    public String toString() {
        return this.getId() + ", " 
                + this.getDescricao() + ", " 
                + this.getCodigoBarra() 
                + ", " + this.getStatus();

    }

    public void getCodigoBarra(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
