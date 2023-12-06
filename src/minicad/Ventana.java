/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package minicad;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Mario Pineda
 */
public class Ventana extends javax.swing.JFrame {

  /**
   * Creates new form Ventana
   */
  public Ventana() {
    initComponents();
    panelDibujo.setBackground(Color.WHITE);
    opcionFigura.setSelectedIndex(opcionFigura.getItemCount()-1);
    opcionFigura.setEnabled(false);
  }

  public void addEventos(ActionListener e) {
    botonEscalar.addActionListener(e);
    botonEscalar.setName("escalar");
    botonRotar.addActionListener(e);
    botonRotar.setName("rotar");
    botonX.addActionListener(e);
    botonX.setName("botonx");
    botonY.addActionListener(e);
    botonY.setName("botony");
    botonLimpiar.addActionListener(e);
    botonLimpiar.setName("limpiar");
    botonDibujar.addActionListener(e);
    botonDibujar.setName("dibujar");
  }

  public void addEventosLista(ListSelectionEvent l) {
    listaFiguras.addListSelectionListener((ListSelectionListener) l);
    listaFiguras.setName("lista");
  }

  public void addEventosMouse(MouseListener m) {
    panelDibujo.addMouseListener(m);
  }

  public JPanel getPanel() {
    return panelDibujo;
  }

