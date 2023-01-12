package Model;

import View.BoardGraphics;

public class Board{
    private final Piece[][] board;

    public Board(int width, int height) {
        board = new Piece[width][height];
    }


    /**
     * Adds a piece to the board at the specified location.
     * @param piece The piece to add.
     * @param x The x coordinate of the piece.
     * @param y The y coordinate of the piece.
     * @type mutator
     * @precondition piece != null && x >= 0 && y >= 0
     * @postcondition The piece is added to the board at the specified location.
     * @invariant piece != null && x >= 0 && y >= 0
     */
    public void addPiece(Piece piece, int x, int y) {
        board[x][y] = piece;
    }

    /**
     * @param x The x coordinate of the piece.
     * @param y The coordinates of the piece to get.
     * @return The piece at the specified location.
     */
    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    public Board initializeBoard(BoardGraphics boardGraphics){
        Board board = new Board(8,10);
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                String name[] = new String[5];
                String splited[] = new String[10];
                
                if(boardGraphics.pawns[i][j].getName().contains("B")) {
                    splited = boardGraphics.pawns[i][j].getName().split("B");
                    
                    String unsplit = "";
                    unsplit += splited[0];
                    name = unsplit.split(" ");
                    if(splited[1].contains("Rider")) {
                        name[0] = "BeastRider";
                    }
                }
                if(boardGraphics.pawns[i][j].getName().contains("R")) {
                    splited = boardGraphics.pawns[i][j].getName().split("R");
                    
                    String unsplit = "";
                    unsplit += splited[0];
                    name = unsplit.split(" ");
                    if(name[0].contains("Beast") && !name[0].contains("Lava")) {
                        name[0] = "BeastRider"; 
                    }
                    
                }
                if(name[0] != null || name[0] =="WhiteSpace") {
                    if (name[0].contains("BeastRider")){
                        BeastRider beastRider = new BeastRider(name[0], i, j, boardGraphics.pawns[i][j].getBackground());
                        addPiece(beastRider, i, j);
                    }else if (name[0].contains("Dragon")){
                        Dragon dragon = new Dragon(name[0], i, j, boardGraphics.pawns[i][j].getBackground());
                        addPiece(dragon, i, j);
                    }else if (name[0].contains("Dwarf")){
                        Dwarf dwarf = new Dwarf(name[0], i, j, boardGraphics.pawns[i][j].getBackground());
                        addPiece(dwarf, i, j);
                    }else if (name[0].contains("Elf")){
                        Elf elf = new Elf(name[0], i, j, boardGraphics.pawns[i][j].getBackground());
                        addPiece(elf, i, j);
                    }else if (name[0].contains("Flag")){
                        Flag flag = new Flag(name[0], i, j, boardGraphics.pawns[i][j].getBackground());
                        addPiece(flag, i, j);
                    }else if (name[0].contains("Knight")){
                        Knight knight = new Knight(name[0], i, j, boardGraphics.pawns[i][j].getBackground());
                        addPiece(knight, i, j);
                    }else if (name[0].contains("LavaBeast")){
                        LavaBeast lavaBeast = new LavaBeast(name[0], i, j, boardGraphics.pawns[i][j].getBackground());
                        addPiece(lavaBeast, i, j);
                    }else if (name[0].contains("Mage")){
                        Mage mage = new Mage(name[0], i, j, boardGraphics.pawns[i][j].getBackground());
                        addPiece(mage, i, j);
                    }else if (name[0].contains("Scout")){
                        Scout scout = new Scout(name[0], i, j, boardGraphics.pawns[i][j].getBackground());
                        addPiece(scout, i, j);
                    }else if (name[0].contains("Sorceress")){
                        Sorceress sorcerer = new Sorceress(name[0], i, j, boardGraphics.pawns[i][j].getBackground());
                        addPiece(sorcerer, i, j);
                    }else if (name[0].contains("Slayer")){
                        Slayer slayer = new Slayer(name[0], i, j, boardGraphics.pawns[i][j].getBackground());
                        addPiece(slayer, i, j);
                    }else if (name[0].contains("Trap")){
                        Trap trap = new Trap(name[0], i, j, boardGraphics.pawns[i][j].getBackground());
                        addPiece(trap, i, j);
                    }else if (name[0].contains("Yeti")){
                        Yeti yeti = new Yeti(name[0], i, j, boardGraphics.pawns[i][j].getBackground());
                        addPiece(yeti, i, j);
                    }
                }
                else {
                    Whitespace whitespace = new Whitespace(name[0], i, j, boardGraphics.pawns[i][j].getBackground());
                    addPiece(whitespace, i, j);
                }
            }
        }
        return board;
    }
}
