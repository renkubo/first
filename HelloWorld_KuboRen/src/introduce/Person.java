package introduce;

public class Person {
    // フィールド
    public String name;
    public int age;
    public double height;
    public double weight;

    // 人数カウント用
    public static int count = 0;

    // コンストラクタ
    public Person(String name, int age, double height, double weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        Person.count++;
    }

    // BMIを計算して返す（小数点第1位で切り捨て）
    public double bmi() {
        if (height <= 0) return 0.0;
        double value = weight / (height * height);
        return Math.floor(value);  // 小数点以下を全部切り捨て
    }

    // 自己紹介を出力
    public void print() {
        System.out.println("名前は" + this.name + "です");
        System.out.println("年は" + this.age + "です");
        System.out.println("BMIは" + this.bmi() + "です");
        System.out.println("合計" + Person.count + "人です");
    }
}