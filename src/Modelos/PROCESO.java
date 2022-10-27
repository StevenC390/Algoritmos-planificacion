/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Steven
 */
public class PROCESO {
    private String nombre;
    private int duracion;
    private int prioridad;
    private int q;
    private float inicioProceso;
    private float salidaProceso;
    
    private int tRetorno = 0;
    private int tEspera = 0;

    public PROCESO() {
    }
    
    public PROCESO(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }
    
    public PROCESO(String nombre, int duracion, int prioridad) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.prioridad = prioridad;
    }
    
    public PROCESO(String nombre, int duracion, int prioridad, int q) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.prioridad = prioridad;
        this.q = q;
    }


    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the prioridad
     */
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * @return the q
     */
    public int getQ() {
        return q;
    }

    /**
     * @param q the q to set
     */
    public void setQ(int q) {
        this.q = q;
    }


    /**
     * @return the inicioProceso
     */
    public float getInicioProceso() {
        return inicioProceso;
    }

    /**
     * @param inicioProceso the inicioProceso to set
     */
    public void setInicioProceso(float inicioProceso) {
        this.inicioProceso = inicioProceso;
    }

    /**
     * @return the salidaProceso
     */
    public float getSalidaProceso() {
        return salidaProceso;
    }

    /**
     * @param salidaProceso the salidaProceso to set
     */
    public void setSalidaProceso(float salidaProceso) {
        this.salidaProceso = salidaProceso;
    }

    /**
     * @return the tRetorno
     */
    public int gettRetorno() {
        return tRetorno;
    }

    /**
     * @param tRetorno the tRetorno to set
     */
    public void settRetorno(int tRetorno) {
        this.tRetorno = tRetorno;
    }

    /**
     * @return the tEspera
     */
    public int gettEspera() {
        return tEspera;
    }

    /**
     * @param tEspera the tEspera to set
     */
    public void settEspera(int tEspera) {
        this.tEspera = tEspera;
    }
}
