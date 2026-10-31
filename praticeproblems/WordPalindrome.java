import java.util.Scanner;

public class WordPalindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = sc.nextLine();

        StringBuilder sb = new StringBuilder(word);

        String reverse = sb.reverse().toString();

        System.out.println("Reversed word: " + reverse);

        if (word.equals(reverse)) {
            System.out.println(word + " - palindrome");
        } else {
            System.out.println(word + " - not a palindrome");
        }

        sc.close();
    }
}
