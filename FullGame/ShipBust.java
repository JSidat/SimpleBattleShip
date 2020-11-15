package FullGame;
import java.util.*;

public class ShipBust {
    private gameHelper helper = new gameHelper();
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
            checkUserGuess(userGuess)

        }
        finishGame();
    }
    


    
}
