/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minicad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Mario Pineda
 */
public class OyenteEventos extends MouseAdapter implements ActionListener {

  private Ventana vista; //Ventana general
  private PanelDibujable panel; //Panel donde se va a Dibujar y hacer todo
  private ArrayList<Polygon> formas = new ArrayList<>(); //Arraylist de puntos pa guardar
  private ArrayList<Point> puntosPoligonos = new ArrayList<>();
  private int cantPuntos = 0; //cant de puntos de la figura

  public OyenteEventos(Ventana vista, PanelDibujable panel) {
    this.vista = vista;
    this.panel = panel;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    Point punto = new Point(e.getX(), e.getY());
    puntosPoligonos.add(punto);
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
        System.out.println("Seleccionó libre");
        System.out.println("Tamaño: " + formas.size());
        formas.add(crearPolygonos(puntosPoligonos));
        panel.setFiguras(formas);
        puntosPoligonos.clear();
        panel.repaint();
        break;
      case "limpiar":
        System.out.println("Limpiar");
        break;
    }
    
  }
  
    public Polygon crearPolygonos(ArrayList<Point> puntos) {
    int[] arrX = new int[puntos.size()];
    int[] arrY = new int[puntos.size()];
    for (int i = 0; i < puntos.size(); i++) {
      System.out.println("Arreglo Puntos ||| x: " + (int) puntos.get(i).getX() + " | Y: " + (int) puntos.get(i).getY());//muetra los puntos
//      tmp.addPoint((int) puntos.get(i).getX(), (int) puntos.get(i).getY());
      arrX[i] = (int) puntos.get(i).getX();
      arrY[i] = (int) puntos.get(i).getY();
    }
    Polygon tmp = new Polygon(arrX, arrY, puntos.size()); //Creo objeto poligono;
    return tmp;
  }
}
