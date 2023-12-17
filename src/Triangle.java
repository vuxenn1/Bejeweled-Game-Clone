import java.util.HashMap;

public class Triangle extends Gems {
    public Triangle(int clmn, int row) {
        super(15, 'T', clmn, row);
    }

    @Override
    public int CheckMatches(HashMap<CoordinatePair, Gems> hashmap) {
        int pointsToAdd = 0;
        int[] matchCheck;

        // Vertical Search
        matchCheck = CheckDirection(hashmap, 0, -1, 'W');
        if(matchCheck[0] == CHECKSIZE)
            return matchCheck[1];

        matchCheck = CheckDirection(hashmap, 0, 1, 'W');
        if(matchCheck[0] == CHECKSIZE)
            return matchCheck[1];

        return pointsToAdd;
    }
}