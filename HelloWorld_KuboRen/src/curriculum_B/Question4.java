package curriculum_B;

import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {

		// Q1
		int[] numbers = { 1, 2, 3, 4, 5 };
		for (int index = 0; index < numbers.length; index++) {
			System.out.println(numbers[index]);
		}

		// Q2
		numbers = new int[] { 10, 20, 30, 40, 50 };
		for (int index = numbers.length - 1; index >= 0; index--) {
			System.out.println(numbers[index]);
		}

		// Q3
		numbers = new int[] { 3, 5, 7, 9, 11 };
		int sum = 0;
		for (int index = 0; index < numbers.length; index++) {
			sum += numbers[index];
		}
		System.out.println("合計値: " + sum);

		// Q4
		numbers = new int[] { 12, 7, 9, 21, 5, 18 };
		int max = numbers[0];
		int min = numbers[0];
		for (int index = 1; index < numbers.length; index++) {
			if (numbers[index] > max) {
				max = numbers[index];
			}
			if (numbers[index] < min) {
				min = numbers[index];
			}
		}
		System.out.println("最大値: " + max);
		System.out.println("最小値: " + min);

		// Q5
		numbers = new int[] { 1, 2, 3, 4, 5 };
		for (int index = 0; index < numbers.length; index++) {
			numbers[index] = numbers[index] * 2;
		}
		for (int n : numbers) {
			System.out.println(n);
		}

		// Q6
		numbers = new int[] { 4, 7, 10, 15, 20 };

		Scanner scanner = new Scanner(System.in);
		System.out.print("数値を入力してください: ");
		int input = scanner.nextInt();

		boolean found = false;
		for (int n : numbers) {
			if (n == input) {
				found = true;
				break;
			}
		}

		if (found) {
			System.out.println(input + " は配列に含まれています。");
		} else {
			System.out.println(input + " は配列に含まれていません。");
		}

		// Q7
		int[][] array = {
				{ 1, 2 },
				{ 3, 4 },
				{ 5, 6 }
		};

		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				System.out.print(array[row][col] + " ");
			}
			System.out.println();
		}

		// Q8
		array = new int[][] {
				{ 10, 20, 30 },
				{ 40, 50, 60 },
				{ 70, 80, 90 }
		};

		sum = 0;
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				sum += array[row][col];
			}
		}
		System.out.println("配列の全要素の合計: " + sum);

		// Q9
		array = new int[][] {
				{ 12, 15, 8 },
				{ 6, 19, 25 },
				{ 30, 2, 10 }
		};

		max = array[0][0];
		min = array[0][0];

		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				if (array[row][col] > max) {
					max = array[row][col];
				}
				if (array[row][col] < min) {
					min = array[row][col];
				}
			}
		}

		System.out.println("最大値: " + max);
		System.out.println("最小値: " + min);

		// Q10
		int[][][] arrays = {
				{ { 1, 2 }, { 3, 4 } },
				{ { 5, 6 }, { 7, 8 } }
		};

		for (int x = 0; x < arrays.length; x++) {
			System.out.println("array[" + x + "]:");
			for (int y = 0; y < arrays[x].length; y++) {
				for (int z = 0; z < arrays[x][y].length; z++) {
					System.out.println("array[" + x + "][" + y + "][" + z + "] = " + arrays[x][y][z]);
				}
			}
		}

		scanner.close();
	}
}
