package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Pawn;

import static org.assertj.core.api.Assertions.*;
import static softeer2nd.chess.Color.*;

class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 합니다.")
    void create() {

        verifyPawn(Pawn.WHITE, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK, Pawn.BLACK_REPRESENTATION);
    }

    public void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertThat(color).isEqualTo(pawn.getColor());
        assertThat(representation).isEqualTo(pawn.getRepresentation());
    }

    @Test
    public void create_기본생성자(){
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Pawn.WHITE);
        assertThat(pawn.getRepresentation()).isEqualTo(Pawn.WHITE_REPRESENTATION);
        /**
         * 초기에 color 값을 White 로 저장함으로써 error 극복
         */
    }







}