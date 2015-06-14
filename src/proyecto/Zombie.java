/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Alejandro
 */
public class Zombie extends Ficha {
    
    Zombie(String n){
        color=n;
        
        if(n.equals("azul")){
            img=new Image(getClass().getResourceAsStream("zombieazul.png"));
            
        }else{
            img=new Image(getClass().getResourceAsStream("zombierojo.png"));
        }
        icon=new ImageView(img);  
        ataque= 1;
        vida= 1;
        escudo = 0;
    }
    
    @Override
    public void ataqueEspecial(LogicaVampire x,Button[][] bu, Button bu2, Button bu3) {
        
    }

   
}
