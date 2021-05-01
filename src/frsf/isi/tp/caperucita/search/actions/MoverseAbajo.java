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

public class MoverseAbajo extends SearchAction {

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        EstadoCaperucita estadoCaperucita = (EstadoCaperucita) s;

        int fila = estadoCaperucita.getPosicionFila();
        int columna = estadoCaperucita.getPosicionColumna();
        int[] infoColumna = estadoCaperucita.getColumna(columna);
        int cantidadAMoverse = estadoCaperucita.moverse(infoColumna, fila, "ABAJO");

        if (cantidadAMoverse > 0) {
            estadoCaperucita.incrementarMovimientosRealizados(1);
            fila = fila + cantidadAMoverse;
            estadoCaperucita.setPosicionFila(fila);

            //Si se encuentra con el lobo --> No ocurre ya que dentro de moverse está contemplado el hecho de "esquivar" la fila o columna que lo contiene
            if (estadoCaperucita.getBosque()[fila][columna] == PercepcionCaperucita.PERCEPCION_LOBO) {
                estadoCaperucita.setCantidadDulces(0);
                estadoCaperucita.setPosicionCaperucita(estadoCaperucita.getPosicionInicial());
                estadoCaperucita.setCantidadVidas(estadoCaperucita.getCantidadVidas() - 1);
                return estadoCaperucita;
            }
            return estadoCaperucita;
        }

            return null;
        }

        @Override
        public EnvironmentState execute (AgentState ast, EnvironmentState est){
            EstadoAmbienteCaperucita estadoAmbiente = (EstadoAmbienteCaperucita) est;
            EstadoCaperucita estadoCaperucita = (EstadoCaperucita) ast;

            int fila = estadoCaperucita.getPosicionFila();
            int columna = estadoCaperucita.getPosicionColumna();
            int[] infoColumna = estadoCaperucita.getColumna(columna);
            int cantidadAMoverse = estadoCaperucita.moverse(infoColumna, fila, "ABAJO");

            if (cantidadAMoverse > 0) {
                estadoCaperucita.incrementarMovimientosRealizados(1);
                fila = fila + cantidadAMoverse;
                estadoCaperucita.setPosicionFila(fila);
                estadoAmbiente.setPosicionAgente(new int[]{fila, columna});

                //Si se encuentra con el lobo --> No ocurre ya que dentro de moverse está contemplado el hecho de "esquivar" la fila o columna que lo contiene
                if (estadoCaperucita.getBosque()[fila][columna] == PercepcionCaperucita.PERCEPCION_LOBO) {
                    estadoCaperucita.setCantidadDulces(0);
                    estadoCaperucita.setPosicionCaperucita(estadoCaperucita.getPosicionInicial());
                    estadoCaperucita.setCantidadVidas(estadoCaperucita.getCantidadVidas() - 1);
                    estadoAmbiente.setCantidadDulcesAgente(0);
                    estadoAmbiente.setCantidadVidasAgente(estadoAmbiente.getCantidadVidasAgente() - 1);
                    estadoAmbiente.setPosicionAgente(estadoCaperucita.getPosicionInicial());
                    return estadoAmbiente;
                }
                return estadoAmbiente;
            }



            return null;

        }

        @Override
        public String toString () {
            return "MoverseAbajo";
        }

        @Override
        public Double getCost () {
            return new Double(0);
        }
    }
