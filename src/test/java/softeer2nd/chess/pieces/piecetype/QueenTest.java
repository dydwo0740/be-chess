package softeer2nd.chess.pieces.piecetype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.exception.OutOfRangeException;
import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;
import softeer2nd.chess.pieces.piecetype.enumutils.Type;
import softeer2nd.chess.view.GameView;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

class QueenTest {
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
    public void recursionTest(){

        board.initializeEmpty();
        gameChess.move("a1", Piece.createBlack(QUEEN));
        gameView.print();
        gameChess.move("a1", "h1");
        gameView.print();
        gameChess.move("h1", "h0");

    }
}