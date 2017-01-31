
package Persistencia;

public class Login {
    
    private int CodLogin;
    private String usuario;
    private String senha;
    private String nivel_acesso;
     private long cod_barra;
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the nivel_acesso
     */
    public String getNivel_acesso() {
        return nivel_acesso;
    }

    /**
     * @param nivel_acesso the nivel_acesso to set
     */
    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    /**
     * @return the CodLogin
     */
    public int getCodLogin() {
        return CodLogin;
    }

    /**
     * @param CodLogin the CodLogin to set
     */
    public void setCodLogin(int CodLogin) {
        this.CodLogin = CodLogin;
    }

    /**
     * @return the cod_barra
     */
    public long getCod_barra() {
        return cod_barra;
    }

    /**
     * @param cod_barra the cod_barra to set
     */
    public void setCod_barra(long cod_barra) {
        this.cod_barra = cod_barra;
    }
    
    
}
