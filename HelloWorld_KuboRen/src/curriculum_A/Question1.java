package curriculum_A;

public class Question1 {

	public static void main(String[] args) {
		
		//Q1の内容
		
		//8bit整数の変数を定義
		byte byteNum = 0;
		System.out.println("現在のbyteNumは" + (byteNum));
		
		//16bit整数の変数を定義
		short shortNum = 0;
		System.out.println("現在のshortNumは" + (shortNum));
		
		//少数ではない整数を定義
		int intNum = 0;
		System.out.println("現在のintNumは" + (intNum));
		
		//64bit整数の変数を定義
		long longNum = 0L;
		System.out.println("現在のlongNumは" + (longNum));
		
		//単精度浮動小数点数の変数を定義
		float floatNum = 0.0f;
		System.out.println("現在のfloatNumは" + (floatNum));
		
		//倍精度浮動小数点数の変数を定義
		double doubleNum = 0.0d;
		System.out.println("現在のdoubleNumは" + (doubleNum));
		
		//文字の変数を定義
		char letter = '\u0000';
		System.out.println("現在のletterは" + (letter));
		
		//文字列の変数を定義
		String letters = null;
		System.out.println("現在のlettersは" + (letters));
		
		//真偽値の変数を定義
		boolean isBoolean = false;
		System.out.println("現在のisBooleanは" + (isBoolean));
		
		//Q2の内容
		
		//上記の変数に代入
		byteNum = 10;
		System.out.println("現在のbyteNumは" + (byteNum));
		
		//上記の変数に代入
		shortNum = 100;
		System.out.println("現在のshortNumは" + (shortNum));
		
		//上記の変数に代入
		intNum = 1000;
		System.out.println("現在のintNumは" + (intNum));
		
		//上記の変数に代入
		longNum = 10000;
		System.out.println("現在のlongNumは" + (longNum));
		
		//上記の変数に代入
		floatNum = 9.5f;
		System.out.println("現在のfloatNumは" + (floatNum));
		
		//上記の変数に代入
		doubleNum = 10.5;
		System.out.println("現在のdoubleNumは" + (doubleNum));
		
		//上記の変数に代入
		letter = 'a';
		System.out.println("現在のletterは" + (letter));
		
		//上記の変数に代入
		letters = "ハロー";
		System.out.println("現在のlettersは" + (letters));
		
		//上記の変数に代入
		isBoolean = true;
		System.out.println("現在のisBooleanは" + (isBoolean));
		
		//以下Q3の内容
		
		//11110を出力
		System.out.println(longNum + intNum + shortNum + byteNum);
		
		//20を出力
		System.out.println(byteNum * 2);
		
		//a ハロー trueを出力
		System.out.println(letter + letters + isBoolean);
		
		//11130を出力
		System.out.println(byteNum + shortNum + intNum + longNum + floatNum + doubleNum);
		
		//10000000000を出力
		System.out.println(byteNum * shortNum * intNum * longNum);
		
		//0.105を出力
		System.out.println(doubleNum / 100);
		//-90を出力
		System.out.println(byteNum - 100);
		
		//Q4の内容
		String name = null;
		
		name = "山田太郎";
		
		System.out.println("こんにちは、" + name + "さん！ ");
		
		
		//Q5
		int age = 0;
		
		age = 25;
		
		System.out.println(" 年齢: " + age);
		
		
		//Q6
		int num1 = 0;
		
		num1 = 10;
		
		int num2 = 0;
		
		num2 = 5;
		
		int sum = num1 + num2;
		
		System.out.println(sum);
		
		//Q7
		
		int score = 0;
		
		score = 80;
		
		score = score + 20;
		
		System.out.println("最終スコア: " + score);
		
		
		//Q8
		double price = 0.0d;
		
		price = 99.99;
		
		int priceInt = (int)price;
		
		System.out.println(priceInt);
		
		//Q9
		//文字列numStrを宣言
		String numStr = "123";
		
		//以下で文字列を数字だけが入力された場合はint型に直し出力
		 try {
	            int num = Integer.parseInt(numStr);
	            System.out.println(num + 10);
	        } catch (NumberFormatException e) {
	            System.out.println("数値に変換できません: " + numStr);
	        }
		
		 //Q10
		 int num;
		 
		 num = 50;
		 
		 String str = String.valueOf(num); 
		 
		 System.out.println("得点:" + str + "点");
		 
		//Q11
		 int a =10;
		 int b =20;
		 
		 boolean result = a < b;
		 System.out.println(result);
		 
		 
		 //Q12
		 int x =0;
		 
		 x = 15;
		 
		 if (x >= 10) {
			System.out.println("OK");
		}
		 else {
			System.out.println("NG");
		}
		
		//Q13
		 String text = "私はJavaが好きです。Javaは楽しい！";
		 
		 text = "私はPythonが好きです。Pythonは楽しい！";
		 
		 System.out.println(text);
	}

}
