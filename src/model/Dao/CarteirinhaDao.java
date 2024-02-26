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
import model.bo.Carteirinha;
import model.bo.Cliente;

/**
 *
 * @author Thiago and Gabrieli
 */
public class CarteirinhaDao implements InterfaceDao<Carteirinha>{

    @Override
    public void create(Carteirinha objeto) {
         Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cantinaifsc.carteirinha(codigoBarra,dataGeracao,dataCancelamento,cliente_id)"+
                "VALUES (?, ?, ?, ?)";
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getCodigoBarra());
            pstm.setString(2, objeto.getDataGeracao());
            pstm.setString(3, objeto.getDataCancelamento());
            pstm.setInt(4, objeto.getCliente().getId());
            
            pstm.execute();
        }catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Carteirinha> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select cart.*, b.* from carteirinha cart " +
        "left outer join cliente b on cart.cliente_id = b.id";
        
        PreparedStatement pstm = null;
        ResultSet rst = null;       
        List<Carteirinha> listaCarteirinha = new ArrayList<>();
        
        try{
           pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            while (rst.next()) {
                Carteirinha carteirinha = new Carteirinha();
                
                carteirinha.setId(rst.getInt("cart.id"));
                carteirinha.setCodigoBarra(rst.getString("cart.codigoBarra"));
                carteirinha.setDataGeracao(rst.getString("cart.dataGeracao"));
                carteirinha.setDataCancelamento(rst.getString("cart.dataCancelamento"));
                
                Cliente cliente = new Cliente();
                cliente.setId(rst.getInt("b.id"));
                cliente.setNome(rst.getString("b.nome"));
                cliente.setCpf(rst.getString("b.cpf"));
                
                carteirinha.setCliente(cliente);
            
                listaCarteirinha.add(carteirinha);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaCarteirinha;
        }
    }

    @Override
    public Carteirinha retrieve(int parPK) {
         Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select cart.*, b.* from carteirinha cart " +
        "left outer join cliente b on cart.cliente_id = b.id where cart.id = ?";
        
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        Carteirinha carteirinha = new Carteirinha();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();
            
            while (rst.next()) {                
                carteirinha.setId(rst.getInt("cart.id"));
                carteirinha.setCodigoBarra(rst.getString("cart.codigoBarra"));
                carteirinha.setDataGeracao(rst.getString("cart.dataGeracao"));
                carteirinha.setDataCancelamento(rst.getString("cart.dataCancelamento"));
                
                Cliente cliente = new Cliente();
                cliente.setId(rst.getInt("b.id"));
                cliente.setNome(rst.getString("b.nome"));
                cliente.setCpf(rst.getString("b.cpf"));

                
                carteirinha.setCliente(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return carteirinha;
        }
    }
    
     @Override
    public List<Carteirinha> retrieve(String parString) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar =  "SELECT carteirinha.id, "
                + "carteirinha.codigoBarra, "
                + "carteirinha.dataGeracao, "
                + "carteirinha.dataCancelamento, "
                + "cliente.nome, "
                + "cliente.cpf "
                + "FROM cantinaifsc.carteirinha "
                + "LEFT OUTER JOIN cliente ON cliente.id = carteirinha.cliente_id "
                + "WHERE cliente.nome LIKE ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        List<Carteirinha> listaCarteirinha = new ArrayList<>();
                
        try{
            
             pstm = conexao.prepareStatement(sqlExecutar);
             pstm.setString(1, "%" + parString + "%");
             rst = pstm.executeQuery();
             
             
             while(rst.next()) {
                 Carteirinha carteirinha = new Carteirinha();
                 carteirinha.setId(rst.getInt("id"));
                 carteirinha.setCodigoBarra(rst.getString("codigoBarra"));
                 carteirinha.setDataGeracao(rst.getString("dataGeracao"));
                 carteirinha.setDataCancelamento(rst.getString("dataCancelamento"));
                 
                 Cliente cliente = new Cliente();
                 cliente.setId(rst.getInt("id"));
                 cliente.setNome(rst.getString("nome"));
                 cliente.setCpf(rst.getString("cpf"));
                 
                 carteirinha.setCliente(cliente);
                 
                 listaCarteirinha.add(carteirinha);
                 
             }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }  finally{
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaCarteirinha;
        }
    }
  
    public List<Carteirinha> retrieve(String nomeParametro, String parString) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select cart.*, b.* from carteirinha cart " +
        "left outer join cliente b on cart.cliente_id = b.id where cart." + nomeParametro + " like ?";
        
        PreparedStatement pstm = null;
        ResultSet rst = null;      
        List<Carteirinha> listaCarteirinha = new ArrayList<>();
        
        try {
            
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1,"%"+ parString +"%");
            rst = pstm.executeQuery();
            
            while (rst.next()) {                
                Carteirinha carteirinha = new Carteirinha();
                
                carteirinha.setId(rst.getInt("cart.id"));
                carteirinha.setCodigoBarra(rst.getString("cart.codigoBarra"));
                carteirinha.setDataGeracao(rst.getString("cart.dataGeracao"));
                carteirinha.setDataCancelamento(rst.getString("cart.dataCancelamento"));
                
                Cliente cliente = new Cliente();
                cliente.setId(rst.getInt("b.id"));
                cliente.setNome(rst.getString("b.nome"));
                cliente.setCpf(rst.getString("b.cpf"));
                
                carteirinha.setCliente(cliente);
                
                listaCarteirinha.add(carteirinha);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaCarteirinha;
        }
    }

    @Override
    public void update(Carteirinha objeto) {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar = "UPDATE carteirinha"
                + " SET "
                + "carteirinha.codigoBarra = ?, "
                + "carteirinha.dataGeracao = ?, "
                + "carteirinha.dataCancelamento = ?, "
                + "carteirinha.cliente_id = ? "
                + "WHERE carteirinha.id = ?";
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getCodigoBarra());
            pstm.setString(2, objeto.getDataGeracao());
            pstm.setString(3, objeto.getDataCancelamento());
            pstm.setInt(4, objeto.getCliente().getId());
            pstm.setInt(5, objeto.getId());
            
            pstm.execute();
        }catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Carteirinha objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
