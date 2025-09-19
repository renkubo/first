package curriculum_B;

import java.util.Random;
import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		// Q1 for 文を使って 1 から 10 までの数字を 1 つずつ表示
		for (int num = 1; num <= 10; num++) {
			System.out.println(num);
		}

		// Q2 for 文を使って 2 から 20 までの 偶数 を 1 つずつ表示
		for (int num = 2; num <= 20; num += 2) {
			System.out.println(num);
		}

		// Q3 for 文を使って 10 から 1 まで カウントダウンして表示
		for (int num = 10; num >= 1; num--) {
			System.out.println(num);
		}

		// Q4 for 文を使って 1 から 100 までの合計 を表示
		int sum = 0;
		for (int num = 1; num <= 100; num++) {
			sum += num;
		}
		System.out.println(sum);

		// Q5 for 文を使って 以下のような三角形を出力
		for (int row = 1; row <= 5; row++) {
			for (int col = 1; col <= row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// Q6 while 文を使って 1 から 10 まで を 1 つずつ表示
		int numWhile = 1;
		while (numWhile <= 10) {
			System.out.println(numWhile);
			numWhile++;
		}

		// Q7 while 文を使って 2 から 20 までの偶数 を 1 つずつ表示
		numWhile = 2;
		while (numWhile <= 20) {
			System.out.println(numWhile);
			numWhile += 2;
		}

		// Q8 while 文を使って 10 から 1 まで のカウントダウンを表示
		numWhile = 10;
		while (numWhile >= 1) {
			System.out.println(numWhile);
			numWhile--;
		}

		// Q9 while 文を使って 1 から 100 までの合計 を表示
		numWhile = 1;
		sum = 0;
		while (numWhile <= 100) {
			sum += numWhile;
			numWhile++;
		}
		System.out.println(sum);

		// Q10 0が入力されたら終了
		while (true) {
			int input = scanner.nextInt();
			scanner.nextLine();
			if (input == 0) {
				System.out.println("終了しました");
				break;
			}
		}

		// Q11 九九表をひょうじさせる
		for (int row = 1; row <= 9; row++) {
			for (int col = 1; col <= 9; col++) {
				System.out.printf("%02d * %02d = %02d || ", col, row, row * col);
			}
			System.out.println();
		}

		// Q12 在庫管理
		String[] products = { "パソコン", "冷蔵庫", "洗濯機", "加湿器", "テレビ", "ディスプレイ" };

		int[] stock = new int[4]; // テレビ・ディスプレイ以外
		for (int stockIndex = 0; stockIndex < stock.length; stockIndex++) {
			stock[stockIndex] = random.nextInt(12);
		}

		int tvStock = random.nextInt(12); // テレビとディスプレイ共通

		System.out.println("ご希望の商品を入力してください。");
		System.out.println("パソコン, 冷蔵庫, 洗濯機, 加湿器, テレビ, ディスプレイ");
		System.out.println("終了する場合は「終了」と入力してください");

		while (true) {
			System.out.println("\n購入する商品を「、」または「,」区切りで入力してください：");
			String inputLine = scanner.nextLine().trim();

			if (inputLine.equalsIgnoreCase("終了")) {
				System.out.println("システムを終了します");
				break;
			}

			String[] inputs = inputLine.split("、|,");
			for (String input : inputs) {
				String product = input.trim().replace("　", "");
				boolean found = false;

				int index = -1;
				boolean isTvOrDisplay = false;

				switch (product) {
				case "パソコン":
					index = 0;
					break;
				case "冷蔵庫":
					index = 1;
					break;
				case "洗濯機":
					index = 2;
					break;
				case "加湿器":
					index = 3;
					break;
				case "テレビ":
				case "ディスプレイ":
					isTvOrDisplay = true;
					break;
				}

				if (isTvOrDisplay) {
					found = true;
					if (tvStock > 0)
						tvStock--;
					String message = (tvStock == 0) ? "在庫なし"
							: (tvStock <= 3) ? "残り (" + tvStock + "台)"
									: tvStock + "台";
					System.out.println(product + "の残り台数は " + message + " です");
				} else if (index != -1) {
					found = true;
					if (stock[index] > 0)
						stock[index]--;
					int count = stock[index];
					String message = (count == 0) ? "在庫なし"
							: (count <= 3) ? "残り (" + count + "台)"
									: count + "台";
					System.out.println(product + "の残り台数は " + message + " です");
				}

				if (!found) {
					System.out.println("『" + product + "』は指定の商品ではありません");
				}
			}
		}

		scanner.close();
	}
}
