package curriculum_D;

public class Character {
	protected String name;
	protected int hp;
	protected int at;
	protected int sp;

	public Character(String name, int hp, int at, int sp) {
		this.name = name;
		this.hp = hp;
		this.at = at;
		this.sp = sp;
	}

	public boolean isAlive() {
		return hp > 0;
	}

	public void attack(Character opponent) {
		opponent.hp -= this.at;
		if (opponent.hp < 0)
			opponent.hp = 0;
		System.out.println(this.name + "の攻撃！ " + opponent.name + "に" + this.at + "のダメージ！");
	}
}