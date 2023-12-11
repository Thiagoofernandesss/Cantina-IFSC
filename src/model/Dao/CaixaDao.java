/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.*;

/**
 *
 * @author gabri
 */
public class CaixaDao implements InterfaceDao<Caixa>{

    @Override
    public void create(Caixa objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cantinaifsc.caixa(dataHoraAbertura,dataHoraFechamento,valorAbertura,valorFechamento,observacao,status,Funcionario_id) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDataHoraAbertura());
            pstm.setString(2, objeto.getDataHoraFechamento());
            pstm.setFloat(3, objeto.getValorAbertura());
            pstm.setFloat(4, objeto.getValorFechamento());
            pstm.setString(5, objeto.getObservaccao());
            pstm.setString(6, objeto.getStatus() + "");
            pstm.setInt(7, objeto.getFuncionario().getId());
        }catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Caixa> retrieve() {
       Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select caixa.*, func.* from caixa caixa "+ 
                "left outer join funcionario func on caixa.Funcionario_id = func.id";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Caixa> listaCaixa = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            while (rst.next()) {
                Caixa caixa = new Caixa();

                caixa.setId(rst.getInt("caixa.id"));
                caixa.setDataHoraAbertura(rst.getString("caixa.dataHoraAbertura"));
                caixa.setDataHoraFechamento(rst.getString("caixa.dataHoraFechamento"));
                caixa.setValorAbertura(rst.getFloat("caixa.valorAbertura"));
                caixa.setValorFechamento(rst.getFloat("caixa.valorFechamento"));
                caixa.setStatus(rst.getString("caixa.status").charAt(0));
                
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rst.getInt("func.id"));
                funcionario.setNome(rst.getString("func.nome"));
                funcionario.setStatus(rst.getString("func.status").charAt(0));

                caixa.setFuncionario(funcionario);

                listaCaixa.add(caixa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaCaixa;
        }
    }

    @Override
    public Caixa retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select caixa.*, func.* from caixa caixa  "
                + "left outer join funcionario func on caixa.Funcionario_id = func.id where caixa.id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        Caixa caixa = new Caixa();
        
         try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();
            
            while (rst.next()) {
                caixa.setId(rst.getInt("caixa.id"));
                caixa.setDataHoraAbertura(rst.getString("caixa.dataHoraAbertura"));
                caixa.setDataHoraFechamento(rst.getString("caixa.dataHoraFechamento"));
                caixa.setValorAbertura(rst.getFloat("caixa.valorAbertura"));
                caixa.setValorFechamento(rst.getFloat("caixa.valorFechamento"));
                caixa.setStatus(rst.getString("caixa.status").charAt(0));
                
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rst.getInt("func.id"));
                funcionario.setNome(rst.getString("func.nome"));
                funcionario.setStatus(rst.getString("func.status").charAt(0));

                caixa.setFuncionario(funcionario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return caixa;
        }
    }
    
    public List<Caixa> retrieve(String nomeParametro, String parString) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select caixa.*, func.* from caixa caixa "
                + "left outer join funcionario func on caixa.Funcionario_id = func.id where caixa." + nomeParametro + " like ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Caixa> listaCaixa = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1,"%"+ parString +"%");
            rst = pstm.executeQuery();
            while (rst.next()) {
                Caixa caixa = new Caixa();

                caixa.setId(rst.getInt("caixa.id"));
                caixa.setDataHoraAbertura(rst.getString("caixa.dataHoraAbertura"));
                caixa.setDataHoraFechamento(rst.getString("caixa.dataHoraFechamento"));
                caixa.setValorAbertura(rst.getFloat("caixa.valorAbertura"));
                caixa.setValorFechamento(rst.getFloat("caixa.valorFechamento"));
                caixa.setStatus(rst.getString("caixa.status").charAt(0));
                
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rst.getInt("func.id"));
                funcionario.setNome(rst.getString("func.nome"));
                funcionario.setStatus(rst.getString("func.status").charAt(0));

                caixa.setFuncionario(funcionario);

                listaCaixa.add(caixa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaCaixa;
        }
    }
    

    @Override
    public void update(Caixa objeto) {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar = "UPDATE caixa"
                + " SET "
                + "caixa.dataHoraAbertura = ?, "
                + "caixa.dataHoraFechamento = ?, "
                + "caixa.valorAbertura = ?, "
                + "caixa.valorFechamento = ?, "
                + "caixa.observacao = ?, "
                + "caixa.status = ?, "
                + "caixa.Funcionario_id = ?"
                + "WHERE caixa.id = ?";
        PreparedStatement pstm = null;
    }

    @Override
    public void delete(Caixa objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List<Caixa> retrieve(String parString) {
        return null;
    }
    
}
