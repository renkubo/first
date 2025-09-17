package curriculum_B;

import java.util.Random;

public class Question2 {

	public static void main(String[] args) {
		Random rand = new Random();
		
		//Q1
		int score = 75;
		
		if(score >= 60) {
			System.out.println("合格です！");
		}
		
		//Q2
		int age = 0;
		
		age = 25;
		
		if (age >= 20  && age < 30 ) {
			System.out.println( "適正年齢です" );
		} 
		else {
			System.out.println( "対象外です" );
		}
		
		//Q3
		
		age = 18;
		
		if (age >= 20) {
			System.out.println( "成人です");
		} 
		else if (age >= 13 && age <= 19) {
			System.out.println( "ティーンエイジャーです");
		}
		else {
			System.out.println( "子供です");
		}
		
		//Q4 Math,max()や配列を使わずにif構文で最大値を判定
		int x = 0;
		int y = 0;
		int z = 0;
		int max = 0;
		
		x = 30;
		y = 15;
		z = 50;
		
		if (x >= y && x >= z) {
			max = x;
			System.out.println(max);
		}
		else if (y >= x && y >= z) {
			max = y;
			System.out.println(max);
		}
		else {
			max =z;
			System.out.println(max);
		}
		
		//Q5
		int num = rand.nextInt(3)-1;
		
		if (num > 0) {
			System.out.println( "正の数です" );
		}
		else if(num == 0) {
			System.out.println( "0です" );
		}
		else {
			System.out.println( "負の数です" );
		}
		
		//Q6
		int value = rand.nextInt(2)+1;
		
		if (value % 2 == 0) {
			System.out.println("偶数です");
		}
		else if (value % 2 != 0) {
			System.out.println("奇数です");
		}
		
		//Q7
		score = rand.nextInt(101);
		
		if (score >= 90) {
			System.out.println("優良");
		}
		else if (score >= 70) {
			System.out.println("良");
		}
		else if (score >= 50) {
			System.out.println("可");
		}
		else {
			System.out.println("不可");
		}
		
		//Q8
		String input = "";
		if (input == null || input == "") {
			System.out.println("入力が無効です");
		}
		
		//Q9
		int day = rand.nextInt(7)+1;
		
		switch(day) {
		case 1:
		    System.out.println("今日は月曜日です");
		    break;
		   case 2:
		    System.out.println("今日は火曜日です");
		    break;
		   case 3:
		    System.out.println("今日は水曜日です");
		    break;
		   case 4:
		    System.out.println("今日は木曜日です");
		    break;
		   case 5:
		    System.out.println("今日は金曜日です");
		    break;
		   case 6:
		    System.out.println("今日は土曜日です");
		    break;
		   case 7:
		    System.out.println("今日は日曜日です");
		    break;
		   default:
		    System.out.println("無効な値です");
		}
		
		//Q10
		int month = rand.nextInt(12)+1;
		
		switch(month) {
		case 12: case 1: case 2:
		   System.out.println("冬");
		   break;
		case 3: case 4: case 5:
		   System.out.println("春");
		   break;
		case 6: case 7: case 8:
		   System.out.println("夏");
		   break;
		case 9: case 10: case 11:
			   System.out.println("冬");
			   break;

		   default:
		   System.out.println("無効な月です");
		}
	}

}
