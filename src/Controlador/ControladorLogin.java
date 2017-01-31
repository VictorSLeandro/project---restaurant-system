/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import DAO.LoginDAO;
import Persistencia.Login;
import java.sql.ResultSet;

/**
 *
 * @author victor
 */
public class ControladorLogin {
    
    LoginDAO loginDAO = new LoginDAO();
    
    public void AcessarSistema (Login lo) {

                 loginDAO.acessarSistema(lo);

         }
    
    
    public void incluirLogin (Login lo) {

                 loginDAO.incluirLogin(lo);

         }

         public void excluirLogin (Login lo) {

                loginDAO.excluirLogin(lo);

        }

         public void alterarLogin (Login lo) {
                    loginDAO.alterarLogin(lo);

                }

         public ResultSet buscarRgLogin (Login lo) {
            ResultSet rs = loginDAO.BuscarCodigo(lo);
            return rs;
            }
       
    public ResultSet listaLogin() {
         ResultSet rs = loginDAO.listarLogin();
         return rs;
    }
    
    
}
