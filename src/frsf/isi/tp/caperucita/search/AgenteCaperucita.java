package frsf.isi.tp.caperucita.search;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.Search;
import frsf.isi.tp.caperucita.search.actions.*;

import java.security.PublicKey;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgenteCaperucita extends SearchBasedAgent {

    public AgenteCaperucita() {

        ObjetivoCaperucita objetivoCaperucita = new ObjetivoCaperucita();

        EstadoCaperucita estadoCaperucita = new EstadoCaperucita();
        this.setAgentState(estadoCaperucita);

        Vector<SearchAction> operadores = new Vector<SearchAction>();
        operadores.addElement(new TomarDulce());
        operadores.addElement(new MoverseArriba());
        operadores.addElement(new MoverseIzquierda());
        operadores.addElement(new MoverseAbajo());
        operadores.addElement(new MoverseDerecha());


        Problem problem = new Problem(objetivoCaperucita, estadoCaperucita, operadores);
        this.setProblem(problem);

    }

    @Override
    public Action selectAction() {
        DepthFirstSearch strategy = new DepthFirstSearch();
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
