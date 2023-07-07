package softeer2nd.chess.pieces;

import softeer2nd.chess.pieces.piecetype.Piece;

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

    public void setPiece(int index, Piece p){
        pieces.set(index, p);
    }


}
