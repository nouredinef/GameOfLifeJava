package life.service;

import life.model.Universe;

import java.util.Random;

public class Algorithm {
    private Universe universe;

    public void initUniverse(int size, int seed) {
        this.universe = new Universe(size, seed);
        Random rnd = new Random(seed);
        char[][] map = universe.getMap();
        int nbAlive = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (rnd.nextBoolean()) {
                    map[i][j] = Universe.ALIVE;
                    universe.setNbAlive(++nbAlive);
                } else {
                    map[i][j] = Universe.DEAD;
                }
            }
        }
    }

    public void initUniverse(int size) {
        int seed = (int)(Math.random()*Integer.MAX_VALUE);
        initUniverse(size, seed);
    }

    private byte getAliveNeighbours(char[][] map, int row, int col) {
        int size = map.length;
        byte count = 0;

        int up = (row == 0) ? size - 1 : row - 1;
        int down = (row == size - 1) ? 0 : row + 1;
        int left = (col == 0) ? size - 1 : col - 1;
        int right = (col == size - 1) ? 0 : col + 1;

        char[] neighbours = new char[8];

        neighbours[0] = map[up][col]; // north
        neighbours[1] = map[down][col]; //south
        neighbours[2] = map[row][left]; // west
        neighbours[3] = map[row][right]; // east

        neighbours[4] = map[up][right]; // northEast
        neighbours[5] = map[up][left]; // northWest
        neighbours[6] = map[down][right]; // southEast
        neighbours[7] = map[down][left]; // southWest

        for (char cell : neighbours) {
            if (cell == Universe.ALIVE) count++;
        }

        return count;
    }

    public void computeNextGen() {
        int aliveCount = 0;
        int size = universe.getSize();
        char[][] map = universe.getMap();
        char[][] newMap = new char[size][size];//universe.getNextMap();//

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                char cell = map[i][j];
                int neighbours = getAliveNeighbours(map, i, j);

                if (cell == Universe.ALIVE) {
                    if (neighbours == 2 || neighbours == 3) {
                        newMap[i][j] = Universe.ALIVE;
                        aliveCount++;
                    } else {
                        newMap[i][j] = Universe.DEAD;
                    }
                } else {
                    if (neighbours == 3) {
                        newMap[i][j] = Universe.ALIVE;
                        aliveCount++;
                    } else {
                        newMap[i][j] = Universe.DEAD;
                    }

                }
            }
        }
        universe.setNbAlive(aliveCount);
        universe.setMap(newMap);
        universe.incrementGeneration();
    }

    public Universe getUniverse() {
        return universe;
    }
}
