# 스트림 미션

## 미션1

> techcourse.fp.mission.Car
> CarTest에서 MoveStrategy에 대한 익명 클래스로 구현하고 있는데 (인텔리제이의 도움없이) 람다를 적용해 구현한다.

## 미션2

> techcourse.fp.mission.Calculator
> List에 담긴 값 중 3보다 큰 수만을 더해야 한다.
>

sumAll, sumAllEven, sumAllOverThree method 소스 코드를 확인하고, (Stream API를 사용하지 않고) 람다를 활용해 중복 제거한다.

## 미션3

> war-and-peace.txt 파일을 읽어 다음 요구사항을 만족해본다.
>

3-1. map, reduce, filter 실습

- StreamStudy 클래스의 countWords(), doubleNumbers(), sumAll() 메서드를 Stream API를 사용하여 리팩토링한다.

3-2. map, reduce, filter 실습

- List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다.
- 지금까지 학습한 map, reduce, filter를 활용해 구현해야 한다.

sumOverThreeAndDouble() 테스트를 pass해야 한다.

3-3. map, reduce, filter 실습

printLongestWordTop100() 메서드를 구현한다. 요구사항은 다음과 같다.

- 단어의 길이가 12자를 초과하는 단어를 추출한다.
- 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
- 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
- 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.