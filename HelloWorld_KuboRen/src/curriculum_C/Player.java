package curriculum_C;

import java.util.Scanner;

public class Player {
	private Scanner scanner = new Scanner(System.in);

	public int chooseHand() {
		System.out.print("グー(0), チョキ(1), パー(2) を入力: ");
		int hand = scanner.nextInt();
		return hand;
	}

	public String handName(int hand) {
		switch (hand) {
		case 0:
			return "グー";
		case 1:
			return "チョキ";
		case 2:
			return "パー";
		default:
			return "不明";
		}
	}

	// Scannerを閉じるメソッドを追加
	public void close() {
		scanner.close();
	}
}