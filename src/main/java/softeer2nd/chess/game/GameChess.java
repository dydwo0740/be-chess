package softeer2nd.chess.game;

import softeer2nd.chess.Board;
import softeer2nd.chess.exception.EmptyPieceException;
import softeer2nd.chess.exception.NotEmptyPieceException;
import softeer2nd.chess.pieces.piecetype.Piece;
import softeer2nd.chess.pieces.Position;

import static softeer2nd.chess.pieces.piecetype.Piece.*;
import static softeer2nd.chess.pieces.piecetype.Piece.Type.*;


public class GameChess {

    private Board board;

    public GameChess(Board board) {
        this.board = board;
    }

    public void move(String position, Piece fromPiece){
        isNotEmptyPiece(position);
        Position pos = findByLocation(position);
        board.getState().get(pos.getX()).setPiece(pos.getY(), fromPiece);
    }

    public void move(String from, String to){
        Position pos1 = findByLocation(from);
        Position pos2 = findByLocation(to);
        isEmptyPiece(from);
        isNotEmptyPiece(to);
        board.getState().get(pos2.getX()).setPiece(pos2.getY(), findPiece(from));
        board.getState().get(pos1.getX()).setPiece(pos1.getY(), createBlank());
    }

    private void isEmptyPiece(String position){
        if(findPiece(position).equals(Piece.createBlank())){
            throw new EmptyPieceException("해당 칸에는 기물이 존재하지 않습니다.");
        }
    }

    private void isNotEmptyPiece(String position) {
        if(!findPiece(position).equals(Piece.createBlank())){
            throw new NotEmptyPieceException("이동시킬 칸에는 기물이 존재합니다.");
        }
    }

    public Position findByLocation(String str){
        Position loc = new Position(str);
        return loc;
    }

    public Piece findPiece(String str) {
        Position position = findByLocation(str);
        return board.getState().get(position.getX()).getPiece(position.getY());
    }


}
