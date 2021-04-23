package frsf.isi.tp.caperucita.search;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class CaperucitaMain {

    public static void main(String[] args) throws PrologConnectorException {
        AgenteCaperucita caperucita = new AgenteCaperucita();

        AmbienteCaperucita ambienteCaperucita = new AmbienteCaperucita();

        SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(ambienteCaperucita, caperucita);

        simulator.start();
    }

}
