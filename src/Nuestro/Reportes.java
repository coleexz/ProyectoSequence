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
import javax.swing.JTextArea;

/**
 *
 * @author josuc
 */
public class Reportes extends JFrame implements ActionListener {
    JPanel panelConfiguracion = new JPanel();
    JLabel lblConfiguracion = new JLabel();
    JButton botonRegresar = new JButton();
    JTextArea txtReportes = new JTextArea();
    
    public Reportes() {
        setSize(500,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelConfiguracion.setSize(500, 500);
        panelConfiguracion.setLayout(null);
        add(panelConfiguracion);
        
        lblConfiguracion.setText("REPORTES");
        lblConfiguracion.setBounds(160, 30, 200, 35);
        lblConfiguracion.setFont(new Font(null, Font.PLAIN, 30));
        lblConfiguracion.setForeground(Color.black);
        panelConfiguracion.add(lblConfiguracion);
        
        botonRegresar.setText("Regresar");
        botonRegresar.setBounds(80, 420, 120, 30);
        botonRegresar.addActionListener(this);
        botonRegresar.setBackground(Color.white);
        botonRegresar.setFont(new Font(null,Font.BOLD,18));
        panelConfiguracion.add(botonRegresar);
        
        txtReportes.setText("");
        txtReportes.setBounds(50, 100, 400, 300);
        panelConfiguracion.add(txtReportes);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonRegresar) {
            MENUPRINCIPAL menu=new MENUPRINCIPAL();
            menu.setVisible(true);
            this.dispose();
        }
    }
}
