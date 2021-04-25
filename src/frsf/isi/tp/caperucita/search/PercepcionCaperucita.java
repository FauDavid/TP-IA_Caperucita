package frsf.isi.tp.caperucita.search;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

import java.util.Arrays;

public class PercepcionCaperucita extends Perception {

    public static int PERCEPCION_DESCONOCIDA = -1;  //❔
    public static int PERCEPCION_VACIO = 0;         //🕳
    public static int PERCEPCION_ARBOL = 1;         //🌲
    public static int PERCEPCION_DULCE = 2;         //🍩
    public static int PERCEPCION_PIEDRA = 3;        //🗿
    public static int PERCEPCION_FLORES = 4;        //🌺
    public static int PERCEPCION_LOBO = 5;          //🐺

    private int[][] bosque;
    private int[] sensorColumna;
    private int[] sensorFila;
    private int cantidadVidas;
    private int cantidadDulces;
    private int[] posicionFlores;

    public PercepcionCaperucita() {
        cantidadVidas=3;
    }

    public PercepcionCaperucita(Agent agente, Environment ambiente) {
        super(agente, ambiente);
    }

    @Override
    public void initPerception(Agent agente, Environment ambiente) {
        AgenteCaperucita agenteCaperucita = (AgenteCaperucita) agente;
        AmbienteCaperucita ambienteCaperucita = (AmbienteCaperucita) ambiente;
        EstadoAmbienteCaperucita estadoAmbiente =
                ambienteCaperucita.getEnvironmentState();

        int fila = estadoAmbiente.getPosicionAgente()[0];
        int columna = estadoAmbiente.getPosicionAgente()[1];

        this.setBosque(ambienteCaperucita.getBosque());
        this.setCantidadVidas(ambienteCaperucita.getCantidadVidas());
        this.setCantidadDulces(ambienteCaperucita.getCantidadDulces());
        this.setPosicionFlores(ambienteCaperucita.getPosicionFlores());
        this.setSensorColumna(ambienteCaperucita.getColumna(columna));
        this.setSensorFila(ambienteCaperucita.getFila(fila));
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(new String());
        str.append(" \n");
        str.append("Vidas: ").append(this.cantidadVidas);
        str.append(" \n");
        str.append("Columna: ");
        for (int row = 0; row < 9; row++) {
            str.append(" ");
            str.append(this.sensorColumna[row]);
        }
        str.append(" \n");
        str.append("Fila: ");
        for (int col = 0; col < 14; col++) {
            str.append(" ");
            str.append(this.sensorFila[col]);
        }
        str.append(" \n");
        return str.toString();
    }

    //Método especificos de caperucita

    public int[] getSensorColumna() {
        return sensorColumna;
    }

    public void setSensorColumna(int[] sensorColumna) {
        this.sensorColumna = sensorColumna;
    }

    public int[] getSensorFila() {
        return sensorFila;
    }

    public void setSensorFila(int[] sensorFila) {
        this.sensorFila = sensorFila;
    }

    public int getCantidadVidas() {
        return cantidadVidas;
    }

    public void setCantidadVidas(int cantidadVidas) {
        this.cantidadVidas = cantidadVidas;
    }

    public int[] getPosicionFlores() {
        return posicionFlores;
    }

    public void setPosicionFlores(int[] posicionFlores) {
        this.posicionFlores = posicionFlores;
    }

    public void setBosque(int[][] bosque) {
        this.bosque=bosque;
    }

    public int[][] getBosque() {
        return this.bosque;
    }

    public int getCantidadDulces() {
        return cantidadDulces;
    }

    public void setCantidadDulces(int cantidadDulces) {
        this.cantidadDulces = cantidadDulces;
    }


}
