package softeer2nd.chess.view;

import softeer2nd.chess.Board;
import softeer2nd.chess.pieces.piecetype.Piece;
import softeer2nd.chess.pieces.Rank;

import java.util.List;

import static softeer2nd.utils.StringUtils.appendNewLine;

public class GameView {
    private Board board;
    public GameView(Board board) {
        this.board = board;
    }
    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : board.getState()) {
            String str = "";
            List<Piece> pieces = rank.getPieces();
            for (Piece piece : pieces) {
                str += String.valueOf(piece.getRepresentation());
            }
            sb.append(appendNewLine(str));
        }

        return sb.toString();
    }

    public void print() {
        System.out.println(showBoard());
    }
}
