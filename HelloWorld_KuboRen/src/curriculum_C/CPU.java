package curriculum_C;

import java.util.Random;

public class CPU {
    private Random rand = new Random();

    public int chooseHand() {
        return rand.nextInt(3);
    }

    public String handName(int hand) {
        switch (hand) {
            case 0: return "グー";
            case 1: return "チョキ";
            case 2: return "パー";
            default: return "不明";
        }
    }
}