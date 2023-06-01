/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.ArrayList;
import model.bo.Bairro;

/**
 *
 * @author aluno
 */
public class ClasseDados {
    private static ClasseDados instance;
    public static ArrayList<Bairro> listaBairro;
    
    public static synchronized ClasseDados getInstance(){
        if(instance == null){
            instance = new ClasseDados();
        }
        return instance;
    }
    
    private ClasseDados(){
        listaBairro = new ArrayList<>();
        
        //teste, não precisa
        Bairro bairro1 = new Bairro(1, "Centro");
        Bairro bairro2 = new Bairro(2, "Vila Moema");
        Bairro bairro3 = new Bairro(3, "Humaita");
        
        listaBairro.add(bairro1);
        listaBairro.add(bairro2);
        listaBairro.add(bairro3);
    }
    
}
