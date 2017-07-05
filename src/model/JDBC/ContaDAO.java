
package model.JDBC;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Conta;
import model.Usuario;


public class ContaDAO {
    
     public void addConta(Conta conta){
    
       String sql = "INSERT INTO conta ( valor, mes, vencimento, kwh, id_usuario) VALUES ( ?, ?, ?, ?, ?)";
        
       ConnectionFactory con = new ConnectionFactory(); 
       
      
       try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            
            stmt.setDouble(1, conta.getValor());
            stmt.setDate(2,  Date.valueOf(conta.getMes()));
            stmt.setDate(3, Date.valueOf(conta.getVencimento()));
            stmt.setInt(4, conta.getKwh());
            stmt.setInt(5, conta.getId_user());
                       
            stmt.execute();
            
            
           // System.out.println("Foi");
        } catch (Exception e) {
          //  System.out.println("Nao foi");
        }
              
    }
    
    
     public ObservableList<Conta> selectConta(int c){
        ObservableList<Conta> conta = FXCollections.observableArrayList();
        
        
        String sql = "SELECT * FROM conta WHERE id_usuario = ?";
        Date mes,ven;
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, c);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Conta c1 = new Conta();
                c1.setId(rs.getInt("id_conta"));
                c1.setId_user(rs.getInt("id_usuario"));             
                c1.setKwh(rs.getInt("kwh"));
                mes = rs.getDate("mes");
                c1.setMes(mes.toLocalDate());                           
                ven = rs.getDate("vencimento");
                c1.setVencimento(ven.toLocalDate());
                c1.setValor(rs.getDouble("valor"));
                conta.add(c1);
              //  System.out.println("BOM");
            }
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
          //  System.out.println("ruim");
        }
        
    
        return conta;
    }
     
     
     public void delete(Conta c){
        String sql = "DELETE FROM conta WHERE id_conta = ?";
        ConnectionFactory con = new ConnectionFactory();
        try{
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            stm.setInt(1, c.getId());
            stm.execute();
            stm.close();
            
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
     
    
     public void UpdateConta(Conta conta){
    
       String sql = "UPDATE conta SET valor = ?, mes = ?, vencimento = ?, kwh = ?, id_usuario = ? WHERE id_conta = ?;";
        
       ConnectionFactory con = new ConnectionFactory(); 
       
      
       try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            
            stmt.setDouble(1, conta.getValor());
            stmt.setDate(2,  Date.valueOf(conta.getMes()));
            stmt.setDate(3, Date.valueOf(conta.getVencimento()));
            stmt.setInt(4, conta.getKwh());
            stmt.setInt(5, conta.getId_user());
            stmt.setInt(6, conta.getId());
            stmt.execute();
            
            
          //  System.out.println("Foi");
        } catch (Exception e) {
          //  System.out.println("Nao foi");
        }
              
    }
     
     
}
