package View;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;
import Model.Board;
public class BoardGraphics extends JPanel implements MouseListener {
    private static final Color blue = Color.decode("#0008ff"); // Blue Colour Hex Code
    private static final Color red = Color.decode("#ff1e00"); // Red Colour Hex Code
    private static final Color white = Color.decode("#FFFFFF"); // White Colour Hex Code
    private static final Color black = Color.decode("#000000"); // Black Colour  Hex Code
    private static final Color yellow = Color.decode("#FFFF00"); // Yellow Colour Hex Code
    private static final Color purple = Color.decode("#800080"); // Purple Colour Hex Code
    private static final Color orange = Color.decode("#FFA500"); // Orange Colour Hex Code
    private static final Color green = Color.green;
    private final int ROWS = 8; //default size
    private final int COLS = 10;
    private int squareSize = 134; // (1080 / 80) - 1
    private boolean isItYellow = false; // Used to check if the color is yellow
    public Board board;
    public JLabel[][] pawns = new JLabel[ROWS][COLS];
    JFrame frame = new JFrame("Stratego");
    List<Point> possibleMoves = new ArrayList<>();


    //Red team
    String dragonIconR = ("images/RedPieces/DragonR.png");
    String mageIconR = ("images/RedPieces/MageR.png");
    String knightIconR = ("images/RedPieces/KnightR.png");
    String beastriderIconR = ("images/RedPieces/BeastRiderR.png");
    String sorceressIconR = ("images/RedPieces/SorceressR.png");
    String lavabeastIconR = ("images/RedPieces/LavaBeastR.png");
    String elfIconR = ("images/RedPieces/ElfR.png");
    String dwarfIconR = ("images/RedPieces/DwarfR.png");
    String scoutIconR = ("images/RedPieces/ScoutR.png");
    String slayerIconR = ("images/RedPieces/SlayerR.png");
    String trapIconR = ("images/RedPieces/TrapR.png");
    String flagIconR = ("images/RedPieces/FlagR.png");
    String redHiddenIcon = ("images/RedPieces/redHidden.png");
    //Blue team
    String yetiIconB = ("images/bluePieces/YetiB.png");
    String dragonIconB = ("images/bluePieces/DragonB.png");
    String mageIconB = ("images/bluePieces/MageB.png");
    String knightIconB = ("images/bluePieces/KnightB.png");
    String beastriderIconB = ("images/bluePieces/BeastRiderB.png");
    String sorceressIconB = ("images/bluePieces/SorceressB.png");
    String elfIconB = ("images/bluePieces/ElfB.png");
    String dwarfIconB = ("images/bluePieces/DwarfB.png");
    String scoutIconB = ("images/bluePieces/ScoutB.png");
    String slayerIconB = ("images/bluePieces/SlayerB.png");
    String trapIconB = ("images/bluePieces/TrapB.png");
    
    String flagIconB = ("images/bluePieces/FlagB.png");
    String blueHiddenIcon = ("images/bluePieces/BlueHidden.png");


    

    public BoardGraphics(Board board) {
        setPreferredSize(new Dimension(1920, 1080));
        this.board = board;
        CreateBoard();
    }


