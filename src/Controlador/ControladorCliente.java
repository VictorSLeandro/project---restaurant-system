/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import DAO.ClienteDAO;
import Persistencia.Cliente;
import Persistencia.Mesa;
import java.sql.ResultSet;

/**
 *
 * @author victor
 */
public class ControladorCliente {
    
    ClienteDAO clienteDAO = new ClienteDAO();
    
    public void incluirCliente (Cliente cli) {

                 clienteDAO.incluirCliente(cli);

         }

         public void excluirCliente (Cliente cli) {

                clienteDAO.excluirCliente(cli);

        }

         public void alterarCliente (Cliente cli) {
                    clienteDAO.alterarCliente(cli);

                }

         public ResultSet buscarRgCliente (Cliente cli) {
            ResultSet rs = clienteDAO.BuscarRg(cli);
            return rs;
            }
         public ResultSet buscarCpfCliente (Cliente cli) {
            ResultSet rs = clienteDAO.BuscarCpf(cli);
            return rs;
            }
         public ResultSet buscarNomeCliente (Cliente cli) {
            ResultSet rs = clienteDAO.BuscarNome(cli);
            return rs;
            }
    public ResultSet listaCliente() {
         ResultSet rs = clienteDAO.listarCliente();
         return rs;
    }
    
}
