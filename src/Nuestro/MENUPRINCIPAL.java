/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nuestro;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author AdminColeexz
 */
public class MENUPRINCIPAL extends JFrame implements ActionListener {
    JPanel panelMenu = new JPanel();
    JButton botonSignOut = new JButton();

    public MENUPRINCIPAL(){
        setSize(500,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelMenu.setSize(500, 500);
        panelMenu.setLayout(null);
        add(panelMenu);
        
        botonSignOut.setText("Cerrar Sesion");
        botonSignOut.setBounds(180, 230, 150, 30);
        botonSignOut.addActionListener(this);
        botonSignOut.setBackground(Color.white);
        panelMenu.add(botonSignOut);
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
