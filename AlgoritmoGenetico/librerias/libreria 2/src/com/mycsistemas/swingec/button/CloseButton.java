/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycsistemas.swingec.button;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Edisoncor
 */
public class CloseButton extends JButton{

    public CloseButton() {
        super();
        creaBoton();
    }

    public CloseButton(AbstractAction action) {
        super(action);
        creaBoton();
    }

    @Override
    public void setText(String text) {
        super.setText("");
    }

    private void creaBoton(){
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/button-close.png"))); // NOI18N
        setBorder(null);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setPressedIcon(new ImageIcon(getClass().getResource("/resources/button-close-pressed.png"))); // NOI18N
        setRolloverIcon(new ImageIcon(getClass().getResource("/resources/button-close-over.png"))); // NOI18N
        setText("");
        setFocusPainted(false);
    }
    

    
}
