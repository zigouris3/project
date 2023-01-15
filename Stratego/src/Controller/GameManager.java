package Controller;


import Model.Board;
import View.BoardGraphics;

public class GameManager{
    private static Board board = new Board(8, 10);;
    
    static BoardGraphics newGraphics;
    private boolean isFinished;
    private String currentPlayer;
    public static GameManager gameManager;

    public GameManager() {
        isFinished = false;
        newGraphics = new BoardGraphics(board);
        initializeGame();
        
    }

    public static void initializeGame(){
        board.initializeBoard(newGraphics);
        System.out.println("Game Initialized");
    }

    
    
    public boolean isFinished(){
        return isFinished;
    }

    public String getCurrentPlayer(){
        return currentPlayer;
    }

    public static void main(String[] args) {
        GameManager manager = new GameManager();
        while (true) board.initializeBoard(newGraphics);
    }


}
