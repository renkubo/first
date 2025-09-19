package curriculum_B;

public class Main {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        greeting.sayHello();

        System.out.println("-------------------");

        Animal lion = new Animal();
        lion.setName("ライオン");
        lion.setHeight(2.1);
        lion.setSpeed(80); // 数値型に対応

        System.out.println("動物名: " + lion.getName());
        System.out.println("体長: " + lion.getHeight() + "m");
        System.out.println("速度: " + lion.getSpeed() + "km/h");
    }
}