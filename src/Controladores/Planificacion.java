/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.PROCESO;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class Planificacion {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int tSistema=0;
        int tEspera=0;
        float tPromEspera=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de procesos: ");
        int num = scanner.nextInt();
        
        //Crar objeto proceso
        LinkedList<PROCESO> p=new LinkedList();
        LinkedList<PROCESO> p2=new LinkedList();
        for (int i= 0; i<num; i++){
            System.out.println("Por favor ingrese el proceso:" +(i+1)+"Nombre, Duracion, Prioridad, Q");
            PROCESO este= new PROCESO(scanner.next(), scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
            p.add(este);
        }
        p2=p;
        //FCFS(p,tSistema,tEspera,tPromEspera);
        p=p2;
        //SJF(p, tSistema, tEspera, tPromEspera);
        p=p2;
        System.out.println("Antes");
        mostrar(p);
        Prioridad(p, tSistema, tEspera, tPromEspera);
        System.out.println("Despues");
        mostrar(p);
    }
    
    public static void FCFS(LinkedList<PROCESO> p,int tSistema,int tEspera, float tPromEspera){
        System.out.println("FCFS");
        procesar(p,tSistema,tEspera,tPromEspera);
    }
    public static void SJF(LinkedList<PROCESO> p,int tSistema,int tEspera, float tPromEspera){
        System.out.println("SJF");
        ordenarDuracion(p);
        procesar(p, tSistema, tEspera, tPromEspera);
    }
    public static void Prioridad(LinkedList<PROCESO> p,int tSistema,int tEspera, float tPromEspera){
        System.out.println("Prioridad");
        ordenarPrioridad(p);
        procesar(p, tSistema, tEspera, tPromEspera);
    }
    public static void RoundRobin(LinkedList<PROCESO> p,int tSistema,int tEspera, float tPromEspera){
        System.out.println("Round Robin");
        
    }
    public static void procesar(LinkedList<PROCESO> p,int tSistema,int tEspera, float tPromEspera){
        boolean bandera=false;
        int tiempo=0;
        int i=0;
        while(bandera==false){
            int tEntrada=0;
            int tSalida=0;
            PROCESO este= p.get(i);
            tEntrada=tiempo;
            int dura=este.getDuracion();
            while(este.getDuracion()>0){
                este.setDuracion(este.getDuracion()-1);
                tiempo++;
            }
            este.setDuracion(dura);
            tSalida=tiempo;
            i++;
            if(i>p.size()-1){
                bandera=true;
            }
            tSistema=tSalida-tEntrada;
            System.out.println("Tiempo Sistema: "+tSistema);
            tEspera=este.getDuracion()-tEntrada;
            System.out.println("Tiempo Espera: "+tEspera);
            System.out.println("Tiempo de ejecucion: "+tiempo);
        }
    }
    public static void mostrar(LinkedList<PROCESO> p){
        for(PROCESO este:p){
            System.out.println(""+este);
        }
    }
    public static void ordenarPrioridad(LinkedList<PROCESO> p){
        PROCESO este=null;
        PROCESO esteOtro=null;
        for(int i=1;i<p.size();i++){
            este= p.get(i);
            int j=i-1;
            while(j>=0 && este.getPrioridad()<=p.get(j).getPrioridad()) {
                System.out.println("Si");
                esteOtro= p.get(j);
                p.set(j+1, p.get(j));
                j--;
            }
            p.set(j+1, este);
        }
    }
    public static void ordenarDuracion(LinkedList<PROCESO> p){
        PROCESO este=null;
        PROCESO esteOtro=null;
        for(int i=1;i<p.size();i++){
            este= p.get(i);
            int j=i-1;
            while(j>=0 && este.getDuracion()<=p.get(j).getDuracion()) {
                System.out.println("Si");
                esteOtro= p.get(j);
                p.set(j+1, p.get(j));
                j--;
            }
            p.set(j+1, este);
        }
    }
}
