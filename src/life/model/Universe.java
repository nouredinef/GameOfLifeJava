package life.model;

import java.io.PrintStream;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.Random;

public class Universe {

    private int size;
    private int height;
    private int width;
    private int seed;
    private int nbAlive;
    private int generation;
    private char[][] map;
    private char[][] nextMap;

    public static final char ALIVE = 'O';
    public static final char DEAD = ' ';

    public Universe(int size, int seed) {
        this(size, size, seed);
        this.size = size;
    }

    public Universe(int height, int width, int seed) {
        this.height = height;
        this.width = width;
        this.seed = seed;
        nbAlive = 0;
        generation = 1;
        map = new char[width][height];
        nextMap = new char[width][height];
    }


    public void incrementGeneration() {
        generation++;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public int getNbAlive() {
        return nbAlive;
    }

    public void setNbAlive(int nbAlive) {
        this.nbAlive = nbAlive;
    }

    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public char[][] getNextMap() {
        return nextMap;
    }

    public void setNextMap(char[][] nextMap) {
        this.nextMap = nextMap;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
