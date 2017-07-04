/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Conta;
import model.JDBC.ContaDAO;
import view.manage.editarcontaabre;


/**
 * FXML Controller class
 *
 * @author Guilherme
 */
public class EditarContaController implements Initializable {

    
    
    //////////////////////////////////////////
    @FXML private Label lbvalor;
    @FXML private Label lbkwh;
    @FXML private Label lbvencimento;
    @FXML private Label lbdata;
    //////////////////////////////////////////
    @FXML private DatePicker dpdata;
    @FXML private DatePicker dpvencimento;
    @FXML private TextField tfvalor;
    @FXML private TextField tfconsumidos;
    //////////////////////////////////////////
    @FXML private Button btcancelar;
    @FXML private Button bteditar;
    
    private static Conta c;
    private Conta alterada;

    
    
    public static Conta getC() {
        return c;
    }

    public static void setC(Conta c) {
        EditarContaController.c = c;
    }

    public Conta getAlterada() {
        return alterada;
    }

    public void setAlterada(Conta alterada) {
        this.alterada = alterada;
    }
    
    
    public void initiConta(){
        tfvalor.setText(String.valueOf(c.getValor()));
        tfconsumidos.setText(String.valueOf(c.getKwh()));
        dpdata.setValue(c.getMes());
        dpvencimento.setValue(c.getVencimento());
        
    }
    
    public void Fechar(){
        editarcontaabre e1 = new editarcontaabre(c);
        
        e1.fecharTela();
    }
    
    public void Atualizar(){
        int id = c.getId();
        int id_user = c.getId_user();
        double valor = Double.valueOf(tfvalor.getText());
        int kwh = Integer.parseInt(tfconsumidos.getText());
        LocalDate mes = dpdata.getValue(), vencimento = dpvencimento.getValue();
        
        if(mes != null && vencimento != null){
            ContaDAO dao = new ContaDAO();
            Conta conta = new Conta();
            conta.setId(id);
            conta.setId_user(id_user);
            conta.setKwh(kwh);
            conta.setMes(mes);
            conta.setValor(valor);
            conta.setVencimento(vencimento);
            dao.UpdateConta(conta);
            
            alterada = conta;
            setC(alterada);
            Fechar();
                Alert confirma = new Alert(Alert.AlertType.INFORMATION);
            confirma.setHeaderText("Conta Atualizada!!!");
            confirma.show();
        }
            else{
            Alert confirma = new Alert(Alert.AlertType.ERROR);
            confirma.setHeaderText("Erro: Preencha todos os dados corretamente!!!");
            confirma.show();
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       initiConta();
       
        bteditar.setOnAction(value->{
            Atualizar();
        });
        
    }    
    
}
