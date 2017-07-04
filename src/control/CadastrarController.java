/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jdk.nashorn.internal.parser.DateParser;
import model.Criptografia;
import model.JDBC.UsuarioDAO;
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
    private TextField tfnascimento;
    
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
            Valida();     
            
     
    });
    }
    public void Limpa(){
        
     tfnome.clear();
     tfloginc.clear();
     tfsenhac.clear();
     cbusua.setSelected(false);
     cbadm.setSelected(false);
     tfnascimento.clear();
     
     
        
    }
    
    
    public void Valida(){
        String nome = tfnome.getText(),senha = tfsenhac.getText(),login = tfloginc.getText();
        boolean adm = cbadm.isSelected(), usu = cbusua.isSelected();
        
        if( login.equals("") || senha.equals("") ||  nome.equals("") ||  adm== true && usu== true || adm == false && usu == false){
            lbmns.setText("Erro: preencher todos os campos!");
            if(adm == true && usu == true || adm == false && usu == false){
            lbmns.setText("Erro: Escolher apenas uma opção!");
            
            
        }
            
        }
                else{
            
            Criptografia cri = new Criptografia();
            
            
            Usuario usuario = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuario.setNome(tfnome.getText());
        usuario.setLogin(tfloginc.getText());
        usuario.setSenha(tfsenhac.getText());
        usuario.setAdm(cbadm.isSelected());
        usuario.setUsua(cbusua.isSelected());
        usuario.setNascimento(tfnascimento.getText());
        usuario.setFoto(camin);
        usuarioDAO.addUsuario(usuario);
            Limpa();
            lbmns.setText("Cadastro com sucesso!");
            Alert concluido = new Alert(Alert.AlertType.INFORMATION);
            concluido.setHeaderText("Cadastro concluido!!!");
            concluido.show();
        }
  
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AcaoDosBotoes();
        acao();
    
    }    
    
}
