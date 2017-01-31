/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Persistencia.Cliente;
import Persistencia.Funcionario;
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
public class FuncionarioDAO {
       
    
      Connection dbcon = null;
      //instanciando um objeto a partir da classe ConexaoDAO
      ConexaoDAO conecta = new ConexaoDAO();
      PreparedStatement st;
      Statement start;
      ResultSet rs;
      
      
       public void incluirFuncionario (Funcionario fun){
                        
          dbcon = conecta.obterConexao();
          try {
              PreparedStatement st;
              st = (PreparedStatement) dbcon.prepareStatement("INSERT INTO Funcionario (cargo_fun,rg_fun,nome_fun,tel_fun,cpf_fun,sexo_fun,log_fun,num_fun,bairro_fun) VALUES (?,?,?,?,?,?,?,?,?)");
              
              st.setString(1,fun.getCargo());
              st.setString(2,fun.getRg());
              st.setString(3,fun.getNome());
              st.setString(4,fun.getTelefone());
              st.setString(5,fun.getCpf());
              st.setString(6,fun.getSexo());
              st.setString(7,fun.getLogradouro());
              st.setString(8,fun.getNumero());
              st.setString(9,fun.getBairro());
              
              int linhaInseridas = st.executeUpdate();
              
              if (linhaInseridas > 0){
                  JOptionPane.showMessageDialog(null,"Dados inseridos com sucesso");
                  
              }
              
              else{
                JOptionPane.showMessageDialog(null,"Erro ao Inserir Dados do Funcionario.");
                //fecha conexão
                conecta.fecharConexao();
              }
              
          }
          catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Erro de Conexão:"+e.getMessage());
          }
      }
        
        //metodo de excluir carros
     public void excluirFuncionario (Funcionario fun){
         try 
         {
              dbcon = conecta.obterConexao();
              st = (PreparedStatement) dbcon.prepareStatement("DELETE FROM Funcionario WHERE id_fun = ?");
              st.setInt(1,fun.getCodFuncionario());
              int linhasExcluidas = st.executeUpdate();
              
              if (linhasExcluidas > 0){
                  JOptionPane.showMessageDialog(null,"Dados excluidos com sucesso");
                  
              }
              
              else{
                JOptionPane.showMessageDialog(null,"Erro ao Excluir Dados do Funcionario.");
                //fecha conexão
                conecta.fecharConexao();
              }
              
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,""+e);
         }
         
     }
    
            public void alterarFuncionario (Funcionario fun){
             
        try {
             
              dbcon = conecta.obterConexao();
              st = (PreparedStatement) dbcon.prepareStatement("UPDATE Funcionario SET cargo_fun = ? , rg_fun= ?, nome_fun= ?, tel_fun= ?, cpf_fun=?,sexo_fun=?, log_fun=?, num_fun=?, bairro_fun=? WHERE id_fun = ? ");
             
             
              st.setString(1,fun.getCargo());
              st.setString(2,fun.getRg());
              st.setString(3,fun.getNome());
              st.setString(4,fun.getTelefone());        
              st.setString(5,fun.getCpf());
              st.setString(6,fun.getSexo());
              st.setString(7,fun.getLogradouro());
              st.setString(8,fun.getNumero());
              st.setString(9,fun.getBairro());
              st.setInt(10,fun.getCodFuncionario());
              int linhasAlteradas = st.executeUpdate();
             
              if (linhasAlteradas > 0){
                  JOptionPane.showMessageDialog(null,"Dados alterados com sucesso");
                  
              }
              
              else{
                JOptionPane.showMessageDialog(null,"Erro na Atualização");
                        //fecha conexão
                conecta.fecharConexao();
              }
         }
         catch (Exception ex){
             JOptionPane.showMessageDialog(null,"Erro de atualização de dados :"+ex.getMessage());
         }
     } 
            
           public ResultSet listarFuncionario()
    {
        Statement st;
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
         st = dbcon.createStatement();
        rs = st.executeQuery("Select * from Funcionario");
         
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao Listar Funcionario: "+e.getMessage());
        }
        return rs;
    }
           
           
        public ResultSet BuscarRg (Funcionario fun){
                        
        
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Funcionario where rg_fun  like ? " );
         st.setString(1,fun.getRg()+"%");
         rs = st.executeQuery();
         
            
        }
        catch(Exception e)
        {
          JOptionPane.showMessageDialog(null,"Erro ao Buscar RG: "+e.getMessage());
        }
        return rs;
     }   
        
            
        public ResultSet BuscarCpf (Funcionario fun){
                        
        
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Funcionario where cpf_fun like  ? " );
         st.setString(1,fun.getCpf()+"%");
         rs = st.executeQuery();
         
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao Buscar CPF: "+e.getMessage());
        }
        return rs;
     }
        
        public ResultSet BuscarNome (Funcionario fun){
                        
        
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Funcionario where nome_fun like ? " );
         st.setString(1,fun.getNome()+"%");
         rs = st.executeQuery();
         
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao Buscar Nome:"+e.getMessage());
        }
        return rs;
     }
           
           
         public DefaultTableModel carregarTabela(ResultSet rs)
    {
        String[] colunaTabela=
            new String [] {"Codigo", "Cargo","RG","Nome","Telefone","CPF","Sexo","Rua","Numero","Bairro"};
           DefaultTableModel modelo = new DefaultTableModel (null, colunaTabela);

        try
        {
            rs.previous();
            while(rs.next())
            {
                modelo.addRow(new Object[]{
                rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)});
            }
        }
        catch (Exception e)
        {
          JOptionPane.showMessageDialog(null,"Erro ao carregar Tabela: " + e);
        }
        
         return modelo;
    }
    public Boolean achaCPF(Funcionario fun){
          
            
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Funcionario where cpf_fun = ? " );
         st.setString(1,fun.getCpf());
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
             JOptionPane.showMessageDialog(null,"Erro ao confirma registro: "+e.getMessage());
        }
      return null;
      }
   
            public Boolean achaNome(Funcionario fun){
          
            
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Funcionario where nome_fun = ? " );
         st.setString(1,fun.getNome());
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
          public Boolean achaRG(Funcionario fun){
          
            
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Funcionario where rg_fun = ? " );
         st.setString(1,fun.getRg());
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
