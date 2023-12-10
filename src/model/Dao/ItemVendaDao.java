
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Dao.ConnectionFactory;
import model.Dao.InterfaceDao;
import model.bo.ItemVenda;

public class ItemVendaDao implements InterfaceDao<ItemVenda>{

    @Override
    public void create(ItemVenda objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "insert into cantina.itemvenda(qtdProduto, status, venda_id, produto_id) values (?, ?, ?, ?)";
        
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getQtdProduto());
             pstm.setString(2, objeto.getStatus() + "");
            pstm.setInt(5, objeto.getVenda().getId());
            pstm.setInt(6, objeto.getProduto().getId());
            
            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<ItemVenda> retrieve() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ItemVenda retrieve(int parPK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ItemVenda> retrieve(String parString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ItemVenda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(ItemVenda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<ItemVenda> totalItemVenda(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select * from itemvenda where itemvenda.venda_id=?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<ItemVenda> listaObjeto = new ArrayList<ItemVenda>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                
                ItemVenda objeto = new ItemVenda();
                
                objeto.setId(rst.getInt("id"));
                objeto.setQtdProduto(rst.getInt("qtdProduto"));
                objeto.setStatus(rst.getString("status").charAt(0));
                objeto.setProduto(service.ProdutoService.carregar(rst.getInt("produto_id")));
                objeto.setVenda(service.VendaService.carregar(rst.getInt("venda_id")));
                listaObjeto.add(objeto);
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaObjeto;
        }
    }
    
}
