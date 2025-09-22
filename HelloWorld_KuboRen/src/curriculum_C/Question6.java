package curriculum_C;

public class Question6 {
	public static void main(String[] args) {
		Player player = new Player();
		CPU cpu = new CPU();

		boolean win = false;

		while (!win) {
			int pHand = player.chooseHand();
			int cHand = cpu.chooseHand();

			System.out.println("あなたの手: " + player.handName(pHand));
			System.out.println("CPUの手: " + cpu.handName(cHand));

			// 勝敗の判定
			if (pHand == cHand) {
				System.out.println("あいこです。もう一度！");
			} else if ((pHand == 0 && cHand == 1) ||
					(pHand == 1 && cHand == 2) ||
					(pHand == 2 && cHand == 0)) {
				System.out.println("あなたの勝ち！");
				win = true;
			} else {
				System.out.println("あなたの負け…。もう一度！");
			}
		}
	}
}