import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class GridReader {
    public HashMap<CoordinatePair, Gems> ReadGrid()
    {
        int columnNumber = 0;
        int rowNumber = 0;
        HashMap<CoordinatePair, Gems> abc = new HashMap<>();
        String gridFile = "src\\gameGrid.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(gridFile));
            String a = null;
            while ((a = br.readLine()) != null) {
                int len = a.length();
                for (int i = 0; i < len; i++) {
                    columnNumber = i / 2;
                    char lett = a.charAt(i);
                    Gems gemx = null;
                    if (lett != ' ') {
                        switch (lett) {
                            case 'D' -> gemx = new Diamond(columnNumber, rowNumber);
                            case 'S' -> gemx = new Square(columnNumber, rowNumber);
                            case 'T' -> gemx = new Triangle(columnNumber, rowNumber);
                            case 'W' -> gemx = new Wildcard(columnNumber, rowNumber);
                        }
                        abc.put(new CoordinatePair(gemx.getColumnNumber(), gemx.getRowNumber()), gemx);
                    }
                }
                rowNumber++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return abc;
    }
}