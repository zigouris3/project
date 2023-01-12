package Model;

import java.awt.*;

public class Flag extends ImmovablePiece {
    public Flag(String name, int x, int y, Color team) {
        super("Flag", x, y, 0, team);
    }
}
