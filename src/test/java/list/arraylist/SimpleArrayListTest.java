package list.arraylist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    @DisplayName("contains는")
    @Nested
    class ContainsTest {
        @DisplayName("추가한 요소에 대해서 true를 반환한다.")
        @Test
        void returnTrueWhenAddedElement() {
            //given
            simpleArrayList.add("hi");
            //when
            boolean contains = simpleArrayList.contains("hi");
            //then
            assertThat(contains).isTrue();
        }

        @DisplayName("추가한 요소에 대해서 false를 반환한다.")
        @Test
        void returnFalseWhen() {
            //given
            //when
            boolean contains = simpleArrayList.contains("hey");
            //then
            assertThat(contains).isFalse();
        }
    }

}