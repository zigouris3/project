package Model;

import java.awt.*;

abstract public class Piece {
    protected String name;
    protected Color team;
    protected Image icon;
    protected int power;
    protected int x;
    protected int y;

    protected Piece(String name, int x, int y, int power, Color team) {
        this.name = name;
        this.power = power;
        this.team = team;
        this.x = x;
        this.y = y;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getTeam(){ return team;}

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String Attack(int x, int y, Board board) {
        return "none";
    }
}
