package frsf.isi.tp.caperucita.search;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EstadoCaperucita extends SearchBasedAgentState {
    private int[][] bosque;
    private int[] posicionCaperucita;
    private int[] posicionFlores;
    private int cantidadVidas;
    private int cantidadDulces;

    public EstadoCaperucita(int[][] bosque, int fila, int columna, int cantidadVidas, int cantidadDulces, int[] posicionFlores) {
        this.bosque = bosque;
        this.posicionCaperucita = new int[]{fila, columna};
        this.posicionFlores = posicionFlores;
        this.cantidadVidas = cantidadVidas;
        this.cantidadDulces = cantidadDulces;
    }

    public EstadoCaperucita() {
        bosque = new int[9][14];
        posicionCaperucita = new int[2];
        posicionFlores = new int[2];
        cantidadVidas = 3;
        cantidadDulces = 0;
        this.initState();
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
        nuevaPosicion[0] = posicionCaperucita[0];
        nuevaPosicion[1] = posicionCaperucita[1];

        int[] nuevaPosicionFlores = new int[2];
        nuevaPosicionFlores[0] = posicionFlores[0];
        nuevaPosicionFlores[1] = posicionFlores[1];

        EstadoCaperucita nuevoEstado = new EstadoCaperucita(nuevoBosque, this.getPosicionFila(), this.getPosicionColumna(), this.cantidadVidas, this.cantidadDulces, nuevaPosicionFlores);

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
        bosque = percepcionCaperucita.getBosque();
        posicionFlores = percepcionCaperucita.getPosicionFlores();
        cantidadVidas = percepcionCaperucita.getCantidadVidas();
    }

    @Override
    public void initState() {
        this.setBosque(getBosque());
        this.setPosicionFloresFila(7);
        this.setPosicionFloresColumna(7);
        this.setPosicionFila(5);
        this.setPosicionColumna(11);
        this.setCantidadVidas(3);
        this.setCantidadDulces(0);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(" Posicion = (").append(getPosicionFila()).append(",").append(getPosicionColumna()).append(") | ");
        str.append(cantidadVidas).append(" vidas | ");
        str.append(cantidadDulces).append(" dulces");

        str.append(" \n");
        str.append(" \n");
        str.append("                Bosque");
        str.append(" \n");

        for (int row = 0; row < 9; row++) {
            str.append(" ");
            for (int col = 0; col < 14; col++) {
                if (bosque[row][col] == 0) {
                    if (getPosicion()[0] == row && getPosicion()[1] == col) {
                        str.append("\uD83D\uDC67 ");
                    } else {
                        str.append("\uD83D\uDD73 ");
                    }
                }
                if (bosque[row][col] == 1) {
                    str.append("\uD83C\uDF32 ");
                }
                if (bosque[row][col] == 2) {
                    str.append("\uD83C\uDF69 ");
                }
                if (bosque[row][col] == 3) {
                    str.append("\uD83D\uDDFF ");
                }
                if (bosque[row][col] == 4) {
                    str.append("\uD83C\uDF3A ");
                }
                if (bosque[row][col] == 5) {
                    str.append("\uD83D\uDC3A ");
                }
                if (bosque[row][col] == -1) {
                    str.append("❔ ");
                }
            }
            str.append(" \n");
        }
        str.append(" ");

        return str.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EstadoCaperucita))
            return false;

        int[][] bosqueObj = ((EstadoCaperucita) obj).getBosque();
        int[] posicionObj = ((EstadoCaperucita) obj).getPosicion();
        int[] posicionFloresObj = ((EstadoCaperucita) obj).getPosicionFlores();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 14; col++) {
                if (bosque[row][col] != bosqueObj[row][col]) {
                    return false;
                }
            }
        }

        if (posicionCaperucita[0] != posicionObj[0] || posicionCaperucita[1] != posicionObj[1]) {
            return false;
        }

        if (posicionFlores[0] != posicionFloresObj[0] || posicionFlores[1] != posicionFloresObj[1]) {
            return false;
        }

        return true;
    }

    public int[][] getBosque() {
        return bosque;
    }

    public void setBosque(int[][] bosque) {
        this.bosque = bosque;
    }

    public int[] getPosicionCaperucita() {
        return posicionCaperucita;
    }

    public void setPosicionCaperucita(int[] posicionCaperucita) {
        this.posicionCaperucita = posicionCaperucita;
    }

    public void setPosicionFlores(int[] posicionFlores) {
        this.posicionFlores = posicionFlores;
    }

    public int getPosicionBosque(int row, int col) {
        return this.bosque[row][col];
    }

    public void setPosicionBosque(int row, int col, int percepcion) {
        this.bosque[row][col] = percepcion;
    }

    public int[] getPosicion() {
        return posicionCaperucita;
    }

    public int getPosicionFila() {
        return posicionCaperucita[0];
    }

    public int getPosicionColumna() {
        return posicionCaperucita[1];
    }

    public void setPosicionFila(int fila) {
        this.posicionCaperucita[0] = fila;
    }

    public void setPosicionColumna(int columna) {
        this.posicionCaperucita[1] = columna;

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

    public int[] getPosicionFlores() {
        return posicionFlores;
    }

    public void setPosicionFloresFila(int fila) {
        this.posicionFlores[0] = fila;
    }

    public void setPosicionFloresColumna(int columna) {
        this.posicionFlores[1] = columna;
    }

    public int moverse(int[] info, int valor, String orientacion) {
        int posicionAMoverse = 0;

        List<Integer> intList = new ArrayList<Integer>(info.length);
        for (int i : info) {
            intList.add(i);
        }
        List<Integer> intList_recortada = new ArrayList<Integer>();

        if (orientacion.equals("ABAJO")) {
            intList_recortada = intList.subList(valor + 1, info.length);
            posicionAMoverse = (int) intList_recortada.stream().takeWhile(i -> (i.equals(PercepcionCaperucita.PERCEPCION_VACIO) || i.equals(PercepcionCaperucita.PERCEPCION_FLORES) || i.equals(PercepcionCaperucita.PERCEPCION_DULCE))).count();
            return posicionAMoverse;
        }

        if (orientacion.equals("ARRIBA")) {
            intList_recortada = intList.subList(0, valor);
            Collections.reverse(intList_recortada);
            posicionAMoverse = (int) intList_recortada.stream().takeWhile(i -> (i.equals(PercepcionCaperucita.PERCEPCION_VACIO) || i.equals(PercepcionCaperucita.PERCEPCION_FLORES) || i.equals(PercepcionCaperucita.PERCEPCION_DULCE))).count();
            return posicionAMoverse;
        }

        if (orientacion.equals("DERECHA")) {
            intList_recortada = intList.subList(valor + 1, info.length);
            posicionAMoverse = (int) intList_recortada.stream().takeWhile(i -> (i.equals(PercepcionCaperucita.PERCEPCION_VACIO) || i.equals(PercepcionCaperucita.PERCEPCION_FLORES) || i.equals(PercepcionCaperucita.PERCEPCION_DULCE))).count();
            return posicionAMoverse;

        }

        if (orientacion.equals("IZQUIERDA")) {
            intList_recortada = intList.subList(0, valor);
            Collections.reverse(intList_recortada);
            posicionAMoverse = (int) intList_recortada.stream().takeWhile(i -> (i.equals(PercepcionCaperucita.PERCEPCION_VACIO) || i.equals(PercepcionCaperucita.PERCEPCION_FLORES) || i.equals(PercepcionCaperucita.PERCEPCION_DULCE))).count();
            return posicionAMoverse;

        }

        return 0;
    }

    public void incrementarDulces(Double cost) {
        this.cantidadDulces += cost;
    }

    public boolean conoceBosque() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 14; col++) {
                if (bosque[row][col] == PercepcionCaperucita.PERCEPCION_DESCONOCIDA) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean noQuedanDulces() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 14; col++) {
                if (bosque[row][col] == PercepcionCaperucita.PERCEPCION_DULCE) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean estaEnFlores() {
        return posicionCaperucita[0]==posicionFlores[0] && posicionCaperucita[1]==posicionFlores[1];
    }
}
