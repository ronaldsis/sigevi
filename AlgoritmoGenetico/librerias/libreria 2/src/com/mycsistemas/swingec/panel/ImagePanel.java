/*
 * JEImagePanel.java
 *
 * Created on 17 de septiembre de 2007, 08:40 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.mycsistemas.swingec.panel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Edisoncor
 */
public class ImagePanel extends JPanel{
    
    private Image image=null;
    private Icon icon;
    
    /** Creates a new instance of JEImagePanel */
    public ImagePanel() {
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 =(Graphics2D) g;
        if(getImage()!=null)
            g2.drawImage(getImage(), 0, 0, getWidth(), getHeight(), null);
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
}
