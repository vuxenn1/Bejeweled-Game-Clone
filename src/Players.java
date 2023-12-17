public class Players
{
    private final String playerName;
    private int totalScore;
    private int rank;

    public Players(String name,int score)
    {
        this.playerName = name;
        this.totalScore = score;
        this.rank = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}