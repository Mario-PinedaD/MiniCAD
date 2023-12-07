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

  /*
    Debo considerar el hecho de que no se introduzcan "puntos" sin más,
    es decir, que la cantidad de puntos sea
    mayor a 1 al menos, para tener algo que dibujar
   */
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
        int[][] matrizEscalar = escalar(generarMatriz(getPoligonoSeleccionado()));

//        System.out.println("Matriz original: ");
//        mostrarMatriz(generarMatriz(getPoligonoSeleccionado()));
//        System.out.println("Matriz de Escala: ");
//        mostrarMatriz(convertirInt(generarMatrizEscalado(vista.getEscalaX(), vista.getEscalaY())));
//        System.out.println("Matriz transformada: ");
//        mostrarMatriz(matrizEscalar);
//        System.out.println("Valores del nuevo polígono: ");
//        mostrarPoligono(crearPolygonos(matrizEscalar));
        formas.set(getPoligonoPosicion(), crearPolygonos(matrizEscalar));
        panel.setFiguras(formas);
        colores.add(crearColor());
        panel.setColores(colores);
        puntosPoligonos.clear();
//        generarNombres();
//        actualizarLista();
        nombres.clear();
        panel.repaint();
        break;

      //*******************
      case "rotar":
        int[][] matrizRotacion = rotacion(generarMatriz(getPoligonoSeleccionado()));

        System.out.println("Matriz original: ");
        mostrarMatriz(generarMatriz(getPoligonoSeleccionado()));
        System.out.println("Matriz de Rotacion: ");
        mostrarMatriz(convertirInt(generarMatrizRotacion(vista.getRotar()))); //JAJAJA no muestra nada pq no hay valores qmostrar, pipipi
//        System.out.println("Matriz transformada: ");
//        mostrarMatriz(matrizRotacion);
//        System.out.println("Valores del nuevo polígono: ");
//        mostrarPoligono(crearPolygonos(matrizRotacion));

        formas.set(getPoligonoPosicion(), crearPolygonos(matrizRotacion));
        panel.setFiguras(formas);
        colores.add(crearColor());
        panel.setColores(colores);
        puntosPoligonos.clear();
//        generarNombres();
//        actualizarLista();
        nombres.clear();
        panel.repaint();
        break;
      //********************************
      case "botonx":
        //Creamos una matriz con los nuevos valores de traslación
        int[][] matrizX = aplicarTraslacion(generarMatriz(getPoligonoSeleccionado()), vista.getMovX(), 0);

//        //Esto es para mostrar las posiciones originales, la de traslacion
//        //La nueva matriz y los valores del polígono.
//        System.out.println("Matriz original: ");
//        mostrarMatriz(generarMatriz(getPoligonoSeleccionado()));
//        System.out.println("Matriz de Traslacion: ");
//        mostrarMatriz(generarMatrizTraslacion(vista.getMovX(), 0));
//        System.out.println("Matriz transformada: ");
//        mostrarMatriz(matrizX);
//        System.out.println("Valores del nuevo polígono: ");
//        mostrarPoligono(crearPolygonos(matrizX));
//
        //Reemplazamos el polígono previo por el nuevo ya transformado.
        formas.set(getPoligonoPosicion(), crearPolygonos(matrizX));
        panel.setFiguras(formas);
        colores.add(crearColor());
        panel.setColores(colores);
        puntosPoligonos.clear();
//        generarNombres();
//        actualizarLista();
        nombres.clear();
        panel.repaint();

        break;
      //********************************
      case "botony":
        int[][] matrizY = aplicarTraslacion(generarMatriz(getPoligonoSeleccionado()), 0, -1 * vista.getMovY());

        formas.set(getPoligonoPosicion(), crearPolygonos(matrizY));
        panel.setFiguras(formas);
        colores.add(crearColor());
        panel.setColores(colores);
        puntosPoligonos.clear();
