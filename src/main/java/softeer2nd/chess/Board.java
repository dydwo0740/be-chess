package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Pawn> store = new ArrayList<>();

    private char[][] location = new char[8][8];

    public List<Pawn> getStore() {
        return store;
    }

    public void addPawn(Pawn pawn) {
        this.store.add(pawn);
    }

    public Pawn findPawn(int index) {
        return this.store.get(index);
    }




}
