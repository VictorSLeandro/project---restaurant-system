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
public class TabelaAuxiliar {
     
    private int codigo;
    private int codCliente;
    private int codItemPedido;
    private double total;
    private double subTotal;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the codigoCliente
     */
    public int getCodigoCliente() {
        return codCliente;
    }

    /**
     * @param codigoCliente the codigoCliente to set
     */
    public void setCodigoCliente(int codigoCliente) {
        this.codCliente = codigoCliente;
    }

    /**
     * @return the codItemPedido
     */
    public int getCodItemPedido() {
        return codItemPedido;
    }

    /**
     * @param codItemPedido the codItemPedido to set
     */
    public void setCodItemPedido(int codItemPedido) {
        this.codItemPedido = codItemPedido;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the subTotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    
    
    
}