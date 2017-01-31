/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

/**
 *
 * @author victor
 */
public class ItemPedido {
    
    private  int CodItemPedidos ;
    private int quantItemPedidos;
    private float total_produto;
    private int CodPedido;
    private int CodProduto;

    /**
     * @return the CodItemPedidos
     */
    public int getCodItemPedidos() {
        return CodItemPedidos;
    }

    /**
     * @param CodItemPedidos the CodItemPedidos to set
     */
    public void setCodItemPedidos(int CodItemPedidos) {
        this.CodItemPedidos = CodItemPedidos;
    }

    /**
     * @return the quantItemPedidos
     */
    public int getQuantItemPedidos() {
        return quantItemPedidos;
    }

    /**
     * @param quantItemPedidos the quantItemPedidos to set
     */
    public void setQuantItemPedidos(int quantItemPedidos) {
        this.quantItemPedidos = quantItemPedidos;
    }

   

    /**
     * @return the CodPedido
     */
    public int getCodPedido() {
        return CodPedido;
    }

    /**
     * @param CodPedido the CodPedido to set
     */
    public void setCodPedido(int CodPedido) {
        this.CodPedido = CodPedido;
    }

    /**
     * @return the CodProduto
     */
    public int getCodProduto() {
        return CodProduto;
    }

    /**
     * @param CodProduto the CodProduto to set
     */
    public void setCodProduto(int CodProduto) {
        this.CodProduto = CodProduto;
    }

    /**
     * @return the total_produto
     */
    public float getTotal_produto() {
        return total_produto;
    }

    /**
     * @param total_produto the total_produto to set
     */
    public void setTotal_produto(float total_produto) {
        this.total_produto = total_produto;
    }
    
    
}
