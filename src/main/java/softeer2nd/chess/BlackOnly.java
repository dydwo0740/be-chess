package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BlackOnly {
    private static PriorityQueue<Piece> store = new PriorityQueue<>(new Comparator<Piece>() {
        @Override
        public int compare(Piece o1, Piece o2) {
            return Double.compare(o2.getType().getDefaultPoint(), o1.getType().getDefaultPoint());
        }
    });

    private BlackOnly(){
    }

    public static void addPiece(Piece piece){
        store.add(piece);
    }

    public static void clear(){
        store.clear();
    }
}
