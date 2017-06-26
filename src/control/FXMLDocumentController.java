/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.JDBC.ConnectionFactory;
import model.JDBC.UsuarioDAO;
import model.Usuario;
import view.manage.Cadastrarabre;
import view.manage.Mensagemabre;
import view.manage.ProgramaTm;

/**
 *
 * @author None
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label Lbtitulo;
    
    @FXML
    private Label Lbmensag;
    
    @FXML
    private TextField tflogin;
    
    @FXML
    private PasswordField pfsenha;
    
    @FXML
    private Button btentrar;
        
    @FXML
    private Button btcadast;
    
    @FXML
    private ImageView Ivsimbolo;
    
    
    
    
    public void logar(){
        
        try {
            UsuarioDAO dao = new UsuarioDAO();
            ObservableList<Usuario> users = dao.selectUsuario();
            for (int i = 0; i < users.size(); i++) {
                if (tflogin.getText().equals(users.get(i).getLogin())) {
                    if (pfsenha.getText().equals(users.get(i).getSenha())) {
                        
                        String nome,login,senha,nascimento, foto;
                        boolean adm, usua;
                        int id_usuario;
                        nome = users.get(i).getNome();
                        foto = users.get(i).getFoto();
                        senha = users.get(i).getSenha();
                        nascimento = users.get(i).getNascimento();
                        login = users.get(i).getLogin();
                        id_usuario = users.get(i).getId_usuario();
                        adm = users.get(i).isAdm();
                        usua = users.get(i).isUsua();
                        Usuario usuario = new Usuario(nome, login, senha, nascimento, foto, id_usuario, adm, usua);
                        
                        ProgramaTm p1 = new ProgramaTm();
                        Mensagemabre m1 = new Mensagemabre();
                        m1.abreTela();
                        p1.fecharTela();
                        
                        i = users.size();
                    }
                } else if (i + 1 == users.size()) {
                    Alert erro = new Alert(Alert.AlertType.ERROR);
                    erro.setHeaderText("Login ou senha incorretos!!!");
                    erro.show();
                }
            }
            
        } catch (Exception ee) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ee);
        }
    }
        
    
    
    
    
    public void SetImagem(){       
    String caminho = "imagens\\lara.png";
    Image image = new Image("file:///" + caminho);
    Ivsimbolo.setImage(image);
 
    }
    
    public void acaoDoBotao(){
        btcadast.setOnMouseClicked(value->{
            Cadastrarabre c1 = new Cadastrarabre();
            c1.abreTela();
            
        });
        
    }
    
    public void acaoBotao(){
        btentrar.setOnMouseClicked(value->{

            logar();
                          
            
        });
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        acaoDoBotao();
        acaoBotao();
        SetImagem();
        logar();
    }    
    
}
