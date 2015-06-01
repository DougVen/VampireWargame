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
public class HombreLobo extends Ficha{

    HombreLobo(String n){
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

    @Override
    public void ataqueEspecial() {
        
    }
    
}
