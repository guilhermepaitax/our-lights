
package model;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class gerenciaImagem {
    
    public String getNovaImagem(){
            
            String caminhoDaImagem = "E:\\imagens\\perfil.png";
            
            FileChooser telaEscolhoImagem = new FileChooser();
            telaEscolhoImagem.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagens", "*.jpg", "*.jpeg", "*.png"));
            File arquivo = telaEscolhoImagem.showOpenDialog(new Stage());
            caminhoDaImagem = arquivo.getAbsolutePath();
            
            if (arquivo != null) {
                caminhoDaImagem = arquivo.getAbsolutePath();
            }
            

            return caminhoDaImagem;
        }
   
}
