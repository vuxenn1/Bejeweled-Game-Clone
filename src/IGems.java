import java.util.HashMap;

public interface IGems {
    int CheckMatches(HashMap<CoordinatePair, Gems> hashmap);
    int getColumnNumber();
    int getRowNumber();
    char getSymbol();
    int getScorePoint();
    void setColumnNumber(int columnNumber);
    void setRowNumber(int rowNumber);
}