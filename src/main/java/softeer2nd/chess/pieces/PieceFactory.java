package softeer2nd.chess.pieces;

import softeer2nd.chess.pieces.piecetype.*;

import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.chess.pieces.Piece.Color.*;
import static softeer2nd.chess.pieces.Piece.Type.*;


public class PieceFactory {
    private static Piece createWhite(Type type) {
        switch (type){
            case PAWN:
                return new Pawn(WHITE);
            case KNIGHT:
                return new Knight(WHITE);
            case ROOK:
                return new Rook(WHITE);
            case KING:
                return new King(WHITE);
            case QUEEN:
                return new Queen(WHITE);
            case BISHOP:
                return new Bishop(WHITE);
            default:
                return new Empty(NOCOLOR);
        }
    }
    private static Piece createBlack(Type type) {
        switch (type){
            case PAWN:
                return new Pawn(BLACK);
            case KNIGHT:
                return new Knight(BLACK);
            case ROOK:
                return new Rook(BLACK);
            case KING:
                return new King(BLACK);
            case QUEEN:
                return new Queen(BLACK);
            case BISHOP:
                return new Bishop(BLACK);
            default:
                return new Empty(NOCOLOR);
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



}
