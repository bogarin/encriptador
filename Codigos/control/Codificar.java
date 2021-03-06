/*
 *   aqui se codifica letras caracteres especiales y numeros
 *  segun como lo indicamos en nuestro lenguaje
 *
 */
package control;

/**
 *
 * @author Ramón Bogarin y Ricardo Avila 
 */
 
import java.util.Random;
import modelo.Caracter;

public class Codificar extends Caracter {

    public Codificar() {
        super();
    }

    /*      Letras en minusculas 
     * es elnumero ascii respesentantivo de la letra 
     * multiplicado por 5 la letra escrita en minusculas
     * anterior y la letra en mayusculas posterior
     * ejemplo: letra  b= 490aC
     * 490 es le numero multiplicado por 5
     * a es la letra anterior de b indicando que es minuscula
     * C es la letra posterior de la letra b
     */
    public void setMinusculasBogav(char caracter) {
        if (caracter > 'a' && caracter < 'z') {
            setMinusculasInterno(caracter);
        } else if (caracter == 'a') {
            super.setTraducidoEspBogav("485bC");
        } else if (caracter == 'z') {
            super.setTraducidoEspBogav("610yA");
        }
    }

    private void setMinusculasInterno(char caracter) {
        String caracterCodificado = "";
        caracterCodificado += getCaracterMultiplicado(caracter);
        caracterCodificado += caracter -= 1;
        caracterCodificado += caracter -= 30;
        super.setTraducidoEspBogav(caracterCodificado);
    }

    /*      Letras en mayusculas 
     * es elnumero ascii respesentantivo de la letra 
     * multiplicado por 5 la letra escrita en mayusculas
     * anterior y la letra en minusculas posterior
     * ejemplo: letra  B= 490Ac
     * 490 es le numero multiplicado por 5
     * A es la letra anterior de b indicando que es mayusculas
     * c es la letra posterior de la letra b
     */
    public void setMayusculasBogav(char caracter) {
        if (caracter > 'A' && caracter < 'Z') {
            setMayusculasInterno(caracter);
        } else if (caracter == 'A') {
            super.setTraducidoEspBogav("325Bc");
        } else if (caracter == 'Z') {
            super.setTraducidoEspBogav("450Ya");
        }
    }

    private void setMayusculasInterno(char caracter) {
        String caracterCodificado = "";
        caracterCodificado += getCaracterMultiplicado(caracter);
        caracterCodificado += caracter -= 1;
        caracterCodificado += caracter += 34;
        super.setTraducidoEspBogav(caracterCodificado);
    }

    /*  Numeros se representan de esta forma:
     * los numeros lo que se hace es el numero ascii
     * que lo representa  multiplicado por 5 mas la posicion de letra
     * y si es par o no ejemplo 1= 245b1
     * 245 es le numero multiplicado
     * b es la osicion que toma el numero 1 enpesando desde el sero 
     * y terminando con 9
     * y 1 es igual a que no es par
     */
    public void setNumerosBogav(char caracter) {
        String caracterCodificado = "";
        char caracterCompaniante = 97;
        caracterCompaniante += getSumaNumero(caracter);
        caracterCodificado += getCaracterMultiplicado(caracter);
        caracterCodificado += caracterCompaniante;
        caracterCodificado += getNumeroEsPar(caracter);
        super.setTraducidoEspBogav(caracterCodificado);
    }

    private int getSumaNumero(char caracter) {
        String convertir = "";
        convertir += caracter;
        return Integer.parseInt(convertir);
    }

    private int getCaracterMultiplicado(char caracter) {
        int decimal = caracter;
        return decimal *= 5;
    }

    private int getNumeroEsPar(char caracter) {
        int numero = caracter;
        return numero %= 2;
    }

    /*
     *   Este metodo indica caracteres especiales
     * como los mas acomunes en escribir que son
     * 160io=Espacio, 45on=Tabulacion, 50er=enter
     */
    public void setcaracterEspecialBogav1ra(char caracter) {
        if (caracter == 32) {
            super.setTraducidoEspBogav("160io");
        } else if (caracter == 9) {
            super.setTraducidoEspBogav("45on");
        } else if (caracter == 10) {
            super.setTraducidoEspBogav("50er");
        }
    }

    /*      Signos especiales desde el la tralba del 
     *   codigo ascii desde 33 al 47 o desde 58 al 64 o 91 al 93 y 96,123 a 125 
     */
    public void setCaracterEspecialBogav2(char caracter) {
        if (caracter >= 33 && caracter <= 47) {
            setTraducidoEspBogav(setInternoCaracterEspecial(caracter));
        } else if (caracter >= 58 && caracter <= 64) {
            setTraducidoEspBogav(setInternoCaracterEspecial(caracter));
        } else if (caracter >= 91 && caracter <= 93) {
            setTraducidoEspBogav(setInternoCaracterEspecial(caracter));
        } else if (caracter == 96) {
            setTraducidoEspBogav(setInternoCaracterEspecial(caracter));
        } else if (caracter == 123) {
            setTraducidoEspBogav(setInternoCaracterEspecial(caracter));
        } else if (caracter == 125) {
            setTraducidoEspBogav(setInternoCaracterEspecial(caracter));
        }
    }

    private String setInternoCaracterEspecial(char caracter) {
        String caracterCodificado = "";
        caracterCodificado += getCaracterMultiplicado(caracter);
        caracterCodificado += getLetrasaleatoriasBogav();
        return caracterCodificado;
    }

    //metodo que asigna letras Mayuscolas en caracteres especiales  
    public String getLetrasaleatoriasBogav() {
        String dosLetras = "";
        int numero = 65;
        Random aleatorio = new Random();
        for (int i = 0; i < 2; i++) {
            numero += aleatorio.nextInt(26);
            dosLetras += (char) numero;
            numero = 65;
        }
        return dosLetras;
    }
        
}
