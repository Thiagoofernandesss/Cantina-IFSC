package service;

import java.util.List;
import model.Dao.CarteirinhaDao;
import model.bo.Carteirinha;

public class CarteirinhaService {
    public static void adicionar(Carteirinha objeto) {
        CarteirinhaDao carteirinhaDao = new CarteirinhaDao();
        carteirinhaDao.create(objeto);
    }

    public static List<Carteirinha> carregar() {
        CarteirinhaDao carteirinhaDao = new CarteirinhaDao();
        return carteirinhaDao.retrieve();
    }

    public static Carteirinha carregar(int parPK) {
        CarteirinhaDao carteirinhaDao = new CarteirinhaDao();
        return carteirinhaDao.retrieve(parPK);
    }

    public static List<Carteirinha> carregar(String nomeParametro, String parString) {
        CarteirinhaDao carteirinhaDao = new CarteirinhaDao();
        return carteirinhaDao.retrieve(nomeParametro, parString);
    }
    
    public static List<Carteirinha> carregar(String parString) {
        CarteirinhaDao carteirinhaDao = new CarteirinhaDao();
        return carteirinhaDao.retrieve(parString);
    }
    public static void atualizar(Carteirinha objeto) {
        CarteirinhaDao carteirinhaDao = new CarteirinhaDao();
        carteirinhaDao.update(objeto);
    }

    public static void remover(Carteirinha objeto) {
        CarteirinhaDao carteirinhaDao = new CarteirinhaDao();
        carteirinhaDao.delete(objeto);
    }
}
