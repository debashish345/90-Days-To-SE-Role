package LLD.snake_ladder.code;

public class BoardGame {

    private Integer boardSize;
    private Dice dice;
    private Jump jump;
    private Player player;

    private BoardGame(){}

    public BoardGame(Integer size) {
        this.boardSize = size;
    }

    public BoardGame diceCount(int count) {
        this.dice = new Dice(count);
        return this;
    }
    public BoardGame initJump(){
        this.jump = new Jump();
        return this;
    }
    public BoardGame jump(int start, int end) {
        this.jump.add(start, end);
        return this;
    }

    public BoardGame initPlayer(){
        this.player = new Player();
        return this;
    }

    public BoardGame player(String name) {
        this.player.add(name);
        return this;
    }

    public Dice getDice() {
        return dice;
    }

    public Jump getJump() {
        return jump;
    }

    public Player getPlayer() {
        return player;
    }
}
