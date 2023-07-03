package softeer2nd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HelloTest {

    @Test
    @DisplayName("간단 테스트")
    void hello() {
        int a = 777;
        assertThat(a).isEqualTo(777);
    }

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다.")
    public void create() {

    }
}