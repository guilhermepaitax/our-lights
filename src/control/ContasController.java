
package control;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Calcula;
import model.Conta;
import model.JDBC.ContaDAO;
import model.Usuario;

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
    private DatePicker dpdatafatura;
    
    
    
    
    @FXML
    private Button btcadastrar;
    
    @FXML
    private Label Lbmensagem;
    
    
    
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
    private Label lbescolha, lbiluminacao, lbunitario;  
    
    private static Usuario usu;
    
    public void Verde(){
       int kwh =  Integer.parseInt(tfkwhsimu.getText());;
       Calcula c1 = new Calcula();
        double valor = c1.Verde(kwh);
        lbvalorsimu.setText(String.valueOf(valor));
    }
    
    public void Amarelo(){
       int kwh =  Integer.parseInt(tfkwhsimu.getText());;
       Calcula c1 = new Calcula();
        double valor = c1.Amarelo(kwh);
        lbvalorsimu.setText(String.valueOf(valor));
    }
    
     public void Vermelho(){
       int kwh =  Integer.parseInt(tfkwhsimu.getText());;
       Calcula c1 = new Calcula();
        double valor = c1.Vermelho(kwh);
        lbvalorsimu.setText(String.valueOf(valor));
    }

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        ContasController.usu = usu;
    }
    
    
  
    
    
    
    public void cadastra(){
        btcadastrar.setOnMouseClicked(value->{
            
        Valida();
        Conta c1 = new Conta();
        ContaDAO dao = new ContaDAO();
        
        c1.setKwh(Integer.valueOf(tfkwh.getText()));
        c1.setMes(dpdatafatura.getValue());
        c1.setVencimento(dpvencimento.getValue());
        c1.setValor(Double.valueOf(tfvalor.getText()));
        c1.setId_user(usu.getId_usuario());
        
        dao.addConta(c1);
            
            Limpa();
        });
        
    }
    
    public void Limpa(){
        tfvalor.clear();
        tfkwh.clear();
        dpdatafatura.setValue(null);
        dpvencimento.setValue(null);
        
    }
    
    
    public void Valida(){
        
        double valor = Double.valueOf(tfvalor.getText());
        LocalDate mes = dpdatafatura.getValue();
        LocalDate vencimento = dpvencimento.getValue();
        
        if( valor == 0 ){
            Lbmensagem.setText("Erro, Preencher todos os campos");
            Alert erro = new Alert(Alert.AlertType.ERROR);
                    erro.setHeaderText("Erro, Preencher todos os campos!!!");
                    erro.show();
        }
        else{
            
            Lbmensagem.setText("Cadastro concluido!!!");
            Alert concluido = new Alert(Alert.AlertType.INFORMATION);
            concluido.setHeaderText("Cadastro concluido!!!");
            concluido.show();
            
            
        }
        
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             
             cadastra();
             
             btverde.setOnMouseClicked(value->{
                 Verde();                 
             });
             
             btamarelo.setOnMouseClicked(value->{
                 Amarelo();        
             });
             btvermelho.setOnMouseClicked(value->{
                 Vermelho();
             });
    }    
    
}
