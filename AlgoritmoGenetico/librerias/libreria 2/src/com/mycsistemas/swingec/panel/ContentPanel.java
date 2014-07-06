package com.mycsistemas.swingec.panel;

import com.mycsistemas.swingec.graphicsUtilities.GraphicsUtil;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.LinearGradientPaint;
import java.io.IOException;
import javax.imageio.ImageIO;
//import com.sun.javaone.aerith.g2d.LinearGradientPaint;

public class ContentPanel extends JPanel {
    ////////////////////////////////////////////////////////////////////////////
    // THEME SPECIFIC FIELDS
    ////////////////////////////////////////////////////////////////////////////
    private float[] fraction ={0.22f, 0.9f};

    private LinearGradientPaint backgroundGradient = 
            new LinearGradientPaint(0f,0f,0f,584f,
            fraction,new Color[]{new Color(32,39,55), new Color(133,144,165)});

    private BufferedImage light;
    private float lightOpacity=0.5f;
    private Color colorStart=new Color(32,39,55);
    private Color colorEnd=new Color(133,144,165);

    // Intermediate image to avoid gradient repaints
    private Image gradientImage = null;

    public ContentPanel() {
        light=(BufferedImage) loadImage("/resources/content-light.png");
    }

    private static Image loadImage(String fileName) {
        try {
            return ImageIO.read(ContentPanel.class.getResource(fileName));
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (!isVisible()) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g;

//        if (gradientImage == null) {
            // Only create this once; this assumes that the size of this
            // container never changes
            gradientImage = GraphicsUtil.createCompatibleImage(getWidth(), getHeight());
            Graphics2D g2d = (Graphics2D) gradientImage.getGraphics();
            Composite composite = g2.getComposite();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                                RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            backgroundGradient =   new LinearGradientPaint(0f,0f,0f,584f,
                    fraction,new Color[]{colorStart, colorEnd});
            g2d.setPaint(backgroundGradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                             lightOpacity));
            g2d.drawImage(light, 0, 0, getWidth(), light.getHeight(), null);
            g2d.setComposite(composite);
            g2d.dispose();
            // !!! ONLY BECAUSE WE NEVER RECREATE THE INTERMEDIATE IMAGE
//            light = null;
//        }

        g2.drawImage(gradientImage, 0, 0, null);
    }

    public Color getColorEnd() {
        return colorEnd;
    }

    public void setColorEnd(Color colorEnd) {
        this.colorEnd = colorEnd;
        gradientImage=null;
        repaint();
    }

    public Color getColorStart() {
        return colorStart;
    }

    public void setColorStart(Color colorStart) {
        this.colorStart = colorStart;
        gradientImage=null;
        repaint();
    }

    public float getLightOpacity() {
        return lightOpacity;
    }

    public void setLightOpacity(float lightOpacity) {
        this.lightOpacity = lightOpacity;
        gradientImage=null;
        repaint();
    }


}
