
package view.manage;

import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Conta;
import control.EditarContaController;


public class editarcontaabre {
    
    private static Stage stage;

    public editarcontaabre(Conta selecionado) {
        EditarContaController.setC(selecionado);
        
    }
    
    public void abreTela() {
        try {
            start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(editarcontaabre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void fecharTela(){
        
        stage.close();
    }
    

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/EditarConta.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        editarcontaabre.stage=stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
