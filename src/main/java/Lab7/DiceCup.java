package Lab7;

import java.util.ArrayList;
import java.util.List;

public class DiceCup {
    private List<Dice> allDice;
    public DiceCup(int numberOfDice) {
        allDice = new ArrayList<>();
        for (int i = 0; i < numberOfDice; i++) {
            Dice dice = new Dice();
            allDice.add(dice);
        }
    }

    public int rollAll() {
        int total = 0;
        for (Dice dice: allDice) {
            int diceRoll = dice.roll();
            total += diceRoll;
        }
        return total;
    }
}
