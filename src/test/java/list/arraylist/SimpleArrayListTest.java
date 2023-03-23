package list.arraylist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
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


        @DisplayName("사이즈가 늘어난다.")
        @Test
        void addAndThenSize() {
            arrayList.add("hihi");
            assertThat(arrayList).extracting("size").isEqualTo(1);
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

    @DisplayName("size는")
    @Nested
    class SizeTest {
        @DisplayName("아무것도 넣지 않았을 때 0이다.")
        @Test
        void returnZeroWhenInitialized() {
            //given
            //when
            //then
            assertThat(arrayList.size()).isEqualTo(0);
        }

        @DisplayName("값을 추가한 뒤 사이즈가 늘어난다.")
        @Test
        void sizeAfterAddition() {
            //given
            arrayList.add("hihi");
            arrayList.add("hihi");
            arrayList.add("hihi");
            //when
            //then
            assertThat(arrayList.size()).isEqualTo(3);
        }

        @DisplayName("capacity까지 추가해도 사이즈를 제대로 계산한다.")
        @Test
        void sizeTilCapacity() {
            //given
            for (int __ = 0; __ < 10; __++) {
                arrayList.add("hihi");
            }
            //when
            //then
            assertThat(arrayList.size()).isEqualTo(10);
        }

        @DisplayName("아무것도 추가하지 않으면 0을 반환한다.")
        @Test
        void returnZero() {
            //given
            //when
            //then
            assertThat(arrayList.size()).isEqualTo(0);
        }
    }

    @DisplayName("isEmpty는")
    @Nested
    class IsEmptyTest {
        @DisplayName("아무것도 넣지 않았을 때 true를 반환한다.")
        @Test
        void returnTrue() {
            //given
            //when
            boolean empty = arrayList.isEmpty();
            //then
            assertThat(empty).isTrue();
        }

        @DisplayName("요소를 넣은 후에는 false를 반환한다.")
        @Test
        void returnFalse() {
            //given
            arrayList.add("hihi");
            //when
            boolean empty = arrayList.isEmpty();
            //then
            assertThat(empty).isFalse();
        }
    }

    @DisplayName("get은")
    @Nested
    class GetTest {
        @DisplayName("올바르지 않은 인덱스로 get을 하는 경우")
        @Test
        void whenInvalidIndex() {
            // java.lang.IndexOutOfBoundsException: Index 100 out of bounds for length "currentLength"
            assertThatThrownBy(() -> arrayList.get(100))
                    .isInstanceOf(IndexOutOfBoundsException.class);
        }

        @DisplayName("음수를 인자로 받는 경우")
        @Test
        void whenNegative() {
            assertThatThrownBy(() -> arrayList.get(-1))
                    .isInstanceOf(IndexOutOfBoundsException.class);
        }

        @DisplayName("요소를 가져올 수 있다.")
        @Test
        void multiple() {
            //given
            arrayList.add("hihi");
            //when
            String getResult = arrayList.get(0);
            //then
            assertThat(getResult).isEqualTo("hihi");
        }
    }

    @DisplayName("set은")
    @Nested
    class SetTest {
        @DisplayName("올바르지 않은 인덱스일 경우 예외가 발생한다.")
        @Test
        void throwExceptionWhenIndexOutOfRange() {
            assertThatThrownBy(() -> arrayList.set(-1, "츄잉껌"))
                    .isInstanceOf(IndexOutOfBoundsException.class);
        }

        @DisplayName("요소를 변경할 수 있다.")
        @Test
        void setElement() {
            arrayList.add("hihi");
            arrayList.set(0, "changed");
            assertThat(arrayList.get(0)).isEqualTo("changed");
        }

        @DisplayName("요소를 변경할 수 있다.")
        @Test
        void setElementToNull() {
            arrayList.add("hihi");
            arrayList.set(0, null);
            assertThat(arrayList.size()).isEqualTo(1);
            assertThat(arrayList.get(0)).isNull();
        }

        @DisplayName("아무것도 없을 때 예외를 반환한다.")
        @Test
        void setElementForEmptyList() {
            List<String> values = new ArrayList<>();
            assertThatThrownBy(() -> values.set(0, "hi"))
                    .isInstanceOf(IndexOutOfBoundsException.class);
        }
    }

    @DisplayName("remove(String)은")
    @Nested
    class RemoveByValueTest {
        @DisplayName("포함된 요소값을 넣으면 삭제가 되고 true를 반환한다.")
        @Test
        void removeExistingElement() {
            arrayList.add("first");
            assertThat(arrayList.remove("first")).isTrue();
        }

        @DisplayName("포함되지 않은 요소값을 넣으면 false를 반환한다.")
        @Test
        void removeElement() {
            arrayList.add("hihi");
            assertThat(arrayList.remove("hi")).isFalse();
        }

        @DisplayName("실행된 뒤 사이즈가 변한다.")
        @Test
        void andThenSizeDecrease() {
            //given
            arrayList.add("hihi");
            arrayList.add("byebye");
            //when
            arrayList.remove("hihi");
            //then
            assertThat(arrayList.size()).isEqualTo(1);
        }

    }

    @DisplayName("remove(int)는")
    @Nested
    class RemoveByIndexTest {
        @DisplayName("삭제된 값을 반환한다.")
        @Test
        void removeExistingElement() {
            //given
            arrayList.add("first");
            //when
            //then
            assertThat(arrayList.remove(0)).isEqualTo("first");
        }

        @DisplayName("인자 범위가 올바르지 않은 경우 예외가 발생한다.")
        @Test
        void removeElement() {
            //given
            //when
            //then
            assertThatThrownBy(() -> arrayList.remove(0))
                    .isInstanceOf(IndexOutOfBoundsException.class);
        }

        @DisplayName("실행된 뒤 사이즈가 변한다.")
        @Test
        void andThenSizeDecrease() {
            //given
            arrayList.add("hihi");
            arrayList.add("byebye");
            //when
            arrayList.remove(0);
            //then
            assertThat(arrayList.size()).isEqualTo(1);
        }

        @DisplayName("실행된 뒤 다른 원소들이 없어지지 않는다.")
        @Test
        void doesntRemoveOtherElements() {
            //given
            arrayList.add("byebye");
            arrayList.add("heyhey");
            arrayList.add("rosie");
            //when
            arrayList.remove(1);
            //then
            assertThat(arrayList.contains("byebye")).isTrue();
            assertThat(arrayList.contains("rosie")).isTrue();
        }
    }
}