  public void setLista(String[] nombres) {
    for (int i = 0; i < nombres.length; i++) {
      listaFiguras.setListData(nombres);
    }
  }
  public javax.swing.JList<String> getLista(){
    return listaFiguras;
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    panelNorte = new javax.swing.JPanel();
    etiquetaFiguras = new javax.swing.JLabel();
    panelSur = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    entradaMovX = new javax.swing.JTextField();
    botonX = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    entradaMovY = new javax.swing.JTextField();
    botonY = new javax.swing.JButton();
    jSeparator1 = new javax.swing.JSeparator();
    jLabel3 = new javax.swing.JLabel();
    entradaEscalaX = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    entradaEscalaY = new javax.swing.JTextField();
    botonEscalar = new javax.swing.JButton();
    jLabel4 = new javax.swing.JLabel();
    entradaRotar = new javax.swing.JTextField();
    botonRotar = new javax.swing.JButton();
    panelEste = new javax.swing.JPanel();
    opcionFigura = new javax.swing.JComboBox<>();
    jScrollPane1 = new javax.swing.JScrollPane();
    listaFiguras = new javax.swing.JList<>();
    botonLimpiar = new javax.swing.JButton();
    botonDibujar = new javax.swing.JButton();
    panelDibujo = new javax.swing.JPanel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    etiquetaFiguras.setText("MINI CAD");
    panelNorte.add(etiquetaFiguras);

    getContentPane().add(panelNorte, java.awt.BorderLayout.NORTH);

    jLabel1.setText("X:");
    panelSur.add(jLabel1);

    entradaMovX.setColumns(5);
    entradaMovX.setText("0");
    panelSur.add(entradaMovX);

    botonX.setText("Mover X");
    panelSur.add(botonX);

    jLabel2.setText("Y:");
    panelSur.add(jLabel2);

    entradaMovY.setColumns(5);
    entradaMovY.setText("0");
    panelSur.add(entradaMovY);

    botonY.setText("Mover Y");
    panelSur.add(botonY);
    panelSur.add(jSeparator1);

    jLabel3.setText("X:");
    panelSur.add(jLabel3);

    entradaEscalaX.setColumns(5);
    panelSur.add(entradaEscalaX);

    jLabel5.setText("Y:");
    panelSur.add(jLabel5);

    entradaEscalaY.setColumns(5);
    panelSur.add(entradaEscalaY);

    botonEscalar.setText("Escalar");
    panelSur.add(botonEscalar);

    jLabel4.setText("Rotación:");
    panelSur.add(jLabel4);

    entradaRotar.setColumns(5);
    panelSur.add(entradaRotar);

    botonRotar.setText("Rotar");
    panelSur.add(botonRotar);

    getContentPane().add(panelSur, java.awt.BorderLayout.PAGE_END);

    panelEste.setPreferredSize(new java.awt.Dimension(150, 469));

    opcionFigura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Linea", "Triangulo", "Cuadrado", "Pentagono", "Libre" }));

    listaFiguras.setToolTipText("");
    listaFiguras.setName(""); // NOI18N
    jScrollPane1.setViewportView(listaFiguras);

    botonLimpiar.setText("Limpiar Lienzo");

    botonDibujar.setText("Dibujar");
    botonDibujar.setName("dibujar"); // NOI18N

    javax.swing.GroupLayout panelEsteLayout = new javax.swing.GroupLayout(panelEste);
    panelEste.setLayout(panelEsteLayout);
    panelEsteLayout.setHorizontalGroup(
      panelEsteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelEsteLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panelEsteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
          .addComponent(opcionFigura, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(botonLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
          .addComponent(botonDibujar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    panelEsteLayout.setVerticalGroup(
      panelEsteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEsteLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        .addGap(18, 18, 18)
        .addComponent(opcionFigura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(botonDibujar)
        .addGap(12, 12, 12)
        .addComponent(botonLimpiar)
        .addContainerGap())
    );

    getContentPane().add(panelEste, java.awt.BorderLayout.EAST);

    javax.swing.GroupLayout panelDibujoLayout = new javax.swing.GroupLayout(panelDibujo);
    panelDibujo.setLayout(panelDibujoLayout);
    panelDibujoLayout.setHorizontalGroup(
      panelDibujoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 664, Short.MAX_VALUE)
    );
    panelDibujoLayout.setVerticalGroup(
      panelDibujoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 458, Short.MAX_VALUE)
    );

    getContentPane().add(panelDibujo, java.awt.BorderLayout.CENTER);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  public double getEscalaX() {
    if (!entradaEscalaX.getText().isBlank()) {
      //double valor = Integer.parseInt(entradaEscalaX.getText());
      double valor = Double.parseDouble(entradaEscalaX.getText());
      if (valor > 0) {
        return valor;
      } else {
        return 0.0;
      }
    } else {
      return 0.0;
    }
  }

  public double getEscalaY() {
    if (!entradaEscalaY.getText().isBlank()) {
      //double valor = Integer.parseInt(entradaEscalaY.getText());
      double valor = Double.parseDouble(entradaEscalaY.getText());
      if (valor > 0) {
        return valor;
      } else {
        return 0.0;
      }
    } else {
      return 0.0;
    }
  }

  public int getMovX() {
    if (entradaMovX.getText().isBlank()) {
      return 0;
    } else {
      return Integer.parseInt(entradaMovX.getText());
    }
  }

  public int getMovY() {
    if (entradaMovY.getText().isBlank()) {
      return 0;
    } else {
      return Integer.parseInt(entradaMovY.getText());
    }
  }

  public int getRotar() {
    if (entradaRotar.getText().isBlank()) {
      return 0;
    } else {
      return Integer.parseInt(entradaRotar.getText());
    }
  }

  public String getSeleccionFigura() {
    //return opcionFigura.getSelectedItem().toString();
    //return opcionFigura.getActionCommand();
    return opcionFigura.getSelectedItem().toString();
  }

  public void cargarListaFiguras() {

  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton botonDibujar;
  private javax.swing.JButton botonEscalar;
  private javax.swing.JButton botonLimpiar;
  private javax.swing.JButton botonRotar;
  private javax.swing.JButton botonX;
  private javax.swing.JButton botonY;
  private javax.swing.JTextField entradaEscalaX;
  private javax.swing.JTextField entradaEscalaY;
  private javax.swing.JTextField entradaMovX;
  private javax.swing.JTextField entradaMovY;
  private javax.swing.JTextField entradaRotar;
  private javax.swing.JLabel etiquetaFiguras;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JList<String> listaFiguras;
  private javax.swing.JComboBox<String> opcionFigura;
  private javax.swing.JPanel panelDibujo;
  private javax.swing.JPanel panelEste;
  private javax.swing.JPanel panelNorte;
  private javax.swing.JPanel panelSur;
  // End of variables declaration//GEN-END:variables
}
