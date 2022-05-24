/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cine;

import funciones.Funciones;
import java.util.Map;
import java.io.IOException;

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
        Map libres;
        Map paraXpersonas;
        
        //sala.liberarSala();
        
        //sala.guardarSala();
        
        sala = Funciones.cargarSala(2);
        
        libres = sala.checkButaca();
        
        paraXpersonas = Funciones.candidatas(libres, 1);
        
        //sala.setN_sala(3);
        
        //sala.guardarSala();
        
        System.out.println(paraXpersonas.toString());
        System.out.println("");
        System.out.println(sala.escribirButaca());
    }
    
}
