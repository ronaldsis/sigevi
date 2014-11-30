package capaPresentacion;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrmAcerca extends JFrame {

    JLabel imagen;
    
    public FrmAcerca() {
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Unfv.jpg"))); 
        imagen.setBounds(80, 250, 100, 50);
        add(imagen);
    }

    public static void main(String args[]) {
        FrmAcerca a = new FrmAcerca();
        a.setVisible(true);
    }
}
