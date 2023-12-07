/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minicad;

/**
 *
 * @author Pineda Mario Numero de control: 21020414 Grupo: 8:00 - 9:00
 */
public class MiniCAD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ventana ventana = new Ventana();
        PanelDibujable panel = new PanelDibujable();
        OyenteEventos oyente = new OyenteEventos(ventana, panel);
        //*******************//
        ventana.addEventos(oyente);
        panel.eventosMouse(oyente);
        ventana.addEventosMouse(oyente);
        System.out.println("tamaño: " +panel.getSize());
        ventana.add(panel);
        ventana.setName("MiniCAD");
        ventana.setSize(1000, 800);
        ventana.setLocation(100, 100);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

}
