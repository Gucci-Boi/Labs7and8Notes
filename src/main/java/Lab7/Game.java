package Lab7;

import java.util.ArrayList;
import java.util.List;

import static input.InputUtils.*;

public class Game {
    private DiceCup diceCup;
    private List<Player> players;

    public static void main(String[] args) {
        Game knockout = new Game();
        knockout.startGame();
    }

    public void startGame() {
        diceCup = new DiceCup(2);
        int numberOfPlayers = positiveIntInput("How many players");
        createPlayers(numberOfPlayers);
        setKnockoutNumbers();
        play();
        printResults();
    }

    private void createPlayers(int numberOfPlayers) {
        players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = stringInput("Enter player " + i + "'s name: ");
            Player player = new Player(name);
            players.add(player);
        }

    }

    private void setKnockoutNumbers() {
        for (Player p: players) {
            int knockoutNumber;
            do {
                knockoutNumber = intInput("Player " + p.getName() + ", enter your knockout " +
                        "number. " + "It must be 6, 7, 8, or 9.");
            } while (knockoutNumber < 6 || knockoutNumber > 9);
            p.setKnockoutNumber(knockoutNumber);
        }
    }

    private void play() {
        int playerIndex = 0;
        int totalPlayers = players.size();

        while (moreThanOnePlayer()) {
            Player currentPlayer = players.get(playerIndex);

            if (currentPlayer.isKnockedOut()) {
                System.out.println(currentPlayer.getName() + " you are knocked out.");
            } else {
                stringInput(currentPlayer.getName() + " press enter to roll.");
                String turnResult = currentPlayer.playTurn(diceCup);
                System.out.println(turnResult);
            }
            playerIndex = (playerIndex + 1) % totalPlayers;
        }
    }

    private boolean moreThanOnePlayer() {
        int totalInPlay = 0;
        for (Player p: players) {
            if (!p.isKnockedOut()) {
                totalInPlay++;
            }
        }
        System.out.println("There are " + totalInPlay + " players in the game.");
        if (totalInPlay > 1) {
            return true;
        } else {
            return false;
        }
    }
    private void printResults() {
        for (Player p:players) {
            if (p.isKnockedOut()) {
                System.out.println(p.getName() + " was knocked out.");
            } else {
                System.out.println("Player " + p.getName() + " wins.");
            }
        }
    }
}
