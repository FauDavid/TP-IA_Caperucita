package frsf.isi.tp.caperucita.search;

import frsf.cidisi.faia.state.EnvironmentState;

public class EstadoAmbienteCaperucita extends EnvironmentState {
    private int[][] bosque;
    private int[] posicionAgente;
    private int cantidadVidasAgente;
    private int cantidadDulcesAgente;

    public EstadoAmbienteCaperucita(int[][] m) {
        bosque = m;
    }

    public EstadoAmbienteCaperucita() {
        bosque = new int[9][14];
        this.initState();
    }

    @Override
    public void initState() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 14; col++) {
                bosque[row][col] = PercepcionCaperucita.PERCEPCION_ARBOL;
            }
        }

        //Escenario 1
        bosque[1][3] = PercepcionCaperucita.PERCEPCION_DULCE;
        bosque[1][4] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[1][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[1][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[1][8] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[1][9] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[1][10] = PercepcionCaperucita.PERCEPCION_DULCE;

        bosque[2][3] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][7] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][8] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][9] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][10] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][11] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[3][3] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][4] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][7] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][8] = PercepcionCaperucita.PERCEPCION_DULCE;
        bosque[3][10] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][11] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[4][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][7] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][9] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][10] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][11] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[5][3] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][7] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][8] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][9] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][10] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][11] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[6][3] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[6][4] = PercepcionCaperucita.PERCEPCION_LOBO;
        bosque[6][8] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[6][10] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[7][3] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[7][4] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[7][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[7][7] = PercepcionCaperucita.PERCEPCION_FLORES;
        bosque[7][8] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[7][9] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[7][10] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[8][9] = PercepcionCaperucita.PERCEPCION_PIEDRA;

        this.setPosicionAgente(new int[]{5, 11});
        this.setCantidadVidasAgente(3);
        this.setCantidadDulcesAgente(0);
    }

    @Override
    public String toString() {
        String str = "";

        str = str + "[ \n";
        for (int row = 0; row < 9; row++) {
            str = str + "[ ";
            for (int col = 0; col < 14; col++) {
                str = str + bosque[row][col] + " ";
            }
            str = str + " ]\n";
        }
        str = str + " ]";

        return str;
    }

    public int[] getColumna(int columna){
        int[] infoColumna = new int[9];
        for(int row = 0; row < 9; row++) {
            infoColumna[row] = bosque[row][columna];
        }
        return infoColumna;
    }

    public int[] getFila(int fila) {
        int[] infoFila = new int[14];
        for(int columna = 0; columna < 14; columna++){
            infoFila[columna] = bosque[fila][columna];
        }
        return infoFila;
    }

    public int[][] getBosque() {
        return bosque;
    }

    public void setBosque(int[][] bosque) {
        this.bosque = bosque;
    }

    public int[] getPosicionAgente() {
        return posicionAgente;
    }

    public void setPosicionAgente(int[] posicionAgente) {
        this.posicionAgente = posicionAgente;
    }

    public int getCantidadVidasAgente() {
        return cantidadVidasAgente;
    }

    public void setCantidadVidasAgente(int cantidadVidasAgente) {
        this.cantidadVidasAgente = cantidadVidasAgente;
    }

    public void setPosicionBosque(int row, int col, int percepcionVacio) {
        this.bosque[row][col] = percepcionVacio;
    }

    public int getCantidadDulcesAgente() {
        return cantidadDulcesAgente;
    }

    public void setCantidadDulcesAgente(int cantidadDulcesAgente) {
        this.cantidadDulcesAgente = cantidadDulcesAgente;
    }

}
