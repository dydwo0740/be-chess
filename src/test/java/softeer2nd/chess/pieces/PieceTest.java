package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.piecetype.Piece;
import softeer2nd.chess.pieces.piecetype.enumutils.Type;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.piecetype.Piece.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

class PieceTest {

    /*@Test
    @DisplayName("흰색 폰이 생성되어야 합니다.")
    void create() {

        verifyPawn(Piece.WHITE, Piece.WHITE_REPRESENTATION);
        verifyPawn(Piece.BLACK, Piece.BLACK_REPRESENTATION);
    }

    public void verifyPawn(final String color, final char representation) {
        Piece piece = new Piece(color, representation);
        assertThat(color).isEqualTo(piece.getColor());
        assertThat(representation).isEqualTo(piece.getRepresentation());
    }*/

    /*@Test
    public void create_기본생성자(){
        Piece piece = new Piece();
        assertThat(piece.getColor()).isEqualTo(Piece.WHITE);
        assertThat(piece.getRepresentation()).isEqualTo(Piece.WHITE_REPRESENTATION);

         // 초기에 color 값을 White 로 저장함으로써 error 극복

    }*/


    @Test
    public void create_piece() {
        verifyPiece(createWhite(PAWN), createBlack(PAWN), PAWN);
        verifyPiece(createWhite(KNIGHT), createBlack(KNIGHT), KNIGHT);
        verifyPiece(createWhite(ROOK), createBlack(ROOK), ROOK);
        verifyPiece(createWhite(BISHOP), createBlack(BISHOP), BISHOP);
        verifyPiece(createWhite(QUEEN), createBlack(QUEEN), QUEEN);
        verifyPiece(createWhite(KING), createBlack(KING), KING);

        Piece blank = createBlank();
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());
        assertEquals(NO_PIECE, blank.getType());
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());
        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
    }


    @Test
    @DisplayName("검은색 기물인지 흰색 기물인지를 파악하는 능력을 기릅니다.")
    public void colorFinder(){
        Piece blackBishop = createBlack(BISHOP);
        assertThat(blackBishop.isBlack()).isTrue();
        assertThat(blackBishop.isWhite()).isFalse();

        Piece whiteBishop = createWhite(BISHOP);
        assertThat(whiteBishop.isWhite()).isTrue();
    }

    @Test
    public void getRepresentationPerPiece() throws Exception {
        assertEquals('p', PAWN.getWhiteRepresentation());
        assertEquals('P', PAWN.getBlackRepresentation());
    }

}