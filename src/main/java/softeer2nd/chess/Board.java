package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Pawn> store = new ArrayList<>();

    private char[][] location = new char[8][8];

    private List<Character> whitePawnsResult = new ArrayList<>();

    private List<Character> blackPawnsResult = new ArrayList<>();

    public List<Pawn> getStore() {
        return store;
    }

    public void addPawn(Pawn pawn) {
        this.store.add(pawn);
    }

    public Pawn findPawn(int index) {
        return this.store.get(index);
    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<whitePawnsResult.size();i++){
            sb.append(String.valueOf(whitePawnsResult.get(i)));
        }
        return sb.toString();
    }

    public String getBlackPawnResult() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<blackPawnsResult.size();i++){
            sb.append(String.valueOf(blackPawnsResult.get(i)));
        }
        return sb.toString();
    }
}
