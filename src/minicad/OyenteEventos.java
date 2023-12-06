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
  private ArrayList<Color> colores = new ArrayList<>();
  private ArrayList<String> nombres = new ArrayList<>();

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
        //Se aplica el escalado a la matriz de los puntos del poligono seleccionado
        aplicarEscalado(
          generarMatriz(
            getPoligonoSeleccionado()));
        break;
      case "rotar":
        System.out.println("Presionó rotar " + vista.getRotar());
        break;
      //**********
      case "botonx":
        int[][] matrij = aplicarTraslacion(generarMatriz(getPoligonoSeleccionado()), vista.getMovX(), 0);
        
        break;
      //************************
      case "botony":
        System.out.println("Presionó en Y: " + vista.getMovY());
        aplicarTraslacion(generarMatriz(getPoligonoSeleccionado()), 0, vista.getMovY());
        break;

      //********************************
      case "dibujar":
        System.out.println("Seleccionó libre");
        System.out.println("Tamaño: " + formas.size());
        formas.add(crearPolygonos(puntosPoligonos));
        panel.setFiguras(formas);
        colores.add(crearColor());
        panel.setColores(colores);
        puntosPoligonos.clear();
        generarNombres();
        actualizarLista();
        nombres.clear();
        panel.repaint();
        break;
      //----------------------------------------
      case "limpiar":
        System.out.println("Limpiar");
        formas.clear();
        colores.clear();
        vista.getLista().removeAll();
        actualizarLista();
        panel.removeAll();
        panel.repaint();
        vista.repaint();
        break;
    }

  }

  //Funcion para crear un polígono de un conjunto de puntos que se introdujeron con clics.
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

  //Creación de un color random para asignarlo a la figura correspondiente
  public Color crearColor() {
    return new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
  }

  public void generarNombres() {
    for (int i = 0; i < formas.size(); i++) {
      String nombre = "Poligono " + (i + 1);
      nombres.add(nombre);
    }
  }

  public void actualizarLista() {
    vista.getLista().removeAll();
    String[] tmpNombre = new String[nombres.size()];
    for (int i = 0; i < nombres.size(); i++) {
      tmpNombre[i] = nombres.get(i);
    }
    vista.setLista(tmpNombre);
  }

  //Se obtiene el polígono con el que se va a chambear
  public Polygon getPoligonoSeleccionado() {
    int pos = vista.getLista().getSelectedIndex();
    return formas.get(pos);
  }

  //Se crea la matriz con la q se va a chambear.
  public int[][] generarMatriz(Polygon poligono) {
    int[][] matrizDelPoligono = new int[3][poligono.npoints];
    int[] pX = poligono.xpoints;
    int[] pY = poligono.ypoints;
    int total = poligono.npoints;
    //Añadición de la 1ra y segunda fila, valores de X y y;
    for (int i = 0; i < total; i++) {
      matrizDelPoligono[0][i] = pX[i];
      matrizDelPoligono[1][i] = pY[i];
    }
    for (int i = 0; i < total; i++) {
      matrizDelPoligono[2][i] = 1;
    }
    return matrizDelPoligono;
  }

  //Método para aplicar la rotación de la figura
  public double[][] aplicarRotacion(int[][] matriz, int angulo) {
    double[][] tmpRotada = new double[matriz.length][matriz[0].length]; //Matriz temporal para guardar los valores

    aplicarTraslacion(matriz, -matriz[0][0], -matriz[0][1]);//Se lleva al origen
    return tmpRotada; //Devolvemos la matriz
  }

  /*Considerando que:
  | cos -sen 0
  | sen  cos 0
  |  1    1  1
   */
  public double[][] generarMatrizRotacion(int angulo) {
    double[][] rotacion = new double[3][3];
    rotacion[0][0] = Math.cos(Math.toRadians(angulo));
    rotacion[0][1] = -1 * Math.sin((Math.toRadians(angulo)));
    rotacion[0][2] = 0;
    rotacion[1][0] = Math.sin((Math.toRadians(angulo)));
    rotacion[1][1] = Math.cos(Math.toRadians(angulo));
    rotacion[1][2] = 0;
    rotacion[2][0] = 0;
    rotacion[2][1] = 0;
    rotacion[2][2] = 1;
    return rotacion;
  }

  //Método para aplicar el escalado
  public void aplicarEscalado(int[][] matriz) {

  }

  /*Considerando que:
  | s 0 0
  | 0 s 0
  | 0 0 1
   */
  public int[][] generarMatrizEscalado(int escalaX, int escalaY) {
    int[][] escalado = new int[3][3];
    escalado[0][0] = escalaX;
    escalado[0][1] = 0;
    escalado[0][2] = 0;
    escalado[1][0] = 0;
    escalado[1][1] = escalaY;
    escalado[1][2] = 0;
    escalado[2][0] = 0;
    escalado[2][1] = 0;
    escalado[2][2] = 1;
    return escalado;
  }

  //Método para aplicar la transformación de la matriz
  public int[][] aplicarTraslacion(int[][] matriz, int valorX, int valorY) {

    int[][] tmpTrasladada = new int[matriz.length][matriz[0].length];
    
    

    tmpTrasladada = convertirInt(productoMatriz(matriz, convertirDouble(generarMatrizTraslacion(valorX, valorY))));

    return tmpTrasladada;
  }

  /*Considerando que:
  | 1 0 x
  | 0 1 y
  | 0 0 1
   */
  public int[][] generarMatrizTraslacion(int trasX, int trasY) {
    int[][] tmp = new int[3][3];
    tmp[0][0] = 1;
    tmp[0][1] = 0;
    tmp[0][2] = trasX;
    tmp[1][0] = 0;
    tmp[1][1] = 1;
    tmp[1][2] = trasY;
    tmp[2][0] = 0;
    tmp[2][1] = 0;
    tmp[2][2] = 1;

    return tmp;
  }

  //Considerando que, matriz A será la correspondiente a la operacion 
  //y la B seran los puntos con los q se trabajarán
  public double[][] productoMatriz(int[][] matrizA, double[][] matrizB) {
    //Filas
    //Matriz A
    int fA = matrizA.length;
    //Matriz B
    int fB = matrizB.length;
    //Columnas
    //Matriz A
    int cA = matrizA[0].length;
    //Matriz B
    int cB = matrizB[0].length;

    double[][] tmp = new double[3][cB];

    for (int i = 0; i < fA; i++) {
      for (int j = 0; j < cB; j++) {
        for (int k = 0; k < cA; k++) {
          // aquí se multiplica la matriz
          tmp[i][j] += matrizA[i][k] * matrizB[k][j];
        }
      }
    }

    return tmp;
  }

  public double[][] convertirDouble(int[][] matriz) {
    double[][] tmp = new double[matriz.length][matriz[0].length];
    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz[0].length; j++) {
        tmp[i][j] = (double) matriz[i][j];
      }
    }
    return tmp;
  }

  public int[][] convertirInt(double[][] matriz) {
    int[][] tmp = new int[matriz.length][matriz[0].length];
    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz[0].length; j++) {
        tmp[i][j] = (int) matriz[i][j];
      }
    }
    return tmp;
  }
}
