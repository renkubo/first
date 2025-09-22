package curriculum_D;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Question7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();

		// プレイヤーの名前入力
		System.out.print("プレイヤーの名前を入力してください: ");
		String playerName = scanner.nextLine();

		// プレイヤーのステータス（ランダム）
		int hp = rand.nextInt(51) + 50; // 50~100
		int at = rand.nextInt(11) + 10; // 10~20
		int sp = rand.nextInt(6) + 5; // 5~10
		Character player = new Character(playerName, hp, at, sp);

		// Daemonのステータスをファイルから読み込み
		Character daemon = loadDaemon("src/curriculum_D/daemon.txt");

		System.out.println("=== ステータス ===");
		System.out.println(player.name + " [HP:" + player.hp + " AT:" + player.at + " SP:" + player.sp + "]");
		System.out.println(daemon.name + " [HP:" + daemon.hp + " AT:" + daemon.at + " SP:" + daemon.sp + "]");

		// 先攻決定
		Character attacker, defender;
		if (player.sp > daemon.sp) {
			attacker = player;
			defender = daemon;
		} else if (player.sp < daemon.sp) {
			attacker = daemon;
			defender = player;
		} else {
			if (rand.nextBoolean()) {
				attacker = player;
				defender = daemon;
			} else {
				attacker = daemon;
				defender = player;
			}
		}
		System.out.println("先攻は " + attacker.name + "！");

		// ログ出力準備
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/curriculum_D/battle_log.txt"))) {
			// バトル開始
			while (player.isAlive() && daemon.isAlive()) {
				attacker.attack(defender);
				writer.write(attacker.name + "の攻撃 → " + defender.name + "のHP: " + defender.hp);
				writer.newLine();

				// 戦闘終了判定
				if (!defender.isAlive())
					break;

				// 攻守交代
				Character temp = attacker;
				attacker = defender;
				defender = temp;
			}

			// 勝敗結果
			String result = player.isAlive() ? player.name + "の勝利！" : daemon.name + "の勝利！";
			System.out.println(result);
			writer.write("=== バトル結果 ===");
			writer.newLine();
			writer.write(result);
			writer.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Daemonのステータスをファイルから読み込む
	public static Character loadDaemon(String filepath) {
		int hp = 0, at = 0, sp = 0;
		try {
			List<String> lines = Files.readAllLines(Paths.get(filepath));
			for (String line : lines) {
				String[] parts = line.split("=");
				switch (parts[0].trim()) {
				case "HP":
					hp = Integer.parseInt(parts[1].trim());
					break;
				case "AT":
					at = Integer.parseInt(parts[1].trim());
					break;
				case "SP":
					sp = Integer.parseInt(parts[1].trim());
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("Daemonデータの読み込みに失敗しました");
		}
		return new Character("Daemon", hp, at, sp);
	}
}