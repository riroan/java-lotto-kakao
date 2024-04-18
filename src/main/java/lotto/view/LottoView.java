package lotto.view;

import lotto.domain.*;
import lotto.enums.Ranking;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoView {
    private static final Scanner scan = new Scanner(System.in);

    public long inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = scan.nextLine();
        return Long.parseLong(money);
    }

    public int inputNumberOfManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String count = scan.nextLine();
        return Integer.parseInt(count);
    }

    public void printLottos(Lottos lottos) {
        int size = lottos.getSize();
        System.out.printf("%d개를 구매했습니다.\n", size);

        for (int i = 0; i < size; i++) {
            System.out.println(lottos.get(i));
        }

        System.out.println();
    }

    private List<Integer> stringToNumbers(String numbers) {
        return Arrays.stream(numbers.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public WinningNumber inputAnswer() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String answerLotto = scan.nextLine();
        List<Integer> answerNumbers = stringToNumbers(answerLotto);

        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusBallNumberInput = scan.nextLine();
        int bonusBallNumber = Integer.parseInt(bonusBallNumberInput);

        System.out.println();

        return createLotto(answerNumbers, bonusBallNumber);
    }

    private WinningNumber createLotto(List<Integer> answerNumbers, int bonusBallNumber) {
        List<Ball> answerBalls = answerNumbers.stream()
                .map(Ball::new)
                .collect(Collectors.toList());
        Ball bonusBall = new Ball(bonusBallNumber);
        Lotto answer = new Lotto(answerBalls);
        return new WinningNumber(answer, bonusBall);
    }

    public void printResult(Result result) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        List<Ranking> winRanks = Arrays.stream(Ranking.values())
                .filter(rank -> rank != Ranking.FAIL)
                .collect(Collectors.toList());
        for (Ranking rank : winRanks) {
            String desc = getIndividualRankingDesc(rank);
            long price = rank.getValue();
            int count = result.getScore(rank);

            System.out.println(desc + String.format("(%d원)- %d개", price, count));
        }
    }

    public void printManualLottosDescription() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public List<Integer> inputManualLottos() {

        String lottoNumbers = scan.nextLine();
        return stringToNumbers(lottoNumbers);
    }

    private String getGainOrLoss(Profit profit) {
        long integerPart = profit.getIntegerPart();
        long decimalPart = profit.getDecimalPart();

        if (integerPart == 1 && decimalPart == 0) {
            return "이익도 손해도 아니";
        }

        if (integerPart < 1) {
            return "손해";
        }

        return "이익이";
    }

    public void printProfit(Profit profit) {
        System.out.println("총 수익률은 " + profit.toString() + "입니다.(기준이 1이기 때문에 결과적으로 " + getGainOrLoss(profit) + "라는 의미임)");
    }

    private String getIndividualRankingDesc(Ranking rank) {
        if (rank == Ranking.FIRST) {
            return "6개 일치 ";
        }

        if (rank == Ranking.SECOND) {
            return "5개 일치, 보너스 볼 일치 ";
        }

        if (rank == Ranking.THIRD) {
            return "5개 일치 ";
        }

        if (rank == Ranking.FOURTH) {
            return "4개 일치 ";
        }

        if (rank == Ranking.FIFTH) {
            return "3개 일치 ";
        }

        return "";
    }
}
