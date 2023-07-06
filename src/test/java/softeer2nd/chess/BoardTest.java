package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.EmptyPieceException;
import softeer2nd.chess.exception.OutOfRangeException;
import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.pieces.piecetype.Bishop;
import softeer2nd.chess.pieces.piecetype.Piece;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.piecetype.Rook;
import softeer2nd.chess.view.GameView;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.piecetype.Piece.*;
import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.Piece.Type.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

class BoardTest {

    private Board board;

    private GameChess gameChess;

    private GameView gameView;
    private int size = 1;

    @BeforeEach
    void before() {
        board = new Board();
        gameChess = board.getGameChess();
        gameView = board.getGameView();
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
        System.out.println("===============");
        gameView.print();
        System.out.println("================");
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
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
        assertEquals(32, board.pieceCount());
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

        assertThat(board.findByColorAndType(BLACK, BISHOP)).isEqualTo(2);
        assertThat(board.findByColorAndType(BLACK, PAWN)).isEqualTo(8);
    }

    @Test
    public void findPiece() throws Exception {
        assertEquals(createBlack(ROOK), gameChess.findByLocation("a8"));
        assertEquals(createBlack(ROOK), gameChess.findByLocation("h8"));
        assertEquals(createWhite(ROOK), gameChess.findByLocation("a1"));
        assertEquals(createWhite(ROOK), gameChess.findByLocation("h1"));
    }

    @Test
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = createBlack(ROOK);

        gameChess.move(position, piece);
        gameView.print();
        assertEquals((Piece) gameChess.findByLocation(position), (Piece) piece);
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
    public void set(){
        gameChess.move("a1", "b3");
        gameView.print();
    }

    @Test
    public void caculcatePoint() throws Exception {
        board.initializeEmpty();


        addPiece("b6", createBlack(PAWN));
        addPiece("e6", createBlack(QUEEN));
        addPiece("b8", createBlack(KING));
        addPiece("c8", createBlack(ROOK));

        addPiece("f2", createWhite(PAWN));
        addPiece("g2", createWhite(PAWN));
        addPiece("e1", createWhite(ROOK));
        addPiece("f1", createWhite(KING));


        assertEquals(15.0, board.caculcatePoint(BLACK), 0.01);
        assertEquals(7.0, board.caculcatePoint(WHITE), 0.01);

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

        addPiece("f1", createWhite(PAWN));
        addPiece("f2", createWhite(PAWN));
        addPiece("f3", createWhite(PAWN));

        assertEquals(1.5, board.caculcatePoint(WHITE));

    }

    @Test
    public void checkPoint(){
        board.initializeEmpty();
        addPiece("a1", createBlack(KNIGHT));
        addPiece("a2", createBlack(KNIGHT));
        assertEquals(5.0, board.caculcatePoint(BLACK));

    }

    private void addPiece(String position, Piece piece) {
        gameChess.move(position, piece);
    }

    @Test
    public void moveTest() throws Exception {
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        board.getGameChess().move(sourcePosition, targetPosition);
        assertEquals(createBlack(NO_PIECE), gameChess.findByLocation(sourcePosition));
        assertEquals(createWhite(PAWN), gameChess.findByLocation(targetPosition));
    }

}