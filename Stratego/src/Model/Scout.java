package Model;

import java.awt.*;

public class Scout extends SpecialMoveablePiece {
    public Scout(String name,  int x, int y, Color team) {
        super("Scout", x, y, 2, team);
    }

    /**
     * The Scout is able to move any number of spaces as long as it is not blocked by another piece.
     * @param piece
     */

}
