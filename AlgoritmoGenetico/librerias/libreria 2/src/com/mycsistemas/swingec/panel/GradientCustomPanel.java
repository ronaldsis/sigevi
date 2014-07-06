/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycsistemas.swingec.panel;

/**
 *
 * @author Edisoncor
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GradientCustomPanel extends JPanel {

    
    public static final int LINEAR_HORIZONTAL= 1;
    public static final int LINEAR_HORIZONTAL_CENTRAL = 2;
    public static final int LINEAR_VERTICAL= 3;
    public static final int LINEAR_VERTICAL_CENTRAL = 4;
    public static final int LINEAR_TRANSVERSAL_IZQUIERDA = 5;
    public static final int LINEAR_TRANSVERSAL_IZQUIERDA_CENTRAL = 6;
    public static final int LINEAR_TRANSVERSAL_DERECHA = 7;
    public static final int LINEAR_TRANSVERSAL_DERECHA_CENTRAL = 8;

    private int tipo;
    protected BufferedImage gradientImage;
    protected Color gradientStart = new Color(204, 249, 124);
    protected Color gradientEnd = new Color(174, 222, 94);

    private Gradiente gradiente = new Gradiente();

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
        repaint();
    }

    public Color getGradientEnd() {
        return gradientEnd;
    }

    public void setGradientEnd(Color gradientEnd) {
        this.gradientEnd = gradientEnd;
    }

    public Color getGradientStart() {
        return gradientStart;
    }

    public void setGradientStart(Color gradientStart) {
        this.gradientStart = gradientStart;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();
        if (gradiente!=null)
            gradiente.setComponente(this);
            g2.setPaint(gradiente.getGradiente(tipo));
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
    }






    public  class Gradiente {

        private int x1, x2, y1, y2;
        private Component componente;


        public Paint getGradiente(int tipo){
            switch (tipo){
            case LINEAR_HORIZONTAL:
                x1=0;
                y1=0;
                x2=componente.getWidth();
                y2=0;
                return new GradientPaint(x1,y1,gradientStart, x2, y2,gradientEnd);
            case LINEAR_HORIZONTAL_CENTRAL:
                x1=0;
                y1=0;
                x2=componente.getWidth();
                y2=0;
                return new LinearGradientPaint((float)x1,(float)y1, (float)x2, (float)y2,
                        new float[]{0.0f,0.5f,1.0f},
                        new Color[]{gradientStart,gradientEnd, gradientStart});
            case LINEAR_TRANSVERSAL_IZQUIERDA:
                x1=0;
                y1=0;
                x2=componente.getWidth();
                y2=componente.getHeight();
                return new GradientPaint(x1,y1,gradientStart, x2, y2,gradientEnd);
            case LINEAR_TRANSVERSAL_IZQUIERDA_CENTRAL:
                x1=0;
                y1=0;
                x2=componente.getWidth();
                y2=componente.getHeight();
                return new LinearGradientPaint((float)x1,(float)y1, (float)x2, (float)y2,
                        new float[]{0.0f,0.40f,0.60f,1.0f},
                        new Color[]{gradientStart,gradientEnd, gradientEnd, gradientStart});
            case LINEAR_TRANSVERSAL_DERECHA:
                x1=componente.getWidth();
                y1=0;
                x2=0;
                y2=componente.getHeight();
                return new GradientPaint(x1,y1,gradientStart, x2, y2,gradientEnd);
            case LINEAR_TRANSVERSAL_DERECHA_CENTRAL:
                x1=componente.getWidth();
                y1=0;
                x2=0;
                y2=componente.getHeight();
                return new LinearGradientPaint((float)x1,(float)y1, (float)x2, (float)y2,
                        new float[]{0.0f,0.45f,0.5f,1.0f},
                        new Color[]{gradientStart,gradientEnd, gradientEnd, gradientStart});
            case LINEAR_VERTICAL:
                x1=0;
                y1=0;
                x2=0;
                y2=componente.getHeight();
                return new GradientPaint(x1,y1,gradientStart, x2, y2,gradientEnd);
            case LINEAR_VERTICAL_CENTRAL:
                x1=0;
                y1=0;
                x2=0;
                y2=componente.getHeight();
                return new LinearGradientPaint((float)x1,(float)y1, (float)x2, (float)y2,
                        new float[]{0.0f,0.40f,0.60f,1.0f},
                        new Color[]{gradientStart,gradientEnd, gradientEnd, gradientStart});
            default:
                return new GradientPaint(0,0,gradientStart, x2, y2,gradientStart);
            }

        }



        public Component getComponente() {
            return componente;
        }

        public void setComponente(Component componente) {
            this.componente = componente;
            x1=0;
            y1=0;
            x2=componente.getWidth();
            y2=componente.getHeight();
        }




}
}