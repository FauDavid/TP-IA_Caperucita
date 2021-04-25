package frsf.isi.tp.caperucita.search;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;


/**
 * This class allows to define a function to be used by any
 * informed search strategy, like A Star or Greedy.
 */

public class Heuristica implements IEstimatedCostFunction {

    /**
     * It returns the estimated cost to reach the goal from a NTree node.
     */

    @Override
    public double getEstimatedCost(NTree node) {
        EstadoCaperucita estadoCaperucita = (EstadoCaperucita) node.getAgentState();
        return (estadoCaperucita.getDistanciaAFlores());
    }
}
