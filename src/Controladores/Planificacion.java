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
        //Crea 3 variables para guardar la informacion sobre los procesos
        int tRetorno = 0;
        int tEspera = 0;
        float tPromRetorno = 0;
        float tPromEspera = 0;
        //Crea una lista donde van a ser guardados los procesos
        LinkedList<PROCESO> p = new LinkedList();
        //Ejecuta los algoritmos
        agregarProcesos(0, p);
        
        FCFS(p, tRetorno, tEspera);
        SJF(p, tRetorno, tEspera);
        Prioridad(p, tRetorno, tEspera);
        
        RoundRobin(p, tRetorno, tEspera);
    }

    public static void agregarProcesos(int num, LinkedList<PROCESO> p) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de procesos a agregar: ");
        num = scanner.nextInt();
        //Crar objeto proceso
        for (int i = 0; i < num; i++) {
            System.out.println("Por favor ingrese el nuevo proceso:" + " Nombre, Duracion");
            PROCESO este = new PROCESO(scanner.next(), scanner.nextInt());
            p.add(este);
        }
    }

    public static void agregarProcesosConPioridad(int num, LinkedList<PROCESO> p) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de procesos a agregar: ");
        num = scanner.nextInt();
        //Editar Procesos
        System.out.println("Pls Ingrese la prioridad para los procesos existentes: ");
        for (PROCESO este : p) {
            System.out.println(este.getNombre() + " Prioridad: ");
            este.setPrioridad(scanner.nextInt());
        }
        //Crar objeto proceso
        for (int i = 0; i < num; i++) {
            System.out.println("Por favor ingrese el nuevo proceso:" + " Nombre, Duracion, Prioridad");
            PROCESO este = new PROCESO(scanner.next(), scanner.nextInt(), scanner.nextInt());
            p.add(este);
        }
    }

    public static void FCFS(LinkedList<PROCESO> p, int tRetorno, int tEspera) {
        System.out.println("Algoritmo FCFS");
        procesar(p, tRetorno, tEspera);
    }

    public static void SJF(LinkedList<PROCESO> p, int tRetorno, int tEspera) {
        System.out.println("Algoritmo SJF");
        System.out.println("Desea agregar un nuevo proceso? Ingrese Y si es afirmativo, N si es negativo");
        Scanner scanner = new Scanner(System.in);
        String letra = scanner.next();
        if (letra.equals("Y") || letra.equals("y")) {
            agregarProcesos(0, p);
        }
        LinkedList<PROCESO> p2 = new LinkedList();
        p2.addAll(p);
        ordenarDuracion(p2);
        procesar(p2, tRetorno, tEspera);
        p2=null;
    }

    public static void Prioridad(LinkedList<PROCESO> p, int tRetorno, int tEspera) {
        System.out.println("Algoritmo por Prioridades");
        System.out.println("Desea agregar un nuevo proceso? Ingrese Y si es afirmativo, N si es negativo");
        Scanner scanner = new Scanner(System.in);
        String letra = scanner.next();
        if (letra.equals("Y") || letra.equals("y")) {
            agregarProcesosConPioridad(0, p);
        } else {
            System.out.println("Pls Ingrese la prioridad para los procesos existentes: ");
            for (PROCESO este : p) {
                System.out.println(este.getNombre() + " Prioridad: ");
                este.setPrioridad(scanner.nextInt());
            }
        }
        LinkedList<PROCESO> p2 = new LinkedList();
        p2.addAll(p);
        ordenarPrioridad(p2);
        procesar(p2, tRetorno, tEspera);
        p2=null;
    }

    public static void RoundRobin(LinkedList<PROCESO> p, int tRetorno, int tEspera) {
        System.out.println("Algoritmo Round Robin");
        System.out.println("Pls Ingrese el valor de Q");
        Scanner scanner = new Scanner(System.in);
        int q=scanner.nextInt();
        procesarRobin(p, tRetorno, tEspera, q);

    }

    public static void procesar(LinkedList<PROCESO> p, int tRetorno, int tEspera) {
        boolean bandera = false;
        int tiempo = 0;
        int i = 0;
        int[] tRetornos = new int[p.size()];
        int[] tEsperas = new int[p.size()];
        while (bandera == false) {
            //Info del proceso cuando llega, sale e inicia
            int tLlegada = i;
            int tInicio = 0;
            int tSalida = 0;
            //Saca el proceso actual para trabajar con su duracion
            PROCESO este = p.get(i);
            //Se anota el tiempo en que llego el nuevo proceso
            tInicio = tiempo;
            //Guarda la duracion del proceso para restaurarla luego del ciclo
            int dura = este.getDuracion();
            //Se "Ejecuta" el proceso
            while (este.getDuracion() > 0) {
                este.setDuracion(este.getDuracion() - 1);
                tiempo++;
            }
            este.setDuracion(dura);
            tSalida = tiempo;
            tRetornos[i] = tSalida;
            //Se calculan los tiempos de Retorno y Espera
            tRetorno = este.getDuracion() + tInicio;
            System.out.println("Tiempo Retorno " + este.getNombre() + ": " + tRetorno);            
            tEspera = tInicio - tLlegada;
            tEsperas[i] = tEspera;
            System.out.println("Tiempo Espera " + este.getNombre() + ": " + tEspera);
            System.out.println("Tiempo de ejecucion: " + tiempo);
            i++;
            if (i == p.size()) {
                bandera = true;
            }
        }
        System.out.println("Tiempo Retorno Promedio: " + calcularPromedio(tRetornos, tRetornos.length));
        System.out.println("Tiempo Espera Promedio: " + calcularPromedio(tEsperas, tEsperas.length));
    }
    
    public static void procesarRobin(LinkedList<PROCESO> p, int tRetorno, int tEspera,int q) {
        boolean bandera = false;
        int tiempo = 0;
        int i = 0;
        int[] tRetornos = new int[p.size()];
        int[] tEsperas = new int[p.size()];
        int[] duras= new int[p.size()];
        while (bandera == false) {
            //Info del proceso cuando llega, sale e inicia
            int tLlegada = i;
            int tInicio = 0;
            int tSalida = 0;
            //Saca el proceso actual para trabajar con su duracion
            PROCESO este = p.get(i);
            if(duras[i]==0){
                duras[i]=este.getDuracion();
            }
            //Se anota el tiempo en que llego el nuevo proceso
            tInicio = tiempo;
            //Se "Ejecuta" el proceso
            int compro=0;
            while (este.getDuracion() != 0 && compro!=q) {
                este.setDuracion(este.getDuracion() - 1);
                tiempo++;
                compro++;
                if(este.getDuracion()==0){
                    p.remove(i);
                }
            }
            compro=0;
            tSalida = tiempo;
            tRetornos[i] = tSalida;
            //Se calculan los tiempos de Retorno y Espera
            tRetorno = tSalida;
            tEspera = tInicio - tLlegada;
            tEsperas[i] = tSalida;
            System.out.println("Tiempo de ejecucion: " + tiempo);
            i++;
            if (p.isEmpty()) {
                bandera = true;
            }else if(i>p.size()-1){
                i=0;
            }
        }
        int[] res=sacarEsperas(tEsperas, duras);
        mostrar(tRetornos, "Retorno");
        mostrar(res, "Espera");
        System.out.println("Tiempo Retorno Promedio: " + calcularPromedio(tRetornos, tRetornos.length));
        System.out.println("Tiempo Espera Promedio: " + calcularPromedio(res, res.length));
    }
    public static int[] sacarEsperas(int[] esperas, int[] duras){
        int[] res=new int[duras.length];
        for (int i = 0; i < duras.length; i++) {
            res[i]=esperas[i]-duras[i];
        }
        return res;
    }
    public static boolean comprobar(boolean[] lista){
        boolean res=true;
        for (int i = 0; i < lista.length; i++) {
            if(lista[i]== false){
                res=false;
            }
        }
        return res;
    }

    public static float calcularPromedio(int[] lista, int n) {
        int suma = 0;
        float res = 0;
        for (int i = 0; i < n; i++) {
            suma += lista[i];
        }
        res = suma / n;
        return res;
    }

    public static void mostrar(int[] lista,String clave) {
        for (int i = 0; i < lista.length; i++) {
            System.out.println("Tiempo " +clave+" p"+(i+1)+": "+lista[i]);
        }
    }

    public static void ordenarPrioridad(LinkedList<PROCESO> p) {
        PROCESO este = null;
        PROCESO esteOtro = null;
        for (int i = 1; i < p.size(); i++) {
            este = p.get(i);
            int j = i - 1;
            while (j >= 0 && este.getPrioridad() <= p.get(j).getPrioridad()) {
                esteOtro = p.get(j);
                p.set(j + 1, p.get(j));
                j--;
            }
            p.set(j + 1, este);
        }
    }

    public static void ordenarDuracion(LinkedList<PROCESO> p) {
        PROCESO este = null;
        PROCESO esteOtro = null;
        for (int i = 1; i < p.size(); i++) {
            este = p.get(i);
            int j = i - 1;
            while (j >= 0 && este.getDuracion() <= p.get(j).getDuracion()) {
                esteOtro = p.get(j);
                p.set(j + 1, p.get(j));
                j--;
            }
            p.set(j + 1, este);
        }
    }
}
