package frsf.isi.tp.caperucita.search.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.isi.tp.caperucita.search.EstadoAmbienteCaperucita;
import frsf.isi.tp.caperucita.search.EstadoCaperucita;
import frsf.isi.tp.caperucita.search.PercepcionCaperucita;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MoverseAbajo extends SearchAction {

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        EstadoCaperucita estadoCaperucita = (EstadoCaperucita) s;
        int fila = estadoCaperucita.getPosicionFila();
        List<Integer> informacionFila = Arrays.stream(estadoCaperucita.getFila(fila)).boxed().collect(Collectors.toList());
        informacionFila.subList(fila,9);

        if (!informacionFila.contains(PercepcionCaperucita.PERCEPCION_LOBO)) {
            int proximaFila = fila;
            while( !(informacionFila.contains(PercepcionCaperucita.PERCEPCION_PIEDRA) || informacionFila.contains(PercepcionCaperucita.PERCEPCION_ARBOL))){
                proximaFila++;
            }
            estadoCaperucita.setPosicionFila(proximaFila);
        }

        return estadoCaperucita;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbienteCaperucita estadoAmbiente = (EstadoAmbienteCaperucita) est;
        EstadoCaperucita estadoCaperucita = ((EstadoCaperucita) ast);
        int fila = estadoCaperucita.getPosicionFila();
        List<Integer> informacionFila = Arrays.stream(estadoCaperucita.getFila(fila)).boxed().collect(Collectors.toList());
        informacionFila.subList(fila,9);

        if (!informacionFila.contains(PercepcionCaperucita.PERCEPCION_LOBO)) {
            int proximaFila = fila;
            while( !(informacionFila.contains(PercepcionCaperucita.PERCEPCION_PIEDRA) || informacionFila.contains(PercepcionCaperucita.PERCEPCION_ARBOL))){
                proximaFila++;
            }
            estadoCaperucita.setPosicionFila(proximaFila);
        }

        estadoAmbiente.setPosicionAgente(new int[] {estadoCaperucita.getPosicionFila(),estadoCaperucita.getPosicionColumna()});

        return estadoAmbiente;

    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Double getCost() {
        return null;
    }
}
