package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.EmptyPieceException;
import softeer2nd.chess.exception.NotEmptyPieceException;
import softeer2nd.chess.exception.OutOfRangeException;
import softeer2nd.chess.pieces.Location;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Piece.Color;
import softeer2nd.chess.pieces.Piece.Type;
import softeer2nd.utils.StringUtils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Piece.Color.*;
import static softeer2nd.chess.pieces.Piece.Type.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

class BoardTest {

    private Board board;
    private int size = 1;

    @BeforeEach
    void before() {
        board = new Board();
        board.initialize();
    }


    /*@Test
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

    }*/

    @Test
    void initialize() {
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    void print() {
        board.print();
    }

    @Test
    @DisplayName("만약 체스판의 범위가 넘어버리는 경우")
    void outOfRangeException(){
        assertThatThrownBy(() -> new Location(0, 9)).isInstanceOf(OutOfRangeException.class);

    }

    @Test
    public void create() throws Exception {
        assertEquals(32, board.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.showBoard());
    }

    @Test
    public void checkFindByColorAndType(){
        assertThat(board.findByColorAndType(BLACK, BISHOP)).isEqualTo(2);
        assertThat(board.findByColorAndType(BLACK, PAWN)).isEqualTo(8);
    }

    @Test
    public void findPiece() throws Exception {
        assertEquals(Piece.createBlackRook(), board.findByLocation("a8"));
        assertEquals(Piece.createBlackRook(), board.findByLocation("h8"));
        assertEquals(Piece.createWhiteRook(), board.findByLocation("a1"));
        assertEquals(Piece.createWhiteRook(), board.findByLocation("h1"));
    }

    @Test
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertEquals(piece, board.findByLocation(position));
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("이동시에 기물의 예외사항 체크")
    public void moveError(){
        // 이동시키고 싶은 위치에 기물이 존재하지 않을때
        board.print();
        assertThatThrownBy(()->board.set("a3", "b2")).isInstanceOf(EmptyPieceException.class);
    }

    @Test
    public void set(){
        board.set("a1", "b3");
        board.print();
    }

    @Test
    public void caculcatePoint() throws Exception {
        board.initializeEmpty();
        

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());


        assertEquals(15.0, board.caculcatePoint(BLACK), 0.01);
        assertEquals(7.0, board.caculcatePoint(WHITE), 0.01);

        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }
}