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
public abstract class FiguraEstandar extends FiguraGeometrica{
    private int x;
    private int y;

    public FiguraEstandar(int x, int y, Color borde, Color colorRelleno) {
        super(borde, colorRelleno);
        this.x = x;
        this.y = y;
    }
    public FiguraEstandar(int x, int y) {
        super(null, null);
        this.x = x;
        this.y = y;
    }
    

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
}
