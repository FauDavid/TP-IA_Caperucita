package frsf.isi.tp.caperucita.search;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AmbienteCaperucita extends Environment {

    @Override
    public Perception getPercept() {
        PercepcionCaperucita perception = new PercepcionCaperucita();

        int row = this.getEnvironmentState().getPosicionAgente()[0];
        int col = this.getEnvironmentState().getPosicionAgente()[1];

        perception.setSensorColumna(this.getColumna(col));
        perception.setSensorFila(this.getFila(row));

        return perception;
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

    @Override
    public String toString() {
        return environmentState.toString();
    }

    @Override
    public boolean agentFailed(Action actionReturned) {
        EstadoAmbienteCaperucita estadoAmbienteCaperucita = this.getEnvironmentState();
        int vidasAgente = estadoAmbienteCaperucita.getCantidadVidasAgente();
        return vidasAgente == 0;
    }

}
