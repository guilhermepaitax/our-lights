/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.JDBC.UsuarioDAO;
import model.Usuario;
import model.gerenciaImagem;


public class PerfilController implements Initializable {

    
    @FXML
    private Label lbtitulo;
    
    @FXML
    private Label lbnome;
    
    @FXML
    private Label lblogin;
    
    @FXML
    private Label lbdata;
    
    @FXML
    private TextField tfnome;
    
    @FXML
    private TextField tflogin;
    
    @FXML
    private TextField tfdata;
    
    @FXML
    private ImageView ivfoto;
    
    
    public void SetImagem(){       
    String caminho = "imagens\\perfil.png";
    Image image = new Image("file:///" + caminho);
    ivfoto.setImage(image);
 
    }
    
    public void colocaInfo(){
        UsuarioDAO u1 = new UsuarioDAO();
        Usuario u2 = new Usuario(); 
        u1.selectUsuario();
        
        tfnome.setText(u2.getNome());
        tflogin.setText(u2.getLogin());
        tfdata.setText(u2.getNascimento());
        if(u2.getFoto() != ""){
            
             String caminho = u2.getFoto();
            Image image = new Image("file:///" + caminho);
            ivfoto.setImage(image);
 
    }
            
}
        
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SetImagem();
        colocaInfo();
    }    
    
}
