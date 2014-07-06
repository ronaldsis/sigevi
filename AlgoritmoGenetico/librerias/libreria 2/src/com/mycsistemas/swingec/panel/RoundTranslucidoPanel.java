/*
 * JPanelTranslucido.java
 * 
 * Created on 23/10/2007, 11:36:05 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycsistemas.swingec.panel;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Edisoncor
 */
public class RoundTranslucidoPanel extends RoundPanel{

    private float tran= 0.5f;
    private float oldTran=0.5f;
    private MouseListener ml;
    private boolean efecto=true;
    
    public RoundTranslucidoPanel(){
        ml = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                aclarar();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                recuperar(e.getPoint());
            }
        };
        addMouseListener(ml);
    }
    
    public void recuperar(Point p3){
        if (isEfecto()){
            if((p3.getX()<0)|(p3.getY()<0) | 
                    (p3.getX()>=getWidth())|(p3.getY()>=getHeight()))
                tran=oldTran;
            repaint();
        }
    }
    
    public void aclarar(){
        if(isEfecto()){
            tran=1F;
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        AlphaComposite newComposite = 
	    AlphaComposite.getInstance(AlphaComposite.SRC_OVER,getTran());
        g2.setComposite(newComposite);
//        g2.dispose();
        super.paintComponent(g);
    }

    public float getTran() {
        return tran;
    }

    public void setTran(float tran) {
        this.tran = tran;
        this.oldTran =tran;
    }

    public boolean isEfecto() {
        return efecto;
    }

    public void setEfecto(boolean efecto) {
        this.efecto = efecto;
    }
    
}
