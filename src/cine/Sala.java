/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase utilizada para gestionar una sala de cine
 * @author Lila Lorenzo Martí
 * @verion 1.0
 */
public class Sala {
    /**
     * numero de la Sala
     */
    private int n_sala;
    /**
     * array bidimensionalque representa a
     * las butacas de la Sala, su valor indica si
     * estan ocupadas o no
     */
    private boolean[][] butaca;
    
    /**
     * Constructor de la clase sala
     * @param n_sala numero de la sala
     * @param n_filas numero de filas en la sala
     * @param n_butacas numero de butacas por fila
     */
    public Sala(int n_sala, int n_filas, int n_butacas) {
        this.n_sala = n_sala;
        butaca = new boolean[n_filas][n_butacas];
        for (boolean[] fila : butaca) {
            for (int i = 0; i < fila.length; i++) {
                fila[i] = false;
            }
        }
    }
    
    /**
     * Constructor vacío
     */
    public Sala() {
        this.n_sala = 0;
    }
    
    /**
     * devuelve el numero de la Sala
     * @return n_sala
     */
    public int getN_sala() {
        return n_sala;
    }
    
    public void setN_sala(int n_sala) {
        this.n_sala = n_sala;
    }
    
    /**
     * cambia todas las butacas de la sala a desocupadas
     */
    public void liberarSala() {
        for (boolean[] fila : this.butaca) {
            for (int i = 0; i < fila.length; i++) {
                fila[i] = false;
            }
        }
    }
    
    /**
     * cambia una butaca a ocupada
     * @param i fila de la butaca
     * @param j columna de la butaca
     */
    public void ocuparButaca(int i, int j) {
        this.butaca[i][j] = true;
    }
    
    /**
     * cambia una butaca a libre
     * @param i fila de la butaca
     * @param j columna de la butaca
     */
    public void liberarButaca(int i, int j) {
        this.butaca[i][j] = false;
    }

    /**
     * devuelve una representación del patio de butacas según estén libres u ocupadas
     * @return cadena de los valores del array bidimensional "butaca"
     */
    public String displayButaca() {
        String cadena = "";
        for (boolean[] fila : this.butaca) {
            for (int i = 0; i < fila.length; i++) {
                if (fila[i]) {
                    cadena += "1 ";
                } else {
                    cadena += "0 ";
                }
            }
            cadena += "\n";
        }
        return cadena;
    }
    
    /**
     * guarda en un fichero de texto la representación de la sala
     * generada por {@link #displayButaca()}
     * @throws IOException 
     */
    public void guardarSala() throws IOException {
        String nombre = "sala_" + this.n_sala + ".txt";
        File sala = new File(nombre);
        
        try (FileWriter writer = new FileWriter(sala)) {
            writer.write(displayButaca());
        }
        System.out.println(nombre + " ha sido guardado correctamente.");
    }
    
    /**
     * Busca todas las butacas consecutivas disponible para un grupo de
     * personas que vienen juntas
     * @param personas número de personas que se sentarán de forma contigua 
     * @return Map de las butacas disponibles donde su fila es la clave
     */
    public Map checkButaca(int personas) {
        /*
        encontradas: Map de butacas disponibles
        fila: fila de la representación de la sala
        columna: columna de la representación de la sala
        contador: contador utilizado para contar las butacas libres contiguas
        */
        Map<Integer, ArrayList<Integer>> encontradas = new HashMap();
        int fila = 0;
        int columna;
        int contador;
        
        for (boolean[] butacas : this.butaca) {
            columna = 0;
            contador = 0;
            // para cada fila se comprueba si cumple el requisito de butacas
            while (columna < butacas.length && contador < personas) {
                if (butacas[columna]) {
                    contador++;
                    // si el Map no contiene la fila esta es generada
                    if (!encontradas.containsKey(fila)) {
                        encontradas.put(fila, new ArrayList<>());
                        encontradas.get(fila).add(columna);
                    } else {
                        encontradas.get(fila).add(columna);
                    }
                // si la sucesión de butacas se rompe se elimina el Map de la fila
                } else {
                    contador = 0;
                    encontradas.remove(fila);
                }
                columna++;
            }
            // limpia la clave fila si no hay suficientes butacas
            if (contador < personas) {
                encontradas.remove(fila);
            }
            
            fila ++;
        }
        
        return encontradas;
    }
}
