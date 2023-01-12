package Model;

import java.awt.*;

public class Dwarf extends SpecialMoveablePiece {
    public Dwarf(String name, int x, int y, Color team) {
        super("Dwarf", x, y, 3, team);
    }

    /**
     * If the Dwarf attacks a trap it will destroy the trap.
     * @param piece
     */

}
