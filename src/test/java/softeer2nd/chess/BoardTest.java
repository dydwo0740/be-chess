package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.EmptyPieceException;
import softeer2nd.chess.exception.OutOfRangeException;
import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.pieces.piecetype.Piece;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.piecetype.enumutils.Type;
import softeer2nd.chess.view.GameView;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.PieceFactory.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

class BoardTest {

    private Board board;

    private GameChess gameChess;

    private GameView gameView;
    private int size = 1;

    @BeforeEach
    void before() {
        board = new Board();
        gameChess = new GameChess(board);
        gameView = new GameView(board);
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
        gameView.print();
        assertThat(gameChess.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(gameChess.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    void print() {
        gameView.print();
    }

    @Test
    @DisplayName("만약 체스판의 범위가 넘어버리는 경우")
    void outOfRangeException(){
        assertThatThrownBy(() -> new Position("a9")).isInstanceOf(OutOfRangeException.class);

    }

    @Test
    public void create() throws Exception {
        assertEquals(32, gameChess.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                gameView.showBoard());
    }

    @Test
    public void checkFindByColorAndType(){

        assertThat(gameChess.findByColorAndType(BLACK, Type.BISHOP)).isEqualTo(2);
        assertThat(gameChess.findByColorAndType(BLACK, PAWN)).isEqualTo(8);
    }

    @Test
    public void findPiece() throws Exception {

        assertEquals(createBlackRook(), gameChess.findPiece("a8"));
        assertEquals(createBlackRook(), gameChess.findPiece("h8"));
        assertEquals(createWhiteRook(), gameChess.findPiece("a1"));
        assertEquals(createWhiteRook(), gameChess.findPiece("h1"));
    }

    @Test
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = createBlackRook();
        gameChess.move(position, piece);
        assertEquals(gameChess.findPiece(position), piece);
    }

    @Test
    public void objectEquals(){


    }

    @Test
    @DisplayName("이동시에 기물의 예외사항 체크")
    public void moveError(){
        // 이동시키고 싶은 위치에 기물이 존재하지 않을때
        gameView.print();
        assertThatThrownBy(()->gameChess.move("a3", "b2")).isInstanceOf(EmptyPieceException.class);
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


        assertEquals(15.0, gameChess.calculatePoint(BLACK), 0.01);
        assertEquals(7.0, gameChess.calculatePoint(WHITE), 0.01);

        System.out.println(gameView.showBoard());
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

        assertEquals(1.5, gameChess.calculatePoint(WHITE));

    }

    @Test
    public void checkPoint(){
        board.initializeEmpty();
        addPiece("a1", createBlackKnight());
        addPiece("a2", createBlackKnight());
        assertEquals(5.0, gameChess.calculatePoint(BLACK));

    }

    private void addPiece(String position, Piece piece) {
        gameChess.move(position, piece);
    }

    @Test
    public void moveTest() throws Exception {
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        gameChess.move(sourcePosition, targetPosition);
        assertEquals(createBlank(), gameChess.findPiece(sourcePosition));
        assertEquals(createWhitePawn(), gameChess.findPiece(targetPosition));
    }

}