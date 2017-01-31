/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Persistencia.Cliente;
import Persistencia.Mesa;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victor
 */
public class ClienteDAO {
    
      Connection dbcon = null;
      //instanciando um objeto a partir da classe ConexaoDAO
      ConexaoDAO conecta = new ConexaoDAO();
      PreparedStatement st;
      Statement start;
      ResultSet rs;
    
      
      
        public void incluirCliente (Cliente cli){
                        
          dbcon = conecta.obterConexao();
          try {
              PreparedStatement st;
              st = (PreparedStatement) dbcon.prepareStatement("INSERT INTO Cliente (email_cli,rg_cli,nome_cli,tel_cli,cpf_cli) VALUES (?,?,?,?,?)");
              
              st.setString(1,cli.getEmail());
              st.setString(2,cli.getRg());
              st.setString(3,cli.getNome());
              st.setString(4,cli.getTelefone());
              st.setString(5,cli.getCpf());
              int linhaInseridas = st.executeUpdate();
              
              if (linhaInseridas > 0){
                  JOptionPane.showMessageDialog(null,"Dados do Cliente Inseridos com Sucesso");
                  
              }
              
              else{
                JOptionPane.showMessageDialog(null,"Erro ao Inserir Dados do Cliente");
                //fecha conexão
                conecta.fecharConexao();
              }
              
          }
          catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Erro ao Cadastrar Cliente: "+e.getMessage());
          }
      }
        
        //metodo de excluir carros
     public void excluirCliente (Cliente cli){
         try 
         {
              dbcon = conecta.obterConexao();
              st = (PreparedStatement) dbcon.prepareStatement("DELETE FROM Cliente WHERE id_cli = ?");
              st.setInt(1,cli.getCodCliente());
              int linhasExcluidas = st.executeUpdate();
              
              if (linhasExcluidas > 0){
                  JOptionPane.showMessageDialog(null,"Dados Excluidos com Sucesso");
                  
              }
              
              else{
                JOptionPane.showMessageDialog(null,"Erro ao Excluir Cliente");
                //fecha conexão
                conecta.fecharConexao();
              }
              
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,""+e);
         }
         
     }
    
            public void alterarCliente (Cliente cli){
             
        try {
             
              dbcon = conecta.obterConexao();
              st = (PreparedStatement) dbcon.prepareStatement("UPDATE Cliente SET email_cli = ? , rg_cli= ?, nome_cli= ?, tel_cli= ?, cpf_cli=? WHERE id_cli = ? ");
             
             
              st.setString(1,cli.getEmail());
              st.setString(2,cli.getRg());
              st.setString(3,cli.getNome());
              st.setString(4,cli.getTelefone());
              st.setString(5,cli.getCpf());
              st.setInt(6, cli.getCodCliente());
              int linhasAlteradas = st.executeUpdate();
             
              if (linhasAlteradas > 0){
                  JOptionPane.showMessageDialog(null,"Dados do Cliente Alterado com Sucesso.");
                  
              }
              
              else{
                JOptionPane.showMessageDialog(null,"Erro na Atualização dos Dados do CLiente.");
                        //fecha conexão
                conecta.fecharConexao();
              }
         }
         catch (Exception ex){
             JOptionPane.showMessageDialog(null,"Erro Atualização de Dados :"+ex.getMessage());
         }
     }
           public ResultSet listarCliente()
    {
        Statement st;
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
         st = dbcon.createStatement();
        rs = st.executeQuery("Select * from Cliente");
         
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao Listar Cliente: "+e.getMessage());
        }
        return rs;
    }
           
           
        public ResultSet BuscarRg (Cliente cli){
                        
        
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Cliente where rg_cli  like ? " );
         st.setString(1,"%"+cli.getRg()+"%");
         rs = st.executeQuery();
         
            
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,"Erro ao Buscar Cliente por RG: "+e.getMessage());
        }
        return rs;
     }   
        
            
        public ResultSet BuscarCpf (Cliente cli){
                        
        
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Cliente where cpf_cli like  ? " );
         st.setString(1,"%"+cli.getCpf()+"%");
         rs = st.executeQuery();
         
            
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,"Erro ao Buscar Cliente por CPF: "+e.getMessage());
        }
        return rs;
     }
        
        public ResultSet BuscarNome (Cliente cli){
                        
        
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Cliente where nome_cli like  ? " );
         st.setString(1,"%"+cli.getNome()+"%");
         rs = st.executeQuery();
         
            
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,"Erro ao Buscar Cliente por Nome: "+e.getMessage());
        }
        return rs;
     }
           
           
         public DefaultTableModel carregarTabela(ResultSet rs)
    {
        String[] colunaTabela=
            new String [] {"Codigo", "Email","RG","Nome","Telefone","CPF"};
           DefaultTableModel modelo = new DefaultTableModel (null, colunaTabela);

        try
        {
            rs.previous();
            while(rs.next())
            {
                modelo.addRow(new Object[]{
                rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
            }
        }
        catch (Exception e)
        {
          JOptionPane.showMessageDialog(null,"Erro ao Carregar Tabela: " + e);
        }
        
         return modelo;
    }
      public Boolean achanome(Cliente cli){
          
            
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Cliente where nome_cli = ? " );
         st.setString(1,cli.getNome());
         rs = st.executeQuery();
         
         if (rs.first()){
             return true;
         }
         else {
             return false;
         }
            
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,"Erro ao Buscar Cliente por Nome: "+e.getMessage());
        }
      return null;
      }
        public Boolean achaCPF(Cliente cli){
          
            
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Cliente where cpf_cli = ? " );
         st.setString(1,cli.getCpf());
         rs = st.executeQuery();
         
         if (rs.first()){
             return true;
         }
         else {
             return false;
         }
            
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,"Erro ao Buscar Cliente por Nome: "+e.getMessage());
        }
      return null;
      }
         public Boolean achaEmail(Cliente cli){
          
            
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Cliente where email_cli = ? " );
         st.setString(1,cli.getEmail());
         rs = st.executeQuery();
         
         if (rs.first()){
             return true;
         }
         else {
             return false;
         }
            
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,"Erro ao Buscar Cliente por Nome: "+e.getMessage());
        }
      return null;
      }
          public Boolean achaRG(Cliente cli){
          
            
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Cliente where rg_cli = ? " );
         st.setString(1,cli.getRg());
         rs = st.executeQuery();
         
         if (rs.first()){
             return true;
         }
         else {
             return false;
         }
            
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,"Erro ao Buscar Cliente por Nome: "+e.getMessage());
        }
      return null;
      }
}
