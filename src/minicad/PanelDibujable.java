/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package minicad;

import java.awt.*;
import java.util.ArrayList;
import java.awt.event.MouseListener;

/**
 *
 * @author Mario Pineda
 */
public class PanelDibujable extends javax.swing.JPanel {

  private ArrayList<Polygon> figuras;

  /**
   * Creates new form PanelDibujable
   */
  public PanelDibujable() {
    this.figuras = new ArrayList<>();
    initComponents();
    this.setBackground(Color.WHITE);
    //crearIdentidad();
  }

  public void setFigura(MouseListener m) {
    this.addMouseListener(m);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (int i = 0; i < figuras.size(); i++) {
      g.setColor(new Color(
        (int) (Math.random() * 256),
        (int) (Math.random() * 256),
        (int) (Math.random() * 256)));
      g.fillPolygon(figuras.get(figuras.size() - 1));
    }
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
  }
  
  public void dibujarPuntos(Graphics g){
    Graphics2D g2= (Graphics2D) g;
  }
  
  
  public void setFiguras(ArrayList<Polygon> formas) {
    this.figuras = formas;
  }
  public ArrayList<Polygon> getFiguras(){
    return figuras;
  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
