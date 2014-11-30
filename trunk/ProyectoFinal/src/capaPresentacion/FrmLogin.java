package capaPresentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import CAPA.JAVA.BEAN.Usuario;
import CAPA.JAVA.DAO.UsuarioDAO;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class FrmLogin extends JFrame implements ActionListener {

    JLabel lblTitulo, lblUsuario, lblClave, lblMensaje, ImagenMaestro;
    JTextField txtUsuario;
    JPasswordField txtClave;
    JButton btnEntrar;

    public static void main(String args[]) {
        FrmLogin objventana = new FrmLogin();
        objventana.setResizable(false);
        objventana.setVisible(true);
        objventana.show();
    }

    FrmLogin() {
        
        setSize(550, 350);
        
        ImagenMaestro = new JLabel(" ");
        ImagenMaestro.setIcon(new ImageIcon(getClass().getResource("/img/logo.png")));
        ImagenMaestro.setBounds(200, 10, 200, 50);
        ImagenMaestro.setSize(400, 100);
        getContentPane().add(ImagenMaestro);

        lblUsuario = new JLabel("USUARIO : ");
        lblUsuario.setBounds(100, 100, 100, 30);
        lblUsuario.setFont(new java.awt.Font("candara", 1, 20));
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblUsuario);

        lblClave = new JLabel("CLAVE : ");
        lblClave.setBounds(100, 150, 100, 30);
        lblClave.setFont(new java.awt.Font("candara", 1, 20));
        lblClave.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblClave);


        txtUsuario = new JTextField();
        txtUsuario.setBounds(250, 100, 100, 30);
        txtUsuario.setFont(new java.awt.Font("Arial", 1, 16));
        txtUsuario.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        getContentPane().add(txtUsuario);

        txtClave = new JPasswordField();
        txtClave.setEchoChar('*');
        txtClave.setFont(new java.awt.Font("Arial", 1, 14));
        txtClave.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                txtClaveKeyTyped(evt);
            }
        });
        txtClave.setBounds(250, 150, 100, 30);
        getContentPane().add(txtClave);
        txtClave.addActionListener(this);

        btnEntrar = new JButton(" Entrar ");
        btnEntrar.setBounds(200, 200, 200, 30);
        btnEntrar.setFont(new java.awt.Font("arial", 1, 20));
        btnEntrar.addActionListener(this);
        getContentPane().add(btnEntrar);

        lblMensaje = new JLabel();
        lblMensaje.setBounds(100, 250, 400, 30);
        lblMensaje.setFont(new java.awt.Font("candara", 1, 20));
        lblMensaje.setForeground(new java.awt.Color(255, 255, 0));
        getContentPane().add(lblMensaje);
        
        add(new imagenfondo());

    }

    public void Entrar() {

        String usuario, clave;
        usuario = txtUsuario.getText().trim();
        clave = txtClave.getText().trim();

        if (usuario.length() == 0 && clave.length() == 0) {
            JOptionPane.showMessageDialog(null, "NO A INGRESADO LA CUENTA !!");
            txtUsuario.requestFocus();
        } else {
            if (usuario.length() != 0 && clave.length() == 0) {
                JOptionPane.showMessageDialog(null, "NO HA DIGITADO EL CLAVE!!");
                txtClave.requestFocus();
            } else {
                if (usuario.length() == 0 && clave.length() != 0) {
                    JOptionPane.showMessageDialog(null, "NO HA DIGITADO EL USUARIO!!");
                    txtUsuario.requestFocus();
                } else {
                    Usuario objUsuBean = new Usuario();
                    objUsuBean.setUsu(usuario);
                    objUsuBean.setCla(clave);
                    UsuarioDAO objUsuDAO = new UsuarioDAO();
                    boolean estado = objUsuDAO.ValidarAcceso(objUsuBean);
                    if (estado) {
                        FrmPrincipal ventanaprincipal = new FrmPrincipal();
                        ventanaprincipal.setLocation(500, 200);
                        ventanaprincipal.setVisible(true);
                        this.dispose();// se cierra  la ventan de login
                    } else {
                        lblMensaje.setText("USUARIO Y CLAVE INCORRECTOS !!");
                        txtUsuario.setText("");
                        txtClave.setText("");
                        txtUsuario.requestFocus();
                    }

                }
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEntrar) {
            Entrar();
        }
    }

    private void txtUsuarioKeyTyped(KeyEvent evt) {
        char x = evt.getKeyChar();
        if ((x == KeyEvent.VK_SPACE)) {
            evt.consume();
            //EMITE UN SONIDO
            getToolkit().beep();
        }
    }

    private void txtClaveKeyTyped(KeyEvent evt) {
        char x = evt.getKeyChar();
        if ((x == KeyEvent.VK_SPACE)) {
            evt.consume();
            //EMITE UN SONIDO
            getToolkit().beep();
        }
    }
}
