package frsf.isi.tp.caperucita.search;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.state.EnvironmentState;

import java.util.Random;

public class EstadoAmbienteCaperucita extends EnvironmentState {
    private int[][] bosque;
    private int[] posicionAgente;
    private int cantidadVidasAgente;
    private int cantidadDulcesAgente;
    private int[] posicionLobo;
    private int[] posicionFlores;

    public EstadoAmbienteCaperucita(int[][] bosque, int[] posicionAgente, int[] posicionFlores, int[] posicionLobo, int cantidadVidasAgente, int cantidadDulcesAgente) {
        this.bosque = bosque;
        this.posicionAgente = posicionAgente;
        this.cantidadVidasAgente = cantidadVidasAgente;
        this.cantidadDulcesAgente = cantidadDulcesAgente;
        this.posicionFlores = posicionFlores;
        this.posicionLobo = posicionLobo;
    }

    public EstadoAmbienteCaperucita() {
        bosque = new int[9][14];
        this.initState();
    }

    @Override
    public void initState() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 14; col++) {
                bosque[row][col] = PercepcionCaperucita.PERCEPCION_ARBOL;
            }
        }

        escenario1();
        //escenario2();
        //escenario3();

        this.setCantidadVidasAgente(3);
        this.setCantidadDulcesAgente(0);
    }

    private void escenario1() {

        //Escenario 1
        bosque[1][3] = PercepcionCaperucita.PERCEPCION_DULCE;
        bosque[1][4] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[1][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[1][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[1][8] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[1][9] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[1][10] = PercepcionCaperucita.PERCEPCION_DULCE;

        bosque[2][3] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][7] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][8] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][9] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][10] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][11] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[3][3] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][4] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][7] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][8] = PercepcionCaperucita.PERCEPCION_DULCE;
        bosque[3][10] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][11] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[4][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][7] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][9] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][10] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][11] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[5][3] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][7] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][8] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][9] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][10] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][11] = PercepcionCaperucita.PERCEPCION_VACIO;

