package frsf.isi.tp.caperucita.search.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.isi.tp.caperucita.search.EstadoAmbienteCaperucita;
import frsf.isi.tp.caperucita.search.EstadoCaperucita;
import frsf.isi.tp.caperucita.search.PercepcionCaperucita;

public class TomarDulce extends SearchAction {

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        EstadoCaperucita estadoCaperucita = (EstadoCaperucita) s;

        int row = estadoCaperucita.getPosicionFila();
        int col = estadoCaperucita.getPosicionColumna();

        if (estadoCaperucita.getBosque()[row][col] == PercepcionCaperucita.PERCEPCION_DULCE) {
            estadoCaperucita.setPosicionBosque(row, col, PercepcionCaperucita.PERCEPCION_VACIO);
            estadoCaperucita.incrementarDulces(this.getCost());
            return estadoCaperucita;
        }

        return null;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbienteCaperucita estadoAmbienteCaperucita = (EstadoAmbienteCaperucita) est;
        EstadoCaperucita estadoCaperucita = ((EstadoCaperucita) ast);

        int row = estadoAmbienteCaperucita.getPosicionAgente()[0];
        int col = estadoAmbienteCaperucita.getPosicionAgente()[1];

        if (estadoCaperucita.getBosque()[row][col] == PercepcionCaperucita.PERCEPCION_DULCE) {
            estadoAmbienteCaperucita.setPosicionBosque(row, col, PercepcionCaperucita.PERCEPCION_VACIO);
            estadoAmbienteCaperucita.setCantidadDulcesAgente(estadoCaperucita.getCantidadDulces());
            estadoCaperucita.setPosicionBosque(row, col, PercepcionCaperucita.PERCEPCION_VACIO);
            estadoCaperucita.incrementarDulces(this.getCost());
            return estadoAmbienteCaperucita;
        }

        return null;
    }

    @Override
    public String toString() {
        return "TomarDulce";
    }

    @Override
    public Double getCost() {
        return new Double(1);
    }
}
