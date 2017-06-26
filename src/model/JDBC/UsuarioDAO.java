
package model.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Usuario;

public class UsuarioDAO {
    
   
 
    
    public void addUsuario(Usuario usuario){
            

        
       String sql = "INSERT INTO usuario (id_usuario, nome, login, senha, nascimento, adm, usua, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
       ConnectionFactory con = new ConnectionFactory(); 
       
       
       try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, usuario.getId_usuario());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getLogin());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getNascimento());
            stmt.setBoolean(6, usuario.isAdm());
            stmt.setBoolean(7, usuario.isUsua());
            stmt.setString(8, usuario.getFoto());
                       
            stmt.execute();
            
            
            System.out.println("Foi");
        } catch (Exception e) {
            System.out.println("Nao foi");
        }
              
    }
    
    
    public ObservableList<Usuario> selectUsuario(){
        ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
        
        
        String sql = "SELECT * FROM usuario";
        
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));             
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNascimento(rs.getString("nascimento"));
                usuario.setAdm(rs.getBoolean("adm"));
                usuario.setUsua(rs.getBoolean("usua"));
                usuario.setFoto(rs.getString("foto"));
                
                usuarios.add(usuario);
                System.out.println("BOM");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ruim");
        }
        
    
        return usuarios;
    }
    
    
    
    
    
}
