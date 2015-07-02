
package control;

import modelo.Caracter;

/**
 *
 * @author Ramón Bogarin y Ricardo Avila 
 */
public class Decodificar extends Caracter{

    private int numeroCaracter;
    private char caracter;
    private String casteo;
    private String numero;        
            
    public Decodificar() {
        super();
        numeroCaracter=0;
        casteo="";
        numero="";
    }
   
    private void setTraducirr(String numero){
        numeroCaracter=Integer.parseInt(numero);
        numeroCaracter/=5;
        caracter=(char)numeroCaracter;
        casteo+=caracter;
        setTraducidoBogavEsp(casteo);
        casteo="";
    }
    
    public void setIntroducir(char caracter){
       
            if(caracter>='a'&&caracter<='z'|| caracter>='A' && caracter<='Z'){
                setaumentoPuntador();
                setTraducirr(numero);
                 numero="";
            }else{
                numero+=caracter;
            }
    }
    
}
