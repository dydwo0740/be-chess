package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.piecetype.Piece;
import softeer2nd.chess.pieces.piecetype.enumutils.Type;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.piecetype.Bishop.createBlackBishop;
import static softeer2nd.chess.pieces.piecetype.Bishop.createWhiteBishop;
import static softeer2nd.chess.pieces.piecetype.Blank.createBlank;
import static softeer2nd.chess.pieces.piecetype.King.createBlackKing;
import static softeer2nd.chess.pieces.piecetype.King.createWhiteKing;
import static softeer2nd.chess.pieces.piecetype.Knight.createBlackKnight;
import static softeer2nd.chess.pieces.piecetype.Knight.createWhiteKnight;
import static softeer2nd.chess.pieces.piecetype.Pawn.createBlackPawn;
import static softeer2nd.chess.pieces.piecetype.Pawn.createWhitePawn;
import static softeer2nd.chess.pieces.piecetype.Queen.createBlackQueen;
import static softeer2nd.chess.pieces.piecetype.Queen.createWhiteQueen;
import static softeer2nd.chess.pieces.piecetype.Rook.createBlackRook;
import static softeer2nd.chess.pieces.piecetype.Rook.createWhiteRook;
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
        verifyPiece(createWhitePawn(), createBlackPawn(), PAWN);
        verifyPiece(createWhiteKnight(), createBlackKnight(), KNIGHT);
        verifyPiece(createWhiteRook(), createBlackRook(), ROOK);
        verifyPiece(createWhiteBishop(), createBlackBishop(), BISHOP);
        verifyPiece(createWhiteQueen(), createBlackQueen(), QUEEN);
        verifyPiece(createWhiteKing(), createBlackKing(), KING);

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
        Piece blackBishop = createBlackBishop();
        assertThat(blackBishop.isBlack()).isTrue();
        assertThat(blackBishop.isWhite()).isFalse();

        Piece whiteBishop = createWhiteBishop();
        assertThat(whiteBishop.isWhite()).isTrue();
    }

    @Test
    public void getRepresentationPerPiece() throws Exception {
        assertEquals('p', PAWN.getWhiteRepresentation());
        assertEquals('P', PAWN.getBlackRepresentation());
    }

}