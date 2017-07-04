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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.JDBC.UsuarioDAO;
import model.Usuario;
import model.gerenciaImagem;
import view.manage.Perfilabre;
import view.manage.editarusuarioabre;
import view.manage.telaprincipalabre;


public class EditarUsuarioController implements Initializable {


    @FXML private Label lbid;
    @FXML private Label lbnome;
    @FXML private Label lblogin;
    @FXML private Label lbsenha;
    @FXML private Label lbnascimento;
    @FXML private Label lbmostraid;
    //////////////////////////////////
    @FXML private TextField tfsenha;
    @FXML private TextField tfnome;
    @FXML private TextField tflogin;
    @FXML private TextField tfnascimento;
    //////////////////////////////////
    @FXML private ImageView ivfoto;
    
    ///////////////////////////////////
    @FXML private Button btcancelar;    
    @FXML private Button btfoto;
    @FXML private Button bteditar;
    private static Usuario u;
    private Usuario alterado;

    public static Usuario getU() {
        return u;
    }

    public static void setU(Usuario u) {
        EditarUsuarioController.u = u;
    }
    
    public Usuario getAlterado() {
        return alterado;
    }

    public void setAlterado(Usuario alterado) {
        this.alterado = alterado;
    }
    
    
    
    public void initUsuario(){
        tfsenha.setText(u.getSenha());
        tflogin.setText(u.getLogin());
        tfnome.setText(u.getNome());
        tfnascimento.setText(u.getNascimento());
        lbmostraid.setText(String.valueOf(u.getId_usuario()));
                   
        String caminho = u.getFoto();
        Image image = new Image("file:///" + caminho);
        ivfoto.setImage(image);
    
    }
        
    String camin;
    
    public void AcaoDosBotoes(){
            btfoto.setOnMouseClicked(event -> {
            gerenciaImagem gerencia = new gerenciaImagem();
            String caminho = gerencia.getNovaImagem();
            
            Image image = new Image("file:///" + caminho);
            ivfoto.setImage(image);
            
            camin = caminho;
            
    });
    }
    
    public void atualizar(){
   
        boolean adm = u.isAdm(), usuariotipo = u.isUsua();
        int id = u.getId_usuario();
        String nome = tfnome.getText(), login = tflogin.getText() ;
        String foto = camin, senha = tfsenha.getText(), nascimento = tfnascimento.getText();
        
        if(nome != "" || login != "" || senha != "" || nascimento != ""){
            UsuarioDAO dao = new UsuarioDAO();
            Usuario usu = new Usuario();
            usu.setAdm(adm);
            usu.setFoto(foto);
            usu.setId_usuario(id);
            usu.setLogin(login);
            usu.setNascimento(nascimento);
            usu.setNome(nome);
            usu.setNome(nome);
            usu.setSenha(senha);
            usu.setUsua(usuariotipo);
            dao.UpdateUsuario(usu);
            
            alterado = usu;
            setU(alterado);
                Fecha();
                Alert confirma = new Alert(Alert.AlertType.INFORMATION);
            confirma.setHeaderText("Cadastro Atualizado!!!");
            confirma.show();
            
        }
        else{
            Alert confirma = new Alert(Alert.AlertType.ERROR);
            confirma.setHeaderText("Erro: Preencha todos os dados corretamente!!!");
            confirma.show();
        }
        
    }
    
    public void Fecha(){
        
        
        Perfilabre p1 = new Perfilabre(u);
        telaprincipalabre t1 = new telaprincipalabre(u);
        editarusuarioabre e1 = new editarusuarioabre(u);
                e1.fecharTela();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initUsuario();
        
        btcancelar.setOnMouseClicked(value->{
            Fecha();
        });
        
        bteditar.setOnMouseClicked(value->{
            atualizar();
            
        });
        
        AcaoDosBotoes();
    }    
    
}
