package FullGame;
import java.util.*;

public class ShipBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<Ship> shipList = new ArrayList<Ship>();
    private int numOfGuesses = 0;

    private void setUpGame () {
        // first make some ships and give them locations
        Ship one = new Ship();
        one.setName("Ship One");
        Ship two = new Ship();
        two.setName("Ship Two");
        Ship three = new Ship();
        three.setName("Ship Three");
        shipList.add(one);
        shipList.add(two);
        shipList.add(three);

        System.out.println("Your goal is to sink three ships");
        System.out.println("Ship One, Ship Two and Ship Three");
        System.out.println("try to sink them all in the lowest number of guesses");
        
        for(Ship ShipToSet : shipList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            ShipToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while(!shipList.isEmpty()) {
            String userGuess = helper.getUserInput("Enter guess here");
            checkUserGuess(userGuess);

        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";

        for(Ship shipToTest : shipList) {
            result = shipToTest.checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            System.out.println(result);

        }

        private void finishGame() {
            System.out.println("All ships are sunk! The ocean is now empty");
            if (numOfGuesses <= 18) {
                System.out.println("It only took you " + numOfGuesses + " guesses.");
            } else {
                System.out.println("Took you long enough. " + numOfGuesses + " guesses.");                
            }
        }

        public static void main (String[] args) {

            ShipBust game = new ShipBust();
            game.setUpGame();
            game.startPlaying();

        }

    }



    
}
