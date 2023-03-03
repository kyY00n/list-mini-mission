package list.arraylist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SimpleArrayListTest {
    SimpleArrayList arrayList;

    @BeforeEach
    void setUp() {
        arrayList = new SimpleArrayList();
    }
    
    @DisplayName("add는")
    @Nested
    class AddTest {
        @DisplayName("배열에 값을 더할 수 있다.")
        @Test
        void add() {
            assertThat(arrayList.add("hi")).isTrue();
        }

        @DisplayName("배열에 값을 계속 더할 수 있다.")
        @Test
        void keepAdding() {
            assertDoesNotThrow(() -> {
                for (int __ = 0; __ < 100; __++) {
                    arrayList.add("hi");
                }
            });
        }

        @DisplayName("값을 추가하면 그 값이 포함되어있다.")
        @ParameterizedTest
        @ValueSource(strings = {"fourth", "fifth", "sixth"})
        void containsAfterAddition(String element) {
            arrayList.add(element);
            assertThat(arrayList.contains(element)).isTrue();
        }

    }

    @DisplayName("contains는")
    @Nested
    class ContainsTest {
        @DisplayName("추가한 요소에 대해서 true를 반환한다.")
        @Test
        void returnTrueWhenAddedElement() {
            //given
            arrayList.add("hi");
            //when
            boolean contains = arrayList.contains("hi");
            //then
            assertThat(contains).isTrue();
        }

        @DisplayName("추가한 요소에 대해서 false를 반환한다.")
        @Test
        void returnFalseWhen() {
            //given
            //when
            boolean contains = arrayList.contains("hey");
            //then
            assertThat(contains).isFalse();
        }
    }

}