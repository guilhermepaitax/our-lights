
package model;

public class Calcula {

   
    
    public double Verde(int kwh){
        double valor; 
        double unitario = 0.60;
        int iluminacao = 15;
        valor = kwh * unitario ;
        valor = valor + iluminacao;
        return valor;
    }
    
    public double Amarelo(int kwh){
        
        double valor; 
        double unitario = 0.60;
        double bandeira = 1.50;
        double numero;
        int iluminacao = 15;
        numero = kwh/100;      
        valor = kwh * unitario ;
        valor = valor + iluminacao;
        valor = valor + (bandeira * numero);  
        return valor;
        
    }
    
    public double Vermelho(int kwh){
        
        double valor; 
        double unitario = 0.60;
        double bandeira = 3.00;
        double numero;
        int iluminacao = 15;
        numero = kwh/100;      
        valor = kwh * unitario ;
        valor = valor + iluminacao;
        valor = valor + (bandeira * numero);  
        return valor;
        
    }
}
