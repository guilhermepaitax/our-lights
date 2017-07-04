
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import view.manage.Mensagemabre;
import view.manage.telaprincipalabre;


public class MensagemController implements Initializable {

    @FXML
    private Label lbtit;
    
    @FXML
    private Label lbtexto;
    
     @FXML
    private Button btok;
     
     public void acaoDoBotao(){
         
         btok.setOnMouseClicked(value->{
                       
             Mensagemabre m1 = new Mensagemabre();
             m1.fecharTela();
             
         });
     }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        acaoDoBotao();
    }    
    
}
