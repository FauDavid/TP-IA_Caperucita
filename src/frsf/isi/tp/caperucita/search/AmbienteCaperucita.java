package frsf.isi.tp.caperucita.search;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.isi.tp.caperucita.search.interfaz.GUI;

import java.util.Arrays;

public class AmbienteCaperucita extends Environment {
    public AmbienteCaperucita() {
        this.environmentState = new EstadoAmbienteCaperucita();
    }

    @Override
    public EstadoAmbienteCaperucita getEnvironmentState() {
        return (EstadoAmbienteCaperucita) super.getEnvironmentState();
    }

    @Override
    public Perception getPercept() {

        PercepcionCaperucita perception = new PercepcionCaperucita();

        int row = this.getEnvironmentState().getPosicionAgente()[0];
        int col = this.getEnvironmentState().getPosicionAgente()[1];

        perception.setSensorColumna(this.getColumna(col));
        perception.setSensorFila(this.getFila(row));
        perception.setPosicionFlores(this.getPosicionFlores());
        perception.setCantidadVidas(this.getCantidadVidas());
        perception.setBosque(this.getBosque());
        perception.setCantidadDulces(this.getCantidadDulces());
        perception.setPosicionCaperucita(this.getPosicionCaperucita());

        return perception;
    }

    @Override
    public String toString() {
        return environmentState.toString();
    }

    @Override
    public boolean agentFailed(Action actionReturned) {
        EstadoAmbienteCaperucita estadoAmbienteCaperucita = this.getEnvironmentState();
        int vidasAgente = estadoAmbienteCaperucita.getCantidadVidasAgente();
        if (vidasAgente == 0) return true;
        return false;
    }

    //Métodos especificos de caperucita

    public int[] getColumna(int columna) {
        return ((EstadoAmbienteCaperucita) this.environmentState).getColumna(columna);
    }

    public int[] getFila(int fila) {
        return ((EstadoAmbienteCaperucita) this.environmentState).getFila(fila);
    }

    public int[] getPosicionFlores() {
        return ((EstadoAmbienteCaperucita) this.environmentState).getPosicionFlores();
    }

    public int getCantidadVidas() {
        return ((EstadoAmbienteCaperucita) this.environmentState).getCantidadVidasAgente();
    }

    public int[][] getBosque() {
        return ((EstadoAmbienteCaperucita) this.environmentState).getBosque();
    }

    public int getCantidadDulces() {
        return ((EstadoAmbienteCaperucita) this.environmentState).getCantidadDulcesAgente();
    }

    public int[] getPosicionCaperucita() {
        return ((EstadoAmbienteCaperucita) this.environmentState).getPosicionAgente();
    }
}
