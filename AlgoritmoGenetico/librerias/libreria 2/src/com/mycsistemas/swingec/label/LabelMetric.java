/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycsistemas.swingec.label;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;

/**
 *
 * @author Edisoncor
 */
public class LabelMetric extends JLabel{
    
    private float shadowOffsetX;
    private float shadowOffsetY;
    private Color shadowColor = Color.BLACK;
    private Color foreground = Color.WHITE;
    private Font font = new Font("Arial", Font.BOLD, 16);
    private int shadowDirection = 60;
    private int shadowDistance = 4;
    
    public LabelMetric(){
        computeShadow();
        setFont(font);
        setForeground(foreground);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        Insets insets = getInsets();
        
        int width = getWidth() - insets.left - insets.right;
        int height = getHeight() - insets.top - insets.bottom;
        
        
       
        
        FontMetrics fm = getFontMetrics(getFont());
        TextLayout layout = new TextLayout(getText().length()<=0? " ":getText(),
                getFont(),
                g2.getFontRenderContext());
        Rectangle2D bounds = layout.getBounds();
        
        int x = (int) (getWidth() - insets.left - insets.right -
                bounds.getWidth()) / 2;
        //x -= 2;
        int y = (getHeight() - insets.top - insets.bottom -
                 fm.getMaxAscent() - fm.getMaxDescent()) / 2;
        y += fm.getAscent() - 1;
        
        
        g2.setColor(shadowColor);
        layout.draw(g2,
                x + (int) Math.ceil(shadowOffsetX),
                y + (int) Math.ceil(shadowOffsetY));
        g2.setColor(getForeground());
        layout.draw(g2, x, y);
    }
    
    private void computeShadow() {
        double rads = Math.toRadians(shadowDirection);
        shadowOffsetX = (float) Math.cos(rads) * shadowDistance;
        shadowOffsetY = (float) Math.sin(rads) * shadowDistance;
    }

    public Color getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
        repaint();
    }

    public int getShadowDirection() {
        return shadowDirection;
    }

    public void setShadowDirection(int shadowDirection) {
        this.shadowDirection = shadowDirection;
        computeShadow();
        repaint();
    }

    public int getShadowDistance() {
        return shadowDistance;
    }

    public void setShadowDistance(int shadowDistance) {
        this.shadowDistance = shadowDistance;
        computeShadow();
        repaint();
    }

}
