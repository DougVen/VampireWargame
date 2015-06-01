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
public abstract class Ficha {
    protected int ataque, vida, escudo;
    protected Image img;
    protected ImageView icon;
    protected String color;

//------------------SETS Y GETS--------------------------
    public int getAtaque() {
        return ataque;
    }

    public int getVida() {
        return vida;
    }

    public int getEscudo() {
        return escudo;
    }
    
//--------------Funciones---------------------------------- 
    public abstract void mover();
    
    public abstract void ataqueEspecial();
    
}
