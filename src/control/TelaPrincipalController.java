
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import model.Usuario;
import view.manage.Analiseabre;
import view.manage.Contasabre;
import view.manage.Graficosabre;
import view.manage.Perfilabre;
import view.manage.ProgramaTm;
import view.manage.ajudaabre;
import view.manage.economiaabre;
import view.manage.listausuarioabre;
import view.manage.telaprincipalabre;


public class TelaPrincipalController implements Initializable {
   

    @FXML private Label lbconta;    
    @FXML private Label lbanalise;    
    @FXML private Label lbeconomia;  
    ////////////////////////////////////////////////////////////////
    @FXML private Button btconta;    
    @FXML private Button btanalise;   
    @FXML private Button bteconomia;   
    @FXML private Button btperfil;    
    @FXML private Button btusuario;   
    @FXML private Button btgrafico;   
    //////////////////////////////////////////////////////////////
    @FXML private MenuBar Mbmenu;    
    @FXML private Menu Mnperfil;   
    @FXML private Menu Mngrafico;    
    @FXML private Menu Mnajuda;    
    @FXML private MenuItem Miajudaaopc;    
    @FXML private MenuItem Mivisuperfi;   
    @FXML private MenuItem Mivigrafico;    
    @FXML private MenuItem miusuarios;   
    @FXML private Button btsair;
    
    ///////////////////////////////////////////////////////////////////
    
    private static Usuario log;

 
    public static Usuario getLog() {
        return log;
    }

    public static void setLog(Usuario aLog) {
        log = aLog;
    }
    
    public void Usuarios(){
        
            if(log.isAdm() == true){
            
            listausuarioabre l1 = new listausuarioabre();
            l1.abreTela();
            
        }
            else{
                Alert erro = new Alert(Alert.AlertType.ERROR);
                    erro.setHeaderText("Seu usuario não possui a pemissão para acessar esta função!!!");
                    erro.show();
                
            }
        
         
        
    }
    
    public void Sair(){
        btsair.setOnAction(value->{
            
                
                switch (JOptionPane.showConfirmDialog(null, "Deseja realmente sair?")) {
            case 0:
                
                telaprincipalabre t1 = new telaprincipalabre();
                t1.fecharTela();
                ProgramaTm p1 = new ProgramaTm();
                p1.abreTela();
                break;
            case 1:
                
                break;
            case 2:
                
                break;
                }
            
        });
        
        
    }

  

    public void acaoEconomia(){
          
            economiaabre e = new economiaabre();
            e.abreTela();
  
    }
    
    
    
    
    public void acaoAjuda(){
        
            ajudaabre a = new ajudaabre();
            a.abreTela();
       
        
    }
    
    public void acaoGrafico(){
       
            Graficosabre g1 = new Graficosabre(log);
            g1.abreTela();
     
    }
    
    
    
    
    public void acaoContas(){
        
        
            Contasabre c1 = new Contasabre(log);           
            c1.abreTela();
    
    }
    
    public void acaoAnalise(){
       
            Analiseabre a1 = new Analiseabre(log);
            
            a1.abreTela();
     
    }
    
    
    public void acaoDoPerfil(){
        
            Perfilabre p1 = new Perfilabre(log);
            p1.abreTela();
     
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Sair();       
        
        btperfil.setOnAction(value->{
            acaoDoPerfil();            
        });
        
        btusuario.setOnAction(value->{
            Usuarios();           
        });
        
        btgrafico.setOnAction(value->{
            acaoGrafico();           
        });
        
        miusuarios.setOnAction(value->{
            Usuarios();
        });
        
        bteconomia.setOnMouseClicked(value->{
            acaoEconomia();
         });
        
        Miajudaaopc.setOnAction(value->{
            acaoAjuda();
         });
        
         Mivigrafico.setOnAction(value->{
            acaoGrafico();
         });   
         
         btconta.setOnMouseClicked(value->{
            acaoContas();
         });
         
          btanalise.setOnMouseClicked(value->{
           acaoAnalise();
         });  
          
          Mivisuperfi.setOnAction(value->{
            acaoDoPerfil();
         });   

    }    
    
}
