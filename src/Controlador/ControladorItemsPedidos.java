
package Controlador;

import DAO.ItemsPedidosDAO;
import Persistencia.ItemPedido;
import Persistencia.Pedido;
import java.sql.ResultSet;
import javax.swing.JTextField;

public class ControladorItemsPedidos {

    ItemsPedidosDAO ID = new ItemsPedidosDAO();
    
    
    public void adicionaItem (ItemPedido itemPedido ){
        ID.adicionaItem(itemPedido);
    }
    public void AchaCodPedido (Pedido ped){
        ID.achaCodPedido(ped);
    }
    public ResultSet listarItemPedido (ItemPedido itemPedido){
        ResultSet rs = ID.BuscarCodigo(itemPedido);
        return rs;
    }
    public void CalculaTotal(JTextField TxtTotalPedido, ItemPedido itemPedido, Pedido ped){
        ID.CalculaTotal(TxtTotalPedido, itemPedido, ped);
    }
    
}
