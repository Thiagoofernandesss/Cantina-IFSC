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
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import model.bo.Fornecedor;

/**
 *
 * @author Thiago and Gabrieli
 */
public class FornecedorDao implements InterfaceDao<Fornecedor>{

    @Override
    public void create(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cantinaifsc.fornecedor(nome,fone1,fone2,email,status,complementoEndereco,"
                + "cnpj,inscricaoEstadual,razaoSocial,endereco_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getStatus() + "");
            pstm.setString(6, objeto.getComplementoEndereco());
            pstm.setString(7, objeto.getCnpj());
            pstm.setString(8, objeto.getInscricaoEstadual());
            pstm.setString(9, objeto.getRazaoSocial());
            pstm.setInt(10, objeto.getEndereco().getId());

            //concatenando com "" p/ transfformar em String
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Fornecedor> retrieve() {
         Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select forn.*, e.*, c.*, b.* from fornecedor forn  "
                + "left outer join endereco e on forn.endereco_id = e.id "
                + "left outer join cidade c on e.cidade_id = c.id "
                + "left outer join bairro b on e.bairro_id = b.id"
        ;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Fornecedor> listaFornecedor = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            while (rst.next()) {
                Fornecedor fornecedor = new Fornecedor();
                
                fornecedor.setId(rst.getInt("forn.id"));
                fornecedor.setNome(rst.getString("forn.nome"));
                fornecedor.setFone1(rst.getString("forn.fone1"));
                fornecedor.setFone2(rst.getString("forn.fone2"));
                fornecedor.setEmail(rst.getString("forn.email"));
                fornecedor.setStatus(rst.getString("forn.status").charAt(0));
                fornecedor.setComplementoEndereco(rst.getString("forn.complementoEndereco"));
                fornecedor.setCnpj(rst.getString("forn.cnpj"));
                fornecedor.setInscricaoEstadual(rst.getString("forn.inscricaoEstadual"));
                fornecedor.setRazaoSocial(rst.getString("forn.razaoSocial"));
                
                Endereco endereco = new Endereco();
                endereco.setId(rst.getInt("e.id"));
                endereco.setCep(rst.getString("e.cep"));
                endereco.setLogradouro(rst.getString("e.logradouro"));
                endereco.setStatus(rst.getString("e.status").charAt(0));

                Cidade cidade = new Cidade();
                cidade.setId(rst.getInt("cidade_id"));
                cidade.setUf(rst.getString("c.uf"));
                cidade.setDescricao(rst.getString("c.descricao"));

                Bairro bairro = new Bairro();
                bairro.setId(rst.getInt("bairro_id"));
                bairro.setDescricao(rst.getString("b.descricao"));

                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                fornecedor.setEndereco(endereco);
                
                listaFornecedor.add(fornecedor);
            }
         } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaFornecedor;
        }
    }

    @Override
    public Fornecedor retrieve(int parPK) {
                Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select forn.*,e.*, c.*, b.* from fornecedor forn  "
                + "left outer join endereco e on forn.endereco_id = e.id "
                + "left outer join cidade c on e.cidade_id = c.id "
                + "left outer join bairro b on e.bairro_id = b.id where forn.id = ?";

        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        Fornecedor fornecedor = new Fornecedor();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();
            
            while (rst.next()) {      
                fornecedor.setId(rst.getInt("forn.id"));
                fornecedor.setNome(rst.getString("forn.nome"));
                fornecedor.setFone1(rst.getString("forn.fone1"));
                fornecedor.setFone2(rst.getString("forn.fone2"));
                fornecedor.setEmail(rst.getString("forn.email"));
                fornecedor.setStatus(rst.getString("forn.status").charAt(0));
                fornecedor.setComplementoEndereco(rst.getString("forn.complementoEndereco"));
                fornecedor.setCnpj(rst.getString("forn.cnpj"));
                fornecedor.setInscricaoEstadual(rst.getString("forn.inscricaoEstadual"));
                fornecedor.setRazaoSocial(rst.getString("forn.razaoSocial"));
                
                Endereco endereco = new Endereco();
                endereco.setId(rst.getInt("e.id"));
                endereco.setCep(rst.getString("e.cep"));
                endereco.setLogradouro(rst.getString("e.logradouro"));
                endereco.setStatus(rst.getString("e.status").charAt(0));

                Cidade cidade = new Cidade();
                cidade.setId(rst.getInt("cidade_id"));
                cidade.setUf(rst.getString("c.uf"));
                cidade.setDescricao(rst.getString("c.descricao"));

                Bairro bairro = new Bairro();
                bairro.setId(rst.getInt("bairro_id"));
                bairro.setDescricao(rst.getString("b.descricao"));

                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                fornecedor.setEndereco(endereco);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return fornecedor;
        }  
    }

