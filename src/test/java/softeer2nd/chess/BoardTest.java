package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.EmptyPieceException;
import softeer2nd.chess.exception.OutOfRangeException;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.Piece;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Piece.*;
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
        assertThatThrownBy(() -> new Position(0, 9)).isInstanceOf(OutOfRangeException.class);

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
        assertEquals(createBlackRook(), board.findByLocation("a8"));
        assertEquals(createBlackRook(), board.findByLocation("h8"));
        assertEquals(createWhiteRook(), board.findByLocation("a1"));
        assertEquals(createWhiteRook(), board.findByLocation("h1"));
    }

    @Test
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = createBlackRook();
        board.move(position, piece);

        assertEquals(piece, board.findByLocation(position));
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("이동시에 기물의 예외사항 체크")
    public void moveError(){
        // 이동시키고 싶은 위치에 기물이 존재하지 않을때
        board.print();
        assertThatThrownBy(()->board.move("a3", "b2")).isInstanceOf(EmptyPieceException.class);
    }

    @Test
    public void set(){
        board.move("a1", "b3");
        board.print();
    }

    @Test
    public void caculcatePoint() throws Exception {
        board.initializeEmpty();


        addPiece("b6", createBlackPawn());
        addPiece("e6", createBlackQueen());
        addPiece("b8", createBlackKing());
        addPiece("c8", createBlackRook());

        addPiece("f2", createWhitePawn());
        addPiece("g2", createWhitePawn());
        addPiece("e1", createWhiteRook());
        addPiece("f1", createWhiteKing());


        assertEquals(15.0, board.caculcatePoint(BLACK), 0.01);
        assertEquals(7.0, board.caculcatePoint(WHITE), 0.01);

        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("같은 세로줄에 있는 폰에 대해서는 0.5점 처리를 할수 있도록 구현합니다.")
    public void testPawnChecker(){
        board.initializeEmpty();
        /**
         * .KR.....  8
         * P.PB....  7
         * .P..Q...  6
         * ........  5
         * .....nq.  4
         * .....p.p  3
         * .....pp.  2
         * ....rk.. 1
         *
         * abcdefgh
         */

        addPiece("f1", createWhitePawn());
        addPiece("f2", createWhitePawn());
        addPiece("f3", createWhitePawn());

        assertEquals(1.5, board.caculcatePoint(WHITE));

    }

    @Test
    public void checkPoint(){
        board.initializeEmpty();
        addPiece("a1", createBlackKnight());
        addPiece("a2", createBlackKnight());
        assertEquals(5.0, board.caculcatePoint(BLACK));

    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }

    @Test
    public void moveTest() throws Exception {
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        board.move(sourcePosition, targetPosition);
        assertEquals(createBlank(), board.findByLocation(sourcePosition));
        assertEquals(createWhitePawn(), board.findByLocation(targetPosition));
    }

}