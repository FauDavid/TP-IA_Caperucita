package frsf.isi.tp.caperucita.search;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class EstadoCaperucita extends SearchBasedAgentState {
    private int[][] bosque;
    private int[] posicion;

    private int cantidadVidas;
    private int cantidadDulces;

    public EstadoCaperucita() {
        bosque = new int[9][14];
        posicion = new int[2];
        cantidadVidas = 3;
        cantidadDulces = 0;
        this.initState();
    }

    public EstadoCaperucita(int[][] bosque, int fila, int columna, int cantidadVidas, int cantidadDulces) {
        this.bosque = bosque;
        this.posicion = new int[]{fila, columna};
        this.cantidadVidas = cantidadVidas;
        this.cantidadDulces = cantidadDulces;
    }

    @Override
    public SearchBasedAgentState clone() {
        int[][] nuevoBosque = new int[9][14];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 14; col++) {
                nuevoBosque[row][col] = bosque[row][col];
            }
        }

        int[] nuevaPosicion = new int[2];
        nuevaPosicion[0] = posicion[0];
        nuevaPosicion[1] = posicion[1];

        EstadoCaperucita nuevoEstado = new EstadoCaperucita(nuevoBosque, this.getPosicionFila(), this.getPosicionColumna(), this.cantidadVidas, this.cantidadDulces);

        return nuevoEstado;
    }

    @Override
    public void updateState(Perception p) {
        PercepcionCaperucita percepcionCaperucita = (PercepcionCaperucita) p;

        int fila = this.getPosicionFila();
        int columna = this.getPosicionColumna();

        for (int row = 0; row < 9; row++) {
            bosque[row][columna] = percepcionCaperucita.getSensorColumna()[row];
        }
        for (int col = 0; col < 14; col++) {
            bosque[fila][col] = percepcionCaperucita.getSensorFila()[col];
        }

        cantidadVidas = percepcionCaperucita.getCantidadVidas();

    }

    @Override
    public void initState() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 14; col++) {
                bosque[row][col] = PercepcionCaperucita.PERCEPCION_DESCONOCIDA;
            }
        }

        this.setPosicionFila(5);
        this.setPosicionColumna(11);
        this.setCantidadVidas(3);
        this.setCantidadDulces(0);
    }

    @Override
    public String toString() {
        String str = "";

        str = str + " posicion=\"(" + getPosicionFila() + "," + "" + getPosicionColumna() + ")\"";
        str = str + " vidas=\"" + cantidadVidas + "\"";
        str = str + " dulces=\"" + cantidadDulces + "\" ";

        str = str + "bosque=\"[ \n";
        for (int row = 0; row < 9; row++) {
            str = str + "[ ";
            for (int col = 0; col < 14; col++) {
                if (bosque[row][col] == -1) {
                    str = str + "* ";
                } else {
                    str = str + bosque[row][col] + " ";
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]\"";

        return str;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EstadoCaperucita))
            return false;

        int[][] bosqueObj = ((EstadoCaperucita) obj).getBosque();
        int[] posicionObj = ((EstadoCaperucita) obj).getPosicion();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 14; col++) {
                if (bosque[row][col] != bosqueObj[row][col]) {
                    return false;
                }
            }
        }

        if (posicion[0] != posicionObj[0] || posicion[1] != posicionObj[1]) {
            return false;
        }

        return true;
    }

    public int getPosicionFila() {
        return posicion[0];
    }

    public int getPosicionColumna() {
        return posicion[1];
    }

    public void setPosicionFila(int fila) {
        this.posicion[0] = fila;
    }

    public void setPosicionColumna(int columna) {
        this.posicion[1] = columna;

    }

    public int[] getColumna(int columna) {
        int[] infoColumna = new int[9];
        for (int row = 0; row < 9; row++) {
            infoColumna[row] = bosque[row][columna];
        }
        return infoColumna;
    }

    public int[] getFila(int fila) {
        int[] infoFila = new int[14];
        for (int columna = 0; columna < 14; columna++) {
            infoFila[columna] = bosque[fila][columna];
        }
        return infoFila;
    }

    public int getCantidadVidas() {
        return cantidadVidas;
    }

    public void setCantidadVidas(int cantidadVidas) {
        this.cantidadVidas = cantidadVidas;
    }

    public int getCantidadDulces() {
        return cantidadDulces;
    }

    public void setCantidadDulces(int cantidadDulces) {
        this.cantidadDulces = cantidadDulces;
    }

    public int[][] getBosque() {
        return bosque;
    }

    public int[] getPosicion() {
        return posicion;
    }

    public void setBosque(int[][] bosque) {
        this.bosque = bosque;
    }

    public int getPosicionBosque(int row, int col) {
        return this.bosque[row][col];
    }

    public void setPosicionBosque(int row, int col, int percepcionVacio) {
        this.bosque[row][col] = percepcionVacio;
    }

    public boolean estaEnCampoDeFlores() {
        return this.bosque[posicion[0]][posicion[1]] == PercepcionCaperucita.PERCEPCION_FLORES;
    }

    public boolean hayObstaculo() {
        return ((this.bosque[posicion[0]][posicion[1]] == PercepcionCaperucita.PERCEPCION_ARBOL) || (this.bosque[posicion[0]][posicion[1]] == PercepcionCaperucita.PERCEPCION_PIEDRA));
    }

    public boolean hayLobo(int[] info){
        List<Integer> intList = new ArrayList<Integer>(info.length);
        for (int i : info)
        {
            intList.add(i);
        }
        return intList.contains(PercepcionCaperucita.PERCEPCION_LOBO);
    }

    public int moverse(int[] info, int valor, String orientacion) {
        int posicionAMoverse = 0;

        int[] percepcionesValidas = new int[]{PercepcionCaperucita.PERCEPCION_FLORES, PercepcionCaperucita.PERCEPCION_VACIO, PercepcionCaperucita.PERCEPCION_DULCE};

        List<Integer> intList = new ArrayList<Integer>(info.length);
        for (int i : info) {
            intList.add(i);
        }
        List<Integer> intList_recortada = new ArrayList<Integer>();

        if(orientacion.equals("ABAJO")) {
            intList_recortada = intList.subList(valor+1, info.length);
            posicionAMoverse = (int) intList_recortada.stream().takeWhile(i -> (i.equals(PercepcionCaperucita.PERCEPCION_VACIO) || i.equals(PercepcionCaperucita.PERCEPCION_FLORES) || i.equals(PercepcionCaperucita.PERCEPCION_DULCE))).count();

        }

        if(orientacion.equals("ARRIBA")) {
            intList_recortada = intList.subList(0, valor);
            Collections.reverse(intList_recortada);
            posicionAMoverse = (int) intList_recortada.stream().takeWhile(i -> (i.equals(PercepcionCaperucita.PERCEPCION_VACIO) || i.equals(PercepcionCaperucita.PERCEPCION_FLORES) || i.equals(PercepcionCaperucita.PERCEPCION_DULCE))).count();
        }

        if(orientacion.equals("DERECHA")) {
            intList_recortada = intList.subList(valor+1, info.length);
            posicionAMoverse = (int) intList_recortada.stream().takeWhile(i -> (i.equals(PercepcionCaperucita.PERCEPCION_VACIO) || i.equals(PercepcionCaperucita.PERCEPCION_FLORES) || i.equals(PercepcionCaperucita.PERCEPCION_DULCE))).count();
        }

        if(orientacion.equals("IZQUIERDA")) {
            intList_recortada = intList.subList(0, valor);
            Collections.reverse(intList_recortada);
            posicionAMoverse = (int) intList_recortada.stream().takeWhile(i -> (i.equals(PercepcionCaperucita.PERCEPCION_VACIO) || i.equals(PercepcionCaperucita.PERCEPCION_FLORES) || i.equals(PercepcionCaperucita.PERCEPCION_DULCE))).count();
        }

        return posicionAMoverse;
    }

    public void incrementarDulces(Double cost) {
        this.cantidadDulces+=cost;
    }

    public boolean tieneVidas() {
        return (this.cantidadVidas > 0);
    }

    public boolean recorrioTodoElBosque() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 14; col++) {
                if (bosque[row][col] == PercepcionCaperucita.PERCEPCION_DESCONOCIDA) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean faltanDulces() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col <14; col++) {
                if (bosque[row][col] == PercepcionCaperucita.PERCEPCION_DULCE) {
                    return true;
                }
            }
        }
        return false;
    }
}
