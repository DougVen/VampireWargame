/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Alejandro
 */
public class Vampiro extends Ficha{
    
    public Vampiro(String n){
        color=n;
        
        if(n.equals("azul")){
            img=new Image(getClass().getResourceAsStream("vampiroazul.png"));
            
        }else{
            img=new Image(getClass().getResourceAsStream("vampirorojo.png"));
        }
        icon=new ImageView(img);    
        ataque= 3;
        vida= 4;
        escudo = 5;
        
    }
    
    @Override
    public void mover() {
       
    }

    @Override
    public void ataqueEspecial() {
      
    }
    
}
