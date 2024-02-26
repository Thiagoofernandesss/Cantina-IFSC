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
import model.bo.Funcionario;

/**
 *
 * @author Thiago and Gabrieli
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
                
                funcionario.setId(rst.getInt("fun.id"));
                funcionario.setNome(rst.getString("fun.nome"));
                funcionario.setFone1(rst.getString("fun.fone1"));
                funcionario.setFone2(rst.getString("fun.fone2"));
                funcionario.setEmail(rst.getString("fun.email"));
                funcionario.setStatus(rst.getString("fun.status").charAt(0));
                funcionario.setComplementoEndereco(rst.getString("fun.complementoEndereco"));
                funcionario.setCpf(rst.getString("fun.cpf"));
                funcionario.setRg(rst.getString("fun.rg"));
                funcionario.setUsuario("fun.usuario");
                funcionario.setSenha("fun.senha");
                
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
                funcionario.setEndereco(endereco);
                
                listaFuncionarios.add(funcionario);
            }
         } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaFuncionarios;
        }
    }

    @Override
    public Funcionario retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select fun.*,e.*, c.*, b.* from funcionario fun  "
                + "left outer join endereco e on fun.endereco_id = e.id "
                + "left outer join cidade c on e.cidade_id = c.id "
                + "left outer join bairro b on e.bairro_id = b.id where fun.id = ?";

        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        Funcionario funcionario = new Funcionario();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();
            
            while (rst.next()) {
                
                funcionario.setId(rst.getInt("fun.id"));
                funcionario.setNome(rst.getString("fun.nome"));
                funcionario.setFone1(rst.getString("fun.fone1"));
                funcionario.setFone2(rst.getString("fun.fone2"));
                funcionario.setEmail(rst.getString("fun.email"));
                funcionario.setStatus(rst.getString("fun.status").charAt(0));
                funcionario.setComplementoEndereco(rst.getString("fun.complementoEndereco"));
                funcionario.setCpf(rst.getString("fun.cpf"));
                funcionario.setRg(rst.getString("fun.rg"));
                funcionario.setUsuario("fun.usuario");
                funcionario.setSenha("fun.senha");
                
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
                funcionario.setEndereco(endereco);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return funcionario;
        }
    }


    public List<Funcionario> retrieve(String nomeParametro, String parString) {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar = "select fun.*, e.*, c.*, b.* from funcionario fun  "
                + "left outer join endereco e on fun.endereco_id = e.id "
                + "left outer join cidade c on e.cidade_id = c.id "
                + "left outer join bairro b on e.bairro_id = b.id where fun." + nomeParametro + " like ?";

        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1,"%"+ parString +"%");
            rst = pstm.executeQuery();
            while (rst.next()) {
                Funcionario funcionario  = new Funcionario();

                funcionario.setId(rst.getInt("fun.id"));
                funcionario.setNome(rst.getString("fun.nome"));
                funcionario.setFone1(rst.getString("fun.fone1"));
                funcionario.setFone2(rst.getString("fun.fone2"));
                funcionario.setEmail(rst.getString("fun.email"));
                funcionario.setStatus(rst.getString("fun.status").charAt(0));
                funcionario.setComplementoEndereco(rst.getString("fun.complementoEndereco"));
                funcionario.setCpf(rst.getString("fun.cpf"));
                funcionario.setRg(rst.getString("fun.rg"));
                funcionario.setUsuario(rst.getString("fun.usuario"));
                funcionario.setSenha(rst.getString("fun.senha"));

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

                funcionario.setEndereco(endereco);

                listaFuncionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaFuncionarios;
        }
    }
    
    public Funcionario retrieveNome(String parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select fun.*,e.*, c.*, b.* from funcionario fun  "
                + "left outer join endereco e on fun.endereco_id = e.id "
                + "left outer join cidade c on e.cidade_id = c.id "
                + "left outer join bairro b on e.bairro_id = b.id where fun.nome = ?";

        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        Funcionario funcionario = new Funcionario();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, parPK);
            rst = pstm.executeQuery();
            
            while (rst.next()) {
                
                funcionario.setId(rst.getInt("fun.id"));
                funcionario.setNome(rst.getString("fun.nome"));
                funcionario.setFone1(rst.getString("fun.fone1"));
                funcionario.setFone2(rst.getString("fun.fone2"));
                funcionario.setEmail(rst.getString("fun.email"));
                funcionario.setStatus(rst.getString("fun.status").charAt(0));
                funcionario.setComplementoEndereco(rst.getString("fun.complementoEndereco"));
                funcionario.setCpf(rst.getString("fun.cpf"));
                funcionario.setRg(rst.getString("fun.rg"));
                funcionario.setUsuario("fun.usuario");
                funcionario.setSenha("fun.senha");
                
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
                funcionario.setEndereco(endereco);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return funcionario;
        }
    }

    @Override
    public void update(Funcionario objeto) {
        
        Connection conexao = ConnectionFactory.getConnection();
        
        String sqlExecutar = "UPDATE funcionario"
                + " SET "
                + "funcionario.nome = ?, "
                + "funcionario.fone1 = ?, "
                + "funcionario.fone2 = ?, "
                + "funcionario.email = ?, "
                + "funcionario.status = ?, "
                + "funcionario.complementoEndereco = ?, "
                + "funcionario.cpf = ?, "
                + "funcionario.rg = ?, "
                + "funcionario.usuario = ?, "
                + "funcionario.senha = ?, "
                + "funcionario.endereco_id = ? "
                + "WHERE funcionario.id = ?";
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
            pstm.setInt(12, objeto.getId());
            //pstm.setString(12, objeto.getEndereco().getCep());

            //concatenando com "" p/ transfformar em String
            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        } 
    }

    @Override
    public void delete(Funcionario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Funcionario> retrieve(String parString) {
        return null;
    }
    
}
