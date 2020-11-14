package life.presentation;

import life.model.Universe;

import java.io.PrintStream;
import java.util.Arrays;

public class ConsolePrint {
    private PrintStream out = System.out;

    public void printUniverse (Universe universe) {
        int generation = universe.getGeneration();
        int nbAlive = universe.getNbAlive();
        int size = universe.getSize();
        char[][] map = universe.getMap();

        out.println("Generation #" + generation);
        out.println("Alive: " + nbAlive);
        out.println();
        
        
        
        
        

    }

    public void prettyPrintUniverse(Universe universe) {
        int generation = universe.getGeneration();
        int nbAlive = universe.getNbAlive();
        int size = universe.getSize();
        int seed = universe.getSeed();
        char[][] map = universe.getMap();
        char[] ligne = new char[size + 2];
        Arrays.fill(ligne,'-');

        out.println("Generation #" + generation);
        out.println("Alive: " + nbAlive);
        out.println("Seed: " + seed);
        out.println(ligne);
        for (int i = 0; i < size; i++) {
            out.print("|");
            for (int j = 0; j < size; j++) {
                out.print(map[i][j]);
            }
            out.println("|");
        }
        out.println(ligne);
    }

    public PrintStream getOut() {
        return out;
    }

    public void setOut(PrintStream out) {
        this.out = out;
    }
}