//        generarNombres();
//        actualizarLista();
        nombres.clear();
        panel.repaint();
        break;

      //********************************
      case "dibujar":
        if (puntosPoligonos.size() > 1) {
          System.out.println("Seleccionó libre");
          System.out.println("Tamaño: " + formas.size());
          formas.add(OyenteEventos.this.crearPolygonos(puntosPoligonos));
          panel.setFiguras(formas);
          colores.add(crearColor());
          panel.setColores(colores);
          puntosPoligonos.clear();
          generarNombres();
          actualizarLista();
          nombres.clear();
          panel.repaint();
        } else {
          puntosPoligonos.clear();
        }
        break;
      //----------------------------------------
      case "limpiar":
        System.out.println("Limpiar");
        formas.clear();
        colores.clear();
        actualizarLista();
        panel.removeAll();
        panel.repaint();
        vista.repaint();
        break;
    }

  }

  public void mostrarPoligono(Polygon poligono) {
    int[] valX = poligono.xpoints;
    int[] valY = poligono.ypoints;
    System.out.println("Valores en X: ");
    for (int i = 0; i < valX.length; i++) {
      System.out.print(valX[i] + " ");
    }
    //En caso de que no pinte, borrar \n  no se pq pero no funciona as
    System.out.println("\nValores en Y: ");
    for (int i = 0; i < valY.length; i++) {
      System.out.print(valY[i] + " ");
    }
  }

  public Polygon crearPolygonos(int[][] matriz) {
    int[] arrX = new int[matriz[0].length];
    int[] arrY = new int[matriz[0].length];

    for (int i = 0; i < matriz[0].length; i++) {
//      tmp.addPoint((int) puntos.get(i).getX(), (int) puntos.get(i).getY());
      //Valores agregados correctamente considera que es [fila] [columna]
      arrX[i] = (int) matriz[0][i];
      arrY[i] = (int) matriz[1][i];
    }

    Polygon poligono = new Polygon(arrX, arrY, arrY.length);
    return poligono;
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
    vista.getLista().repaint();
  }

  //Se obtiene el polígono con el que se va a chambear
  public Polygon getPoligonoSeleccionado() {
    int pos = vista.getLista().getSelectedIndex();
    return formas.get(pos);
  }

  public int getPoligonoPosicion() {
    int pos = vista.getLista().getSelectedIndex();
    return pos;
  }

  //Se crea la matriz con la q se va a chambear.
  //Funciona matriz [filas][columnas]
  public int[][] generarMatriz(Polygon poligono) {
    int[][] matrizDelPoligono = new int[3][poligono.npoints];
    System.out.println("filas: " + matrizDelPoligono.length);
    System.out.println("Columnas: " + matrizDelPoligono[0].length);
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

  public int[][] rotacion(int[][] matriz) {
    int xCentro = 0;
    int yCentro = 0;
    int totalPuntos = matriz[0].length;
    for (int i = 0; i < totalPuntos; i++) {
        xCentro += matriz[0][i];
        yCentro += matriz[1][i];
    }
    xCentro /= totalPuntos;
    yCentro /= totalPuntos;

    return aplicarTraslacion(
      convertirInt(
        aplicarRotacion(
          aplicarTraslacion(matriz, -xCentro, -yCentro), vista.getRotar())), xCentro, yCentro);
  }

  //Método para aplicar la rotación de la figura
  public double[][] aplicarRotacion(int[][] matriz, int angulo) {
    double[][] tmpRotada = new double[matriz.length][matriz[0].length]; //Matriz temporal para guardar los valores

    tmpRotada = productoMatriz(generarMatrizRotacion(angulo), convertirDouble(matriz));
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

  public int[][] escalar(int[][] matriz) {
    //Puntos en X y Y de base para llevarlo al origen
    int xBase = matriz[0][0];
    int yBase = matriz[1][0];
    return aplicarTraslacion(
      convertirInt(
        aplicarEscalado(
          aplicarTraslacion(matriz, -xBase, -yBase), vista.getEscalaX(), vista.getEscalaY())), xBase, yBase);
  }

  //Método para aplicar el escalado
  public double[][] aplicarEscalado(int[][] matriz, double esX, double esY) {
    double[][] tmp = new double[matriz.length][matriz[0].length];
    //El orden del escalado sería
    //Devolver - Escalar - origen
    tmp = productoMatriz(generarMatrizEscalado(esX, esY), convertirDouble(matriz));
    return tmp;
  }

  /*Considerando que:
  | s 0 0
  | 0 s 0
  | 0 0 1
   */
  public double[][] generarMatrizEscalado(double escalaX, double escalaY) {
    double[][] escalado = new double[3][3];
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

    tmpTrasladada = convertirInt(productoMatriz(convertirDouble(generarMatrizTraslacion(valorX, valorY)), convertirDouble(matriz)));

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
  public double[][] productoMatriz(double[][] matrizA, double[][] matrizB) {
    //Filas
    //Matriz A
    int filaA = matrizA.length;
    //Matriz B
    int filaB = matrizB.length;
    //Columnas
    //Matriz A
    int columnaA = matrizA[0].length;
    //Matriz B
    int columnaB = matrizB[0].length;

    double[][] tmp = new double[filaA][columnaB];

    //Para todas las filas de A
    for (int i = 0; i < filaA; i++) {
      //Semultiplican por todas las columnas de B
      for (int j = 0; j < columnaB; j++) {
        //Obteniendo
        for (int k = 0; k < columnaA; k++) {
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

  //Este unicamente era por si quería mostrar las matrices con las q se trabajan
  public void mostrarMatriz(int[][] matrij) {
    for (int i = 0; i < matrij.length; i++) {
      for (int k = 0; k < matrij[0].length; k++) {
        System.out.print(matrij[i][k] + " ");
      }
      System.out.println("");
    }
  }
}
