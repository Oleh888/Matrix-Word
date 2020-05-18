package console.app;

public class Main {
    String[] testOne = {"amclatdhe", "mate"};
    String[] testTwo = {"QLGNAEKIRLRNGEAE", "KING"};

    public static void main(String[] args) {
        Enter enter = new Enter();
        enter.enterSequence();
        Matrix matrix = new Matrix();
        matrix.createMatrix(enter.getSequence());
        enter.enterWord();
        matrix.getCharsSequence(enter.getWord());
    }
}
