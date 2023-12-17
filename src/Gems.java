import java.util.HashMap;

public class Gems implements IGems {
    private int columnNumber;
    private int rowNumber;
    private char symbol;
    private int scorePoint;
    public static int CHECKSIZE = 2;

    public Gems(int score, char symb, int clmn, int row) {
        this.symbol = symb;
        this.columnNumber = clmn;
        this.rowNumber = row;
        this.scorePoint = score;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getScorePoint() {
        return scorePoint;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public boolean isBlank() {
        return false;
    }

    @Override
    public int CheckMatches(HashMap<CoordinatePair, Gems> hashmap) {
        return 0; // Implement your specific logic
    }
    public int[] CheckDirection(HashMap<CoordinatePair, Gems> hashmap, int xOffset, int yOffset, char targetSymbol) {
        int x = this.getColumnNumber();
        int y = this.getRowNumber();
        int n = (int) (Math.sqrt(hashmap.size()) - 1);
        int[] matchChecker = {0, this.getScorePoint()};//0 is checker 1 is adding points

        for (int i = 1; i <= CHECKSIZE; i++) {
            int newX = x + (i * xOffset);
            int newY = y + (i * yOffset);

            if (newX >= 0 && newX <= n && newY >= 0 && newY <= n) {
                Gems nextGem = hashmap.get(new CoordinatePair(newX, newY));
                if (nextGem.getSymbol() == this.getSymbol() || nextGem.getSymbol() == targetSymbol) {
                    matchChecker[0]++;
                    matchChecker[1] += (nextGem.getSymbol() == this.getSymbol()) ? this.getScorePoint() : 10;
                }
            }
        }
        if (matchChecker[0] == CHECKSIZE) {
            for (int i = 0; i <= CHECKSIZE; i++) {
                int newX = x + i * xOffset;
                int newY = y + i * yOffset;
                hashmap.put(new CoordinatePair(newX, newY), new BlankGem(newX, newY));
            }
            return matchChecker;
        } else {
            matchChecker[0] = 0;
            matchChecker[1] = this.getScorePoint();
        }
        return matchChecker;
    }
}