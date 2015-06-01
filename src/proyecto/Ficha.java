/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Alejandro
 */
public abstract class Ficha {
    protected int ataque, vida, escudo;
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