    public static String getRandom(ArrayList<String> array) {
        Random random = new Random();
        int index = random.nextInt(array.size());
        return array.get(index);
    }
    public String[] blueImages = {yetiIconB,yetiIconB,dragonIconB,mageIconB,knightIconB,knightIconB,beastriderIconB,beastriderIconB,beastriderIconB,sorceressIconB,sorceressIconB,elfIconB,elfIconB,dwarfIconB,dwarfIconB,dwarfIconB,dwarfIconB,dwarfIconB,scoutIconB,scoutIconB,scoutIconB,scoutIconB,slayerIconB,trapIconB,trapIconB,trapIconB,trapIconB,trapIconB,trapIconB,flagIconB};
    public String[] redImages = {dragonIconR,mageIconR,knightIconR,knightIconR,beastriderIconR,beastriderIconR,beastriderIconR,sorceressIconR,sorceressIconR,lavabeastIconR,lavabeastIconR,elfIconR,elfIconR,dwarfIconR,dwarfIconR,dwarfIconR,dwarfIconR,dwarfIconR,scoutIconR,scoutIconR,scoutIconR,scoutIconR,slayerIconR,trapIconR,trapIconR,trapIconR,trapIconR,trapIconR,trapIconR,flagIconR};
    public ArrayList<String> blueImagesList = new ArrayList<String>(Arrays.asList(blueImages));
    public ArrayList<String> redImagesList = new ArrayList<String>(Arrays.asList(redImages));
    String getRedName(String str) {
        String ran[] = str.split("/"); // Turning str into a list named ran
        String ran___ = "";
        ran___ += ran[2]; // Turning the list named ran into string again but only with the names of the pawns (knightR.png)
        String ran__[] = ran___.split("R"); // Turning it into a list again to get the name only without the R.png
        if(str == beastriderIconR) {
            ran__[0] = "BeastRider";
        }
        return ran__[0];
    }
    String getBlueName(String str) {
        String ran[] = str.split("/"); // Turning str into a list named ran
        String ran___ = "";
        ran___ += ran[2]; // Turning the list named ran into string again but only with the names of the pawns (knightR.png)
        String ran__[] = ran___.split("B"); // Turning it into a list again to get the name only without the R.png
        if(str == beastriderIconB) {
            ran__[0] = "BeastRider";
        }
        return ran__[0];
        
    }


    // Create an integer array to represent the board

    
    
