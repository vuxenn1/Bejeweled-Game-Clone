import java.util.HashMap;

public class Square extends Gems {
    public Square(int clmn, int row) {
        super(15, 'S', clmn, row);
    }

    @Override
    public int CheckMatches(HashMap<CoordinatePair, Gems> hashmap) {
        int pointsToAdd = 0;
        int[] matchCheck;

        // Horizontal Search
        matchCheck = CheckDirection(hashmap, -1, 0, 'W');
        if(matchCheck[0] == CHECKSIZE)
            return matchCheck[1];

        matchCheck = CheckDirection(hashmap, 1, 0, 'W');
        if(matchCheck[0] == CHECKSIZE)
            return matchCheck[1];

        return pointsToAdd;
    }
}