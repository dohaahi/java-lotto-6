package lotto.domain;

import java.util.List;
import lotto.domain.dto.BonusNumberDto;
import lotto.domain.dto.WinningLottoDto;
import lotto.validator.LottoValidator;

public class Lotto {
    public static final int SIZE = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = sort(numbers);
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    public int matchWinningLottoCount(final WinningLottoDto winningLottoDto) {
        int matchCount = 0;

        for (Integer number : numbers) {
            matchCount += (int) winningLottoDto.numbers().stream().filter(winningNumber -> winningNumber.equals(number))
                    .count();
        }

        return matchCount;
    }

    public boolean hasBonusNumber(final BonusNumberDto bonusNumberDto) {
        return numbers.stream().anyMatch(i -> i.equals(bonusNumberDto.number()));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}