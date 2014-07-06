/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycsistemas.swingec.button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author Edison
 */
public class AeroRoundtButton extends JButton{

    private Color color=getBackground();
    private Image buttonHighlight;
    private int angle=20;


    public AeroRoundtButton(Icon icon) {
        super(icon);
    }

    public AeroRoundtButton() {
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        buttonHighlight = loadImage("/resources/header-halo.png");
    }

    private static Image loadImage(String fileName) {
        try {
            return ImageIO.read(AeroRoundtButton.class.getResource(fileName));
        } catch (IOException ex) {
            return null;
        }
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        Paint oldPaint = g2.getPaint();

        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(
                0,0,getWidth(),getHeight(),angle,angle);
        g2.clip(r2d);

        ButtonModel modelo = getModel();

        Rectangle2D rect = new Rectangle2D.Double(0, 0, getWidth(), getHeight() / 2.0);
        if(modelo.isArmed()|modelo.isPressed())
            g2.setPaint(color.darker());
        else
            g2.setPaint(color);
       
        g2.fill(rect);

        rect = new Rectangle2D.Double(0, (getHeight() / 2.0) - 1.0, getWidth(), getHeight());
        if(modelo.isArmed()|modelo.isPressed())
            g2.setPaint(color.darker().darker());
        else
            g2.setPaint(color.darker());
        
        g2.fill(rect);

        if(modelo.isRollover()  ){
            g2.drawRect(0, 0, getWidth(), getHeight());
            g2.drawImage(buttonHighlight,
                    0,0,
                    getWidth(), getHeight(), null);
        }


        g2.setPaint(oldPaint);
        super.paintComponent(g);

    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
        repaint();
    }


}
