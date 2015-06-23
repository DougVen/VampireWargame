/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.RandomAccessFile;
import java.util.RandomAccess;

/**
 *
 * @author usuario
 */
public interface Mando {

    public void crearUsuario(String nombre, String pass);

    public void eliminar(String nombre, String pass);

    public void guardarPartida();

    public void cargar();
    public void print();

    public long search(String nombre);

}
