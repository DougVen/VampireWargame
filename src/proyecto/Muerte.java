/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Alejandro
 */
public class Muerte extends Ficha {

    public Muerte(String n) {
        test = "M";
        color = n;

        if (n.equals("azul")) {
            img = new Image(getClass().getResourceAsStream("muerteazul.png"));

        } else {
            img = new Image(getClass().getResourceAsStream("muerteroja.png"));
        }
        icon = new ImageView(img);
        ataque = 4;
        vida = 3;
        escudo = 1;
    }

    @Override
   public void ataqueEspecial(LogicaVampire x, Button[][] bu, Button tardis, int superman, int batman) {
        int a = getX(tardis, bu);//doctor
        int b = getY(tardis, bu);//who

        int c = superman;//batman
        int d = batman;//superman

        int posx = batman - a;
        int posy = superman - b;

        if (posx < 0) {
            posx = posx * (-1);
        }
        if (posy < 0) {
            posy = posy * (-1);
        }
        boolean ocurrio = true;

        if (!x.tablero[b][a].getTest().equals("X")) {
           if ((posx <= 2) && (posy <= 2)) {
                System.out.println("ZOMBIE-------------");

                int ataque = 2;
                int life = x.tablero[b][a].getVida();
                System.out.println("Vida antes del special: " + life);
                if (ataque > life) {
                    life = 0;
                } else {
                    life = life - ataque;
                }
                x.tablero[b][a].setVida(life);
                System.out.println("Vida despues del special: " + life);
                ocurrio = false;
                //--------------------------
            }
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (x.tablero[i][j].getTest().equals("Z")) { //i= who, j= doctor
                        int poosx = batman - j;
                        int poosy = superman - i;
                        if (poosx < 0) {
                            poosx = poosx * (-1);
                        }
                        if (poosy < 0) {
                            poosy = poosy * (-1);
                        }
                        if ((poosx <= 1) && (poosy <= 1)) {
                            int ataque = 1;
                            int life = x.tablero[b][a].getVida();
                            System.out.println("Vida antes del special: " + life);
                            if (ataque > life) {
                                life = 0;
                            } else {
                                life = life - ataque;
                            }
                            x.tablero[b][a].setVida(life);
                            System.out.println("Vida despues del special: " + life);
                            //--------------------------
                            ocurrio= false;
                        }
                    }

                }
            }
            if(ocurrio){
                x.turno-= 1;
            }

        } else {

            //aqui spawn de zombie
            if (x.tablero[c][d].getColor().equals("azul")) {
                x.tablero[b][a] = new Zombie("azul");
                bu[a][b].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("zombieazul.png"))));

            } else {
                x.tablero[b][a] = new Zombie("rojo");
                bu[a][b].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("zombierojo.png"))));
            }
        }

    }
}