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
import model.bo.Funcionario;

/**
 *
 * @author Thiago
 */
public class FuncionarioDao implements  InterfaceDao<Funcionario>{

    @Override
    public void create(Funcionario objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cantinaifsc.funcionario(nome,fone1,fone2,email,status,complementoEndereco,"
                + "cpf,rg,usuario,senha,endereco_id) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
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
            pstm.setString(9, objeto.getUsuario());
            pstm.setString(10, objeto.getSenha());
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
    public List<Funcionario> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select fun.*, e.*, c.*, b.* from funcionario fun  "
                + "left outer join endereco e on fun.endereco_id = e.id "
                + "left outer join cidade c on e.cidade_id = c.id "
                + "left outer join bairro b on e.bairro_id = b.id"
        ;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            while (rst.next()) {
                Funcionario funcionario = new Funcionario();
                
                cliente.setId(rst.getInt("cli.id"));
                cliente.setNome(rst.getString("cli.nome"));
                cliente.setFone1(rst.getString("cli.fone1"));
                cliente.setFone2(rst.getString("cli.fone2"));
                cliente.setEmail(rst.getString("cli.email"));
                cliente.setStatus(rst.getString("cli.status").charAt(0));
                cliente.setComplementoEndereco(rst.getString("cli.complementoEndereco"));
                cliente.setCpf(rst.getString("cli.cpf"));
                cliente.setRg(rst.getString("cli.rg"));
                cliente.setMatricula(rst.getString("cli.matricula"));
                cliente.setDataNascimento(rst.getString("cli.dataNascimento"));
                
            }
        } catch (Exception e) {
        } finally {
        }
    }

    @Override
    public Funcionario retrieve(int parPK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public List<Funcionario> retrieve(String nomeParametro, String parString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Funcionario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Funcionario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Funcionario> retrieve(String parString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
