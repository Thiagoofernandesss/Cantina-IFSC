/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Cliente;
import model.bo.Endereco;

/**
 *
 * @author Thiago
 */
public class ClienteDao implements InterfaceDao<Cliente> {

    @Override
    public void create(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cantinaifsc.cliente(nome,fone1,fone2,email,status,complementoEndereco,"
                + "cpf,rg,matricula,dataNascimento,endereco_id) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getStatus() + "");
            pstm.setString(6, objeto.getComplementoEndereco());
            pstm.setString(7, objeto.getCpf());
            pstm.setString(8, objeto.getRg());
            pstm.setString(9, objeto.getMatricula());
            pstm.setString(10, objeto.getDataNascimento());
            pstm.setInt(11, objeto.getEndereco().getId());

            //concatenando com "" p/ transfformar em String
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public List<Cliente> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT cliente.id, "
                + "cliente.nome, "
                + "cliente.fone1, "
                + "cliente.fone2, "
                + "cliente.email, "
                + "cliente.status, "
                + "cliente.complementoEndereco , "
                + "cliente.cpf , "
                + "cliente.rg "
                + "cliente.matricula "
                + "cliente.dataNascimento "
                + "cliente.endereco_id "
                + "endereco.cep"
                + "FROM cliente "
                + " LEFT OUTER JOIN ENDERECO ON ENDERECO.id = CLIENTE.endereco_id ";
        ;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Cliente> listaCliente = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            while (rst.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(rst.getInt("id"));
                cliente.setNome(rst.getString("nome"));
                cliente.setFone1(rst.getString("fone1"));
                cliente.setFone2(rst.getString("fone2"));
                cliente.setEmail(rst.getString("email"));
                cliente.setStatus(rst.getString("status").charAt(0));
                cliente.setComplementoEndereco(rst.getString("complementoEndereco"));
                cliente.setCpf(rst.getString("cpf"));
                cliente.setRg(rst.getString("rg"));
                cliente.setMatricula(rst.getString("matricula"));
                cliente.setDataNascimento(rst.getString("dataNascimento"));

                Endereco endereco = new Endereco();
                endereco.setId(rst.getInt("Endereco_id"));
                endereco.setCep(rst.getString("endereco.cep"));
                endereco.setLogradouro(rst.getString("endereco.logradouro"));
                endereco.setStatus(rst.getString("endereco.status").charAt(0));
                cliente.setEndereco(endereco);

                listaCliente.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaCliente;
        }

    }

    @Override
    public Cliente retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT cliente.id, "
                + "cliente.nome, "
                + "cliente.fone1, "
                + "cliente.fone2, "
                + "cliente.email, "
                + "cliente.status, "
                + "cliente.complementoEndereco , "
                + "cliente.cpf , "
                + "cliente.rg "
                + "cliente.matricula "
                + "cliente.dataNascimento "
                + "cliente.endereco_id "
                + "endereco.cep"
                + "FROM cliente "
                + " LEFT OUTER JOIN ENDERECO ON ENDERECO.id = CLIENTE.endereco_id "
                + " WHERE cliente.id = ? ";

        PreparedStatement pstm = null;
        ResultSet rst = null;

        Cliente cliente = new Cliente();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();

            while (rst.next()) {

                cliente.setId(rst.getInt("id"));
                cliente.setNome(rst.getString("nome"));
                cliente.setFone1(rst.getString("fone1"));
                cliente.setFone2(rst.getString("fone2"));
                cliente.setEmail(rst.getString("email"));
                cliente.setStatus(rst.getString("status").charAt(0));
                cliente.setComplementoEndereco(rst.getString("complementoEndereco"));
                cliente.setCpf(rst.getString("cpf"));
                cliente.setRg(rst.getString("rg"));
                cliente.setMatricula(rst.getString("matricula"));
                cliente.setDataNascimento(rst.getString("dataNascimento"));

                Endereco endereco = new Endereco();
                endereco.setId(rst.getInt("Endereco_id"));
                endereco.setCep(rst.getString("endereco.cep"));
                endereco.setLogradouro(rst.getString("endereco.logradouro"));
                endereco.setStatus(rst.getString("endereco.status").charAt(0));
                cliente.setEndereco(endereco);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return cliente;
        }
    }

    public List<Cliente> retrieve(String nomeParametro, String parString) {

        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar = "SELECT cliente.id, "
                + "cliente.nome, "
                + "cliente.fone1, "
                + "cliente.fone2, "
                + "cliente.email, "
                + "cliente.status, "
                + "cliente.complementoEndereco , "
                + "cliente.cpf , "
                + "cliente.rg "
                + "cliente.matricula "
                + "cliente.dataNascimento "
                + "cliente.endereco_id "
                + "endereco.cep"
                + "FROM cliente "
                + " LEFT OUTER JOIN ENDERECO ON ENDERECO.id = CLIENTE.endereco_id "
                + " WHERE " + nomeParametro + " like ?";

        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Cliente> listaCliente = new ArrayList<>();
        
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            while (rst.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(rst.getInt("id"));
                cliente.setNome(rst.getString("nome"));
                cliente.setFone1(rst.getString("fone1"));
                cliente.setFone2(rst.getString("fone2"));
                cliente.setEmail(rst.getString("email"));
                cliente.setStatus(rst.getString("status").charAt(0));
                cliente.setComplementoEndereco(rst.getString("complementoEndereco"));
                cliente.setCpf(rst.getString("cpf"));
                cliente.setRg(rst.getString("rg"));
                cliente.setMatricula(rst.getString("matricula"));
                cliente.setDataNascimento(rst.getString("dataNascimento"));

                Endereco endereco = new Endereco();
                endereco.setId(rst.getInt("Endereco_id"));
                endereco.setCep(rst.getString("endereco.cep"));
                endereco.setLogradouro(rst.getString("endereco.logradouro"));
                endereco.setStatus(rst.getString("endereco.status").charAt(0));
                cliente.setEndereco(endereco);

                listaCliente.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaCliente;
        }

    }

    @Override
    public void update(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        
        String sqlExecutar = " UPDATE cliente"
                + " SET "
                + " cliente.nome = ?, "
                + " cliente.fone1 = ?, "
                + " cliente.fone2 = ?, "
                + " cliente.email = ?, "
                + " cliente.status = ? "
                + " cliente.complementoEndereco = ? "
                + " cliente.cpf = ? "
                + " cliente.rg = ? "
                + " cliente.matricula = ? "
                + " cliente.dataNascimento = ? "
                + " cliente.endereco_id = ? "
                + " WHERE cliente.id = ?";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getStatus() + "");
            pstm.setString(6, objeto.getComplementoEndereco());
            pstm.setString(7, objeto.getCpf());
            pstm.setString(8, objeto.getRg());
            pstm.setString(9, objeto.getMatricula());
            pstm.setString(10, objeto.getDataNascimento());
            pstm.setInt(11, objeto.getEndereco().getId());

            //concatenando com "" p/ transfformar em String
            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }

        
    }

    @Override
    public void delete(Cliente objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cliente> retrieve(String parString) {
        return null;
    }

}
