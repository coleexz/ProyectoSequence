/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Proyectooo;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author AdminColeexz
 */
public class ATABLEROCOLE extends javax.swing.JFrame implements ActionListener {

    private String tableroIconos[][] = new String[10][10]; //tablero para verificar que si los iconos son del compañero o no
    private ArrayList<ImageIcon> imagenes = new ArrayList();

    boolean victoria = false;
    static char turnoJugador = 'a';
    String posColocar = "";
    public static int numjugadores;

    public static ArrayList<Player> players = new ArrayList();
    public static ArrayList<SequencePlayer> seqplayers = new ArrayList();

    ImageIcon redToken = new javax.swing.ImageIcon(getClass().getResource("/tokens/redToken.png"));
    ImageIcon blueToken = new javax.swing.ImageIcon(getClass().getResource("/tokens/blueToken.png"));
    ImageIcon yellowToken = new javax.swing.ImageIcon(getClass().getResource("/tokens/yellowToken.png"));
    ImageIcon greenToken = new javax.swing.ImageIcon(getClass().getResource("/tokens/greenToken.png"));

    Random rand = new Random();

    public static Icon IconoBotonTableroSeleccionado = null;

    /*

    
    POR HACER
    
    PODER VALIDAR CON QUIEN ME VOY A IR
    
    HACER BOTON PARA SALIR DEL TABLERO
    
    HACER MAS COLORES
    
    CAMBIAR LO DE LA CANTIDAD DE JUGADORES DEL COMBO BOX
    
    HACER TIMER
    
     */
    //array para cargar las imagenes de la baraja
    private ArrayList<ImageIcon> cartas = new ArrayList();

    private String[][] handCardNames = {
        {"null", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "null"},
        {"6C", "5C", "4C", "3C", "2C", "AH", "KH", "QH", "10H", "10S"},
        {"7C", "AS", "2D", "3D", "4D", "5D", "6D", "7D", "9H", "QS"},
        {"8C", "KS", "6C", "5C", "4C", "3C", "2C", "8D", "8H", "KS"},
        {"9C", "QS", "7C", "6H", "5H", "4H", "AH", "9D", "7H", "AS"},
        {"10C", "10S", "8C", "7H", "2H", "3H", "KH", "10D", "6H", "2D"},
        {"QC", "9S", "9C", "8H", "9H", "10H", "QH", "QD", "5H", "3D"},
        {"KC", "8S", "10C", "QC", "KC", "AC", "AD", "KD", "4H", "4D"},
        {"AC", "7S", "6S", "5S", "4S", "3S", "2S", "2H", "3H", "5D"},
        {"null", "AD", "KD", "QD", "10D", "9D", "8D", "7D", "6D", "null"},};

    public ATABLEROCOLE(int numjugadores) {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        cambiarBarajas();
        cambiarNombreLabels();
        agregarImagenes();

        initComponents();
        pack();
        setLocationRelativeTo(null);
        setResizable(false);

        this.numjugadores = numjugadores;

        cuatrocartas.setVisible(false);
        cincocartas.setVisible(false);
        seiscartas.setVisible(false);
        sietecartas.setVisible(false);

        dosjugadoresizq.setVisible(false);
        tresjugadoresizq.setVisible(false);
        cuatrojugadoresizq.setVisible(false);
        seisjugadoresizq.setVisible(false);
        dosjugadoresizq.setVisible(false);

        dosjugadoresder.setVisible(false);
        tresjugadoresder.setVisible(false);
        cuatrojugadoresder.setVisible(false);
        seisjugadoresder.setVisible(false);
        ochojugadoresder.setVisible(false);

        resizeImages();
        vaciarTablero();
        generarJugadores();
        habilitarPaneles();
        agregarAcciones();
        cambiarBarajas();
        JOptionPane.showMessageDialog(this, "Turno de : " + seqplayers.get(0).getName());

        cambiarBarajas();
        cambiarNombreLabels();
    }

    //me agrega todas las imagenes al array de cartas
    public void agregarImagenes() {
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/10D.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/10D.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/10C.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/10C.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/10H.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/10H.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/10S.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/10S.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/2C.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/2C.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/2D.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/2D.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/2H.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/2H.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/2S.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/2S.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/3C.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/3C.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/3D.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/3D.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/3H.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/3H.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/3S.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/3S.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/4C.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/4C.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/4D.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/4D.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/4H.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/4H.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/4S.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/4S.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/5C.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/5C.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/5D.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/5D.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/5H.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/5H.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/5S.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/5S.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/6C.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/6C.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/6D.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/6D.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/6H.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/6H.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/6S.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/6S.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/7C.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/7C.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/7D.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/7D.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/7H.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/7H.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/7S.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/7S.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/8C.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/8C.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/8D.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/8D.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/8H.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/8H.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/8S.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/8S.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/9C.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/9C.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/9D.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/9D.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/9H.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/9H.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/9S.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/9S.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/AC.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/AC.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/AD.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/AD.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/AH.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/AH.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/AS.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/AS.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/JC.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/JC.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/JD.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/JD.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/JH.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/JH.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/JS.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/JS.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/KC.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/KC.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/KD.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/KD.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/KH.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/KH.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/KS.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/KS.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/QC.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/QC.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/QD.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/QD.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/QH.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/QH.jpg")));

        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/QS.jpg")));
        cartas.add(new javax.swing.ImageIcon(getClass().getResource("/cartas/QS.jpg")));

        System.out.println(cartas.size());
    }

    public void establecerIconos() {

    }

    //es igual a la funcion de cambair labels
    public void cambiarBarajas() {
        switch (numjugadores) {
            case 2:
                if (turnoJugador == 'a') {
                    sietecartasboton1.setIcon(seqplayers.get(0).cartas.get(0));
                    sietecartasboton2.setIcon(seqplayers.get(0).cartas.get(1));
                    sietecartasboton3.setIcon(seqplayers.get(0).cartas.get(2));
                    sietecartasboton4.setIcon(seqplayers.get(0).cartas.get(3));
                    sietecartasboton5.setIcon(seqplayers.get(0).cartas.get(4));
                    sietecartasboton6.setIcon(seqplayers.get(0).cartas.get(5));
                    sietecartasboton7.setIcon(seqplayers.get(0).cartas.get(6));
                } else if (turnoJugador == 'b') {
                    sietecartasboton1.setIcon(seqplayers.get(1).cartas.get(0));
                    sietecartasboton2.setIcon(seqplayers.get(1).cartas.get(1));
                    sietecartasboton3.setIcon(seqplayers.get(1).cartas.get(2));
                    sietecartasboton4.setIcon(seqplayers.get(1).cartas.get(3));
                    sietecartasboton5.setIcon(seqplayers.get(1).cartas.get(4));
                    sietecartasboton6.setIcon(seqplayers.get(1).cartas.get(5));
                    sietecartasboton7.setIcon(seqplayers.get(1).cartas.get(6));
                }
                break;

            case 3:
                if (turnoJugador == 'a') {
                    seiscartasboton1.setIcon(seqplayers.get(0).cartas.get(0));
                    seiscartasboton2.setIcon(seqplayers.get(0).cartas.get(1));
                    seiscartasboton3.setIcon(seqplayers.get(0).cartas.get(2));
                    seiscartasboton4.setIcon(seqplayers.get(0).cartas.get(3));
                    seiscartasboton5.setIcon(seqplayers.get(0).cartas.get(4));
                    seiscartasboton6.setIcon(seqplayers.get(0).cartas.get(5));
                } else if (turnoJugador == 'b') {
                    seiscartasboton1.setIcon(seqplayers.get(1).cartas.get(0));
                    seiscartasboton2.setIcon(seqplayers.get(1).cartas.get(1));
                    seiscartasboton3.setIcon(seqplayers.get(1).cartas.get(2));
                    seiscartasboton4.setIcon(seqplayers.get(1).cartas.get(3));
                    seiscartasboton5.setIcon(seqplayers.get(1).cartas.get(4));
                    seiscartasboton6.setIcon(seqplayers.get(1).cartas.get(5));
                } else if (turnoJugador == 'c') {
                    seiscartasboton1.setIcon(seqplayers.get(2).cartas.get(0));
                    seiscartasboton2.setIcon(seqplayers.get(2).cartas.get(1));
                    seiscartasboton3.setIcon(seqplayers.get(2).cartas.get(2));
                    seiscartasboton4.setIcon(seqplayers.get(2).cartas.get(3));
                    seiscartasboton5.setIcon(seqplayers.get(2).cartas.get(4));
                    seiscartasboton6.setIcon(seqplayers.get(2).cartas.get(5));
                }
                break;

            case 4:
                if (turnoJugador == 'a') {
                    sietecartasboton1.setIcon(seqplayers.get(0).cartas.get(0));
                    sietecartasboton2.setIcon(seqplayers.get(0).cartas.get(1));
                    sietecartasboton3.setIcon(seqplayers.get(0).cartas.get(2));
                    sietecartasboton4.setIcon(seqplayers.get(0).cartas.get(3));
                    sietecartasboton5.setIcon(seqplayers.get(0).cartas.get(4));
                    sietecartasboton6.setIcon(seqplayers.get(0).cartas.get(5));
                    sietecartasboton7.setIcon(seqplayers.get(0).cartas.get(6));
                } else if (turnoJugador == 'b') {
                    sietecartasboton1.setIcon(seqplayers.get(1).cartas.get(0));
                    sietecartasboton2.setIcon(seqplayers.get(1).cartas.get(1));
                    sietecartasboton3.setIcon(seqplayers.get(1).cartas.get(2));
                    sietecartasboton4.setIcon(seqplayers.get(1).cartas.get(3));
                    sietecartasboton5.setIcon(seqplayers.get(1).cartas.get(4));
                    sietecartasboton6.setIcon(seqplayers.get(1).cartas.get(5));
                    sietecartasboton7.setIcon(seqplayers.get(1).cartas.get(6));
                } else if (turnoJugador == 'c') {
                    sietecartasboton1.setIcon(seqplayers.get(2).cartas.get(0));
                    sietecartasboton2.setIcon(seqplayers.get(2).cartas.get(1));
                    sietecartasboton3.setIcon(seqplayers.get(2).cartas.get(2));
                    sietecartasboton4.setIcon(seqplayers.get(2).cartas.get(3));
                    sietecartasboton5.setIcon(seqplayers.get(2).cartas.get(4));
                    sietecartasboton6.setIcon(seqplayers.get(2).cartas.get(5));
                    sietecartasboton7.setIcon(seqplayers.get(2).cartas.get(6));
                } else if (turnoJugador == 'd') {
                    sietecartasboton1.setIcon(seqplayers.get(3).cartas.get(0));
                    sietecartasboton2.setIcon(seqplayers.get(3).cartas.get(1));
                    sietecartasboton3.setIcon(seqplayers.get(3).cartas.get(2));
                    sietecartasboton4.setIcon(seqplayers.get(3).cartas.get(3));
                    sietecartasboton5.setIcon(seqplayers.get(3).cartas.get(4));
                    sietecartasboton6.setIcon(seqplayers.get(3).cartas.get(5));
                    sietecartasboton7.setIcon(seqplayers.get(3).cartas.get(6));
                }
                break;

            case 6:
                if (turnoJugador == 'a') {
                    cincocartasboton1.setIcon(seqplayers.get(0).cartas.get(0));
                    cincocartasboton2.setIcon(seqplayers.get(0).cartas.get(1));
                    cincocartasboton3.setIcon(seqplayers.get(0).cartas.get(2));
                    cincocartasboton4.setIcon(seqplayers.get(0).cartas.get(3));
                    cincocartasboton5.setIcon(seqplayers.get(0).cartas.get(4));
                } else if (turnoJugador == 'b') {
                    cincocartasboton1.setIcon(seqplayers.get(1).cartas.get(0));
                    cincocartasboton2.setIcon(seqplayers.get(1).cartas.get(1));
                    cincocartasboton3.setIcon(seqplayers.get(1).cartas.get(2));
                    cincocartasboton4.setIcon(seqplayers.get(1).cartas.get(3));
                    cincocartasboton5.setIcon(seqplayers.get(1).cartas.get(4));
                } else if (turnoJugador == 'c') {
                    cincocartasboton1.setIcon(seqplayers.get(2).cartas.get(0));
                    cincocartasboton2.setIcon(seqplayers.get(2).cartas.get(1));
                    cincocartasboton3.setIcon(seqplayers.get(2).cartas.get(2));
                    cincocartasboton4.setIcon(seqplayers.get(2).cartas.get(3));
                    cincocartasboton5.setIcon(seqplayers.get(2).cartas.get(4));
                } else if (turnoJugador == 'd') {
                    cincocartasboton1.setIcon(seqplayers.get(3).cartas.get(0));
                    cincocartasboton2.setIcon(seqplayers.get(3).cartas.get(1));
                    cincocartasboton3.setIcon(seqplayers.get(3).cartas.get(2));
                    cincocartasboton4.setIcon(seqplayers.get(3).cartas.get(3));
                    cincocartasboton5.setIcon(seqplayers.get(3).cartas.get(4));
                } else if (turnoJugador == 'e') {
                    cincocartasboton1.setIcon(seqplayers.get(4).cartas.get(0));
                    cincocartasboton2.setIcon(seqplayers.get(4).cartas.get(1));
                    cincocartasboton3.setIcon(seqplayers.get(4).cartas.get(2));
                    cincocartasboton4.setIcon(seqplayers.get(4).cartas.get(3));
                    cincocartasboton5.setIcon(seqplayers.get(4).cartas.get(4));
                } else if (turnoJugador == 'f') {
                    cincocartasboton1.setIcon(seqplayers.get(5).cartas.get(0));
                    cincocartasboton2.setIcon(seqplayers.get(5).cartas.get(1));
                    cincocartasboton3.setIcon(seqplayers.get(5).cartas.get(2));
                    cincocartasboton4.setIcon(seqplayers.get(5).cartas.get(3));
                    cincocartasboton5.setIcon(seqplayers.get(5).cartas.get(4));
                }
                break;

            case 8:
                if (turnoJugador == 'a') {
                    cuatrocartasboton1.setIcon(seqplayers.get(0).cartas.get(0));
                    cuatrocartasboton2.setIcon(seqplayers.get(0).cartas.get(1));
                    cuatrocartasboton3.setIcon(seqplayers.get(0).cartas.get(2));
                    cuatrocartasboton4.setIcon(seqplayers.get(0).cartas.get(3));
                } else if (turnoJugador == 'b') {
                    cuatrocartasboton1.setIcon(seqplayers.get(1).cartas.get(0));
                    cuatrocartasboton2.setIcon(seqplayers.get(1).cartas.get(1));
                    cuatrocartasboton3.setIcon(seqplayers.get(1).cartas.get(2));
                    cuatrocartasboton4.setIcon(seqplayers.get(1).cartas.get(3));
                } else if (turnoJugador == 'c') {
                    cuatrocartasboton1.setIcon(seqplayers.get(2).cartas.get(0));
                    cuatrocartasboton2.setIcon(seqplayers.get(2).cartas.get(1));
                    cuatrocartasboton3.setIcon(seqplayers.get(2).cartas.get(2));
                    cuatrocartasboton4.setIcon(seqplayers.get(2).cartas.get(3));
                } else if (turnoJugador == 'd') {
                    cuatrocartasboton1.setIcon(seqplayers.get(3).cartas.get(0));
                    cuatrocartasboton2.setIcon(seqplayers.get(3).cartas.get(1));
                    cuatrocartasboton3.setIcon(seqplayers.get(3).cartas.get(2));
                    cuatrocartasboton4.setIcon(seqplayers.get(3).cartas.get(3));
                } else if (turnoJugador == 'e') {
                    cuatrocartasboton1.setIcon(seqplayers.get(4).cartas.get(0));
                    cuatrocartasboton2.setIcon(seqplayers.get(4).cartas.get(1));
                    cuatrocartasboton3.setIcon(seqplayers.get(4).cartas.get(2));
                    cuatrocartasboton4.setIcon(seqplayers.get(4).cartas.get(3));
                } else if (turnoJugador == 'f') {
                    cuatrocartasboton1.setIcon(seqplayers.get(5).cartas.get(0));
                    cuatrocartasboton2.setIcon(seqplayers.get(5).cartas.get(1));
                    cuatrocartasboton3.setIcon(seqplayers.get(5).cartas.get(2));
                    cuatrocartasboton4.setIcon(seqplayers.get(5).cartas.get(3));
                } else if (turnoJugador == 'g') {
                    cuatrocartasboton1.setIcon(seqplayers.get(6).cartas.get(0));
                    cuatrocartasboton2.setIcon(seqplayers.get(6).cartas.get(1));
                    cuatrocartasboton3.setIcon(seqplayers.get(6).cartas.get(2));
                    cuatrocartasboton4.setIcon(seqplayers.get(6).cartas.get(3));
                } else if (turnoJugador == 'h') {
                    cuatrocartasboton1.setIcon(seqplayers.get(7).cartas.get(0));
                    cuatrocartasboton2.setIcon(seqplayers.get(7).cartas.get(1));
                    cuatrocartasboton3.setIcon(seqplayers.get(7).cartas.get(2));
                    cuatrocartasboton4.setIcon(seqplayers.get(7).cartas.get(3));
                }
                break;
        }
    }

    //redimensiona los inconos y las cartas que uso
    public void resizeImages() {
        int width = 85; // Ancho deseado
        int height = 118; // Alto deseado

        Image Rimg = redToken.getImage();
        Image RnewImg = Rimg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        redToken = new ImageIcon(RnewImg);

        Image Bimg = blueToken.getImage();
        Image BnewImg = Bimg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        blueToken = new ImageIcon(BnewImg);

        Image Yimg = yellowToken.getImage();
        Image YnewImg = Yimg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        yellowToken = new ImageIcon(YnewImg);

        Image Gimg = greenToken.getImage();
        Image GnewImg = Gimg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        greenToken = new ImageIcon(GnewImg);

    }

