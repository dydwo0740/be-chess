package softeer2nd.chess.pieces.piecetype;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.exception.NeverReach;
import softeer2nd.chess.exception.OutOfRangeException;
import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;
import softeer2nd.chess.pieces.piecetype.enumutils.Type;
import softeer2nd.chess.view.GameView;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.piecetype.PieceFactory.*;
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
    void outOfRange(){
        board.initializeEmpty();
        gameChess.move("a1", createBlackKing());
        assertThatThrownBy(() -> gameChess.move("a1", "a0")).isInstanceOf(OutOfRangeException.class);

    }

    @Test
    @DisplayName("king의 움직임에 같은 색 기물이 있을때")
    void kingMoveV1(){
        board.initializeEmpty();
        gameChess.move("a1", createBlackKing());
        gameChess.move("b2", createBlackBishop());
        assertThatThrownBy(()-> gameChess.move("a1", "b2")).isInstanceOf(NeverReach.class);
    }
    @Test
    @DisplayName("king의 움직임에 다른 색 기물이 있을때")
    void kingMoveV2(){
        board.initializeEmpty();
        gameChess.move("a1", createBlackKing());
        gameChess.move("b2", createWhiteBishop());
        gameChess.move("a1", "b2");
        assertThat(gameChess.findPiece("b2")).isEqualTo(createBlackKing());
    }


}