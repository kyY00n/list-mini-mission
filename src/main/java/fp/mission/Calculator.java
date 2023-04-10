package fp.mission;

import java.util.List;
import java.util.function.Predicate;

public class Calculator {

    public static int sumIf(List<Integer> numbers, Predicate<Integer> predicate) {
        int total = 0;
        for (int number : numbers) {
            if (predicate.test(number)) {
                total += number;
            }
        }
        return total;
    }
}
