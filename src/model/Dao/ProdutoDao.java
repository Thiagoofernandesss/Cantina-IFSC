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
import model.bo.Produto;

/**
 *
 * @author Thiago
 */
public class ProdutoDao implements InterfaceDao<Produto>{

    @Override
    public void create(Produto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cantinaifsc.produto(descricao,codigoBarra,status) VALUES(?,?,?)";
        PreparedStatement pstm = null;
                
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getCodigoBarra());
            pstm.setString(3, objeto.getStatus() + "");
            
            pstm.execute();
        }catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Produto> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "Select produto.id, produto.descricao, produto.codigoBarra, produto.status from produto";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Produto> listaproduto = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            while (rst.next()) {
                Produto produto = new Produto();
                produto.setId(rst.getInt("id"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setCodigoBarra(rst.getString("codigoBarra"));
                produto.setStatus(rst.getString("status").charAt(0));

                listaproduto.add(produto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaproduto;
        }
    }

    @Override
    public Produto retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "Select produto.id, produto.descricao, produto.codigoBarra, produto.status from produto where id= ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Produto produtoParPK = new Produto();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);

            pstm.setInt(1, parPK);
            

            rst = pstm.executeQuery();

            if (rst.next()) {
                produtoParPK.setId(rst.getInt("id"));
                produtoParPK.setDescricao(rst.getString("descricao"));
                produtoParPK.setCodigoBarra(rst.getString("codigoBarra"));
                produtoParPK.setStatus(rst.getString("status").charAt(0));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return produtoParPK;
        }
    }

    @Override
    public List<Produto> retrieve(String parString) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "Select produto.id, produto.descricao, produto.codigoBarra, produto.status from produto where descricao like ?";
        
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Produto> listaProduto = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);

            pstm.setString(1, "%" + parString + "%");

            rst = pstm.executeQuery();

            while(rst.next()){
                Produto produto = new Produto();
                produto.setId(rst.getInt("id"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setCodigoBarra(rst.getString("codigoBarra"));
                produto.setStatus(rst.getString("status").charAt(0));
                listaProduto.add(produto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaProduto;
        }
    }
    
public List<Produto> retrieve(String nomeParametro, String parString) {
    Connection conexao = ConnectionFactory.getConnection();
    String sqlExecutar = "SELECT id, descricao, codigoBarra, status FROM produto WHERE " + nomeParametro + " LIKE ?";

    PreparedStatement pstm = null;
    ResultSet rst = null;
    List<Produto> listaProduto = new ArrayList<>();

    try {
        pstm = conexao.prepareStatement(sqlExecutar);
        pstm.setString(1, "%" + parString + "%");

        rst = pstm.executeQuery();

        while (rst.next()) {
            Produto produto = new Produto();
            produto.setId(rst.getInt("id"));
            produto.setDescricao(rst.getString("descricao"));
            produto.setCodigoBarra(rst.getString("codigoBarra"));
            produto.setStatus(rst.getString("status").charAt(0));
            listaProduto.add(produto);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        ConnectionFactory.closeConnection(conexao, pstm, rst);
    }
    return listaProduto;
}

    @Override
   public void update(Produto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE produto SET descricao = ?, codigoBarra = ?, status = ? WHERE id = ?";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getCodigoBarra());
            pstm.setString(3, objeto.getStatus() + "");
            pstm.setInt(4, objeto.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }


    @Override
    public void delete(Produto objeto) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
