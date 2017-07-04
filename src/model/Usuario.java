
package model;

import java.time.LocalDate;
import java.util.Date;

public class Usuario {
    
      
    private int id_usuario;

    public Usuario(String nome, String login, String senha, String nascimento, String foto, int id_usuario, boolean adm, boolean usua) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.nascimento = nascimento;
        this.foto = foto;
        this.id_usuario = id_usuario;
        this.adm = adm;
        this.usua = usua;
    }

    public Usuario() {
        
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    private String nome,login,senha;
    private boolean adm, usua;
    private String  foto;
    private String nascimento;

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    
    

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    

    public String getNome() {
        return nome;
    }

    public boolean isUsua() {
        return usua;
    }

    public void setUsua(boolean usua) {
        this.usua = usua;
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

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean tipo) {
        this.adm = tipo;
    }
    
}
