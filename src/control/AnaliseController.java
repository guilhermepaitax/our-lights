
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class AnaliseController implements Initializable {

    
    @FXML
    private Label lbtitulo;
    
    @FXML
    private ImageView ivfundo;
    
    @FXML
    private TableView tvtabela;
    
    @FXML
    private TableColumn tcid;
    
    @FXML
    private TableColumn tcvalor;
    
    @FXML
    private TableColumn tcmes;
    
    @FXML
    private TableColumn tckwh;
    
    @FXML
    private TableColumn tcvencimento;
    
    
    public void SetImagem(){       
    String caminho = "imagens\\cool orange and black backgrounds.jpg";
    Image image = new Image("file:///" + caminho);
    ivfundo.setImage(image);
 
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SetImagem();
    }    
    
}
