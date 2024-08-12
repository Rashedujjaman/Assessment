import java.util.Scanner;
public class Test {
    public static String userInput(){
        System.out.print("Enter a string : ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        return input;
    }

    public static int wordCount(String input){
        if(input == null || input.isEmpty()){
            return 0;
        }
        String[] words = input.split("\\s+");
        return words.length;          
    }

    public static int characterCount(String input){
        if(input == null || input.isEmpty()){
            return 0;
        }
        String margedInput = input.replaceAll("\\s+", "");
        return margedInput.length();
    }

    public static StringBuilder reversedString(String input){
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse();
    }

    public static boolean palindrom(String input){
        StringBuilder sb = new StringBuilder(input);
        if(sb.toString().equals(sb.reverse().toString())){
            return true;
        }
        return false;
    }

    public static void triangle(String input){
        for (int i=0; i<input.length(); i++){
            System.out.println(" ".repeat((input.length()-i)-1) + "*".repeat(2*i+1));

        }
        
    }



    public static void main(String[] args){
        String input = userInput();
        System.out.println("You entered : " + input);
        System.out.println("Number of words it contain : " + wordCount(input));
        System.out.println("Number of characters it contain : " + characterCount(input));
        System.out.println("Reversed string : " + reversedString(input));
        System.out.println("Is it a palindrom : " + palindrom(input));
        System.out.println("Triangle made of number of characters in the string : ");
        triangle(input);


    }
}
