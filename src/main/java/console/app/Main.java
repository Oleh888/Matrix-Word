package console.app;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        String sequence = consoleHandler.enterSequence();
        String word = consoleHandler. enterWord();
        MatrixService matrix = new MatrixService();
        System.out.println("result sequence of cells is "
                + matrix.getCharsSequence(sequence, word));
        System.out.println("tratatam");
        int a = 4;
    }
}
