package frsf.isi.tp.caperucita.search;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

import java.util.Arrays;

public class PercepcionCaperucita extends Perception {

    public static int PERCEPCION_DESCONOCIDA = -1;
    public static int PERCEPCION_VACIO = 0;
    public static int PERCEPCION_ARBOL = 1;
    public static int PERCEPCION_DULCE = 2;
    public static int PERCEPCION_PIEDRA = 3;
    public static int PERCEPCION_FLORES = 4;
    public static int PERCEPCION_LOBO = 5;

    private int[] sensorColumna;
    private int[] sensorFila;
    private int cantidadVidas;

    public PercepcionCaperucita() {
        cantidadVidas = 3;
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

        this.setSensorColumna(ambienteCaperucita.getColumna(columna));
        this.setSensorFila(ambienteCaperucita.getFila(fila));
    }

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

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        str.append("Vidas: " + this.cantidadVidas);
        str.append("; ");
        str.append("InformacionColumna: " + Arrays.toString(this.sensorColumna));
        str.append("; ");
        str.append("InformacionFila: " + Arrays.toString(this.sensorFila));
        str.append("; ");

        return str.toString();
    }

}
