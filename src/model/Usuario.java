
package model;


public class Usuario {
    
    private String nome,login,senha;
    private boolean tipo1, tipo2;
    private String data, foto;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    

    public String getNome() {
        return nome;
    }

    public boolean isTipo2() {
        return tipo2;
    }

    public void setTipo2(boolean tipo2) {
        this.tipo2 = tipo2;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isTipo1() {
        return tipo1;
    }

    public void setTipo(boolean tipo) {
        this.tipo1 = tipo;
    }
    
}
