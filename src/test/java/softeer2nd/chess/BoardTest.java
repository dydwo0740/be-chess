package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;

import static org.assertj.core.api.Assertions.*;
import static softeer2nd.chess.Color.*;

class BoardTest {

    private Board board;
    private int size = 1;

    @BeforeEach
    void before(){
        board = new Board();
    }


    @Test
    void create(){

        saveAndCheck(WHITE);
        saveAndCheck(BLACK);



        //board.addPawn(new Integer("7"));
    }

    public void saveAndCheck(final String color) {
        Piece piece = new Piece(color);
        board.addPawn(piece);
        assertThat(board.getStore().size()).isEqualTo(size++);
        assertThat(board.findPawn(board.getStore().size() - 1)).isEqualTo(piece);

    }

    @Test
    void initialize(){
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    void print(){
        board.print();
    }

}