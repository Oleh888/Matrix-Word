package console.app;

public class Main {
    public static void main(String[] args) {
        MatrixService matrix = new MatrixService();
        System.out.println("result sequence of cells is " + matrix.getCharsSequence());
    }
}
