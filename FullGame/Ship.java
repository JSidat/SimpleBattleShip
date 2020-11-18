package FullGame;
import java.util.*;

public class Ship {
    private ArrayList<String> locationCells; // array lsit of cell locations
    private String name; // name of the ship

    // setter method that updates the ship's location(random location provided by the gameHelper placeShip method)
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) {
        String result= "miss";
        int index = locationCells.indexOf(userInput); // if user guess is one of the entries in the arrayList, indexOf will return its arrayList location, if not it will return -1
        if (index >= 0) {
            locationCells.remove(index); // using arrayList's remove method to delete the entry

        if (locationCells.isEmpty()) { // use the empty method in arrayList to see if all of the locations have been guessed
            result = "kill";
            System.out.println("Ouch! You sunk " + name); // tell the user when the ship has been sunk
        } else {
            result = "hit";
        }
        }
        return result; // return "miss" or "hit" or "kill"
    }
}

