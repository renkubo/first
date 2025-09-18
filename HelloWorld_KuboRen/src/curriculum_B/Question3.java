package curriculum_B;

import java.util.Random;
import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		//Q1 for 文を使って 1 から 10 までの数字を 1 つずつ表示

		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}

		//Q2 for 文を使って 2 から 20 までの 偶数 を 1 つずつ表示

		for (int i = 2; i <= 20; i += 2) {
			System.out.println(i);
		}

		//Q3 for 文を使って 10 から 1 まで カウントダウンして表示

		for (int i = 10; i >= 1; i--) {
			System.out.println(i);
		}

		//Q4 for 文を使って 1 から 100 までの合計 を表示

		int sum = 0;

		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);

		//Q5 for 文を使って 以下のような三角形を出力

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		//Q6 while 文を使って 1 から 10 まで を 1 つずつ表示

		int i = 1;

		while (i <= 10) {
			System.out.println(i);
			i++;
		}

		//Q7 while 文を使って 2 から 20 までの偶数 を 1 つずつ表示

		i = 2;

		while (i <= 20) {
			System.out.println(i);
			i += 2;
		}

		//Q8 while 文を使って 10 から 1 まで のカウントダウンを表示

		i = 10;

		while (i >= 1) {
			System.out.println(i);
			i--;
		}

		//Q9 while 文を使って 1 から 100 までの合計 を表示

		i = 1;

		sum = 0;

		while (i <= 100) {
			sum += i;
			i++;
		}

		System.out.println(sum);

		//Q10 
		while (true) {
			int input = scanner.nextInt();
			scanner.nextLine();

			if (input == 0) {
				System.out.println("終了しました");
				break;
			}
		}
		//scanner.close();

		//Q11 for文を使用して下記の通りに出力してください

		for (i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%02d * %02d = %02d || ", j, i, i * j);
			}
			System.out.println();
		}

		//Q12 

		// 商品リスト（表示用）
		String[] products = { "パソコン", "冷蔵庫", "洗濯機", "加湿器", "テレビ", "ディスプレイ" };

		// 在庫配列（テレビ・ディスプレイは共通なので4つだけ用意）
		int[] stock = new int[4];
		for (i = 0; i < stock.length; i++) {
			stock[i] = random.nextInt(12); // 0〜11
		}

		// テレビとディスプレイ共通の在庫
		int k = random.nextInt(12); // 0〜11

		System.out.println("ご希望の商品を入力してください。");
		System.out.println("パソコン, 冷蔵庫, 洗濯機, 加湿器, テレビ, ディスプレイ");
		System.out.println("終了する場合は「終了」と入力してください");

		while (true) {
			System.out.println("\n購入する商品を「、」または「,」区切りで入力してください：");
			String inputLine = scanner.nextLine().trim();

			// 終了の判定
			if (inputLine.equalsIgnoreCase("終了")) {
				System.out.println("システムを終了します");
				break;
			}

			// 入力を分割する
			String[] inputs = inputLine.split("、|,");
			for (String input : inputs) {
				String product = input.trim().replace("　", ""); // 前後空白・全角スペース除去
				boolean found = false;

				int index = -1; // 在庫配列のインデックス
				boolean isTvOrDisplay = false;

				// 商品判定
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

				// テレビ・ディスプレイ
				if (isTvOrDisplay) {
					found = true;
					if (k > 0)
						k--; // 在庫を減らす

					String message = (k == 0) ? "在庫なし"
							: (k <= 3) ? "残り (" + k + "台)"
									: k + "台";
					System.out.println(product + "の残り台数は" + message + "です");
				}
				// その他の商品
				else if (index != -1) {
					found = true;
					if (stock[index] > 0)
						stock[index]--;

					int count = stock[index];
					String message = (count == 0) ? "在庫なし"
							: (count <= 3) ? "残り (" + count + "台)"
									: count + "台";
					System.out.println(product + "の残り台数は" + message + "です");
				}

				// 指定外商品
				switch (found ? 1 : 0) {
				case 0:
					System.out.println("『" + product + "』は指定の商品ではありません");
					break;
				}
			}
		}
	}
}
