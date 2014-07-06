package com.mycsistemas.swingec.button;

import com.mycsistemas.swingec.graphicsUtilities.ColorTintFilter;
import com.mycsistemas.swingec.graphicsUtilities.GraphicsUtil;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;


/**
 *
 * @author rbair
 */
public class ActionColoredButton extends JButton {

    private float shadowOffsetX;
    private float shadowOffsetY;
    
    private Color shadowColor=new Color(0,0,0);
    private int shadowDirection=60;
    private Color color=getBackground();
    
    private BufferedImage mainButton, mainButtonPressed,
                  normalButton, normalButtonPressed, buttonHighlight;

    private int shadowDistance=1;
    private Insets sourceInsets = new Insets(6, 7, 6, 8);
    private Dimension buttonDimension= new Dimension(116, 35);
    private Color buttonForeground= new Color(255,255,255);
    private Font buttonFont = new Font("Arial", Font.BOLD, 16);
    private Float profundidad=.5f;
    
    private float ghostValue;
    
    private boolean main = false;

    public ActionColoredButton(String text) {
        this();
        setText(text);
    }
    
    public ActionColoredButton(Action a) {
        this();
        setAction(a);
    }
    
    public ActionColoredButton() {
        
        
        computeShadow();
        
//        addMouseListener(new HiglightHandler());
        
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setForeground(buttonForeground);
        setFont(buttonFont);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusable(false);
        normalButton = (BufferedImage) loadImage("/resources/button-normal.png");
        normalButtonPressed = (BufferedImage) loadImage("/resources/button-normal-pressed.png");
        buttonHighlight = (BufferedImage) loadImage("/resources/header-halo.png");
        mainButton = (BufferedImage) loadImage("/resources/button-main.png");
        mainButtonPressed = (BufferedImage) loadImage("/resources/button-main-pressed.png");

        ColorTintFilter tint = new ColorTintFilter(color, profundidad);
        normalButton=tint.filter(normalButton, normalButton);
        normalButtonPressed=tint.filter(normalButtonPressed, normalButtonPressed);

        
        // Hacky? Hacky!
        setUI(new BasicButtonUI() {
            @Override
            public Dimension getMinimumSize(JComponent c) {
                return getPreferredSize(c);
            }
            
            @Override
            public Dimension getMaximumSize(JComponent c) {
                return getPreferredSize(c);
            }
            
            @Override
            public Dimension getPreferredSize(JComponent c) {
                Insets insets = c.getInsets();
                Dimension d = new Dimension(buttonDimension);
                d.width += insets.left + insets.right;
                d.height += insets.top + insets.bottom;
                return d;
            }
        });
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        normalButton = (BufferedImage) loadImage("/resources/button-normal.png");
        normalButtonPressed = (BufferedImage) loadImage("/resources/button-normal-pressed.png");

        ColorTintFilter tint = new ColorTintFilter(color, profundidad);
        normalButton=tint.filter(normalButton, normalButton);
        normalButtonPressed=tint.filter(normalButtonPressed, normalButtonPressed);

        repaint();
    }

    public Float getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Float profundidad) {
        this.profundidad = profundidad;
        normalButton = (BufferedImage) loadImage("/resources/button-normal.png");
        normalButtonPressed = (BufferedImage) loadImage("/resources/button-normal-pressed.png");

        ColorTintFilter tint = new ColorTintFilter(color, profundidad);
        normalButton=tint.filter(normalButton, normalButton);
        normalButtonPressed=tint.filter(normalButtonPressed, normalButtonPressed);
        repaint();
    }

    public void setMain(boolean main) {
        boolean old = isMain();
        this.main = main;
        firePropertyChange("main", old, isMain());
    }
    
    public boolean isMain() {
        return main;
    }
    
    private void computeShadow() {
        double rads = Math.toRadians(shadowDirection);
        shadowOffsetX = (float) Math.cos(rads) * shadowDistance;
        shadowOffsetY = (float) Math.sin(rads) * shadowDistance;
    }


    private static Image loadImage(String fileName) {
        try {
            return ImageIO.read(ActionColoredButton.class.getResource(fileName));
        } catch (IOException ex) {
            return null;
        }
    }
    private Image getImage(boolean armed) {
        if (isMain()) {
            return armed ? mainButtonPressed : mainButton;
        } else {
            return armed ? normalButtonPressed : normalButton;
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        ButtonModel m = getModel();
        Insets insets = getInsets();
        
        int width = getWidth() - insets.left - insets.right;
        int height = getHeight() - insets.top - insets.bottom;
        
        GraphicsUtil.tileStretchPaint(g2,this,(BufferedImage) getImage(m.isArmed()), sourceInsets);

//        if (ghostValue > 0.0f) {
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            
            float alphaValue = ghostValue;
            Composite composite = g2.getComposite();
            if (composite instanceof AlphaComposite) {
                alphaValue *= ((AlphaComposite) composite).getAlpha();
            }
            
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    1));
            if(m.isRollover()){
                g2.drawImage(buttonHighlight,
                        insets.left + 2, insets.top + 2,
                        width - 4, height - 4, null);
            }
            g2.setComposite(composite);
//        }
        
        FontMetrics fm = getFontMetrics(getFont());
        TextLayout layout = new TextLayout(getText(),
                getFont(),
                g2.getFontRenderContext());
        Rectangle2D bounds = layout.getBounds();
        
        int x = (int) (getWidth() - insets.left - insets.right -
                bounds.getWidth()) / 2;
        //x -= 2;
        int y = (getHeight() - insets.top - insets.bottom -
                 fm.getMaxAscent() - fm.getMaxDescent()) / 2;
        y += fm.getAscent() - 1;
        
        if (m.isArmed()) {
            x += 1;
            y += 1;
        }
        
        g2.setColor(shadowColor);
        layout.draw(g2,
                x + (int) Math.ceil(shadowOffsetX),
                y + (int) Math.ceil(shadowOffsetY));
        g2.setColor(buttonForeground);
        layout.draw(g2, x, y);
    }

    public Color getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
        repaint();
    }

    public Dimension getButtonDimension() {
        return buttonDimension;
    }

    public void setButtonDimension(Dimension buttonDimension) {
        this.buttonDimension = buttonDimension;
        repaint();
    }

    public Font getButtonFont() {
        return buttonFont;
    }

    public void setButtonFont(Font buttonFont) {
        this.buttonFont = buttonFont;
        repaint();
    }

    public Color getButtonForeground() {
        return buttonForeground;
    }

    public void setButtonForeground(Color buttonForeground) {
        this.buttonForeground = buttonForeground;
        repaint();
    }

    public int getShadowDirection() {
        return shadowDirection;
    }

    public void setShadowDirection(int shadowDirection) {
        this.shadowDirection = shadowDirection;
        repaint();
    }

    public int getShadowDistance() {
        return shadowDistance;
    }

    public void setShadowDistance(int shadowDistance) {
        this.shadowDistance = shadowDistance;
        repaint();
    }
    
    
}
