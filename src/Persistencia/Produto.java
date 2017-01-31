

package Persistencia;

import java.io.File;
import java.sql.Blob;

public class Produto {
    
    private int CodProduto;
    private String categoria;
    private float preco;
    private String descrição;
    private Blob foto;
    private File aquivo;
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
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * @return the descrição
     */
    public String getDescrição() {
        return descrição;
    }

    /**
     * @param descrição the descrição to set
     */
    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    /**
     * @return the foto
     */
    public Blob getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    /**
     * @return the aquivo
     */
    public File getAquivo() {
        return aquivo;
    }

    /**
     * @param aquivo the aquivo to set
     */
    public void setAquivo(File aquivo) {
        this.aquivo = aquivo;
    }
    
    
}
