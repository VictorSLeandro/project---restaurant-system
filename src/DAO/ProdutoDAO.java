/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Persistencia.Cliente;
import Persistencia.Produto;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victor
 */
public class ProdutoDAO {
    
      Connection dbcon = null;
      //instanciando um objeto a partir da classe ConexaoDAO
      ConexaoDAO conecta = new ConexaoDAO();
      PreparedStatement st;
      Statement start;
      ResultSet rs;
    
       
         public void incluirProduto (Produto prod, JFileChooser se){
                        
          dbcon = conecta.obterConexao();
          try {
              PreparedStatement st;
              st = (PreparedStatement) dbcon.prepareStatement("INSERT INTO Produto (desc_prod,cat_prod,preco_prod,foto_prod,nomefoto_prod) VALUES (?,?,?,?,?)");
              
              st.setString(1,prod.getDescrição());    
              st.setString(2,prod.getCategoria());          
              st.setFloat(3,prod.getPreco());
              st.setString(4,se.getSelectedFile().toString());
              st.setString(5, prod.getAquivo().getName());
              int linhaInseridas = st.executeUpdate();
              
              if (linhaInseridas > 0){
                  JOptionPane.showMessageDialog(null,"Dados Inseridos com sucesso");
                  
              }
              
              else{
                JOptionPane.showMessageDialog(null,"Erro ao Inserir Dados");
                //fecha conexão
                conecta.fecharConexao();
              }
              
          }
          catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Erro de Conexão:"+e.getMessage());
          }
      }
        
        //metodo de excluir carros
     public void excluirProduto (Produto prod){
         try 
         {
              dbcon = conecta.obterConexao();
              st = (PreparedStatement) dbcon.prepareStatement("DELETE FROM Produto WHERE id_prod = ?");
              st.setInt(1,prod.getCodProduto());
              int linhasExcluidas = st.executeUpdate();
              
              if (linhasExcluidas > 0){
                  JOptionPane.showMessageDialog(null,"Dados Excluidos com sucesso");
                  
              }
              
              else{
                JOptionPane.showMessageDialog(null,"Erro ao Excluir Dados");
                //fecha conexão
                conecta.fecharConexao();
              }
              
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,""+e);
         }
         
     }
    
            public void alterarProduto (Produto prod ,JFileChooser se ){
             
        try {
             
              dbcon = conecta.obterConexao();
              st = (PreparedStatement) dbcon.prepareStatement("UPDATE Produto SET desc_prod = ? , cat_prod= ?, preco_prod= ?,foto_prod = ?,nomefoto_prod=? where id_prod = ? ");
             
             
        
              st.setString(1,prod.getDescrição());
              st.setString(2,prod.getCategoria());
              st.setFloat(3,prod.getPreco());              
              st.setString(4, se.getSelectedFile().toString());
              st.setString(5, prod.getAquivo().getName());
              st.setInt(6, prod.getCodProduto());
              
              int linhasAlteradas = st.executeUpdate();
             
              if (linhasAlteradas > 0){
                  JOptionPane.showMessageDialog(null,"Dados alterados com sucesso");
                  
              }
              
              else{
                JOptionPane.showMessageDialog(null,"Erro na Atualização ");
                        //fecha conexão
                conecta.fecharConexao();
              }
         }
         catch (Exception ex){
             JOptionPane.showMessageDialog(null,"Erro de Atulização de Dados :"+ex.getMessage());
         }
     }
           public ResultSet listarProduto()
    {
        Statement st;
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
         st = dbcon.createStatement();
        rs = st.executeQuery("Select * from Produto");
         
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao Listar Produto:"+e.getMessage());
        }
        return rs;
    }
           
           
        public ResultSet BuscarCodigo (Produto prod){
                        
        
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Produto where id_prod = ? " );
         st.setInt(1,prod.getCodProduto());
         rs = st.executeQuery();
         
            
        }
        catch(Exception e)
        {
            System.out.println("Erro ao Buscar Codigo: "+e.getMessage());
        }
        return rs;
     }   
        
            
        public ResultSet BuscarCategoria (Produto prod){
                        
        
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Produto where cat_prod like  ? " );
         st.setString(1,"%"+prod.getCategoria()+"%");
         rs = st.executeQuery();
         
            
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,"Erro ao Buscar Categoria de Produto: "+e.getMessage());
        }
        return rs;
     }
        
         public DefaultTableModel carregarTabela(ResultSet rs)
    {
        String[] colunaTabela=
            new String [] {"Codigo", "Descrição","Categoria","Preço"};
           DefaultTableModel modelo = new DefaultTableModel (null, colunaTabela);

        try
        {
            rs.previous();
            while(rs.next())
            {
                modelo.addRow(new Object[]{
                rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
               
            }
        }
        catch (Exception e)
        {
          JOptionPane.showMessageDialog(null,"Erro ao Carregar Tabela: " + e);
        }
        
         return modelo;
    }
      public ImageIcon getFoto (Produto prod){
        Image ii = null ;
          ImageIcon icon = null;
          try {
          dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Produto where id_prod = ? " );
         st.setInt(1,prod.getCodProduto());
         rs = st.executeQuery();
         if (rs.first()){
              String caminhoImagem = rs.getString("foto_prod");
             URL caminho = new URL ("file:///"+caminhoImagem);
            // is = new ByteArrayInputStream(rs.getString("foto_prod"));
            
           
          //ii =  new  ImageIcon(getClass().getResource(caminhoImagem));
           ii = ImageIO.read(caminho);
          
             icon = new ImageIcon(ii);
            icon.setImage(ii.getScaledInstance(180, 130,Image.SCALE_DEFAULT));
             return icon;
         }
        }       
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Erro carregar foto"+ex);
        }
          return  icon;
      }
    
}
