import java.util.HashMap;

public class Diamond extends Gems {
    public Diamond(int clmn, int row) {
        super(30, 'D', clmn, row);
    }

    @Override
    public int CheckMatches(HashMap<CoordinatePair, Gems> hashmap) {
        int pointsToAdd = 0;
        int[] matchCheck;

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