/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyectooo;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public abstract class SequencePlayer {
    
    String name,simbolo;
    int puntos;
    ImageIcon color;
    ArrayList<ImageIcon> cartas; 
    
    public SequencePlayer(String name, ImageIcon color, ArrayList<ImageIcon> cartas, String simbolo, int puntos){
        this.name=name;
        this.color = color;
        this.cartas = cartas;
        this.simbolo=simbolo;
    }

    public String getName() {
        return name;
    }

    public void setColor(ImageIcon color) {
        this.color = color;
    }

    public void setCartas(ArrayList<ImageIcon> cartas) {
        this.cartas = cartas;
    }
    

}
