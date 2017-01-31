/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Controlador.ControladorItemsPedidos;
import Persistencia.Cliente;
import Persistencia.ItemPedido;
import Persistencia.Login;
import Persistencia.Mesa;
import Persistencia.Pedido;
import Persistencia.Produto;
import Persistencia.TabelaAuxiliar;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author victor
 */
public class PedidoDAO {
    
      Connection dbcon = null;
      //instanciando um objeto a partir da classe ConexaoDAO
      ConexaoDAO conecta = new ConexaoDAO();
      PreparedStatement st;
      Statement start;
      ResultSet rs;
      ControladorItemsPedidos contr_item = new ControladorItemsPedidos();
      
      public void IniciaPedido (Pedido ped){
                        
          dbcon = conecta.obterConexao();
          try {
              PreparedStatement st;
              st = (PreparedStatement) dbcon.prepareStatement("INSERT INTO Pedidos (Total_ped,id_Mesa) VALUES (?,?)");
              
              st.setFloat(1,ped.getTotalPedidos());    
              st.setInt(2, ped.getCodMesa());
              
              int linhaInseridas = st.executeUpdate();
              
              if (linhaInseridas > 0){
                 
                  
              }
              
              else{
                JOptionPane.showMessageDialog(null,"Erro ao Iniciar pedido:");
                //fecha conexão
                conecta.fecharConexao();
              }
              
          }
          catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Erro ao Iniciar Pedido:"+e.getMessage());
          }
      }
      
   
      
      
    public void BuscarCodProduto (Produto prod){
        try{
        //     Statement st;
        ResultSet rs = null;
         dbcon = conecta.obterConexao();
         st = (PreparedStatement) dbcon.prepareStatement("select * from Produto where id_prod = ? " );
         st.setInt(1,prod.getCodProduto());
         rs = st.executeQuery();
         
         rs.first();
         
         prod.setCodProduto(rs.getInt("id_prod"));
         prod.setDescrição(rs.getString("desc_prod"));
         prod.setCategoria(rs.getString("cat_prod"));
         prod.setPreco(rs.getFloat("preco_prod"));
         
        }
        catch(Exception ex ){
            JOptionPane.showMessageDialog(null,"Produto não cadastrado");
        }
    }
    
          public void listarProduto(JComboBox cbm_desc)
    {
        Statement st;
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
         st = dbcon.createStatement();
        rs = st.executeQuery("Select * from Produto");
        cbm_desc.addItem("");
        while(rs.next()){
        
            cbm_desc.addItem(rs.getString("desc_prod"));
        }
            
        
      }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao Listar Produto: "+e.getMessage());
        }
       
    }
         public void atualizaCodProduto (Produto prod){
           try{
        //     Statement st;
        ResultSet rs = null;
         dbcon = conecta.obterConexao();
         st = (PreparedStatement) dbcon.prepareStatement("select * from Produto where desc_prod = ? " );
         st.setString(1,prod.getDescrição());
         rs = st.executeQuery();
         
         rs.first();
        
         prod.setCodProduto(rs.getInt("id_prod"));     
         prod.setCategoria(rs.getString("cat_prod"));
         prod.setPreco(rs.getFloat("preco_prod"));        
      }
        catch(Exception ex ){
            JOptionPane.showMessageDialog(null,"Erro ao Atualizar cod:"+ex.getMessage());
         }      
      }
        public void listarProdutoCat(JComboBox cbm_catProduto)
     {
        Statement st;
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
         st = dbcon.createStatement();
        rs = st.executeQuery("Select * from Produto");
       
        cbm_catProduto.addItem("");
        while(rs.next()){
        
        cbm_catProduto.addItem(rs.getString("cat_prod"));
        }
        
      }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao Carregar:"+e.getMessage());
        }
       
    }
        public void FiltraCategoria(JComboBox cbm_desc, Produto prod)
     {
        
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
         st = (PreparedStatement) dbcon.prepareStatement("select * from Produto where cat_prod = ? " );
         st.setString(1,prod.getCategoria());
        rs = st.executeQuery();
        
        while(rs.next()){
        
        cbm_desc.addItem(rs.getString("desc_prod"));
        
        }
       
        
      }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao Listar por Categoria:"+e.getMessage());
        }
       
    }
      
         public void BuscarCPFCliente (Cliente cli, JTextField  TxtCodigoProduto,JTextField TxtNomeCliente, JTextField  TxtQuant, JTextField  txtHora, JTextField  txtPrecoProd, JButton btnAddItem, JTextField TxtObs){
        try{
        //     Statement st;
        ResultSet rs = null;
         dbcon = conecta.obterConexao();
         st = (PreparedStatement) dbcon.prepareStatement("select * from Cliente where cpf_cli like ? " );
        st.setString(1,"%"+cli.getCpf()+"%");
         rs = st.executeQuery();
         
        if ( rs.first()){
         
         cli.setCodCliente(rs.getInt("id_cli"));
         cli.setNome(rs.getString("nome_cli"));
            
        }
        else {
         
        
        
        }
         
        }
        catch(Exception ex ){
            JOptionPane.showMessageDialog(null,"Cliente não Cadastrado");
        }
    }
         public void EscolhaDaMesa (JLabel lblNumMesa, Mesa me){
           
             me.getNumMesa();             
             lblNumMesa.setText(String.valueOf(me.getNumMesa()));
         }
         public void BuscaPedido (Pedido ped, Cliente cli,JButton btnGerarPedido,
        JButton btnFinalizaPedido,  JFormattedTextField txtHora, JTextField TxtTotalPedido, JTextField TxtCodigoProduto, JTextField TxtQuant, JComboBox cbm_desc,JComboBox cbm_catProduto,JButton btnAddItem, JButton  btnNotaCozinha){
             
         try{
        //     Statement st;
        ResultSet rs = null;
         dbcon = conecta.obterConexao();st = (PreparedStatement) dbcon.prepareStatement("SELECT" +
"     Item_Pedido.`id_IP` AS Item_Pedido_id_IP, " +
"     Item_Pedido.`id_ped` AS Item_Pedido_id_ped, " +
"     Item_Pedido.`id_prod` AS Item_Pedido_id_prod, " +
"     Item_Pedido.`quant_IP` AS Item_Pedido_quant_IP, " +
"     Item_Pedido.`preco_IP` AS Item_Pedido_preco_IP, " +
"     Pedidos.`id_ped` AS Pedidos_id_ped, " +
"     Pedidos.`hora_ped` AS Pedidos_hora_ped, " +
"     Pedidos.`data_ped` AS Pedidos_data_ped, " +
"     Pedidos.`status_ped` AS Pedidos_status_ped, " +
 
"     Pedidos.`id_Mesa` AS Pedidos_id_Mesa, " +
"     Pedidos.`obs_ped` AS Pedidos_obs_ped, " +
"     Pedidos.`Total_ped` AS Pedidos_Total_ped, " +
"     Produto.`id_prod` AS Produto_id_prod, " +
"     Produto.`desc_prod` AS Produto_desc_prod, " +
"     Produto.`cat_prod` AS Produto_cat_prod, " +
"     Produto.`preco_prod` AS Produto_preco_prod, " +
"     Produto.`foto_prod` AS Produto_foto_prod " +
"FROM " +
"     `Pedidos` Pedidos INNER JOIN `Item_Pedido` Item_Pedido ON Pedidos.`id_ped` = Item_Pedido.`id_ped` " +
"     INNER JOIN `Produto` Produto ON Item_Pedido.`id_prod` = Produto.`id_prod` " +
"where id_Mesa = ?");
         
         st.setInt(1,(ped.getCodPedido()));
         rs = st.executeQuery();
         
         if (rs.relative(1)){
         rs.first();
        
         ped.setTotalPedidos(rs.getFloat("Pedidos_Total_ped"));
         btnGerarPedido.setEnabled(false);
          btnFinalizaPedido.setEnabled(true);
                  TxtTotalPedido.setText(String.valueOf(ped.getTotalPedidos()));
                  txtHora.setText(ped.getHora());
                
            ItemPedido itemPedido = new ItemPedido();
            
          TxtCodigoProduto.setEnabled(true);
          TxtQuant.setEnabled(true);
          cbm_catProduto.setEnabled(true);
          cbm_desc.setEnabled(true);
          btnAddItem.setEnabled(true);
           btnNotaCozinha.setEnabled(true);
          
          
         }
         else {
            btnGerarPedido.setEnabled(true);
            btnFinalizaPedido.setEnabled(false);
          
                  txtHora.setText("");
              
                  TxtTotalPedido.setText("");
                  cli.setCodCliente(0);
                  cli.setNome("");
                  cli.setCpf("");
                  
          TxtCodigoProduto.setEnabled(false);
          TxtQuant.setEnabled(false);
          cbm_catProduto.setEnabled(false);
          cbm_desc.setEnabled(false);
          btnAddItem.setEnabled(false);
           btnNotaCozinha.setEnabled(false);
          TxtCodigoProduto.setText("");
          TxtQuant.setText("");
          

         }
        }
        catch(Exception ex ){
            JOptionPane.showMessageDialog(null,"Erro ao Buscar Pedido"+ex);
        }    
             
     }
         
         public void limpaPedido (Pedido ped){
             try {
             
              dbcon = conecta.obterConexao();
              st = (PreparedStatement) dbcon.prepareStatement("UPDATE Pedidos SET data_ped = ? , hora_ped= ?,  obs_ped=? WHERE id_ped = ? ");
             
             
              st.setString(1,"");
              st.setString(2,"");
              st.setString(3,"");                      
              st.setInt(4, ped.getCodPedido());
              int linhasAlteradas = st.executeUpdate();
             
              if (linhasAlteradas > 0){
                  JOptionPane.showMessageDialog(null,"Pedido finalizado com sucesso");                  
              }
              
              else{
                 JOptionPane.showMessageDialog(null,"Erro ao Gerar Pedido");
                        //fecha conexão
                  conecta.fecharConexao();
              }
         }
         catch (Exception ex){
             JOptionPane.showMessageDialog(null,"Erro ao Gerar Pedido:"+ex.getMessage());
         }
             
             
         }
         public void CadastraPedido (Pedido ped){
               try {
             
              dbcon = conecta.obterConexao();
              st = (PreparedStatement) dbcon.prepareStatement("UPDATE Pedidos SET data_ped = ? , hora_ped= ?,  obs_ped=? WHERE id_ped = ? ");
             
             
              st.setString(1,ped.getData());
              st.setString(2,ped.getHora());
             
              st.setString(3,ped.getObeservação());                      
              st.setInt(4, ped.getCodPedido());
              int linhasAlteradas = st.executeUpdate();
             
              if (linhasAlteradas > 0){
                  JOptionPane.showMessageDialog(null,"Pedido gerado com sucesso");                  
              }
              
              else{
                 JOptionPane.showMessageDialog(null,"Erro ao Gerar Pedido");
                        //fecha conexão
                  conecta.fecharConexao();
              }
         }
         catch (Exception ex){
             JOptionPane.showMessageDialog(null,"Erro ao Gerar Pedido:"+ex.getMessage());
         }
      }
           public void ativaCampos(JTextField  TxtCodigoProduto,JTextField TxtNomeCliente, JTextField  TxtQuant, JTextField  txtHora, JTextField  txtPrecoProd, JButton btnAddItem, JTextField TxtObs  ){
      
    }
           public void StatusMesa(Mesa me){
                        
          dbcon = conecta.obterConexao();
          try {
              PreparedStatement st;
              st = (PreparedStatement) dbcon.prepareStatement("UPDATE Mesa SET situa_mesa = ?  where id_Mesa = ? ;");
              
             st.setString(1,me.getStatus());
              st.setInt(2,me.getCodigoMesa());    
             
              int linhaInseridas = st.executeUpdate();
              
              if (linhaInseridas > 0){
                 
                  
              }
              
              else{
                JOptionPane.showMessageDialog(null,"Erro ao mudar status da mesa:");
                //fecha conexão
                conecta.fecharConexao();
              }
              
          }
          catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Erro ao mudar status da mesa:"+e.getMessage());
          }
      } 
           public ImageIcon VerificaStatus (Mesa me){
          try{
             ImageIcon ImgSatus =  null;
        //     Statement st;
        ResultSet rs = null;
         dbcon = conecta.obterConexao();
         st = (PreparedStatement) dbcon.prepareStatement("select * from Mesa where id_Mesa = ? " );
         st.setInt(1,me.getCodigoMesa());
         rs = st.executeQuery();
         
         rs.first();
         String status = "aberto";
         if(status.equals(rs.getString("situa_mesa"))){
         
             ImageIcon ImgAberta =  new  ImageIcon(getClass().getResource("/Imagens/mesaaberta.png"));
             return ImgAberta;
         }
         else {
             ImageIcon ImgAberta =  new  ImageIcon(getClass().getResource("/Imagens/mesafechada.png"));
             return ImgAberta;
         }
        }
        catch(Exception ex ){
            JOptionPane.showMessageDialog(null,"Erro iniciar Icone"+ex);
        }
               return null;
           }
           
           public ResultSet CupomFisca (Pedido ped){
                        
        
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("SELECT" +
"     Item_Pedido.`id_IP` AS Item_Pedido_id_IP, " +
"     Item_Pedido.`id_ped` AS Item_Pedido_id_ped, " +
"     Item_Pedido.`id_prod` AS Item_Pedido_id_prod, " +
"     Item_Pedido.`quant_IP` AS Item_Pedido_quant_IP, " +
"     Item_Pedido.`preco_IP` AS Item_Pedido_preco_IP, " +
"     Pedidos.`id_ped` AS Pedidos_id_ped, " +
"     Pedidos.`hora_ped` AS Pedidos_hora_ped, " +
"     Pedidos.`data_ped` AS Pedidos_data_ped, " +
"     Pedidos.`status_ped` AS Pedidos_status_ped, " +
 
"     Pedidos.`id_Mesa` AS Pedidos_id_Mesa, " +
"     Pedidos.`obs_ped` AS Pedidos_obs_ped, " +
"     Pedidos.`Total_ped` AS Pedidos_Total_ped, " +
"     Produto.`id_prod` AS Produto_id_prod, " +
"     Produto.`desc_prod` AS Produto_desc_prod, " +
"     Produto.`cat_prod` AS Produto_cat_prod, " +
"     Produto.`preco_prod` AS Produto_preco_prod, " +
"     Produto.`foto_prod` AS Produto_foto_prod " +
"FROM " +
"     `Pedidos` Pedidos INNER JOIN `Item_Pedido` Item_Pedido ON Pedidos.`id_ped` = Item_Pedido.`id_ped` " +
"     INNER JOIN `Produto` Produto ON Item_Pedido.`id_prod` = Produto.`id_prod` " +
"where id_Mesa = ?");
       st.setInt(1,ped.getCodMesa());
         rs = st.executeQuery();
         
            
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,"Erro ao Buscar Cliente por Nome: "+e.getMessage());
        }
        return rs;
     }  
           public void SalvaTotal (Pedido ped){
                 try {
             
              dbcon = conecta.obterConexao();
              st = (PreparedStatement) dbcon.prepareStatement("UPDATE Pedidos SET total_ped = ?  WHERE id_ped = ? ");
             
             
              st.setFloat(1,ped.getTotalPedidos());
              st.setInt(2, ped.getCodPedido());
              int linhasAlteradas = st.executeUpdate();
             
              if (linhasAlteradas > 0){
                   
              }
              
              else{
                 JOptionPane.showMessageDialog(null,"Erro ao salvar Total");
                        //fecha conexão
                  conecta.fecharConexao();
              }
         }
         catch (Exception ex){
             JOptionPane.showMessageDialog(null,"Erro ao salvar Total:"+ex.getMessage());
         }
           }
           
}
