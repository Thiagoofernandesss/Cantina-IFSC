package service;

import java.util.List;
import model.Dao.FornecedorDao;
import model.bo.Fornecedor;

public class FornecedorService {
    public static void adicionar(Fornecedor objeto) {
        FornecedorDao fornecedorDao = new FornecedorDao();
        fornecedorDao.create(objeto);
    }

    public static List<Fornecedor> carregar() {
        FornecedorDao fornecedorDao = new FornecedorDao();
        return fornecedorDao.retrieve();
    }

    public static Fornecedor carregar(int parPK) {
        FornecedorDao fornecedorDao = new FornecedorDao();
        return fornecedorDao.retrieve(parPK);
    }

    public static List<Fornecedor> carregar(String nomeParametro, String parString) {
        FornecedorDao fornecedorDao = new FornecedorDao();
        return fornecedorDao.retrieve(nomeParametro, parString);
    }

    public static void atualizar(Fornecedor objeto) {
        FornecedorDao fornecedorDao = new FornecedorDao();
        fornecedorDao.update(objeto);
    }

    public static void remover(Fornecedor objeto) {
        FornecedorDao fornecedorDao = new FornecedorDao();
        fornecedorDao.delete(objeto);
    }
}
