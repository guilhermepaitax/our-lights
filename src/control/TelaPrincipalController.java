
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.manage.Analiseabre;
import view.manage.Contasabre;
import view.manage.Perfilabre;


public class TelaPrincipalController implements Initializable {

    @FXML
    private Label lbtitulo;

    @FXML
    private Label lbconta;
    
    @FXML
    private Label lbanalise;
    
    @FXML
    private Label lbeconomia;
    
    @FXML
    private Button btconta;
    
    @FXML
    private Button btanalise;
    
    @FXML
    private Button bteconomia;
    
    @FXML
    private ImageView ivconta;
    
    @FXML
    private ImageView ivanalise;
    
    @FXML
    private ImageView iveconomia;
    
    @FXML
    private ImageView ivfundo;
    
    @FXML
    private MenuBar Mbmenu;
    
    @FXML
    private Menu Mnperfil;
    
    @FXML
    private Menu Mngrafico;
    
    @FXML
    private MenuItem Mivisuperfi;
    
    @FXML
    private MenuItem Mivigrafico;
    
    public void SetImagem(){       
    String caminho = "imagens\\economia.png";
    Image image = new Image("file:///" + caminho);
    iveconomia.setImage(image);
 
    }
    
    public void SetImagem2(){       
    String caminho = "imagens\\analise.png";
    Image image = new Image("file:///" + caminho);
    ivanalise.setImage(image);
 
    }
    
    public void SetImagem3(){       
    String caminho = "imagens\\conta.png";
    Image image = new Image("file:///" + caminho);
    ivconta.setImage(image);
 
    }
    
    public void SetImagem4(){       
    String caminho = "imagens\\fundo2.jpg";
    Image image = new Image("file:///" + caminho);
    ivfundo.setImage(image);
 
    }
    
    public void acaoContas(){
        
        btconta.setOnMouseClicked(value->{
            Contasabre c1 = new Contasabre();
            c1.abreTela();
            
        });
        
        
    }
    
    public void acaoAnalise(){
        btanalise.setOnMouseClicked(value->{
            Analiseabre a1 = new Analiseabre();
            
            a1.abreTela();
            
        });
        
        
    }
    
    
    public void acaoDoPerfil(){
        Mivisuperfi.setOnAction(value->{
            Perfilabre p1 = new Perfilabre();
            p1.abreTela();
            
            
            
        });
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SetImagem();
        SetImagem2();
        SetImagem3();
        SetImagem4();
        acaoDoPerfil();
        acaoContas();
        acaoAnalise();
    }    
    
}
