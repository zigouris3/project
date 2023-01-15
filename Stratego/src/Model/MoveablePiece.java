package Model;

import java.awt.*;



public abstract class MoveablePiece extends Piece{
    /**
     * Constructor for MoveablePiece
     * @param name Name of the piece
     *
     * @param x X coordinate of the piece
     * @param y Y coordinate of the piece
     * @param power Power of the piece
     * @type constructor
     * @precondition name != null && icon != null && x >= 0 && y >= 0 && power >= 0
     * @postcondition The piece is created with the given parameters
     * @invariant name != null && icon != null && x >= 0 && y >= 0 && power >= 0
     */
    protected MoveablePiece(String name, int x, int y, int power, Color team) {
        super(name, x, y, power, team);
    }
    @Override
    public String Attack(int x , int y, Board board) {
        Whitespace whitespace = new Whitespace("WhiteSpace", this.getX(), this.getY());
        String winner = "none";
        if (board.getPiece(x,y) instanceof Whitespace){
            board.addPiece(whitespace, this.getX(), this.getY());
            this.setX(x);
            this.setY(y);
            board.addPiece(this,x,y);
            
            winner = "attacker";
       } else if(board.getPiece(x,y).team != this.getTeam()){
            if (board.getPiece(x, y)instanceof Flag){
                winner = "attacker";
                this.setX(x);
                this.setY(y);
                board.addPiece(this,x,y);
                System.out.println("Game is over");
                if(this.getTeam() == Color.blue){
                    System.out.println("Blue team is victorious");
                } else {
                    System.out.println("Red team is victorious");
                }
            }else if (this instanceof Slayer && board.getPiece(x,y) instanceof Dragon){
                winner = this.getName();
                board.addPiece(whitespace, this.getX(), this.getY());
                this.setX(x);
                this.setY(y);
                board.addPiece(this,x,y);
                winner = "attacker";
            }else if(this instanceof Dwarf && board.getPiece(x,y) instanceof Trap) {
                winner = this.getName();
                this.setX(x);
                this.setY(y);
                board.addPiece(this,x,y);
                winner ="attacker";
            }else if(this.getPower() > board.getPiece(x,y).getPower()){
                winner = this.getName();
                this.setX(x);
                this.setY(y);
                board.addPiece(this,x,y);
                winner ="attacker";

            }else if (this.getPower() < board.getPiece(x,y).getPower()) {
                winner = board.getPiece(x,y).getName();
                board.addPiece(whitespace,this.getX(),this.getY());
                winner = "defender";
            }else if (this.getPower() == board.getPiece(x,y).getPower()) {
                winner = "none";
                board.addPiece(whitespace,x,y);
                board.addPiece(whitespace,this.getX(),this.getY());
                winner = "none";
            } 
        
       }
       return winner;
    }
    

    // Getters and Setters

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
