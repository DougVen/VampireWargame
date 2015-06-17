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
    
    
    
   


    public void ataqueEspecial(LogicaVampire play,Button[][] botones, Button tardis, Button ult, int t) {
       System.out.println("LOBO SPECIAL   ");
        int doctor=super.getX(tardis, botones);
        int who=super.getY(tardis, botones);
        int superman=super.getX(ult, botones);
        int batman=super.getY(ult, botones);
        int posx = batman - doctor;
        int posy = superman - who;
        if (posx < 0) {
            posx = posx * (-1);
        }
        if (posy < 0) {
            posy = posy * (-1);
        }

        if ((posx <= 2) && (posy <= 2)) {
                mover(play, botones, doctor, who, superman, batman);
        }
        
       
                         
    }

    @Override
    public void ataqueEspecial(LogicaVampire play, Button[][] botones, Button tardis, int superman, int batman){
      int doctor = getX(tardis, botones);
        int who = getY(tardis, botones);
        int posx = batman - doctor;
        int posy = superman - who;

        if (posx < 0) {
            posx = posx * (-1);
        }
        if (posy < 0) {
            posy = posy * (-1);
        }

        if ((posx <= 2) && (posy <= 2)) {
                mover(play, botones, doctor, who, superman, batman);
        }
    }
                    
}
