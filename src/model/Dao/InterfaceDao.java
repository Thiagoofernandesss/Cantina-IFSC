/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.Dao;

import java.util.List;

/**
 *
 * @author Thiago
 */
public interface InterfaceDao<T> {
   // Método abstrato para criar um objeto no banco de dados
   public abstract void create(T objeto);
   // Método abstrato para recuperar uma lista de objetos do banco de dados
   public abstract List<T> retrieve();
   // Método abstrato para recuperar um objeto com base em uma chave primária (parPK)
   public abstract T retrieve(int parPK);
   // Método abstrato para recuperar um objeto com base em uma string (parString)
   public abstract List<T> retrieve(String parString);
   // Método abstrato para atualizar um objeto no banco de dados
   public abstract void update(T objeto);
   // Método abstrato para excluir um objeto do banco de dados
   public abstract void delete(T objeto);
    
}
