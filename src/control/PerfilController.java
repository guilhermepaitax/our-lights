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
    
    @FXML
    private ImageView ivlampada;
    
    public void SetImagem(){       
    String caminho = "E:\\imagens\\perfil.png";
    Image image = new Image("file:///" + caminho);
    ivlampada.setImage(image);
 
    }
    
    public void colocaInfo(){
        Usuario u1 = new Usuario();
        tfnome.setText(u1.getNome());
        tflogin.setText(u1.getLogin());
        tfdata.setText(u1.getData());
        
        gerenciaImagem gerencia = new gerenciaImagem();
            
            
            Image image = new Image("file:///" + u1.getFoto());
            ivfoto.setImage(image);
    
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SetImagem();
        colocaInfo();
    }    
    
}
