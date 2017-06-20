/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Usuario;
import view.manage.Cadastrarabre;
import view.manage.Mensagemabre;
import view.manage.ProgramaTm;

/**
 *
 * @author None
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label Lbtitulo;
    
    @FXML
    private Label Lbmensag;
    
    @FXML
    private TextField tflogin;
    
    @FXML
    private PasswordField pfsenha;
    
    @FXML
    private Button btentrar;
        
    @FXML
    private Button btcadast;
    
    @FXML
    private ImageView Ivsimbolo;
    
    public void SetImagem(){       
    String caminho = "E:\\imagens\\lara.png";
    Image image = new Image("file:///" + caminho);
    Ivsimbolo.setImage(image);
 
    }
    
    public void acaoDoBotao(){
        btcadast.setOnMouseClicked(value->{
            Cadastrarabre c1 = new Cadastrarabre();
            c1.abreTela();
            
        });
        
    }
    
    public void acaoBotao(){
        btentrar.setOnMouseClicked(value->{
            Usuario u1 = new Usuario();
          if(tflogin.getText().equals("admin") && pfsenha.getText().equals("admin")){  
                Mensagemabre m1 = new Mensagemabre();
                m1.abreTela();
            
                ProgramaTm p1 = new ProgramaTm();
                p1.fecharTela();
                
          }
          
          if(tflogin.getText().equals(u1.getLogin()) && pfsenha.getText().equals(u1.getSenha())){
              
              Mensagemabre m1 = new Mensagemabre();
                m1.abreTela();
            
                ProgramaTm p1 = new ProgramaTm();
                p1.fecharTela();
              
          }
          
                else{
              Lbmensag.setText("Login ou senha incorretos!");
          }
                          
            
        });
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        acaoDoBotao();
        acaoBotao();
        SetImagem();
    }    
    
}
