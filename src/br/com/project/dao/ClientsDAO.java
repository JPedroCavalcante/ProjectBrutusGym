package br.com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.model.Clients;
import java.sql.Date;
import java.util.List;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClientsDAO {
    private Connection connection;
    
    public ClientsDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void cadastrarCliente(Clients cli){
        try {
            String sql =
                    "INSERT INTO tb_clientes(nome,cttpemergencia,ddv,cpf,email,celular,cep,endereco,numero,"
                    + "complemento, bairro,cidade,estado)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getCttPEmergencia());
            stmt.setString(3, cli.getDDV());
            stmt.setString(4, cli.getCPF());
            stmt.setString(5, cli.getEmail());
            stmt.setString(6, cli.getCelular());
            stmt.setString(7, cli.getCEP());
            stmt.setString(8, cli.getEndereco());
            stmt.setInt(9, cli.getN());
            stmt.setString(10, cli.getComp());
            stmt.setString(11, cli.getBairro());
            stmt.setString(12, cli.getCidade());
            stmt.setString(13, cli.getUF());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo deu errado! "+ ex);
        }
                 
    }
    
public List<Clients> listarClientes(){
        try {
            List<Clients> lista = new ArrayList<>();            
            String sql = "SELECT * FROM tb_clientes";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Clients cli = new Clients();
                
                cli.setMatricula(rs.getInt("matricula"));
                cli.setNome(rs.getString("nome"));
                cli.setDDV(rs.getString("ddv"));
                cli.setCPF(rs.getString("cpf"));
                cli.setEmail(rs.getString("email"));
                cli.setCelular(rs.getString("celular"));
                cli.setCEP(rs.getString("cep"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setN(rs.getInt("numero"));
                cli.setComp(rs.getString("complemento"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setUF(rs.getString("estado"));
                
                lista.add(cli);
            }
            return lista;         
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ ex);
            return null;
        }
    }
    
    public List<Clients> consultaPorNome(String nome){
        try {
            List<Clients> lista = new ArrayList<>();            
            String sql = "SELECT * FROM tb_clientes WHERE nome like ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Clients cli = new Clients();
                
                cli.setMatricula(rs.getInt("matricula"));
                cli.setNome(rs.getString("nome"));
                cli.setCttPEmergencia(rs.getString("cttpemergencia"));
                cli.setDDV(rs.getString("ddv"));
                cli.setCPF(rs.getString("cpf"));
                cli.setEmail(rs.getString("email"));
                cli.setCelular(rs.getString("celular"));
                cli.setCEP(rs.getString("cep"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setN(rs.getInt("numero"));
                cli.setComp(rs.getString("complemento"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setUF(rs.getString("estado"));
                
                lista.add(cli);
            }
            return lista;         
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ ex);
            return null;
        }
    }
    
    public Clients buscaPorNome(String nome){
        try {
            String sql = "SELECT * FROM tb_clientes WHERE nome = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            
            Clients cli = new Clients();
            
            if(rs.next()){                
                cli.setMatricula(rs.getInt("matricula"));
                cli.setNome(rs.getString("nome"));
                cli.setCttPEmergencia(rs.getString("cttpemergencia"));
                cli.setDDV(rs.getString("ddv"));
                cli.setCPF(rs.getString("cpf"));
                cli.setEmail(rs.getString("email"));
                cli.setCelular(rs.getString("celular"));
                cli.setCEP(rs.getString("cep"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setN(rs.getInt("numero"));
                cli.setComp(rs.getString("complemento"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setUF(rs.getString("estado"));                
            }
            return cli;      
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }
    }
    
    public void excluirCliente(Clients cli){
          try {
                       
            String sql = "DELETE FROM tb_clientes WHERE matricula = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,cli.getMatricula());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!!!");
                                 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ ex);           
        }
        
    }
    
    public void alterarCliente(Clients cli){
         try {
                       
            String sql = "UPDATE tb_clientes SET nome=?, cttpemergencia=?, ddv=?, cpf=?, email=?, "
                    + "celular=?, cep=?, endereco=?, numero=?, "
                    + "complemento=?, bairro=?, cidade=?, estado=?"
                    + " where matricula=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getCttPEmergencia());
            stmt.setString(3, cli.getDDV());
            stmt.setString(4, cli.getCPF());
            stmt.setString(5, cli.getEmail());
            stmt.setString(6, cli.getCelular());
            stmt.setString(7, cli.getCEP());
            stmt.setString(8, cli.getEndereco());
            stmt.setInt(9, cli.getN());
            stmt.setString(10, cli.getComp());
            stmt.setString(11, cli.getBairro());
            stmt.setString(12, cli.getCidade());
            stmt.setString(13, cli.getUF());
            
            stmt.setInt(14, cli.getMatricula());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!");
                                 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ ex);           
        }
    }

    private String format(LocalDate ddv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

