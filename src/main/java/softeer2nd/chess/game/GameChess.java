package softeer2nd.chess.game;

import softeer2nd.chess.Board;
import softeer2nd.chess.exception.EmptyPieceException;
import softeer2nd.chess.exception.NotEmptyPieceException;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.Rank;

import java.util.List;

import static softeer2nd.chess.pieces.Piece.createBlank;

public class GameChess {

    private Board board;

    public GameChess(Board board) {
        this.board = board;
    }

    public void move(String position, Piece toPiece){
        isNotEmptyPiece(position);
        Piece fromPiece = findByLocation(position);
        fromPiece.change(toPiece);
    }

    public void move(String from, String to){
        Piece start = findByLocation(from);
        Piece end = findByLocation(to);

        isEmptyPiece(from);
        isNotEmptyPiece(to);

        end.change(start);
        start.change(Piece.createBlank());
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
