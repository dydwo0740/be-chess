package softeer2nd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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





}