    public List<Fornecedor> retrieve(String nomeParametro,String parString) {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar = "select forn.*, e.*, c.*, b.* from fornecedor forn  "
                + "left outer join endereco e on forn.endereco_id = e.id "
                + "left outer join cidade c on e.cidade_id = c.id "
                + "left outer join bairro b on e.bairro_id = b.id where forn." + nomeParametro + " like ?";

        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        List<Fornecedor> listaFornecedor = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1,"%"+ parString +"%");
            rst = pstm.executeQuery();
            
            while (rst.next()) {
                Fornecedor fornecedor = new Fornecedor();
                
                fornecedor.setId(rst.getInt("forn.id"));
                fornecedor.setNome(rst.getString("forn.nome"));
                fornecedor.setFone1(rst.getString("forn.fone1"));
                fornecedor.setFone2(rst.getString("forn.fone2"));
                fornecedor.setEmail(rst.getString("forn.email"));
                fornecedor.setStatus(rst.getString("forn.status").charAt(0));
                fornecedor.setComplementoEndereco(rst.getString("forn.complementoEndereco"));
                fornecedor.setCnpj(rst.getString("forn.cnpj"));
                fornecedor.setInscricaoEstadual(rst.getString("forn.inscricaoEstadual"));
                fornecedor.setRazaoSocial(rst.getString("forn.razaoSocial"));
                
                Endereco endereco = new Endereco();
                endereco.setId(rst.getInt("e.id"));
                endereco.setCep(rst.getString("e.cep"));
                endereco.setLogradouro(rst.getString("e.logradouro"));
                endereco.setStatus(rst.getString("e.status").charAt(0));

                Cidade cidade = new Cidade();
                cidade.setId(rst.getInt("cidade_id"));
                cidade.setUf(rst.getString("c.uf"));
                cidade.setDescricao(rst.getString("c.descricao"));

                Bairro bairro = new Bairro();
                bairro.setId(rst.getInt("bairro_id"));
                bairro.setDescricao(rst.getString("b.descricao"));

                endereco.setBairro(bairro);
                endereco.setCidade(cidade);               
                fornecedor.setEndereco(endereco);
                
                listaFornecedor.add(fornecedor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaFornecedor;
        }    
    }

    @Override
    public void update(Fornecedor objeto) {
               Connection conexao = ConnectionFactory.getConnection();
        
       String sqlExecutar = "UPDATE fornecedor"
                + " SET "
                + "fornecedor.nome = ?, "
                + "fornecedor.fone1 = ?, "
                + "fornecedor.fone2 = ?, "
                + "fornecedor.email = ?, "
                + "fornecedor.status = ?, "
                + "fornecedor.complementoEndereco = ?, "
                + "fornecedor.cnpj = ?, "
                + "fornecedor.inscricaoEstadual = ?, "
                + "fornecedor.razaoSocial = ?, "
                + "fornecedor.endereco_id = ? "
                + "WHERE fornecedor.id = ?";
       
        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getStatus() + "");
            pstm.setString(6, objeto.getComplementoEndereco());
            pstm.setString(7, objeto.getCnpj());
            pstm.setString(8, objeto.getInscricaoEstadual());
            pstm.setString(9, objeto.getRazaoSocial());
            pstm.setInt(10, objeto.getEndereco().getId());
            pstm.setInt(11, objeto.getId());

            //concatenando com "" p/ transfformar em String
            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        } 
    }

    @Override
    public void delete(Fornecedor objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Fornecedor> retrieve(String parString) {
        return null;
    }
    
}
