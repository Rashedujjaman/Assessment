import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterCategorization {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert Text: (press return to mark end of input)");
        String inputString = scan.nextLine();
        scan.close();
        analyzeAndDisplayString(inputString);
    }
    private static void analyzeAndDisplayString(String inputString) {
        // 1. Group characters into categories and count occurrences
        Map<Character, Integer> vowelCounts = new HashMap<>();
        Map<Character, Integer> consonantCounts = new HashMap<>();
        Map<Character, Integer> otherCharCounts = new LinkedHashMap<>();

        for (char c : inputString.toCharArray()) {
            char upperC = Character.toUpperCase(c); // Convert all character to uppercase
            if (Character.isLetter(upperC)) {
                if (isVowel(upperC)) {
                    incrementCount(vowelCounts, upperC);
                } else {
                    incrementCount(consonantCounts, upperC);
                }
            } else {
                incrementCount(otherCharCounts, upperC); // All non-letters counted here
            }
        }

        // 2. Display counts of each category (in uppercase)
        System.out.print("\nVowels: ");
        printMap(vowelCounts);
        System.out.print("\nConsonants: ");
        printMap(consonantCounts);

        // Display other characters, including blanks and special chars
        System.out.print("\nOther characters: [blank space]");
        printMap(otherCharCounts);

        // 3. Display the longest word in the string (no change needed here)
        String longestWord = findLongestWord(inputString);
        System.out.println("\nLongest word in the string: " + longestWord);
    }

    // Method to check if a character is a vowel
    private static boolean isVowel(char c) {
        char uppercase = Character.toUpperCase(c);
        return uppercase == 'A' || uppercase == 'E' || uppercase == 'I' || uppercase == 'O' || uppercase == 'U';
    }

    // Method to increment character count in a map
    private static void incrementCount(Map<Character, Integer> map, char c) {
        int count = map.getOrDefault(c, 0);
        map.put(c, count + 1);
    }

    // Method to print a map of character counts
    private static void printMap(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "(" + entry.getValue() + ") ");
        }
    }

    // Method to find the longest word in a string
    private static String findLongestWord(String inputString) {
        String[] words = inputString.split("\\s+"); // Split by whitespace
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }
}
