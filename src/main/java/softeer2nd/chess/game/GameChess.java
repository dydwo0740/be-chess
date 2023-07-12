package softeer2nd.chess.game;

import softeer2nd.chess.Board;
import softeer2nd.chess.exception.EmptyPieceException;
import softeer2nd.chess.exception.NeverReach;
import softeer2nd.chess.exception.SamePosition;
import softeer2nd.chess.pieces.Rank;
import softeer2nd.chess.pieces.piecetype.Piece;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.piecetype.enumutils.Type;
import java.util.List;
import static softeer2nd.chess.pieces.piecetype.Piece.*;
import static softeer2nd.chess.pieces.piecetype.PieceFactory.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

public class GameChess {
    private final Board board;

    public GameChess(Board board) {
        this.board = board;
    }

    public void move(String position, Piece fromPiece){
        Position p = changeToPosition(position);
        if(isMyTeamHere(p.getX(), p.getY(), fromPiece.getColor())){
            throw new NeverReach("해당 칸에는 같은 팀 기물이 배치되어 있습니다.");
        }
        board.changePiece(p.getX(), p.getY(), fromPiece);
    }
    public void move(String from, String to){
        Position pos1 = changeToPosition(from);
        Position pos2 = changeToPosition(to);
        if (from.equals(to)) {
            throw new SamePosition(from + " 과 " + to + " 는 동일한 위치입니다.");
        }
        if (isBlankPiece(pos1.getX(), pos1.getY())) {
            throw new EmptyPieceException("출발지 칸에는 기물이 존재하지 않습니다.");
        }
        Piece piece = findPiece(from);
        if(piece.verifyMovePosition(pos1 ,pos2, this)) {
            board.changePiece(pos2.getX(), pos2.getY(), findPiece(from));
            board.changePiece(pos1.getX(), pos1.getY(), createBlank());
        }else{
            throw new NeverReach(from+" 으로부터, " + to + " 로는 도달할 수 없습니다. ");
        }
    }
    public boolean isMyTeamHere(int x, int y, Color color) {
        Piece piece = board.findByPosition(x, y);
        if (!piece.equals(createBlank()) && color.equals(piece.getColor())) {
            return true;
        }
        return false;
    }
    public boolean isBlankPiece(int x, int y){
        Piece piece = board.findByPosition(x, y);
        if (piece.equals(createBlank())) {
            return true;
        }
        return false;
    }
    public Position changeToPosition(String str){
        Position pos = new Position(str);
        return pos;
    }
    public Piece findPiece(String str) {
        Position position = changeToPosition(str);
        return board.findByPosition(position.getX(), position.getY());
    }

    public double caculcatePoint(Color color) {
        double sum = 0;
        for (Rank rank : board.getState()) {
            List<Piece> pieces = rank.getPieces();
            for (Piece piece : pieces) {
                if (piece.getColor() == color) {
                    sum += piece.getType().getDefaultPoint();
                }
            }
        }
        return sum - ((double)pawnCheck(color) * 0.5);
    }
    private int pawnCheck(Color color){
        int[] pawnChecker = new int[8];
        int res = 0;
        for (Rank rank : board.getState()) {
            List<Piece> pieces = rank.getPieces();
            int index = 0;
            for (Piece piece : pieces) {
                if (piece.getType().equals(PAWN) && piece.getColor().equals(color)) {
                    pawnChecker[index]++;
                }
                index++;
            }
        }
        for (int count : pawnChecker) {
            if(count >= 2){
                res += count;
            }
        }
        return res;
    }
    public String findByPiece(final Piece findPiece) {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : board.getState()) {
            List<Piece> pieces = rank.getPieces();
            for (Piece piece : pieces) {
                if (piece.equals(findPiece)) {
                    sb.append(String.valueOf(piece.getRepresentation()));
                }
            }
        }
        return sb.toString();
    }

    public String getWhitePawnsResult() {
        return findByPiece(createWhitePawn());
    }
    public String getBlackPawnsResult() {
        return findByPiece(createBlackPawn());
    }

    public int findByColorAndType(final Color color, final Type type) {
        int count = 0;
        for (Rank rank : board.getState()) {
            List<Piece> pieces = rank.getPieces();
            for (Piece piece : pieces) {
                if (piece.getColor().equals(color) && piece.getType().equals(type)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int pieceCount() {
        int count = 0;
        for (Rank rank : board.getState()) {
            List<Piece> pieces = rank.getPieces();
            for (Piece piece : pieces) {
                if (!piece.equals(createBlank())) {
                    count++;
                }
            }
        }
        return count;
    }
}
