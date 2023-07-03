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

        String black = "Black";
        String white = "White";

        verifyPawn(black);
        verifyPawn(white);

    }

    public void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(color).isEqualTo(pawn.getColor());
    }

    @Test
    public void create_기본생성자(){
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(WHITE);
        /**
         * 초기에 color 값을 White 로 저장함으로써 error 극복
         */
    }





}