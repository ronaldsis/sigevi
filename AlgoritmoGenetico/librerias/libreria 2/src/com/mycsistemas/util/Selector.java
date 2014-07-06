/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycsistemas.util;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Action;

/**
 *
 * @author edisoncor
 */
public class Selector {

    private String title;
    private String subtitle;
    private String description;
    private BufferedImage imagen;
    private ActionListener accionPrincipal;
    private ActionListener accionSecundaria;
    private String nombrePrimeraAccion;
    private String nombreSegundoAccion;


    public Selector() {
        loadImage("/resources/shinybutton.png");
    }

    public Selector(String title, String subtitle, String description, BufferedImage imagen) {
        this();
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.imagen = imagen;
    }

    public Selector(String title, String subtitle, String description, ActionListener accionPrincipal, String nombrePrimeraAccion) {
        this();
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.accionPrincipal = accionPrincipal;
        this.nombrePrimeraAccion = nombrePrimeraAccion;
    }

    public Selector(String title, String subtitle, String description, ActionListener accionPrincipal, ActionListener accionSecundaria, String nombrePrimeraAccion, String nombreSegundoAccion) {
        this(title, subtitle, description, accionPrincipal, nombrePrimeraAccion);
        this.nombrePrimeraAccion = nombrePrimeraAccion;
        this.nombreSegundoAccion = nombreSegundoAccion;
    }



    public Selector(String title, String subtitle, String description) {
        this();
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
    }


    public void loadImage(String fileName) {
        try {
            imagen = ImageIO.read(Selector.class.getResource(fileName));
        } catch (Exception ex) {
            return;
        }
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNombrePrimeraAccion() {
        return nombrePrimeraAccion;
    }

    public void setNombrePrimeraAccion(String nombrePrimeraAccion) {
        this.nombrePrimeraAccion = nombrePrimeraAccion;
    }

    public String getNombreSegundoAccion() {
        return nombreSegundoAccion;
    }

    public void setNombreSegundoAccion(String nombreSegundoAccion) {
        this.nombreSegundoAccion = nombreSegundoAccion;
    }

    public ActionListener getAccionPrincipal() {
        return accionPrincipal;
    }

    public void setAccionPrincipal(ActionListener accionPrincipal) {
        this.accionPrincipal = accionPrincipal;
    }

    public ActionListener getAccionSecundaria() {
        return accionSecundaria;
    }

    public void setAccionSecundaria(ActionListener accionSecundaria) {
        this.accionSecundaria = accionSecundaria;
    }



}
