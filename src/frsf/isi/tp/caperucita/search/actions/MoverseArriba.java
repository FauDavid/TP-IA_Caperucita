package frsf.isi.tp.caperucita.search.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.isi.tp.caperucita.search.EstadoAmbienteCaperucita;
import frsf.isi.tp.caperucita.search.EstadoCaperucita;
import frsf.isi.tp.caperucita.search.PercepcionCaperucita;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MoverseArriba extends SearchAction {

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        EstadoCaperucita estadoCaperucita = (EstadoCaperucita) s;
        int fila = estadoCaperucita.getPosicionFila();
        int columna = estadoCaperucita.getPosicionColumna();
        int[] infoColumna = estadoCaperucita.getColumna(columna);

        //La funcion moverse calcula la cantidad a moverse hasta que algo obstaculice al agente
        int cantidadAMoverse =  estadoCaperucita.moverse(infoColumna, fila, "ARRIBA");

        estadoCaperucita.incrementarMovimientosRealizados(cantidadAMoverse);
        fila = fila - cantidadAMoverse;

        estadoCaperucita.setPosicionFila(fila);

        return estadoCaperucita;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbienteCaperucita estadoAmbiente = (EstadoAmbienteCaperucita) est;
        EstadoCaperucita estadoCaperucita = ((EstadoCaperucita) ast);

        int fila = estadoCaperucita.getPosicionFila();
        int columna = estadoCaperucita.getPosicionColumna();
        int[] infoColumna = estadoCaperucita.getColumna(columna);

        int cantidadAMoverse =  estadoCaperucita.moverse(infoColumna, fila, "ARRIBA");

        estadoCaperucita.incrementarMovimientosRealizados(cantidadAMoverse);
        fila = fila - cantidadAMoverse;

        estadoCaperucita.setPosicionFila(fila);
        estadoAmbiente.setPosicionAgente(new int[]{fila, columna});

        return estadoAmbiente;
    }

    @Override
    public String toString() {
        return "MoverseArriba";
    }

    @Override
    public Double getCost() {
        return new Double(0);
    }
}
