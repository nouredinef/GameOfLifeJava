package life;

import life.model.Universe;
import life.presentation.SwingWindowPrint;

import life.service.Algorithm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Type the size of the Universe to generate :");
//        int n = sc.nextInt();
//        sc.close();
        int n = 50;
        int m = 5; // max Iterations
        Algorithm algoService = new Algorithm();
        algoService.initUniverse(n);
        Universe universe = algoService.getUniverse();

//
        Thread th = new Thread(() -> {
            SwingWindowPrint game = new SwingWindowPrint();
            try {
                System.out.println("Preparing first generation ...");
                Thread.sleep(10);
                for (int i = 0; i < m; i++) {
                    System.out.println("Printing generation #" + +i);
                    game.printUniverse(universe);
                    Thread.sleep(1000);
                    System.out.println("Computing generation #" + (i+1));
                    algoService.computeNextGen();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        th.start();



    }

}


