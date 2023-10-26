package service;

import java.util.List;
import model.Dao.EnderecoDao;
import model.bo.Endereco;

public class EnderecoService {
    public static void adicionar(Endereco objeto) {
        EnderecoDao enderecoDao = new EnderecoDao();
        enderecoDao.create(objeto);
    }

    public static List<Endereco> carregar() {
        EnderecoDao enderecoDao = new EnderecoDao();
        return enderecoDao.retrieve();
    }

    public static Endereco carregar(int parPK) {
        EnderecoDao enderecoDao = new EnderecoDao();
        return enderecoDao.retrieve(parPK);
    }

    public static List<Endereco> carregar(String parString) {
        EnderecoDao enderecoDao = new EnderecoDao();
        return enderecoDao.retrieve(parString);
    }

    public static void atualizar(Endereco objeto) {
        EnderecoDao enderecoDao = new EnderecoDao();
        enderecoDao.update(objeto);
    }

    public static void remover(Endereco objeto) {
        EnderecoDao enderecoDao = new EnderecoDao();
        enderecoDao.delete(objeto);
    }
}
