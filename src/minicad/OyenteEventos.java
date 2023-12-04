/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minicad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Mario Pineda
 */
public class OyenteEventos extends MouseAdapter implements ActionListener {

    private Ventana vista;
    private PanelDibujable panel;

    public OyenteEventos(Ventana vistapane, PanelDibujable panel) {
        this.vista = vista;
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Posicion en x " + e.getComponent().getLocation().getX());
        System.out.println("Posicion en y " + e.getComponent().getLocation().getY());
        System.out.println("Mouse Presionao'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        boton.getName();
        switch (boton.getName()) {
            case "escalar":
                System.out.println("Presionó escalar " + vista.getEscala());
                break;
            case "rotar":
                System.out.println("Presionó rotar");
                break;
            case "botonx":
                System.out.println("Presionó En X: " + vista.getMovX());
                break;
            case "botony":
                System.out.println("Presionó en Y: "+ vista.getMovY());
                break;
            case "seleccion":
                System.out.println("Seleccion: " + vista.getSeleccionFigura());
                break;
            case "limpiar":
                System.out.println("Limpiar");
                break;
        }
    }

}
