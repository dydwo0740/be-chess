package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.pieces.Pawn;

import static org.assertj.core.api.Assertions.*;
import static softeer2nd.chess.Color.*;

class BoardTest {

    private Board board;
    private int size = 1;


    @Test
    void create(){

        board = new Board();

        saveAndCheck(WHITE);
        saveAndCheck(BLACK);

        //board.addPawn(new Integer("7"));
    }

    public void saveAndCheck(final String color) {
        Pawn pawn = new Pawn(color);
        board.addPawn(pawn);
        assertThat(board.getStore().size()).isEqualTo(size++);
        assertThat(board.findPawn(board.getStore().size() - 1)).isEqualTo(pawn);

    }

}