package lotto.controller;

import lotto.domain.dto.BonusNumberDto;
import lotto.domain.dto.DrawingResultDto;
import lotto.domain.dto.LottosDto;
import lotto.domain.dto.PurchaseAmountDto;
import lotto.domain.dto.WinningLottoDto;
import lotto.service.LottoMachine;
import lotto.validator.BonusNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void start() {
        purchaseLotto();
    }

    private LottosDto purchaseLotto() {
        PurchaseAmountDto purchaseAmountDto = inputView.inputPurchaseAmount();
        LottosDto lottosDto = lottoMachine.issuedLottos(purchaseAmountDto);
        outputView.printPurchaseQuantityLottos(purchaseAmountDto);
        outputView.printIssuedPurchaseResult(lottosDto);

        return lottosDto;
    }


    private void validateBonusNumberDuplicate(final WinningLottoDto winningLottoDto,
                                              final BonusNumberDto bonusNumberDto) {
        boolean isDuplicate = winningLottoDto.numbers().contains(bonusNumberDto.number());

        if (isDuplicate) {
            throw new IllegalArgumentException(BonusNumberValidator.DUPLICATE_NUMBER_MESSAGE);
        }
    }
}