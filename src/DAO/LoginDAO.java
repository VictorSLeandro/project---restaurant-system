

package DAO;

import Persistencia.Login;
import Visão.LoginGUI;
import Visão.MenuGUI;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.PreparedStatement;
import java.awt.print.PrinterJob;
import java.io.FileOutputStream;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperPrint;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;



public class LoginDAO {

    
      Connection dbcon = null;
      //instanciando um objeto a partir da classe ConexaoDAO
      ConexaoDAO conecta = new ConexaoDAO();
      PreparedStatement st;
      Statement start;
      ResultSet rs;
    
    public void acessarSistema (Login lo){
        try{
            
        ResultSet rs = null;
         dbcon = conecta.obterConexao();
         st = (PreparedStatement) dbcon.prepareStatement("SELECT * from Login where login = ?");
          st.setString(1,lo.getUsuario());
         rs = st.executeQuery();
         rs.first();
         if((lo.getUsuario().equals(rs.getString("login"))&&((lo.getSenha().equals(rs.getString("senha"))&&((lo.getNivel_acesso().equals(rs.getString("nivel_acesso")))))))){
             
          
             LoginGUI loginGui = new LoginGUI();
           
           
          
           MenuGUI Mengui = new MenuGUI();
           Mengui.setVisible(true);
           String nivelAcesso = rs.getString("nivel_acesso");
           Mengui.PegaDadosNivelAcesso(nivelAcesso);
          
            loginGui.dispose();
           
             
        }
        else {
            JOptionPane.showMessageDialog(null,"Usuario não cadastrado");
        }
    } 
      catch (Exception ex){
          JOptionPane.showMessageDialog(null,"Erro ao Exibir Menu Principal:"+ex);
      }  
    }
    
       public void incluirLogin (Login lo){
                        
          dbcon = conecta.obterConexao();
          try {
              PreparedStatement st;
              st = (PreparedStatement) dbcon.prepareStatement("INSERT INTO Login (login,senha,nivel_acesso,cod_barra) VALUES (?,?,?,?)");
              
              st.setString(1,lo.getUsuario());
              st.setString(2,lo.getSenha());
              st.setString(3,lo.getNivel_acesso());
              st.setLong(4, lo.getCod_barra());
     
              
              int linhaInseridas = st.executeUpdate();
              
              if (linhaInseridas > 0){
                 
                  
              }
              
              else{
                JOptionPane.showMessageDialog(null,"Erro ao inserir dados.");
                //fecha conexão
                conecta.fecharConexao();
              }
              
          }
          catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Erro de Conexão:"+e.getMessage());
          }
      }
        
        //metodo de excluir carros
     public void excluirLogin (Login lo){
         try 
         {
              dbcon = conecta.obterConexao();
              st = (PreparedStatement) dbcon.prepareStatement("DELETE FROM Login WHERE id_log = ?");
              st.setInt(1,lo.getCodLogin());
              int linhasExcluidas = st.executeUpdate();
              
              if (linhasExcluidas > 0){
                  JOptionPane.showMessageDialog(null,"Dados excluidos com sucesso");
                  
              }
              
              else{
                JOptionPane.showMessageDialog(null,"Erro ao Excluir Dados.");
                //fecha conexão
                conecta.fecharConexao();
              }
              
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,""+e);
         }
         
     }
    
            public void alterarLogin (Login lo){
             
        try {
             
              dbcon = conecta.obterConexao();
              st = (PreparedStatement) dbcon.prepareStatement("UPDATE Login SET login = ? , senha= ?, cod_barra = ? WHERE id_log = ? ");
             
             
              st.setString(1,lo.getUsuario());
              st.setString(2,lo.getSenha());     
              st.setLong(3,lo.getCod_barra());
              st.setInt(4,lo.getCodLogin());
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
             JOptionPane.showMessageDialog(null,"Erro de Atualização de Dados :"+ex.getMessage());
         }
     }
           public ResultSet listarLogin()
    {
        Statement st;
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
         st = dbcon.createStatement();
        rs = st.executeQuery("Select * from Login");
         
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao Listar Login:"+e.getMessage());
        }
        return rs;
    }
           
           
            
        public ResultSet BuscarCodigo (Login lo){
                        
        
        ResultSet rs = null;
        try
        {
            dbcon = conecta.obterConexao();
          st = (PreparedStatement) dbcon.prepareStatement("select * from Login where id_log = ? " );
         st.setInt(1,lo.getCodLogin());
         rs = st.executeQuery();
         
            
        }
        catch(Exception e)
        {
            System.out.println("Erro ao Buscar Codigo:"+e.getMessage());
        }
        return rs;
     }
        
           
           
         public DefaultTableModel carregarTabela(ResultSet rs)
    {
        String[] colunaTabela=
            new String [] {"Codigo","Usuario","Senha","Nivel Acesso","Codigo Barra"};
        
           DefaultTableModel modelo = new DefaultTableModel (null, colunaTabela);

        try
        {
            rs.previous();
            while(rs.next())
            {
                modelo.addRow(new Object[]{
                rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
            }
        }
        catch (Exception e)
        {
          JOptionPane.showMessageDialog(null,"Erro ao Carregar Tabela:" + e);
        }
        
         return modelo;
    }
      public void GerarCodigoBarra (JTextField txtCodBarra){
          
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
try {
PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/home/victor/Área de Trabalho/Codigo_Barra_Java_Linha_Codigo.pdf"));
document.open();
PdfContentByte cb = writer.getDirectContent();
BarcodeEAN codeEAN = new BarcodeEAN();
codeEAN.setCodeType(codeEAN.EAN8);
codeEAN.setCode(txtCodBarra.getText());
Image imageEAN = codeEAN.createImageWithBarcode(cb, null, null);
document.add(new Phrase(new Chunk(imageEAN, 0, 0)));
JOptionPane.showMessageDialog(null, "Cartão gerado com sucesso");
}
catch (Exception de) {          
    JOptionPane.showMessageDialog(null, "Erro gerar pdf"+de.getMessage());
}
document.close();

      
      }


    
   
}
