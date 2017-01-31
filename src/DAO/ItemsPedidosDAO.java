
package DAO;

import Persistencia.ItemPedido;
import Persistencia.Pedido;
import Persistencia.Produto;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ItemsPedidosDAO {
    
         
      Connection dbcon = null;
      //instanciando um objeto a partir da classe ConexaoDAO
      ConexaoDAO conecta = new ConexaoDAO();
      PreparedStatement st;
      Statement start;
      ResultSet rs;
      
    
    
         public void  adicionaItem (ItemPedido itemPedido){
             dbcon = conecta.obterConexao();
          try {
              PreparedStatement st;
              st = (PreparedStatement) dbcon.prepareStatement("INSERT INTO Item_Pedido (quant_IP,id_ped,id_prod,preco_IP) VALUES (?,?,?,?)");
              
              st.setFloat(1,itemPedido.getQuantItemPedidos());    
              st.setInt(2, itemPedido.getCodPedido());
              st.setInt(3,itemPedido.getCodProduto());
              st.setFloat(4, itemPedido.getTotal_produto());
              int linhaInseridas = st.executeUpdate();
              
              if (linhaInseridas > 0){
                  
                  
              }
              
              else{
                JOptionPane.showMessageDialog(null,"Erro ao Iniciar Pedido:");
                //fecha conexão
                conecta.fecharConexao();
              }
              
          }
          catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Erro ao Iniciar Pedido:"+e.getMessage());
      }
         }
       
    public void achaCodPedido (Pedido ped){
        try{
        //     Statement st;
        ResultSet rs = null;
         dbcon = conecta.obterConexao();
         st = (PreparedStatement) dbcon.prepareStatement("select * from Pedidos where id_Mesa = ? " );
         st.setInt(1,ped.getCodMesa());
         rs = st.executeQuery();
         
         rs.first();
         
        ped.setCodPedido(rs.getInt("id_ped"));
        
        }
        catch(Exception ex ){
            JOptionPane.showMessageDialog(null,"Erro ao Achar Pedido: "+ex);
        }
    }
    
    
    
      public DefaultTableModel carregarTabela(ResultSet rs)
    {
        String[] colunaTabela=
            new String [] {"Codigo Produto", "Descrição","Quantidade","Preço"};
           DefaultTableModel modelo = new DefaultTableModel (null, colunaTabela);

        try
        {
            rs.previous();
            while(rs.next())
            {
                modelo.addRow(new Object[]{
                rs.getString(3),rs.getString(7),rs.getString(4),rs.getString(5)});
            }
        }
        catch (Exception e)
        {
          JOptionPane.showMessageDialog(null,"Erro na Tabela: " + e);
        }
        
         return modelo;
    }
    
      public ResultSet listarProduto(ItemPedido ip)
    {
        
        ResultSet rs = null;
        try
        {
         
            
            dbcon = conecta.obterConexao();
          dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement ("select * from Item_Pedido where id_ped = ? ");
        st.setInt(1, ip.getCodPedido());
         
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao Iniciar Nota: "+e.getMessage());
        }
       return rs;
    }
       public ResultSet BuscarCodigo (ItemPedido itemPedido){
                        
        
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Item_Pedido inner join Produto on Item_Pedido.id_prod = Produto.id_prod  where id_ped = ? " );
        st.setInt(1,itemPedido.getCodPedido());
         rs = st.executeQuery();
         
            
        }
        catch(Exception e)
        {
            System.out.println("Erro ao Buscar Codigo: "+e.getMessage());
        }
        return rs;
     }   
       public void CalculaTotal(JTextField TxtTotalPedido, ItemPedido itemPedido, Pedido ped)
     {
        
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
         st = (PreparedStatement) dbcon.prepareStatement("select * from Item_Pedido where id_ped = ? " );
         st.setInt(1,itemPedido.getCodPedido());
        
        rs = st.executeQuery();
        float total = 0;
         
        int cont = 0;
        int i = 0;
        while(rs.next()){
           total = total + rs.getFloat("preco_IP");
            
            ped.setTotalPedidos(total);
           
        }
        
        
        if (total>0){
         
        
            TxtTotalPedido.setText(String.valueOf( ped.getTotalPedidos()));
        }
             
           else {
            TxtTotalPedido.setText("");
        }
    }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao Listar por categoria: "+e.getMessage());
        }
       
    }
       public void limpaItemPedido (Pedido ped){
            try 
         {
              dbcon = conecta.obterConexao();
              st = (PreparedStatement) dbcon.prepareStatement("DELETE FROM Item_Pedido WHERE id_ped = ?");
              st.setInt(1,ped.getCodPedido());
              int linhasExcluidas = st.executeUpdate();
              
              if (linhasExcluidas > 0){
                  
                  
              }
              
              else{
                JOptionPane.showMessageDialog(null,"Erro ao limpa item da venda");
                //fecha conexão
                conecta.fecharConexao();
              }
              
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,"Erro ao limpa item da venda"+e);
         }
         
       }
      
}


