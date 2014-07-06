/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycsistemas.swingec.textField;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Edison
 */
public class ImageTextField extends JTextField{


    private Integer angle=20;
    private Image image=null;
    private Icon icon;
    private float alfa=.7f;

    public ImageTextField() {
        setOpaque(false);
        setBorder(new EmptyBorder(0,5,0,2));
        setPreferredSize(new Dimension(69, 20));
    }

    public float getAlfa() {
        return alfa;
    }

    public void setAlfa(float alfa) {

        if(alfa>1)
            alfa=1;
        if(alfa<0)
            alfa=0;
        this.alfa = alfa;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        Paint oldPaint = g2.getPaint();

        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(
                0,0,getWidth(),getHeight(),angle,angle);
        g2.clip(r2d);

        g2.setPaint(new GradientPaint(0.0f, 0.0f, getBackground(),
                0.0f, getHeight(), getBackground()));
        g2.fillRoundRect(0,0,getWidth(),getHeight(),angle,angle);

        if(getImage()!=null){
            Composite oldComposite = g2.getComposite();
            AlphaComposite newComposite =
                    AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alfa);
            g2.setComposite(newComposite);
            g2.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            g2.setComposite(oldComposite);
        }


        g2.setPaint(new GradientPaint(0.0f, 0.0f, Color.BLACK,
                0.0f, getHeight(), Color.BLACK));
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, angle, angle);

        g2.setPaint(oldPaint);
        super.paintComponent(g);

    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon){
        this.icon=icon;
        setImage(((ImageIcon)icon).getImage());
    }

    public Integer getAngle() {
        return angle;
    }

    public void setAngle(Integer angle) {
        this.angle = angle;
        repaint();
    }


}
