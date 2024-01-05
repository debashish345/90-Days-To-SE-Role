package LLD.snake_ladder.code;

public class Dice {
    private final Integer diceCount;

    public Dice(Integer diceCount) {
        this.diceCount = diceCount;
    }

    public Integer nextPoint() {
        return (int) (Math.random() * (6 * diceCount - 1 * diceCount)) + 1;
    }
}
