package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.*;

public class WhiteOnly {
    private static PriorityQueue<Piece> store = new PriorityQueue<>(new Comparator<Piece>() {
        @Override
        public int compare(Piece o1, Piece o2) {
            return Double.compare(o2.getType().getDefaultPoint(), o1.getType().getDefaultPoint());
        }
    });

    private WhiteOnly(){
    }

    public static void addPiece(Piece piece){
        store.add(piece);
    }

    public static void clear(){
        store.clear();
    }

}
