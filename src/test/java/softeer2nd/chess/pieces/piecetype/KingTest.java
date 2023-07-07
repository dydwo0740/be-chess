package softeer2nd.chess.pieces.piecetype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;
import softeer2nd.chess.pieces.piecetype.enumutils.Type;
import softeer2nd.chess.view.GameView;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

class KingTest {

    private Board board;
    private GameChess gameChess;
    private GameView gameView;

    @BeforeEach
    public void before(){
        board = new Board();
        gameChess = board.getGameChess();
        gameView = board.getGameView();
    }

    @Test
    @DisplayName("king의 움직임이 체스판을 넘어간 경우")
    public void outOfRange(){
        Piece blackKing = Piece.createBlack(KING);
        List<Direction> directions = blackKing.getDirections();
        for (Direction direction : directions) {
            System.out.println("direction = " + direction);
        }
    }

}