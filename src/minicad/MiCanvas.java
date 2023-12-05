/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minicad;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Mario Pineda
 */
public class MiCanvas extends Canvas {

    private ArrayList<Polygon> figuras;
    
    public MiCanvas(){
        this.setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        for (Polygon poligono : figuras) {
            g.setColor(new Color(
                    (int) (Math.random() * 256),
                    (int) (Math.random() * 256),
                    (int) (Math.random() * 256)));
            g.fillPolygon(poligono);
        }
    }

    public void setPoligonos(ArrayList<Polygon> figuras) {
        this.figuras = figuras;
    }
}
