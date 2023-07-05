package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.utils.StringUtils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.utils.StringUtils.*;

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
    void create_piece() {
        verifyPiece(Piece.createWhitePawn(), WHITE, WHITE_PAWN);
        verifyPiece(Piece.createBlackPawn(), BLACK, BLACK_PAWN);

        verifyPiece(Piece.createWhiteKnight(), WHITE, WHITE_KNIGHT);
        verifyPiece(Piece.createBlackKnight(), BLACK, BLACK_KNIGHT);

        verifyPiece(Piece.createWhiteRook(), WHITE, WHITE_ROOK);
        verifyPiece(Piece.createBlackRook(), BLACK, BLACK_ROOK);


        verifyPiece(Piece.createWhiteBishop(), WHITE, WHITE_BISHOP);
        verifyPiece(Piece.createBlackBishop(), BLACK, BLACK_BISHOP);

        verifyPiece(Piece.createWhiteKing(), WHITE, WHITE_KING);
        verifyPiece(Piece.createBlackKing(), BLACK, BLACK_KING);

        verifyPiece(Piece.createWhiteQueen(), WHITE, WHITE_QUEEN);
        verifyPiece(Piece.createBlackQueen(), BLACK, BLACK_QUEEN);

    }

    private void verifyPiece(final Piece piece, final String color, final char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    @Test
    @DisplayName("검은색 기물인지 흰색 기물인지를 파악하는 능력을 기릅니다.")
    public void colorFinder(){
        Piece blackBishop = Piece.createBlackBishop();
        assertThat(blackBishop.isBlack()).isTrue();
        assertThat(blackBishop.isWhite()).isFalse();

        Piece whiteBishop = Piece.createWhiteBishop();
        assertThat(whiteBishop.isWhite()).isTrue();
    }

    @Test
    public void getRepresentationPerPiece() throws Exception {
        assertEquals('p', Piece.Type.PAWN.getWhiteRepresentation());
        assertEquals('P', Piece.Type.PAWN.getBlackRepresentation());
    }

}