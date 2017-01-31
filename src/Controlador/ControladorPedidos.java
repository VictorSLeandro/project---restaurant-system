/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import DAO.PedidoDAO;
import DAO.ProdutoDAO;
import Persistencia.Cliente;
import Persistencia.Mesa;
import Persistencia.Pedido;
import Persistencia.Produto;
import Persistencia.TabelaAuxiliar;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author victor
 */
public class ControladorPedidos {
   
    PedidoDAO PD = new PedidoDAO();
    
    public void BuscarProdutoCod (Produto prod){
        PD.BuscarCodProduto(prod);
    }
    public void listarProduto(JComboBox cbm_desc){
         PD.listarProduto(cbm_desc);
    }
    public void AtualizaCodProduto (Produto prod){
        PD.atualizaCodProduto(prod);
    }
    public void ListarCategoria (JComboBox cbm_catProduto){
        PD.listarProdutoCat(cbm_catProduto);
    }
    public void FiltraCategoria (JComboBox cbm_desc, Produto prod){
        PD.FiltraCategoria(cbm_desc, prod);
        
    }
      public void BuscarClienteCPF (Cliente cli,JTextField  TxtCodigoProduto,JTextField TxtNomeCliente, JTextField  TxtQuant, JTextField  txtHora, JTextField  txtPrecoProd, JButton btnAddItem, JTextField TxtObs){
        PD.BuscarCPFCliente(cli, TxtCodigoProduto, TxtNomeCliente, TxtQuant, txtHora, txtPrecoProd, btnAddItem, TxtObs);
    }
      public void EscolhaDaMesa (JLabel lblNumMesa, Mesa me){
          PD.EscolhaDaMesa(lblNumMesa, me);
      }
     public void IniciaVenda (Pedido ped){
         PD.IniciaPedido(ped);
     }
     public void BuscaPedido (Pedido ped, Cliente cli,JButton btnGerarPedido,
        JButton btnFinalizaPedido, JFormattedTextField txtHora, JTextField TxtTotalPedido, JTextField TxtCodigoProduto, JTextField TxtQuant, JComboBox cbm_desc,JComboBox cbm_catProduto,JButton btnAddItem, JButton  btnNotaCozinha){
          PD.BuscaPedido(ped, cli, btnGerarPedido, btnFinalizaPedido, txtHora, TxtTotalPedido, TxtCodigoProduto, TxtQuant, cbm_desc, cbm_catProduto, btnAddItem, btnNotaCozinha);
     }
     
     public void CadastraPedido (Pedido ped){
         PD.CadastraPedido(ped);
     }
     
    
     public void LimpaPedido (Pedido ped){
         PD.limpaPedido(ped);
     }
}
