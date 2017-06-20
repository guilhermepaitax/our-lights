/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Usuario;
import model.gerenciaImagem;


public class CadastrarController implements Initializable {

    
    @FXML
    private Label lbcadas;
    
    @FXML
    private Label lbmns;
    
    @FXML
    private TextField tfnome;
    
    @FXML
    private TextField tfloginc;
    
    @FXML
    private TextField tfsenhac;
    
    @FXML
    private TextField tfdata;
    
    @FXML
    private CheckBox cbadm;
    
    @FXML
    private CheckBox cbusua;
    
    @FXML
    private Button btcadast;
    
    @FXML
    private Button btimagen;
    
    @FXML
    private ImageView ivfoto;
    
    String camin;
    
    public void AcaoDosBotoes(){
            btimagen.setOnMouseClicked(event -> {
            gerenciaImagem gerencia = new gerenciaImagem();
            String caminho = gerencia.getNovaImagem();
            
            Image image = new Image("file:///" + caminho);
            ivfoto.setImage(image);
            
            camin = caminho;
            
    });
    }
    public void acao(){
        btcadast.setOnMouseClicked(value->{
                 
        Usuario u1 = new Usuario();
        u1.setTipo(cbadm.isSelected());
        u1.setTipo2(cbusua.isSelected());
        u1.setNome(tfnome.getText());
        u1.setLogin(tfloginc.getText());
        u1.setSenha(tfsenhac.getText());
        u1.setData(tfdata.getText());
        u1.setFoto(camin);
        
            //System.out.println("Login:"+u1.getLogin());
            //System.out.println("Senha:"+u1.getSenha());
            
            
        if(u1.getLogin().equals("") || u1.getSenha().equals("") || u1.getNome().equals("") || u1.getData().equals("") || u1.isTipo1()== true && u1.isTipo2()== true){
            lbmns.setText("Erro: preencher todos os campos!");
            if(u1.isTipo1()== true && u1.isTipo2()== true){
            lbmns.setText("Erro: Escolher apenas uma opção!");
            
        }
        }
        
                else{
            lbmns.setText("Cadastro com sucesso!");
        }
        
    });
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AcaoDosBotoes();
        acao();
    }    
    
}
