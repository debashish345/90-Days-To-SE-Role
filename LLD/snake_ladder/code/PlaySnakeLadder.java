package LLD.snake_ladder.code;

import java.util.LinkedList;
import java.util.Queue;

public class PlaySnakeLadder {

    public static void main(String[] args) {


        for (int i=0; i<100; i++) {

            Queue<String> players = new LinkedList<>();
            String player1 = "John";
            String player2 = "Doe";
            players.add(player1);
            players.add(player2);

            BoardGame boardGame = new BoardGame(100);
            boardGame.diceCount(1)
                    .initJump()
                    .jump(5, 10)
                    .jump(70, -55)
                    .initPlayer()
                    .player(player1)
                    .player(player2);


            while (players.size() > 1) {
                String playerName = players.poll();
                Integer move = boardGame.getDice().nextPoint();
                Integer currentPlayerPos = boardGame.getPlayer().getPlayerPosByName(playerName);
                Integer nextPos = move + currentPlayerPos;

                if (nextPos == 100) {
                    System.out.println("Winner " + playerName);
                    break;
                } else if (nextPos > 100) {
                    boardGame.getPlayer().removePlayer(playerName);
                    //System.out.println("Removing [Out-Of-Board]" + playerName);
                } else {
                    if (boardGame.getJump().getMoves().containsKey(nextPos)) {
                        Integer jump = boardGame.getJump().getMoves().get(nextPos);
                        boardGame.getPlayer().updatePosition(playerName, jump);
                    } else {
                        boardGame.getPlayer().updatePosition(playerName, nextPos);
                    }
                    players.add(playerName);
                    //System.out.println("Position of " + playerName + " " + boardGame.getPlayer().getPlayerPosByName(playerName));
                }
            }
        }
    }
}
