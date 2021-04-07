package frsf.isi.tp.caperucita.search;

import domain.Celda;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

import java.util.ArrayList;
import java.util.List;

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
        this.posicion = new int[]{fila,columna};
        this.cantidadVidas = cantidadVidas;
        this.cantidadDulces = cantidadDulces;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public SearchBasedAgentState clone() {
        return null;
    }

    @Override
    public void updateState(Perception p) {

    }

    @Override
    public void initState() {

    }

    @Override
    public String toString() {
        return null;
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

    public void setBosque(int[][] bosque) {
        this.bosque = bosque;
    }

    public void setPosicionBosque(int row, int col, int percepcionVacio) {
        this.bosque[row][col] = percepcionVacio;
    }

    public boolean estaEnCampoDeFlores(){
        int fila = this.posicion[0];
        int columna = this.posicion[1];

        return this.bosque[fila][columna] == PercepcionCaperucita.PERCEPCION_FLORES;
    }
}
