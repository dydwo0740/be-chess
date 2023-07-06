package softeer2nd.chess.pieces;

import softeer2nd.chess.pieces.piecetype.*;

import static softeer2nd.chess.pieces.Chess.*;
import static softeer2nd.chess.pieces.Chess.Color.*;
import static softeer2nd.chess.pieces.Chess.Type.*;


public class PieceFactory {
    private static Chess createWhite(Type type) {
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
    private static Chess createBlack(Type type) {
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


    public static Chess createWhitePawn(){
        //굳이 매개변수로 색깔을 넘겨줄 필요가 없다.
        // whitePawn이라고 명시되어있기 때문입니다.
        return createWhite(PAWN);
    }

    public static Chess createBlackPawn(){
        return createBlack(PAWN);
    }

    public static Chess createBlank(){
        return createWhite(NO_PIECE);
    }

    public static Chess createWhiteKnight(){
        return createWhite(KNIGHT);
    }

    public static Chess createBlackKnight(){
        return createBlack(KNIGHT);
    }

    public static Chess createWhiteRook(){
        return createWhite(ROOK);
    }
    public static Chess createBlackRook(){
        return createBlack(ROOK);
    }
    public static Chess createWhiteBishop(){
        return createWhite(BISHOP);
    }
    public static Chess createBlackBishop(){
        return createBlack(BISHOP);
    }
    public static Chess createWhiteQueen(){
        return createWhite(QUEEN);
    }
    public static Chess createBlackQueen(){
        return createBlack(QUEEN);
    }
    public static Chess createWhiteKing(){
        return createWhite(KING);
    }
    public static Chess createBlackKing(){
        return createBlack(KING);
    }



}
