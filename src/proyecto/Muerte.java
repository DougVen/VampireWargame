/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Alejandro
 */
public class Muerte extends Ficha{

   public Muerte(String n){
       test="M";
        color=n;
        
        if(n.equals("azul")){
            img=new Image(getClass().getResourceAsStream("muerteazul.png"));
            
        }else{
            img=new Image(getClass().getResourceAsStream("muerteroja.png"));
        }
        icon=new ImageView(img);  
        ataque= 4;
        vida= 3;
        escudo =1;
    }
    

    @Override
    public void ataqueEspecial(LogicaVampire x,Button[][] bu, Button tardis, Button ult) {
        int a= getX(tardis,bu);
        int b= getY(tardis,bu);
        
        int c= getX(ult,bu);//batman
        int d= getY(ult,bu);//superman
        
        System.out.println("Que ataque especial quiere?");
        System.out.println("Escriba "+"'"+ "lanza"+ "'"+" o "+"'"+"spawn"+"'");
        Scanner lea= new Scanner(System.in);
        String choice= lea.next().toLowerCase();
        
        do{
            try{
                switch(choice){
                    case "lanza":
                        System.out.println("Soy Muerte");

                        int ataque= 2;
                        int life=x.tablero[b][a].getVida();
                        System.out.println("Vida antes del special: " + life);
                        if(ataque>life){
                            life=0;
                        }
                        else{
                            life=life-ataque;
                        }
                        x.tablero[b][a].setVida(life);
                        System.out.println("Vida despues del special: " + life);
                        //--------------------------

                        
                    case "spawn":
                        //aqui spawn de zombie
                        if (x.tablero[d][c].getColor().equals("rojo")){
                            x.tablero[b][a] = new Zombie("rojo");
                            bu[a][b].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("zombierojo.png"))));
                        }
                        else{
                            x.tablero[b][a] = new Zombie("azul");
                            bu[a][b].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("zombieazul.png"))));
                        }
               }
            }
            catch(Exception e){
                e.getMessage();
            }
        }while(!(choice.equals("lanza") || choice.equals("spawn")));
    }
    
    
}
