package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.*;

public class BlackOnly {
    private static List<Piece> store = new ArrayList<>();

    private BlackOnly(){
    }

    public static void addPiece(Piece piece){
        store.add(piece);
    }

    public static void clear(){
        store.clear();
    }

    public static void printBlackPiece(boolean reverse){
        Collections.sort(store, new Comparator<Piece>() {
            @Override
            public int compare(Piece o1, Piece o2) {
                return Double.compare(o2.getType().getDefaultPoint(), o1.getType().getDefaultPoint());
            }
        });
        StringBuilder sb = new StringBuilder();

        for (Piece piece : store) {
            sb.append(String.valueOf(piece.getRepresentation()));
        }
        if(reverse) {
            System.out.println(sb.reverse().toString());
        }else{
            System.out.println(sb.toString());
        }
    }

}
