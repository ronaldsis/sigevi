/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycsistemas.swingec.panel;

/**
 *
 * @author Edisoncor
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class BicolorPanel extends JPanel {
    protected BufferedImage gradientImage;
    protected Color gradientStart = new Color(204, 249, 124);

    public BicolorPanel() {
        this(new BorderLayout());
    }

    public BicolorPanel(LayoutManager layout) {
        super(layout);
        addComponentListener(new GradientCacheManager());
    }

    @Override
    protected void paintComponent(Graphics g) {
        createImageCache();

        if (gradientImage != null) {
            g.drawImage(gradientImage, 0, 0, getWidth(), getHeight(), null);
        }
    }

    protected void createImageCache() {
        int width = 2;
        int height = getHeight();

        if (width == 0 || height == 0) {
            return;
        }

        if (gradientImage == null ||
            width != gradientImage.getWidth() || 
            height != gradientImage.getHeight()) {

            gradientImage = new BufferedImage(width, height,
                                              BufferedImage.TYPE_INT_RGB);

            Graphics2D g2 = gradientImage.createGraphics();
            g2.setPaint(gradientStart);

            Rectangle2D rect = new Rectangle2D.Double(0, 0, width, height / 2.0);
            g2.fill(rect);

            g2.setPaint(gradientStart.darker());

            rect = new Rectangle2D.Double(0, (height / 2.0) - 1.0, width, height);
            g2.fill(rect);

            g2.dispose();
        }
    }

    



    public Color getGradientStart() {
        return gradientStart;
    }

    public void setGradientStart(Color gradientStart) {
        this.gradientStart = gradientStart;
        gradientImage=null;
        repaint();
    }

    private void disposeImageCache() {
        synchronized (gradientImage) {
            gradientImage.flush();
            gradientImage = null;
        }
    }

    private class GradientCacheManager implements ComponentListener {
        public void componentResized(ComponentEvent e) {
        }

        public void componentMoved(ComponentEvent e) {
        }

        public void componentShown(ComponentEvent e) {
        }

        public void componentHidden(ComponentEvent e) {
            disposeImageCache();
        }
    }
}