package softeer2nd.chess.pieces.piecetype;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.exception.NeverReach;
import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;
import softeer2nd.chess.view.GameView;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.piecetype.PieceFactory.*;
import static softeer2nd.chess.pieces.piecetype.PieceFactory.createBlackKing;

class PawnTest {
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
    @DisplayName("pawn의 직진 - 앞에 아무 기물도 존재하지 않을때")
    void pawnMoveV1() {
        gameChess.move("a1", createWhitePawn());

        gameChess.move("a1", "a2");
    }

    @Test
    @DisplayName("pawn의 직진 - 앞에 기물이 막고 있을때")
    void pawnMoveV2() {
        gameChess.move("a1", createWhitePawn());
        gameChess.move("a2", createBlackKnight());
        assertThatThrownBy(() -> gameChess.move("a1", "a2")).isInstanceOf(NeverReach.class);
    }

    @Test
    @DisplayName("pawn의 대각선 - 방향에 같은 color의 기물이 존재할떄")
    void pawnMoveV3() {
        gameChess.move("b1", createWhitePawn());
        gameChess.move("a2", createWhiteBishop());

        assertThatThrownBy(() -> gameChess.move("b1", "a2")).isInstanceOf(NeverReach.class);
    }

    @Test
    @DisplayName("pawn의 대각선 - 방향에 다른 color의 기물이 존재할떄")
    void pawnMoveV4(){
        gameChess.move("b1", createWhitePawn());
        gameChess.move("a2", createBlackKnight());
        gameChess.move("b1", "a2");
    }
}