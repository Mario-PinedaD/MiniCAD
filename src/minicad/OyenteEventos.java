/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minicad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Mario Pineda
 */
public class OyenteEventos extends MouseAdapter implements ActionListener {

  private Ventana vista; //Ventana general
  private PanelDibujable panel; //Panel donde se va a Dibujar y hacer todo
  private ArrayList<Polygon> formas = new ArrayList<>(); //Arraylist de puntos pa guardar
  private ArrayList<Integer> puntosX = new ArrayList<>();
  private ArrayList<Integer> puntosY = new ArrayList<>();
  private int cantPuntos = 0; //cant de puntos de la figura

  public OyenteEventos(Ventana vista, PanelDibujable panel) {
    this.vista = vista;
    this.panel = panel;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    int pLlevados = 0;
    int[] puntos;
    String figura = vista.getSeleccionFigura();
    switch (figura) {
      case "Linea":
        cantPuntos = 2;
        puntos = new int[cantPuntos];
        System.out.println("Se eligió: " + figura);
        do {
          System.out.println("Punto ");
          pLlevados++;
        } while (pLlevados != cantPuntos);
        break;

      case "Triangulo":
        cantPuntos = 3;
        puntos = new int[cantPuntos];
        System.out.println("Se eligió " + figura);
        break;

      case "Cuadrado":
        cantPuntos = 4;
        puntos = new int[cantPuntos];
        System.out.println("");
        break;

      case "Pentagono":
        cantPuntos = 5;
        puntos = new int[cantPuntos];
        break;
      //=================
      case "Libre": //Caso fuera de la linea
        puntosX.add(e.getX());
        puntosY.add(e.getY());
        break;
    }
    //Esto nomas fue prueba
//    System.out.println("Posicion en x " + e.getComponent().getLocation().getX());
//    System.out.println("Posicion en y " + e.getComponent().getLocation().getY());
//    System.out.println("Mouse Presionao'");
//    System.out.println("Posicion en el panel X: " + e.getX());
//    System.out.println("Posicion en el panel Y: " + e.getY());
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JButton boton = (JButton) e.getSource();
    boton.getName();
    switch (boton.getName()) {
      case "escalar":
        System.out.println("Presionó escalar x: " + vista.getEscalaX());
        System.out.println("Presionó escalar y: " + vista.getEscalaY());
        break;
      case "rotar":
        System.out.println("Presionó rotar " + vista.getRotar());
        break;
      case "botonx":
        System.out.println("Presionó En X: " + vista.getMovX());
        break;
      case "botony":
        System.out.println("Presionó en Y: " + vista.getMovY());
        break;
//      case "seleccion":
//        System.out.println("Seleccion: " + vista.getSeleccionFigura());
//        break;
      case "dibujar":
        if (vista.getSeleccionFigura().equals("Libre")) {
          System.out.println("Seleccionó libre");
          System.out.println("Tamaño: " + formas.size());
          panel.setFiguras(crearPolygono(puntosX, puntosY));
        }
        break;
      case "limpiar":
        System.out.println("Limpiar");
        break;
    }
    panel.repaint();
    vista.repaint();
  }

  public ArrayList<Polygon> crearPolygono(ArrayList<Integer> valX, ArrayList<Integer> valY) {
    ArrayList<Polygon> temporal = new ArrayList<>();
    for (int i = 0; i < valX.size(); i++) {
      Polygon tmp = new Polygon();
      tmp.addPoint(valX.get(i), valY.get(i));
      temporal.add(tmp);
    }
    return temporal;
  }
}
