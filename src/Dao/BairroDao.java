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
    
    public void adicionarBairro(Bairro bairro){
        bairros.add(bairro);
    }
    
    public void atualizaBairro(Bairro bairro){
        for(Bairro b : bairros){
            if(b.getId() == bairro.getId()){
                b.setDescricao(bairro.getDescricao());
                b.setId(bairro.getId());
                break;
            }
        }
        
    }
    
    public void deletarBairro(int bairroId){
        Bairro bairroToRemove =null;
        
        for(Bairro b : bairros){
            if(b.getId() == bairroId){
                bairroToRemove = b;
                break;
            }
        }
        if(bairroToRemove!= null){
            bairros.remove(bairroToRemove);
        }
    }
    
    public List<Bairro> getAllBairros(){
        return bairros;
    }
    
    public Bairro getBairroById(int BairroId){
        for(Bairro b: bairros){
            if(b.getId() == BairroId){
                return b;
            }
        }
        return null;
    }


    
    
    
}
