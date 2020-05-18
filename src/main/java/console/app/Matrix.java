package console.app;

public class Matrix {
    private char[][] sequenceArray;
    private StringBuilder builder;

    public void createMatrix(String sequence) {
        int length = (int) Math.sqrt(sequence.length());
        sequenceArray = new char[length][length];
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
    }

    public void getCharsSequence(String word) {
        builder = new StringBuilder();
        if (exist(sequenceArray, word)) {
            String[] tempArray = builder.toString().split(" ");
            builder = new StringBuilder();
            for (int i = tempArray.length - 1; i >= 0; i--) {
                builder.append(tempArray[i]).append("->");
            }
            String result = builder.toString().substring(0, builder.length() - 2);
            System.out.println("result sequence of cells is " + result);
        } else {
            System.out.println("This word does not exist in the matrix");
        }
    }

    private boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean result = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (checkIndex(board, word, i, j,0)) {
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean checkIndex(char[][] board, String word, int i, int j, int k) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }
        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            if (k == word.length() - 1) {
                builder.append("[").append(i).append(",").append(j).append("]").append(" ");
                return true;
            } else if (checkIndex(board, word, i - 1, j, k + 1)
                    || checkIndex(board, word, i + 1, j, k + 1)
                    || checkIndex(board, word, i, j - 1, k + 1)
                    || checkIndex(board, word, i, j + 1, k + 1)) {
                builder.append("[").append(i).append(",").append(j).append("]").append(" ");
                return true;
            }
            board[i][j] = temp;
        }
        return false;
    }
}
