/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package funciones;

/**
 *
 * @author Lila
 */
public interface Menu {
    
    public static String displayMenu(){
        String texto = "";

        texto += "1 -Crear nueva sala\n";
        texto += "2 -Cargar sala existente\n";
        texto += "3 -Mostrar el mapa de butacas\n";
        texto += "4 -Buscar butacas libres\n";
        texto += "5 -Asignar butacas\n";
        texto += "6 -Vaciar sala\n";
        texto += "0 -Cerrar programa";
        
        return texto;
    }
}
