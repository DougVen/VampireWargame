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
    public void ataqueEspecial(LogicaVampire play,Button[][] botones, Button tardis, Button ult) {
       System.out.println("LOBO SPECIAL   ");
        int doctor=super.getX(tardis, botones);
        int who=super.getY(tardis, botones);
        int superman=super.getX(ult, botones);
        int batman=super.getY(ult, botones);
        System.out.println(doctor);
        System.out.println(who);
        System.out.println(superman);
        System.out.println(batman);
        botones[doctor][who].setGraphic(botones[batman][superman].getGraphic());
            botones[batman][superman].setGraphic(((Node) blank));

            play.tablero[who][doctor] = play.tablero[superman][batman];
            play.tablero[superman][batman] = null;
        
       
                         
    }

    @Override
    public boolean mover(LogicaVampire play, Button[][] botones, Button tardis, int superman, int batman) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
                    
}
