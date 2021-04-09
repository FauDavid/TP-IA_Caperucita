package frsf.isi.tp.caperucita.search.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.isi.tp.caperucita.search.EstadoAmbienteCaperucita;
import frsf.isi.tp.caperucita.search.EstadoCaperucita;
import frsf.isi.tp.caperucita.search.PercepcionCaperucita;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MoverseDerecha extends SearchAction {

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        EstadoCaperucita estadoCaperucita = (EstadoCaperucita) s;
        int fila = estadoCaperucita.getPosicionFila();
        int columna = estadoCaperucita.getPosicionColumna();
        int[] infoFila = estadoCaperucita.getFila(fila);

        if (!estadoCaperucita.hayLobo(infoFila)) {
            columna = columna + estadoCaperucita.moverse(infoFila, columna, "DERECHA");
        }

        estadoCaperucita.setPosicionColumna(columna);

        return estadoCaperucita;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbienteCaperucita estadoAmbiente = (EstadoAmbienteCaperucita) est;
        EstadoCaperucita estadoCaperucita = (EstadoCaperucita) ast;

        int fila = estadoCaperucita.getPosicionFila();
        int columna = estadoCaperucita.getPosicionColumna();
        int[] infoFila = estadoCaperucita.getFila(fila);

        if (!estadoCaperucita.hayLobo(infoFila)) {
            columna = columna + estadoCaperucita.moverse(infoFila, columna, "DERECHA");
        }

        estadoCaperucita.setPosicionColumna(columna);
        estadoAmbiente.setPosicionAgente(new int[]{fila, columna});

        return estadoAmbiente;
    }

    @Override
    public String toString() {
        return "MoverseDerecha";
    }


    @Override
    public Double getCost() {
        return new Double(0);
    }
}
