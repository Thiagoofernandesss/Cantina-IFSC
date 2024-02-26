/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Dao.ProdutoDao;
import model.bo.Produto;

/**
 *
 * @author Thiago
 */
public class ProdutoService {
    public static void adicionar(Produto objeto) {
        ProdutoDao produtoDao = new ProdutoDao();
        produtoDao.create(objeto);
    }

    public static List<Produto> carregar() {
        ProdutoDao produtoDao = new ProdutoDao();
        return produtoDao.retrieve();
    }

    public static Produto carregar(int parPK) {
        ProdutoDao produtoDao = new ProdutoDao();
        return produtoDao.retrieve(parPK);
    }

    public static List<Produto> carregar(String parString) {
        ProdutoDao produtoDao = new ProdutoDao();
        return produtoDao.retrieve(parString);
    }
    
    public static Produto carregarCodigoBarra(String parString) {
        ProdutoDao objetoDAO = new ProdutoDao();
        return objetoDAO.retrieveCodigoBarras(parString);
    }
    
     public static List<Produto> carregar(String nomeParametro, String parString) {
        ProdutoDao produtoDao = new ProdutoDao();
        return produtoDao.retrieve(nomeParametro, parString);
    }

    public static void atualizar(Produto objeto) {
        ProdutoDao produtoDao = new ProdutoDao();
        produtoDao.update(objeto);
    }
    public static void remover(Produto objeto) {
        ProdutoDao produtoDao = new ProdutoDao();
        produtoDao.delete(objeto);
    }
    
}
