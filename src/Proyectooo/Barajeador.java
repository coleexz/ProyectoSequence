/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyectooo;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author AdminColeexz
 */
public class Barajeador {
    static Random rand = new Random();
    
    public static void barajear(ArrayList<ImageIcon> arreglo) {
        int n = arreglo.size();
        for (int i = n - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(arreglo, i, j);
        }
    }

    private static void swap(ArrayList<ImageIcon> arreglo, int i, int j) {
        ImageIcon temp = arreglo.get(i);
        arreglo.set(i, arreglo.get(j));
        arreglo.set(j, temp);
    }
    
    

}
