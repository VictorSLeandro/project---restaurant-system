/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import DAO.ProdutoDAO;
import Persistencia.Produto;
import java.io.FileInputStream;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author victor
 */
public class ControladorProduto {
 
    
    ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public void incluirProduto (Produto prod,JFileChooser se) {

                 produtoDAO.incluirProduto(prod,se);

         }

         public void excluirProduto (Produto prod) {

                produtoDAO.excluirProduto(prod);

        }

         public void alterarProduto (Produto prod, JFileChooser se) {
                    produtoDAO.alterarProduto(prod,se);

                }

         public ResultSet buscarCodigoProduto (Produto prod) {
            ResultSet rs = produtoDAO.BuscarCodigo(prod);
            return rs;
            }
         public ResultSet buscarCategoriaProduto (Produto prod) {
            ResultSet rs = produtoDAO.BuscarCategoria(prod);
            return rs;
            }
         
    public ResultSet listaProduto() {
         ResultSet rs = produtoDAO.listarProduto();
         return rs;
    }
     
    
}