    //esto me sirve simplemente para la clase de SELECCIONARJUGADORES para verificar si el array de players ya tiene un usuario con es enombre
    public static boolean buscarUsuario(String nombre) {
        for (Player p : players) {
            if (p.getUser().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    //me cambia los labels cada vez que se pasa de jugador, esta en sentiod antihorario, y esto tiene que ser horario entonces despues se cmabia
    public void cambiarNombreLabels() {
        int c = 0;
        switch (numjugadores) {
            case 2:
                switch (turnoJugador) {
                    case 'a':
                        nombrejugadoractual.setText(seqplayers.get(0).getName());
                        dosnombrejugador2.setText(seqplayers.get(1).getName());
                        break;

                    case 'b':
                        nombrejugadoractual.setText(seqplayers.get(1).getName());
                        dosnombrejugador2.setText(seqplayers.get(0).getName());
                        break;
                }
                break;

            case 3:
                switch (turnoJugador) {
                    case 'a':
                        nombrejugadoractual.setText(seqplayers.get(0).getName());
                        tresnombrejugador2.setText(seqplayers.get(1).getName());
                        tresnombrejugador3.setText(seqplayers.get(2).getName());
                        break;

                    case 'b':
                        nombrejugadoractual.setText(seqplayers.get(1).getName());
                        tresnombrejugador2.setText(seqplayers.get(2).getName());
                        tresnombrejugador3.setText(seqplayers.get(0).getName());
                        break;

                    case 'c':
                        nombrejugadoractual.setText(seqplayers.get(2).getName());
                        tresnombrejugador2.setText(seqplayers.get(0).getName());
                        tresnombrejugador3.setText(seqplayers.get(1).getName());
                        break;
                }
                break;

            case 4:
                switch (turnoJugador) {
                    case 'a':
                        nombrejugadoractual.setText(seqplayers.get(0).getName());
                        cuatronombrejugador2.setText(seqplayers.get(1).getName());
                        cuatronombrejugador3.setText(seqplayers.get(2).getName());
                        cuatronombrejugador4.setText(seqplayers.get(3).getName());
                        break;

                    case 'b':
                        nombrejugadoractual.setText(seqplayers.get(1).getName());
                        cuatronombrejugador2.setText(seqplayers.get(2).getName());
                        cuatronombrejugador3.setText(seqplayers.get(3).getName());
                        cuatronombrejugador4.setText(seqplayers.get(0).getName());
                        break;

                    case 'c':
                        nombrejugadoractual.setText(seqplayers.get(2).getName());
                        cuatronombrejugador2.setText(seqplayers.get(3).getName());
                        cuatronombrejugador3.setText(seqplayers.get(0).getName());
                        cuatronombrejugador4.setText(seqplayers.get(1).getName());
                        break;

                    case 'd':
                        nombrejugadoractual.setText(seqplayers.get(3).getName());
                        cuatronombrejugador2.setText(seqplayers.get(0).getName());
                        cuatronombrejugador3.setText(seqplayers.get(1).getName());
                        cuatronombrejugador4.setText(seqplayers.get(2).getName());
                        break;
                }
                break;

            case 6:
                switch (turnoJugador) {
                    case 'a':
                        nombrejugadoractual.setText(seqplayers.get(0).getName());
                        seisnombrejugador2.setText(seqplayers.get(1).getName());
                        seisnombrejugador3.setText(seqplayers.get(2).getName());
                        seisnombrejugador4.setText(seqplayers.get(3).getName());
                        seisnombrejugador5.setText(seqplayers.get(4).getName());
                        seisnombrejugador6.setText(seqplayers.get(5).getName());
                        break;

                    case 'b':
                        nombrejugadoractual.setText(seqplayers.get(1).getName());
                        seisnombrejugador2.setText(seqplayers.get(2).getName());
                        seisnombrejugador3.setText(seqplayers.get(3).getName());
                        seisnombrejugador4.setText(seqplayers.get(4).getName());
                        seisnombrejugador5.setText(seqplayers.get(5).getName());
                        seisnombrejugador6.setText(seqplayers.get(0).getName());
                        break;

                    case 'c':
                        nombrejugadoractual.setText(seqplayers.get(2).getName());
                        seisnombrejugador2.setText(seqplayers.get(3).getName());
                        seisnombrejugador3.setText(seqplayers.get(4).getName());
                        seisnombrejugador4.setText(seqplayers.get(5).getName());
                        seisnombrejugador5.setText(seqplayers.get(0).getName());
                        seisnombrejugador6.setText(seqplayers.get(1).getName());
                        break;

                    case 'd':
                        nombrejugadoractual.setText(seqplayers.get(3).getName());
                        seisnombrejugador2.setText(seqplayers.get(4).getName());
                        seisnombrejugador3.setText(seqplayers.get(5).getName());
                        seisnombrejugador4.setText(seqplayers.get(0).getName());
                        seisnombrejugador5.setText(seqplayers.get(1).getName());
                        seisnombrejugador6.setText(seqplayers.get(2).getName());
                        break;

                    case 'e':
                        nombrejugadoractual.setText(seqplayers.get(4).getName());
                        seisnombrejugador2.setText(seqplayers.get(5).getName());
                        seisnombrejugador3.setText(seqplayers.get(0).getName());
                        seisnombrejugador4.setText(seqplayers.get(1).getName());
                        seisnombrejugador5.setText(seqplayers.get(2).getName());
                        seisnombrejugador6.setText(seqplayers.get(3).getName());
                        break;

                    case 'f':
                        nombrejugadoractual.setText(seqplayers.get(5).getName());
                        seisnombrejugador2.setText(seqplayers.get(0).getName());
                        seisnombrejugador3.setText(seqplayers.get(1).getName());
                        seisnombrejugador4.setText(seqplayers.get(2).getName());
                        seisnombrejugador5.setText(seqplayers.get(3).getName());
                        seisnombrejugador6.setText(seqplayers.get(4).getName());
                        break;
                }
                break;

            case 8:
                switch (turnoJugador) {
                    case 'a':
                        nombrejugadoractual.setText(seqplayers.get(0).getName());
                        ochonombrejugador2.setText(seqplayers.get(1).getName());
                        ochonombrejugador3.setText(seqplayers.get(2).getName());
                        ochonombrejugador4.setText(seqplayers.get(3).getName());
                        ochonombrejugador5.setText(seqplayers.get(4).getName());
                        ochonombrejugador6.setText(seqplayers.get(5).getName());
                        ochonombrejugador7.setText(seqplayers.get(6).getName());
                        ochonombrejugador8.setText(seqplayers.get(7).getName());
                        break;

                    case 'b':
                        nombrejugadoractual.setText(seqplayers.get(1).getName());
                        ochonombrejugador2.setText(seqplayers.get(2).getName());
                        ochonombrejugador3.setText(seqplayers.get(3).getName());
                        ochonombrejugador4.setText(seqplayers.get(4).getName());
                        ochonombrejugador5.setText(seqplayers.get(5).getName());
                        ochonombrejugador6.setText(seqplayers.get(6).getName());
                        ochonombrejugador7.setText(seqplayers.get(7).getName());
                        ochonombrejugador8.setText(seqplayers.get(0).getName());
                        break;

                    case 'c':
                        nombrejugadoractual.setText(seqplayers.get(2).getName());
                        ochonombrejugador2.setText(seqplayers.get(3).getName());
                        ochonombrejugador3.setText(seqplayers.get(4).getName());
                        ochonombrejugador4.setText(seqplayers.get(5).getName());
                        ochonombrejugador5.setText(seqplayers.get(6).getName());
                        ochonombrejugador6.setText(seqplayers.get(7).getName());
                        ochonombrejugador7.setText(seqplayers.get(0).getName());
                        ochonombrejugador8.setText(seqplayers.get(1).getName());
                        break;

                    case 'd':
                        nombrejugadoractual.setText(seqplayers.get(3).getName());
                        ochonombrejugador2.setText(seqplayers.get(4).getName());
                        ochonombrejugador3.setText(seqplayers.get(5).getName());
                        ochonombrejugador4.setText(seqplayers.get(6).getName());
                        ochonombrejugador5.setText(seqplayers.get(7).getName());
                        ochonombrejugador6.setText(seqplayers.get(0).getName());
                        ochonombrejugador7.setText(seqplayers.get(1).getName());
                        ochonombrejugador8.setText(seqplayers.get(2).getName());
                        break;

                    case 'e':
                        nombrejugadoractual.setText(seqplayers.get(4).getName());
                        ochonombrejugador2.setText(seqplayers.get(5).getName());
                        ochonombrejugador3.setText(seqplayers.get(6).getName());
                        ochonombrejugador4.setText(seqplayers.get(7).getName());
                        ochonombrejugador5.setText(seqplayers.get(0).getName());
                        ochonombrejugador6.setText(seqplayers.get(1).getName());
                        ochonombrejugador7.setText(seqplayers.get(2).getName());
                        ochonombrejugador8.setText(seqplayers.get(3).getName());
                        break;

                    case 'f':
                        nombrejugadoractual.setText(seqplayers.get(5).getName());
                        ochonombrejugador2.setText(seqplayers.get(6).getName());
                        ochonombrejugador3.setText(seqplayers.get(7).getName());
                        ochonombrejugador4.setText(seqplayers.get(0).getName());
                        ochonombrejugador5.setText(seqplayers.get(1).getName());
                        ochonombrejugador6.setText(seqplayers.get(2).getName());
                        ochonombrejugador7.setText(seqplayers.get(3).getName());
                        ochonombrejugador8.setText(seqplayers.get(4).getName());
                        break;

                    case 'g':
                        nombrejugadoractual.setText(seqplayers.get(6).getName());
                        ochonombrejugador2.setText(seqplayers.get(7).getName());
                        ochonombrejugador3.setText(seqplayers.get(0).getName());
                        ochonombrejugador4.setText(seqplayers.get(1).getName());
                        ochonombrejugador5.setText(seqplayers.get(2).getName());
                        ochonombrejugador6.setText(seqplayers.get(3).getName());
                        ochonombrejugador7.setText(seqplayers.get(4).getName());
                        ochonombrejugador8.setText(seqplayers.get(5).getName());
                        break;

                    case 'h':
                        nombrejugadoractual.setText(seqplayers.get(7).getName());
                        ochonombrejugador2.setText(seqplayers.get(0).getName());
                        ochonombrejugador3.setText(seqplayers.get(1).getName());
                        ochonombrejugador4.setText(seqplayers.get(2).getName());
                        ochonombrejugador5.setText(seqplayers.get(3).getName());
                        ochonombrejugador6.setText(seqplayers.get(4).getName());
                        ochonombrejugador7.setText(seqplayers.get(5).getName());
                        ochonombrejugador8.setText(seqplayers.get(6).getName());
                        break;
                }
                break;
        }
    }

    //me genera los jugadores con sus usarios, colroes, cantidad de barajas, el simbolo que se va a utilizar en el array de tableroIconos,  y los puntos de cada jugador
    public void generarJugadores() {
        int c = 0;
        for (Player p : players) {
            if (numjugadores == 2) {
                if (c == 0) {
                    // Agregar al jugador actual al equipo correspondiente
                    SequencePlayer pl = new EquipoPropio(LOGIN.JUGADORACTUAL.getUser(), getFicha(LOGIN.JUGADORACTUAL.getColor()), generarBarajas(7), "0", LOGIN.JUGADORACTUAL.getPuntos());
                    seqplayers.add(pl);
                    c++;
                } else {
                    SequencePlayer pl = new Equipo2(p.getUser(), getFicha("rojo"), generarBarajas(7), "1", p.getPuntos());
                    seqplayers.add(pl);
                    c++;
                }
            } else if (numjugadores == 3) {
                if (c == 0) {
                    // Agregar al jugador actual al equipo correspondiente
                    SequencePlayer pl = new EquipoPropio(LOGIN.JUGADORACTUAL.getUser(), getFicha(LOGIN.JUGADORACTUAL.getColor()), generarBarajas(6), "0", LOGIN.JUGADORACTUAL.getPuntos());
                    seqplayers.add(pl);
                    c++;
                } else if (c == 1) {
                    SequencePlayer pl = new Equipo2(p.getUser(), getFicha("rojo"), generarBarajas(6), "1", p.getPuntos());
                    seqplayers.add(pl);
                    c++;
                } else if (c == 2) {
                    SequencePlayer pl = new Equipo3(p.getUser(), getFicha("amarillo"), generarBarajas(6), "2", p.getPuntos());
                    seqplayers.add(pl);
                    c++;
                }
            } else if (numjugadores == 4) {
                if (c == 0) {
                    // Agregar al jugador actual al equipo correspondiente
                    SequencePlayer pl = new EquipoPropio(LOGIN.JUGADORACTUAL.getUser(), getFicha(LOGIN.JUGADORACTUAL.getColor()), generarBarajas(7), "0", LOGIN.JUGADORACTUAL.getPuntos());
                    seqplayers.add(pl);
                    c++;
                } else if (c == 1) {
                    SequencePlayer pl = new EquipoPropio(p.getUser(), getFicha(MENUSWING.colorequipopropio), generarBarajas(7), "0", p.getPuntos());
                    seqplayers.add(pl);
                    c++;
                } else if (c == 2 || c == 3) {
                    SequencePlayer pl = new Equipo2(p.getUser(), getFicha("rojo"), generarBarajas(7), "1", p.getPuntos());
                    seqplayers.add(pl);
                    c++;
                }
            } else if (numjugadores == 6) {
                if (c == 0) {
                    // Agregar al jugador actual al equipo correspondiente
                    SequencePlayer pl = new EquipoPropio(LOGIN.JUGADORACTUAL.getUser(), getFicha(LOGIN.JUGADORACTUAL.getColor()), generarBarajas(5), "0", LOGIN.JUGADORACTUAL.getPuntos());
                    seqplayers.add(pl);
                    c++;
                } else if (c == 1) {
                    // Agregar al jugador actual al equipo correspondiente
                    SequencePlayer pl = new EquipoPropio(p.getUser(), getFicha(MENUSWING.colorequipopropio), generarBarajas(5), "0", p.getPuntos());
                    seqplayers.add(pl);
                    c++;
                } else if (c == 2 || c == 3) {
                    SequencePlayer pl = new Equipo2(p.getUser(), getFicha("rojo"), generarBarajas(5), "1", p.getPuntos());
                    seqplayers.add(pl);
                    c++;
                } else if (c == 4 || c == 5) {
                    SequencePlayer pl = new Equipo3(p.getUser(), getFicha("amarillo"), generarBarajas(5), "2", p.getPuntos());
                    seqplayers.add(pl);
                    c++;
                }
            } else if (numjugadores == 8) {
                if (c == 0) {
                    // Agregar al jugador actual al equipo correspondiente
                    SequencePlayer pl = new EquipoPropio(LOGIN.JUGADORACTUAL.getUser(), getFicha(LOGIN.JUGADORACTUAL.getColor()), generarBarajas(4), "0", LOGIN.JUGADORACTUAL.getPuntos());
                    seqplayers.add(pl);
                    c++;
                } else if (c == 1 || c == 2 || c == 3) {
                    // Agregar al jugador actual al equipo correspondiente
                    SequencePlayer pl = new EquipoPropio(p.getUser(), getFicha(MENUSWING.colorequipopropio), generarBarajas(4), "0", p.getPuntos());
                    seqplayers.add(pl);
                    c++;
                } else if (c == 4 || c == 5 || c == 6 || c == 7) {
                    SequencePlayer pl = new Equipo2(p.getUser(), getFicha("rojo"), generarBarajas(4), "1", p.getPuntos());
                    seqplayers.add(pl);
                    c++;
                }
            }

        }
    }

    //me genera las barajas para cuada uno de los jugadores,las barajas son atributos de cada uno de los objetos de sequence players
    public ArrayList<ImageIcon> generarBarajas(int num) {
        ArrayList<ImageIcon> baraja = new ArrayList();
        int c = 0;
        while (c < num) {
            int i = rand.nextInt(cartas.size());
            baraja.add(cartas.get(i));
            c++;
        }

        return baraja;
    }

    //retorna el color de la ficha, esto me sirve para comparar lo que es el atributo del objeto con el color que se escogio, y me devuelve el icono
    public ImageIcon getFicha(String color) {
        switch (color) {
            case "rojo":
                return redToken;
            case "azul":
                return blueToken;
            case "verde":
                return greenToken;
            case "amarillo":
                return yellowToken;
            default:
                return null;
        }
    }

    //vacia el tablero que contiene la informacion en strings de cada uno de las fichas de los jugadores cuando termina el juego
    public void vaciarTablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tableroIconos[i][j] = "";
            }
        }
        tableroIconos[0][0] = "null";
        tableroIconos[9][0] = "null";
        tableroIconos[9][9] = "null";
        tableroIconos[0][9] = "null";
    }

    public void habilitarPaneles() {
        switch (numjugadores) {
            case 2:
                dosjugadoresizq.setVisible(true);
                dosjugadoresder.setVisible(true);
                sietecartas.setVisible(true);
                break;
            case 3:
                tresjugadoresizq.setVisible(true);
                tresjugadoresder.setVisible(true);
                seiscartas.setVisible(true);
                break;
            case 4:
                cuatrojugadoresizq.setVisible(true);
                cuatrojugadoresder.setVisible(true);
                sietecartas.setVisible(true);
                break;
            case 6:
                seisjugadoresizq.setVisible(true);
                seisjugadoresder.setVisible(true);
                cincocartas.setVisible(true);
                break;
            case 8:
                dosjugadoresizq.setVisible(true);
                ochojugadoresder.setVisible(true);
                cuatrocartas.setVisible(true);

        }
    }

    //chequea si el icono es vacio
    public boolean chequearIconoVacio(String pos) {
        int x = Integer.parseInt(Character.toString(pos.charAt(0)));
        int y = Integer.parseInt(Character.toString(pos.charAt(1)));
        return tableroIconos[x][y].equals("");
    }

    //funcion incompleta
    public boolean chequearCartaEspecial(String pos) {
        return true;
    }

