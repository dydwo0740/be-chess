package softeer2nd.chess.pieces.piecetype;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.exception.NeverReach;
import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.view.GameView;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.piecetype.PieceFactory.*;
import static softeer2nd.chess.pieces.piecetype.PieceFactory.createBlackKing;

class RookTest {
    private Board board;
    private GameChess gameChess;
    private GameView gameView;

    @BeforeEach
    public void before() {
        board = new Board();
        board.initializeEmpty();
        gameChess = new GameChess(board);
        gameView = new GameView(board);
    }


    @Test
    @DisplayName("Rook의 직진 - 다른 color의 기물이 존재할떄")
    void rookMoveV1() {
        gameChess.move("a1", createBlackRook());
        gameChess.move("a3", createWhiteBishop());
        gameChess.move("a1", "a3");
    }

    @Test
    @DisplayName("Rook의 직진 - 같은 color의 기물이 존재할때")
    void rookMoveV2() {
        gameChess.move("a1", createBlackRook());
        gameChess.move("a3", createBlackBishop());
        Assertions.assertThatThrownBy(() -> gameChess.move("a1", "a3")).isInstanceOf(NeverReach.class);
    }

    @Test
    @DisplayName("Rook의 후진 - 다른 color의 기물이 존재할때")
    void rookMoveV3() {
        gameChess.move("a3", createBlackRook());
        gameChess.move("a1", createWhiteBishop());
        gameChess.move("a3", "a1");
    }

    @Test
    @DisplayName("Rook의 후진 - 같은 color의 기물이 존재할때")
    void rookMoveV4() {
        gameChess.move("a3", createBlackRook());
        gameChess.move("a1", createBlackBishop());
        assertThatThrownBy(() -> gameChess.move("a3", "a1")).isInstanceOf(NeverReach.class);
    }

    @Test
    @DisplayName("Rook의 왼쪽으로의 움직임 - 같은 color와 다른 color")
    void rookMoveV5(){
        gameChess.move("c1", createBlackRook());
        gameChess.move("a1", createBlackKing());
        gameChess.move("e1", createWhiteBishop());

        assertThatThrownBy(() -> gameChess.move("c1", "a1")).isInstanceOf(NeverReach.class);
        gameChess.move("c1", "e1");
    }
}