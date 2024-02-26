/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.DAO.VendaDAO;
import model.bo.Venda;

/**
 *
 * @author gabri
 */
public class VendaService {
     public static void adicionar(Venda objeto){
        VendaDAO objetoDAO = new VendaDAO();
        objetoDAO.create(objeto);
    }
    
     //public static int createReturnID(Venda objeto){
     //   VendaDAO objetoDAO = new VendaDAO();
     //   return objetoDAO.createReturnID(objeto);
    //}
     
     public static Venda carregar(int parPK){
        VendaDAO objetoDAO = new VendaDAO();
        return objetoDAO.retrieve(parPK);
    }
}
