/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycsistemas.swingec.button;

import com.mycsistemas.swingec.graphicsUtilities.HyperlinkHandler;
import com.mycsistemas.swingec.graphicsUtilities.Reflection;
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
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/**
 *
 * @author Edisoncor
 */
   public class TaskButton extends JButton {

       private Dimension componentDimension = new Dimension(0, 0);
       private BufferedImage image;
       private Rectangle clickable;
       private float ghostValue = 0.0f;
       private float newFraction = 0.0f;
       private int distance_r;
       private int distance_g;
       private int distance_b;
       private int color_r;
       private int color_g;
       private int color_b;
       private String nombre="nombre";
       private String description="Descripcion";
       private String imageName="/resources/task-view-trip.png";
       private Font categoryFont = new Font("Arial", Font.PLAIN, 20);
       private Font categorySmallFont = new Font("Arial", Font.PLAIN, 14);
       private Color shadowColor=new Color(0,0,0);;
       private float shadowOffsetX=0f;
       private float shadowOffsetY=0f;
       private float shadowOpacity=.5f;
       private float categorySmallOpacity=.8f;
       private Color categoryColor=new Color(210,210,210);
       private boolean mouseEnter=false;
       private Color categoryHighlightColor = new Color(255,255,255);
       private Image buttonHighlight;

       public TaskButton(){
           this("Nombre", "Descripcion", "/resources/task-view-trip.png");
       }

        public TaskButton(String name, String description, String imageName) {
            this.nombre = name;
            setText(name);
            this.description = description;
            this.imageName = imageName;

            setFocusable(false);

            setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

            setOpaque(false);
            setContentAreaFilled(false);
            setFocusPainted(false);
//            setBorderPainted(false);

            new ImageFetcher().execute();

            color_r = Color.red.getRed();
            color_g = Color.green.getGreen();
            color_b = Color.BLUE.getBlue();

            setSize(new Dimension(242, 64));
            setPreferredSize(new Dimension(242, 64));
             buttonHighlight = loadImage("/resources/header-halo.png");

        }

    private static Image loadImage(String fileName) {
        try {
            return ImageIO.read(AeroButton.class.getResource(fileName));
        } catch (IOException ex) {
            return null;
        }
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }





        @Override
        protected void fireActionPerformed(ActionEvent e) {
            // consume action performed events here
            // see MouseClickHandler instead
        }

        private class ImageFetcher extends SwingWorker {
            @Override
            protected Object doInBackground() throws Exception {
                getImage();
                return image;
            }

            @Override
            protected void done() {
                componentDimension = computeDimension();
                revalidate();
            }
        }

        private void getImage() {
            try {
                this.image = ImageIO.read(getClass().getResource(imageName));
            } catch (IOException e) {

            }
            BufferedImage mask = Reflection.createGradientMask(image.getWidth(),
                                                               image.getHeight());
            this.image = Reflection.createReflectedPicture(image, mask);
        }

        private Dimension computeDimension() {
            Insets insets = getInsets();

            FontMetrics metrics = getFontMetrics(categoryFont);
            Rectangle2D bounds = metrics.getMaxCharBounds(getGraphics());
            int height = (int) bounds.getHeight() + metrics.getLeading();
            int nameWidth = SwingUtilities.computeStringWidth(metrics, getText());

            metrics = getFontMetrics(categorySmallFont);
            bounds = metrics.getMaxCharBounds(getGraphics());
            height += bounds.getHeight();
            int descWidth = SwingUtilities.computeStringWidth(metrics,
                                                              description == null ? "" : description);

            int width = Math.max(nameWidth, descWidth);
            width += image.getWidth() + 10;

            clickable = new Rectangle(insets.left, insets.top /*+ 4*/,
                                      width /*+ insets.left + insets.right*/,
                                      height /*+ insets.top + insets.bottom*/);
            HyperlinkHandler.add(this, clickable);

            height = Math.max(height, image.getHeight());
            height += 4;

            return new Dimension(width + insets.left + insets.right,
                                 height + insets.top + insets.bottom);
        }

        @Override
        public Dimension getMinimumSize() {
            return getPreferredSize();
        }

        @Override
        public Dimension getPreferredSize() {
            return componentDimension;
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (!isVisible()) {
                return;
            }

            Graphics2D g2 = (Graphics2D) g;
            setupGraphics(g2);

            float y = paintText(g2);
            getImage();
            paintImage(g2, y);
        }

        private void paintImage(Graphics2D g2, float y) {
            Insets insets = getInsets();

            if (ghostValue > 0.0f) {
                int newWidth = (int) (image.getWidth() * (1.0 + ghostValue / 2.0));
                int newHeight = (int) (image.getHeight() * (1.0 + ghostValue / 2.0));

                Composite composite = g2.getComposite();
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                                                           0.7f * (1.0f - ghostValue)));
                g2.drawImage(image,
                             insets.left + (image.getWidth() - newWidth) / 2,
                             4 + (int) (y - newHeight / (5.0 / 3.0)) -
                             (image.getWidth() - newWidth) / 2,
                             newWidth, newHeight, null);
                g2.setComposite(composite);
            }

            g2.drawImage(image, null,
                         insets.left,
                         4 + (int) (y - image.getHeight() / (5.0 / 3.0)));
            if(getModel().isRollover()  ){
                g2.drawRect(0, 0, getWidth()-1, getHeight()-1);
                g2.drawImage(buttonHighlight,
                    0,0,
                    getWidth(), getHeight(), null);
        }
        }

        private float paintText(Graphics2D g2) {
            g2.setFont(categoryFont);

            Insets insets = getInsets();

            FontRenderContext context = g2.getFontRenderContext();
            TextLayout layout = new TextLayout(getText(),
                                               categoryFont, context);

            float x = image.getWidth() + 10.0f;
            x += insets.left;
            float y = 4.0f + layout.getAscent() - layout.getDescent();
            y += insets.top;

            g2.setColor(shadowColor);
            Composite composite = g2.getComposite();
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                                                       shadowOpacity));
            layout.draw(g2, shadowOffsetX + x, shadowOffsetY + y);
            g2.setComposite(composite);

            g2.setColor(new Color(color_r, color_g, color_b));
            layout.draw(g2, x, y);
            y += layout.getDescent();

            layout = new TextLayout(description == null ? " " : description,
                                    categorySmallFont, context);
            y += layout.getAscent();
            composite = g2.getComposite();
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    categorySmallOpacity));
            layout.draw(g2, x, y);
            g2.setComposite(composite);

            return y;
        }

        private void setupGraphics(Graphics2D g2) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        }

        private final class MouseClickHandler extends MouseAdapter {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (clickable.contains(e.getPoint())) {
                    for (ActionListener l : getActionListeners()) {
                        l.actionPerformed(new ActionEvent(TaskButton.this, 462, ""));
                    }
                }
            }
        }
   }

