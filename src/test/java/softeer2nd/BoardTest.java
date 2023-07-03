package softeer2nd;

import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.pieces.Pawn;

import static org.assertj.core.api.Assertions.*;
import static softeer2nd.chess.Color.*;

class BoardTest {

    @Test
    void create(){
        Board board = new Board();

        Pawn white = new Pawn(WHITE);
        board.addPawn(white);
        assertThat(board.getStore().size()).isEqualTo(1);
        assertThat(board.findPawn(board.getStore().size() - 1)).isEqualTo(white);

        Pawn black = new Pawn(BLACK);
        board.addPawn(black);
        assertThat(board.getStore().size()).isEqualTo(2);
        assertThat(board.findPawn(board.getStore().size() - 1)).isEqualTo(black);
    }

}