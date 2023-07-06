package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.BlackOnly.*;
import static softeer2nd.chess.Gate.*;
import static softeer2nd.chess.WhiteOnly.*;

class GateTest {
    private Board board;

    @BeforeEach
    public void before(){
        board = new Board();
        board.initialize();
    }

    @Test
    public void gateWorking(){
        boolean reverse = true;
        addAllPiece(board);
        printWhitePiece(reverse);
        printBlackPiece(reverse);
        Gate.clear();

        reverse = !reverse;
        addAllPiece(board);
        printWhitePiece(reverse);
        printBlackPiece(reverse);
        Gate.clear();
    }

}