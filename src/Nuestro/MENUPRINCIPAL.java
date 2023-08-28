/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nuestro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author AdminColeexz
 */
public class MENUPRINCIPAL extends JFrame implements ActionListener {
    JPanel panelMenu = new JPanel();
    JButton botonConfiguracion = new JButton();
    JButton botonJugar = new JButton();
    JButton botonReportes = new JButton();
    JButton botonLogout = new JButton();
    JLabel lblMenu = new JLabel();

    public MENUPRINCIPAL(){
        setSize(500,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelMenu.setSize(500, 500);
        panelMenu.setLayout(null);
        add(panelMenu);
        
        lblMenu.setText("MENU PRINCIPAL");
        lblMenu.setBounds(120, 30, 280, 35);
        lblMenu.setFont(new Font(null, Font.PLAIN, 30));
        lblMenu.setForeground(Color.black);
        panelMenu.add(lblMenu);        
        
        botonJugar.setText("Jugar");
        botonJugar.setBounds(185, 100, 130, 30);
        botonJugar.addActionListener(this);
        botonJugar.setBackground(Color.white);
        panelMenu.add(botonJugar);
        
        botonConfiguracion.setText("Configuracion");
        botonConfiguracion.setBounds(185, 200, 130, 30);
        botonConfiguracion.addActionListener(this);
        botonConfiguracion.setBackground(Color.white);
        panelMenu.add(botonConfiguracion);
        
        botonReportes.setText("Reportes");
        botonReportes.setBounds(185, 300, 130, 30);
        botonReportes.addActionListener(this);
        botonReportes.setBackground(Color.white);
        panelMenu.add(botonReportes);        
        
        botonLogout.setText("Cerrar Sesion");
        botonLogout.setBounds(185, 400, 130, 30);
        botonLogout.addActionListener(this);
        botonLogout.setBackground(Color.white);
        panelMenu.add(botonLogout);  
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == botonJugar){
            CONFIG menureportes = new CONFIG();
            TABLERO tablero = new TABLERO(menureportes.numerojugadores);
            tablero.setVisible(true);
            this.dispose();
        }
        if (e.getSource() == botonLogout) {
            LOGIN login = new LOGIN();
            login.setVisible(true);
            this.dispose();
        }
        
        if (e.getSource() == botonReportes) {
            Reportes reportes = new Reportes();
            reportes.setVisible(true);
            this.dispose();
        }
        
        if (e.getSource() == botonConfiguracion) {
            CONFIG menus = new CONFIG();
            menus.setVisible(true);
            this.dispose();
        }
    }
    
}