    //funcion gane
    public boolean chequearGane(String currentColor) {
        int rowCount = 0;
        int diagCount = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (checkConsecutive(tableroIconos, i, j, 0, 1, currentColor, 5)) {
                    rowCount++;
                    if (rowCount >= 2) {
                        return true;
                    }
                } else {
                    rowCount = 0;
                }

                if (checkConsecutive(tableroIconos, i, j, 1, 1, currentColor, 5)
                        || checkConsecutive(tableroIconos, i, j, 1, -1, currentColor, 5)) {
                    diagCount++;
                    if (diagCount >= 2) {
                        return true;
                    }
                } else {
                    diagCount = 0;
                }
            }
        }
        return false;
    }

    //funcion gane
    private boolean checkConsecutive(String[][] board, int x, int y, int dx, int dy, String targetColor, int targetCount) {
        int count = 1;

        while (x >= 0 && x < 10 && y >= 0 && y < 10 && board[x][y].equals(targetColor)) {
            count++;
            if (count >= targetCount) {
                return true;
            }
            x += dx;
            y += dy;
        }
        return false;
    }

    //verifica si el boton que se presiono es cualqueira de los bootnes de la barjaa o no
    public boolean validarBotonBaraja(ActionEvent e) {
        if (e.getSource() == cuatrocartasboton1 || e.getSource() == cuatrocartasboton2 || e.getSource() == cuatrocartasboton3 || e.getSource() == cuatrocartasboton4
                || e.getSource() == cincocartasboton1 || e.getSource() == cincocartasboton2 || e.getSource() == cincocartasboton3 || e.getSource() == cincocartasboton4 || e.getSource() == cincocartasboton5
                || e.getSource() == seiscartasboton1 || e.getSource() == seiscartasboton2 || e.getSource() == seiscartasboton3 || e.getSource() == seiscartasboton4 || e.getSource() == seiscartasboton5 || e.getSource() == seiscartasboton6
                || e.getSource() == sietecartasboton1 || e.getSource() == sietecartasboton2 || e.getSource() == sietecartasboton3 || e.getSource() == sietecartasboton4 || e.getSource() == sietecartasboton5 || e.getSource() == sietecartasboton6 || e.getSource() == sietecartasboton7) {
            return true;
        }
        return false;
    }

    //lo que hace esta funcion es simplemente deshabilitar los botones, pero la verdad no funciona bien
    public boolean botonBaraja(ActionEvent e) {
        if (!validarBotonBaraja(e)) {
            if (getCords(e) == getCordsBaraja(e)) {
                System.out.println(getCordsBaraja(e.getSource()));
                int x = Integer.valueOf(Character.toString(getCords(e.getSource()).charAt(0)));
                int y = Integer.valueOf(Character.toString(getCords(e.getSource()).charAt(1)));
                String boton = x + "" + y;
                deshabilitarBotones(getBoton(boton).getIcon());
                System.out.println("coordenada buena");
                return true;
            } else {
                System.out.println("coordenada mala");
                return false;
            }

        } else {
            System.out.println("validar incorrecto");
            return false;
        }

    }

    //esta funcion todavia no funciona bien, pero consigue los botones con las coordenadas, y compara si la carta coincide con el string que tiene cada boton como texot
    //como te dije, esta funcion no funciona ya que era como tenia antes el proyecto, ahora la voy a cambiar para que no compare cartas si no iconos.
    public void deshabilitarBotones(Icon iconoSeleccionado) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton botonActual = getBoton(i + "" + j);
                JLabel labelActual = getLabel(i + "" + j);

                // Verifica si el icono del botón no es nulo antes de compararlo
                Icon iconoBoton = botonActual.getIcon();
                if (iconoBoton != null && iconoBoton.equals(iconoSeleccionado)) {
                    botonActual.setEnabled(false); // Debe ser false para deshabilitar
                    labelActual.setBackground(Color.GREEN);
                } else {
                    botonActual.setEnabled(true); // Debe ser true para habilitar otros botones
                    labelActual.setBackground(null);
                }
            }
        }
    }

    public void habilitarBotones() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                getBoton(i + "" + j).setEnabled(true);
                getLabel(i + "" + j).setBackground(null);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(SALIRTABLERO)) {
            MENUSWING menu = new MENUSWING();
            JOptionPane.showMessageDialog(this, "¡Vuelva pronto!\nVolverá al menú principal.");
            this.dispose();
            menu.setVisible(true);
        } else if (e.getSource().equals(DESCARTAR)) {

        } else if (e.getSource().equals(CAMBIARPOS)) {

        } else if (!validarBotonBaraja(e)) {
            int x = Integer.parseInt(Character.toString(getCords(e.getSource()).charAt(0)));
            int y = Integer.parseInt(Character.toString(getCords(e.getSource()).charAt(1)));
            posColocar = x + "" + y;

            cambiarBarajas();

            switch (numjugadores) {
                case 2:
                    // Resto de tu código para 2 jugadores
                    break;

                case 3:
                    // Resto de tu código para 3 jugadores
                    break;

                case 4:
                    System.out.println(turnoJugador);

                    switch (turnoJugador) {
                        case 'a':
                            cambiarBarajas();

                            if (IconoBotonTableroSeleccionado == null) {
                                IconoBotonTableroSeleccionado = getBoton(x + "" + y).getIcon();
                                ultimacarta.setIcon(IconoBotonTableroSeleccionado);
                                deshabilitarBotones(IconoBotonTableroSeleccionado);
                            } else {
                                // Si no es la primera selección, compara iconos
                                Icon iconoTablero = getBoton(x + "" + y).getIcon();
                                if (iconoTablero.equals(IconoBotonTableroSeleccionado)) {
                                    // Las imágenes son iguales, realiza las acciones necesarias
                                    getBoton(posColocar).setIcon(seqplayers.get(0).color);
                                    tableroIconos[x][y] = seqplayers.get(0).simbolo;

                                    // Cambia el turno al siguiente jugador
                                    turnoJugador = 'b';
                                    cambiarNombreLabels();
                                    habilitarBotones();
                                    JOptionPane.showMessageDialog(this, "Turno de : " + seqplayers.get(1).getName());
                                    if (chequearGane(seqplayers.get(0).simbolo)) {
                                        vaciarArray();
                                        JOptionPane.showMessageDialog(this, "¡Terminó el juego!");
                                        System.exit(0);
                                    }

                                    // Limpia el icono del botón tablero seleccionado
                                    IconoBotonTableroSeleccionado = null;
                                } else {
                                    JOptionPane.showMessageDialog(this, "Las cartas no coinciden");
                                    IconoBotonTableroSeleccionado = null;
                                }
                            }

                            break;

                        case 'b':
                            cambiarBarajas();

                            if (IconoBotonTableroSeleccionado == null) {
                                // Si es la primera selección, guarda el icono y deshabilita otros botones
                                IconoBotonTableroSeleccionado = getBoton(x + "" + y).getIcon();
                                ultimacarta.setIcon(IconoBotonTableroSeleccionado);
                                deshabilitarBotones(IconoBotonTableroSeleccionado);
                            } else {
                                // Si no es la primera selección, compara iconos
                                Icon iconoTablero = getBoton(x + "" + y).getIcon();
                                if (iconoTablero.equals(IconoBotonTableroSeleccionado)) {
                                    // Las imágenes son iguales, realiza las acciones necesarias
                                    getBoton(posColocar).setIcon(seqplayers.get(1).color);
                                    tableroIconos[x][y] = seqplayers.get(1).simbolo;

                                    // Cambia el turno al siguiente jugador
                                    turnoJugador = 'c';
                                    cambiarNombreLabels();
                                    habilitarBotones();
                                    JOptionPane.showMessageDialog(this, "Turno de : " + seqplayers.get(2).getName());
                                    if (chequearGane(seqplayers.get(1).simbolo)) {
                                        vaciarArray();
                                        JOptionPane.showMessageDialog(this, "¡Terminó el juego!");
                                        System.exit(0);
                                    }

                                    // Limpia el icono del botón tablero seleccionado
                                    IconoBotonTableroSeleccionado = null;
                                } else {
                                    JOptionPane.showMessageDialog(this, "Las cartas no coinciden");
                                    IconoBotonTableroSeleccionado = null;
                                }
                            }

                            break;

                        case 'c':
                            cambiarBarajas();

                            if (IconoBotonTableroSeleccionado == null) {
                                // Si es la primera selección, guarda el icono y deshabilita otros botones
                                IconoBotonTableroSeleccionado = getBoton(x + "" + y).getIcon();
                                ultimacarta.setIcon(IconoBotonTableroSeleccionado);
                                deshabilitarBotones(IconoBotonTableroSeleccionado);
                            } else {
                                // Si no es la primera selección, compara iconos
                                Icon iconoTablero = getBoton(x + "" + y).getIcon();
                                if (iconoTablero.equals(IconoBotonTableroSeleccionado)) {
                                    // Las imágenes son iguales, realiza las acciones necesarias
                                    getBoton(posColocar).setIcon(seqplayers.get(2).color);
                                    tableroIconos[x][y] = seqplayers.get(2).simbolo;

                                    // Cambia el turno al siguiente jugador
                                    turnoJugador = 'd';
                                    cambiarNombreLabels();
                                    habilitarBotones();
                                    JOptionPane.showMessageDialog(this, "Turno de : " + seqplayers.get(3).getName());
                                    if (chequearGane(seqplayers.get(2).simbolo)) {
                                        vaciarArray();
                                        JOptionPane.showMessageDialog(this, "¡Terminó el juego!");
                                        System.exit(0);
                                    }

                                    // Limpia el icono del botón tablero seleccionado
                                    IconoBotonTableroSeleccionado = null;
                                } else {
                                    JOptionPane.showMessageDialog(this, "Las cartas no coinciden");
                                    IconoBotonTableroSeleccionado = null;
                                }
                            }

                            break;

                        case 'd':
                            cambiarBarajas();

                            if (IconoBotonTableroSeleccionado == null) {
                                // Si es la primera selección, guarda el icono y deshabilita otros botones
                                IconoBotonTableroSeleccionado = getBoton(x + "" + y).getIcon();
                                ultimacarta.setIcon(IconoBotonTableroSeleccionado);
                                deshabilitarBotones(IconoBotonTableroSeleccionado);
                            } else {
                                // Si no es la primera selección, compara iconos
                                Icon iconoTablero = getBoton(x + "" + y).getIcon();
                                if (iconoTablero.equals(IconoBotonTableroSeleccionado)) {
                                    // Las imágenes son iguales, realiza las acciones necesarias
                                    getBoton(posColocar).setIcon(seqplayers.get(3).color);
                                    tableroIconos[x][y] = seqplayers.get(3).simbolo;

                                    // Cambia el turno al siguiente jugador
                                    turnoJugador = 'a'; // Cambia al jugador 'a' en lugar de 'd'
                                    cambiarNombreLabels();
                                    habilitarBotones();
                                    JOptionPane.showMessageDialog(this, "Turno de : " + seqplayers.get(0).getName());
                                    if (chequearGane(seqplayers.get(3).simbolo)) {
                                        vaciarArray();
                                        JOptionPane.showMessageDialog(this, "¡Terminó el juego!");
                                        System.exit(0);
                                    }

                                    // Limpia el icono del botón tablero seleccionado
                                    IconoBotonTableroSeleccionado = null;
                                } else {
                                    JOptionPane.showMessageDialog(this, "Las cartas no coinciden");
                                    IconoBotonTableroSeleccionado = null;
                                }
                            }
                            break;

                        // Resto de los casos para el jugador 'b', 'c', 'd'
                        // ...
                    }
                    break;

                case 6:
                    // Resto de tu código para 6 jugadores
                    break;

                case 8:
                    // Resto de tu código para 8 jugadores
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "no me funcionan los botones de la baraja :(\ntenga piedad inge");
        }
    }

    //vacia los arrays ya que los arrays que estan siendo utilziados en esta clase son propios de esta calse, y se generan despues de entrar a la clase de SELECCIONARJUGADORES
    public void vaciarArray() {
        players.clear();
        seqplayers.clear();
    }

    //lo que hace esta funcion es que te consigue el boton de la baraja presionado, esto lo utilizo para agarrar el icono de la carta seleccionado
    public JButton getBotonBaraja(String posicion) {
        switch (posicion) {
            case "41":
                return cuatrocartasboton1;
            case "42":
                return cuatrocartasboton2;
            case "43":
                return cuatrocartasboton3;
            case "44":
                return cuatrocartasboton4;
            case "51":
                return cincocartasboton1;
            case "52":
                return cincocartasboton2;
            case "53":
                return cincocartasboton3;
            case "54":
                return cincocartasboton4;
            case "55":
                return cincocartasboton5;
            case "61":
                return seiscartasboton1;
            case "62":
                return seiscartasboton2;
            case "63":
                return seiscartasboton3;
            case "64":
                return seiscartasboton4;
            case "65":
                return seiscartasboton5;
            case "66":
                return seiscartasboton6;
            case "71":
                return sietecartasboton1;
            case "72":
                return sietecartasboton2;
            case "73":
                return sietecartasboton3;
            case "74":
                return sietecartasboton4;
            case "75":
                return sietecartasboton5;
            case "76":
                return sietecartasboton6;
            case "77":
                return sietecartasboton7;
            default:
                return null;
        }
    }

    public String getCordsBaraja(Object boton) {
        if (boton == cuatrocartasboton1) {
            return "41";
        } else if (boton == cuatrocartasboton2) {
            return "42";
        } else if (boton == cuatrocartasboton3) {
            return "43";
        } else if (boton == cuatrocartasboton4) {
            return "44";
        } else if (boton == cincocartasboton1) {
            return "51";
        } else if (boton == cincocartasboton2) {
            return "52";
        } else if (boton == cincocartasboton3) {
            return "53";
        } else if (boton == cincocartasboton4) {
            return "54";
        } else if (boton == cincocartasboton5) {
            return "55";
        } else if (boton == seiscartasboton1) {
            return "61";
        } else if (boton == seiscartasboton2) {
            return "62";
        } else if (boton == seiscartasboton3) {
            return "63";
        } else if (boton == seiscartasboton4) {
            return "64";
        } else if (boton == seiscartasboton5) {
            return "65";
        } else if (boton == seiscartasboton6) {
            return "66";
        } else if (boton == sietecartasboton1) {
            return "71";
        } else if (boton == sietecartasboton2) {
            return "72";
        } else if (boton == sietecartasboton3) {
            return "73";
        } else if (boton == sietecartasboton4) {
            return "74";
        } else if (boton == sietecartasboton5) {
            return "75";
        } else if (boton == sietecartasboton6) {
            return "76";
        } else if (boton == sietecartasboton7) {
            return "77";
        } else {
            return "";
        }
    }

    //para conseguir las coordenadas de los botones despues de presionarlos y usarlas en el array
    public String getCords(Object boton) {
        if (boton == boton00) {
            return "00";
        } else if (boton == boton01) {
            return "01";
        } else if (boton == boton02) {
            return "02";
        } else if (boton == boton03) {
            return "03";
        } else if (boton == boton04) {
            return "04";
        } else if (boton == boton05) {
            return "05";
        } else if (boton == boton06) {
            return "06";
        } else if (boton == boton07) {
            return "07";
        } else if (boton == boton08) {
            return "08";
        } else if (boton == boton09) {
            return "09";
        } else if (boton == boton10) {
            return "10";
        } else if (boton == boton11) {
            return "11";
        } else if (boton == boton12) {
            return "12";
        } else if (boton == boton13) {
            return "13";
        } else if (boton == boton14) {
            return "14";
        } else if (boton == boton15) {
            return "15";
        } else if (boton == boton16) {
            return "16";
        } else if (boton == boton17) {
            return "17";
        } else if (boton == boton18) {
            return "18";
        } else if (boton == boton19) {
            return "19";
        } else if (boton == boton20) {
            return "20";
        } else if (boton == boton21) {
            return "21";
        } else if (boton == boton22) {
            return "22";
        } else if (boton == boton23) {
            return "23";
        } else if (boton == boton24) {
            return "24";
        } else if (boton == boton25) {
            return "25";
        } else if (boton == boton26) {
            return "26";
        } else if (boton == boton27) {
            return "27";
        } else if (boton == boton28) {
            return "28";
        } else if (boton == boton29) {
            return "29";
        } else if (boton == boton30) {
            return "30";
        } else if (boton == boton31) {
            return "31";
        } else if (boton == boton32) {
            return "32";
        } else if (boton == boton33) {
            return "33";
        } else if (boton == boton34) {
            return "34";
        } else if (boton == boton35) {
            return "35";
        } else if (boton == boton36) {
            return "36";
        } else if (boton == boton37) {
            return "37";
        } else if (boton == boton38) {
            return "38";
        } else if (boton == boton39) {
            return "39";
        } else if (boton == boton40) {
            return "40";
        } else if (boton == boton41) {
            return "41";
        } else if (boton == boton42) {
            return "42";
        } else if (boton == boton43) {
            return "43";
        } else if (boton == boton44) {
            return "44";
        } else if (boton == boton45) {
            return "45";
        } else if (boton == boton46) {
            return "46";
        } else if (boton == boton47) {
            return "47";
        } else if (boton == boton48) {
            return "48";
        } else if (boton == boton49) {
            return "49";
        } else if (boton == boton50) {
            return "50";
        } else if (boton == boton51) {
            return "51";
        } else if (boton == boton52) {
            return "52";
        } else if (boton == boton53) {
            return "53";
        } else if (boton == boton54) {
            return "54";
        } else if (boton == boton55) {
            return "55";
        } else if (boton == boton56) {
            return "56";
        } else if (boton == boton57) {
            return "57";
        } else if (boton == boton58) {
            return "58";
        } else if (boton == boton59) {
            return "59";
        } else if (boton == boton60) {
            return "60";
        } else if (boton == boton61) {
            return "61";
        } else if (boton == boton62) {
            return "62";
        } else if (boton == boton63) {
            return "63";
        } else if (boton == boton64) {
            return "64";
        } else if (boton == boton65) {
            return "65";
        } else if (boton == boton66) {
            return "66";
        } else if (boton == boton67) {
            return "67";
        } else if (boton == boton68) {
            return "68";
        } else if (boton == boton69) {
            return "69";
        } else if (boton == boton70) {
            return "70";
        } else if (boton == boton71) {
            return "71";
        } else if (boton == boton72) {
            return "72";
        } else if (boton == boton73) {
            return "73";
        } else if (boton == boton74) {
            return "74";
        } else if (boton == boton75) {
            return "75";
        } else if (boton == boton76) {
            return "76";
        } else if (boton == boton77) {
            return "77";
        } else if (boton == boton78) {
            return "78";
        } else if (boton == boton79) {
            return "79";
        } else if (boton == boton80) {
            return "80";
        } else if (boton == boton81) {
            return "81";
        } else if (boton == boton82) {
            return "82";
        } else if (boton == boton83) {
            return "83";
        } else if (boton == boton84) {
            return "84";
        } else if (boton == boton85) {
            return "85";
        } else if (boton == boton86) {
            return "86";
        } else if (boton == boton87) {
            return "87";
        } else if (boton == boton88) {
            return "88";
        } else if (boton == boton89) {
            return "89";
        } else if (boton == boton90) {
            return "90";
        } else if (boton == boton91) {
            return "91";
        } else if (boton == boton92) {
            return "92";
        } else if (boton == boton93) {
            return "93";
        } else if (boton == boton94) {
            return "94";
        } else if (boton == boton95) {
            return "95";
        } else if (boton == boton96) {
            return "96";
        } else if (boton == boton97) {
            return "97";
        } else if (boton == boton98) {
            return "98";
        } else if (boton == boton99) {
            return "99";
        } else {
            return "";
        }
    }

    //para conseguir el boton dependiendo de la poscion donde estoy, se utiliza para darle un icono al boton   
    public JButton getBoton(String posicion) {
        switch (posicion) {
            case "00":
                return boton00;
            case "01":
                return boton01;
            case "02":
                return boton02;
            case "03":
                return boton03;
            case "04":
                return boton04;
            case "05":
                return boton05;
            case "06":
                return boton06;
            case "07":
                return boton07;
            case "08":
                return boton08;
            case "09":
                return boton09;
            case "10":
                return boton10;
            case "11":
                return boton11;
            case "12":
                return boton12;
            case "13":
                return boton13;
            case "14":
                return boton14;
            case "15":
                return boton15;
            case "16":
                return boton16;
            case "17":
                return boton17;
            case "18":
                return boton18;
            case "19":
                return boton19;
            case "20":
                return boton20;
            case "21":
                return boton21;
            case "22":
                return boton22;
            case "23":
                return boton23;
            case "24":
                return boton24;
            case "25":
                return boton25;
            case "26":
                return boton26;
            case "27":
                return boton27;
            case "28":
                return boton28;
            case "29":
                return boton29;
            case "30":
                return boton30;
            case "31":
                return boton31;
            case "32":
                return boton32;
            case "33":
                return boton33;
            case "34":
                return boton34;
            case "35":
                return boton35;
            case "36":
                return boton36;
            case "37":
                return boton37;
            case "38":
                return boton38;
            case "39":
                return boton39;
            case "40":
                return boton40;
            case "41":
                return boton41;
            case "42":
                return boton42;
            case "43":
                return boton43;
            case "44":
                return boton44;
            case "45":
                return boton45;
            case "46":
                return boton46;
            case "47":
                return boton47;
            case "48":
                return boton48;
            case "49":
                return boton49;
            case "50":
                return boton50;
            case "51":
                return boton51;
            case "52":
                return boton52;
            case "53":
                return boton53;
            case "54":
                return boton54;
            case "55":
                return boton55;
            case "56":
                return boton56;
            case "57":
                return boton57;
            case "58":
                return boton58;
            case "59":
                return boton59;
            case "60":
                return boton60;
            case "61":
                return boton61;
            case "62":
                return boton62;
            case "63":
                return boton63;
            case "64":
                return boton64;
            case "65":
                return boton65;
            case "66":
                return boton66;
            case "67":
                return boton67;
            case "68":
                return boton68;
            case "69":
                return boton69;
            case "70":
                return boton70;
            case "71":
                return boton71;
            case "72":
                return boton72;
            case "73":
                return boton73;
            case "74":
                return boton74;
            case "75":
                return boton75;
            case "76":
                return boton76;
            case "77":
                return boton77;
            case "78":
                return boton78;
            case "79":
                return boton79;
            case "80":
                return boton80;
            case "81":
                return boton81;
            case "82":
                return boton82;
            case "83":
                return boton83;
            case "84":
                return boton84;
            case "85":
                return boton85;
            case "86":
                return boton86;
            case "87":
                return boton87;
            case "88":
                return boton88;
            case "89":
                return boton89;
            case "90":
                return boton90;
            case "91":
                return boton91;
            case "92":
                return boton92;
            case "93":
                return boton93;
            case "94":
                return boton94;
            case "95":
                return boton95;
            case "96":
                return boton96;
            case "97":
                return boton97;
            case "98":
                return boton98;
            case "99":
                return boton99;
            default:
                return null;
        }
    }

    //Esta funcion es para conseguir el label atraves de la posicion con los ints (x y) para despues a traves de esta funcion ponerle los iconos de los tokens
    public JLabel getLabel(String posicion) {
        switch (posicion) {
            case "00":
                return label00;
            case "01":
                return label01;
            case "02":
                return label02;
            case "03":
                return label03;
            case "04":
                return label04;
            case "05":
                return label05;
            case "06":
                return label06;
            case "07":
                return label07;
            case "08":
                return label08;
            case "09":
                return label09;
            case "10":
                return label10;
            case "11":
                return label11;
            case "12":
                return label12;
            case "13":
                return label13;
            case "14":
                return label14;
            case "15":
                return label15;
            case "16":
                return label16;
            case "17":
                return label17;
            case "18":
                return label18;
            case "19":
                return label19;
            case "20":
                return label20;
            case "21":
                return label21;
            case "22":
                return label22;
            case "23":
                return label23;
            case "24":
                return label24;
            case "25":
                return label25;
            case "26":
                return label26;
            case "27":
                return label27;
            case "28":
                return label28;
            case "29":
                return label29;
            case "30":
                return label30;
            case "31":
                return label31;
            case "32":
                return label32;
            case "33":
                return label33;
            case "34":
                return label34;
            case "35":
                return label35;
            case "36":
                return label36;
            case "37":
                return label37;
            case "38":
                return label38;
            case "39":
                return label39;
            case "40":
                return label40;
            case "41":
                return label41;
            case "42":
                return label42;
            case "43":
                return label43;
            case "44":
                return label44;
            case "45":
                return label45;
            case "46":
                return label46;
            case "47":
                return label47;
            case "48":
                return label48;
            case "49":
                return label49;
            case "50":
                return label50;
            case "51":
                return label51;
            case "52":
                return label52;
            case "53":
                return label53;
            case "54":
                return label54;
            case "55":
                return label55;
            case "56":
                return label56;
            case "57":
                return label57;
            case "58":
                return label58;
            case "59":
                return label59;
            case "60":
                return label60;
            case "61":
                return label61;
            case "62":
                return label62;
            case "63":
                return label63;
            case "64":
                return label64;
            case "65":
                return label65;
            case "66":
                return label66;
            case "67":
                return label67;
            case "68":
                return label68;
            case "69":
                return label69;
            case "70":
                return label70;
            case "71":
                return label71;
            case "72":
                return label72;
            case "73":
                return label73;
            case "74":
                return label74;
            case "75":
                return label75;
            case "76":
                return label76;
            case "77":
                return label77;
            case "78":
                return label78;
            case "79":
                return label79;
            case "80":
                return label80;
            case "81":
                return label81;
            case "82":
                return label82;
            case "83":
                return label83;
            case "84":
                return label84;
            case "85":
                return label85;
            case "86":
                return label86;
            case "87":
                return label87;
            case "88":
                return label88;
            case "89":
                return label89;
            case "90":
                return label90;
            case "91":
                return label91;
            case "92":
                return label92;
            case "93":
                return label93;
            case "94":
                return label94;
            case "95":
                return label95;
            case "96":
                return label96;
            case "97":
                return label97;
            case "98":
                return label98;
            case "99":
                return label99;
            default:
                return null;
        }
    }

    void agregarAcciones() {
        boton00.addActionListener(this);
        boton01.addActionListener(this);
        boton02.addActionListener(this);
        boton03.addActionListener(this);
        boton04.addActionListener(this);
        boton05.addActionListener(this);
        boton06.addActionListener(this);
        boton07.addActionListener(this);
        boton08.addActionListener(this);
        boton09.addActionListener(this);
        boton10.addActionListener(this);
        boton11.addActionListener(this);
        boton12.addActionListener(this);
        boton13.addActionListener(this);
        boton14.addActionListener(this);
        boton15.addActionListener(this);
        boton16.addActionListener(this);
        boton17.addActionListener(this);
        boton18.addActionListener(this);
        boton19.addActionListener(this);
        boton20.addActionListener(this);
        boton21.addActionListener(this);
        boton22.addActionListener(this);
        boton23.addActionListener(this);
        boton24.addActionListener(this);
        boton25.addActionListener(this);
        boton26.addActionListener(this);
        boton27.addActionListener(this);
        boton28.addActionListener(this);
        boton29.addActionListener(this);
        boton30.addActionListener(this);
        boton31.addActionListener(this);
        boton32.addActionListener(this);
        boton33.addActionListener(this);
        boton34.addActionListener(this);
        boton35.addActionListener(this);
        boton36.addActionListener(this);
        boton37.addActionListener(this);
        boton38.addActionListener(this);
        boton39.addActionListener(this);
        boton40.addActionListener(this);
        boton41.addActionListener(this);
        boton42.addActionListener(this);
        boton43.addActionListener(this);
        boton44.addActionListener(this);
        boton45.addActionListener(this);
        boton46.addActionListener(this);
        boton47.addActionListener(this);
        boton48.addActionListener(this);
        boton49.addActionListener(this);
        boton50.addActionListener(this);
        boton51.addActionListener(this);
        boton52.addActionListener(this);
        boton53.addActionListener(this);
        boton54.addActionListener(this);
        boton55.addActionListener(this);
        boton56.addActionListener(this);
        boton57.addActionListener(this);
        boton58.addActionListener(this);
        boton59.addActionListener(this);
        boton60.addActionListener(this);
        boton61.addActionListener(this);
        boton62.addActionListener(this);
        boton63.addActionListener(this);
        boton64.addActionListener(this);
        boton65.addActionListener(this);
        boton66.addActionListener(this);
        boton67.addActionListener(this);
        boton68.addActionListener(this);
        boton69.addActionListener(this);
        boton70.addActionListener(this);
        boton71.addActionListener(this);
        boton72.addActionListener(this);
        boton73.addActionListener(this);
        boton74.addActionListener(this);
        boton75.addActionListener(this);
        boton76.addActionListener(this);
        boton77.addActionListener(this);
        boton78.addActionListener(this);
        boton79.addActionListener(this);
        boton80.addActionListener(this);
        boton81.addActionListener(this);
        boton82.addActionListener(this);
        boton83.addActionListener(this);
        boton84.addActionListener(this);
        boton85.addActionListener(this);
        boton86.addActionListener(this);
        boton87.addActionListener(this);
        boton88.addActionListener(this);
        boton89.addActionListener(this);
        boton90.addActionListener(this);
        boton91.addActionListener(this);
        boton92.addActionListener(this);
        boton93.addActionListener(this);
        boton94.addActionListener(this);
        boton95.addActionListener(this);
        boton96.addActionListener(this);
        boton97.addActionListener(this);
        boton98.addActionListener(this);
        boton99.addActionListener(this);

        cuatrocartasboton1.addActionListener(this);
        cuatrocartasboton2.addActionListener(this);
        cuatrocartasboton3.addActionListener(this);
        cuatrocartasboton4.addActionListener(this);

        cincocartasboton1.addActionListener(this);
        cincocartasboton2.addActionListener(this);
        cincocartasboton3.addActionListener(this);
        cincocartasboton4.addActionListener(this);
        cincocartasboton5.addActionListener(this);

        seiscartasboton1.addActionListener(this);
        seiscartasboton2.addActionListener(this);
        seiscartasboton3.addActionListener(this);
        seiscartasboton4.addActionListener(this);
        seiscartasboton5.addActionListener(this);
        seiscartasboton6.addActionListener(this);

        sietecartasboton1.addActionListener(this);
        sietecartasboton2.addActionListener(this);
        sietecartasboton3.addActionListener(this);
        sietecartasboton4.addActionListener(this);
        sietecartasboton5.addActionListener(this);
        sietecartasboton6.addActionListener(this);
        sietecartasboton7.addActionListener(this);

        CAMBIARPOS.addActionListener(this);
        SALIRTABLERO.addActionListener(this);
        DESCARTAR.addActionListener(this);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ATABLEROCOLE.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ATABLEROCOLE.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ATABLEROCOLE.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ATABLEROCOLE.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ATABLEROCOLE(numjugadores).setVisible(true);
            }
        });
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layeredpanecartas = new javax.swing.JLayeredPane();
        cincocartas = new javax.swing.JPanel();
        cuatrocartas = new javax.swing.JPanel();
        cuatrocartasboton1 = new javax.swing.JButton();
        cuatrocartasboton2 = new javax.swing.JButton();
        cuatrocartasboton3 = new javax.swing.JButton();
        cuatrocartasboton4 = new javax.swing.JButton();
        sietecartas = new javax.swing.JPanel();
        sietecartasboton1 = new javax.swing.JButton();
        sietecartasboton2 = new javax.swing.JButton();
        sietecartasboton3 = new javax.swing.JButton();
        sietecartasboton4 = new javax.swing.JButton();
        sietecartasboton5 = new javax.swing.JButton();
        sietecartasboton6 = new javax.swing.JButton();
        sietecartasboton7 = new javax.swing.JButton();
        seiscartas = new javax.swing.JPanel();
        seiscartasboton1 = new javax.swing.JButton();
        seiscartasboton2 = new javax.swing.JButton();
        seiscartasboton3 = new javax.swing.JButton();
        seiscartasboton4 = new javax.swing.JButton();
        seiscartasboton5 = new javax.swing.JButton();
        seiscartasboton6 = new javax.swing.JButton();
        cincocartasboton1 = new javax.swing.JButton();
        cincocartasboton2 = new javax.swing.JButton();
        cincocartasboton3 = new javax.swing.JButton();
        cincocartasboton4 = new javax.swing.JButton();
        cincocartasboton5 = new javax.swing.JButton();
        nombrejugadoractual = new javax.swing.JLabel();
        TABLERO = new javax.swing.JLayeredPane();
        label00 = new javax.swing.JLabel();
        label01 = new javax.swing.JLabel();
        label02 = new javax.swing.JLabel();
        label03 = new javax.swing.JLabel();
        label04 = new javax.swing.JLabel();
        label05 = new javax.swing.JLabel();
        label06 = new javax.swing.JLabel();
        label07 = new javax.swing.JLabel();
        label08 = new javax.swing.JLabel();
        label09 = new javax.swing.JLabel();
        label10 = new javax.swing.JLabel();
        label11 = new javax.swing.JLabel();
        label12 = new javax.swing.JLabel();
        label21 = new javax.swing.JLabel();
        label22 = new javax.swing.JLabel();
        label23 = new javax.swing.JLabel();
        label24 = new javax.swing.JLabel();
        label25 = new javax.swing.JLabel();
        label26 = new javax.swing.JLabel();
        label27 = new javax.swing.JLabel();
        label28 = new javax.swing.JLabel();
        label29 = new javax.swing.JLabel();
        label40 = new javax.swing.JLabel();
        label41 = new javax.swing.JLabel();
        label42 = new javax.swing.JLabel();
        label43 = new javax.swing.JLabel();
        label44 = new javax.swing.JLabel();
        label45 = new javax.swing.JLabel();
        label46 = new javax.swing.JLabel();
        label47 = new javax.swing.JLabel();
        label48 = new javax.swing.JLabel();
        label49 = new javax.swing.JLabel();
        label50 = new javax.swing.JLabel();
        label51 = new javax.swing.JLabel();
        label52 = new javax.swing.JLabel();
        label53 = new javax.swing.JLabel();
        label54 = new javax.swing.JLabel();
        label55 = new javax.swing.JLabel();
        label56 = new javax.swing.JLabel();
        label57 = new javax.swing.JLabel();
        label58 = new javax.swing.JLabel();
        label59 = new javax.swing.JLabel();
        label60 = new javax.swing.JLabel();
        label61 = new javax.swing.JLabel();
        label62 = new javax.swing.JLabel();
        label63 = new javax.swing.JLabel();
        label64 = new javax.swing.JLabel();
        label65 = new javax.swing.JLabel();
        label66 = new javax.swing.JLabel();
        label67 = new javax.swing.JLabel();
        label68 = new javax.swing.JLabel();
        label69 = new javax.swing.JLabel();
        label70 = new javax.swing.JLabel();
        label71 = new javax.swing.JLabel();
        label72 = new javax.swing.JLabel();
        label73 = new javax.swing.JLabel();
        label74 = new javax.swing.JLabel();
        label75 = new javax.swing.JLabel();
        label76 = new javax.swing.JLabel();
        label77 = new javax.swing.JLabel();
        label78 = new javax.swing.JLabel();
        label79 = new javax.swing.JLabel();
        label80 = new javax.swing.JLabel();
        label81 = new javax.swing.JLabel();
        label82 = new javax.swing.JLabel();
        label83 = new javax.swing.JLabel();
        label84 = new javax.swing.JLabel();
        label85 = new javax.swing.JLabel();
        label86 = new javax.swing.JLabel();
        label87 = new javax.swing.JLabel();
        label88 = new javax.swing.JLabel();
        label89 = new javax.swing.JLabel();
        label90 = new javax.swing.JLabel();
        label91 = new javax.swing.JLabel();
        label92 = new javax.swing.JLabel();
        label93 = new javax.swing.JLabel();
        label94 = new javax.swing.JLabel();
        label95 = new javax.swing.JLabel();
        label96 = new javax.swing.JLabel();
        label97 = new javax.swing.JLabel();
        label98 = new javax.swing.JLabel();
        label99 = new javax.swing.JLabel();
        label13 = new javax.swing.JLabel();
        label14 = new javax.swing.JLabel();
        label15 = new javax.swing.JLabel();
        label16 = new javax.swing.JLabel();
        label17 = new javax.swing.JLabel();
        label18 = new javax.swing.JLabel();
        label19 = new javax.swing.JLabel();
        label20 = new javax.swing.JLabel();
        label30 = new javax.swing.JLabel();
        label31 = new javax.swing.JLabel();
        label32 = new javax.swing.JLabel();
        label33 = new javax.swing.JLabel();
        label34 = new javax.swing.JLabel();
        label35 = new javax.swing.JLabel();
        label36 = new javax.swing.JLabel();
        label37 = new javax.swing.JLabel();
        label38 = new javax.swing.JLabel();
        label39 = new javax.swing.JLabel();
        boton86 = new javax.swing.JButton();
        boton76 = new javax.swing.JButton();
        boton69 = new javax.swing.JButton();
        boton99 = new javax.swing.JButton();
        boton77 = new javax.swing.JButton();
        boton21 = new javax.swing.JButton();
        boton74 = new javax.swing.JButton();
        boton18 = new javax.swing.JButton();
        boton27 = new javax.swing.JButton();
        boton43 = new javax.swing.JButton();
        boton19 = new javax.swing.JButton();
        boton95 = new javax.swing.JButton();
        boton66 = new javax.swing.JButton();
        boton39 = new javax.swing.JButton();
        boton65 = new javax.swing.JButton();
        boton00 = new javax.swing.JButton();
        boton57 = new javax.swing.JButton();
        boton83 = new javax.swing.JButton();
        boton35 = new javax.swing.JButton();
        boton41 = new javax.swing.JButton();
        boton22 = new javax.swing.JButton();
        boton84 = new javax.swing.JButton();
        boton05 = new javax.swing.JButton();
        boton25 = new javax.swing.JButton();
        boton98 = new javax.swing.JButton();
        boton32 = new javax.swing.JButton();
        boton34 = new javax.swing.JButton();
        boton20 = new javax.swing.JButton();
        boton80 = new javax.swing.JButton();
        boton53 = new javax.swing.JButton();
        boton58 = new javax.swing.JButton();
        boton52 = new javax.swing.JButton();
        boton64 = new javax.swing.JButton();
        boton07 = new javax.swing.JButton();
        boton28 = new javax.swing.JButton();
        boton08 = new javax.swing.JButton();
        boton26 = new javax.swing.JButton();
        boton50 = new javax.swing.JButton();
        boton87 = new javax.swing.JButton();
        boton29 = new javax.swing.JButton();
        boton89 = new javax.swing.JButton();
        boton49 = new javax.swing.JButton();
        boton55 = new javax.swing.JButton();
        boton62 = new javax.swing.JButton();
        boton04 = new javax.swing.JButton();
        boton37 = new javax.swing.JButton();
        boton13 = new javax.swing.JButton();
        boton75 = new javax.swing.JButton();
        boton71 = new javax.swing.JButton();
        boton81 = new javax.swing.JButton();
        boton40 = new javax.swing.JButton();
        boton44 = new javax.swing.JButton();
        boton23 = new javax.swing.JButton();
        boton61 = new javax.swing.JButton();
        boton90 = new javax.swing.JButton();
        boton72 = new javax.swing.JButton();
        boton73 = new javax.swing.JButton();
        boton85 = new javax.swing.JButton();
        boton31 = new javax.swing.JButton();
        boton78 = new javax.swing.JButton();
        boton45 = new javax.swing.JButton();
        boton15 = new javax.swing.JButton();
        boton59 = new javax.swing.JButton();
        boton91 = new javax.swing.JButton();
        boton60 = new javax.swing.JButton();
        boton94 = new javax.swing.JButton();
        boton10 = new javax.swing.JButton();
        boton97 = new javax.swing.JButton();
        boton47 = new javax.swing.JButton();
        boton48 = new javax.swing.JButton();
        boton24 = new javax.swing.JButton();
        boton06 = new javax.swing.JButton();
        boton38 = new javax.swing.JButton();
        boton70 = new javax.swing.JButton();
        boton96 = new javax.swing.JButton();
        boton03 = new javax.swing.JButton();
        boton33 = new javax.swing.JButton();
        boton46 = new javax.swing.JButton();
        boton12 = new javax.swing.JButton();
        boton68 = new javax.swing.JButton();
        boton09 = new javax.swing.JButton();
        boton79 = new javax.swing.JButton();
        boton36 = new javax.swing.JButton();
        boton01 = new javax.swing.JButton();
        boton16 = new javax.swing.JButton();
        boton67 = new javax.swing.JButton();
        boton14 = new javax.swing.JButton();
        boton82 = new javax.swing.JButton();
        boton93 = new javax.swing.JButton();
        boton17 = new javax.swing.JButton();
        boton54 = new javax.swing.JButton();
        boton51 = new javax.swing.JButton();
        boton63 = new javax.swing.JButton();
        boton56 = new javax.swing.JButton();
        boton88 = new javax.swing.JButton();
        boton30 = new javax.swing.JButton();
        boton11 = new javax.swing.JButton();
        boton42 = new javax.swing.JButton();
        boton02 = new javax.swing.JButton();
        boton92 = new javax.swing.JButton();
        TABLEROLABEL = new javax.swing.JLabel();
        layeredpaneizq = new javax.swing.JLayeredPane();
        tresjugadoresizq = new javax.swing.JPanel();
        tresnombrejugador3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dosjugadoresizq = new javax.swing.JPanel();
        dosnombrejugador2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cuatrojugadoresizq = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        cuatronombrejugador3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cuatronombrejugador4 = new javax.swing.JLabel();
        seisjugadoresizq = new javax.swing.JPanel();
        seisnombrejugador4 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        seisnombrejugador5 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        seisnombrejugador6 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        ochojugadoresizq = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        ochonombrejugador6 = new javax.swing.JLabel();
        ochonombrejugador8 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        ochonombrejugador5 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        ochonombrejugador7 = new javax.swing.JLabel();
        layeredpaneder = new javax.swing.JLayeredPane();
        dosjugadoresder = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cuatrojugadoresder = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cuatronombrejugador2 = new javax.swing.JLabel();
        ochojugadoresder = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        ochonombrejugador2 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        ochonombrejugador3 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        ochonombrejugador4 = new javax.swing.JLabel();
        tresjugadoresder = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tresnombrejugador2 = new javax.swing.JLabel();
        seisjugadoresder = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        seisnombrejugador2 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        seisnombrejugador3 = new javax.swing.JLabel();
        SALIRTABLERO = new javax.swing.JButton();
        CAMBIARPOS = new javax.swing.JButton();
        ultimacarta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        DESCARTAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1920, 1920));

        layeredpanecartas.setPreferredSize(new java.awt.Dimension(700, 202));

        cincocartas.setBackground(new java.awt.Color(255, 255, 255));
        cincocartas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout cincocartasLayout = new javax.swing.GroupLayout(cincocartas);
        cincocartas.setLayout(cincocartasLayout);
        cincocartasLayout.setHorizontalGroup(
            cincocartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 992, Short.MAX_VALUE)
        );
        cincocartasLayout.setVerticalGroup(
            cincocartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        cuatrocartas.setBackground(new java.awt.Color(255, 255, 255));
        cuatrocartas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        cuatrocartasboton1.setContentAreaFilled(false);

        cuatrocartasboton2.setContentAreaFilled(false);

        cuatrocartasboton3.setContentAreaFilled(false);

        cuatrocartasboton4.setContentAreaFilled(false);
        cuatrocartasboton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuatrocartasboton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cuatrocartasLayout = new javax.swing.GroupLayout(cuatrocartas);
        cuatrocartas.setLayout(cuatrocartasLayout);
        cuatrocartasLayout.setHorizontalGroup(
            cuatrocartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cuatrocartasLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(cuatrocartasboton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cuatrocartasboton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cuatrocartasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cuatrocartasboton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cuatrocartasLayout.setVerticalGroup(
            cuatrocartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cuatrocartasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cuatrocartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cuatrocartasboton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuatrocartasboton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuatrocartasboton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuatrocartasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        sietecartas.setBackground(new java.awt.Color(255, 255, 255));
        sietecartas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        sietecartasboton1.setContentAreaFilled(false);
        sietecartasboton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sietecartasboton1ActionPerformed(evt);
            }
        });

        sietecartasboton2.setContentAreaFilled(false);
        sietecartasboton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sietecartasboton2ActionPerformed(evt);
            }
        });

        sietecartasboton3.setContentAreaFilled(false);
        sietecartasboton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sietecartasboton3ActionPerformed(evt);
            }
        });

        sietecartasboton4.setContentAreaFilled(false);
        sietecartasboton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sietecartasboton4ActionPerformed(evt);
            }
        });

        sietecartasboton5.setContentAreaFilled(false);
        sietecartasboton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sietecartasboton5ActionPerformed(evt);
            }
        });

        sietecartasboton6.setContentAreaFilled(false);
        sietecartasboton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sietecartasboton6ActionPerformed(evt);
            }
        });

        sietecartasboton7.setContentAreaFilled(false);
        sietecartasboton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sietecartasboton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sietecartasLayout = new javax.swing.GroupLayout(sietecartas);
        sietecartas.setLayout(sietecartasLayout);
        sietecartasLayout.setHorizontalGroup(
            sietecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sietecartasLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(sietecartasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sietecartasboton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sietecartasboton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sietecartasboton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sietecartasboton5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sietecartasboton6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sietecartasboton7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );
        sietecartasLayout.setVerticalGroup(
            sietecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sietecartasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sietecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sietecartasboton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sietecartasboton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sietecartasboton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sietecartasboton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sietecartasboton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sietecartasboton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sietecartasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        seiscartas.setBackground(new java.awt.Color(255, 255, 255));
        seiscartas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        seiscartasboton1.setBorderPainted(false);
        seiscartasboton1.setContentAreaFilled(false);

        seiscartasboton2.setContentAreaFilled(false);
        seiscartasboton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seiscartasboton2ActionPerformed(evt);
            }
        });

        seiscartasboton3.setContentAreaFilled(false);

        seiscartasboton4.setContentAreaFilled(false);

        seiscartasboton5.setContentAreaFilled(false);

        seiscartasboton6.setContentAreaFilled(false);

        cincocartasboton1.setContentAreaFilled(false);

        cincocartasboton2.setContentAreaFilled(false);

        cincocartasboton3.setContentAreaFilled(false);

        cincocartasboton4.setContentAreaFilled(false);

        cincocartasboton5.setContentAreaFilled(false);

        javax.swing.GroupLayout seiscartasLayout = new javax.swing.GroupLayout(seiscartas);
        seiscartas.setLayout(seiscartasLayout);
        seiscartasLayout.setHorizontalGroup(
            seiscartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seiscartasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seiscartasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cincocartasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cincocartasboton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cincocartasboton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cincocartasboton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cincocartasboton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seiscartasboton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seiscartasboton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seiscartasboton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seiscartasboton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seiscartasboton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        seiscartasLayout.setVerticalGroup(
            seiscartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seiscartasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(seiscartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(seiscartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cincocartasboton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cincocartasboton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cincocartasboton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cincocartasboton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cincocartasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(seiscartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(seiscartasboton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seiscartasboton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seiscartasboton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seiscartasboton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seiscartasboton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seiscartasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        nombrejugadoractual.setText("jLabel15");

        layeredpanecartas.setLayer(cincocartas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredpanecartas.setLayer(cuatrocartas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredpanecartas.setLayer(sietecartas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredpanecartas.setLayer(seiscartas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredpanecartas.setLayer(nombrejugadoractual, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layeredpanecartasLayout = new javax.swing.GroupLayout(layeredpanecartas);
        layeredpanecartas.setLayout(layeredpanecartasLayout);
        layeredpanecartasLayout.setHorizontalGroup(
            layeredpanecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layeredpanecartasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cuatrocartas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layeredpanecartasLayout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(nombrejugadoractual, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layeredpanecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredpanecartasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cincocartas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layeredpanecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredpanecartasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(seiscartas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layeredpanecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layeredpanecartasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(sietecartas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layeredpanecartasLayout.setVerticalGroup(
            layeredpanecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layeredpanecartasLayout.createSequentialGroup()
                .addComponent(cuatrocartas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombrejugadoractual)
                .addContainerGap())
            .addGroup(layeredpanecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredpanecartasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cincocartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(82, Short.MAX_VALUE)))
            .addGroup(layeredpanecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredpanecartasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(seiscartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(74, Short.MAX_VALUE)))
            .addGroup(layeredpanecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredpanecartasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(sietecartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(82, Short.MAX_VALUE)))
        );

        TABLERO.setMinimumSize(new java.awt.Dimension(700, 600));
        TABLERO.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        TABLERO.add(label00, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 540, 50, 60));
        TABLERO.add(label01, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 540, 50, 60));
        TABLERO.add(label02, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 540, 50, 60));
        TABLERO.add(label03, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 50, 50));
        TABLERO.add(label04, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, 50, 50));
        TABLERO.add(label05, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, 50, 50));
        TABLERO.add(label06, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 50, 50));
        TABLERO.add(label07, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 540, 40, 60));
        TABLERO.add(label08, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 540, 40, 60));
        TABLERO.add(label09, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 540, 50, 50));
        TABLERO.add(label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 60, 60));
        TABLERO.add(label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 50, 60));
        TABLERO.add(label12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 50, 60));
        TABLERO.add(label21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 50, 50));
        TABLERO.add(label22, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 50, 60));
        TABLERO.add(label23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 50, 60));
        TABLERO.add(label24, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 50, 50));
        TABLERO.add(label25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 50, 50));
        TABLERO.add(label26, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 50, 60));
        TABLERO.add(label27, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, 50, 60));
        TABLERO.add(label28, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, 50, 60));
        TABLERO.add(label29, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, 40, 60));
        TABLERO.add(label40, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 50, 50));
        TABLERO.add(label41, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 50, 50));
        TABLERO.add(label42, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 50, 50));
        TABLERO.add(label43, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 50, 50));
        TABLERO.add(label44, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 50, 50));
        TABLERO.add(label45, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 50, 50));
        TABLERO.add(label46, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 50, 50));
        TABLERO.add(label47, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 50, 50));
        TABLERO.add(label48, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 50, 50));
        TABLERO.add(label49, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, 50, 50));
        TABLERO.add(label50, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 50, 60));
        TABLERO.add(label51, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 50, 60));
        TABLERO.add(label52, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 50, 60));
        TABLERO.add(label53, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 50, 60));
        TABLERO.add(label54, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 50, 60));
        TABLERO.add(label55, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 50, 60));
        TABLERO.add(label56, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 50, 60));
        TABLERO.add(label57, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 50, 60));
        TABLERO.add(label58, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 50, 60));
        TABLERO.add(label59, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 50, 60));
        TABLERO.add(label60, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 180, 50, 60));
        TABLERO.add(label61, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 180, 50, 60));
        TABLERO.add(label62, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 50, 60));
        TABLERO.add(label63, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 50, 50));
        TABLERO.add(label64, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 186, 50, 50));
        TABLERO.add(label65, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 50, 60));
        TABLERO.add(label66, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 50, 60));
        TABLERO.add(label67, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 50, 60));
        TABLERO.add(label68, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 50, 60));
        TABLERO.add(label69, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 50, 60));
        TABLERO.add(label70, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 126, 50, 50));
        TABLERO.add(label71, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 50, 50));
        TABLERO.add(label72, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 50, 50));
        TABLERO.add(label73, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 50, 50));
        TABLERO.add(label74, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 50, 50));
        TABLERO.add(label75, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 50, 50));
        TABLERO.add(label76, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 50, 50));
        TABLERO.add(label77, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 50, 60));
        TABLERO.add(label78, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 50, 50));
        TABLERO.add(label79, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 50, 50));
        TABLERO.add(label80, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 70, 50, 50));
        TABLERO.add(label81, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 50, 50));
        TABLERO.add(label82, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 50, 50));
        TABLERO.add(label83, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 50, 50));
        TABLERO.add(label84, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 50, 50));
        TABLERO.add(label85, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 50, 50));
        TABLERO.add(label86, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 50, 50));
        TABLERO.add(label87, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 50, 50));
        TABLERO.add(label88, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 50, 50));
        TABLERO.add(label89, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 50, 50));
        TABLERO.add(label90, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 50, 50));
        TABLERO.add(label91, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 50, 50));
        TABLERO.add(label92, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 50, 50));
        TABLERO.add(label93, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 50, 50));
        TABLERO.add(label94, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 50, 50));
        TABLERO.add(label95, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 50, 60));
        TABLERO.add(label96, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 50, 60));
        TABLERO.add(label97, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 50, 50));
        TABLERO.add(label98, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 50, 50));
        TABLERO.add(label99, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 50, 50));
        TABLERO.add(label13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, 50, 60));
        TABLERO.add(label14, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, -1, 60));
        TABLERO.add(label15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, -1, 60));
        TABLERO.add(label16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, -1, 60));
        TABLERO.add(label17, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 480, -1, 60));
        TABLERO.add(label18, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 480, -1, 60));
        TABLERO.add(label19, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, -1, 60));
        TABLERO.add(label20, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 430, 50, 50));
        TABLERO.add(label30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 50, 50));
        TABLERO.add(label31, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 50, 50));
        TABLERO.add(label32, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 366, -1, 50));
        TABLERO.add(label33, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 50, 50));
        TABLERO.add(label34, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, -1, 60));
        TABLERO.add(label35, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, -1, 50));
        TABLERO.add(label36, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, -1, 50));
        TABLERO.add(label37, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, 50));
        TABLERO.add(label38, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, -1, 50));
        TABLERO.add(label39, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, -1, 50));

        boton86.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton86.setForeground(new java.awt.Color(255, 255, 255));
        boton86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/KH.jpg"))); // NOI18N
        boton86.setBorder(null);
        boton86.setBorderPainted(false);
        boton86.setContentAreaFilled(false);
        TABLERO.add(boton86, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 65, 51, 53));

        boton76.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton76.setForeground(new java.awt.Color(255, 255, 255));
        boton76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/6D.jpg"))); // NOI18N
        boton76.setBorder(null);
        boton76.setBorderPainted(false);
        boton76.setContentAreaFilled(false);
        TABLERO.add(boton76, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 125, 51, 53));

        boton69.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton69.setForeground(new java.awt.Color(255, 255, 255));
        boton69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/KS.jpg"))); // NOI18N
        boton69.setBorder(null);
        boton69.setBorderPainted(false);
        boton69.setContentAreaFilled(false);
        TABLERO.add(boton69, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 185, 51, 53));

        boton99.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton99.setForeground(new java.awt.Color(255, 255, 255));
        boton99.setBorder(null);
        boton99.setBorderPainted(false);
        boton99.setContentAreaFilled(false);
        boton99.setEnabled(false);
        TABLERO.add(boton99, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 7, 51, 53));

        boton77.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton77.setForeground(new java.awt.Color(255, 255, 255));
        boton77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/7D.jpg"))); // NOI18N
        boton77.setBorder(null);
        boton77.setBorderPainted(false);
        boton77.setContentAreaFilled(false);
        TABLERO.add(boton77, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 125, 51, 53));

        boton21.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton21.setForeground(new java.awt.Color(255, 255, 255));
        boton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/8S.jpg"))); // NOI18N
        boton21.setBorder(null);
        boton21.setBorderPainted(false);
        boton21.setContentAreaFilled(false);
        TABLERO.add(boton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 423, 51, 53));

        boton74.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton74.setForeground(new java.awt.Color(255, 255, 255));
        boton74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/4D.jpg"))); // NOI18N
        boton74.setBorder(null);
        boton74.setBorderPainted(false);
        boton74.setContentAreaFilled(false);
        TABLERO.add(boton74, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 125, 51, 53));

        boton18.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton18.setForeground(new java.awt.Color(255, 255, 255));
        boton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/3H.jpg"))); // NOI18N
        boton18.setBorder(null);
        boton18.setBorderPainted(false);
        boton18.setContentAreaFilled(false);
        TABLERO.add(boton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 483, 51, 53));

        boton27.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton27.setForeground(new java.awt.Color(255, 255, 255));
        boton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/KD.jpg"))); // NOI18N
        boton27.setBorder(null);
        boton27.setBorderPainted(false);
        boton27.setContentAreaFilled(false);
        TABLERO.add(boton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 423, 51, 53));

        boton43.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton43.setForeground(new java.awt.Color(255, 255, 255));
        boton43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/7H.jpg"))); // NOI18N
        boton43.setBorder(null);
        boton43.setBorderPainted(false);
        boton43.setContentAreaFilled(false);
        TABLERO.add(boton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 305, 51, 53));

        boton19.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton19.setForeground(new java.awt.Color(255, 255, 255));
        boton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/5D.jpg"))); // NOI18N
        boton19.setBorder(null);
        boton19.setBorderPainted(false);
        boton19.setContentAreaFilled(false);
        TABLERO.add(boton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 483, 51, 53));

        boton95.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton95.setForeground(new java.awt.Color(255, 255, 255));
        boton95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/6S.jpg"))); // NOI18N
        boton95.setBorder(null);
        boton95.setBorderPainted(false);
        boton95.setContentAreaFilled(false);
        TABLERO.add(boton95, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 7, 51, 53));

        boton66.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton66.setForeground(new java.awt.Color(255, 255, 255));
        boton66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/2C.jpg"))); // NOI18N
        boton66.setBorder(null);
        boton66.setBorderPainted(false);
        boton66.setContentAreaFilled(false);
        TABLERO.add(boton66, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 185, 51, 53));

        boton39.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton39.setForeground(new java.awt.Color(255, 255, 255));
        boton39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/3D.jpg"))); // NOI18N
        boton39.setBorder(null);
        boton39.setBorderPainted(false);
        boton39.setContentAreaFilled(false);
        TABLERO.add(boton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 364, 51, 53));

        boton65.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton65.setForeground(new java.awt.Color(255, 255, 255));
        boton65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/3C.jpg"))); // NOI18N
        boton65.setBorder(null);
        boton65.setBorderPainted(false);
        boton65.setContentAreaFilled(false);
        TABLERO.add(boton65, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 185, 51, 53));

        boton00.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton00.setForeground(new java.awt.Color(255, 255, 255));
        boton00.setBorder(null);
        boton00.setBorderPainted(false);
        boton00.setContentAreaFilled(false);
        boton00.setEnabled(false);
        boton00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton00ActionPerformed(evt);
            }
        });
        TABLERO.add(boton00, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 51, 53));

        boton57.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton57.setForeground(new java.awt.Color(255, 255, 255));
        boton57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/9D.jpg"))); // NOI18N
        boton57.setBorder(null);
        boton57.setBorderPainted(false);
        boton57.setContentAreaFilled(false);
        TABLERO.add(boton57, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 245, 51, 53));

        boton83.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton83.setForeground(new java.awt.Color(255, 255, 255));
        boton83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/3C.jpg"))); // NOI18N
        boton83.setBorder(null);
        boton83.setBorderPainted(false);
        boton83.setContentAreaFilled(false);
        TABLERO.add(boton83, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 65, 51, 53));

        boton35.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton35.setForeground(new java.awt.Color(255, 255, 255));
        boton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/10H.jpg"))); // NOI18N
        boton35.setBorder(null);
        boton35.setBorderPainted(false);
        boton35.setContentAreaFilled(false);
        TABLERO.add(boton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 364, 51, 53));

        boton41.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton41.setForeground(new java.awt.Color(255, 255, 255));
        boton41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/10S.jpg"))); // NOI18N
        boton41.setBorder(null);
        boton41.setBorderPainted(false);
        boton41.setContentAreaFilled(false);
        TABLERO.add(boton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 305, 51, 53));

        boton22.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton22.setForeground(new java.awt.Color(255, 255, 255));
        boton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/10C.jpg"))); // NOI18N
        boton22.setBorder(null);
        boton22.setBorderPainted(false);
        boton22.setContentAreaFilled(false);
        TABLERO.add(boton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 423, 51, 53));

        boton84.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton84.setForeground(new java.awt.Color(255, 255, 255));
        boton84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/2C.jpg"))); // NOI18N
        boton84.setBorder(null);
        boton84.setBorderPainted(false);
        boton84.setContentAreaFilled(false);
        TABLERO.add(boton84, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 65, 51, 53));

        boton05.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton05.setForeground(new java.awt.Color(255, 255, 255));
        boton05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/9D.jpg"))); // NOI18N
        boton05.setBorder(null);
        boton05.setBorderPainted(false);
        boton05.setContentAreaFilled(false);
        TABLERO.add(boton05, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 542, 51, 53));

        boton25.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton25.setForeground(new java.awt.Color(255, 255, 255));
        boton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/AC.jpg"))); // NOI18N
        boton25.setBorder(null);
        boton25.setBorderPainted(false);
        boton25.setContentAreaFilled(false);
        TABLERO.add(boton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 423, 51, 53));

        boton98.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton98.setForeground(new java.awt.Color(255, 255, 255));
        boton98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/9S.jpg"))); // NOI18N
        boton98.setBorder(null);
        boton98.setBorderPainted(false);
        boton98.setContentAreaFilled(false);
        TABLERO.add(boton98, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 7, 51, 53));

        boton32.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton32.setForeground(new java.awt.Color(255, 255, 255));
        boton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/9C.jpg"))); // NOI18N
        boton32.setBorder(null);
        boton32.setBorderPainted(false);
        boton32.setContentAreaFilled(false);
        TABLERO.add(boton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 364, 51, 53));

        boton34.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton34.setForeground(new java.awt.Color(255, 255, 255));
        boton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/9H.jpg"))); // NOI18N
        boton34.setBorder(null);
        boton34.setBorderPainted(false);
        boton34.setContentAreaFilled(false);
        TABLERO.add(boton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 364, 51, 53));

        boton20.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton20.setForeground(new java.awt.Color(255, 255, 255));
        boton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/KC.jpg"))); // NOI18N
        boton20.setBorder(null);
        boton20.setBorderPainted(false);
        boton20.setContentAreaFilled(false);
        TABLERO.add(boton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 423, 51, 53));

        boton80.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton80.setForeground(new java.awt.Color(255, 255, 255));
        boton80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/6C.jpg"))); // NOI18N
        boton80.setBorder(null);
        boton80.setBorderPainted(false);
        boton80.setContentAreaFilled(false);
        TABLERO.add(boton80, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 65, 51, 53));

        boton53.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton53.setForeground(new java.awt.Color(255, 255, 255));
        boton53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/6H.jpg"))); // NOI18N
        boton53.setBorder(null);
        boton53.setBorderPainted(false);
        boton53.setContentAreaFilled(false);
        TABLERO.add(boton53, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 245, 51, 53));

        boton58.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton58.setForeground(new java.awt.Color(255, 255, 255));
        boton58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/7H.jpg"))); // NOI18N
        boton58.setToolTipText("");
        boton58.setBorder(null);
        boton58.setBorderPainted(false);
        boton58.setContentAreaFilled(false);
        TABLERO.add(boton58, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 245, 51, 53));

        boton52.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton52.setForeground(new java.awt.Color(255, 255, 255));
        boton52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/7C.jpg"))); // NOI18N
        boton52.setBorder(null);
        boton52.setBorderPainted(false);
        boton52.setContentAreaFilled(false);
        TABLERO.add(boton52, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 245, 51, 53));

        boton64.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton64.setForeground(new java.awt.Color(255, 255, 255));
        boton64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/4C.jpg"))); // NOI18N
        boton64.setBorder(null);
        boton64.setBorderPainted(false);
        boton64.setContentAreaFilled(false);
        TABLERO.add(boton64, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 185, 51, 53));

        boton07.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton07.setForeground(new java.awt.Color(255, 255, 255));
        boton07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/7D.jpg"))); // NOI18N
        boton07.setBorder(null);
        boton07.setBorderPainted(false);
        boton07.setContentAreaFilled(false);
        TABLERO.add(boton07, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 542, 51, 53));

        boton28.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton28.setForeground(new java.awt.Color(255, 255, 255));
        boton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/4H.jpg"))); // NOI18N
        boton28.setBorder(null);
        boton28.setBorderPainted(false);
        boton28.setContentAreaFilled(false);
        TABLERO.add(boton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 423, 51, 53));

        boton08.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton08.setForeground(new java.awt.Color(255, 255, 255));
        boton08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/6D.jpg"))); // NOI18N
        boton08.setBorder(null);
        boton08.setBorderPainted(false);
        boton08.setContentAreaFilled(false);
        TABLERO.add(boton08, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 542, 51, 53));

        boton26.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton26.setForeground(new java.awt.Color(255, 255, 255));
        boton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/AD.jpg"))); // NOI18N
        boton26.setBorder(null);
        boton26.setBorderPainted(false);
        TABLERO.add(boton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 423, 51, 53));

        boton50.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton50.setForeground(new java.awt.Color(255, 255, 255));
        boton50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/9C.jpg"))); // NOI18N
        boton50.setBorder(null);
        boton50.setBorderPainted(false);
        boton50.setContentAreaFilled(false);
        TABLERO.add(boton50, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 245, 51, 53));

        boton87.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton87.setForeground(new java.awt.Color(255, 255, 255));
        boton87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/QH.jpg"))); // NOI18N
        boton87.setBorder(null);
        boton87.setBorderPainted(false);
        boton87.setContentAreaFilled(false);
        TABLERO.add(boton87, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 65, 51, 53));

        boton29.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton29.setForeground(new java.awt.Color(255, 255, 255));
        boton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/4D.jpg"))); // NOI18N
        boton29.setBorder(null);
        boton29.setBorderPainted(false);
        boton29.setContentAreaFilled(false);
        TABLERO.add(boton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 423, 51, 53));

        boton89.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton89.setForeground(new java.awt.Color(255, 255, 255));
        boton89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/10S.jpg"))); // NOI18N
        boton89.setBorder(null);
        boton89.setBorderPainted(false);
        boton89.setContentAreaFilled(false);
        TABLERO.add(boton89, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 65, 51, 53));

        boton49.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton49.setForeground(new java.awt.Color(255, 255, 255));
        boton49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/2D.jpg"))); // NOI18N
        boton49.setBorder(null);
        boton49.setBorderPainted(false);
        boton49.setContentAreaFilled(false);
        TABLERO.add(boton49, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 305, 51, 53));

        boton55.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton55.setForeground(new java.awt.Color(255, 255, 255));
        boton55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/4H.jpg"))); // NOI18N
        boton55.setBorder(null);
        boton55.setBorderPainted(false);
        boton55.setContentAreaFilled(false);
        TABLERO.add(boton55, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 245, 51, 53));

        boton62.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton62.setForeground(new java.awt.Color(255, 255, 255));
        boton62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/6C.jpg"))); // NOI18N
        boton62.setBorder(null);
        boton62.setBorderPainted(false);
        boton62.setContentAreaFilled(false);
        boton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton62ActionPerformed(evt);
            }
        });
        TABLERO.add(boton62, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 185, 51, 53));

        boton04.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton04.setForeground(new java.awt.Color(255, 255, 255));
        boton04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/10D.jpg"))); // NOI18N
        boton04.setBorder(null);
        boton04.setBorderPainted(false);
        boton04.setContentAreaFilled(false);
        TABLERO.add(boton04, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, 51, 53));

        boton37.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton37.setForeground(new java.awt.Color(255, 255, 255));
        boton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/QD.jpg"))); // NOI18N
        boton37.setBorder(null);
        boton37.setBorderPainted(false);
        boton37.setContentAreaFilled(false);
        TABLERO.add(boton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 364, 51, 53));

        boton13.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton13.setForeground(new java.awt.Color(255, 255, 255));
        boton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/5S.jpg"))); // NOI18N
        boton13.setBorder(null);
        boton13.setBorderPainted(false);
        boton13.setContentAreaFilled(false);
        TABLERO.add(boton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 483, 51, 53));

        boton75.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton75.setForeground(new java.awt.Color(255, 255, 255));
        boton75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/5D.jpg"))); // NOI18N
        boton75.setBorder(null);
        boton75.setBorderPainted(false);
        boton75.setContentAreaFilled(false);
        TABLERO.add(boton75, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 125, 51, 53));

        boton71.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton71.setForeground(new java.awt.Color(255, 255, 255));
        boton71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/AS.jpg"))); // NOI18N
        boton71.setBorder(null);
        boton71.setBorderPainted(false);
        boton71.setContentAreaFilled(false);
        TABLERO.add(boton71, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 125, 51, 53));

        boton81.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton81.setForeground(new java.awt.Color(255, 255, 255));
        boton81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/5C.jpg"))); // NOI18N
        boton81.setBorder(null);
        boton81.setBorderPainted(false);
        boton81.setContentAreaFilled(false);
        TABLERO.add(boton81, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 65, 51, 53));

        boton40.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton40.setForeground(new java.awt.Color(255, 255, 255));
        boton40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/10C.jpg"))); // NOI18N
        boton40.setBorder(null);
        boton40.setBorderPainted(false);
        boton40.setContentAreaFilled(false);
        TABLERO.add(boton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 305, 51, 53));

        boton44.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton44.setForeground(new java.awt.Color(255, 255, 255));
        boton44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/2H.jpg"))); // NOI18N
        boton44.setBorder(null);
        boton44.setBorderPainted(false);
        boton44.setContentAreaFilled(false);
        TABLERO.add(boton44, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 305, 51, 53));

        boton23.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton23.setForeground(new java.awt.Color(255, 255, 255));
        boton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/QC.jpg"))); // NOI18N
        boton23.setBorder(null);
        boton23.setBorderPainted(false);
        boton23.setContentAreaFilled(false);
        TABLERO.add(boton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 423, 51, 53));

        boton61.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton61.setForeground(new java.awt.Color(255, 255, 255));
        boton61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/KS.jpg"))); // NOI18N
        boton61.setBorder(null);
        boton61.setBorderPainted(false);
        boton61.setContentAreaFilled(false);
        TABLERO.add(boton61, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 185, 51, 53));

        boton90.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton90.setForeground(new java.awt.Color(255, 255, 255));
        boton90.setBorder(null);
        boton90.setBorderPainted(false);
        boton90.setContentAreaFilled(false);
        boton90.setEnabled(false);
        TABLERO.add(boton90, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 7, 51, 53));

        boton72.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton72.setForeground(new java.awt.Color(255, 255, 255));
        boton72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/2D.jpg"))); // NOI18N
        boton72.setBorder(null);
        boton72.setBorderPainted(false);
        boton72.setContentAreaFilled(false);
        TABLERO.add(boton72, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 125, 51, 53));

        boton73.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton73.setForeground(new java.awt.Color(255, 255, 255));
        boton73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/3D.jpg"))); // NOI18N
        boton73.setBorder(null);
        boton73.setBorderPainted(false);
        boton73.setContentAreaFilled(false);
        TABLERO.add(boton73, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 125, 51, 53));

        boton85.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton85.setForeground(new java.awt.Color(255, 255, 255));
        boton85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/AH.jpg"))); // NOI18N
        boton85.setBorder(null);
        boton85.setBorderPainted(false);
        boton85.setContentAreaFilled(false);
        TABLERO.add(boton85, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 65, 51, 53));

        boton31.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton31.setForeground(new java.awt.Color(255, 255, 255));
        boton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/9S.jpg"))); // NOI18N
        boton31.setBorder(null);
        boton31.setBorderPainted(false);
        boton31.setContentAreaFilled(false);
        TABLERO.add(boton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 364, 51, 53));

        boton78.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton78.setForeground(new java.awt.Color(255, 255, 255));
        boton78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/9H.jpg"))); // NOI18N
        boton78.setBorder(null);
        boton78.setBorderPainted(false);
        boton78.setContentAreaFilled(false);
        TABLERO.add(boton78, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 125, 51, 53));

        boton45.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton45.setForeground(new java.awt.Color(255, 255, 255));
        boton45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/3H.jpg"))); // NOI18N
        boton45.setBorder(null);
        boton45.setBorderPainted(false);
        boton45.setContentAreaFilled(false);
        TABLERO.add(boton45, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 305, 51, 53));

        boton15.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton15.setForeground(new java.awt.Color(255, 255, 255));
        boton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/3S.jpg"))); // NOI18N
        boton15.setBorder(null);
        boton15.setBorderPainted(false);
        boton15.setContentAreaFilled(false);
        TABLERO.add(boton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 483, 51, 53));

        boton59.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton59.setForeground(new java.awt.Color(255, 255, 255));
        boton59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/AS.jpg"))); // NOI18N
        boton59.setBorder(null);
        boton59.setBorderPainted(false);
        boton59.setContentAreaFilled(false);
        TABLERO.add(boton59, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 245, 51, 53));

        boton91.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton91.setForeground(new java.awt.Color(255, 255, 255));
        boton91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/2S.jpg"))); // NOI18N
        boton91.setBorder(null);
        boton91.setBorderPainted(false);
        boton91.setContentAreaFilled(false);
        TABLERO.add(boton91, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 7, 51, 53));

        boton60.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton60.setForeground(new java.awt.Color(255, 255, 255));
        boton60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/8C.jpg"))); // NOI18N
        boton60.setBorder(null);
        boton60.setBorderPainted(false);
        boton60.setContentAreaFilled(false);
        TABLERO.add(boton60, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 185, 51, 53));

        boton94.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton94.setForeground(new java.awt.Color(255, 255, 255));
        boton94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/5S.jpg"))); // NOI18N
        boton94.setBorder(null);
        boton94.setBorderPainted(false);
        boton94.setContentAreaFilled(false);
        TABLERO.add(boton94, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 7, 51, 53));

        boton10.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton10.setForeground(new java.awt.Color(255, 255, 255));
        boton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/AC.jpg"))); // NOI18N
        boton10.setBorder(null);
        boton10.setBorderPainted(false);
        boton10.setContentAreaFilled(false);
        TABLERO.add(boton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 51, 60));

        boton97.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton97.setForeground(new java.awt.Color(255, 255, 255));
        boton97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/8S.jpg"))); // NOI18N
        boton97.setToolTipText("");
        boton97.setBorder(null);
        boton97.setBorderPainted(false);
        boton97.setContentAreaFilled(false);
        TABLERO.add(boton97, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 7, 51, 53));

        boton47.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton47.setForeground(new java.awt.Color(255, 255, 255));
        boton47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/10D.jpg"))); // NOI18N
        boton47.setBorder(null);
        boton47.setBorderPainted(false);
        boton47.setContentAreaFilled(false);
        TABLERO.add(boton47, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 305, 51, 53));

        boton48.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton48.setForeground(new java.awt.Color(255, 255, 255));
        boton48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/6H.jpg"))); // NOI18N
        boton48.setBorder(null);
        boton48.setBorderPainted(false);
        boton48.setContentAreaFilled(false);
        TABLERO.add(boton48, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 305, 51, 53));

        boton24.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton24.setForeground(new java.awt.Color(255, 255, 255));
        boton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/KC.jpg"))); // NOI18N
        boton24.setBorder(null);
        boton24.setBorderPainted(false);
        boton24.setContentAreaFilled(false);
        TABLERO.add(boton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 423, 51, 53));

        boton06.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton06.setForeground(new java.awt.Color(255, 255, 255));
        boton06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/8D.jpg"))); // NOI18N
        boton06.setBorder(null);
        boton06.setBorderPainted(false);
        boton06.setContentAreaFilled(false);
        TABLERO.add(boton06, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 542, 51, 53));

        boton38.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton38.setForeground(new java.awt.Color(255, 255, 255));
        boton38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/5H.jpg"))); // NOI18N
        boton38.setBorder(null);
        boton38.setBorderPainted(false);
        boton38.setContentAreaFilled(false);
        TABLERO.add(boton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 364, 51, 53));

        boton70.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton70.setForeground(new java.awt.Color(255, 255, 255));
        boton70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/7C.jpg"))); // NOI18N
        boton70.setBorder(null);
        boton70.setBorderPainted(false);
        boton70.setContentAreaFilled(false);
        TABLERO.add(boton70, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 125, 51, 53));

        boton96.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton96.setForeground(new java.awt.Color(255, 255, 255));
        boton96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/7S.jpg"))); // NOI18N
        boton96.setBorder(null);
        boton96.setBorderPainted(false);
        boton96.setContentAreaFilled(false);
        TABLERO.add(boton96, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 7, 51, 53));

        boton03.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton03.setForeground(new java.awt.Color(255, 255, 255));
        boton03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/QD.jpg"))); // NOI18N
        boton03.setBorder(null);
        boton03.setBorderPainted(false);
        boton03.setContentAreaFilled(false);
        TABLERO.add(boton03, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 51, 53));

        boton33.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton33.setForeground(new java.awt.Color(255, 255, 255));
        boton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/8H.jpg"))); // NOI18N
        boton33.setBorder(null);
        boton33.setBorderPainted(false);
        boton33.setContentAreaFilled(false);
        TABLERO.add(boton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 364, 51, 53));

        boton46.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton46.setForeground(new java.awt.Color(255, 255, 255));
        boton46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/KH.jpg"))); // NOI18N
        boton46.setBorder(null);
        boton46.setBorderPainted(false);
        boton46.setContentAreaFilled(false);
        TABLERO.add(boton46, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 305, 51, 53));

        boton12.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton12.setForeground(new java.awt.Color(255, 255, 255));
        boton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/6S.jpg"))); // NOI18N
        boton12.setBorder(null);
        boton12.setBorderPainted(false);
        boton12.setContentAreaFilled(false);
        TABLERO.add(boton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 483, 51, 53));

        boton68.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton68.setForeground(new java.awt.Color(255, 255, 255));
        boton68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/8H.jpg"))); // NOI18N
        boton68.setBorder(null);
        boton68.setBorderPainted(false);
        boton68.setContentAreaFilled(false);
        TABLERO.add(boton68, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 185, 51, 53));

        boton09.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton09.setForeground(new java.awt.Color(255, 255, 255));
        boton09.setBorder(null);
        boton09.setBorderPainted(false);
        boton09.setContentAreaFilled(false);
        boton09.setEnabled(false);
        TABLERO.add(boton09, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 542, 51, 53));

        boton79.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton79.setForeground(new java.awt.Color(255, 255, 255));
        boton79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/QS.jpg"))); // NOI18N
        boton79.setBorder(null);
        boton79.setBorderPainted(false);
        boton79.setContentAreaFilled(false);
        TABLERO.add(boton79, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 125, 51, 53));

        boton36.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton36.setForeground(new java.awt.Color(255, 255, 255));
        boton36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/QH.jpg"))); // NOI18N
        boton36.setBorder(null);
        boton36.setBorderPainted(false);
        boton36.setContentAreaFilled(false);
        TABLERO.add(boton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 364, 51, 53));

        boton01.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton01.setForeground(new java.awt.Color(255, 255, 255));
        boton01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/AD.jpg"))); // NOI18N
        boton01.setBorder(null);
        boton01.setBorderPainted(false);
        TABLERO.add(boton01, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 542, 51, 53));

        boton16.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton16.setForeground(new java.awt.Color(255, 255, 255));
        boton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/2S.jpg"))); // NOI18N
        boton16.setBorder(null);
        boton16.setBorderPainted(false);
        boton16.setContentAreaFilled(false);
        TABLERO.add(boton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 483, 51, 53));

        boton67.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton67.setForeground(new java.awt.Color(255, 255, 255));
        boton67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/8D.jpg"))); // NOI18N
        boton67.setBorder(null);
        boton67.setBorderPainted(false);
        boton67.setContentAreaFilled(false);
        TABLERO.add(boton67, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 185, 51, 53));

        boton14.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton14.setForeground(new java.awt.Color(255, 255, 255));
        boton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/4S.jpg"))); // NOI18N
        boton14.setBorder(null);
        boton14.setBorderPainted(false);
        boton14.setContentAreaFilled(false);
        TABLERO.add(boton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 483, 51, 53));

        boton82.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton82.setForeground(new java.awt.Color(255, 255, 255));
        boton82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/4C.jpg"))); // NOI18N
        boton82.setBorder(null);
        boton82.setBorderPainted(false);
        boton82.setContentAreaFilled(false);
        TABLERO.add(boton82, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 65, 51, 53));

        boton93.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton93.setForeground(new java.awt.Color(255, 255, 255));
        boton93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/4S.jpg"))); // NOI18N
        boton93.setBorder(null);
        boton93.setBorderPainted(false);
        boton93.setContentAreaFilled(false);
        TABLERO.add(boton93, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 7, 51, 53));

        boton17.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton17.setForeground(new java.awt.Color(255, 255, 255));
        boton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/2H.jpg"))); // NOI18N
        boton17.setBorder(null);
        boton17.setBorderPainted(false);
        boton17.setContentAreaFilled(false);
        TABLERO.add(boton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 483, 51, 53));

        boton54.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton54.setForeground(new java.awt.Color(255, 255, 255));
        boton54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/5H.jpg"))); // NOI18N
        boton54.setBorder(null);
        boton54.setBorderPainted(false);
        boton54.setContentAreaFilled(false);
        TABLERO.add(boton54, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 245, 51, 53));

        boton51.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton51.setForeground(new java.awt.Color(255, 255, 255));
        boton51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/QS.jpg"))); // NOI18N
        boton51.setBorder(null);
        boton51.setBorderPainted(false);
        boton51.setContentAreaFilled(false);
        TABLERO.add(boton51, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 245, 51, 53));

        boton63.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton63.setForeground(new java.awt.Color(255, 255, 255));
        boton63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/5C.jpg"))); // NOI18N
        boton63.setBorder(null);
        boton63.setBorderPainted(false);
        boton63.setContentAreaFilled(false);
        TABLERO.add(boton63, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 185, 51, 53));

        boton56.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton56.setForeground(new java.awt.Color(255, 255, 255));
        boton56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/AH.jpg"))); // NOI18N
        boton56.setBorder(null);
        boton56.setBorderPainted(false);
        boton56.setContentAreaFilled(false);
        TABLERO.add(boton56, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 245, 51, 53));

        boton88.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton88.setForeground(new java.awt.Color(255, 255, 255));
        boton88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/10H.jpg"))); // NOI18N
        boton88.setBorder(null);
        boton88.setBorderPainted(false);
        boton88.setContentAreaFilled(false);
        TABLERO.add(boton88, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 65, 51, 53));

        boton30.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton30.setForeground(new java.awt.Color(255, 255, 255));
        boton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/QC.jpg"))); // NOI18N
        boton30.setBorder(null);
        boton30.setBorderPainted(false);
        boton30.setContentAreaFilled(false);
        TABLERO.add(boton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 364, 51, 53));

        boton11.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton11.setForeground(new java.awt.Color(255, 255, 255));
        boton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/7S.jpg"))); // NOI18N
        boton11.setBorder(null);
        boton11.setBorderPainted(false);
        boton11.setContentAreaFilled(false);
        TABLERO.add(boton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 483, 51, 53));

        boton42.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton42.setForeground(new java.awt.Color(255, 255, 255));
        boton42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/8C.jpg"))); // NOI18N
        boton42.setBorder(null);
        boton42.setBorderPainted(false);
        boton42.setContentAreaFilled(false);
        TABLERO.add(boton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 305, 51, 53));

        boton02.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton02.setForeground(new java.awt.Color(255, 255, 255));
        boton02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/KD.jpg"))); // NOI18N
        boton02.setBorder(null);
        boton02.setBorderPainted(false);
        boton02.setContentAreaFilled(false);
        TABLERO.add(boton02, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 542, 51, 53));

        boton92.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        boton92.setForeground(new java.awt.Color(255, 255, 255));
        boton92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/3S.jpg"))); // NOI18N
        boton92.setBorder(null);
        boton92.setBorderPainted(false);
        boton92.setContentAreaFilled(false);
        TABLERO.add(boton92, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 7, 51, 53));

        TABLEROLABEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tokens/tableroimg.jpg"))); // NOI18N
        TABLEROLABEL.setToolTipText("");
        TABLERO.add(TABLEROLABEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 600));

        layeredpaneizq.setPreferredSize(new java.awt.Dimension(250, 802));
        layeredpaneizq.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tresjugadoresizq.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        javax.swing.GroupLayout tresjugadoresizqLayout = new javax.swing.GroupLayout(tresjugadoresizq);
        tresjugadoresizq.setLayout(tresjugadoresizqLayout);
        tresjugadoresizqLayout.setHorizontalGroup(
            tresjugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tresjugadoresizqLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(tresjugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tresjugadoresizqLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tresjugadoresizqLayout.createSequentialGroup()
                        .addComponent(tresnombrejugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
        );
        tresjugadoresizqLayout.setVerticalGroup(
            tresjugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tresjugadoresizqLayout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(tresnombrejugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(367, Short.MAX_VALUE))
        );

        layeredpaneizq.add(tresjugadoresizq, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 270, 820));

        dosjugadoresizq.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        javax.swing.GroupLayout dosjugadoresizqLayout = new javax.swing.GroupLayout(dosjugadoresizq);
        dosjugadoresizq.setLayout(dosjugadoresizqLayout);
        dosjugadoresizqLayout.setHorizontalGroup(
            dosjugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dosjugadoresizqLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(dosjugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dosjugadoresizqLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dosjugadoresizqLayout.createSequentialGroup()
                        .addComponent(dosnombrejugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        dosjugadoresizqLayout.setVerticalGroup(
            dosjugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dosjugadoresizqLayout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(dosnombrejugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(367, Short.MAX_VALUE))
        );

        layeredpaneizq.add(dosjugadoresizq, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 270, 820));

        cuatrojugadoresizq.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        javax.swing.GroupLayout cuatrojugadoresizqLayout = new javax.swing.GroupLayout(cuatrojugadoresizq);
        cuatrojugadoresizq.setLayout(cuatrojugadoresizqLayout);
        cuatrojugadoresizqLayout.setHorizontalGroup(
            cuatrojugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cuatrojugadoresizqLayout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(cuatrojugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cuatrojugadoresizqLayout.createSequentialGroup()
                        .addGroup(cuatrojugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20))
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cuatrojugadoresizqLayout.createSequentialGroup()
                        .addGroup(cuatrojugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cuatronombrejugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cuatronombrejugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64))))
        );
        cuatrojugadoresizqLayout.setVerticalGroup(
            cuatrojugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cuatrojugadoresizqLayout.createSequentialGroup()
                .addContainerGap(216, Short.MAX_VALUE)
                .addComponent(cuatronombrejugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addGap(64, 64, 64)
                .addComponent(cuatronombrejugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addGap(206, 206, 206))
        );

        layeredpaneizq.add(cuatrojugadoresizq, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 270, 820));

        seisjugadoresizq.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        javax.swing.GroupLayout seisjugadoresizqLayout = new javax.swing.GroupLayout(seisjugadoresizq);
        seisjugadoresizq.setLayout(seisjugadoresizqLayout);
        seisjugadoresizqLayout.setHorizontalGroup(
            seisjugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seisjugadoresizqLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(seisjugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seisjugadoresizqLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(seisjugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seisnombrejugador5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seisnombrejugador6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seisnombrejugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );
        seisjugadoresizqLayout.setVerticalGroup(
            seisjugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seisjugadoresizqLayout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addComponent(seisnombrejugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGap(46, 46, 46)
                .addComponent(seisnombrejugador5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addGap(37, 37, 37)
                .addComponent(seisnombrejugador6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addGap(63, 63, 63))
        );

        layeredpaneizq.add(seisjugadoresizq, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 270, 820));

        ochojugadoresizq.setBackground(new java.awt.Color(255, 255, 255));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        javax.swing.GroupLayout ochojugadoresizqLayout = new javax.swing.GroupLayout(ochojugadoresizq);
        ochojugadoresizq.setLayout(ochojugadoresizqLayout);
        ochojugadoresizqLayout.setHorizontalGroup(
            ochojugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ochojugadoresizqLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(ochojugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ochojugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ochonombrejugador7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ochonombrejugador8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
            .addGroup(ochojugadoresizqLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(ochojugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ochojugadoresizqLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ochonombrejugador5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ochojugadoresizqLayout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ochonombrejugador6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        ochojugadoresizqLayout.setVerticalGroup(
            ochojugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ochojugadoresizqLayout.createSequentialGroup()
                .addGroup(ochojugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ochojugadoresizqLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(ochonombrejugador5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)
                        .addComponent(ochonombrejugador6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165)
                        .addComponent(ochonombrejugador7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159)
                        .addComponent(ochonombrejugador8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ochojugadoresizqLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel32)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel33)))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        layeredpaneizq.add(ochojugadoresizq, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 270, 820));

        layeredpaneder.setPreferredSize(new java.awt.Dimension(250, 802));
        layeredpaneder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dosjugadoresder.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("BARAJA");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N
        jLabel4.setText("jLabel3");

        javax.swing.GroupLayout dosjugadoresderLayout = new javax.swing.GroupLayout(dosjugadoresder);
        dosjugadoresder.setLayout(dosjugadoresderLayout);
        dosjugadoresderLayout.setHorizontalGroup(
            dosjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dosjugadoresderLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(dosjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dosjugadoresderLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        dosjugadoresderLayout.setVerticalGroup(
            dosjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dosjugadoresderLayout.createSequentialGroup()
                .addContainerGap(353, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(333, 333, 333))
        );

        layeredpaneder.add(dosjugadoresder, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 270, 820));

        cuatrojugadoresder.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("BARAJA");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N
        jLabel8.setText("jLabel3");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        javax.swing.GroupLayout cuatrojugadoresderLayout = new javax.swing.GroupLayout(cuatrojugadoresder);
        cuatrojugadoresder.setLayout(cuatrojugadoresderLayout);
        cuatrojugadoresderLayout.setHorizontalGroup(
            cuatrojugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cuatrojugadoresderLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(cuatrojugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cuatronombrejugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cuatrojugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(cuatrojugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cuatrojugadoresderLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel19)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        cuatrojugadoresderLayout.setVerticalGroup(
            cuatrojugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cuatrojugadoresderLayout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addComponent(cuatronombrejugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(177, 177, 177)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );

        layeredpaneder.add(cuatrojugadoresder, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 270, 820));

        ochojugadoresder.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("BARAJA");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N
        jLabel12.setText("jLabel3");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        javax.swing.GroupLayout ochojugadoresderLayout = new javax.swing.GroupLayout(ochojugadoresder);
        ochojugadoresder.setLayout(ochojugadoresderLayout);
        ochojugadoresderLayout.setHorizontalGroup(
            ochojugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ochojugadoresderLayout.createSequentialGroup()
                .addGroup(ochojugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ochojugadoresderLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ochojugadoresderLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(ochojugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ochojugadoresderLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ochonombrejugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ochojugadoresderLayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ochonombrejugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ochojugadoresderLayout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ochonombrejugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        ochojugadoresderLayout.setVerticalGroup(
            ochojugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ochojugadoresderLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(ochojugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ochojugadoresderLayout.createSequentialGroup()
                        .addComponent(ochonombrejugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addGap(44, 44, 44)
                .addGroup(ochojugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ochojugadoresderLayout.createSequentialGroup()
                        .addComponent(ochonombrejugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addGap(53, 53, 53)
                .addGroup(ochojugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ochojugadoresderLayout.createSequentialGroup()
                        .addComponent(ochonombrejugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addGap(26, 26, 26)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        layeredpaneder.add(ochojugadoresder, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 270, 820));

        tresjugadoresder.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("BARAJA");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N
        jLabel6.setText("jLabel3");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        javax.swing.GroupLayout tresjugadoresderLayout = new javax.swing.GroupLayout(tresjugadoresder);
        tresjugadoresder.setLayout(tresjugadoresderLayout);
        tresjugadoresderLayout.setHorizontalGroup(
            tresjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tresjugadoresderLayout.createSequentialGroup()
                .addGap(0, 86, Short.MAX_VALUE)
                .addGroup(tresjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tresjugadoresderLayout.createSequentialGroup()
                        .addGroup(tresjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tresjugadoresderLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18))
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tresjugadoresderLayout.createSequentialGroup()
                        .addComponent(tresnombrejugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
        );
        tresjugadoresderLayout.setVerticalGroup(
            tresjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tresjugadoresderLayout.createSequentialGroup()
                .addContainerGap(287, Short.MAX_VALUE)
                .addComponent(tresnombrejugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(141, 141, 141)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        layeredpaneder.add(tresjugadoresder, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 270, 820));

        seisjugadoresder.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("BARAJA");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N
        jLabel10.setText("jLabel3");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardBack.png"))); // NOI18N

        javax.swing.GroupLayout seisjugadoresderLayout = new javax.swing.GroupLayout(seisjugadoresder);
        seisjugadoresder.setLayout(seisjugadoresderLayout);
        seisjugadoresderLayout.setHorizontalGroup(
            seisjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seisjugadoresderLayout.createSequentialGroup()
                .addGroup(seisjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(seisjugadoresderLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(seisjugadoresderLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(seisjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))))
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seisjugadoresderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(seisjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seisnombrejugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seisnombrejugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );
        seisjugadoresderLayout.setVerticalGroup(
            seisjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seisjugadoresderLayout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(seisnombrejugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addGap(56, 56, 56)
                .addComponent(seisnombrejugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addGap(85, 85, 85)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        layeredpaneder.add(seisjugadoresder, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 270, 820));

        SALIRTABLERO.setText("Salir de la partida");

        CAMBIARPOS.setText("Cambiar posicion de cartas de baraja");

        ultimacarta.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        ultimacarta.setForeground(new java.awt.Color(255, 255, 255));
        ultimacarta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/8D.jpg"))); // NOI18N
        ultimacarta.setBorder(null);
        ultimacarta.setBorderPainted(false);
        ultimacarta.setContentAreaFilled(false);
        ultimacarta.setEnabled(false);

        jLabel1.setText("Ultima Carta Seleccionada:");

        DESCARTAR.setText("Descartar carta de la baraja");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(layeredpaneizq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TABLERO, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(layeredpanecartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(CAMBIARPOS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DESCARTAR)
                                .addGap(113, 113, 113)))
                        .addComponent(layeredpaneder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(436, 436, 436)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ultimacarta, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(SALIRTABLERO))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TABLERO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CAMBIARPOS)
                            .addComponent(DESCARTAR))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(layeredpanecartas, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(layeredpaneder, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(layeredpaneizq, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ultimacarta, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(SALIRTABLERO)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cuatrocartasboton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuatrocartasboton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuatrocartasboton4ActionPerformed

    private void sietecartasboton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sietecartasboton1ActionPerformed

    }//GEN-LAST:event_sietecartasboton1ActionPerformed

    private void sietecartasboton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sietecartasboton2ActionPerformed

    }//GEN-LAST:event_sietecartasboton2ActionPerformed

    private void sietecartasboton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sietecartasboton3ActionPerformed

    }//GEN-LAST:event_sietecartasboton3ActionPerformed

    private void sietecartasboton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sietecartasboton4ActionPerformed

    }//GEN-LAST:event_sietecartasboton4ActionPerformed

    private void sietecartasboton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sietecartasboton5ActionPerformed

    }//GEN-LAST:event_sietecartasboton5ActionPerformed

    private void sietecartasboton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sietecartasboton6ActionPerformed

    }//GEN-LAST:event_sietecartasboton6ActionPerformed

    private void sietecartasboton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sietecartasboton7ActionPerformed

    }//GEN-LAST:event_sietecartasboton7ActionPerformed

    private void seiscartasboton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seiscartasboton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seiscartasboton2ActionPerformed

    private void boton00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton00ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton00ActionPerformed

    private void boton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton62ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton62ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CAMBIARPOS;
    private javax.swing.JButton DESCARTAR;
    private javax.swing.JButton SALIRTABLERO;
    private javax.swing.JLayeredPane TABLERO;
    private javax.swing.JLabel TABLEROLABEL;
    private javax.swing.JButton boton00;
    private javax.swing.JButton boton01;
    private javax.swing.JButton boton02;
    private javax.swing.JButton boton03;
    private javax.swing.JButton boton04;
    private javax.swing.JButton boton05;
    private javax.swing.JButton boton06;
    private javax.swing.JButton boton07;
    private javax.swing.JButton boton08;
    private javax.swing.JButton boton09;
    private javax.swing.JButton boton10;
    private javax.swing.JButton boton11;
    private javax.swing.JButton boton12;
    private javax.swing.JButton boton13;
    private javax.swing.JButton boton14;
    private javax.swing.JButton boton15;
    private javax.swing.JButton boton16;
    private javax.swing.JButton boton17;
    private javax.swing.JButton boton18;
    private javax.swing.JButton boton19;
    private javax.swing.JButton boton20;
    private javax.swing.JButton boton21;
    private javax.swing.JButton boton22;
    private javax.swing.JButton boton23;
    private javax.swing.JButton boton24;
    private javax.swing.JButton boton25;
    private javax.swing.JButton boton26;
    private javax.swing.JButton boton27;
    private javax.swing.JButton boton28;
    private javax.swing.JButton boton29;
    private javax.swing.JButton boton30;
    private javax.swing.JButton boton31;
    private javax.swing.JButton boton32;
    private javax.swing.JButton boton33;
    private javax.swing.JButton boton34;
    private javax.swing.JButton boton35;
    private javax.swing.JButton boton36;
    private javax.swing.JButton boton37;
    private javax.swing.JButton boton38;
    private javax.swing.JButton boton39;
    private javax.swing.JButton boton40;
    private javax.swing.JButton boton41;
    private javax.swing.JButton boton42;
    private javax.swing.JButton boton43;
    private javax.swing.JButton boton44;
    private javax.swing.JButton boton45;
    private javax.swing.JButton boton46;
    private javax.swing.JButton boton47;
    private javax.swing.JButton boton48;
    private javax.swing.JButton boton49;
    private javax.swing.JButton boton50;
    private javax.swing.JButton boton51;
    private javax.swing.JButton boton52;
    private javax.swing.JButton boton53;
    private javax.swing.JButton boton54;
    private javax.swing.JButton boton55;
    private javax.swing.JButton boton56;
    private javax.swing.JButton boton57;
    private javax.swing.JButton boton58;
    private javax.swing.JButton boton59;
    private javax.swing.JButton boton60;
    private javax.swing.JButton boton61;
    private javax.swing.JButton boton62;
    private javax.swing.JButton boton63;
    private javax.swing.JButton boton64;
    private javax.swing.JButton boton65;
    private javax.swing.JButton boton66;
    private javax.swing.JButton boton67;
    private javax.swing.JButton boton68;
    private javax.swing.JButton boton69;
    private javax.swing.JButton boton70;
    private javax.swing.JButton boton71;
    private javax.swing.JButton boton72;
    private javax.swing.JButton boton73;
    private javax.swing.JButton boton74;
    private javax.swing.JButton boton75;
    private javax.swing.JButton boton76;
    private javax.swing.JButton boton77;
    private javax.swing.JButton boton78;
    private javax.swing.JButton boton79;
    private javax.swing.JButton boton80;
    private javax.swing.JButton boton81;
    private javax.swing.JButton boton82;
    private javax.swing.JButton boton83;
    private javax.swing.JButton boton84;
    private javax.swing.JButton boton85;
    private javax.swing.JButton boton86;
    private javax.swing.JButton boton87;
    private javax.swing.JButton boton88;
    private javax.swing.JButton boton89;
    private javax.swing.JButton boton90;
    private javax.swing.JButton boton91;
    private javax.swing.JButton boton92;
    private javax.swing.JButton boton93;
    private javax.swing.JButton boton94;
    private javax.swing.JButton boton95;
    private javax.swing.JButton boton96;
    private javax.swing.JButton boton97;
    private javax.swing.JButton boton98;
    private javax.swing.JButton boton99;
    private javax.swing.JPanel cincocartas;
    private javax.swing.JButton cincocartasboton1;
    private javax.swing.JButton cincocartasboton2;
    private javax.swing.JButton cincocartasboton3;
    private javax.swing.JButton cincocartasboton4;
    private javax.swing.JButton cincocartasboton5;
    private javax.swing.JPanel cuatrocartas;
    private javax.swing.JButton cuatrocartasboton1;
    private javax.swing.JButton cuatrocartasboton2;
    private javax.swing.JButton cuatrocartasboton3;
    private javax.swing.JButton cuatrocartasboton4;
    private javax.swing.JPanel cuatrojugadoresder;
    private javax.swing.JPanel cuatrojugadoresizq;
    private javax.swing.JLabel cuatronombrejugador2;
    private javax.swing.JLabel cuatronombrejugador3;
    private javax.swing.JLabel cuatronombrejugador4;
    private javax.swing.JPanel dosjugadoresder;
    private javax.swing.JPanel dosjugadoresizq;
    private javax.swing.JLabel dosnombrejugador2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel label00;
    private javax.swing.JLabel label01;
    private javax.swing.JLabel label02;
    private javax.swing.JLabel label03;
    private javax.swing.JLabel label04;
    private javax.swing.JLabel label05;
    private javax.swing.JLabel label06;
    private javax.swing.JLabel label07;
    private javax.swing.JLabel label08;
    private javax.swing.JLabel label09;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label12;
    private javax.swing.JLabel label13;
    private javax.swing.JLabel label14;
    private javax.swing.JLabel label15;
    private javax.swing.JLabel label16;
    private javax.swing.JLabel label17;
    private javax.swing.JLabel label18;
    private javax.swing.JLabel label19;
    private javax.swing.JLabel label20;
    private javax.swing.JLabel label21;
    private javax.swing.JLabel label22;
    private javax.swing.JLabel label23;
    private javax.swing.JLabel label24;
    private javax.swing.JLabel label25;
    private javax.swing.JLabel label26;
    private javax.swing.JLabel label27;
    private javax.swing.JLabel label28;
    private javax.swing.JLabel label29;
    private javax.swing.JLabel label30;
    private javax.swing.JLabel label31;
    private javax.swing.JLabel label32;
    private javax.swing.JLabel label33;
    private javax.swing.JLabel label34;
    private javax.swing.JLabel label35;
    private javax.swing.JLabel label36;
    private javax.swing.JLabel label37;
    private javax.swing.JLabel label38;
    private javax.swing.JLabel label39;
    private javax.swing.JLabel label40;
    private javax.swing.JLabel label41;
    private javax.swing.JLabel label42;
    private javax.swing.JLabel label43;
    private javax.swing.JLabel label44;
    private javax.swing.JLabel label45;
    private javax.swing.JLabel label46;
    private javax.swing.JLabel label47;
    private javax.swing.JLabel label48;
    private javax.swing.JLabel label49;
    private javax.swing.JLabel label50;
    private javax.swing.JLabel label51;
    private javax.swing.JLabel label52;
    private javax.swing.JLabel label53;
    private javax.swing.JLabel label54;
    private javax.swing.JLabel label55;
    private javax.swing.JLabel label56;
    private javax.swing.JLabel label57;
    private javax.swing.JLabel label58;
    private javax.swing.JLabel label59;
    private javax.swing.JLabel label60;
    private javax.swing.JLabel label61;
    private javax.swing.JLabel label62;
    private javax.swing.JLabel label63;
    private javax.swing.JLabel label64;
    private javax.swing.JLabel label65;
    private javax.swing.JLabel label66;
    private javax.swing.JLabel label67;
    private javax.swing.JLabel label68;
    private javax.swing.JLabel label69;
    private javax.swing.JLabel label70;
    private javax.swing.JLabel label71;
    private javax.swing.JLabel label72;
    private javax.swing.JLabel label73;
    private javax.swing.JLabel label74;
    private javax.swing.JLabel label75;
    private javax.swing.JLabel label76;
    private javax.swing.JLabel label77;
    private javax.swing.JLabel label78;
    private javax.swing.JLabel label79;
    private javax.swing.JLabel label80;
    private javax.swing.JLabel label81;
    private javax.swing.JLabel label82;
    private javax.swing.JLabel label83;
    private javax.swing.JLabel label84;
    private javax.swing.JLabel label85;
    private javax.swing.JLabel label86;
    private javax.swing.JLabel label87;
    private javax.swing.JLabel label88;
    private javax.swing.JLabel label89;
    private javax.swing.JLabel label90;
    private javax.swing.JLabel label91;
    private javax.swing.JLabel label92;
    private javax.swing.JLabel label93;
    private javax.swing.JLabel label94;
    private javax.swing.JLabel label95;
    private javax.swing.JLabel label96;
    private javax.swing.JLabel label97;
    private javax.swing.JLabel label98;
    private javax.swing.JLabel label99;
    private javax.swing.JLayeredPane layeredpanecartas;
    private javax.swing.JLayeredPane layeredpaneder;
    private javax.swing.JLayeredPane layeredpaneizq;
    private javax.swing.JLabel nombrejugadoractual;
    private javax.swing.JPanel ochojugadoresder;
    private javax.swing.JPanel ochojugadoresizq;
    private javax.swing.JLabel ochonombrejugador2;
    private javax.swing.JLabel ochonombrejugador3;
    private javax.swing.JLabel ochonombrejugador4;
    private javax.swing.JLabel ochonombrejugador5;
    private javax.swing.JLabel ochonombrejugador6;
    private javax.swing.JLabel ochonombrejugador7;
    private javax.swing.JLabel ochonombrejugador8;
    private javax.swing.JPanel seiscartas;
    private javax.swing.JButton seiscartasboton1;
    private javax.swing.JButton seiscartasboton2;
    private javax.swing.JButton seiscartasboton3;
    private javax.swing.JButton seiscartasboton4;
    private javax.swing.JButton seiscartasboton5;
    private javax.swing.JButton seiscartasboton6;
    private javax.swing.JPanel seisjugadoresder;
    private javax.swing.JPanel seisjugadoresizq;
    private javax.swing.JLabel seisnombrejugador2;
    private javax.swing.JLabel seisnombrejugador3;
    private javax.swing.JLabel seisnombrejugador4;
    private javax.swing.JLabel seisnombrejugador5;
    private javax.swing.JLabel seisnombrejugador6;
    private javax.swing.JPanel sietecartas;
    private javax.swing.JButton sietecartasboton1;
    private javax.swing.JButton sietecartasboton2;
    private javax.swing.JButton sietecartasboton3;
    private javax.swing.JButton sietecartasboton4;
    private javax.swing.JButton sietecartasboton5;
    private javax.swing.JButton sietecartasboton6;
    private javax.swing.JButton sietecartasboton7;
    private javax.swing.JPanel tresjugadoresder;
    private javax.swing.JPanel tresjugadoresizq;
    private javax.swing.JLabel tresnombrejugador2;
    private javax.swing.JLabel tresnombrejugador3;
    private javax.swing.JButton ultimacarta;
    // End of variables declaration//GEN-END:variables

}
