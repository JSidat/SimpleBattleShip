package FullGame;
import java.util.*;

// Declare and initialise the variables needed 
public class ShipBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<Ship> shipList = new ArrayList<Ship>();
    private int numOfGuesses = 0;

    private void setUpGame () {
        // Make three ship objects, give them names and add them to the arraylist called shipList
        Ship one = new Ship();
        one.setName("Ship One");
        Ship two = new Ship();
        two.setName("Ship Two");
        Ship three = new Ship();
        three.setName("Ship Three");
        shipList.add(one);
        shipList.add(two);
        shipList.add(three);

        // Print out brief instructions for the user 
        System.out.println("Your goal is to sink three ships");
        System.out.println("Ship One, Ship Two and Ship Three");
        System.out.println("try to sink them all in the lowest number of guesses");
        
        // use a for loop to repeat the setLocation method for each ship in the list
        for(Ship ShipToSet : shipList) {
            // ask the helper for the location of the ship
            ArrayList<String> newLocation = helper.placeShip(3);
            // Use the setter method on this ship to give it the location that we got from the helper 
            ShipToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while(!shipList.isEmpty()) { // as long as the shipList is not empty
            String userGuess = helper.getUserInput("Enter guess here"); // get user input
            checkUserGuess(userGuess); // call the checkUserGuess method to check theuser input
        }
        finishGame(); // call the finishGame method when the shipList is empty
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++; // increment the number of guesses the user has made
        String result = "miss"; // assume it is a miss unless told otherwise

        for(Ship shipToTest : shipList) { // repeat for each ship in the shipList
            result = shipToTest.checkYourself(userGuess); // check the user guess, looking for a hit or kill
            if (result.equals("hit")) { 
                break; // get out of the loop early, no point in checking the other guesses
            }
            if (result.equals("kill")) {
                shipList.remove(shipToTest);
                break; // ship's sunk, so remove it from the list and leave the loop
            }
            System.out.println(result); // print the result for the user
        }
    }

        // print out a message telling the player how he did in the game
        private void finishGame() {
            System.out.println("All ships are sunk! The ocean is now empty");
            if (numOfGuesses <= 18) {
                System.out.println("It only took you " + numOfGuesses + " guesses.");
            } else {
                System.out.println("Took you long enough. " + numOfGuesses + " guesses.");                
            }
        }

        public static void main (String[] args) {

            ShipBust game = new ShipBust(); // tell the game object to create a new game
            game.setUpGame(); // tell the game object to set up the game
            game.startPlaying(); // tellthe game object to start the main game play loop (keep asking for and checking user guesses)

        }

    }



    

