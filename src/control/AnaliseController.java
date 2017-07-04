
package control;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Conta;
import model.JDBC.ContaDAO;
import model.Usuario;
import view.manage.Analiseabre;
import view.manage.editarcontaabre;


public class AnaliseController implements Initializable {

    
    @FXML private Label lbtitulo;
    /////////////////////////////////////////////////////////////////////////
    @FXML private TableView<Conta> tvtabela;   
    @FXML private TableColumn<Conta, Integer> tcid;    
    @FXML private TableColumn<Conta, Double> tcvalor;
    @FXML private TableColumn<Conta, LocalDate> tcmes;    
    @FXML private TableColumn<Conta, Integer> tckwh;   
    @FXML private TableColumn<Conta, LocalDate> tcvencimento;    
    ////////////////////////////////////////////////////////////////////////
       
    @FXML private Button btatualizar;    
    @FXML private Button btexcluir;    
    @FXML private Button bteditar;  
    @FXML private Button btpdf, btpesquisa;
    @FXML private DatePicker dppesquisa;
    private static Usuario usu;
    private Conta selecionado;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        AnaliseController.usu = usu;
    }
    private ObservableList<Conta> obslista;

    
    
       public void IniciaTabela(){
           tcid.setCellValueFactory(new PropertyValueFactory("id"));
           tcvalor.setCellValueFactory(new PropertyValueFactory("valor"));
           tcmes.setCellValueFactory(new PropertyValueFactory("mes"));
           tckwh.setCellValueFactory(new PropertyValueFactory("kwh"));
           tcvencimento.setCellValueFactory(new PropertyValueFactory("vencimento"));
           
           ContaDAO dao = new ContaDAO();
            obslista = dao.selectConta(usu.getId_usuario());
            tvtabela.setItems(obslista);
           
          
    }
       
      
    
    
       public void atualizar() {
           btatualizar.setOnMouseClicked(value->{
      
        try {
            ContaDAO dao = new ContaDAO();
            obslista = dao.selectConta(usu.getId_usuario());
            tvtabela.setItems(obslista);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Tabela Atualizada!");
            a.showAndWait();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
         });
    }
       
       
    
   
    
        public void Editar(){
            bteditar.setOnMouseClicked(value->{
                if(selecionado != null){
                editarcontaabre e1 = new editarcontaabre(selecionado);
                e1.abreTela();
                Analiseabre a1 = new Analiseabre(usu);
                a1.fecharTela();
                }else{
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setHeaderText("Selecione uma conta!!!");
                    alerta.show();
                }
            });
            
        }
    
    public void Excluir(){
        
        if(selecionado != null){
                    
                    switch (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta conta?")) {
            case 0:
                    
             ContaDAO dao = new ContaDAO();
             dao.delete(selecionado);
             Alert a = new Alert(AlertType.INFORMATION);
                 a.setHeaderText("Conta deletada com sucesso!");
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
                 a.setHeaderText("Selecione uma conta!!!");
                 a.show();
             }
        
    }
    
    public void busca(){
        if (dppesquisa.toString().trim().isEmpty()) {
                Alert al = new Alert(AlertType.ERROR);
                al.setHeaderText("Informe uma data para pesquisar!");
                al.showAndWait();
        }else{
            
            ObservableList<Conta> cont = FXCollections.observableArrayList();
                for (Conta c : obslista) {
                    if (Date.valueOf(c.getMes()).equals(Date.valueOf(dppesquisa.getValue()))) {
                        cont.add(c);
                    }
                }
                tvtabela.setItems(cont);
        }
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
            
            List<Conta> conta = new ContaDAO().selectConta(usu.getId_usuario());
            
            for(int x = 0; x < conta.size(); x ++){
            doc.add(new Paragraph("Id: "+conta.get(x).getId()));
            doc.add(new Paragraph("kWh Consumidos: "+conta.get(x).getKwh()));
            doc.add(new Paragraph("Data da Fatura: "+conta.get(x).getMes()));
            doc.add(new Paragraph("Vencimento da Fatura: "+conta.get(x).getVencimento()));
            doc.add(new Paragraph("Valor: "+conta.get(x).getValor()));
            doc.add(new Paragraph("Id Usuario: "+conta.get(x).getId_user()));
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
                
                selecionado = (Conta)newValue;
            }
        });

        btpesquisa.setOnMouseClicked(value->{
            busca();
        });
        
        btpdf.setOnMouseClicked(value->{
            GerarPDF();
        });
        
    }
        
    }    
    

