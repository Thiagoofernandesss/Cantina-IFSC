package service;

import java.util.List;
import model.Dao.CidadeDao;
import model.bo.Cidade;

public class CidadeService {
    public static void adicionar(Cidade objeto) {
        CidadeDao cidadeDao = new CidadeDao();
        cidadeDao.create(objeto);
    }

    public static List<Cidade> carregar() {
        CidadeDao cidadeDao = new CidadeDao();
        return cidadeDao.retrieve();
    }

    public static Cidade carregar(int parPK) {
        CidadeDao cidadeDao = new CidadeDao();
        return cidadeDao.retrieve(parPK);
    }

    public static List<Cidade> carregar(String nomeParametro, String parString) {
        CidadeDao cidadeDao = new CidadeDao();
        return cidadeDao.retrieve(nomeParametro,parString);
    }

    public static void atualizar(Cidade objeto) {
        CidadeDao cidadeDao = new CidadeDao();
        cidadeDao.update(objeto);
    }

    public static void remover(Cidade objeto) {
        CidadeDao cidadeDao = new CidadeDao();
        cidadeDao.delete(objeto);
    }
}
