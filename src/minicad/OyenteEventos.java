/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minicad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Mario Pineda
 */
public class OyenteEventos implements ActionListener {

    private JFrame ventana;

    public OyenteEventos(JFrame ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        boton.getName();
        switch (boton.getName()) {
            case "escalar":
                System.out.println("Presionó escalar");
                break;
            case "rotar":
                System.out.println("Presionó rotar");
                break;
            case "botonx":
                System.out.println("Presionó En X");
                break;
            case "botony":
                System.out.println("Presionó en Y");
                break;

        }
    }

}
