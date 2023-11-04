package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int SIZE = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final String INVALID_LOTTO_SIZE_MESSAGE = "당첨 번호는 숫자 " + SIZE + "개여야 합니다.";
    public static final String DUPLICATE_NUMBERS_MESSAGE = "당첨 번호를 중복되지 않아야 합니다";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateNumberSize(final List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_MESSAGE);
        }
    }

    private void validateDuplicateNumbers(final List<Integer> numbers) {
        for (Integer number : numbers) {
            long count = numbers.stream().filter(num -> num.equals(number)).count();

            if (count > 1) {
                throw new IllegalArgumentException(DUPLICATE_NUMBERS_MESSAGE);
            }
        }
    }
}