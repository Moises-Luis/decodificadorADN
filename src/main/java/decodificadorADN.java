import java.util.Scanner;

public class decodificadorADN {
    private String primeraCadena;
    private String segundaCadena;
    private int i, j;
    Scanner entrada = new Scanner(System.in);
    
    public decodificadorADN(){
        ejecutar();
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
            System.out.println("cadena: "+aux);
        }else if(aux.length() < aux2.length()){
            System.out.println("cadena2: "+aux2);
        }else{
            System.out.println("cadena: "+aux);
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
    
}
