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
        int a = getX(tardis, bu);
        int b = getY(tardis, bu);

        int c = superman;//batman
        int d = batman;//superman

        if (!x.tablero[b][a].getTest().equals("X")) {

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
            //--------------------------
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
