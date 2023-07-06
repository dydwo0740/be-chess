package softeer2nd.chess.pieces;

import static softeer2nd.chess.pieces.Chess.*;
import static softeer2nd.chess.pieces.Piece.Color.*;
import static softeer2nd.chess.pieces.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.Piece.Type.*;
import static softeer2nd.chess.pieces.Piece.Type.KING;

public class PieceFactory {
    private static Piece createWhite(Piece.Type type) {
        switch (type){
            case PAWN:
                return new Pawn(WHITE);
            case KNIGHT:
                return new Piece(WHITE, KNIGHT);
            case ROOK:
                return new Piece(WHITE, ROOK);
            case KING:
                return new Piece(WHITE, KING);
            case QUEEN:
                return new Piece(WHITE, QUEEN);
            case BISHOP:
                return new Piece(WHITE, BISHOP);
            default:
                return new Piece(NOCOLOR, NO_PIECE);
        }
    }
    private static Piece createBlack(Piece.Type type) {
        switch (type){
            case PAWN:
                return new Piece(BLACK, PAWN);
            case KNIGHT:
                return new Piece(BLACK, KNIGHT);
            case ROOK:
                return new Piece(BLACK, ROOK);
            case KING:
                return new Piece(BLACK, KING);
            case QUEEN:
                return new Piece(BLACK, QUEEN);
            case BISHOP:
                return new Piece(BLACK, BISHOP);
            default:
                return new Piece(NOCOLOR, NO_PIECE);
        }
    }


    public static Piece createWhitePawn(){
        //굳이 매개변수로 색깔을 넘겨줄 필요가 없다.
        // whitePawn이라고 명시되어있기 때문입니다.
        return createWhite(PAWN);
    }

    public static Piece createBlackPawn(){
        return createBlack(PAWN);
    }

    public static Piece createBlank(){
        return createWhite(NO_PIECE);
    }

    public static Piece createWhiteKnight(){
        return createWhite(KNIGHT);
    }

    public static Piece createBlackKnight(){
        return createBlack(KNIGHT);
    }

    public static Piece createWhiteRook(){
        return createWhite(ROOK);
    }
    public static Piece createBlackRook(){
        return createBlack(ROOK);
    }
    public static Piece createWhiteBishop(){
        return createWhite(BISHOP);
    }
    public static Piece createBlackBishop(){
        return createBlack(BISHOP);
    }
    public static Piece createWhiteQueen(){
        return createWhite(QUEEN);
    }
    public static Piece createBlackQueen(){
        return createBlack(QUEEN);
    }
    public static Piece createWhiteKing(){
        return createWhite(KING);
    }
    public static Piece createBlackKing(){
        return createBlack(KING);
    }

    public boolean isBlack() {
        if (color.equals(BLACK)) {
            return true;
        }
        return false;
    }


}
