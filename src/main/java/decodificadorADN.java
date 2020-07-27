import java.awt.Color;
import java.awt.Dimension;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;

public class decodificadorADN extends JFrame implements ActionListener{
    
    private String primeraCadena;
    private String segundaCadena;
    private int i, j;
    Scanner entrada = new Scanner(System.in);
    private JPanel panelFondo;
    private JButton botonAceptar;
    private JLabel instrucciones, ADN_decodificado;
    private JTextField primerTexto, segundoTexto;
    private String aux, aux2;
    
    public decodificadorADN(){
        setLayout(null);
        
        this.setVisible(true);
        this.setSize(300,300);
        this.setMinimumSize(new Dimension(520,300));
        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        
       // this.getContentPane().setBackground(Color.red);
        panelFondo = new JPanel();
        panelFondo.setLayout(null);
        //panelFondo.setBackground(Color.BLACK);
        panelFondo.setBounds(0,0,500,300);
        this.getContentPane().add(panelFondo);
        
        instrucciones = new JLabel("Introduzca c/u de las secuencias del ADN en cada una de las casillas: ");
        instrucciones.setBounds(10,10,500,50);
        panelFondo.add(instrucciones);
        
        primerTexto = new JTextField();
        primerTexto.setBounds(10,70,200,40);
        panelFondo.add(primerTexto);
        
        segundoTexto = new JTextField();
        segundoTexto.setBounds(10,130,200,40);
        panelFondo.add(segundoTexto);
        
        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(220,100,100,50);
        botonAceptar.addActionListener(this);
        panelFondo.add(botonAceptar);
        
        
        ADN_decodificado = new JLabel();
        ADN_decodificado.setBounds(20,190,200,50);
        panelFondo.add(ADN_decodificado);
        
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);        
        
    }
    
    public void ejecutar(){
        System.out.println("Ingrese la primera cadena: ");
        primeraCadena = entrada.nextLine();
        System.out.println("Ingrese la segunda cadena: ");
        segundaCadena = entrada.nextLine();
        
        separarCadenas(primeraCadena, segundaCadena);
        
    }
    
    public void separarCadenas(String primCadena, String segundCadena){
        String aux = "", aux2 = "";
        int tamañoMaximoARecorrer = 0;
        
        if(primCadena.length() < segundCadena.length()){
            tamañoMaximoARecorrer = primCadena.length();
        }else{
            tamañoMaximoARecorrer = segundCadena.length();
        }
        
        int numAuxi = 0;
        
        for( i = 0; i<primCadena.length(); i++){
            for(j = 0 ; j<segundCadena.length(); j++){
                
                if(primCadena.substring(i,i+1).equalsIgnoreCase(segundCadena.substring(j,j+1))){
                    if(numAuxi == 0){
                        aux = getCadena(i, j, primCadena, segundCadena);
                        numAuxi++;
                    }else if(numAuxi == 1){    
                        aux2 = getCadena(i, j, primCadena, segundCadena);
                        numAuxi++;
                    }
                    if(numAuxi > 1){
                        if(aux.length() < aux2.length()){
                            aux = "";
                            aux = getCadena(i, j, primCadena, segundCadena);
                        }
                        if(aux.length() > aux2.length()){
                            aux2 = "";
                            aux2 = getCadena(i, j, primCadena, segundCadena);
                        }
                        if(aux.length() == aux2.length()){
                            aux = "";
                            aux = getCadena(i, j, primCadena, segundCadena);
                        }
                    }
                }
                
            }
        }
        
        if(aux.length() > aux2.length()){
                ADN_decodificado.setText(aux);
            System.out.println("ADN decodificado ///: "+aux);
        }else if(aux.length() < aux2.length()){
            ADN_decodificado.setText(aux2);
            System.out.println("ADN decodificado: "+aux2);
        }else{
            ADN_decodificado.setText(aux);
            System.out.println("ADN decodificado: "+aux);
        }
            
        
    }
    
    public String getCadena(int a, int b, String cadena1 , String cadena2){
        boolean aux1 = true;
        String aux="";

            for(int d = a; d < cadena1.length() && b < cadena2.length(); d++){
                if(cadena1.substring(d,d+1).equalsIgnoreCase(cadena2.substring(b,b+1))){
                aux += cadena1.substring(d,d+1);
                b++;
                
                }else{
                    aux1 = false;
                    break;
                }   
            }
        return aux;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == botonAceptar){
            String primTexto = primerTexto.getText();
            String segTexto = segundoTexto.getText();
            
            separarCadenas(primTexto, segTexto);
            primerTexto.setText("");
            segundoTexto.setText("");
            
            ADN_decodificado.setVisible(true);
            
        }
    }
}
