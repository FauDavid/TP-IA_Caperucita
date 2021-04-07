package frsf.isi.tp.caperucita.search;

import frsf.cidisi.faia.state.EnvironmentState;

public class EstadoAmbienteCaperucita extends EnvironmentState {
    private int[][] bosque;
    private int[] posicionAgente;
    private int cantidadVidasAgente;

    @Override
    public void initState() {

    }

    @Override
    public String toString() {
        return null;
    }

    public int[] getColumna(int columna){
        int[] column = new int[bosque[0].length];
        for(int i=0; i<column.length; i++){
            column[i] = bosque[i][columna];
        }
        return column;
    }

    public int[] getFila(int fila) {
        int[] row = new int[bosque[0].length];
        for(int i=0; i<row.length; i++){
            row[i] = bosque[fila][i];
        }
        return row;
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

}
