package service;

import java.util.List;
import model.Dao.ClienteDao;
import model.bo.Cliente;

public class ClienteService {
    public static void adicionar(Cliente objeto) {
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.create(objeto);
    }

    public static List<Cliente> carregar() {
        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.retrieve();
    }

    public static Cliente carregar(int parPK) {
        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.retrieve(parPK);
    }

    public static List<Cliente> carregar(String nomeParametro, String parString) {
        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.retrieve(nomeParametro ,parString);
    }
    
    public static Cliente carregarCPF(String parPK) {
        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.retrieveCPF(parPK);
    }
    
    public static List<Cliente> carregarPorNomeCliente(String nomeParametro, String parString) {
        ClienteDao enderecoDao = new ClienteDao();
        return enderecoDao.retrieve(nomeParametro ,parString);
    }

    public static void atualizar(Cliente objeto) {
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.update(objeto);
    }

    public static void remover(Cliente objeto) {
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.delete(objeto);
    }
}
