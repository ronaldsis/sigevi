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
import java.awt.RenderingHints;

/**
 *
 * @author Edisoncor
 */
public class TranslucidoPanel extends RoundPanel{

    private float alfa=.7f;

    public TranslucidoPanel(){
    }

    public float getAlfa() {
        return alfa;
    }

    public void setAlfa(float alfa) {
        this.alfa = alfa;
        repaint();
    }
    

    @Override
    protected void paintComponent(Graphics g) {
          Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        if((alfa>1)|(alfa<0))
            alfa=1;
        AlphaComposite newComposite =
	    AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alfa);
        g2.setComposite(newComposite);
//        g2.dispose();
        super.paintComponent(g);
    }


    
}
