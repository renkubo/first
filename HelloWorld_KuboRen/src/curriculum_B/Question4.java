package curriculum_B;

import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {

		// Q1 
		int[] numbers = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}

		// Q2
		numbers = new int[] { 10, 20, 30, 40, 50 };
		for (int i = numbers.length - 1; i >= 0; i--) {
			System.out.println(numbers[i]);
		}

		// Q3 
		numbers = new int[] { 3, 5, 7, 9, 11 };
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		System.out.println("合計値: " + sum);

		// Q4
		numbers = new int[] { 12, 7, 9, 21, 5, 18 };
		int max = numbers[0];
		int min = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
			if (numbers[i] < min) {
				min = numbers[i];
			}
		}
		System.out.println("最大値: " + max);
		System.out.println("最小値: " + min);

		// Q5
		numbers = new int[] { 1, 2, 3, 4, 5 };
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = numbers[i] * 2;
		}
		for (int n : numbers) {
			System.out.println(n);
		}

		//Q6
		// 配列を用意
		numbers = new int[] { 4, 7, 10, 15, 20 };

		// ユーザーから数値を入力
		Scanner scanner = new Scanner(System.in);
		System.out.print("数値を入力してください: ");
		int input = scanner.nextInt();

		// 判定用フラグ
		boolean found = false;

		// 配列を走査して一致する値があるか確認
		for (int n : numbers) {
			if (n == input) {
				found = true;
				break;
			}
		}

		// 結果を表示
		if (found) {
			System.out.println(input + " は配列に含まれています。");
		} else {
			System.out.println(input + " は配列に含まれていません。");
		}

		scanner.close();

		//Q7 2次元配列を用意
		int[][] array = {
				{ 1, 2 },
				{ 3, 4 },
				{ 5, 6 }
		};

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();

			//Q8
			array = new int[][] {
					{ 10, 20, 30 },
					{ 40, 50, 60 },
					{ 70, 80, 90 }
			};

			sum = 0;

			for (i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					sum += array[i][j];
				}
			}

			System.out.println("配列の全要素の合計: " + sum);
		}

		//Q9 
		array = new int[][] {
				{ 12, 15, 8 },
				{ 6, 19, 25 },
				{ 30, 2, 10 }
		};

		max = array[0][0];
		min = array[0][0];

		// 2次元配列を走査
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] > max) {
					max = array[i][j];
				}
				if (array[i][j] < min) {
					min = array[i][j];
				}
			}
		}

		System.out.println("最大値: " + max);
		System.out.println("最小値: " + min);

		//Q10
		int[][][] arrays = {
				{ { 1, 2 }, { 3, 4 } },
				{ { 5, 6 }, { 7, 8 } }
		};

		for (int i = 0; i < arrays.length; i++) {
			System.out.println("array[" + i + "]:");
			for (int j = 0; j < arrays[i].length; j++) {
				for (int k = 0; k < arrays[i][j].length; k++) {
					System.out.println("array[" + i + "][" + j + "][" + k + "] = " + arrays[i][j][k]);
				}
			}
		}
	}
}
