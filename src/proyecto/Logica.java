/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;
import javafx.scene.image.ImageView;

/**
 *
 * @author usuario
 */
public class Logica {
    static int turno=1;
    static public int Ruleta(){
        Random t;
        t=new Random();
       IntStream valores=t.ints(1, 4);
        OptionalInt z=valores.findAny();
        int fi=z.getAsInt();
        System.out.println(fi);
        return fi;
    }
    static void Mover(Ficha f){
        
    }
    static void Turno(){
        turno+=1;
        int jugable=Ruleta();
        
        switch(jugable){
            case 1 :
                break;
            case 2:
                break;
            case 3:
                break;
        }
        
    }
    
    public static void main(String[] args) {
        Ruleta();
        Ficha[][] tablero=new Ficha[6][6];
        
        tablero[0][0]=new HombreLobo("rojo");
        tablero[0][5]=new HombreLobo("azul");
        tablero[3][0]=new Muerte("rojo");
        tablero[3][5]=new Muerte("azul");
 
        tablero[1][0]=new Vampiro("rojo");
        tablero[1][5]=new Vampiro("azul");
        tablero[4][0]=new Vampiro("rojo");
        tablero[4][5]=new Vampiro("azul");
        
        tablero[2][0]=new Muerte("rojo");
        tablero[2][5]=new Muerte("azul");
        tablero[5][0]=new HombreLobo("rojo");
        tablero[5][5]=new HombreLobo("azul");
        
        
        
        
    }
}
