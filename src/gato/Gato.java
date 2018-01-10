package gato;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gato {
    Scanner sc = new Scanner(System.in);
    
    private boolean comprobarCelda(String[][] mat, int fil, int col) {
        boolean val = false;
        
        //Comprobar si la posición está disponible
        //Si no está disponible retorna false
        if(mat[fil][col].equals(" ")) {
           val = true;}
        
        return val;
    }
    
    private boolean comprobarGanador(String[][] mat) {
        String a, b, c;
        boolean gan = false;
        int i = 1;
        

            a = mat[0][0];
            b = mat[0][1];
            c = mat[0][2];
            if((a.equals("x") || a.equals("0")) && a.equals(b) && a.equals(c)){
                gan = true;
            }
            
            a = mat[1][0];
            b = mat[1][1];
            c = mat[1][2];
            if((a.equals("x") || a.equals("0")) && a.equals(b) && a.equals(c)){
                gan = true;
            }
            
            a = mat[2][0];
            b = mat[2][1];
            c = mat[2][2];
            if((a.equals("x") || a.equals("0")) && a.equals(b) && a.equals(c)){
                gan = true;
            }
            
            a = mat[0][0];
            b = mat[1][0];
            c = mat[2][0];
            if((a.equals("x") || a.equals("0")) && a.equals(b) && a.equals(c)){
                gan = true;
            }
            
            a = mat[0][1];
            b = mat[1][1];
            c = mat[2][1];
            if((a.equals("x") || a.equals("0")) && a.equals(b) && a.equals(c)){
                gan = true;
            }
            
            a = mat[0][2];
            b = mat[1][2];
            c = mat[2][2];
            if((a.equals("x") || a.equals("0")) && a.equals(b) && a.equals(c)){
                gan = true;
            }
            
            a = mat[0][0];
            b = mat[1][1];
            c = mat[2][2];
            if((a.equals("x") || a.equals("0")) && a.equals(b) && a.equals(c)){
                gan = true;
            }
            
            a = mat[2][2];
            b = mat[1][1];
            c = mat[0][0];
            if((a.equals("x") || a.equals("0")) && a.equals(b) && a.equals(c)){
                gan = true;}
        
        return gan;
    }
    
    private void imprimirMatriz(String[][] mat) {
        
        String[] pos = new String[9];
        int cont = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                pos[cont] = mat[i][j];
                cont++;
            }
        }
                
        System.out.println("");
        System.out.println("     |     |     ");
        System.out.println("  "+pos[0]+"  |  "+pos[1]+"  |  "+pos[2]+"  ");
        System.out.println("     |     |     ");
        System.out.println("-----------------");
        System.out.println("     |     |     ");
        System.out.println("  "+pos[3]+"  |  "+pos[4]+"  |  "+pos[5]+"  ");
        System.out.println("     |     |     ");
        System.out.println("-----------------");
        System.out.println("     |     |     ");
        System.out.println("  "+pos[6]+"  |  "+pos[7]+"  |  "+pos[8]+"  ");
        System.out.println("     |     |     ");
        
    }
    
    private int ingresarFila() {
        System.out.print("Ingrese fila: ");
        int f = sc.nextInt() - 1;
        return f;
    }
    
    private int ingresarColumna() {
        System.out.print("Ingrese Columna: ");
        int col = sc.nextInt() - 1;
        return col;
    }
    
    public static void main(String[] args) {
        
        Gato g1 = new Gato();
        JFrame ven = new JFrame("Gato");
        
        String[][] gato = new String[3][3];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                gato[i][j] = " ";
            }
        }
        
        System.out.println("************************");
        System.out.println("****** JUEGO GATO ******");
        System.out.println("************************");
        int fil;
        int col;
        boolean val;
        boolean fin = false;
        int i = 0;
        
        System.out.println("");
        System.out.println("         COLUMNAS      ");
        System.out.println("        1     2     3  ");
        System.out.println(" FILAS     |     |     ");
        System.out.println("   1       |     |     ");
        System.out.println("           |     |     ");
        System.out.println("      -----------------");
        System.out.println("           |     |     ");
        System.out.println("   2       |     |     ");
        System.out.println("           |     |     ");
        System.out.println("      -----------------");
        System.out.println("           |     |     ");
        System.out.println("   3       |     |     ");
        System.out.println("           |     |     ");
        
        while(fin == false) {
            
            System.out.println("\nJugador 'X'");
            fil = g1.ingresarFila();
            col = g1.ingresarColumna();
            //System.out.println("Comprobar");
            val = g1.comprobarCelda(gato, fil, col);
            if(val == false) {
                System.out.println("Celda no disponible");
                System.out.println("");
                while(val == false) {
                    g1.imprimirMatriz(gato);
                    fil = g1.ingresarFila();
                    System.out.println("");
                    col = g1.ingresarColumna();
                    val = g1.comprobarCelda(gato, fil, col);
                }
            }
            System.out.println('\u000C');
            gato[fil][col] = "x";
            g1.imprimirMatriz(gato);
            fin = g1.comprobarGanador(gato);
            if(fin == true) {
                System.out.println("*** GANA EL JUGADOR x ***");
                break;
            }
            
            System.out.println("\nJugador '0'");
            fil = g1.ingresarFila();
            col = g1.ingresarColumna();
            val = g1.comprobarCelda(gato, fil, col);
            if(val == false) {
                System.out.println("Celda no disponible");
                System.out.println("");
                
                while(val == false) {
                    g1.imprimirMatriz(gato);
                    fil = g1.ingresarFila();
                    System.out.println("");
                    col = g1.ingresarColumna();
                    val = g1.comprobarCelda(gato, fil, col);
                }
            }
            System.out.println('\u000C');
            gato[fil][col] = "0";
            g1.imprimirMatriz(gato);
            fin = g1.comprobarGanador(gato);
            if(fin == true) {
                System.out.println("*** GANA EL JUGADOR 0 ***");
                break;
            }
        }
        
        System.out.println("\n*** FIN DEL JUEGO ***");
    }
    
}
/*
Comprobar empates
Validar números dentro del arreglo
*/