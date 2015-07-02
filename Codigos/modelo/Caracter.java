package modelo;

/**
 *
 * @author Ramón Bogarin y Ricardo Avila 
 */
 
public class Caracter {
	private String palabra;
	private String traducido;
        private int puntador;
	
	public Caracter(){
		palabra="";
		traducido="";
                puntador=0;
	}
	
	public void setTraducir(String palabra){
		this.palabra=palabra;
	}
	
	public char getCaracterPalabra(){
		return palabra.charAt(puntador);
	}
        
        public int getPalabraTamaño(){
            return palabra.length();
        }
	
	public void setTraducidoEspBogav(String caracter ){
		traducido+=caracter;
	}
        
        public void setTraducidoBogavEsp(String caracter){
            traducido+=caracter;
        }
        
        public void setaumentoPuntador(){
            puntador++;
        }
	
        public int getPosicionDelPuntador(){
            return puntador;
        }
        
	public String toString(){
		return traducido;
	}
}
