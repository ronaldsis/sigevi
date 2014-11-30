package capaPresentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.*;

public class FrmInicio extends JPanel implements ActionListener {

    JButton btacerca;
    JLabel fecha1,hora1, imagen;
    JTextField hora, fecha;
    private FormAcerca acerca;

    FrmInicio() {
        setBackground(new Color(255, 200, 0));
        setSize(900, 600);

        imagen = new JLabel(" ");
        imagen.setIcon(new ImageIcon(getClass().getResource("/img/Unfv.jpg")));
        imagen.setBounds(200, 10, 200, 50);
        imagen.setSize(400, 100);
        add(imagen);

        btacerca = new JButton(" ACERCA ");
        btacerca.setBounds(80, 150, 100, 30);
        btacerca.addActionListener(this);
        add(btacerca);

        fecha1 = new JLabel(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        fecha1.setBounds(150, 250, 250, 30);
        fecha1.setFont(new java.awt.Font("Times New Roman", 0, 16));
        add(fecha1);
        
         hora1 = new JLabel(new SimpleDateFormat("hh:mm:ss").format(new Date()));
        hora1.setBounds(150, 300, 250, 30);
        hora1.setFont(new java.awt.Font("Times New Roman", 0, 16));
        add(hora1);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btacerca) {
            acerca = new FormAcerca();
            acerca.setLocation(80, 150);
            acerca.setVisible(true);
            //Utilizo el resizable para hacer que no se maximize la ventana fijate corre el principal y hazle clic en 
            //inicio y luego haz clic en el boton acerca y saldra la ventana que no se puede maximizar :3
        }
    }
}
