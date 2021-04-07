package frsf.isi.tp.caperucita.search;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AmbienteCaperucita extends Environment {


    @Override
    public Perception getPercept() {
        return null;
    }

    public AmbienteCaperucita() {
        this.environmentState = new EstadoAmbienteCaperucita();
    }

    @Override
    public EstadoAmbienteCaperucita getEnvironmentState() {
        return (EstadoAmbienteCaperucita) super.getEnvironmentState();
    }

    public int[] getColumna(int columna) {
        return ((EstadoAmbienteCaperucita) this.environmentState).getColumna(columna);
    }

    public int[] getFila(int fila) {
        return ((EstadoAmbienteCaperucita) this.environmentState).getFila(fila);
    }
}
