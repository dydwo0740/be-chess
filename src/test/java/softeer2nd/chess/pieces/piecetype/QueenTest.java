package softeer2nd.chess.pieces.piecetype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
        board.initializeEmpty();
        gameChess = board.getGameChess();
        gameView = board.getGameView();
    }
    /**
     * 1. 도달 가능한 경우 (상대 컬러의 기물은 건너갈 수 있다는 가정)
     * 2. 도달 불가능한 경우 -> 해당 위치에 같은 팀의 기물 존재 or 그냥 도달 불가능 or 체스 판 밖일 경우
     */

    @Test
    @DisplayName("도달이 가능한 경우 상대 컬러의 기물이 경로에 존재하지 않는다.")
    public void canReachV1(){

    }

    @Test
    @DisplayName("도달이 가능한 경우 상대 컬러의 기물이 경로에 존재한다.")
    public void canReachV2(){

    }
}