/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacion;

import java.awt.*;
import javax.swing.*;

public class imagenfondo extends JPanel {

    public void paintComponent(Graphics g1) {
        Dimension tam1 = getSize();
        ImageIcon imagen1 = new ImageIcon(new ImageIcon(getClass().getResource("/img/pared.jpg")).getImage());
        g1.drawImage(imagen1.getImage(), 0, 0, tam1.width, tam1.height, null);
    }

}
