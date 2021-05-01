package frsf.isi.tp.caperucita.search.interfaz;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    int espaciado = 3;
    public Bosque bosque = new Bosque();

    public GUI(){
        this.setTitle("Agente Caperucita ");
        this.setSize(855, 580);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setContentPane(bosque);
        setLocationRelativeTo(null);
    }

    public class Bosque extends JPanel {
        int[][] bosque;
        int[] posicionCaperucita;

        public Bosque() {

        }

        public void paintComponent(Graphics g) {
            g.setColor(Color.decode("#93aa55"));
            g.fillRect(0, 0, 855, 580);
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 14; col++) {

                    //Dibujar árbol
                    if (bosque[row][col] == 1) {
                        ImageIcon icon = new ImageIcon("src/images/tree.png");
                        icon.paintIcon(this, g, espaciado + col * 60, espaciado + row * 60);
                    }
                    //Dibujar dulce
                    if (bosque[row][col] == 2) {
                        g.setColor(Color.decode("#f6bf87"));
                        g.fillRoundRect(espaciado + col * 60, espaciado + row * 60, 60 - 2 * espaciado, 60 - 2 * espaciado, 10, 10);
                        ImageIcon icon = new ImageIcon("src/images/dulce.png");
                        icon.paintIcon(this, g, espaciado + col * 60, espaciado + row * 60);
                    }
                    //Dibujar piedra
                    if (bosque[row][col] == 3) {
                        ImageIcon icon = new ImageIcon("src/images/piedra.png");
                        icon.paintIcon(this, g, espaciado + col * 60, espaciado + row * 60);
                    }
                    //Dibujar flores
                    if (bosque[row][col] == 4) {
                        ImageIcon icon = new ImageIcon("src/images/flores.png");
                        icon.paintIcon(this, g, espaciado + col * 60, espaciado + row * 60);
                    }
                    //Dibujar lobo
                    if (bosque[row][col] == 5) {
                        ImageIcon icon = new ImageIcon("src/images/lobo.png");
                        icon.paintIcon(this, g, espaciado + col * 60, espaciado + row * 60);
                    }
                    //Dibujar vacio
                    if (bosque[row][col] == 0) {
                        g.setColor(Color.decode("#f6bf87"));
                        g.fillRoundRect(espaciado + col * 60, espaciado + row * 60, 60 - 2 * espaciado, 60 - 2 * espaciado, 10, 10);
                    }
                    //Dibujar caperucita
                    if(posicionCaperucita[0]==row && posicionCaperucita[1]==col) {
                        ImageIcon icon = new ImageIcon("src/images/caperucita.png");
                        icon.paintIcon(this, g, espaciado + col * 60, espaciado + row * 60);
                    }
                }
            }
        GUI.this.repaint();
        }

        public void setBosque(int[][] bosque) {
            this.bosque=bosque;
        }

        public void setPosicion(int[] posicion) {
            this.posicionCaperucita=posicion;
        }
    }
}
