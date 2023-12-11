package service;

import java.util.List;
import model.Dao.FuncionarioDao;
import model.bo.Funcionario;

public class FuncionarioService {
    public static void adicionar(Funcionario objeto) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.create(objeto);
    }

    public static List<Funcionario> carregar() {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return funcionarioDao.retrieve();
    }

    public static Funcionario carregar(int parPK) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return funcionarioDao.retrieve(parPK);
    }

    public static List<Funcionario> carregar(String nomeParametro, String parString) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return funcionarioDao.retrieve(nomeParametro, parString);
    }
    
    public static Funcionario carregarFuncionario(String parPK) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return funcionarioDao.retrieveNome(parPK);
    }

    public static void atualizar(Funcionario objeto) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.update(objeto);
    }

    public static void remover(Funcionario objeto) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.delete(objeto);
    }
}
