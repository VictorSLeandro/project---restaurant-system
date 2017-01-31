

package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoDAO {
    
    
    Connection dbconn;
    Statement stmt;
    ResultSet rs;
   
  PreparedStatement std;  
  String url = "jdbc:mysql://127.0.0.1:3306/DB_SGRPM";
  String drive = "com.mysql.jdbc.Driver";
  String user = "root";
  String pass = "13d8xhh96";
    
      public void conecta () {
          
          
          try 
          {
           Class.forName(drive).newInstance();
           dbconn = DriverManager.getConnection(url, user, pass);
           stmt = dbconn.createStatement();
              
          }
          catch(ClassNotFoundException e){
          
              JOptionPane.showMessageDialog(null,"Erro ao Carregar o Driver");
              
          }
          catch (SQLException e){
              JOptionPane.showMessageDialog(null,"Erro ao Conectar com o BD");
              
          } catch (InstantiationException ex) {
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          
      }
    
      public void fecharConexao ()
      {
          
          try {
              //se a conexao não estiver fechada, ele ira fechar ela 
              
              if (!dbconn.isClosed()){
                  dbconn.close();
              }
          }
          catch (SQLException e){
              
              JOptionPane.showMessageDialog(null,"Erro ao fechar conexão");
          }
          
      }
      
      public Connection obterConexao (){
          
          conecta();
          return  dbconn;
      }
   
}
