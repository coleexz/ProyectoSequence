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
    JButton botonSignOut = new JButton();
    JButton botonJugar = new JButton();
    JButton botonReportes = new JButton();
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
        lblMenu.setBounds(120, 30, 280, 50);
        lblMenu.setFont(new Font(null, Font.PLAIN, 30));
        lblMenu.setForeground(Color.black);
        panelMenu.add(lblMenu);        
        
        botonJugar.setText("Jugar");
        botonJugar.setBounds(185, 125, 130, 30);
        botonJugar.addActionListener(this);
        botonJugar.setBackground(Color.white);
        panelMenu.add(botonJugar);
        
        botonSignOut.setText("Cerrar Sesion");
        botonSignOut.setBounds(185, 250, 130, 30);
        botonSignOut.addActionListener(this);
        botonSignOut.setBackground(Color.white);
        panelMenu.add(botonSignOut);
        
        botonReportes.setText("Reportes");
        botonReportes.setBounds(185, 375, 130, 30);
        botonReportes.addActionListener(this);
        botonReportes.setBackground(Color.white);
        panelMenu.add(botonReportes);        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonSignOut) {
            LOGIN login = new LOGIN();
            login.setVisible(true);
            this.dispose();
        }
    }
    
}
