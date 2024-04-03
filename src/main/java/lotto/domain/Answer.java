package lotto.domain;

public class Answer {
    private final Lotto answerNumbers;
    private final Ball bonusNumber;

    public Answer(Lotto answerNumbers, Ball bonusNumber) {
        validateBonusNumberNotInAnswerNumbers(answerNumbers, bonusNumber);
        this.answerNumbers = answerNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberNotInAnswerNumbers(Lotto answerNumbers, Ball bonusNumber){
        boolean isContain = answerNumbers.contain(bonusNumber);
        if (isContain) {
            throw new IllegalStateException("중복된 숫자가 존재합니다!");
        }
    }

    public Lotto getAnswerNumbers() {
        return this.answerNumbers;
    }

    public Ball getBonusNumber() {
        return this.bonusNumber;
    }
}
