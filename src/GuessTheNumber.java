import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {

        Scanner getInput = new Scanner(System.in);
        Scanner playInput = new Scanner(System.in);
        char playing = 'y';
        boolean guessedCorrectly = false;
        int guess = 0;

        System.out.println("Hello! What is your name?");
        String name = getInput.nextLine();

        while (playing == 'y') {
            int correctNumber = (int)(Math.random() * 20 + 1);
            int guessCount = 0;

            System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20. Take a guess.");

            while (guessedCorrectly == false ) {
                // Used if number was guessed incorrectly & they are still playing
                if (guessCount >= 6) {
                    System.out.println("Sorry you have used up all your guesses, would you like to play again? ( y, n )");
                    playing = playInput.next().charAt(0);
                    if(playing == 'y') {
                        guessCount = 0;
                        guessedCorrectly = false;
                        break;
                    } else {
                        System.out.println("Thanks for playing");
                        return;
                    }
                }
                try {
                    guess = getInput.nextInt();
                    if (guess > 20 || guess < 1) {
                        System.out.println("Please input a valid number 1 - 20");
                    } else {
                        guessCount++;
                        if (guess > correctNumber) {
                            System.out.println("Your guess is too high, try again");
                            System.out.println("Testing, Correct Number is " + correctNumber);
                        } else if (guess < correctNumber) {
                            System.out.println("Your guess is too low, try again");
                            System.out.println("Testing, Correct Number is " + correctNumber);
                        } else {
                            guessedCorrectly = true;
                            System.out.println("Your guess is correct, good job!, it took you " + guessCount + " tries.");
                            System.out.println("Would you like to play again? ( y, n )");
                            playing = playInput.next().charAt(0);
                            if(playing == 'y') {
                                guessCount = 0;
                                guessedCorrectly = false;
                                break;
                            } else {
                                System.out.println("Thanks for playing");
                            }
                    }
                 }
                } catch (Exception e) {
                    System.out.println("Please input a number 1 - 20");
                    getInput.next();
                }
            }
        }
    }
}
