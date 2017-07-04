/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.JDBC.UsuarioDAO;
import model.Usuario;
import model.gerenciaImagem;
import view.manage.Perfilabre;
import view.manage.editarusuarioabre;


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
    private Button bteditar;
    
    private static Usuario perf;

    public static Usuario getPerf() {
        return perf;
    }

    public static void setPerf(Usuario aperf) {
        perf = aperf;
    }

    
    public void editar(){
        bteditar.setOnAction(value->{
            editarusuarioabre e1 = new editarusuarioabre(perf);
            Perfilabre p1 = new Perfilabre();
            p1.fecharTela();
            e1.abreTela();
        });
        
        
    }

    public void colocainfo(){
        
       
        
        tfnome.setText(perf.getNome());
        tflogin.setText(perf.getLogin());
        tfdata.setText(perf.getNascimento());
       
            String caminho = perf.getFoto();
        Image image = new Image("file:///" + caminho);
        ivfoto.setImage(image); 
            
        }
        
        
    
        

       


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colocainfo();
        editar();
       
    }
    }
    
    
    

