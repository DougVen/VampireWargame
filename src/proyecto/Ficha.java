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
public abstract class Ficha {
    protected int ataque, vida, escudo;
   
    protected Image img;
    public ImageView icon;
    protected String color,test=" ";
    

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
    
    public void setEscudo(int esc) {
        escudo= esc;
    }
    
    public void setVida(int vida) {
        this.vida=vida;
    }

    public ImageView getIcon() {
        return icon;
    }

    public String getColor() {
        return color;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    
    
    
    public int getX(Button b, Button[][] bu){
        int doctor=0;
        for (int i = 0; i <bu.length; i++) {
                    for (int j = 0; j < bu[i].length; j++) {
                        if(bu[i][j]==b){
                            doctor=i;
                            
                        }
                    }
                }           
                return doctor;
    }
    public int getY(Button b, Button[][] bu){
        int doctor=0;
        for (int i = 0; i <bu.length; i++) {
                    for (int j = 0; j < bu[i].length; j++) {
                        if(bu[i][j]==b){
                            doctor=j;
                        }
                    }
                }           
                return doctor;
    }
    
//--------------Funciones---------------------------------- 
    public abstract void mover();
    
    public abstract void ataqueEspecial(LogicaVampire x,Button[][] bu, Button bu2, Button bu3);
    
}
