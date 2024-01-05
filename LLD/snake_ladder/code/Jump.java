package LLD.snake_ladder.code;

import java.util.HashMap;
import java.util.Map;

public class Jump {
    private Map<Integer, Integer> move = new HashMap<>();

    public Jump() {
        move = new HashMap<>();
    }

    public Map<Integer, Integer> add(Integer start, Integer end) {
        move.put(start, end);
        return move;
    }

    public Map<Integer, Integer> getMoves() {
        return this.move;
    }
}
