package console.app;

public class MatrixService {
    public char[][] createMatrix(String sequence) {
        int length = (int) Math.sqrt(sequence.length());
        char[][] sequenceArray = new char[length][length];
        System.out.println("Your matrix looks like: ");
        int index = 0;
        for (int i = 0; i < sequenceArray.length; i++) {
            for (int j = 0; j < sequenceArray[i].length; j++) {
                char symbol = sequence.charAt(index);
                sequenceArray[i][j] = symbol;
                System.out.print(symbol + " ");
                index++;
            }
            System.out.println();
        }
        return sequenceArray;
    }

    public String getCharsSequence() {
        String result = "This word does not exist in the matrix";
        StringBuilder builder = new StringBuilder();
        if (exist(createMatrix(ConsoleHandler.enterSequence()), builder)) {
            String[] tempArray = builder.toString().split(" ");
            builder = new StringBuilder();
            for (int i = tempArray.length - 1; i >= 0; i--) {
                builder.append(tempArray[i]).append("->");
            }
            result = builder.toString().substring(0, builder.length() - 2);
        }
        return result;
    }

    private boolean exist(char[][] board, StringBuilder builder) {
        String word = ConsoleHandler.enterWord();
        int width = board.length;
        int length = board[0].length;
        boolean result = false;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (checkIndex(builder, board, word, i, j,0)) {
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean checkIndex(
            StringBuilder builder, char[][] board, String word, int i, int j, int k) {
        int width = board.length;
        int length = board[0].length;
        if (i < 0 || j < 0 || i >= width || j >= length) {
            return false;
        }
        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            if (k == word.length() - 1) {
                    || checkIndex(builder, board, word, i - 1, j, k + 1)
                    || checkIndex(builder, board, word, i + 1, j, k + 1)
                    || checkIndex(builder, board, word, i, j - 1, k + 1)
                    || checkIndex(builder, board, word, i, j + 1, k + 1)) {
                builder.append("[").append(i).append(",").append(j).append("]").append(" ");
                return true;
            }
            board[i][j] = temp;
        }
        return false;
    }

    private void appendIndex(StringBuilder builder, int i, int j) {
        builder.append("[").append(i).append(",").append(j).append("]").append(" ");
    }
}
