/** 
 * The DiceGame program rolls a dice then has the user try and guess what it landed on
 * tells the user if their guess was to high or low and tells the user how mnay guesses they took
 * @author  Liam Csiffary
 * @version 1.0
 * @since   2022-02-23
 */
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class DiceGame {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    System.out.println(
                "This program rolls a dice and you have to guess what the result of that roll was");
    int randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);
    int userGuess = 0;
    int counter = 0;
    while (true) {
      counter++;
      try {
        System.out.println("Guess a number between 1 and 6");
        String userGuessString = myObj.nextLine();
        userGuess = Integer.parseInt(userGuessString);
      } catch (NumberFormatException e) {
        counter--;
        userGuess = -1;
      }

      if (userGuess == -1) {
        System.out.println("You must input an integer");
      } else if (userGuess == randomNum) {
        break;
      } else if (userGuess > randomNum) {
        System.out.println("Your number was too big");
      } else if (userGuess < randomNum) {
        System.out.println("Your number was too small");
      } else {
        System.out.println("How did you end up here?");
      }
    }
    System.out.println("Congratulations! It took you " + counter + " guesses to guess the number");
  }
}
