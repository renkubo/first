package curriculum_B;

// --- Animal.java ---
public class Animal {
	private String name;
	private double height;
	private double speed; // 数値型に変更

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getHeight() {
		return this.height;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getSpeed() {
		return this.speed;
	}
}