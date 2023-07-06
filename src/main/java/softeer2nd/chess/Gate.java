package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Rank;

import java.util.List;

import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.chess.pieces.Piece.Color.*;

public class Gate {

    public static void addAllPiece(Board board){
        List<Rank> state = board.getState();
        for (Rank rank : state) {
            List<Piece> pieces = rank.getPieces();
            for (Piece piece : pieces) {
                if (piece.isBlack()) {
                    BlackOnly.addPiece(piece);
                }else if(piece.isWhite()){
                    WhiteOnly.addPiece(piece);
                }
            }
        }
    }
}
