/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;

/**
 *
 * @author Alejandro
 */
public class HombreLobo extends Ficha{
        
   
    private Image img2 = new Image(getClass().getResourceAsStream("yes.png"));
    private ImageView blank = new ImageView(img2);
    //private Button[][] botones = new Button[6][6];
    //private int doctor,who, batman,superman,posx,posy;
    private Button ult= new Button("",((Node)blank));
    
    
    public HombreLobo(String n){
        test="H";
        color=n;
        
        if(n.equals("azul")){
            img=new Image(getClass().getResourceAsStream("loboazul.png"));
            
        }else{
            img=new Image(getClass().getResourceAsStream("loborojo.png"));
        }
        icon=new ImageView(img);  
        ataque= 5;
        vida= 5;
        escudo =2;
    }
    
    
    
    @Override
    public void mover() {
        
    }


    public void ataqueEspecial(LogicaVampire x,Button[][] bu, Button tardis, Button ult) {
        System.out.println("LOBO");
        
        //who = a  // doctor= b// superman= c// batman= d
        
        int a= getX(tardis,bu); //doctor
        int b= getY(tardis,bu);// who
        
        int c= getX(ult,bu);// superman
        int d= getY(ult,bu);// batman
        
        x.tablero[c][d].setTest("HH");
            //---------------------------------------
            /*
            if(ult.getGraphic()!=((Node)blank)){
                int posx= d- a;
                int posy= c-b;
                if(posx<0)
                    posx=posx *(-1);
                if(posy<0)
                    posy= posy*(-1);
            
                if((posx <=2)&& (posy <=2)){

                    bu[c][d].setOnAction(mover);
                    
                    if(bu[b][a].getGraphic()!=((Node)blank)){

                     bu[b][a].setGraphic(ult.getGraphic());
                     x.tablero[b][a]=x.tablero[d][c];
                     x.tablero[d][c]=null;
                     ult.setGraphic(((Node)blank));
                     x.Print();
                     return;
                    }
                            
                }
            }
                   */        
    }
                    
}
