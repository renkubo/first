package curriculum_B;

public class Question5 {

	public static void main(String[] args) {

		// Q1のメソッドの呼び出し
		helloWorld();

		// Q2のメソッドの実行
		int number = 10;
		int result = doubleValue(number);
		System.out.println(number + "を２倍すると" + result + "です");

		// Q3のメソッドを実行
		int num1 = 7;
		int num2 = 10;

		if (isEven(num2)) {
			System.out.println(num2 + "は偶数です");
		} else {
			System.out.println(num2 + "は奇数です");
		}

		if (isEven(num1)) {
			System.out.println(num1 + "は偶数です");
		} else {
			System.out.println(num1 + "は奇数です");
		}
	}

	// Q1
	public static void helloWorld() {
		System.out.println("Hello, World!");
	}

	// Q2
	public static int doubleValue(int num) {
		return num * 2;
	}

	// Q3
	public static boolean isEven(int num) {
		return num % 2 == 0;
	}

	// Q4
	public static class Greeting {
		public static void sayHello() {
			System.out.println("こんにちは！");
		}
	}
}