/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.util.ArrayList;
import java.util.List;
import model.bo.Bairro;



/**
 *
 * @author Thiago
 */
public class BairroDao {
    private static  BairroDao instance;
    private List<Bairro> bairros;

    public BairroDao() {
        bairros = new ArrayList<>();
    }
    
    public static synchronized BairroDao getInstance(){
        if(instance == null){
            instance = new BairroDao();
        }
        return instance;
    }


    
    
    
}
