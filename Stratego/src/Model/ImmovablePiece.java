package Model;

import java.awt.*;

public abstract class ImmovablePiece extends Piece {

    protected ImmovablePiece(String name, int x, int y, int power, Color team) {
        super(name, x, y, power, team);
    }
    @Override
    public String Attack(int x, int y, Board board){
        return "immovable";
    }

}