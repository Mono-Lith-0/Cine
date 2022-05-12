/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cine;

import static funciones.Funciones.cargarSala;
import java.io.IOException;
import java.util.Map;

/**
 * Clase principal
 * @author Lila Lorenzo Martí
 * @version 1.0
 */
public class Cine {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //Sala sala = new Sala(1, 5, 7);
        Sala sala;
        Map ejemplo;
        
        //sala.liberarSala();
        
        //sala.guardarSala();
        
        sala = cargarSala(2);
        
        ejemplo = sala.checkButaca(3);
        
        //sala.setN_sala(3);
        
        //sala.guardarSala();
        
        System.out.println(ejemplo.toString());
    }
    
}
