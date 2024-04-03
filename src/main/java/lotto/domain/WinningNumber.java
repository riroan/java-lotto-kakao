package lotto.domain;

public class WinningNumber {
    private final Lotto winningNumbers;
    private final Ball bonusNumber;

    public WinningNumber(Lotto winningNumbers, Ball bonusNumber) {
        validateBonusNumberNotInWinningNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberNotInWinningNumbers(Lotto winningNumbers, Ball bonusNumber){
        boolean isContain = winningNumbers.contain(bonusNumber);
        if (isContain) {
            throw new IllegalStateException("중복된 숫자가 존재합니다!");
        }
    }

    public Lotto getWinningNumbers() {
        return this.winningNumbers;
    }

    public Ball getBonusNumber() {
        return this.bonusNumber;
    }
}
