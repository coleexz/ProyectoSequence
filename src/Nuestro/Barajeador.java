/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nuestro;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author AdminColeexz
 */
public class Barajeador {
    Random rand = new Random();
    
    public void barajear(ImageIcon[][] arreglo){
       
        int n = arreglo.length;
        for (int i = n - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(arreglo, i, j);
        }
    
    }
    
    private static void swap(Object[] arreglo, int i, int j) {
        Object temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }
    
    

}
