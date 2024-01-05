package LLD.snake_ladder.code;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private Map<String, Integer> players;
    private final Integer INITIAL_POS = 0;

    public Player(){
        this.players = new HashMap<>();
    }

    public void add(String name) {
        players.put(name, INITIAL_POS);
    }

    public Integer updatePosition(String name, Integer pos) {
        if (!players.containsKey(name)) {
            throw new RuntimeException("Invalid player name!");
        }
        players.put(name, players.get(name) + pos);
        return players.get(name);
    }

    public void removePlayer(String name) {
        this.players.remove(name);
    }

    private Integer playerCount(){
        return this.players.size();
    }

    public Integer getPlayerPosByName(String name) {
        return players.get(name);
    }
}
