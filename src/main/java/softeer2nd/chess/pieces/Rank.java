package softeer2nd.chess.pieces;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private List<Piece> pieces;


    public Rank() {
        pieces = new ArrayList<>();
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public Piece getPiece(int index){
        return pieces.get(index);
    }

    public List<Piece> getPieces() {
        return pieces;
    }
}
