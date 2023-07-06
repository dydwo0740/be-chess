package softeer2nd.chess.game;

import softeer2nd.chess.Board;
import softeer2nd.chess.exception.EmptyPieceException;
import softeer2nd.chess.exception.NotEmptyPieceException;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.PieceFactory;
import softeer2nd.chess.pieces.Position;

import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.chess.pieces.PieceFactory.*;


public class GameChess {

    int[] row = {1, 1, 1, 0, 0, -1, -1, -1};
    int[] col = {1, 0, -1, 1, -1, 1, 0, -1};

    private Board board;

    public GameChess(Board board) {
        this.board = board;
    }

    public void move(String position, Piece fromPiece){
        isNotEmptyPiece(position);
        Piece toPiece = findByLocation(position);
        toPiece.changeAttribute(fromPiece);
    }

    public void move(String from, String to){
        Piece start = findByLocation(from);
        Piece end = findByLocation(to);

        isEmptyPiece(from);
        isNotEmptyPiece(to);

        end.changeAttribute(start);
        start.changeAttribute(createBlank());
    }

    private void isEmptyPiece(String position){
        if(findByLocation(position).equals(createBlank())){
            throw new EmptyPieceException("해당 칸에는 기물이 존재하지 않습니다.");
        }
    }

    private void isNotEmptyPiece(String position) {
        if(!findByLocation(position).equals(createBlank())){
            throw new NotEmptyPieceException("이동시킬 칸에는 기물이 존재합니다.");
        }
    }

    public Piece findByLocation(String str){
        Position loc = new Position(str);
        return board.getState().get(loc.getX()).getPiece(loc.getY());
    }



}
