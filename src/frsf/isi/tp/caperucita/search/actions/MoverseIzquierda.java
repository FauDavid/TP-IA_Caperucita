package frsf.isi.tp.caperucita.search.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.isi.tp.caperucita.search.EstadoAmbienteCaperucita;
import frsf.isi.tp.caperucita.search.EstadoCaperucita;
import frsf.isi.tp.caperucita.search.PercepcionCaperucita;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoverseIzquierda extends SearchAction {

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        EstadoCaperucita estadoCaperucita = (EstadoCaperucita) s;

        int fila = estadoCaperucita.getPosicionFila();
        int columna = estadoCaperucita.getPosicionColumna();
        int[] infoFila = estadoCaperucita.getFila(fila);

        int proxColumna = columna - estadoCaperucita.moverse(infoFila, columna, "IZQUIERDA");

        estadoCaperucita.setPosicionColumna(proxColumna);

        return estadoCaperucita;
}

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbienteCaperucita estadoAmbiente = (EstadoAmbienteCaperucita) est;
        EstadoCaperucita estadoCaperucita = (EstadoCaperucita) ast;

        int fila = estadoCaperucita.getPosicionFila();
        int columna = estadoCaperucita.getPosicionColumna();
        int[] infoFila = estadoCaperucita.getFila(fila);

        int proxColumna = columna - estadoCaperucita.moverse(infoFila, columna, "IZQUIERDA");

        estadoCaperucita.setPosicionColumna(proxColumna);
        estadoAmbiente.setPosicionAgente(new int[]{fila, proxColumna});

        return estadoAmbiente;
    }

    @Override
    public String toString() {
        return "MoverseIzquierda";
    }

    @Override
    public Double getCost() {
        return new Double(0);
    }
}