    void CreateBoard() {

        ArrayList<String> modifiedArrayBlue = new ArrayList<String>();

        // A nested for loop to get the rows, columns of the board
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                //ImageIcon randomImg = row <= 2 ? new ImageIcon(getRandom(blueImages)) : row >=5 ? new ImageIcon(getRandom(redImages)); etsi to hthela sthn arxh
                Color color = row <= 2 ? blue : row >= 5 ? red : white;
                isItYellow = false;
                // checking if the boxes in the middle are in a specific row && column so it paints it yellow
                if((row==3 && col == 3 || row-1 == 3 && col == 2 || row == 3 && col == 2 || row == 4 && col ==3) || (row==3 && col == 7 || row-1 == 3 && col == 6 || row == 3 && col == 6) || (row == 4 && col ==7)) {
                    color=yellow;
                    isItYellow = true;
                }
                pawns[row][col] = new JLabel();
                pawns[row][col].setBounds(col*squareSize,row*squareSize,squareSize,squareSize);
                pawns[row][col].setBackground(color);
                pawns[row][col].setOpaque(true);
                if(!isItYellow) {
                    pawns[row][col].setBorder(BorderFactory.createLineBorder(black, 1));
                    pawns[row][col].addMouseListener(this);
                }
                if (row <= 2) {
                    String url = getRandom(blueImagesList);
                    pawns[row][col].setName(getBlueName(url)+" Blue");
                    ImageIcon icon = null;
                    try {
                        icon = new ImageIcon(ImageIO.read(getClass().getResource(url)).getScaledInstance(squareSize, squareSize, java.awt.Image.SCALE_SMOOTH));
                    } catch (IOException e) {
                    
                        e.printStackTrace();
                    }    
                    pawns[row][col].setIcon(icon);
                    if(blueImages.length>=1){
                    modifiedArrayBlue= new ArrayList<String>(Arrays.asList(blueImages));
                    }
                
                    for (int i = 0; i < blueImagesList.size(); i++) {
                        if(blueImagesList.get(i) == url) {
                            blueImagesList.remove(i);
                            break;
                        }
                    }

                }
                if(row >= 3 && row <=4) {
                    pawns[row][col].setName("WhiteSpace");
                }
                if (row >=5) {
                    String url = getRandom(redImagesList);
                    pawns[row][col].setName(getRedName(url)+" Red");
                    ImageIcon icon = null;
                    try {
                        icon = new ImageIcon(ImageIO.read(getClass().getResource(url)).getScaledInstance(squareSize, squareSize, java.awt.Image.SCALE_SMOOTH));
                    } catch (IOException e) {
                    
                        e.printStackTrace();
                    }    
                    pawns[row][col].setIcon(icon);
                    if(redImages.length>=1){
                    modifiedArrayBlue= new ArrayList<String>(Arrays.asList(blueImages));
                    }
                
                    for (int i = 0; i < redImagesList.size(); i++) {
                        if(redImagesList.get(i) == url) {
                            redImagesList.remove(i);
                            break;
                        }
                    }

                }
                
                frame.add(pawns[row][col]);
            }
        }
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting the default close operation
        frame.setLayout(null);
        frame.add(this); // adding the frame
        frame.setUndecorated(true); // Turn it to false if you want it to be decorated
        frame.pack(); // Makes the frame pixels be controlled from the components that are in the frame for example: if frame is 1920x1080 and the components use the 512x512 it makes the frame 512x512
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);
    }

    boolean checkIfClicked=false;
    final boolean teamRed = false;
    final boolean teamBlue = true;
    boolean currentPlayer = teamBlue;
    JLabel oldLabel = new JLabel();
    boolean clear=false;
    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        System.out.println(label.getName());
        if(label.getName().contains("Trap") || label.getName().contains("Flag")) {
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) { // finding the pawn's location in the board
                    if(pawns[i][j].getName() == "WhiteSpace" && pawns[i][j].getBackground() != yellow) {
                        pawns[i][j].setBackground(white);
                    }
                }
            }
            return;
        }

        if(currentPlayer == teamBlue) {
            
            for(int i = 0; i<ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if(pawns[i][j].getBackground() == red) {
                        ImageIcon img = null;
                        try {
                            img = new ImageIcon(ImageIO.read(getClass().getResource(redHiddenIcon)).getScaledInstance(squareSize, squareSize, java.awt.Image.SCALE_SMOOTH));
                        } catch (IOException ell) {
                            // TODO Auto-generated catch block
                            ell.printStackTrace();
                        }
                        pawns[i][j].setIcon(img);
                    }
                }
            }

            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if(pawns[i][j].getBackground() == blue) {
                        String[] splited = pawns[i][j].getName().split("Blue");
                        
                        String unsplit = "";
                        unsplit += splited[0];
                        String split2[] = unsplit.split(" ");
                        if(split2[0].contains("Beast") && !split2[0].contains("Lava")) {
                            split2[0] = "BeastRider"; 
                        }
                        String url = "images/bluePieces/"+split2[0]+ "B.png";
                        ImageIcon randomImg= null;
                        try {
                            randomImg = new ImageIcon(ImageIO.read(getClass().getResource(url)).getScaledInstance(squareSize, squareSize, java.awt.Image.SCALE_SMOOTH));
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        pawns[i][j].setIcon(randomImg);
                    }
                }
            }
            if(label.getBackground() == green) {
            
                int row = -1;
                int col = -1;
                int row_ = -1;
                int col_ = -1;

                for (int i = 0; i < ROWS; i++) {
                    for (int j = 0; j < COLS; j++) { // finding the pawn's location in the board
                        if (pawns[i][j] == label) {
                            row = i;
                            col = j;
                        }
                    }
                }

                int x1 = oldLabel.getX(); // Getting the pawn's X position in pixels
                int y1 = oldLabel.getY(); // Getting the pawn's Y position in pixels

                int x2 = label.getX(); // Getting the WhiteSpace's X position in pixels
                int y2 = label.getY(); // Getting the WhiteSpace's Y position in pixels

                oldLabel.setLocation(x2, y2); // Changing the pawn's location
                label.setLocation(x1,y1); // Changing the WhiteSpace's location
                for (int i = 0; i < ROWS; i++) {
                    for (int j = 0; j < COLS; j++) { // Finding the pawn's location in the board
                        if (pawns[i][j] == oldLabel) {
                            row_ = i;
                            col_ = j;
                        }
                    }
                }
                
                JLabel temp ;
                temp = pawns[row][col];
                pawns[row][col] = pawns[row_][col_];
                pawns[row_][col_] = temp;
                label.setBackground(white); // Making it white
                currentPlayer=teamRed;
                
            }

           
            
            int row = -1;
            int col = -1;
            
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if (pawns[i][j] == label){
                        row = i;
                        col = j;
                    }
                    if(pawns[i][j].getBackground() == green) pawns[i][j].setBackground(white);
                }
            }
            if(label.getName() != "WhiteSpace" && label.getBackground() == blue) {
                oldLabel = label;
                if(row>0 && pawns[row-1][col].getBackground() != yellow && pawns[row-1][col].getName() == "WhiteSpace") { // if can move upwards
                    pawns[row-1][col].setBackground(green);
                    if (label.getName().contains("Scout")){
                        int k = row-1;
                        while (k>=0 && pawns[k][col].getName() == "WhiteSpace" && pawns[k][col].getBackground() != yellow){
                            pawns[k][col].setBackground(green);
                            k--;   
                        }
                    }
                }
                
                if(row<7 && pawns[row+1][col].getBackground() != yellow && pawns[row+1][col].getName() == "WhiteSpace" ) { //checking square below
                    pawns[row+1][col].setBackground(green);
                    if (label.getName().contains("Scout")){
                        int k = row+1;
                        while (k<7&& pawns[k][col].getName() == "WhiteSpace" && pawns[k][col].getBackground() != yellow ){
                            pawns[k][col].setBackground(green);
                            k++;
                        }
                        
                    }
                }

               
                
                if(col>0 && pawns[row][col-1].getBackground() != yellow && pawns[row][col-1].getName() == "WhiteSpace" ) { //checking square to the left
                    pawns[row][col-1].setBackground(green);
                    if (label.getName().contains("Scout")){
                        int k = col-1;
                        while (pawns[row][k].getName() == "WhiteSpace" && pawns[row][k].getBackground() != yellow && k>0){
                            pawns[row][k].setBackground(green);
                            k--;
                        }
                        
                    }
                }

                

                if (col<9 && pawns[row][col+1].getBackground() != yellow && pawns[row][col+1].getName() == "WhiteSpace") { //checking square to the right
                    pawns[row][col+1].setBackground(green);
                    if (label.getName().contains("Scout")){
                        int k = col+1;
                        while (pawns[row][k].getName() == "WhiteSpace" && pawns[row][k].getBackground() != yellow && k<9){
                            pawns[row][k].setBackground(green);
                            k++;
                        }
                        
                    }
                }
            }
            
        }
        if(currentPlayer == teamRed) {
            // for(int i = 0; i<ROWS; i++) {
            //     for (int j = 0; j < COLS; j++) {
            //         if(pawns[i][j].getBackground() == blue) {
            //             ImageIcon img = new ImageIcon(blueHiddenIcon);
            //             Image image = img.getImage();
            //             Image newImage = image.getScaledInstance(squareSize, squareSize, java.awt.Image.SCALE_SMOOTH);
            //             img = new ImageIcon(newImage);
            //             pawns[i][j].setIcon(img);
            //         }
            //     }
            // }
            for(int i = 0; i<ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if(pawns[i][j].getBackground() == blue) {
                        ImageIcon img = null;
                        try {
                            img = new ImageIcon(ImageIO.read(getClass().getResource(blueHiddenIcon)).getScaledInstance(squareSize, squareSize, java.awt.Image.SCALE_SMOOTH));
                        } catch (IOException ell) {
                            // TODO Auto-generated catch block
                            ell.printStackTrace();
                        }
                        pawns[i][j].setIcon(img);
                    }
                }
            }
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if(pawns[i][j].getBackground() == red) {
                        String[] splited = pawns[i][j].getName().split("R");
                        
                        String unsplit = "";
                        unsplit += splited[0];
                        String split2[] = unsplit.split(" ");
                        if(split2[0].contains("Beast") && !split2[0].contains("Lava")) {
                            split2[0] = "BeastRider"; 
                        }
                        String url = "images/RedPieces/"+split2[0]+ "R.png";
                        ImageIcon randomImg= null;
                        try {
                            randomImg = new ImageIcon(ImageIO.read(getClass().getResource(url)).getScaledInstance(squareSize, squareSize, java.awt.Image.SCALE_SMOOTH));
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        pawns[i][j].setIcon(randomImg);
                    }
                }
            }
            if(label.getBackground() == green) {
            
                int row = -1;
                int col = -1;
                int row_ = -1;
                int col_ = -1;

                for (int i = 0; i < ROWS; i++) {
                    for (int j = 0; j < COLS; j++) { // finding the pawn's location in the board
                        if (pawns[i][j] == label) {
                            row = i;
                            col = j;
                        }
                    }
                }

                int x1 = oldLabel.getX(); // Getting the pawn's X position in pixels
                int y1 = oldLabel.getY(); // Getting the pawn's Y position in pixels

                int x2 = label.getX(); // Getting the WhiteSpace's X position in pixels
                int y2 = label.getY(); // Getting the WhiteSpace's Y position in pixels

                oldLabel.setLocation(x2, y2); // Changing the pawn's location
                label.setLocation(x1,y1); // Changing the WhiteSpace's location
                for (int i = 0; i < ROWS; i++) {
                    for (int j = 0; j < COLS; j++) { // finding the pawn's location in the board
                        if (pawns[i][j] == oldLabel) {
                            row_ = i;
                            col_ = j;
                        }
                    }
                }
                JLabel temp ;
                temp = pawns[row][col];
                pawns[row][col] = pawns[row_][col_];
                pawns[row_][col_] = temp;
                label.setBackground(white); // Making it white
                currentPlayer=teamBlue;

            }

            
            
            int row = -1;
            int col = -1;
            
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if (pawns[i][j] == label){
                        row = i;
                        col = j;
                    }
                    if(pawns[i][j].getBackground() == green) pawns[i][j].setBackground(white);
                }
            }
            if(label.getName() != "WhiteSpace" && label.getBackground() != yellow && label.getBackground() == red) {
                oldLabel = label;
                if(row>0 && pawns[row-1][col].getBackground() != yellow && pawns[row-1][col].getName() == "WhiteSpace" ) { // if can move upwards
                    pawns[row-1][col].setBackground(green);
                    if (label.getName().contains("Scout")){
                        
                        int k = row-1;
                        while (k >= 0 && pawns[k][col].getName() == "WhiteSpace" && pawns[k][col].getBackground() != yellow ){
                            pawns[k][col].setBackground(green);
                            k--;
                        }
                      
                    }
                }

               

                if(row<7 && pawns[row+1][col].getBackground() != yellow && pawns[row+1][col].getName() == "WhiteSpace") { //checking square below
                    pawns[row+1][col].setBackground(green);
                    if (label.getName().contains("Scout")){
                        int k = row+1;
                        while (k <= 7&& pawns[k][col].getName() == "WhiteSpace" && pawns[k][col].getBackground() != yellow){
                            pawns[k][col].setBackground(green);
                            k++;
                        }
                        
                    }
                }

                
                
                if(col>0 && pawns[row][col-1].getBackground() != yellow && pawns[row][col-1].getName() == "WhiteSpace" ) { //checking square to the left
                    pawns[row][col-1].setBackground(green);
                    if (label.getName().contains("Scout")){
                        
                        int k = col-1;
                        while (k >= 0 && pawns[row][k].getName() == "WhiteSpace" && pawns[row][k].getBackground() != yellow ){
                            pawns[row][k].setBackground(green);
                            k--;
                        }
                       
                    }
                }

               

                if (col<9 && pawns[row][col+1].getBackground() != yellow && pawns[row][col+1].getName() == "WhiteSpace") { //checking square to the right
                    pawns[row][col+1].setBackground(green);
                    if (label.getName().contains("Scout")){
                        int k = col+1;
                        while (k <= 9 && pawns[row][k].getName() == "WhiteSpace" && pawns[row][k].getBackground() != yellow ){
                            pawns[row][k].setBackground(green);
                            k++;
                        }
                       
                    }
                }
                
                
                
            }
        }
        
        
        
    }


    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
