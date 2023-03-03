package list.arraylist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleArrayListTest {
    SimpleArrayList simpleArrayList;

    @BeforeEach
    void setUp() {
        simpleArrayList = new SimpleArrayList();
    }

    @DisplayName("배열에 값을 더할 수 있다.")
    @Test
    void add() {
        assertThat(simpleArrayList.add("hi")).isTrue();
    }

    @DisplayName("배열에 값을 계속 더할 수 있다.")
    @Test
    void keepAdding() {
        assertDoesNotThrow(() -> {
            for (int __ = 0; __ < 100; __++) {
                simpleArrayList.add("hi");
            }
        });
    }

}