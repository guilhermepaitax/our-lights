
package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import model.Conta;
import model.JDBC.ContaDAO;
import model.MesDAO;
import model.Usuario;



public class GraficosController implements Initializable {

    
    
    @FXML private TabPane tpmenu;
    @FXML private Tab tbarras;
    @FXML private Tab tpizza;
    @FXML private BarChart<String, Double> bcbarra;
    @FXML private PieChart pbpizza;
    //@FXML private NumberAxis nagrafico;
    @FXML private CategoryAxis cagrafico;
    private static Usuario usu;
 
    
     public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario ausu) {
        GraficosController.usu = ausu;
    }
    
    
    private int janeiro = 0, fevereiro = 0, marco = 0, abril = 0;
    private int maio = 0, junho = 0, julho = 0, agosto = 0, setembro = 0;
    private int outubro = 0, novembro = 0, dezembro = 0;
    
    private double contajaneiro = 0, contafevereiro = 0, contamarco = 0, contaabril = 0;
    private double contamaio = 0, contajunho = 0, contajulho = 0, contaagosto = 0, contasetembro = 0;
    private double contaoutubro = 0, contanovembro = 0, contadezembro = 0;
    

    
    public void iniGrafico() {
        try {
            if(janeiro>0){
                pbpizza.getData().add( new PieChart.Data("Janeiro", janeiro));
            }if(fevereiro>0){
                pbpizza.getData().add( new PieChart.Data("Fevereiro", fevereiro));
            }if(marco>0){
                pbpizza.getData().add( new PieChart.Data("Março", marco));
            }if(abril>0){
                pbpizza.getData().add( new PieChart.Data("Abril", abril));
            } if(maio>0){
                pbpizza.getData().add( new PieChart.Data("Maio", maio));
            }if(junho>0){
                pbpizza.getData().add( new PieChart.Data("Junho", junho));
            } if(julho>0){
                pbpizza.getData().add( new PieChart.Data("Julho", julho));
            }if(agosto>0){
                pbpizza.getData().add( new PieChart.Data("Agosto", agosto));
            } if(setembro>0){
                pbpizza.getData().add( new PieChart.Data("Setembro", setembro));
            }if(outubro>0){
                pbpizza.getData().add( new PieChart.Data("Outubro", outubro));
            } if(novembro>0){
                pbpizza.getData().add( new PieChart.Data("Novembro", novembro));
            }if(dezembro>0){
                pbpizza.getData().add( new PieChart.Data("Dezembro", dezembro)); } 
                pbpizza.setTitle("Meses com cadastro de contas:");
                    
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
    
    public void addGrafico(){
        ContaDAO dao = new ContaDAO();
        List<Conta> conta = new ArrayList<Conta>(dao.selectConta(usu.getId_usuario()));
            
        for (int x = 0; x < conta.size(); x++) {
            if (conta.get(x).getMes().getMonthValue() == 1) {
                janeiro = janeiro + 1;                
            }if (conta.get(x).getMes().getMonthValue() == 2) {
                fevereiro = fevereiro + 1;               
            }if (conta.get(x).getMes().getMonthValue() == 3) {
                marco = marco + 1;                
            }if (conta.get(x).getMes().getMonthValue() == 4) {
                abril = abril + 1;               
            }if (conta.get(x).getMes().getMonthValue() == 5) {
                maio = maio + 1;               
            }if (conta.get(x).getMes().getMonthValue() == 6) {
                junho = junho + 1;                
            }if (conta.get(x).getMes().getMonthValue() == 7) {
                julho = julho + 1;                
            }if (conta.get(x).getMes().getMonthValue() == 8) {
                agosto = agosto + 1;               
            }if (conta.get(x).getMes().getMonthValue() == 9) {
                setembro = setembro + 1;                
            }if (conta.get(x).getMes().getMonthValue() == 10) {
                outubro = outubro + 1;                
            }if (conta.get(x).getMes().getMonthValue() == 11) {
                novembro = novembro + 1;                
            }if (conta.get(x).getMes().getMonthValue() == 12) {
                dezembro = dezembro + 1;               
            }
        }       
    }
   
   
    
   public void addGraficoBarra(){
       
       ContaDAO dao = new ContaDAO();
        List<Conta> conta = new ArrayList<Conta>(dao.selectConta(usu.getId_usuario()));
            
        for (int x = 0; x < conta.size(); x++) {
            if (conta.get(x).getMes().getMonthValue() == 1) {
                contajaneiro = conta.get(x).getValor();     
                
            }if (conta.get(x).getMes().getMonthValue() == 2) {
                contafevereiro = conta.get(x).getValor(); 
                
            }if (conta.get(x).getMes().getMonthValue() == 3) {
                contamarco = conta.get(x).getValor();    
                
            }if (conta.get(x).getMes().getMonthValue() == 4) {
                contaabril = conta.get(x).getValor();   
                
            }if (conta.get(x).getMes().getMonthValue() == 5) {
                contamaio = conta.get(x).getValor();    
                
            }if (conta.get(x).getMes().getMonthValue() == 6) {
                contajunho = conta.get(x).getValor();  
                
            }if (conta.get(x).getMes().getMonthValue() == 7) {
                contajulho = conta.get(x).getValor();  
                
            }if (conta.get(x).getMes().getMonthValue() == 8) {
                contaagosto = conta.get(x).getValor(); 
                
            }if (conta.get(x).getMes().getMonthValue() == 9) {
                contasetembro = conta.get(x).getValor(); 
                
            }if (conta.get(x).getMes().getMonthValue() == 10) {
                contaoutubro = conta.get(x).getValor();
                
            }if (conta.get(x).getMes().getMonthValue() == 11) {
                contanovembro = conta.get(x).getValor(); 
                
            }if (conta.get(x).getMes().getMonthValue() == 12) {
                contadezembro = conta.get(x).getValor();               
            }
        }
    }
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {     
        addGrafico();
        iniGrafico();        
       cagrafico.setCategories(MesDAO.getMeses());
       addGraficoBarra();
       setValorconta();
    }    
    
    public void setValorconta() {        
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        bcbarra.setTitle("Valor das contas cadastradas");
        series.getData().add(new XYChart.Data<>("Jan", contajaneiro));
        series.getData().add(new XYChart.Data<>("Fev", contafevereiro));
        series.getData().add(new XYChart.Data<>("Mar", contamarco));
        series.getData().add(new XYChart.Data<>("Abr", contaabril));
        series.getData().add(new XYChart.Data<>("Mai", contamaio));
        series.getData().add(new XYChart.Data<>("Jun", contajunho));
        series.getData().add(new XYChart.Data<>("Jul", contajulho));
        series.getData().add(new XYChart.Data<>("Ago", contaagosto));
        series.getData().add(new XYChart.Data<>("Set", contasetembro));
        series.getData().add(new XYChart.Data<>("Out", contaoutubro));
        series.getData().add(new XYChart.Data<>("Nov", contanovembro));
        series.getData().add(new XYChart.Data<>("Dez", contadezembro));
        
        bcbarra.getData().add(series);
    }
    
}
