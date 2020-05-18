package console.app;

import java.util.Scanner;

public class Enter {
    private String sequence;
    private String word;

    public String getSequence() {
        return sequence;
    }

    public String getWord() {
        return word;
    }

    public void enterSequence() {
        System.out.println("Please, enter your sequence of "
                + "characters that have string of size N^2,"
                + " that describes square matrix of characters N*N");
        Scanner scanner = new Scanner(System.in);
        sequence = scanner.next().toUpperCase();
        if (sequence.length() % Math.sqrt(sequence.length()) != 0) {
            System.out.println("Entered sequence does not have size N^2, please repeat");
            enterSequence();
        }
    }

    public void enterWord() {
        System.out.println("Please, enter your word");
        Scanner scanner = new Scanner(System.in);
        word = scanner.next().toUpperCase();
    }
}
