/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycsistemas.swingec.button;

import com.mycsistemas.swingec.graphicsUtilities.ColorTintFilter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author Edison
 */
public class CircleButton extends JButton{

    private Color color=getBackground();
    private Image buttonHighlight;
    private BufferedImage bg, center, bgInv, centerInv;
    private Float profundidad=.5f;


    public CircleButton(Icon icon) {
        super(icon);
    }

    public CircleButton() {
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        buttonHighlight = loadImage("/resources/header-halo.png");
        bg = (BufferedImage) loadImage("/resources/shinybutton.png");
        center = (BufferedImage) loadImage("/resources/shinybuttoncenter.png");
        bgInv = (BufferedImage) loadImage("/resources/shinybuttoninv.png");
        centerInv = (BufferedImage) loadImage("/resources/shinybuttoncenterinv.png");
        ColorTintFilter tint = new ColorTintFilter(Color.GREEN, 0.7f);
        center=tint.filter(center, center);
        centerInv=tint.filter(centerInv, centerInv);
    }

    private static Image loadImage(String fileName) {
        try {
            return ImageIO.read(CircleButton.class.getResource(fileName));
        } catch (IOException ex) {
            return null;
        }
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        center = (BufferedImage) loadImage("/resources/shinybuttoncenter.png");
        ColorTintFilter tint = new ColorTintFilter(color, profundidad);
        center=tint.filter(center, center);
        centerInv = (BufferedImage) loadImage("/resources/shinybuttoncenterinv.png");
        centerInv=tint.filter(centerInv, centerInv);
        repaint();
    }

    public Float getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Float profundidad) {
        this.profundidad = profundidad;
        center = (BufferedImage) loadImage("/resources/shinybuttoncenter.png");
        ColorTintFilter tint = new ColorTintFilter(color, profundidad);
        center=tint.filter(center, center);
        centerInv = (BufferedImage) loadImage("/resources/shinybuttoncenterinv.png");
        centerInv=tint.filter(centerInv, centerInv);
        repaint();
    }

    @Override
    public void setText(String text) {
        super.setText("");
    }


    @Override
    protected void paintComponent(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        Paint oldPaint = g2.getPaint();

        ButtonModel modelo = getModel();

        g2.drawImage(bg,
                    0,0,
                    getWidth(), getHeight(), null);
        g2.drawImage(center,
                    0,0,
                    getWidth(), getHeight(), null);
        if(modelo.isRollover()  ){
            g2.drawImage(buttonHighlight,
                    0,0,
                    getWidth(), getHeight(), null);
        }
        if(modelo.isPressed()){
            g2.drawImage(bgInv,
                    0,0,
                    getWidth(), getHeight(), null);
            g2.drawImage(centerInv,
                    0,0,
                    getWidth(), getHeight(), null);
        }
        

        g2.setPaint(oldPaint);
        super.paintComponent(g);

    }

    




}
