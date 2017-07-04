/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.manage;

import control.TelaPrincipalController;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Usuario;


public class telaprincipalabre {
    
    private static Stage stage;

    public telaprincipalabre(Usuario alog) {
        
        TelaPrincipalController.setLog(alog);
    }

    public telaprincipalabre() {
    }
    
    public void abreTela() {
        try {
            start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(telaprincipalabre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void fecharTela(){
        
        stage.close();
    }
    

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Tela Principal.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        telaprincipalabre.stage=stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    public void abreTela(Usuario u) {
        TelaPrincipalController.setLog(u);
    }
    
    
}
