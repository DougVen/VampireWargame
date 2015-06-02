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
    public void mover() {
       
    }

    @Override
    public void ataqueEspecial() {
       
    }
    
}
