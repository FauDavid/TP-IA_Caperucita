package frsf.isi.tp.caperucita.search;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.*;
import frsf.isi.tp.caperucita.search.actions.*;
import frsf.isi.tp.caperucita.search.interfaz.GUI;

import java.rmi.NotBoundException;
import java.security.PublicKey;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgenteCaperucita extends SearchBasedAgent {

    public AgenteCaperucita() {

        ObjetivoCaperucita objetivoCaperucita = new ObjetivoCaperucita();

        EstadoCaperucita estado = new EstadoCaperucita();

        this.setAgentState(estado);

        Vector<SearchAction> operadores = new Vector<SearchAction>();
        operadores.addElement(new MoverseArriba());
        operadores.addElement(new MoverseAbajo());
        operadores.addElement(new MoverseDerecha());
        operadores.addElement(new MoverseIzquierda());
        operadores.addElement(new TomarDulce());

        EstadoCaperucita estadoCaperucita = (EstadoCaperucita) this.getAgentState();
        Problem problem = new Problem(objetivoCaperucita, estadoCaperucita, operadores);
        this.setProblem(problem);

    }

    @Override
    public Action selectAction() {

        /*Método de Búsqueda en Profundidad
        DepthFirstSearch strategy = new DepthFirstSearch();
        */

        /*Método de Búsqueda en Anchura
        BreathFirstSearch strategy = new BreathFirstSearch();
        */

        /*Método de Búsqueda Avara
        IEstimatedCostFunction heuristic = new Heuristica();
        GreedySearch strategy = new GreedySearch(heuristic);
        */

        /*Método de Búsqueda A*
        IStepCostFunction cost = new FuncionCosto();
        IEstimatedCostFunction heuristic = new Heuristica();
        AStarSearch strategy = new AStarSearch(cost, heuristic);
        */

        /*Método de Costo Uniforme
         IStepCostFunction costFunction = new FuncionCosto();
         UniformCostSearch strategy = new UniformCostSearch(costFunction);
          */

        IStepCostFunction costFunction = new FuncionCosto();
        UniformCostSearch strategy = new UniformCostSearch(costFunction);

        Search searchSolver = new Search(strategy);

        searchSolver.setVisibleTree(Search.EFAIA_TREE);

        this.setSolver(searchSolver);

        Action selectedAction = null;
        try {
            selectedAction = this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(AgenteCaperucita.class.getName()).log(Level.SEVERE, null, ex);
        }

        return selectedAction;
    }

    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }



}
