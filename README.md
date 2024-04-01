# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## TODO List
- [ ] 사용자가 금액 입력
- [ ] 1000으로 나누었을 때 몫만큼 구매한다.
- [ ] LottoSystem이 구매 개수 파악
- [ ] LottoSystem이 랜덤 로또 용지 생성
- [ ] LottoSystem이 로또 별 당첨 여부 확인 !
- [ ] Lottos클래스는 Lotto의 리스트를 가진다.
- [ ] Lotto의 숫자는 중복되지 않아야한다.
- [ ] Ball은 1~45에 포함되는지 확인한다.
- [ ] 랜덤을 위한 인터페이스를 개발한다.
- [ ] 사용자가 당첨 번호 입력
- [ ] 사용자가 보너스 볼 입력
- [ ] View가 일치 개수 출력
- [ ] LottoSystem이 총 수익률 계산
- [ ] View가 총 수익률 출력

lotto.compare(correct)
lottosystem.compare(lotto, correct)

Ball <- Lotto <- Lottos <- LottoSystem

                                |

                                V

                            RandomGenerator