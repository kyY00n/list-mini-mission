package list.arraylist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ListStudyTest {
    ArrayList<String> values;

    @BeforeEach
    void setUp() {
        values = new ArrayList<>();
        values.add("first");
        values.add("second");
        values.add("third");
    }

    @DisplayName("값을 추가하면 그 값이 포함되어있다.")
    @ParameterizedTest
    @ValueSource(strings = {"fourth", "fifth", "sixth"})
    void containsAfterAddition(String element) {
        values.add(element);
        assertThat(values).contains(element);
    }

    @DisplayName("값을 추가한 뒤 사이즈가 늘어난다.")
    @Test
    void sizeAfterAddition() {
        assertThat(values.size()).isEqualTo(3);
    }

    @DisplayName("첫 번째 값을 찾는다.")
    @Test
    void getFirstValue() {
        assertThat(values.get(0)).isEqualTo("first");
    }

    @DisplayName("첫 번째로 넣은 요소가 들어있는지 구한다.")
    @Test
    void contains() {
        assertThat(values.contains("first")).isTrue();
    }

    @DisplayName("인덱스로 요소를 삭제하면 값을 가져온다.")
    @Test
    void remove() {
        assertThat(values.remove(0)).isEqualTo("first");
    }

    @DisplayName("요소를 삭제하면 사이즈가 줄어든다.")
    @Test
    void sizeAfterRemove() {
        values.remove(0);
        assertThat(values.size()).isEqualTo(2);
    }

    @DisplayName("요소를 변경할 수 있다.")
    @Test
    void setElement() {
        values.set(0, "changed");
        assertThat(values.get(0)).isEqualTo("changed");
    }

    @DisplayName("아무것도 없을 때 예외를 반환한다.")
    @Test
    void setElementForEmptyList() {
        List<String> values = new ArrayList<>();
        assertThatThrownBy(() -> values.set(0, "hi"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @DisplayName("null 로 설정할 때")
    @Test
    void setToNull() {
        String result = values.set(0, null);
        System.out.println(result);
        System.out.println(values.get(0) == null);
    }

    @DisplayName("포함된 요소값을 넣으면 삭제가 되고 true를 반환한다.")
    @Test
    void removeExistingElement() {
        assertThat(values.remove("first")).isTrue();
    }

    @DisplayName("포함되지 않은 요소값을 넣으면 false를 반환한다.")
    @Test
    void removeElement() {
        assertThat(values.remove("hi")).isFalse();
    }

    @DisplayName("clear를 하면 리스트가 비어있다.")
    @Test
    void claer() {
        //given
        //when
        values.clear();
        //then
        assertThat(values.isEmpty()).isTrue();
    }

    @DisplayName("remove(int)를 했을 때 요소가 null 일 경우")
    @Test
    void removeNullValue() {
        //given
        List<String> values = new ArrayList<>();
        values.add(null);
        String removed = values.remove(0);
        assertThat(removed).isNull();
    }

    @DisplayName("remove(int): 올바르지 않은 인덱스일 경우")
    @Test
    void removeByInvalidIndex() {
        assertThatThrownBy(() -> values.remove(10))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
