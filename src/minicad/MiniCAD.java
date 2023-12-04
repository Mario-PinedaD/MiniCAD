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
        Ventana f = new Ventana();
        PanelDibujable panel = new PanelDibujable();
        OyenteEventos oyente = new OyenteEventos(f, panel);
        f.addEventos(oyente);
        f.addEventosMouse(oyente);
        f.setName("MiniCAD");
        f.setSize(800, 800);
        f.setLocation(100, 100);
        f.setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
