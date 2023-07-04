package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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
    void create_piece(){
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE, Piece.WHITE_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK, Piece.BLACK_REPRESENTATION);

    }

    private void verifyPiece(final Piece piece, final String color, final char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }








}