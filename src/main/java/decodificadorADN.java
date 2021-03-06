import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;

public class decodificadorADN extends JFrame implements ActionListener{
    
    private String primeraCadena;
    private String segundaCadena;
    private int i, j;
    private Scanner entrada = new Scanner(System.in);
    private JPanel panelFondo;
    private JButton botonAceptar;
    private JLabel instrucciones,segundaParteDeLasInstrucciones, ADN_decodificado;
    private JTextField primerTexto, segundoTexto;
    private String aux, aux2;
    
    /**
     * Constructor de la clase
     * - inicializacion de las variables de la interfaz
     */
    
    public decodificadorADN(){
        setLayout(null);
        
        this.setVisible(true);
        this.setSize(300,300);
        this.setMinimumSize(new Dimension(500,300));
        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        
       // this.getContentPane().setBackground(Color.red);
        panelFondo = new JPanel();
        panelFondo.setLayout(null);
        panelFondo.setBackground(Color.BLACK);
        panelFondo.setBounds(0,0,500,300);
        this.getContentPane().add(panelFondo);
        
        instrucciones = new JLabel("Introduzca c/u de las secuencias del");
        instrucciones.setFont(new Font("chiller", 3,14));
        instrucciones.setForeground(Color.red);
        instrucciones.setBounds(100,10,500,50);
        panelFondo.add(instrucciones);
        
        
        segundaParteDeLasInstrucciones = new JLabel("ADN en cada una de las casillas: "); 
        segundaParteDeLasInstrucciones.setFont(new Font("chiller", 3,14));
        segundaParteDeLasInstrucciones.setForeground(Color.red);
        segundaParteDeLasInstrucciones.setBounds(120,30,500,50);
        panelFondo.add(segundaParteDeLasInstrucciones);
        
        
        primerTexto = new JTextField();
        primerTexto.setBounds(70,100,200,30);
        panelFondo.add(primerTexto);
        
        segundoTexto = new JTextField();
        segundoTexto.setBounds(70,160,200,30);
        panelFondo.add(segundoTexto);
        
        botonAceptar = new JButton("Aceptar");
        botonAceptar.setFont(new Font("chiller",3,14));
        botonAceptar.setForeground(Color.BLACK);
        botonAceptar.setBounds(350,130,100,50);
        botonAceptar.addActionListener(this);
        panelFondo.add(botonAceptar);
        
        
        ADN_decodificado = new JLabel();
        ADN_decodificado.setForeground(Color.red);
        segundaParteDeLasInstrucciones.setFont(new Font("chiller", 3,14));
        ADN_decodificado.setBounds(200,220,200,50);
        panelFondo.add(ADN_decodificado);
        
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);        
        
    }
    
    
    /**
     * Metodo que se utilizó para la parte de la consola
     * específicamente para pedir datos al usuario
     */
    public void ejecutar(){
        System.out.println("Ingrese la primera cadena: ");
        primeraCadena = entrada.nextLine();
        System.out.println("Ingrese la segunda cadena: ");
        segundaCadena = entrada.nextLine();
        
        separarCadenas(primeraCadena, segundaCadena);
        
    }
    
    /**
     * Método encargado de la logica para poder obtener los primeros caracteres iguales de las dos
     * cadenas introducidas
     * @param primCadena: parámetro utilizado específicamente para la primera cadena del ADN
     * @param segundCadena : este contendría la segunda cadena del ADN
     */
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
    
    /**
     * Metodo encargado de obtener todos los caracteres iguales en ambas cadenas
     * @param a: posición en la primera cadena en la que se encuentra el primer similar 
     * @param b: posición en la segunda cadena en la que se encuentra el caracter igual a la otra cadena
     * @param cadena1: cadena de caracteres del primer ADN
     * @param cadena2: cadena de caracteres del segundo ADN
     * @return : el ADN decodificado
     */
    
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
    /**
     * 
     * @param e: variable en la que se almacenará el evento del boton 
     */

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
