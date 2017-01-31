/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import DAO.FuncionarioDAO;
import Persistencia.Funcionario;
import java.sql.ResultSet;

/**
 *
 * @author victor
 */
public class ControladorFuncionario {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    public void incluirFuncionario (Funcionario fun) {

                 funcionarioDAO.incluirFuncionario(fun);

         }

         public void excluirFuncionario (Funcionario fun) {

                funcionarioDAO.excluirFuncionario(fun);

        }

         public void alterarFuncionario (Funcionario fun) {
                    funcionarioDAO.alterarFuncionario(fun);

                }

         public ResultSet buscarRgFuncionario (Funcionario fun) {
            ResultSet rs = funcionarioDAO.BuscarRg(fun);
            return rs;
            }
         public ResultSet buscarCpfFuncionario (Funcionario fun) {
            ResultSet rs = funcionarioDAO.BuscarCpf(fun);
            return rs;
            }
         public ResultSet buscarNomeFuncionario (Funcionario fun) {
            ResultSet rs = funcionarioDAO.BuscarNome(fun);
            return rs;
            }
    public ResultSet listaFuncionario() {
         ResultSet rs = funcionarioDAO.listarFuncionario();
         return rs;
    }
    
}
