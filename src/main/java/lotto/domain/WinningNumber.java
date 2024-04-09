package lotto.domain;

import lotto.enums.Ranking;

public class WinningNumber {
    private final Lotto winningNumbers;
    private final Ball bonusNumber;

    public WinningNumber(Lotto winningNumbers, Ball bonusNumber) {
        validateBonusNumberNotInWinningNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberNotInWinningNumbers(Lotto winningNumbers, Ball bonusNumber) {
        boolean isContain = winningNumbers.contain(bonusNumber);
        if (isContain) {
            throw new IllegalStateException("중복된 숫자가 존재합니다!");
        }
    }

    public long countCorrectNumbers(Lotto lotto) {
        return winningNumbers.countCorrectNumbers(lotto);
    }

    public Ranking match(Lotto lotto) {
        long answerCount = countCorrectNumbers(lotto);
        boolean isCorrectBonusBall = hasBonusNumber(lotto);

        return Ranking.getRank(answerCount, isCorrectBonusBall);
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.contain(bonusNumber);
    }
}
