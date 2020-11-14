package life.presentation;

import life.model.Universe;

import javax.swing.*;
import java.awt.*;

public class SwingWindowPrint extends JFrame {
    private final String GENERATION_LBL = "Generation #";
    private final String ALIVE_LBL = "Alive : ";
    private final String SEED_LBL = "Seed : ";

    private Universe universe;
    private int gridHeight;
    private int gridWidth;
    public final static int V_GAP = 2;
    public final static int H_GAP = 2;



    private JPanel infoPnl;
    private JPanel geneAlivePnl;
    private JLabel generationsLbl;
    private JLabel aliveCountLbl;

    private JPanel seedPnl;
    private JLabel seedLbl;

    private JPanel gridPnl;
    private JPanel btnPnl;
    private JLabel[][] gridLblMap;

    private JToggleButton startStopBtn;
    private JButton nextGenBtn;

    private JButton restartBtn;

    public SwingWindowPrint() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setVisible(true);
        setLayout(new BorderLayout());

        init();
    }

    private void init() {
        /* for future upgrade :
         if universe == null
         popup asking size and max generations
         blank grid
         clicking makes alive.
         ==> init a universe with these values. (no seed showed)
         */

        // North Panel = informations
        infoPnl = new JPanel();
        infoPnl.setLayout(new BorderLayout());
        geneAlivePnl = new JPanel();
        geneAlivePnl.setLayout(new BoxLayout(geneAlivePnl, BoxLayout.Y_AXIS));

        generationsLbl = new JLabel("Generation #0");
        generationsLbl.setName("GenerationLabel");
//        generationsLbl.setText("Generation #" + universe.getGeneration());
        geneAlivePnl.add(generationsLbl);

        aliveCountLbl = new JLabel("Alive: 0");
        aliveCountLbl.setName("AliveLabel");
//        aliveCountLbl.setText("Alive: " + universe.getNbAlive());
        geneAlivePnl.add(aliveCountLbl);

        seedPnl = new JPanel();
        seedLbl = new JLabel("SeedLabel");
        seedLbl.setText("Seed : ");
//        seedLbl.setText("Seed : " + universe.getSeed());
        seedPnl.add(seedLbl);

        infoPnl.add(geneAlivePnl, BorderLayout.WEST);
        infoPnl.add(seedLbl, BorderLayout.EAST);

        add(infoPnl, BorderLayout.NORTH);

        // Center Panel = The GRID !!
        gridPnl = new JPanel();
        gridPnl.setLayout(new GridLayout(10,10, 5, 5));

        GridLayout gly = new GridLayout();

        ///////////////////////////////
        //////////////////////////////
        gridPnl.setBackground(Color.LIGHT_GRAY);



        for (int i = 0; i < (10*10); i++) {
            final JLabel lbl = new JLabel();
            lbl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
//            lbl.setBackground(Color.DARK_GRAY);
            gridPnl.add(lbl);
        }



//        gridPnl.setLayout(new GridLayout(n, n));
//        gridPnl.setMinimumSize(new Dimension(555,444));
        add(gridPnl, BorderLayout.CENTER);

        // South Panel = Buttons
        btnPnl = new JPanel();

        startStopBtn = new JToggleButton();
        startStopBtn.setName("PlayToggleButton");
        startStopBtn.setText("Start");
        startStopBtn.addActionListener(e -> manageCalculationThread());
        btnPnl.add(startStopBtn);
        
        nextGenBtn = new JButton("Next Gen.");
        nextGenBtn.addActionListener(e -> printNextGen());
        btnPnl.add(startStopBtn);

        restartBtn = new JButton("New grid");
        restartBtn.setName("ResetButton");
        restartBtn.addActionListener(e -> initUniverse());
        btnPnl.add(restartBtn);

        add(btnPnl, BorderLayout.SOUTH);
    }

    public void printUniverse( Universe universe) {
        generationsLbl.setText(GENERATION_LBL + universe.getGeneration());
        aliveCountLbl.setText(ALIVE_LBL + universe.getNbAlive());
        seedLbl.setText(SEED_LBL + universe.getSeed());
        gridLblMap = new JLabel[universe.getWidth()][universe.getHeight()];

        int width = universe.getWidth();
        int height = universe.getHeight();
        char[][] map = universe.getMap();
        gridPnl.removeAll();
        gridPnl.setLayout(new GridLayout(width, height, V_GAP, H_GAP));
        //gridPnl.setBackground(Color.LIGHT_GRAY);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                gridLblMap[i][j] = new JLabel();
                JLabel lbl = gridLblMap[i][j];
//                lbl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                lbl.setOpaque(true);
                lbl.setToolTipText("cell [" + i + "," + j + "]");
                if (map[i][j] == Universe.ALIVE) {
                    lbl.setBackground(Color.BLACK);
                    lbl.setForeground(Color.BLACK);
                } else {
                    lbl.setBackground(Color.WHITE);
                    lbl.setForeground(Color.WHITE);
                }
                gridPnl.add(lbl);
            }
        }
        gridPnl.updateUI();
    }


    private void printNextGen() {
    }

    private void initUniverse() {
    }

    private void manageCalculationThread() {

    }

}
