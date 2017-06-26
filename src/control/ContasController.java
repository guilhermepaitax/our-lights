
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ContasController implements Initializable {

    @FXML
    private Label Lbcadastrodeconta;
    
    @FXML
    private TabPane Tpmenu;
    
    @FXML
    private TextField tfvalor;
    
    @FXML
    private TextField tfkwh;
    
    @FXML
    private DatePicker dpvencimento;
    
    @FXML
    private TextField tfid;
    
    @FXML
    private MenuButton mbmes;
    
    @FXML
    private ImageView ivconta;
    
    @FXML
    private Button btcadastrar;
    
    @FXML
    private Label Lbcampo1;
    
    @FXML
    private Label Lbcampo2;
    
    @FXML
    private Label Lbcampo3;
    
    @FXML
    private Label Lbcampo4;
    
    @FXML
    private Label Lbmensagem;
    
    @FXML
    private Label Lbajuda;
    
    @FXML
    private ImageView ivbandeira;
    
    @FXML
    private TextField tfkwhsimu;
    
    @FXML
    private Button btverde;
    
    @FXML
    private Button btamarelo;
    
    @FXML
    private Button btvermelho;
    
    @FXML
    private Label lbsimbolodin;
    
    @FXML
    private Label lbvalorsimu;
    
    @FXML
    private Label lbtitulo;
    
    @FXML
    private Label lbexplica;
    
    @FXML
    private MenuItem mijaneiro;
    
    @FXML
    private MenuItem mifevereiro;
    
    @FXML
    private MenuItem mimarco;
    
    @FXML
    private MenuItem miabril;
    
    @FXML
    private MenuItem mimaio;
    
    @FXML
    private MenuItem mijunho;
    
    @FXML
    private MenuItem mijulho;
    
    @FXML
    private MenuItem miagosto;
    
    @FXML
    private MenuItem misetembro;
    
    @FXML
    private MenuItem mioutubro;
    
    @FXML
    private MenuItem minovembro;
    
    @FXML
    private MenuItem midezembro;
    
    @FXML
    private Label lbescolha;
    
    
    
    
    
    public void SetImagem(){       
    String caminho = "imagens\\bandeira.jpg";
    Image image = new Image("file:///" + caminho);
    ivbandeira.setImage(image);
 
    }
    
    public void SetImagem2(){       
    String caminho = "imagens\\Copel.jpg";
    Image image = new Image("file:///" + caminho);
    ivconta.setImage(image);
 
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             SetImagem();
             SetImagem2();
    }    
    
}
