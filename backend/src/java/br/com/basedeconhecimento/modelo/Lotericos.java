
package br.com.basedeconhecimento.modelo;
/**
 *
 * @author André Said
 */
public class Lotericos {
    private Integer id;
    private String sistema;
    private String erro;
    private String formadeacesso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getFormadeacesso() {
        return formadeacesso;
    }

    public void setFormadeacesso(String formadeacesso) {
        this.formadeacesso = formadeacesso;
    }
}
