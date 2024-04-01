package lotto;

public class Answer {
    private Lotto answerNumbers;
    private Ball bonusNumber;

    public Answer(Lotto answerNumbers, Ball bonusNumber) {
        validateBonusNumberNotInAnswerNumbers(answerNumbers, bonusNumber);
        this.answerNumbers = answerNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberNotInAnswerNumbers(Lotto answerNumbers, Ball bonusNumber){
        boolean isContain = answerNumbers.contain(bonusNumber);
        if (isContain) {
            throw new RuntimeException();
        }
    }

    public Lotto getAnswerNumbers() {
        return this.answerNumbers;
    }

    public Ball getBonusNumber() {
        return this.bonusNumber;
    }
}
