import java.util.Random;
import java.util.Scanner;

public class Hangman2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words;
        if (args.length > 0) {
            words = args;
        } else {
            words = new String[]{"elephant", "cow", "horse", "carriage", "mouse", "executioner", "caravan", "octopus"};
        }
        Random random = new Random();
        //creates a random object to pick a random word from the string array to guess


        System.out.println("Hey There, Take Part In This Hangman Game");



        char playAgain = 'y'; //a variable which stores the user's choice to play the game again

        // a while loop to keep the game running
        while (playAgain == 'y') {

            String word = words[random.nextInt(words.length)]; // Choose a random word
            char[] guessedWord = new char[word.length()];
            for (int i = 0; i < guessedWord.length; i++) {
                guessedWord[i] = '*';
            }
            
            int misses = 0;
            while (true) {
                System.out.print("Guess a letter in the word ");
                System.out.println(guessedWord);
                char guess = scanner.next().toLowerCase().charAt(0);

                if (!processGuess(word, guessedWord, guess)) {
                    misses++;
                    System.out.println("No such letter exists in the word");
                }

                if (isWordGuessed(guessedWord)) {
                    System.out.println("The word is " + word + ". You missed " + misses + " time(s).");
                    break;
                }
            }

            System.out.println("Do you want to guess another word? (y/n)");
            playAgain = scanner.next().toLowerCase().charAt(0); 
        }

        System.out.println("Thank You for Having Fun!");
        scanner.close();
    }


    //this method checks if the guessed letter exists in the word 
    public static boolean isWordGuessed(char[] guessedWord) {
        for (char c : guessedWord) {
            if (c == '*') {
                return false;
            }
        }
        return true;
    }

    // this method checks if the chosen word is correctly guessed
    public static boolean processGuess(String word, char[] guessedWord, char guess) {
        boolean hasGuess = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                guessedWord[i] = guess;
                hasGuess = true;
            }
        }
        return hasGuess;
    }

    
}