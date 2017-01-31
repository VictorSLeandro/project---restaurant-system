
package Persistencia;

import java.util.Date;



public class Pedido {
    
   private int CodPedido;
    private String data;
    private String status;
    private String hora;
    private int CodCliente;
    private int CodMesa;
    private float totalPedidos;
    private String Obeservação;
  
    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the CodCliente
     */
    public int getCodCliente() {
        return CodCliente;
    }

    /**
     * @param CodCliente the CodCliente to set
     */
    public void setCodCliente(int CodCliente) {
        this.CodCliente = CodCliente;
    }

    /**
     * @return the CodMesa
     */
    public int getCodMesa() {
        return CodMesa;
    }

    /**
     * @param CodMesa the CodMesa to set
     */
    public void setCodMesa(int CodMesa) {
        this.CodMesa = CodMesa;
    }

    /**
     * @return the totalPedidos
     */
    public float getTotalPedidos() {
        return totalPedidos;
    }

    /**
     * @param totalPedidos the totalPedidos to set
     */
    public void setTotalPedidos(float totalPedidos) {
        this.totalPedidos = totalPedidos;
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
     * @return the Obeservação
     */
    public String getObeservação() {
        return Obeservação;
    }

    /**
     * @param Obeservação the Obeservação to set
     */
    public void setObeservação(String Obeservação) {
        this.Obeservação = Obeservação;
    }
    
}
