/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.awt.Color;

/**
 *
 * @author pipet
 */
public abstract class FiguraGeometrica {
    private Color borde;
    private Color colorRelleno;

    public FiguraGeometrica() {
    }

    public FiguraGeometrica(Color borde, Color colorRelleno) {
        this.borde = borde;
        this.colorRelleno = colorRelleno;
    }

    /**
     * @return the borde
     */
    public Color getBorde() {
        return borde;
    }

    /**
     * @param borde the borde to set
     */
    public void setBorde(Color borde) {
        this.borde = borde;
    }

    /**
     * @return the colorRelleno
     */
    public Color getColorRelleno() {
        return colorRelleno;
    }

    /**
     * @param colorRelleno the colorRelleno to set
     */
    public void setColorRelleno(Color colorRelleno) {
        this.colorRelleno = colorRelleno;
    }
     
}
