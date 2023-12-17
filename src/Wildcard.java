import java.util.HashMap;

public class Wildcard extends Gems {
    public Wildcard(int clmn, int row) {
        super(10, 'W', clmn, row);
    }
    public int CheckMatches(HashMap<CoordinatePair, Gems> hashmap)
    {
        int pointsToAdd = 0;
        int[] matchCheck;

        // Vertical Search First
        matchCheck = CheckDirection(hashmap, 0, -1, 'T');
        if(matchCheck[0] == CHECKSIZE)
            return matchCheck[1];

        matchCheck = CheckDirection(hashmap, 0, 1, 'T');
        if(matchCheck[0] == CHECKSIZE)
            return matchCheck[1];

        // Horizontal Search
        matchCheck = CheckDirection(hashmap, -1, 0, 'S');
        if(matchCheck[0] == CHECKSIZE)
            return matchCheck[1];

        matchCheck = CheckDirection(hashmap, 1, 0, 'S');
        if(matchCheck[0] == CHECKSIZE)
            return matchCheck[1];

        // Diagonal Search
        matchCheck = CheckDirection(hashmap, 1, 1, 'D');
        if(matchCheck[0] == CHECKSIZE)
            return matchCheck[1];

        matchCheck = CheckDirection(hashmap, -1, -1, 'D');
        if(matchCheck[0] == CHECKSIZE)
            return matchCheck[1];

        matchCheck = CheckDirection(hashmap, -1, 1, 'D');
        if(matchCheck[0] == CHECKSIZE)
            return matchCheck[1];

        matchCheck = CheckDirection(hashmap, 1, -1, 'D');
        if(matchCheck[0] == CHECKSIZE)
            return matchCheck[1];

        return pointsToAdd;
    }
}