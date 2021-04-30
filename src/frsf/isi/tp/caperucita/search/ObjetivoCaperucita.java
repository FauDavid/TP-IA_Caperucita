package frsf.isi.tp.caperucita.search;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoCaperucita extends GoalTest {

    @Override
    public boolean isGoalState(AgentState estadoAgente) {
        if(((EstadoCaperucita) estadoAgente).estaEnFlores() && ((EstadoCaperucita) estadoAgente).getCantidadVidas() > 0){
            return true;
        }
        return false;
    }
}
