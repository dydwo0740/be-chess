package softeer2nd.chess.pieces.piecetype;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.blackPawnDirection;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.whitePawnDirection;

public class PieceFactory {
    public static Piece createWhiteBishop(){
        return new Bishop(WHITE);
    }
    public static Piece createBlackBishop(){
        return new Bishop(BLACK);
    }
    public static Piece createBlank(){
        return new Blank(NOCOLOR);
    }
    public static Piece createWhiteKing(){
        return new King(WHITE);
    }
    public static Piece createBlackKing(){
        return new King(BLACK);
    }
    public static Piece createWhiteKnight(){
        return new Knight(WHITE);
    }
    public static Piece createBlackKnight(){
        return new Knight(BLACK);
    }
    public static Piece createWhitePawn() {
        return new Pawn(WHITE, whitePawnDirection());
    }
    public static Piece createBlackPawn() {
        return new Pawn(BLACK, blackPawnDirection());
    }
    public static Piece createWhiteQueen(){
        return new Queen(WHITE);
    }
    public static Piece createBlackQueen(){
        return new Queen(BLACK);
    }
    public static Piece createWhiteRook(){
        return new Rook(WHITE);
    }
    public static Piece createBlackRook(){
        return new Rook(BLACK);
    }
}
