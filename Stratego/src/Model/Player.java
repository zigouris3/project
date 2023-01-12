package Model;

import java.util.ArrayList;

public class Player {
    // Statistics
    private int totalAttacks;
    private int successfulAttacks;
    private int totalSaves;

    // Captures
    private final ArrayList<Piece> capturedPieces;

    public Player() {
        totalAttacks = 0;
        successfulAttacks = 0;
        totalSaves = 0;
        capturedPieces = new ArrayList<Piece>();
    }

    public int totalCaptures(){
        return capturedPieces.size();
    }

    public void addCapture(Piece piece){
        capturedPieces.add(piece);
    }

    public void addUnsuccessfulAttack(){
        totalAttacks++;
    }

    public void addSuccessfulAttack(){
        successfulAttacks++;
        totalAttacks++;
    }

    public void addSave(){
        totalSaves++;
    }

    public int getTotalAttacks() {
        return totalAttacks;
    }

    public int getSuccessfulAttacks() {
        return successfulAttacks;
    }

    public int getAttackSuccessRate() {
        return (int) ((successfulAttacks / totalAttacks) * 100);
    }

    public int getTotalSaves() {
        return totalSaves;
    }

    public ArrayList<Piece> getCapturedPieces() {
        return capturedPieces;
    }

}
