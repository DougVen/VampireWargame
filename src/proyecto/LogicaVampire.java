/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author usuario
 */
public class LogicaVampire {
    protected int turno=1;
    public Ficha[][] tablero;


    public LogicaVampire() {
        tablero=new Ficha[6][6];
     
    }
    
    public void Print(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(tablero[i][j]==null){
                    System.out.print("X");
                }else
                System.out.print(tablero[i][j].test); 
            }System.out.println("");         
            
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
    }
        
    public int Ruleta(){
        
        
        Random t;
        t=new Random();
       IntStream valores=t.ints(1, 4);
        OptionalInt z=valores.findAny();
        int fi=z.getAsInt();
        System.out.println(fi);
        return fi;
    }
    protected void Mover(Ficha f){
        
    }
    protected void Turno(){
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
}