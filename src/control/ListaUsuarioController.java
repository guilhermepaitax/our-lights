
package control;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.JDBC.ContaDAO;
import model.JDBC.UsuarioDAO;
import model.Usuario;
import view.manage.editarusuarioabre;
import view.manage.listausuarioabre;


public class ListaUsuarioController implements Initializable {


    @FXML private Button btpesquisa;    
    @FXML private Button btexcluir;    
    @FXML private Button btatualizar;
    @FXML private TextField tfpesquisa;
    @FXML private Button bteditar, btpdf;
    ///////////////////////////////////////////////////
    @FXML private TableColumn<Usuario, LocalDate> tcnasc;
    @FXML private TableColumn<Usuario, Boolean> tcadm;
    @FXML private TableColumn<Usuario, String> tcnome;
    @FXML private TableColumn<Usuario, String> tclogin;
    @FXML private TableColumn<Usuario, Integer> tcid;
    @FXML private TableView<Usuario> tvtabela;
    private Usuario selecionado;
    private ObservableList<Usuario> obslista;
    
    
   
    private ObservableList<Usuario> busca(){
        ObservableList<Usuario> usuariobusca = FXCollections.observableArrayList();
        for(int x = 0; x < obslista.size(); x++){
        if(obslista.get(x).getNome().toLowerCase().contains(tfpesquisa.getText().toLowerCase())){
            usuariobusca.add(obslista.get(x));
        }
            }
        return usuariobusca;
    }
    
     public void IniciaTabela(){
           tcid.setCellValueFactory(new PropertyValueFactory("id_usuario"));
           tcnasc.setCellValueFactory(new PropertyValueFactory("nascimento"));
           tcadm.setCellValueFactory(new PropertyValueFactory("adm"));
           tcnome.setCellValueFactory(new PropertyValueFactory("nome"));
           tclogin.setCellValueFactory(new PropertyValueFactory("login"));
           
           UsuarioDAO dao = new UsuarioDAO();
            obslista = dao.selectUsuario();
            tvtabela.setItems(obslista);
                    
    }   
     
     
    
    public void atualizar() {
           btatualizar.setOnMouseClicked(value->{
      
        try {
            UsuarioDAO dao = new UsuarioDAO();
            obslista = dao.selectUsuario();
            tvtabela.setItems(obslista);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Tabela Atualizada!");
            a.showAndWait();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
         });
    }
     
     public void Excluir(){
   
                if(selecionado != null){
                    
                    switch (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este usuario?")) {
            case 0:
                    
             UsuarioDAO dao = new UsuarioDAO();
             dao.delete(selecionado);
             Alert a = new Alert(AlertType.INFORMATION);
                 a.setHeaderText("Usuario deletado com sucesso!");
                 a.show();
                 
                 
                 break;
            case 1:
                
                break;
            case 2:
                
                break;
                }
             }
                 else{
                 Alert a = new Alert(AlertType.WARNING);
                 a.setHeaderText("Selecione um usuario!!!");
                 a.show();
             }
       
     }
    
    public void Editar(){
        bteditar.setOnMouseClicked(value->{
            if(selecionado != null){
            editarusuarioabre e1 = new editarusuarioabre(selecionado);
            listausuarioabre l1 = new listausuarioabre();
            l1.fecharTela();
            e1.abreTela();
            }else{
                 Alert a = new Alert(AlertType.WARNING);
                 a.setHeaderText("Selecione um usuario!!!");
                 a.show();
            }
        });
    }
    
    public void GerarPDF(){
        Document doc = new Document();
        
        FileChooser f = new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF",".pdf"));
        File file = f.showSaveDialog(new Stage());
        
        if(file != null){
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(file.getAbsolutePath()));
                doc.open();

                List<Usuario> usuario = new UsuarioDAO().selectUsuario();

                for(int x = 0; x < usuario.size(); x ++){
                doc.add(new Paragraph("Id: "+ usuario.get(x).getId_usuario()));
                doc.add(new Paragraph("Login: "+ usuario.get(x).getLogin()));
                doc.add(new Paragraph("Data de Nascimento: "+ usuario.get(x).getNascimento()));
                doc.add(new Paragraph("Nome: "+ usuario.get(x).getNome()));
                doc.add(new Paragraph("Senha: "+ usuario.get(x).getSenha()));
                doc.add(new Paragraph("Caminho da Foto: "+ usuario.get(x).getFoto()));
                doc.add(new Paragraph("                                                  "));

                }
                doc.close();

                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("PDF gerado com sucessso!!!");
                a.show();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(AnaliseController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(AnaliseController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Defina um lugar para salvar o arquivo");
                a.show();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        IniciaTabela();
        atualizar();
        Editar();
        btexcluir.setOnMouseClicked(value->{
        Excluir();
        });
        tvtabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                
                selecionado = (Usuario)newValue;
            }
        });
        
        
        btpesquisa.setOnMouseClicked(value->{
            tvtabela.setItems(busca());
        });
        
        tfpesquisa.setOnKeyReleased(value->{
            tvtabela.setItems(busca());
        });
        
        btpdf.setOnMouseClicked(value->{
            GerarPDF();
        });
    }    
    
}
