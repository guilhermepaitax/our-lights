
package model.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Criptografia;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Usuario;

public class UsuarioDAO {
    
   
 
    
    public void addUsuario(Usuario usuario){
    
       String sql = "INSERT INTO usuario ( nome, login, senha, adm, usua, foto, nascimento) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        
       ConnectionFactory con = new ConnectionFactory(); 
       
       
       try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, Criptografia.Criptografando(usuario.getSenha()));           
            stmt.setBoolean(4, usuario.isAdm());
            stmt.setBoolean(5, usuario.isUsua());
            stmt.setString(6, usuario.getFoto());
            stmt.setString(7, usuario.getNascimento());
                       
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            
            System.out.println("Foi");
        } catch (Exception e) {
            System.out.println("Nao foi");
        }
              
    }
    
    
    public ObservableList<Usuario> selectUsuario(){
        ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
        
        
        String sql = "SELECT * FROM usuario";
        Date ota;
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
                usuario.setAdm(rs.getBoolean("adm"));
                usuario.setUsua(rs.getBoolean("usua"));
                usuario.setFoto(rs.getString("foto"));
                usuario.setNascimento(rs.getString("nascimento"));
                usuarios.add(usuario);
                System.out.println("BOM");
            }
            
            con.getConnection().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ruim");
        }
        
    
        return usuarios;
    }
    
    
    public void delete(Usuario u){
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        ConnectionFactory con = new ConnectionFactory();
        try{
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            stm.setInt(1, u.getId_usuario());
            stm.execute();
            stm.close();
            con.getConnection().close();
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    
    public void UpdateUsuario(Usuario usuario){
    
       String sql = "UPDATE usuario SET nome = ?, login = ?, senha = ?, foto = ?, nascimento = ? WHERE id_usuario = ?;";
        
       ConnectionFactory con = new ConnectionFactory(); 
       
       
       try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());           
            stmt.setString(4, usuario.getFoto());
            stmt.setString(5, usuario.getNascimento());
            stmt.setInt(6, usuario.getId_usuario());
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            
            System.out.println("Foi");
        } catch (Exception e) {
            System.out.println("Nao foi");
        }
              
    }
    
}
