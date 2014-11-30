/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacion;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author MLFCR
 */
public class imagenfondounfv  extends JPanel {

    public void paintComponent(Graphics g1) {
        Dimension tam1 = getSize();
        ImageIcon imagen1 = new ImageIcon(new ImageIcon(getClass().getResource("/img/maestro.png")).getImage());
        g1.drawImage(imagen1.getImage(), 0, 0, tam1.width, tam1.height, null);
    }

}
