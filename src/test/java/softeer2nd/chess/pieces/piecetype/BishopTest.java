package softeer2nd.chess.pieces.piecetype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.exception.NeverReach;
import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.view.GameView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static softeer2nd.chess.pieces.piecetype.Bishop.createBlackBishop;
import static softeer2nd.chess.pieces.piecetype.Blank.createBlank;
import static softeer2nd.chess.pieces.piecetype.King.createBlackKing;
import static softeer2nd.chess.pieces.piecetype.King.createWhiteKing;



class BishopTest {
    private Board board;
    private GameChess gameChess;
    private GameView gameView;
    @BeforeEach
    public void before(){
        board = new Board();
        board.initializeEmpty();
        gameChess = new GameChess(board);
        gameView = new GameView(board);
    }
    @Test
    @DisplayName("재귀가 잘 동작하는지에 대한 test")
    public void recursionTest(){
        board.initializeEmpty();
        gameChess.move("a1", createBlackBishop());
        gameChess.move("a1", "h8");
        assertThat(gameChess.findPiece("h8")).isEqualTo(createBlackBishop());
        assertThat(gameChess.findPiece("a1")).isEqualTo(createBlank());
    }
    @Test
    @DisplayName("bishop의 움직임에 같은 색 기물이 있을때")
    void bishopMoveV1(){
        board.initializeEmpty();
        gameChess.move("a1", createBlackBishop());
        gameChess.move("b2", createBlackKing());
        assertThatThrownBy(()-> gameChess.move("a1", "b2")).isInstanceOf(NeverReach.class);
    }
    @Test
    @DisplayName("bishop의 움직임에 다른 색 기물이 있을때")
    void kingMoveV2(){
        board.initializeEmpty();
        gameChess.move("a1", createBlackKing());
        gameChess.move("b2", createWhiteKing());
        gameChess.move("a1", "b2");
        assertThat(gameChess.findPiece("b2")).isEqualTo(createBlackKing());
    }

}