//      bosque[6][4] = PercepcionCaperucita.PERCEPCION_LOBO;
        bosque[6][3] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[6][8] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[6][10] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[7][3] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[7][4] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[7][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[7][7] = PercepcionCaperucita.PERCEPCION_FLORES;
        bosque[7][8] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[7][9] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[7][10] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[8][9] = PercepcionCaperucita.PERCEPCION_PIEDRA;

        this.setPosicionAgente(new int[]{5, 11});
        this.setPosicionFlores(new int[]{7, 7});

        Random rand = new Random();
        int fil = rand.nextInt(9);
        int col = rand.nextInt(14);
        bosque[fil][col] = PercepcionCaperucita.PERCEPCION_LOBO;
        this.setPosicionLobo(new int[]{fil,col});

        this.setBosque(bosque);
    }

    private void escenario2() {

        //Escenario 2
        bosque[1][5] = PercepcionCaperucita.PERCEPCION_DULCE;
        bosque[1][6] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[2][4] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][9] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[3][3] = PercepcionCaperucita.PERCEPCION_PIEDRA;
        bosque[3][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][7] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][8] = PercepcionCaperucita.PERCEPCION_DULCE;
        bosque[3][9] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][10] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[4][3] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][8] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][10] = PercepcionCaperucita.PERCEPCION_DULCE;

        bosque[5][3] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][4] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][8] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][9] = PercepcionCaperucita.PERCEPCION_PIEDRA;
        bosque[5][10] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[6][3] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[6][4] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[6][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[6][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[6][7] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[6][8] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[6][10] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[7][6] = PercepcionCaperucita.PERCEPCION_FLORES;
        bosque[7][8] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[7][9] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[7][10] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[8][6] = PercepcionCaperucita.PERCEPCION_FLORES;

        this.setPosicionLobo(new int[]{6,4});
        this.setPosicionFlores(new int[]{7,6});
        this.setPosicionAgente(new int[]{6, 3});
        this.setBosque(bosque);
    }

    private void escenario3() {

        //Escenario 3
        bosque[0][3] = PercepcionCaperucita.PERCEPCION_FLORES;

        bosque[1][3] = PercepcionCaperucita.PERCEPCION_FLORES;
        bosque[1][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[1][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[1][7] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[2][3] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[2][6] = PercepcionCaperucita.PERCEPCION_PIEDRA;
        bosque[2][7] = PercepcionCaperucita.PERCEPCION_DULCE;

        bosque[3][2] = PercepcionCaperucita.PERCEPCION_PIEDRA;
        bosque[3][3] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][4] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][7] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][8] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[3][10] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[4][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][7] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][8] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][9] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][10] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[4][11] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[5][3] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][4] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][8] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][10] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[5][11] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[6][3] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[6][4] = PercepcionCaperucita.PERCEPCION_DULCE;
        bosque[6][5] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[6][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[6][8] = PercepcionCaperucita.PERCEPCION_DULCE;
        bosque[6][9] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[6][10] = PercepcionCaperucita.PERCEPCION_PIEDRA;
        bosque[6][11] = PercepcionCaperucita.PERCEPCION_VACIO;

        bosque[7][6] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[7][7] = PercepcionCaperucita.PERCEPCION_VACIO;
        bosque[7][8] = PercepcionCaperucita.PERCEPCION_VACIO;

        this.setPosicionAgente(new int[]{4, 11});
        this.setBosque(bosque);
    }

    public Object clone() {
        int[][] nuevoBosque = new int[9][14];

        for (int fil = 0; fil < 8; fil++) {
            for (int col = 0; col < 13; col++) {
                nuevoBosque[fil][col] = this.bosque[fil][col];
            }
        }

        EstadoAmbienteCaperucita nuevoEstado = new EstadoAmbienteCaperucita(nuevoBosque, this.posicionAgente, this.posicionFlores, this.posicionLobo, this.cantidadVidasAgente, this.cantidadDulcesAgente);

        return nuevoEstado;
    }

    public int[] getPosicionLobo() {
        return posicionLobo;
    }

    public void setPosicionLobo(int[] posicionLobo) {
        this.posicionLobo = posicionLobo;
    }

    public int[] getPosicionFlores() {
        return posicionFlores;
    }

    public void setPosicionFlores(int[] posicionFlores) {
        this.posicionFlores = posicionFlores;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append(" \n");
        for (int row = 0; row < 9; row++) {
            str.append(" ");
            for (int col = 0; col < 14; col++) {
                if (bosque[row][col] == 0) {
                    if(getPosicionAgente()[0]==row && getPosicionAgente()[1]==col){
                        str.append("C   ");
                    }
                    else{
                        str.append("_   ");
                    }
                }
                if (bosque[row][col] == 1) {
                    str.append("A   ");
                }
                if (bosque[row][col] == 2) {
                    str.append("D   ");
                }
                if (bosque[row][col] == 3) {
                    str.append("P   ");
                }
                if (bosque[row][col] == 4) {
                    str.append("F   ");
                }
                if (bosque[row][col] == 5) {
                    str.append("L   ");
                }
            }
            str.append(" \n");
        }


        return str.toString();
    }

    public int[] getColumna(int columna){
        int[] infoColumna = new int[9];
        for(int row = 0; row < 9; row++) {
            infoColumna[row] = bosque[row][columna];
        }
        return infoColumna;
    }

    public int[] getFila(int fila) {
        int[] infoFila = new int[14];
        for(int columna = 0; columna < 14; columna++){
            infoFila[columna] = bosque[fila][columna];
        }
        return infoFila;
    }

    public int[][] getBosque() {
        return bosque;
    }

    public void setBosque(int[][] bosque) {
        this.bosque = bosque;
    }

    public int[] getPosicionAgente() {
        return posicionAgente;
    }

    public void setPosicionAgente(int[] posicionAgente) {
        this.posicionAgente = posicionAgente;
    }

    public int getCantidadVidasAgente() {
        return cantidadVidasAgente;
    }

    public void setCantidadVidasAgente(int cantidadVidasAgente) {
        this.cantidadVidasAgente = cantidadVidasAgente;
    }

    public void setPosicionBosque(int row, int col, int percepcionVacio) {
        this.bosque[row][col] = percepcionVacio;
    }

    public int getCantidadDulcesAgente() {
        return cantidadDulcesAgente;
    }

    public void setCantidadDulcesAgente(int cantidadDulcesAgente) {
        this.cantidadDulcesAgente = cantidadDulcesAgente;
    }



}
