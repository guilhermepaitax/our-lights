
package model.JDBC;

import java.sql.Date;
import java.sql.PreparedStatement;
import model.Conta;
import model.Usuario;


public class ContaDAO {
    
     public void addConta(Conta conta){
            

        
       String sql = "INSERT INTO conta (id_conta, valor, mes, vencimento, kwh) VALUES (?, ?, ?, ?, ?)";
        
       ConnectionFactory con = new ConnectionFactory(); 
       
      
       try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, conta.getId());
            stmt.setDouble(2, conta.getValor());
            stmt.setString(3, conta.getMes());
            stmt.setDate(4, (Date) conta.getVencimento());
            stmt.setInt(5, conta.getKwh());
                       
            stmt.execute();
            
            
            System.out.println("Foi");
        } catch (Exception e) {
            System.out.println("Nao foi");
        }
              
    }
    
    
    
}
