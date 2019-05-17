
package br.com.basedeconhecimento.modelo;

/**
 *
 * @author André Said
 */
public class Usuario {
    private int idmatricula;
    private String nome,emailstefanini,cpf,funcao,equipe;

    public int getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(int idmatricula) {
        this.idmatricula = idmatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmailstefanini() {
        return emailstefanini;
    }

    public void setEmailstefanini(String emailstefanini) {
        this.emailstefanini = emailstefanini;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }
    
}
