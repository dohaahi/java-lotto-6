package lotto.validator;

import java.util.regex.Pattern;

public class InputValidator {
    public static final String WINNING_NUMBERS_REGEX = "^[0-9,]+$";
    public static final String DELIMITER = ",";
    public static final String WRONG_INPUT_PURCHASE_AMOUNT_MESSAGE = "구입 금액은 숫자로 입력해주세요.";
    public static final String WRONG_INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호는 숫자와 '" + DELIMITER + "'만을 사용하여 입력해주세요.";

    public static void validatePurchaseAmount(final String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(WRONG_INPUT_PURCHASE_AMOUNT_MESSAGE);
        }
    }

    public static void validateWinningNumbers(final String input) {
        if (!isMatchedWinningNumbersRegex(input)) {
            throw new IllegalArgumentException(WRONG_INPUT_WINNING_NUMBERS_MESSAGE);
        }
    }

    private static boolean isMatchedWinningNumbersRegex(final String input) {
        return Pattern.matches(WINNING_NUMBERS_REGEX, input);
    }
}
